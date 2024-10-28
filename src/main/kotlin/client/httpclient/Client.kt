package client.httpclient

interface Client {
    suspend fun get(url: String): Response
    suspend fun post(url: String, body: String? = null): Response
    suspend fun put(url: String, body: String? = null): Response
    suspend fun delete(url: String): Response
}