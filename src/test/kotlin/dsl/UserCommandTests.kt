package dsl

import dsl.commands.base.Dockerfile
import kotlin.test.Test
import kotlin.test.assertEquals

class UserCommandTests {
    @Test
    fun `Should create user command with single user`() {
        assertEquals(
            Dockerfile {
                USER {
                    +"user"
                }
            }.toString(), "USER user"
        )
    }

    @Test
    fun `Should create user command with single user and group`() {
        assertEquals(
            Dockerfile {
                USER {
                    +"user:group"
                }
            }.toString(), "USER user:group"
        )
    }
}