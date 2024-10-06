import netware.client.RequestClient
import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

fun networkRequest() {

    val requestClient = RequestClient(
        url = "http://localhost:3000"
    ).build(object : ClientCallback {
        override fun onSuccess(response: RequestResponse) {
            println(response.getResponseLog(
                formatted = true
            ))
        }
        override fun onError(error: RequestError) {
            println(error.getErrorLog(
                formated = true
            ))
        }
    })
}

fun main() {

    networkRequest()
}