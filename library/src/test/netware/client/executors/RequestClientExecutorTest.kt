package netware.client.executors

import netware.client.holders.RequestResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RequestClientExecutorTest {

    private val expectedResponse = RequestResponse(
        statusCode = 200,
        status = "OK",
        response = """{"message":"API connection established successfully!","status":200}"""
    )

    @Test
    fun testRequestClientValidation() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestUrl = "httxp://127.0.0.1:8080/",
            networkRequestMethod = "POST"
        ).validateNetworkRequest()

        assertEquals("""
            Status code: 1000, Status: Failed.
            Message: Invalid network request protocol.
        """.trimIndent(), requestClientExecutor.getError().getErrorLog())
    }

    @Test
    fun requestExecutorTest() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestUrl = "http://localhost:3000/",
            networkRequestMethod = "GET",
            networkRequestHeaders = null
        ).requestExecutor(
            isHTTPs = false
        )

        assertEquals(expectedResponse, requestClientExecutor.getResponse())
    }
}