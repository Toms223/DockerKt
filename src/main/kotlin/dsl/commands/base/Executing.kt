package dsl.commands.base

abstract class Executing(val command: String, separator: String = " "): Command(command, separator){
    private var shell = false
    fun shell() {
        shell = true
    }

    override fun toString(): String {
        return if(shell) {
            val instructions = super.toString().split(" ").drop(1)
            val flags = instructions.filter { it.startsWith("--") }
            val flagsString = if (flags.isNotEmpty()) flags.joinToString(" ") + " " else ""
            val values = instructions.filter { !it.startsWith("--") }.joinToString {"\"$it\""}
            return "$command $flagsString[$values]"
        } else {
            super.toString()
        }
    }
}