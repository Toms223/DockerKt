package dsl.commands

import dsl.commands.base.Command

class Expose: Command("EXPOSE") {
    fun udp(port: Int) {
       arguments.add("$port/udp")
    }

    fun tcp(port: Int) {
        arguments.add("$port/tcp")
    }

    override fun Any.unaryPlus()
    {
        when(this) {
            is String -> {
                val port = this.split("/")
                if(port.size == 2) {
                    arguments.add(this)
                } else {
                    arguments.add("$this/tcp")
                }
            }
        }
    }
}