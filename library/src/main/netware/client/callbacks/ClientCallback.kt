package netware.client.callbacks

import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

// Callback interface for RequestClient
interface ClientCallback {

    fun onSuccess(response: RequestResponse)
    fun onError(error: RequestError)
}