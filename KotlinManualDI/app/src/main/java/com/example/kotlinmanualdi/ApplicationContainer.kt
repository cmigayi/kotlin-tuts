package com.example.kotlinmanualdi

import java.util.Random

class ApplicationContainer {
    val numberRespository: NumberRespository = NumberRepositoryImpl(Random())
}