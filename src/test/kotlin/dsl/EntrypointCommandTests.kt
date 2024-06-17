package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class EntrypointCommandTests {
    @Test
    fun `Should create entrypoint command without options`(){
        assertEquals(
            Dockerfile{
                ENTRYPOINT{
                    +"echo Hello, World!"
                }
            }.toString(),
            "ENTRYPOINT echo Hello, World!"
        )
    }

    @Test
    fun `Should create entrypoint command without options and with exec`(){
        assertEquals(
            Dockerfile{
                ENTRYPOINT{
                    +shell()
                    +"echo Hello, World!"
                }
            }.toString(),
            "ENTRYPOINT [\"echo\", \"Hello,\", \"World!\"]"
        )
    }
}