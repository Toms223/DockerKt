package dsl

import dsl.commands.base.Dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class ArgCommandTests {
    @Test
    fun `arg command with single argument`() {
        assertEquals(
            Dockerfile{
                ARG{
                    +"key=value"
                }
            }.toString(), "ARG key=value"
        )
    }
}