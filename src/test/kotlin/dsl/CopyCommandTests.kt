package dsl

import dsl.commands.base.dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CopyCommandTests {
    @Test
    fun `Should create copy command without options and a single argument`(){
        assertEquals(
            dockerfile{
                copy{
                    +"file.txt"
                    +"file2.txt"
                }
            }.toString(),
            "COPY file.txt file2.txt"
        )
    }
}