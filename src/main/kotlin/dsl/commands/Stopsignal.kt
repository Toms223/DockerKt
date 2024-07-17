package dsl.commands

import dsl.commands.base.Command

class Stopsignal: Command("STOPSIGNAL") {
    private var signal: String = "SIGTERM"

    override fun Any.unaryPlus() {
        when(this) {
            is String -> signal = this
        }
    }

    fun sigabrt() {
        signal = "SIGABRT"
    }

    fun sigalrm() {
        signal = "SIGALRM"
    }

    fun sigbus() {
        signal = "SIGBUS"
    }

    fun sigfpe() {
        signal = "SIGFPE"
    }

    fun sighup() {
        signal = "SIGHUP"
    }

    fun sigill() {
        signal = "SIGILL"
    }

    fun sigint() {
        signal = "SIGINT"
    }

    fun sigkill() {
        signal = "SIGKILL"
    }

    fun sigpipe() {
        signal = "SIGPIPE"
    }

    fun sigpoll() {
        signal = "SIGPOLL"
    }

    fun sigprof() {
        signal = "SIGPROF"
    }

    fun sigquit() {
        signal = "SIGQUIT"
    }

    fun sigsegv() {
        signal = "SIGSEGV"
    }

    fun sigstop() {
        signal = "SIGSTOP"
    }

    fun sigsys() {
        signal = "SIGSYS"
    }

    fun sigtrap() {
        signal = "SIGTRAP"
    }

    fun sigtstp() {
        signal = "SIGTSTP"
    }

    fun sigttin() {
        signal = "SIGTTIN"
    }

    fun sigttou() {
        signal = "SIGTTOU"
    }

    fun sigusr1() {
        signal = "SIGUSR1"
    }

    fun sigusr2() {
        signal = "SIGUSR2"
    }

    fun sigvtalrm() {
        signal = "SIGVTALRM"
    }

    fun sigxcpu() {
        signal = "SIGXCPU"
    }

    fun sigxfsz() {
        signal = "SIGXFSZ"
    }

    override fun toString(): String {
        arguments.add(signal)
        return super.toString()
    }
}