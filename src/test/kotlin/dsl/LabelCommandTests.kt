package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class LabelCommandTests {
    @Test
    fun `Should create label command with single argument`() {
        assertEquals(
            Dockerfile{
                LABEL{
                    +"key=value"
                }
            }.toString(), "LABEL key=value"
        )
    }

    @Test
    fun `Should create label command with multiple arguments`() {
        assertEquals(
            Dockerfile{
                LABEL{
                    +"key1=value1"
                    +"key2=value2"
                }
            }.toString(), "LABEL key1=value1 key2=value2"
        )
    }

    @Test
    fun `Should create label command with pair values`() {
        assertEquals(
            Dockerfile{
                LABEL{
                    + ("key1" to "value1")
                    + ("key2" to "value2")
                }
            }.toString(), "LABEL key1=value1 key2=value2"
        )
    }
}