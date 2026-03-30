package com.example.betanalyzier.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.betanalyzier.data.model.Match
import com.example.betanalyzier.databinding.ItemMatchBinding

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    private var matches: List<Match> = emptyList()

    fun submitList(newList: List<Match>) {
        matches = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size

    class MatchViewHolder(private val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            binding.tvHomeTeam.text = match.homeTeam
            binding.tvAwayTeam.text = match.awayTeam
            binding.tvLeague.text = match.league
            binding.tvDate.text = match.date
            binding.tvOddsHome.text = "1: ${match.oddsHome}"
            binding.tvOddsDraw.text = "X: ${match.oddsDraw}"
            binding.tvOddsAway.text = "2: ${match.oddsAway}"

            Glide.with(binding.ivHomeLogo.context)
                .load(match.homeLogoUrl)
                .into(binding.ivHomeLogo)

            Glide.with(binding.ivAwayLogo.context)
                .load(match.awayLogoUrl)
                .into(binding.ivAwayLogo)

            match.recommendation?.let {
                binding.tvRecommendation.text = it.text
                binding.tvRecommendation.setTextColor(it.color)
            }
        }
    }
}