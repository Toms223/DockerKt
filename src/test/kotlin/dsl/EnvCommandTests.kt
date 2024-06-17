package dsl

import dsl.commands.base.Dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class EnvCommandTests {
    @Test
    fun `should create ENV command with string`() {
        assertEquals(Dockerfile {
            ENV {
                +"key=value"
                +"key2=value2"
            }
        }.toString(), "ENV key=value key2=value2")
    }

    @Test
    fun `should create ENV command with pairs`() {
        assertEquals(Dockerfile {
            ENV {
                +("key" to "value")
                +("key2" to "value2")
            }
        }.toString(), "ENV key=value key2=value2")
    }
}