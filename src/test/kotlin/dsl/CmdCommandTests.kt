package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CmdCommandTests {
    @Test
    fun `Should create cmd command without options and a single argument`(){
        assertEquals(
            Dockerfile{
                CMD{
                    +"echo Hello World!"
                }
            }.toString(),
            "CMD echo Hello World!"
        )
    }

    @Test
    fun `Should create cmd command without options and a single argument in exec form`(){
        assertEquals(
            Dockerfile{
                CMD{
                    +shell()
                    +"echo Hello World!"
                }
            }.toString(),
            "CMD [\"echo\", \"Hello\", \"World!\"]"
        )
    }
}