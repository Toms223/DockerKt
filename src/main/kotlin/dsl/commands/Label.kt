package dsl.commands

import dsl.commands.base.Command

class Label:Command("LABEL") {
    override fun Any.unaryPlus() {
        when(this) {
            is String -> arguments.add(this)
            is Pair<*, *> -> arguments.add("${this.first}=${this.second}")
        }
    }
}