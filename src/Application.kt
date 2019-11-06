package com.kbeer

import com.kbeer.repository.BeerRepository
import com.kbeer.webapp.beer
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.freemarker.FreeMarker
import io.ktor.gson.gson
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    val beerRepository = BeerRepository()

    routing {

        static {
            // This serves files from the 'styles' folder in the application resources.
            resources("styles")
        }

        beer(beerRepository)
    }
}



