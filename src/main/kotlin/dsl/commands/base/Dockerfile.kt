package dsl.commands.base

import dsl.commands.Arg
import dsl.commands.Cmd
import dsl.commands.Copy
import dsl.commands.Run

class Dockerfile {
    private val children = mutableListOf<Command>()

    fun run(init: Run.() -> Unit) {
        val run = Run()
        run.init()
        children.add(run)
    }

    fun arg(init: Arg.() -> Unit) {
        val arg = Arg()
        arg.init()
        children.add(arg)
    }

    fun cmd(init: Command.() -> Unit) {
        val cmd = Cmd()
        cmd.init()
        children.add(cmd)
    }

    fun copy(init: Command.() -> Unit) {
        val copy = Copy()
        copy.init()
        children.add(copy)
    }

    override fun toString(): String {
        return children.joinToString("\n")
    }
}

fun dockerfile(init: Dockerfile.() -> Unit): Dockerfile {
    val dockerfile = Dockerfile()
    dockerfile.init()
    return dockerfile
}