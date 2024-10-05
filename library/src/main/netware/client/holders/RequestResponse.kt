package netware.client.holders

data class RequestResponse(
    private val status: String = "No status found.",
    private val statusCode: Int = 0,
    private val response: String = "No response found.",
) {

    fun getStatus() = status
    fun getStatusCode() = statusCode
    fun getResponse() = response
    fun getLog() {

    }
}
