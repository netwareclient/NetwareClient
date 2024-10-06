import netware.client.RequestClient

fun networkRequestWithoutCallback() {

    val requestClient = RequestClient(
        url = "http://localhost:3000",
    ).build()

    if (requestClient.isSuccess) {
        println(requestClient.response.getResponseLog(
            formatted = true
        ))
    } else {
        println(requestClient.error.getErrorLog(
            formated = true
        ))
    }
}

fun main() {
    networkRequestWithoutCallback()
}