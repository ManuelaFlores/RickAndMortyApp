package com.manuflowers.rickandmortyapp.ui

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.manuflowers.rickandmortyapp.network.models.CharacterResponse
import com.manuflowers.rickandmortyapp.ui.base.ActivityRetriever
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainListFeedView(private val mainView: ViewGroup) : MainView, KoinComponent, LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()

    override val containerView: View?
        get() = mainView

    init {
        val viewModel = ViewModelProviders.of(activityRetriever.getActivity() as FragmentActivity)
            .get(MainViewModel::class.java)
        viewModel.mainView = this
        viewModel.getCharacterResponse()
    }

    override fun setMainView(characterResponse: CharacterResponse) {
        charactersRecyclerView.adapter = CharactersAdapter(charactersList = characterResponse.results.toMutableList())
    }
}