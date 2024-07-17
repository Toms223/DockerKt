package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ShellCommandTests {
    @Test
    fun `Should create shell command test with arguments`() {
        assertEquals(Dockerfile {
            SHELL {
                +"executable"
                +"argument1"
                +"argument2"
            }
        }.toString(), "SHELL [\"executable\", \"argument1\", \"argument2\"]")
    }
}