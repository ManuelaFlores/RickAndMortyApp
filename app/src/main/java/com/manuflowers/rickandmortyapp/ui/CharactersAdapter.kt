package com.manuflowers.rickandmortyapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.rickandmortyapp.R
import com.manuflowers.rickandmortyapp.network.models.Result
import kotlinx.android.synthetic.main.item_list_character.view.*

class CharactersAdapter(private val charactersList: MutableList<Result>) :
    RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_character, parent, false)
        return CharactersViewHolder(layout)
    }

    override fun getItemCount() = charactersList.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

    inner class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(result: Result) {
            itemView.characterNameTextView.text = result.name
            itemView.characterGender.text = result.gender
            itemView.characterSpace.text = result.species
        }
    }
}