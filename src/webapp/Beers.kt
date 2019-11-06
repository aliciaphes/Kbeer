package com.kbeer.webapp

import com.kbeer.model.Beer
import com.kbeer.repository.BeerRepository
import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.request.receive
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post

const val HOME = "/"
const val BEER = "/beer"


fun Route.beer(beerRepository: BeerRepository) {

    get(HOME) {
        val beers = beerRepository.beers()
        call.respond(FreeMarkerContent("beers.ftl", mapOf("beers" to beers)))
    }


    post(BEER) {
        val parameters = call.receiveParameters()
        val action = parameters["action"] ?: throw IllegalArgumentException("Missing parameter: action")
        when (action) {
            "add" -> {
                val name = parameters["name"] ?: throw IllegalArgumentException("Missing parameter: name")
                val description =
                    parameters["description"] ?: throw IllegalArgumentException("Missing parameter: description")
                val abv =
                    parameters["abv"] ?: throw IllegalArgumentException("Missing parameter: ABV")
                val beerToAdd = Beer(name, description, abv.toFloat())
                beerRepository.add(beerToAdd)
            }
            "delete" -> {
                val id = parameters["id"] ?: throw IllegalArgumentException("Missing parameter: id")
                beerRepository.remove(id.toInt())
            }
        }
        call.respondRedirect(HOME)
    }
}