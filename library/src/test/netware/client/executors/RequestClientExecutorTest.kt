package netware.client.executors

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class RequestClientExecutorTest {

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
}