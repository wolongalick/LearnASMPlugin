package com.alick.asmplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * @createTime 2021/2/26 14:05
 * @author 崔兴旺
 * @description
 */
class DemoClassVisitor(classVisitor: ClassVisitor?) : ClassVisitor(Opcodes.ASM5, classVisitor) {

    private var className: String? = null

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name
    }


    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val visitMethod = super.visitMethod(access, name, descriptor, signature, exceptions)

        if (className.equals("com/alick/asmdemo/MainActivity")) {
            if (name.equals("onCreate")) {
                return DemoMethodVisitor(visitMethod)
            }
        }

        return visitMethod
    }

}