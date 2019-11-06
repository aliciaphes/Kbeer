package com.kbeer.repository

import com.kbeer.model.Beer
import java.util.concurrent.atomic.AtomicInteger


class BeerRepository {

    private val idCounter: AtomicInteger = AtomicInteger()
    private val beers = ArrayList<Beer>()


    fun add(beer: Beer){
        if (!beers.contains(beer)) {
            beer.id = idCounter.incrementAndGet()
            beers.add(beer)
        }
    }

    fun beer(id: Int) = beers.find { it.id == id } ?: throw IllegalArgumentException("No beer found for $id.")


    fun beers() = beers


    fun remove(beer: Beer) {
        if (!beers.contains(beer)) {
            throw IllegalArgumentException("No beer found for ${beer.id}")
        }
        beers.remove(beer)
    }

    fun remove(id: Int) = beers.remove(beer(id))


    fun clear() = beers.clear()


}



