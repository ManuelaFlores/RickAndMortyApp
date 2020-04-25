package com.manuflowers.rickandmortyapp.network

import com.manuflowers.rickandmortyapp.network.models.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character/")
    suspend fun getAllCharacters(): CharacterResponse
}