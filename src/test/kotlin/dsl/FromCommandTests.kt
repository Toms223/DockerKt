package dsl

import dsl.commands.base.Dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class FromCommandTests {
    @Test
    fun `Should create from command with image`(){
        assertEquals(
            Dockerfile{
                FROM{
                    +"image"
                }
            }.toString(),
            "FROM image"
        )
    }

    @Test
    fun `Should create from command with image with name`(){
        assertEquals(
            Dockerfile{
                FROM{
                    +"image"
                    asName("awesome")
                }
            }.toString(),
            "FROM image AS awesome"
        )
    }

    @Test
    fun `Should create from command with image with name and tag`(){
        assertEquals(
            Dockerfile{
                FROM{
                    +"image"
                    asName("awesome")
                    tag("latest")
                }
            }.toString(),
            "FROM image:latest AS awesome"
        )
    }

    @Test
    fun `Should create from command with image with name and digest`(){
        assertEquals(
            Dockerfile{
                FROM{
                    +"image"
                    asName("awesome")
                    digest("123456")
                }
            }.toString(),
            "FROM image@123456 AS awesome"
        )
    }
}