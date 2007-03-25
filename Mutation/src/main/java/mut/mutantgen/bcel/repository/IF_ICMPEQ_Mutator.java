package mut.mutantgen.bcel.repository;

import mut.EMutationOperator;

import org.apache.bcel.generic.IF_ICMPEQ;
import org.apache.bcel.generic.IF_ICMPNE;
import org.apache.bcel.generic.InstructionHandle;

public class IF_ICMPEQ_Mutator implements IMutator {

	public void performMutation(InstructionHandle handle) {
		if (!(handle.getInstruction() instanceof IF_ICMPEQ)) {
			return;
		}
		IF_ICMPEQ instruction = (IF_ICMPEQ) handle.getInstruction();
		handle.setInstruction(new IF_ICMPNE(instruction.getTarget()));

	}

	public EMutationOperator getMutationOperator() {
		return EMutationOperator.IF_ICMPEQ;
	}

}
