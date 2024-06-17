package dsl.commands.base

abstract class Command(private val command: String, private val separator: String = " ") {
    val arguments = mutableListOf<String>()
    private val options = mutableListOf<Option>()


    open operator fun invoke(init: Command.() -> Unit) {
        this.init()
    }

    open operator fun Any.unaryPlus() {
        when(this) {
            is String -> arguments.add(this)
            is Option -> options.add(this)
        }
    }

    override fun toString(): String {
        val arguments = arguments.joinToString(if(separator != " ")" $separator " else separator)
        val options = if(options.isNotEmpty()) " --${options.joinToString(" --")} " else " "
        return "$command$options$arguments"
    }
}