package com.example.betanalyzier.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("response") val response: List<T>
)

// --- Fixtures ---
data class FixtureResponse(
    @SerializedName("fixture") val fixture: Fixture,
    @SerializedName("league") val league: League,
    @SerializedName("teams") val teams: Teams,
    @SerializedName("goals") val goals: Goals,
    @SerializedName("score") val score: Score
)

data class Fixture(
    @SerializedName("id") val id: Int,
    @SerializedName("date") val date: String,
    @SerializedName("venue") val venue: Venue,
    @SerializedName("status") val status: Status
)

data class Venue(
    @SerializedName("name") val name: String,
    @SerializedName("city") val city: String
)

data class League(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("season") val season: Int
)

data class Teams(
    @SerializedName("home") val home: Team,
    @SerializedName("away") val away: Team
)

data class Team(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("winner") val winner: Boolean?
)

data class Goals(
    @SerializedName("home") val home: Int?,
    @SerializedName("away") val away: Int?
)

data class Score(
    @SerializedName("halftime") val halftime: Goals,
    @SerializedName("fulltime") val fulltime: Goals
)

data class Status(
    @SerializedName("long") val long: String,
    @SerializedName("short") val short: String,
    @SerializedName("elapsed") val elapsed: Int?
)

// --- Predictions ---
data class PredictionResponse(
    @SerializedName("predictions") val predictions: Predictions,
    @SerializedName("comparison") val comparison: Comparison,
    @SerializedName("h2h") val h2h: List<FixtureResponse>
)

data class Predictions(
    @SerializedName("advice") val advice: String,
    @SerializedName("percent") val percent: Percent
)

data class Percent(
    @SerializedName("home") val home: String,
    @SerializedName("draw") val draw: String,
    @SerializedName("away") val away: String
)

data class Comparison(
    @SerializedName("form") val form: TeamComparison,
    @SerializedName("goals") val goals: TeamComparison,
    @SerializedName("h2h") val h2h: TeamComparison
)

data class TeamComparison(
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)

// --- Statistics ---
data class StatisticResponse(
    @SerializedName("team") val team: Team,
    @SerializedName("statistics") val statistics: List<Statistic>
)

data class Statistic(
    @SerializedName("type") val type: String,
    @SerializedName("value") val value: Any? // Corner Kicks, Yellow Cards, Ball Possession, Shots on Goal
)

// --- Injuries ---
data class InjuryResponse(
    @SerializedName("player") val player: InjuryPlayer,
    @SerializedName("team") val team: Team,
    @SerializedName("fixture") val fixture: FixtureBrief
)

data class InjuryPlayer(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String, // "Missing", "Doubtful"
    @SerializedName("reason") val reason: String
)

data class FixtureBrief(
    @SerializedName("id") val id: Int
)

// --- Lineups ---
data class LineupResponse(
    @SerializedName("team") val team: Team,
    @SerializedName("coach") val coach: Coach,
    @SerializedName("formation") val formation: String,
    @SerializedName("startXI") val startXI: List<PlayerEntry>,
    @SerializedName("substitutes") val substitutes: List<PlayerEntry>
)

data class Coach(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: String
)

data class PlayerEntry(
    @SerializedName("player") val player: Player
)

data class Player(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: Int,
    @SerializedName("pos") val pos: String,
    @SerializedName("grid") val grid: String?
)

// --- Standings ---
data class StandingResponse(
    @SerializedName("league") val league: StandingLeague
)

data class StandingLeague(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("flag") val flag: String,
    @SerializedName("season") val season: Int,
    @SerializedName("standings") val standings: List<List<Standing>>
)

data class Standing(
    @SerializedName("rank") val rank: Int,
    @SerializedName("team") val team: Team,
    @SerializedName("points") val points: Int,
    @SerializedName("goalsDiff") val goalsDiff: Int,
    @SerializedName("group") val group: String,
    @SerializedName("form") val form: String,
    @SerializedName("status") val status: String,
    @SerializedName("description") val description: String?,
    @SerializedName("all") val all: StandingStats,
    @SerializedName("home") val home: StandingStats,
    @SerializedName("away") val away: StandingStats,
    @SerializedName("update") val update: String
)

data class StandingStats(
    @SerializedName("played") val played: Int,
    @SerializedName("win") val win: Int,
    @SerializedName("draw") val draw: Int,
    @SerializedName("lose") val lose: Int,
    @SerializedName("goals") val goals: StandingGoals
)

data class StandingGoals(
    @SerializedName("for") val forGoals: Int,
    @SerializedName("against") val againstGoals: Int
)
