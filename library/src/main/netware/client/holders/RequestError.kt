package netware.client.holders

// Data class to hold error message of HTTP Requests
data class RequestError(
    private val status: String = "No error status found",
    private val statusCode: Int = 0,
    private val message: String = "No error message found.",
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getMessage() = message

    fun getErrorLog(): String {
        return """
            Status code: $statusCode, Status: $status.
            Message: $message
        """.trimIndent()
    }

    fun getErrorLog(formated: Boolean): String {
        return if (formated) {
            """
                ---------------------------------------------------------------
                Status code: $statusCode, Status: $status.
                Message: ------------------------------------------------------
                $message
                ---------------------------------------------------------------
            """.trimIndent()
        } else {
            """
                Status code: $statusCode, Status: $status.
                Message: $message
            """.trimIndent()
        }
    }

}