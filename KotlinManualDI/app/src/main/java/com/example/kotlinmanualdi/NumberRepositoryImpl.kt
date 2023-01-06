package com.example.kotlinmanualdi

import java.util.*

class NumberRepositoryImpl(private val random: Random): NumberRespository {
    override fun generateNextNumber(): Int {
        return random.nextInt()
    }
}