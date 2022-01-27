package com.example.nbatv.execution

interface ExecutionContext {
    fun execute(block : () -> Unit)
}