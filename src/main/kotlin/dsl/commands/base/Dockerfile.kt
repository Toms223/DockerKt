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

    fun ENV(init: Env.() -> Unit) {
        val env = Env()
        env.init()
        children.add(env)
    }

    fun EXPOSE(init: Expose.() -> Unit) {
        val expose = Expose()
        expose.init()
        children.add(expose)
    }

    fun FROM(init: From.() -> Unit) {
        val from = From()
        from.init()
        children.add(from)
    }

    fun ADD(init: Add.() -> Unit) {
        val add = Add()
        add.init()
        children.add(add)
    }

    fun HEALTHCHECK(init: Healthcheck.() -> Unit) {
        val healthcheck = Healthcheck()
        healthcheck.init()
        children.add(healthcheck)
    }

    fun LABEL(init: Label.() -> Unit) {
        val label = Label()
        label.init()
        children.add(label)
    }

    fun MAINTAINER(init: Maintainer.() -> Unit) {
        val maintainer = Maintainer()
        maintainer.init()
        children.add(maintainer)
    }

    fun ONBUILD(init: Onbuild.() -> Unit) {
        val onbuild = Onbuild()
        onbuild.init()
        children.add(onbuild)
    }

    fun SHELL(init: Shell.() -> Unit) {
        val shell = Shell()
        shell.init()
        children.add(shell)
    }

    fun STOPSIGNAL(init: Stopsignal.() -> Unit) {
        val stopsignal = Stopsignal()
        stopsignal.init()
        children.add(stopsignal)
    }

    fun USER(init: User.() -> Unit) {
        val user = User()
        user.init()
        children.add(user)
    }

    fun VOLUME(init: Volume.() -> Unit) {
        val volume = Volume()
        volume.init()
        children.add(volume)
    }

    fun WORKDIR(init: Workdir.() -> Unit) {
        val workdir = Workdir()
        workdir.init()
        children.add(workdir)
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