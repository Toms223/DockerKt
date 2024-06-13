package dsl.commands

class Run: Command("RUN", "&&"){
    fun mount(init: Option.() -> Unit): Option {
        val option = Option("mount")
        option.init()
        return option
    }

    fun network(init: Option.() -> Unit): Option {
        val option = Option("network")
        option.init()
        return option
    }

    val bind = "type=bind"
    val cache = "type=cache"
    val tmpfs = "type=tmpfs"
    val secret = "type=secret"
    val ssh = "type=ssh"

    val none = "none"
    val host  = "host"

    fun ro(init: Option.() -> Unit): Option {
        val option = Option("ro")
        option.init()
        return option
    }

    fun id(init: Option.() -> Unit): Option {
        val option = Option("id")
        option.init()
        return option
    }

    fun sharing(init: Option.() -> Unit): Option {
        val option = Option("sharing")
        option.init()
        return option
    }

    fun mode(init: Option.() -> Unit): Option {
        val option = Option("mode")
        option.init()
        return option
    }

    fun uid(init: Option.() -> Unit): Option {
        val option = Option("uid")
        option.init()
        return option
    }

    fun gid(init: Option.() -> Unit): Option {
        val option = Option("gid")
        option.init()
        return option
    }

    fun size(init: Option.() -> Unit): Option {
        val option = Option("size")
        option.init()
        return option
    }

    fun target(init: Option.() -> Unit): Option {
        val option = Option("target")
        option.init()
        return option
    }

    fun required(init: Option.() -> Unit): Option {
        val option = Option("required")
        option.init()
        return option
    }

    fun security(init: Option.() -> Unit): Option {
        val option = Option("security")
        option.init()
        return option
    }

    fun source(init: Option.() -> Unit): Option {
        val option = Option("source")
        option.init()
        return option
    }

    fun from(init: Option.() -> Unit): Option {
        val option = Option("from")
        option.init()
        return option
    }

    fun rw(init: Option.() -> Unit): Option {
        val option = Option("rw")
        option.init()
        return option
    }
}
