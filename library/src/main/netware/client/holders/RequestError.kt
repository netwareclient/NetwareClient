package netware.client.holders

data class RequestError(
    private val status: String = "No error status found.",
    private val statusCode: Int = 0,
    private val message: String = "No error message found.",
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getMessage() = message
    fun getErrorLog() {

    }

}