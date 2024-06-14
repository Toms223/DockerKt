package dsl.commands

import dsl.commands.base.Command
import dsl.commands.base.Option

class Copy: Command("COPY"){
    val link = Option("link")

    fun from(init: Option.() -> Unit): Option {
        val option = Option("from")
        option.init()
        return option
    }

    fun chown(init: Option.() -> Unit): Option {
        val option = Option("chown")
        option.init()
        return option
    }

    fun chmod(init: Option.() -> Unit): Option {
        val option = Option("chmod")
        option.init()
        return option
    }

    fun parents(init: Option.() -> Unit): Option {
        val option = Option("parents")
        option.init()
        return option
    }

    fun exclude(init: Option.() -> Unit): Option {
        val option = Option("exclude")
        option.init()
        return option
    }
}