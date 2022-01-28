package com.example.nbatv.internal

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.io.FileReader

class OkHttpTeamRepositoryTest {

//    private val mockWebServer = MockWebServer()
//
//    @Before
//    fun setup() {
//        mockWebServer.start(8080)
//    }
//
//    @Test
//    fun testSuccessfulResponse() {
//        mockWebServer.dispatcher = object : Dispatcher() {
//            override fun dispatch(request: RecordedRequest):
//                    MockResponse {
//                return MockResponse()
//                    .setResponseCode(200)
//                    .setBody(FileReader.readStringFromFile("success_response.json"))
//            }
//        }
//    }
//
//    @Test
//    fun testFailedResponse() {
//
//    }
//
////    @Test
////    fun getAllTeams() {
////    }
//
//    @After
//    fun teardown() {
//        mockWebServer.shutdown()
//    }
}