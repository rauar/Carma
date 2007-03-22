package mut;

import java.util.List;
import java.util.Set;

/**
 * Specification of a mutation test
 * @author mike
 *
 */
public class MutationTestSpec {
	/**
	 * names of test classes
	 */
	private List<String> testSet;
	
	/**
	 * class to be tested
	 */
	private String classUnderTest;
	
	/**
	 * mutation operators to be applied
	 */
	private Set<MutationOperator> operators;

	public String getClassUnderTest() {
		return classUnderTest;
	}

	public void setClassUnderTest(String classUnderTest) {
		this.classUnderTest = classUnderTest;
	}

	public Set<MutationOperator> getOperators() {
		return operators;
	}

	public void setOperators(Set<MutationOperator> operators) {
		this.operators = operators;
	}

	public List<String> getTestSet() {
		return testSet;
	}

	public void setTestSet(List<String> testSet) {
		this.testSet = testSet;
	}
}
