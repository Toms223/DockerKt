package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CopyCommandTests {
    @Test
    fun `Should create copy command without options`(){
        assertEquals(
            Dockerfile{
                COPY{
                    +"file.txt"
                    +"file2.txt"
                }
            }.toString(),
            "COPY file.txt file2.txt"
        )
    }

    @Test
    fun `Should create copy command with options`(){
        assertEquals(
            Dockerfile{
                COPY{
                    +"file.txt"
                    +"file2.txt"
                    +from { +"nginx:latest" }
                    +chown { +"1" }
                }
            }.toString(),
            "COPY --from=nginx:latest --chown=1 file.txt file2.txt"
        )
    }
}