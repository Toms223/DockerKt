package dsl.commands

import dsl.commands.base.Command

class Env: Command("ENV"){
    override fun Any.unaryPlus() {
        when(this) {
            is String -> arguments.add(this)
            is Pair<*, *> -> arguments.add("${this.first}=${this.second}")
        }
    }
}