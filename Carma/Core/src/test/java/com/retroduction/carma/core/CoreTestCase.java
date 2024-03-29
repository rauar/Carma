/**
  *  This file is part of Carma (Retroduction.org).
  *
  *  Carma is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  Carma is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *  along with Carma.  If not, see <http://www.gnu.org/licenses/>.
  *
  * Copyright Retroduction.org (c) 2007-2010
  */

package com.retroduction.carma.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import com.retroduction.carma.core.api.eventlisteners.IEvent;
import com.retroduction.carma.core.api.eventlisteners.IEventListener;
import com.retroduction.carma.core.api.eventlisteners.om.ClassesUnderTestResolved;
import com.retroduction.carma.core.api.eventlisteners.om.MutantsGenerated;
import com.retroduction.carma.core.api.eventlisteners.om.MutationProcessFinished;
import com.retroduction.carma.core.api.eventlisteners.om.MutationProcessStarted;
import com.retroduction.carma.core.api.eventlisteners.om.ProcessingClassUnderTest;
import com.retroduction.carma.core.api.eventlisteners.om.ProcessingClassUnderTestFinished;
import com.retroduction.carma.core.api.eventlisteners.om.ProcessingMutant;
import com.retroduction.carma.core.api.eventlisteners.om.ProcessingMutationOperator;
import com.retroduction.carma.core.api.eventlisteners.om.TestSetNotSane;
import com.retroduction.carma.core.api.eventlisteners.om.TestsExecuted;
import com.retroduction.carma.core.api.resolvers.IResolver;
import com.retroduction.carma.core.api.testrunners.ITestRunner;
import com.retroduction.carma.core.api.testrunners.om.Mutant;
import com.retroduction.carma.core.api.testrunners.om.SourceCodeMapping;
import com.retroduction.carma.core.api.transitions.IMutationGenerator;
import com.retroduction.carma.core.api.transitions.ITransition;
import com.retroduction.carma.core.api.transitions.ITransitionGroup;
import com.retroduction.carma.core.api.transitions.om.TransitionGroupConfig;
import com.retroduction.carma.core.om.PersistentClassInfo;
import com.retroduction.carma.core.om.TestedClassInfo;
import com.retroduction.carma.utilities.IByteCodeFileReader;

public class CoreTestCase extends TestCase {

	private class MockTransition implements ITransition {

		public List<Mutant> applyTransitions(byte[] byteCode) {
			List<Mutant> result = new ArrayList<Mutant>();
			Mutant mutant = new Mutant();
			result.add(mutant);
			return result;
		}

		public String getName() {
			return "MockTransition";
		}

	}

	private class MockTransitionGroup implements ITransitionGroup {

		public String getName() {
			return "MockTransitionGroup";
		}

		public ITransition[] getTransitions() {
			return new ITransition[] { new MockTransition() };
		}

		public void initWithDefaultTransitions() {
		}

		public void setTransitions(ITransition[] transitions) {
		}

	}

	private class MockEventListener implements IEventListener {

		private ArrayList<IEvent> events = new ArrayList<IEvent>();

		public void destroy() {
		}

		public void notifyEvent(IEvent event) {
			this.events.add(event);
		}

		public ArrayList<IEvent> getEvents() {
			return this.events;
		}

	}

	private class MockMutantGenerator implements IMutationGenerator {

		public List<Mutant> generateMutants(String classUnderTest, byte[] originalClassByteCode,
				ITransitionGroup transitionGroup) {
			List<Mutant> result = new ArrayList<Mutant>();
			Mutant pseudoMutant = new Mutant();
			pseudoMutant.setName("PseudoMutant");
			pseudoMutant.setClassName("com.retroduction.carma.test.PseudoMutant");
			pseudoMutant.setTransition(new MockTransition());
			pseudoMutant.setSourceMapping(new SourceCodeMapping());
			result.add(pseudoMutant);
			return result;
		}

	}

	private class MockResolver implements IResolver {

		public Set<TestedClassInfo> resolve() {
			Set<TestedClassInfo> result = new HashSet<TestedClassInfo>();

			PersistentClassInfo classInfo = new PersistentClassInfo("com.retroduction.carma.ClassUnderTest");

			TestedClassInfo desc = new TestedClassInfo(classInfo);
			desc.getAssociatedTestNames().add(new PersistentClassInfo("com.retroduction.carma.SomeTestCase"));

			result.add(desc);

			return result;
		}

		public Set<TestedClassInfo> removeSuperfluousClassNames(Set<TestedClassInfo> classesUnderTest) {
			return classesUnderTest;
		}

		public Set<TestedClassInfo> removeSuperfluousTestClasses(Set<TestedClassInfo> remainingClassDescriptions) {
			return remainingClassDescriptions;
		}

	}

	private class MockTestRunner implements ITestRunner {

		private boolean shouldFailOnValidation;

		public MockTestRunner(boolean shoudFailOnValidation) {
			super();
			this.shouldFailOnValidation = shoudFailOnValidation;
		}

		public void execute(Mutant mutant, Set<String> testNames) {
		}

		public Set<String> execute(Set<String> testNames) {

			if (this.shouldFailOnValidation) {
				Set<String> result = new HashSet<String>();
				result.add("com.retroduction.carma.FailedTestCase");
				return result;
			} else {
				return new HashSet<String>();
			}

		}

	}

	private class MockByteCodeFileReader implements IByteCodeFileReader {

		private boolean fail;

		public MockByteCodeFileReader(boolean fail) {
			super();
			this.fail = fail;
		}

		public byte[] readByteCodeFromDisk(File originalClassFile) throws FileNotFoundException, IOException {
			if (this.fail) {
				throw new IOException("Mock doomed to fail");
			} else {
				return new byte[] { 1, 2, 3, 4, 5 };
			}
		}

		public byte[] readByteCodeFromMultipleFolders(String classUnderTestName, File[] paths) throws IOException {
			if (this.fail) {
				throw new IOException("Mock doomed to fail");
			} else {
				return new byte[] { 1, 2, 3, 4, 5 };
			}
		}

		public byte[] readByteCodeFromStream(InputStream originalClassFileInputStream) throws FileNotFoundException,
				IOException {
			if (this.fail) {
				throw new IOException("Mock doomed to fail");
			} else {
				return new byte[] { 1, 2, 3, 4, 5 };
			}
		}

	}

	public void test_TestSetSane() {

		MockEventListener eventListener = new MockEventListener();
		MockMutantGenerator mutantGenerator = new MockMutantGenerator();
		MockResolver mockResolver = new MockResolver();
		MockTestRunner testRunner = new MockTestRunner(false);
		MockTransitionGroup transitionGroup = new MockTransitionGroup();
		MockByteCodeFileReader byteCodeReader = new MockByteCodeFileReader(false);

		TransitionGroupConfig tgConfig = new TransitionGroupConfig();
		Set<ITransitionGroup> setOfTransitionGroups = new HashSet<ITransitionGroup>();
		setOfTransitionGroups.add(transitionGroup);
		tgConfig.setTransitionGroups(setOfTransitionGroups);

		Core core = new Core();

		core.setEventListener(eventListener);
		core.setMutantGenerator(mutantGenerator);
		core.setResolver(mockResolver);
		core.setTestRunner(testRunner);
		core.setTransitionGroupConfig(tgConfig);
		core.setByteCodeFileReader(byteCodeReader);

		core.execute();

		Iterator<IEvent> eventIterator = eventListener.getEvents().iterator();

		IEvent event;

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessStarted);
		assertEquals(1, ((MutationProcessStarted) event).getTransitionGroups().size());
		assertTrue(((MutationProcessStarted) event).getTransitionGroups().contains(transitionGroup));

		event = eventIterator.next();
		assertTrue(event instanceof ClassesUnderTestResolved);
		// TODO: check event content

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTest);
		assertEquals("com.retroduction.carma.ClassUnderTest", ((ProcessingClassUnderTest) event).getClassUnderTest()
				.getFullyQualifiedClassName());
		assertEquals(1, ((ProcessingClassUnderTest) event).getClassUnderTest().getAssociatedTestNames().size());
		assertTrue(((ProcessingClassUnderTest) event).getClassUnderTest().getAssociatedTestNames().contains(
				new PersistentClassInfo("com.retroduction.carma.SomeTestCase")));

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingMutationOperator);
		assertEquals("MockTransitionGroup", ((ProcessingMutationOperator) event).getTransitionGroupName());

		event = eventIterator.next();
		assertTrue(event instanceof MutantsGenerated);
		assertEquals(1, ((MutantsGenerated) event).getGeneratedMutants().size());
		assertEquals("com.retroduction.carma.ClassUnderTest", ((MutantsGenerated) event).getGeneratedMutants().get(0)
				.getSourceMapping().getClassName());

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingMutant);
		assertEquals("PseudoMutant", ((ProcessingMutant) event).getMutant().getName());
		assertEquals("MockTransitionGroup", ((ProcessingMutant) event).getMutant().getTransitionGroup().getName());

		event = eventIterator.next();
		assertTrue(event instanceof TestsExecuted);

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTestFinished);

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessFinished);

		assertTrue(!eventIterator.hasNext());

	}

	public void test_TestSetBroken() {

		MockEventListener eventListener = new MockEventListener();
		MockMutantGenerator mutantGenerator = new MockMutantGenerator();
		MockResolver mockResolver = new MockResolver();
		MockTestRunner testRunner = new MockTestRunner(true);
		MockTransitionGroup transitionGroup = new MockTransitionGroup();
		MockByteCodeFileReader byteCodeReader = new MockByteCodeFileReader(false);

		TransitionGroupConfig tgConfig = new TransitionGroupConfig();
		Set<ITransitionGroup> setOfTransitionGroups = new HashSet<ITransitionGroup>();
		setOfTransitionGroups.add(transitionGroup);
		tgConfig.setTransitionGroups(setOfTransitionGroups);

		Core core = new Core();

		core.setEventListener(eventListener);
		core.setMutantGenerator(mutantGenerator);
		core.setResolver(mockResolver);
		core.setTestRunner(testRunner);
		core.setTransitionGroupConfig(tgConfig);
		core.setByteCodeFileReader(byteCodeReader);

		core.execute();

		Iterator<IEvent> eventIterator = eventListener.getEvents().iterator();

		IEvent event;

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessStarted);

		event = eventIterator.next();
		assertTrue(event instanceof ClassesUnderTestResolved);
		// TODO: check event content

		event = eventIterator.next();
		assertTrue(event instanceof TestSetNotSane);
		// TODO: check event content

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTest);

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingMutationOperator);

		event = eventIterator.next();
		assertTrue(event instanceof MutantsGenerated);

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingMutant);

		event = eventIterator.next();
		assertTrue(event instanceof TestsExecuted);

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTestFinished);

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessFinished);

		assertTrue(!eventIterator.hasNext());

	}

	public void test_TestSetSane_ClassByteCodeCannotBeRead() {

		MockEventListener eventListener = new MockEventListener();
		MockMutantGenerator mutantGenerator = new MockMutantGenerator();
		MockResolver mockResolver = new MockResolver();
		MockTestRunner testRunner = new MockTestRunner(false);
		MockTransitionGroup transitionGroup = new MockTransitionGroup();
		MockByteCodeFileReader byteCodeReader = new MockByteCodeFileReader(true);

		TransitionGroupConfig tgConfig = new TransitionGroupConfig();
		Set<ITransitionGroup> setOfTransitionGroups = new HashSet<ITransitionGroup>();
		setOfTransitionGroups.add(transitionGroup);
		tgConfig.setTransitionGroups(setOfTransitionGroups);

		Core core = new Core();

		core.setEventListener(eventListener);
		core.setMutantGenerator(mutantGenerator);
		core.setResolver(mockResolver);
		core.setTestRunner(testRunner);
		core.setTransitionGroupConfig(tgConfig);
		core.setByteCodeFileReader(byteCodeReader);

		core.execute();

		Iterator<IEvent> eventIterator = eventListener.getEvents().iterator();

		IEvent event;

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessStarted);

		event = eventIterator.next();
		assertTrue(event instanceof ClassesUnderTestResolved);
		// TODO: check event content

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTest);

		event = eventIterator.next();
		assertTrue(event instanceof ProcessingClassUnderTestFinished);

		event = eventIterator.next();
		assertTrue(event instanceof MutationProcessFinished);

		assertTrue(!eventIterator.hasNext());
	}
}
