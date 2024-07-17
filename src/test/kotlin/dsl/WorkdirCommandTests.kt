package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class WorkdirCommandTests {
    @Test
    fun `Should create workdir command with single path`() {
        assertEquals(
            Dockerfile {
                WORKDIR {
                    +"path"
                }
            }.toString(), "WORKDIR path"
        )
    }
}