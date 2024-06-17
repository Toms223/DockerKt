package dsl.commands

import dsl.commands.base.Command
import dsl.commands.base.Option

class From: Command("FROM") {
    private var name: String = ""
    private var version: String = ""
    fun platform(init: Option.() -> Unit): Option {
        val option = Option("platform")
        option.init()
        return option
    }

    fun tag(tag: String) {
        this.version = ":$tag"
    }

    fun digest(digest: String) {
        this.version = "@$digest"
    }

    fun asName(name:String){
        this.name = " AS $name"
    }

    override fun toString(): String {
        return super.toString() + this.version + this.name
    }
}