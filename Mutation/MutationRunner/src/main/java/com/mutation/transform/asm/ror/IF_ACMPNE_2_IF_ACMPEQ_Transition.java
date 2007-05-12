package com.mutation.transform.asm.ror;

import org.objectweb.asm.Opcodes;


public class IF_ACMPNE_2_IF_ACMPEQ_Transition extends ROR_Transition {

	public IF_ACMPNE_2_IF_ACMPEQ_Transition() {
		super();
		this.sourceInstruction = Opcodes.IF_ACMPNE;
		this.targetInstruction = Opcodes.IF_ACMPEQ;
	}

}