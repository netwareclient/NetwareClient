package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

@Suppress("unused")
class RequestClient(
    url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = "" // Get is a default network request method
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody = ""

    var isSuccess: Boolean = false
    val response: RequestResponse = RequestResponse()
    var error: RequestError = RequestError()

    // Constructor 1
    constructor(url: String, method: String) : this(url) {
        networkRequestMethod = method
    }

    // Constructor 2
    constructor(url: String, method: String, headers: Map<String, String>) : this(url) {
        networkRequestMethod = method
        addHeaders(headers)
    }

    // Constructor 3
    constructor(url: String, method: String, headers: Map<String, String>, body: String) : this(url) {
        networkRequestMethod = method
        addHeaders(headers)
        networkRequestBody = body
    }

    // Constructor 4
    constructor(url: String, headers: Map<String, String>) : this(url) {
        networkRequestMethod = "GET"
        addHeaders(headers)
    }

    private fun networkRequestMethodIsValid(): Boolean {
        return networkRequestMethod in listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
    }

    // Request builder function with callback
    fun build(clientCallback: ClientCallback) {
        when {
            networkRequestMethodIsValid() -> {

            }
            else -> {
                clientCallback.onError(
                    error = RequestError(
                        statusCode = 1000,
                        status = "Failed",
                        message = "\"$networkRequestMethod\" is not a valid HTTP request method."
                    )
                )
                isSuccess = false
            }
        }
    }

    // Request builder function without callback
    fun build(): RequestClient {
        when {
            networkRequestMethodIsValid() -> {

            }
            else -> {
                error = RequestError(
                    statusCode = 1000,
                    status = "Failed",
                    message = "\"$networkRequestMethod\" is not a valid HTTP request method."
                )
                isSuccess = false
            }
        }
        return this
    }

    // Function to add headers to the network request headers
    private fun addHeaders(headers: Map<String, String>) {
        for ((key, value) in headers) {
            networkRequestHeaders[key] = value
        }
    }

    internal fun getRequestHeaders() = networkRequestHeaders

    internal fun getRequestMethod() = networkRequestMethod

    internal fun getRequestUrl() = networkRequestUrl

    internal fun getRequestBody() = networkRequestBody

    internal fun isNetworkRequestMethodValid() = networkRequestMethodIsValid()
}