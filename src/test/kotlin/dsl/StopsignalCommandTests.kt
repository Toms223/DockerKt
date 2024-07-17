package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StopsignalCommandTests {
    @Test
    fun `Should create stopsignal command with single signal`() {
        assertEquals(
            Dockerfile {
                STOPSIGNAL {
                    +"SIGPROF"
                }
            }.toString(), "STOPSIGNAL SIGPROF"
        )
    }

    @Test
    fun `Should create stopsignal command with single signal from function`() {
        assertEquals(
            Dockerfile {
                STOPSIGNAL {
                    sigkill()
                }
            }.toString(), "STOPSIGNAL SIGKILL"
        )
    }
}