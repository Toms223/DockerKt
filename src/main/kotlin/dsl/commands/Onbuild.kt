package dsl.commands

import dsl.commands.base.Command

class Onbuild: Command("ONBUILD"){
    private lateinit var command: Command

    fun CMD(init: Cmd.() -> Unit) {
        command = Cmd()
        (command as Cmd).init()
    }

    fun ADD(init: Add.() -> Unit) {
        command = Add()
        (command as Add).init()
    }

    fun COPY(init: Copy.() -> Unit) {
        command = Copy()
        (command as Copy).init()
    }

    fun ENTRYPOINT(init: Entrypoint.() -> Unit) {
        command = Entrypoint()
        (command as Entrypoint).init()
    }

    fun ENV(init: Env.() -> Unit) {
        command = Env()
        (command as Env).init()
    }

    fun EXPOSE(init: Expose.() -> Unit) {
        command = Expose()
        (command as Expose).init()
    }

    fun HEALTHCHECK(init: Healthcheck.() -> Unit) {
        command = Healthcheck()
        (command as Healthcheck).init()
    }

    fun LABEL(init: Label.() -> Unit) {
        command = Label()
        (command as Label).init()
    }

    fun RUN(init: Run.() -> Unit) {
        command = Run()
        (command as Run).init()
    }



    override fun toString(): String {
        assert(!command.toString().contains(Regex("--from=\\S+"))) { "ONBUILD COPY command cannot have --from option" }
        return super.toString() + command.toString()
    }
}