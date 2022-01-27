package com.example.nbatv.execution

import android.os.Handler
import android.os.Looper

class UiExecutionContext : ExecutionContext{
    private val mainHandler = Handler(Looper.getMainLooper())
    override fun execute(block: () -> Unit) {
        mainHandler.post(block)
    }
}