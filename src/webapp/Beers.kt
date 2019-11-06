package com.kbeer.webapp

import com.kbeer.model.Beer
import com.kbeer.repository.BeerRepository
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post

const val HOME = "/"
const val BEER = "/beer"


fun Route.beer(beerRepository: BeerRepository) {

    get(HOME) {
        call.respond(beerRepository.beers())
    }


    post(BEER) {
        val beer = call.receive<Beer>()
        beerRepository.add(beer)
        call.respond(beer)
    }
}