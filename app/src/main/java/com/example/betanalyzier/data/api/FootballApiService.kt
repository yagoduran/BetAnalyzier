package com.example.betanalyzier.data.api

import com.example.betanalyzier.data.model.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FootballApiService {
    
    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("date") date: String,
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<FixtureResponse>

    @GET("fixtures/headtohead")
    suspend fun getH2H(
        @Query("h2h") h2h: String, // teamId-teamId
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<FixtureResponse>

    @GET("fixtures")
    suspend fun getTeamLastFixtures(
        @Query("team") teamId: Int,
        @Query("last") last: Int = 10,
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<FixtureResponse>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatistics(
        @Query("fixture") fixtureId: Int,
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<StatisticResponse>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineups(
        @Query("fixture") fixtureId: Int,
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<LineupResponse>

    @GET("standings")
    suspend fun getStandings(
        @Query("league") leagueId: Int,
        @Query("season") season: Int,
        @Header("x-apisports-key") apiKey: String
    ): ApiResponse<StandingResponse>
}
