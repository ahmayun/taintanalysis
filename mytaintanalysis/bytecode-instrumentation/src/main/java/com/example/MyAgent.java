//package com.example;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.Instrumentation;
//import java.security.ProtectionDomain;
//import org.objectweb.asm.*;
//import org.objectweb.asm.tree.*;
//
//public class MyAgent {
//    public static void premain(String agentArgs, Instrumentation inst) {
//        inst.addTransformer(new ClassFileTransformer() {
//            public byte[] transform(
//                    ClassLoader loader,
//                    String className,
//                    Class<?> classBeingRedefined,
//                    ProtectionDomain protectionDomain,
//                    byte[] classfileBuffer
//            ) {
//                ClassReader cr = new ClassReader(classfileBuffer);
//                ClassNode cn = new ClassNode();
//                cr.accept(cn, 0);
//
//                for (MethodNode mn : cn.methods) {
//                    InsnList instructions = mn.instructions;
//                    AbstractInsnNode currentNode = instructions.getFirst();
//                    while (currentNode != null) {
//                        AbstractInsnNode nextNode = currentNode.getNext();
//                        instructions.insert(currentNode, new InsnNode(Opcodes.NOP));
//                        currentNode = nextNode;
//                    }
//                }
//
//                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
//                cn.accept(cw);
//                return cw.toByteArray();
//            }
//        });
//    }
//}