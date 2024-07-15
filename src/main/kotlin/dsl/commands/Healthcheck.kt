package dsl.commands

import dsl.commands.base.Command
import dsl.commands.base.Option

class Healthcheck: Command("HEALTHCHECK") {
    private var CMD = ""

    fun interval(interval: Int): Option {
        val option = Option("interval")
        option { +"${interval}s" }
        return option
    }

    fun timeout(timeout: Int): Option {
        val option = Option("timeout")
        option { +"${timeout}s" }
        return option
    }

    fun startPeriod(startPeriod: Int): Option {
        val option = Option("start-period")
        option { +"${startPeriod}s"}
        return option
    }

    fun startInterval(startInterval: Int): Option {
        val option = Option("start-interval")
        option { +"${startInterval}s" }
        return option
    }

    fun retries(retries: Int): Option {
        val option = Option("retries")
        option { +"$retries" }
        return option
    }

    fun none() {
        CMD = "NONE"
    }

    fun CMD(command: String) {
        CMD = "CMD $command"
    }


    override fun toString(): String {
        return super.toString() + CMD
    }

}