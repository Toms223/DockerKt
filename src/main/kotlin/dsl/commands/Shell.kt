package dsl.commands

import dsl.commands.base.Executing

class Shell: Executing("SHELL") {
    init {
        shell()
    }
}