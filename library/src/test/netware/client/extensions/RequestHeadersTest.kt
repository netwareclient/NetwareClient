package netware.client.extensions

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RequestHeadersTest {

    @Test
    fun testRequestHeaders() {

        val requestHeaders = RequestHeaders()
        requestHeaders.add("my-header1", "my-header2")
        requestHeaders.add("my-header3", "my-header4")
        requestHeaders.add("my-header4", "my-header5")

        assertEquals("""
            {my-header1=my-header2, my-header3=my-header4, my-header4=my-header5}
        """.trimIndent(), requestHeaders.getHeaders().toString())
    }
}