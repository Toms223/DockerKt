package dsl.commands.base

import dsl.commands.*

class Dockerfile {
    private val children = mutableListOf<Command>()

    fun RUN(init: Run.() -> Unit) {
        val run = Run()
        run.init()
        children.add(run)
    }

    fun ARG(init: Arg.() -> Unit) {
        val arg = Arg()
        arg.init()
        children.add(arg)
    }

    fun CMD(init: Cmd.() -> Unit) {
        val cmd = Cmd()
        cmd.init()
        children.add(cmd)
    }

    fun COPY(init: Copy.() -> Unit) {
        val copy = Copy()
        copy.init()
        children.add(copy)
    }

    fun ENTRYPOINT(init: Entrypoint.() -> Unit) {
        val entrypoint = Entrypoint()
        entrypoint.init()
        children.add(entrypoint)
    }

    override fun toString(): String {
        return children.joinToString("\n")
    }
}

fun Dockerfile(init: Dockerfile.() -> Unit): Dockerfile {
    val dockerfile = Dockerfile()
    dockerfile.init()
    return dockerfile
}