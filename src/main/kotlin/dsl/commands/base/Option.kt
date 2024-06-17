package dsl.commands.base

class Option(private val key: String) {
    private var value: String? = null

    private val children = mutableListOf<Option>()

    operator fun invoke(init: Option.() -> Unit) {
        this.init()
    }

    operator fun Any.unaryPlus() {
        when(this) {
            is String -> value = this
            is Option -> this@Option.children.add(this)
        }
    }

    override fun toString(): String {
            return "${(if(value != null) "$key=$value" else key) + if(children.isNotEmpty()) "," else ""}${children.joinToString(",")}"
    }
}