package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.executors.RequestClientExecutor
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

@Suppress("unused")
class RequestClient(
    url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = "GET" // Get is a default network request method
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody: String? = null

    var isSuccess: Boolean = false
    var response: RequestResponse = RequestResponse()
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

    // Constructor 5
    constructor(url: String, method: String, body: String): this(url) {
        networkRequestMethod = method
        addHeaders(emptyMap())
        networkRequestBody = body
    }

    private fun networkRequestMethodIsValid(): Boolean {
        return networkRequestMethod in listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
    }

    // Request builder function with callback
    fun build(clientCallback: ClientCallback): RequestClient {
        when {
            networkRequestMethodIsValid() -> {
                executeRequest(object : ClientCallback {
                    override fun onSuccess(response: RequestResponse) {
                        clientCallback.onSuccess(response)
                    }
                    override fun onError(error: RequestError) {
                        clientCallback.onError(error)
                    }
                })
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
        return this
    }

    // Request builder function without callback
    fun build(): RequestClient {
        when {
            networkRequestMethodIsValid() -> {
                executeRequest(object : ClientCallback {
                    override fun onSuccess(response: RequestResponse) {
                        isSuccess = true
                        this@RequestClient.response = response
                    }
                    override fun onError(error: RequestError) {
                        isSuccess = false
                        this@RequestClient.error = error
                    }
                })
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

    // Function to execute network request
    private fun executeRequest(clientCallback: ClientCallback) {
        if (networkRequestMethod == "GET" && networkRequestBody != null) {
            clientCallback.onError(
                error = RequestError(
                    statusCode = 1000,
                    status = "Failed",
                    message = "An HTTP GET request cannot contain a request body."
                )
            )
            isSuccess = false
        } else {

            val requestClientExecutor = RequestClientExecutor(
                networkRequestUrl = networkRequestUrl,
                networkRequestMethod = networkRequestMethod,
                networkRequestHeaders = networkRequestHeaders,
                networkRequestBody = networkRequestBody
            )

            val requestStatus = requestClientExecutor.validateNetworkRequest()

            if (requestStatus.isSuccessful) {
                clientCallback.onSuccess(
                    response = requestStatus.getResponse()
                )
                isSuccess = true
            } else {
                clientCallback.onError(
                    error = requestStatus.getError()
                )
            }
        }
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