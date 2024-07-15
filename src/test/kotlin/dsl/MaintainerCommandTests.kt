package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MaintainerCommandTests {
    @Test
    fun `Should create maintainer command with single argument`() {
        assertEquals(
            Dockerfile {
                MAINTAINER {
                    +"Me!"
                }
            }.toString(), "MAINTAINER Me!")
    }
}