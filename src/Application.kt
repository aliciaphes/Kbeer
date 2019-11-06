package com.kbeer

import com.kbeer.repository.BeerRepository
import com.kbeer.webapp.beer
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    val beerRepository = BeerRepository()

    routing {
        beer(beerRepository)
    }
}



