package netware.client.holders

// Data class holding request status of HTTP Requests
data class RequestClientResponse(
    val isSuccessful: Boolean,
    private val response: RequestResponse = RequestResponse(),
    private val error: RequestError = RequestError()
) {

    fun getResponse() = response
    fun getError() = error
}