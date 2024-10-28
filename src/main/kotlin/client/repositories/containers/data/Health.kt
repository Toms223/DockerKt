package client.repositories.containers.data

data class Health(
    val status: HealthStatus,
    val failingStreak: Int,
    val log: HealthLog
)
