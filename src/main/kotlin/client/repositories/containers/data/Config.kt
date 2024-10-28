package client.repositories.containers.data


data class Config(val attachStdin: Boolean = false,
                  val attachStdout: Boolean = false,
                  val attachStderr: Boolean = false,
                  val cmd: List<String> = emptyList(),
                  val domainName: String = "",
                  val entrypoint: List<String>,
                  val env: List<String> = emptyList(),
                  val exposedPorts: List<Ports> = emptyList(),
                  val healthCheck: List<Map<String, List<String>>>,
                  val hostname: String = "",
                  val image: String,
                  val labels: MutableMap<String, String> = mutableMapOf(),
                  val macAddress: String = "",
                  val networkDisabled: Boolean = false,
                  val onBuild: List<String> = emptyList(),
                  val openStdin: Boolean = false,
                  val stdinOnce: Boolean = false,
                  val tty: Boolean = false,
                  val user: String = "",
                  val volumes: MutableList<String> = mutableListOf(),
                  val workingDir: String = "",
                  val shell: List<String> = emptyList(),
                  val stopSignal: String = "",
                  val stopTimeout: Int = 10
    )
{



    fun addLabel(key: String, value: String) {
        labels[key] = value
    }

    fun addVolume(volume: String) = volumes.add(volume)

    fun getVolumes() = volumes.toList()

    fun getLabels() = labels.toMap()

    fun getLabel(key: String) = labels[key]
}