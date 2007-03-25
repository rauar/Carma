package mut.driver;

import java.util.List;
import java.util.Set;

import mut.MutationOperator;
import mut.MutationTestSpec;

/**
 * creates a set of mutation tests
 * @author mike
 *
 */
public interface IMutationTestsCreator {
	/**
	 * create mutation tests
	 * @param operators the operators to be considered
	 * @return test set
	 */
	List<MutationTestSpec> createTests(Set<MutationOperator> operators);
}
