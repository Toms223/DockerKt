package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class HealthcheckCommandTests {
    @Test
    fun `Should create healthcheck command with none`() {
        assertEquals(
            Dockerfile {
                HEALTHCHECK {
                    none()
                }
            }.toString(), "HEALTHCHECK NONE"
        )
    }

    @Test
    fun `Should create healthcheck command with command`() {
        assertEquals(
            Dockerfile {
                HEALTHCHECK {
                    CMD("ls")
                }
            }.toString(), "HEALTHCHECK CMD ls"
        )
    }

    @Test
    fun `Should create healthcheck command with all options`() {
        assertEquals(
            Dockerfile {
                HEALTHCHECK {
                    CMD("ls")
                    +interval(30)
                    +timeout(30)
                    +startPeriod(30)
                    +startInterval(30)
                    +retries(3)
                }
            }.toString(), "HEALTHCHECK --interval=30s --timeout=30s --start-period=30s --start-interval=30s --retries=3 CMD ls"
        )
    }
}