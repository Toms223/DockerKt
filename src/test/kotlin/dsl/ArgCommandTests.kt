package dsl

import dsl.commands.base.dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class ArgCommandTests {
    @Test
    fun `arg command with single argument`() {
        assertEquals(
            dockerfile{
                arg{
                    +"key=value"
                }
            }.toString(), "ARG key=value"
        )
    }
}