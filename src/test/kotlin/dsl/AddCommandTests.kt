package dsl

import dsl.commands.base.Dockerfile
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class AddCommandTests {
    @Test
    fun `add command with single argument`() {
        assertEquals(
            Dockerfile{
                ADD{
                    +"source"
                }
            }.toString(), "ADD source"
        )
    }

    @Test
    fun `add command with multiple arguments`() {
        assertEquals(
            Dockerfile{
                ADD{
                    +"source"
                    +"destination"
                }
            }.toString(), "ADD source destination"
        )
    }

    @Test
    fun `add command with multiple arguments and options`() {
        assertEquals(
            Dockerfile{
                ADD{
                    +"source"
                    +"destination"
                    +keepGitDir
                    +checksum{
                        +"sha256:1234567890"
                    }
                    +chown{
                        +"user:group"
                    }
                    +chmod{
                        +"777"
                    }
                    +link
                    +exclude{
                        +"*.txt"
                    }
                }
            }.toString(), "ADD --keep-git-dir=true --checksum=sha256:1234567890 --chown=user:group --chmod=777 --link --exclude=*.txt source destination"
        )
    }
}