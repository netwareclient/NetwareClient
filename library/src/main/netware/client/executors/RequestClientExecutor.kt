package netware.client.executors

import netware.client.holders.RequestClientResponse
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import javax.net.ssl.HttpsURLConnection

@Suppress("unused")
class RequestClientExecutor(
    private val networkRequestUrl: String,
    private val networkRequestMethod: String,
    private val networkRequestHeaders: Map<String, String>? = null,
    private val networkRequestBody: String? = null
) {

    internal fun validateNetworkRequest(): RequestClientResponse {
        return when {
            networkRequestUrl.startsWith("http://") -> {
                requestExecutor(
                    isHTTPs = false
                )
            }
            networkRequestUrl.startsWith("https://") -> {
                requestExecutor(
                    isHTTPs = true
                )
            }
            else -> {
                return RequestClientResponse(
                    isSuccessful = false,
                    error = RequestError(
                        statusCode = 1000,
                        status = "Failed",
                        message = "Invalid network request protocol."
                    )
                )
            }
        }
    }

    internal fun requestExecutor(isHTTPs: Boolean): RequestClientResponse {

        var requestResult = RequestClientResponse()

        val networkRequestUri = URI(networkRequestUrl)
        val networkRequestUrl = networkRequestUri.toURL()

        val networkRequestConnection = if (isHTTPs) {
            networkRequestUrl.openConnection() as HttpsURLConnection
        } else {
            networkRequestUrl.openConnection() as HttpURLConnection
        }

        networkRequestConnection.requestMethod = networkRequestMethod

        if (networkRequestHeaders != null) {
            for ((key, value) in networkRequestHeaders) {
                networkRequestConnection.setRequestProperty(key, value)
            }
        }

        try {

            // Read server response code and status
            val serverResponseStatusCode = networkRequestConnection.responseCode
            val serverResponseStatus = networkRequestConnection.responseMessage?: "No status found"

            val serverResponse = if (serverResponseStatusCode in 200..299) {
                networkRequestConnection.inputStream.bufferedReader().use {
                    it.readText()
                }
            } else {
                networkRequestConnection.errorStream.bufferedReader().use {
                    it.readText()
                }
            }

            val responseHeaders: MutableMap<String, String> = mutableMapOf()

            // Read response map
            networkRequestConnection.headerFields.forEach {
                responseHeaders[it.key] = it.value.toString()
            }

            requestResult = if (serverResponseStatusCode == HttpURLConnection.HTTP_OK) {
                RequestClientResponse(
                    isSuccessful = true,
                    response = RequestResponse(
                        status = serverResponseStatus,
                        statusCode = serverResponseStatusCode,
                        headers = responseHeaders,
                        response = serverResponse
                    )
                )
            } else {
                RequestClientResponse(
                    isSuccessful = true,
                    response = RequestResponse(
                        status = serverResponseStatus,
                        statusCode = serverResponseStatusCode,
                        headers = responseHeaders,
                        response = serverResponse
                    )
                )
            }
        } catch (exception: Exception) {
            requestResult = RequestClientResponse(
                isSuccessful = false,
                error = RequestError(
                    status = "Failed",
                    statusCode = 1000,
                    message = "$exception"
                )
            )
        } finally {
            networkRequestConnection.disconnect()
        }

        return requestResult
    }

}