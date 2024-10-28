package client.httpclient


import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class OkHttpDockerClient: Client {
    private val okHttpClient = OkHttpClient()
    private val requestBuilder = okhttp3.Request.Builder()

    override suspend fun get(url: String): Response = suspendCoroutine { continuation ->
        val request = requestBuilder.url(url).build()
        val response = okHttpClient.newCall(request).execute()
        continuation.resume(Response(response.code, response.body?.string()))
    }


    override suspend fun post(url: String, body: String?): Response = suspendCoroutine { continuation ->
        val request = requestBuilder.url(url).post((body ?: "").toRequestBody(null)).build()
        val response = okHttpClient.newCall(request).execute()
        continuation.resume(Response(response.code, response.body?.string()))
    }

    override suspend fun put(url: String, body: String?): Response = suspendCoroutine { continuation ->
        val request = requestBuilder.url(url).put((body ?: "").toRequestBody(null)).build()
        val response = okHttpClient.newCall(request).execute()
        continuation.resume(Response(response.code, response.body?.string()))
    }

    override suspend fun delete(url: String): Response = suspendCoroutine { continuation ->
        val request = requestBuilder.url(url).delete().build()
        val response = okHttpClient.newCall(request).execute()
        continuation.resume(Response(response.code, response.body?.string()))
    }
}