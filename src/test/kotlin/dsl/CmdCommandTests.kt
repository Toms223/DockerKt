package dsl

import dsl.commands.base.dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CmdCommandTests {
    @Test
    fun `Should create cmd command without options and a single argument`(){
        assertEquals(
            dockerfile{
                cmd{
                    +"echo Hello World!"
                }
            }.toString(),
            "CMD echo Hello World!"
        )
    }
}