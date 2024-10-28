package client.repositories.containers.data

enum class StateStatus{
    CREATED,
    RUNNING,
    PAUSED,
    RESTARTING,
    REMOVING,
    EXITED,
    DEAD
}