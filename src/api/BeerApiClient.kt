package com.kbeer.api

import com.kbeer.model.Beer
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

class BeerApiClient {

    companion object {
        const val BASE_ENDPOINT =
            "https://api.punkapi.com/v2/beers/random"
    }

    private val client = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }


    suspend fun getBeerFromPunkAPI(): Beer {
        try {
            val content = client.get<ArrayList<Beer>>(BASE_ENDPOINT)
            client.close()
            return content[0]
        } catch (e: Exception) {
            throw Exception("Error retrieving IPA beer")
        }
    }


}





