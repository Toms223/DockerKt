package dsl

import dsl.commands.base.Dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class ExposeCommandTests {
    @Test
    fun `Should create expose command using default tcp port`(){
        assertEquals(
            Dockerfile{
                EXPOSE{
                    +"80"
                }
            }.toString(),
            "EXPOSE 80/tcp"
        )
    }

    @Test
    fun `Should create expose command using specific string config`(){
        assertEquals(
            Dockerfile{
                EXPOSE{
                    +"80/tcp"
                }
            }.toString(),
            "EXPOSE 80/tcp"
        )
    }

    @Test
    fun `Should create expose tcp command using function`(){
        assertEquals(
            Dockerfile{
                EXPOSE{
                    tcp(80)
                }
            }.toString(),
            "EXPOSE 80/tcp"
        )
    }

    @Test
    fun `Should create expose udp command using function`(){
        assertEquals(
            Dockerfile{
                EXPOSE{
                    udp(80)
                }
            }.toString(),
            "EXPOSE 80/udp"
        )
    }
}