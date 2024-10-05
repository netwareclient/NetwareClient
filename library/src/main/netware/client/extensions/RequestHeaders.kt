package netware.client.extensions

// Request headers (extension) for ease of use
class RequestHeaders {

    private val clientRequestHeaders: MutableMap<String, String> = mutableMapOf()

    fun add(key: String, value: String) {
        clientRequestHeaders[key] = value
    }

    fun getHeaders() = clientRequestHeaders
}