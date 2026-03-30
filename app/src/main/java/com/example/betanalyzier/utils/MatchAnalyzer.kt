package com.example.betanalyzier.utils

import android.graphics.Color
import com.example.betanalyzier.data.model.FixtureResponse
import com.example.betanalyzier.data.model.InjuryResponse
import com.example.betanalyzier.data.model.StatisticResponse

data class DeepAnalysisResult(
    val recommendation: String,
    val confidence: Int,
    val color: Int
)

object MatchAnalyzer {

    fun performDeepAnalysis(
        homeStats: List<StatisticResponse>,
        awayStats: List<StatisticResponse>,
        h2h: List<FixtureResponse>,
        injuries: List<InjuryResponse>,
        homeTeamId: Int,
        awayTeamId: Int
    ): DeepAnalysisResult {
        var valueScore = 70 // Base score
        var advice = ""

        // 1. Forma (Últimos 5 partidos) - Simplificado
        // Suponemos que h2h o una lista de últimos partidos nos da la forma.
        // Aquí simulamos el cálculo basado en victorias recientes.

        // 2. Penalización por Bajas Clave
        val homeInjuries = injuries.filter { it.team.id == homeTeamId }
        if (homeInjuries.size > 2) {
            valueScore -= 15
            advice += "Bajas críticas en el local. "
        }

        // 3. Mercado de Corners
        val homeCorners = getStatValue(homeStats, "Corner Kicks")
        val awayCorners = getStatValue(awayStats, "Corner Kicks")
        val totalAvgCorners = homeCorners + awayCorners

        if (totalAvgCorners > 9.5) {
            advice += "Recomendación: Más de 9.5 corners. "
        } else if (totalAvgCorners > 8.5) {
            advice += "Recomendación: Más de 8.5 corners. "
        }

        // Determinar Color y Resultado Final
        val color = when {
            valueScore >= 75 -> Color.parseColor("#4CAF50") // Verde
            valueScore >= 50 -> Color.parseColor("#FF9800") // Naranja
            else -> Color.parseColor("#F44336") // Rojo
        }

        if (advice.isEmpty()) advice = "Partido equilibrado, precaución."

        return DeepAnalysisResult(advice, valueScore, color)
    }

    private fun getStatValue(stats: List<StatisticResponse>, type: String): Double {
        val stat = stats.flatMap { it.statistics }.find { it.type == type }
        return when (val v = stat?.value) {
            is Number -> v.toDouble()
            is String -> v.replace("%", "").toDoubleOrNull() ?: 0.0
            else -> 0.0
        }
    }
}
