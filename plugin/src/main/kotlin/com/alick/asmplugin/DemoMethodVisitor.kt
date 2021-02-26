package com.alick.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * @createTime 2021/2/26 14:13
 * @author 崔兴旺
 * @description
 */
open class DemoMethodVisitor(methodVisitor: MethodVisitor?) :
    MethodVisitor(Opcodes.ASM5, methodVisitor) {

    override fun visitCode() {
        super.visitCode()

        mv.visitLdcInsn("TAG")
        mv.visitLdcInsn("===== 这是通过ASM输出的日志3 =====")
        mv.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "android/util/Log",
            "e",
            "(Ljava/lang/String;Ljava/lang/String;)I",
            false
        )
        mv.visitInsn(Opcodes.POP)

    }


}