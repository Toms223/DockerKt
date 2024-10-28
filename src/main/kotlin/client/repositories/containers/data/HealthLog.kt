package client.repositories.containers.data

import java.time.LocalDateTime

data class HealthLog(
    val start: LocalDateTime,
    val end: LocalDateTime,
    val exitCode: Int,
    val output: String
)
