package com.example.betanalyzier.utils

import android.graphics.Color
import com.example.betanalyzier.data.model.FixtureResponse
import com.example.betanalyzier.data.model.Standing
import com.example.betanalyzier.data.model.StatisticResponse

data class AnalysisResult(
    val prediction: String,
    val probability: Int,
    val reason: String,
    val color: Int
)

class ProfessionalAnalyzer {

    fun analyze(
        h2h: List<FixtureResponse>,
        homeLast10: List<FixtureResponse>,
        awayLast10: List<FixtureResponse>,
        homeStanding: Standing?,
        awayStanding: Standing?
    ): AnalysisResult {
        var homeScore = 0.0
        var awayScore = 0.0
        val reasons = mutableListOf<String>()

        // 1. Factor Campo (Simplified)
        homeScore += 0.5
        reasons.add("Ventaja de localía para ${homeStanding?.team?.name ?: "Local"}")

        // 2. Momento de Forma (Last 5)
        val homeForm = homeLast10.take(5)
        val awayForm = awayLast10.take(5)
        
        val homeWins = homeForm.count { it.teams.home.winner == true || it.teams.away.winner == true && it.teams.away.id == it.teams.home.id } // This logic needs careful team check
        // Simplified form check
        val homePoints = calculatePoints(homeLast10.take(5), homeStanding?.team?.id ?: -1)
        val awayPoints = calculatePoints(awayLast10.take(5), awayStanding?.team?.id ?: -1)

        if (homePoints > awayPoints) {
            homeScore += 1.0
            reasons.add("Mejor racha reciente del local (${homePoints} pts vs ${awayPoints} pts)")
        } else if (awayPoints > homePoints) {
            awayScore += 1.0
            reasons.add("Visitante en mejor estado de forma (${awayPoints} pts vs ${homePoints} pts)")
        }

        // 3. Clasificación
        if (homeStanding != null && awayStanding != null) {
            if (homeStanding.rank < awayStanding.rank) {
                homeScore += 0.8
                reasons.add("Mejor posición en tabla: ${homeStanding.rank}º vs ${awayStanding.rank}º")
            } else if (awayStanding.rank < homeStanding.rank) {
                awayScore += 0.8
                reasons.add("Visitante superior en clasificación")
            }
        }

        // Final Calculation
        val total = homeScore + awayScore
        val homeProb = if (total > 0) ((homeScore / total) * 100).toInt() else 50
        
        return when {
            homeProb > 65 -> AnalysisResult("Victoria Local", homeProb, reasons.joinToString(". "), Color.parseColor("#4CAF50"))
            homeProb < 35 -> AnalysisResult("Victoria Visitante", 100 - homeProb, reasons.joinToString(". "), Color.parseColor("#4CAF50"))
            else -> AnalysisResult("Empate / Riesgo", 50, "Fuerzas muy equilibradas. " + reasons.take(1).joinToString(""), Color.parseColor("#FF9800"))
        }
    }

    private fun calculatePoints(fixtures: List<FixtureResponse>, teamId: Int): Int {
        var points = 0
        fixtures.forEach { f ->
            if (f.teams.home.id == teamId) {
                if (f.teams.home.winner == true) points += 3
                else if (f.teams.home.winner == null) points += 1
            } else if (f.teams.away.id == teamId) {
                if (f.teams.away.winner == true) points += 3
                else if (f.teams.away.winner == null) points += 1
            }
        }
        return points
    }
}
