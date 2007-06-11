package com.mutation.driver.maven;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.retroduction.carma.application.Carma;
import com.retroduction.carma.core.runner.events.listener.CompositeEventListener;
import com.retroduction.carma.core.runner.events.listener.SummaryCreatorEventListener;
import com.retroduction.carma.core.runner.events.listener.SummaryCreatorEventListener.Summary;
import com.retroduction.carma.core.transform.TransitionGroupConfig;

public class MavenTestExecuter {
	private List<URL> dependencyClassPathUrls;

	private File classesDir;

	private File testClassesDir;

	private File logFile = new File("test.log");

	private File reportFile = new File("report.xml");

	private String testNamePattern = "Test";

	public Summary exeuteTests() throws MojoExecutionException {

		reportFile.getParentFile().mkdirs();

		ClassPathResource springConfigResource = new ClassPathResource("mutationConfig.xml");
		XmlBeanFactory factory = new XmlBeanFactory(springConfigResource);

		factory.registerSingleton("classesDir", new File(classesDir.getAbsolutePath()));
		factory.registerSingleton("testClassesDir", new File(testClassesDir.getAbsolutePath()));
		factory.registerSingleton("libraries", getDependencyClassPathUrls());
		factory.registerSingleton("usedResolver", factory.getBean("classMatchResolver"));
		factory.registerSingleton("report.filename", reportFile.getAbsolutePath());
		factory.registerSingleton("testCaseSuffix", testNamePattern);
		factory.registerSingleton("log.filename", logFile.getAbsolutePath());

		SummaryCreatorEventListener summaryCreator = new SummaryCreatorEventListener();
		factory.registerSingleton("summaryCreator", summaryCreator);
		
		((CompositeEventListener) factory.getBean("eventListener")).getListeners().add(summaryCreator);

		TransitionGroupConfig tgGroup = (TransitionGroupConfig) factory.getBean("operators");
		Carma driver = (Carma) factory.getBean("testDriver");
		driver.execute(tgGroup);

		Summary sum = summaryCreator.createSummary();
		factory.destroySingletons();
		return sum;
	}

	public List<URL> getDependencyClassPathUrls() {
		return dependencyClassPathUrls;
	}

	public void setDependencyClassPathUrls(List<URL> dependencyClassPathUrls) {
		this.dependencyClassPathUrls = dependencyClassPathUrls;
	}

	public void setClassesDir(File classesDir) {
		this.classesDir = classesDir;
	}

	public void setTestClassesDir(File testClassesDir) {
		this.testClassesDir = testClassesDir;
	}

	public void setLogFile(File logFile) {
		this.logFile = logFile;
	}

	public void setReportFile(File reportFile) {
		this.reportFile = reportFile;
	}

	public void setTestNamePattern(String testNamePattern) {
		this.testNamePattern = testNamePattern;
	}
}
