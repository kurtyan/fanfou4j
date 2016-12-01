package com.github.kurtyan.fanfou4j.core

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by yanke on 2016/12/1.
 */
class AbstractRequestTest {

    class Result() {}

    class Request : AbstractRequest<Result>() {
        var long: Long by longDelegate
        var int: Int by intDelegate
        var boolean: Boolean by booleanDelegate
        var string: String by stringDelegate
        var underScoreTest: String by stringDelegate
        var neverSetString: String by stringDelegate

        override fun getMethod(): HttpMethod {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getUrl(): String {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun getSuperParameterMap(): HashMap<String, Any?> {
            return super.parameterMap
        }
    }

    @Test
    fun getResponseType() {
        val request = Request()
        Assert.assertEquals(Result::class.java.typeName, request.getResponseType().typeName)
    }

    @Test
    fun getParameter() {
        val string = "com/github/kurtyan/fanfou4j/core/AbstractRequest.kt"
        val underScoreTest = "valueForUnderScoreTest"
        val request = Request()
        request.int = 1
        request.boolean = false
        request.long = 10L
        request.string = string
        request.underScoreTest = underScoreTest

        val superParameterMap = request.getSuperParameterMap()
        val finalParameter = request.getParameter()

        Assert.assertEquals(1, request.int)
        Assert.assertEquals(1, superParameterMap["int"])
        Assert.assertEquals("1", finalParameter["int"])


        Assert.assertEquals(false, request.boolean)
        Assert.assertEquals(false, superParameterMap["boolean"])
        Assert.assertEquals("false", finalParameter["boolean"])

        Assert.assertEquals(10L, request.long)
        Assert.assertEquals(10L, superParameterMap["long"])
        Assert.assertEquals("10", finalParameter["long"])

        Assert.assertEquals(string, request.string)
        Assert.assertEquals(string, superParameterMap["string"])
        Assert.assertEquals("${string}", finalParameter["string"])

        Assert.assertEquals(underScoreTest, request.underScoreTest)
        Assert.assertEquals(underScoreTest, superParameterMap["underScoreTest"])
        Assert.assertEquals(underScoreTest, finalParameter["under_score_test"])
        Assert.assertFalse(finalParameter.containsKey("underScoreTest"))

        Assert.assertNull(request.neverSetString)
        Assert.assertNull(superParameterMap["neverSetString"])
        Assert.assertNull(finalParameter["never_set_string"])
    }

}