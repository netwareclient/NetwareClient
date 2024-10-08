package netware.client.holders

// Data class to hold response of HTTP Requests
data class RequestResponse(
    private val status: String = "No status found",
    private val statusCode: Int = 0,
    private val response: String = "No response found.",
    private val headers: Map<String, String> = mapOf()
) {

    fun getStatus() = status
    fun getStatusCode() = statusCode
    fun getResponse() = response
    fun getHeaders() = headers

    fun getResponseLog(): String {
        return """
            Status code: $statusCode, Status: $status.
            Response: $response
        """.trimIndent()
    }

    fun getResponseLog(formatted: Boolean): String {
        return if (formatted) {
            """
                ---------------------------------------------------------------
                Status: $status, Status Code: $statusCode.
                Response: -----------------------------------------------------
                $response
                ---------------------------------------------------------------
            """.trimIndent()
        } else {
            """
                Status code: $statusCode, Status: $status.
                Response: $response
            """.trimIndent()
        }
    }
}
