package com.kbeer.model


data class Beer(val name: String, val description: String) {
    var id: Int = 0
    var abv: Float = 0F // Alcohol by volume

    constructor(name: String, description: String, alcoholByVolume: Float) : this(name, description) {
        abv = alcoholByVolume
    }
}
