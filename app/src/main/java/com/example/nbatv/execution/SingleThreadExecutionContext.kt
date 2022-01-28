package com.example.nbatv.execution

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SingleThreadExecutionContext : ExecutionContext {
    private val executorService = Executors.newSingleThreadExecutor()
    override fun execute(block: () -> Unit) {
        executorService.submit(block)
    }

//    fun join() {
//        executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)
//    }
}