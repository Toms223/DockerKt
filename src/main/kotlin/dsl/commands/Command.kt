package dsl.commands

open class Command(private val command: String, private val separator: String = " ") {
    private val savedArguments = mutableListOf<String>()
    private val options = mutableListOf<Option>()


    open operator fun invoke(init: Command.() -> Unit) {
        this.init()
    }

    operator fun Any.unaryPlus() {
        when(this) {
            is String -> savedArguments.add(this)
            is Option -> options.add(this)
        }
    }

    override fun toString(): String{
        val arguments = savedArguments.joinToString(" $separator ")
        val options = if(options.isNotEmpty()) " --${options.joinToString(",")} " else " "
        return "$command$options$arguments"
    }
}