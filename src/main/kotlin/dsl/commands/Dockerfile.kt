package dsl.commands

class Dockerfile {
    private val children = mutableListOf<Command>()

    fun run(init: Run.() -> Unit) {
        val run = Run()
        run.init()
        children.add(run)
    }

    override fun toString(): String {
        return children.joinToString("\n")
    }
}

fun dockerfile(init: Dockerfile.() -> Unit): Dockerfile {
    val dockerfile = Dockerfile()
    dockerfile.init()
    return dockerfile
}