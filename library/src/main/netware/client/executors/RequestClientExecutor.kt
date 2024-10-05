package netware.client.executors

import netware.client.holders.RequestClientResponse
import netware.client.holders.RequestError

class RequestClientExecutor(
    private val networkRequestUrl: String,
    private val networkRequestMethod: String,
    private val networkRequestHeaders: Map<String, String>? = null,
    private val networkRequestBody: String? = null
) {

    internal fun validateNetworkRequest(): RequestClientResponse {
        return when {
            networkRequestUrl.startsWith("http://") -> {
                requestExecutor()
            }
            networkRequestUrl.startsWith("https://") -> {
                requestExecutor()
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

    internal fun requestExecutor(): RequestClientResponse {
        return RequestClientResponse(
            isSuccessful = true
        )
    }

}