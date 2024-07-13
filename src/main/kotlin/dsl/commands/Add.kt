package dsl.commands

import dsl.commands.base.Command
import dsl.commands.base.Option

class Add: Command("ADD"){
    fun keepGitDir(): Option{
        val option = Option("keep-git-dir")
        option{
            +"true"
        }
        return option
    }

    fun checksum(init: Option.() -> Unit): Option {
        val option = Option("checksum")
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

    fun link(): Option {
        return Option("link")
    }

    fun exclude(init: Option.() -> Unit): Option {
        val option = Option("exclude")
        option.init()
        return option
    }


}