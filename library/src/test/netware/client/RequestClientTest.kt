package netware.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class RequestClientTest {

    @Test
    fun verifyAddedHeaders() {

        val demoHeaders = mapOf(
            "something" to "1something",
            "nothing" to "1nothing"
        )

        val requestClient = RequestClient(
            url = "http://127.0.0.1:8080/",
            headers = demoHeaders
        )

        assertEquals(demoHeaders, requestClient.getRequestHeaders())
    }

    @Test
    fun verifyNetworkRequestMethod() {

        val requestClient = RequestClient(
            url = "http://127.0.0.1:8080/",
            method = "GET"
        )

        assertEquals("GET", requestClient.getRequestMethod())
    }

    @Test
    fun verifyNetworkRequestUrl() {

        val requestClient = RequestClient(
            url = "http://127.0.0.1:8080/",
        )

        assertEquals("http://127.0.0.1:8080/", requestClient.getRequestUrl())
    }

    @Test
    fun checkNetworkRequestMethod() {

        val requestClient = RequestClient(
            url = "http://127.0.0.1:8080/",
            method = "GET"
        )

        assertEquals(true, requestClient.isNetworkRequestMethodValid())
    }
}