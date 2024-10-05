package netware.client

@Suppress("unused")
class RequestClient(
    private val url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = ""
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody = ""

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

    // Function to add headers to the network request headers
    private fun addHeaders(headers: Map<String, String>) {
        for ((key, value) in headers) {
            networkRequestHeaders[key] = value
        }
    }

    internal fun getRequestHeaders(): Map<String, String> {
        return networkRequestHeaders
    }
}