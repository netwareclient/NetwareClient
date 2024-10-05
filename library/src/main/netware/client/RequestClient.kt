package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError

@Suppress("unused")
class RequestClient(
    url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = "GET" // Get is a default network request method
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody = ""

    // Constructor 1
    constructor(url: String, method: String) : this(url) {
        networkRequestMethod = method
        println(networkRequestMethod)
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

    private val networkRequestMethodIsValid = networkRequestMethod == "GET"

    // Request builder function with callback
    fun build(clientCallback: ClientCallback) {
        when {
            networkRequestMethodIsValid -> {

            }
            else -> {
            }
        }
    }

    // Request builder function without callback
    fun build(): RequestClient {
        when {
            networkRequestMethodIsValid -> {

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

    private val invalidNetworkRequestError = RequestError(
        statusCode = 1000,
        status = "Failed",
        message = "$networkRequestMethod is not a valid HTTP request method."
    )

    internal fun getRequestHeaders() = networkRequestHeaders

    internal fun getRequestMethod() = networkRequestMethod

    internal fun getRequestUrl() = networkRequestUrl

    internal fun getRequestBody() = networkRequestBody

    internal fun isNetworkRequestMethodValid() = networkRequestMethodIsValid
}