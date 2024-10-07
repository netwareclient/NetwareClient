import netware.client.RequestClient

fun networkRequestWithoutCallback() {

    val requestClient = RequestClient(
        url = "http://localhost:8000/hello-world",
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