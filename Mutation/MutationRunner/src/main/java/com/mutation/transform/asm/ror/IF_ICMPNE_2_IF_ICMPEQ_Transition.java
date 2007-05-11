package com.mutation.transform.asm.ror;

import org.objectweb.asm.Opcodes;


public class IF_ICMPNE_2_IF_ICMPEQ_Transition extends ROR_Transition {

	public IF_ICMPNE_2_IF_ICMPEQ_Transition() {
		super();
		this.sourceInstruction = Opcodes.IF_ICMPEQ;
		this.targetInstruction = Opcodes.IF_ICMPNE;
	}

}