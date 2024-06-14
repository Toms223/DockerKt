package dsl

import dsl.commands.base.dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class RunCommandTests {
    @Test
    fun `Should create run command without options and a single argument`(){
        assertEquals(
            dockerfile{
                run{
                    +"echo Hello World!"
                }
            }.toString(),
            "RUN echo Hello World!"
        )
    }

    @Test
    fun `Should create run command without options and multiple arguments`(){
        assertEquals(
            dockerfile{
                run{
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN echo Hello World! && echo Hi program!"
        )
    }

    @Test
    fun `Should create multiple run commands without options and multiple arguments`(){
        assertEquals(
            dockerfile{
                run{
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
                run{
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN echo Hello World! && echo Hi program!\nRUN echo Hello World! && echo Hi program!"
        )
    }

    @Test
    fun `Should create run command option mount`(){
        assertEquals(
            dockerfile{
                run {
                    +mount {
                        +bind
                        +target { +"/test/path" }
                        +source { +"/test/source" }
                        +from { +"image" }
                        +rw { +"true" }
                    }
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN --mount=type=bind,target=/test/path,source=/test/source,from=image,rw=true echo Hello World! && echo Hi program!"
        )
    }

    @Test
    fun `Should create run command option network`(){
        assertEquals(
            dockerfile{
                run {
                    +network {
                        +none
                    }
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN --network=none echo Hello World! && echo Hi program!"
        )
    }

    @Test
    fun `Should create run command option security`(){
        assertEquals(
            dockerfile{
                run {
                    +security {
                        +sandbox
                    }
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN --security=sandbox echo Hello World! && echo Hi program!"
        )
    }

    @Test
    fun `Should create run command option network and mount`(){
        assertEquals(
            dockerfile{
                run {
                    +network {
                        +none
                    }
                    +mount {
                        +bind
                        +target { +"/test/path" }
                        +source { +"/test/source" }
                        +from { +"image" }
                        +rw { +"true" }
                    }
                    +"echo Hello World!"
                    +"echo Hi program!"
                }
            }.toString(),
            "RUN --network=none --mount=type=bind,target=/test/path,source=/test/source,from=image,rw=true echo Hello World! && echo Hi program!"
        )
    }
}