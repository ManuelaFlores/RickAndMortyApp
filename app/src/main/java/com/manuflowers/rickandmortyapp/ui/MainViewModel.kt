package com.manuflowers.rickandmortyapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuflowers.rickandmortyapp.network.RickAndMortyApi
import com.manuflowers.rickandmortyapp.network.models.CharacterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {

    private  val  rickAndMortyApi: RickAndMortyApi by inject()

    var mainView: MainView? = null

    fun getCharacterResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            val characterResponse = rickAndMortyApi.getAllCharacters()
            withContext(Dispatchers.Main) {
                mainView?.setMainView(characterResponse = characterResponse)
            }
        }
    }
}

interface MainView {
    fun setMainView(characterResponse: CharacterResponse)
}