package dsl.commands

import dsl.commands.base.Command

class User: Command("USER") {
    private var user = ""
    private var group = ""

    fun user(user: String) {
        this.user = user
    }

    fun group(group: String) {
        this.group = group
    }

    override fun Any.unaryPlus() {
        when(this) {
            is String ->{
                this.split(":").let {
                    user = it[0]
                    group = it.getOrNull(1) ?: ""
                }
            }
        }
    }

    override fun toString(): String {
        if (group != "") {
            arguments.add("$user:$group")
        }
        else {
            arguments.add(user)
        }
        return super.toString()
    }
}