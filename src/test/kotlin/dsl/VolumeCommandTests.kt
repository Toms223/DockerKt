package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class VolumeCommandTests {
    @Test
    fun `Should create volume command with single path`() {
        assertEquals(
            Dockerfile {
                VOLUME {
                    +"path"
                }
            }.toString(), "VOLUME path"
        )
    }

    @Test
    fun `Should create volume command with multiple paths`() {
        assertEquals(
            Dockerfile {
                VOLUME {
                    +"path1"
                    +"path2"
                }
            }.toString(), "VOLUME path1 path2"
        )
    }

    @Test
    fun `Should create volume command with multiple paths in shell form`() {
        assertEquals(
            Dockerfile {
                VOLUME {
                    shell()
                    +"path1"
                    +"path2"
                }
            }.toString(), "VOLUME [\"path1\", \"path2\"]"
        )
    }
}