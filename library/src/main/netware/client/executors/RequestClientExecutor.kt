package netware.client.executors

class RequestClientExecutor(
    private val networkRequestUrl: String,
    private val networkRequestMethod: String,
    private val networkRequestHeaders: Map<String, String>? = null,
    private val networkRequestBody: String? = null
) {

}