package com.mutation.report.generator.chart;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.mutation.report.generator.reportobjects.ClassInfo;
import com.mutation.report.generator.reportobjects.ClassInfoCreator;
import com.mutation.report.loader.ReportModelLoader;
import com.mutation.report.om.MutationRun;

public class MutationCoverateClassBarChartGreator {

	public void createChart(List<ClassInfo> infos, File pngFile) {

		int numClasses = 10;
		double[] limits = new double[numClasses];
		double step = 1.0 / numClasses;
		for (int i = 0; i < limits.length - 1; i++) {
			limits[i] = step * (double) (i + 1);
		}
		limits[numClasses - 1] = Double.MAX_VALUE;
		// double[] limits = { 0.01, 0.25, 0.5, 0.75, 0.9, 1.0, Double.MAX_VALUE
		// };
		MCoverageClassCreator creator = new MCoverageClassCreator(limits);
		final List<DataClass> classes = creator.classifyMCoverage(infos);
		CategoryDataset dataSet = createDataset("Mutation Coverage Class Distribution", classes);

		JFreeChart chart = createBarChart(dataSet);

		final NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryToolTipGenerator tooltipGenerator = new CategoryToolTipGenerator() {

			public String generateToolTip(CategoryDataset data, int series, int category) {
				List<ClassInfo> instances = classes.get(category).getInstances();
				String iStr = "";
				for (ClassInfo i : instances) {
					iStr += " " + i.getFqClassName() + ":" + nf.format(i.getMCoverageRatio());
				}
				return iStr;
			}

		};
		plot.getRenderer().setToolTipGenerator(tooltipGenerator);

		chartToFile(chart, pngFile);
	}

	public static void main(String[] args) throws FileNotFoundException, JAXBException {

		File reportFile = new File(args[0]);
		MutationRun run = new ReportModelLoader().loadReportModel(reportFile);
		ClassInfoCreator infoCreator = new ClassInfoCreator(run.getClassUnderTest());
		MutationCoverateClassBarChartGreator chartCreator = new MutationCoverateClassBarChartGreator();

		File pngFile = new File(reportFile.getPath() + "_MutCoverageChart.png");

		chartCreator.createChart(infoCreator.createClassInfos(), pngFile);

	}

	public void chartToFile(JFreeChart chart, File pngFile) {
		// save it to an image
		try {

			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

			File file1 = pngFile;
			ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

			// write an HTML page incorporating the image with an image map
			File file2 = new File(file1.getPath() + "barchart100.html");
			OutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
			PrintWriter writer = new PrintWriter(out);
			writer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
			writer.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
			writer.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
			writer.println("<head><title>JFreeChart Image Map Demo</title></head>");
			writer.println("<body><p>");
			ImageMapUtilities.writeImageMap(writer, "chart", info);
			writer.println("<img src=\"" + file1.toURL() + "\" "
					+ "width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"barchart100.png\"/>");
			writer.println("</p></body>");
			writer.println("</html>");
			writer.close();

		} catch (Exception e) {
			System.out.println("Schade");
		}
	}

	public JFreeChart createBarChart(CategoryDataset dataSet) {

		// create the chart...
		JFreeChart chart = ChartFactory.createBarChart("Mutation Test Coverage Distribution", // chart
				// title
				null, // domain axis label
				"Number of Instances", // range axis label
				dataSet, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips?
				false // URLs?
				);
		chart.setBackgroundPaint(java.awt.Color.white);

		return chart;

	}

	private CategoryDataset createDataset(String title, List<DataClass> classes) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (DataClass dataClass : classes) {
			dataset.addValue(dataClass.getNumInstances(), title, dataClass.getName());
		}
		return dataset;
	}

	/**
	 * Returns a sample dataset.
	 * 
	 * @return The dataset.
	 */
	private CategoryDataset createDataset() {
		// row keys...
		String series1 = "MutationCoverageRatio";
		// column keys...
		String category1 = "<  25%";
		String category2 = "< 50%";
		String category3 = "< 75%";
		String category4 = ">= 75%";
		// create the dataset...
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1, series1, category1);
		dataset.addValue(4, series1, category2);
		dataset.addValue(3, series1, category3);
		dataset.addValue(5, series1, category4);
		return dataset;
	}

	/**
	 * Returns a sample dataset.
	 * 
	 * @return The dataset.
	 */
	private CategoryDataset _createDataset() {
		// row keys...
		String series1 = "First";
		String series2 = "Second";
		String series3 = "Third";
		// column keys...
		String category1 = "Category 1";
		String category2 = "Category 2";
		String category3 = "Category 3";
		String category4 = "Category 4";
		String category5 = "Category 5";
		// create the dataset...
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, series1, category1);
		dataset.addValue(4.0, series1, category2);
		dataset.addValue(3.0, series1, category3);
		dataset.addValue(5.0, series1, category4);
		dataset.addValue(5.0, series1, category5);
		dataset.addValue(5.0, series2, category1);
		dataset.addValue(7.0, series2, category2);
		dataset.addValue(6.0, series2, category3);
		dataset.addValue(8.0, series2, category4);
		dataset.addValue(4.0, series2, category5);
		dataset.addValue(4.0, series3, category1);
		dataset.addValue(3.0, series3, category2);
		dataset.addValue(2.0, series3, category3);
		dataset.addValue(3.0, series3, category4);
		dataset.addValue(6.0, series3, category5);
		return dataset;
	}
}
