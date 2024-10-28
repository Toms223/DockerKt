package client.repositories.containers.data

data class ContainerState(
    val status: StateStatus,
    val running: Boolean,
    val paused: Boolean,
    val restarting: Boolean,
    val oomKilled: Boolean,
    val dead: Boolean,
    val pid: Int,
    val exitCode: Int,
    val error: String,
    val startedAt: String,
    val finishedAt: String,
    val
) {
}