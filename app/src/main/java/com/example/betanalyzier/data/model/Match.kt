package com.example.betanalyzier.data.model

data class Match(
    val id: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeLogoUrl: String,
    val awayLogoUrl: String,
    val date: String,
    val league: String,
    val oddsHome: Double,
    val oddsDraw: Double,
    val oddsAway: Double,
    var recommendation: Recommendation? = null
)

data class Recommendation(
    val text: String,
    val color: Int // Resource ID for color
)