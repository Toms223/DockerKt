package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class OnbuildCommandTests {
    @Test
    fun `Should create onbuild command with single command`() {
        assertEquals(
            Dockerfile {
                ONBUILD {
                    +CMD{
                        +"ls"
                    }
                }
            }.toString(), "ONBUILD CMD ls"
        )
    }

    @Test
    fun `Should fail onbuild command with copy with from argument`() {
        assertThrows<AssertionError>{
            Dockerfile {
                ONBUILD {
                    +COPY {
                        +"file.txt"
                        +"file2.txt"
                        +from { +"nginx:latest" }
                        +chmod { +"777" }
                    }
                }
            }.toString()
        }
    }

    @Test
    fun `Should create onbuild command with copy without from argument`() {
        assertEquals(
            Dockerfile {
                ONBUILD {
                    +COPY {
                        +"file.txt"
                        +"file2.txt"
                        +chmod { +"777" }
                    }
                }
            }.toString(), "ONBUILD COPY --chmod=777 file.txt file2.txt"
        )
    }
}