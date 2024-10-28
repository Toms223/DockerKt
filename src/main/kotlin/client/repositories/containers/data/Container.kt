package client.repositories.containers.data


import client.httpclient.Client
import java.util.Date

data class Container(
    val id: String,
    val created: Date,
    val path: String,
    val args: List<String>,
    val name: String,
    val image: Image,
    val config: Config,
    val hostConfig: HostConfig,
    val state: ContainerState,
    val networkSettings: NetworkSettings,
    val mounts: List<Mount>
){
    suspend fun start(httpClient: Client, host: String) {
        val endpoint = "$host/containers/${id}/start"
        val response = httpClient.post(endpoint)
        assert(response.code == 204 || response.code == 304) { "Fail to start container: ${response.code} error" }
    }

    suspend fun stop(httpClient: Client, host: String) {
        val stopEndpoint = "$host/containers/${id}/stop"
        val waitEndpoint = "$host/containers/${id}/wait"
        val response = httpClient.post(stopEndpoint)
        assert(response.code == 204 || response.code == 304) { "Fail to stop container: ${response.code} error" }
        httpClient.post(waitEndpoint)
    }

    suspend fun pause(httpClient: Client, host: String) {
        val endpoint = "$host/containers/${id}/pause"
        val response = httpClient.post(endpoint)
        assert(response.code == 204) { "Fail to pause container: ${response.code} error" }
    }

    suspend fun resume(httpClient: Client, host: String) {
        val endpoint = "$host/containers/${id}/unpause"
        val response = httpClient.post(endpoint)
        assert(response.code == 204) { "Fail to start container: ${response.code} error" }
    }

    suspend fun restart(httpClient: Client, host: String) {
        val endpoint = "$host/containers/${id}/restart"
        val response = httpClient.post(endpoint)
        assert(response.code == 204) { "Fail to restart container: ${response.code} error" }
    }

    suspend fun kill(httpClient: Client, host: String) {
        val endpoint = "$host/containers/${id}/kill"
        val response = httpClient.post(endpoint)
        assert(response.code == 204) { "Fail to kill container: ${response.code} error" }
    }
}
