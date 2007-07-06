package com.retroduction.carma.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.retroduction.carma.core.api.testrunners.om.Mutant;
import com.retroduction.carma.core.api.transitions.IMutationGenerator;
import com.retroduction.carma.core.api.transitions.ITransition;
import com.retroduction.carma.core.api.transitions.ITransitionGroup;
import com.retroduction.carma.utilities.Logger;
import com.retroduction.carma.utilities.LoggerFactory;

public class MutantGenerator implements IMutationGenerator {

	private Logger logger = LoggerFactory.getLogger(MutantGenerator.class);

	public List<Mutant> generateMutants(String classUnderTest, byte[] originalClassByteCode,
			Set<ITransitionGroup> transitionGroups) {

		List<Mutant> result = new ArrayList<Mutant>();

		for (ITransitionGroup group : transitionGroups) {

			logger.debug("Processing transition group: "+ group.getName());
			
			for (ITransition transition : group.getTransitions()) {

				List<Mutant> mutants = transition.applyTransitions(originalClassByteCode);

				for (Mutant mutant : mutants) {
					mutant.setClassName(classUnderTest);
					mutant.setTransitionGroup(group);
				}

				result.addAll(mutants);
			}

		}

		return result;
	}
}
