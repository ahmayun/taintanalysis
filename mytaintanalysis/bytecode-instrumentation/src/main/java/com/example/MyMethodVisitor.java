package com.example;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class MyMethodVisitor extends AdviceAdapter {
    public MyMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv, access, name, descriptor);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        mv.visitInsn(Opcodes.NOP);
    }
}