package com.example.betanalyzier.utils

import android.graphics.Color
import com.example.betanalyzier.data.model.Recommendation

object BetAnalyzer {

    fun analyze(oddsHome: Double, oddsDraw: Double, oddsAway: Double): Recommendation {
        // Simple logic based on odds (probability = 1/odds)
        // High value if probability > 70% (odds < 1.42)
        
        return when {
            oddsHome < 1.45 -> Recommendation("Valor Alto - Local", Color.parseColor("#4CAF50")) // Green
            oddsAway < 1.45 -> Recommendation("Valor Alto - Visitante", Color.parseColor("#4CAF50"))
            oddsDraw < 3.0 -> Recommendation("Riesgo - Empate", Color.parseColor("#FF9800")) // Orange
            oddsHome < 2.0 -> Recommendation("Probable - Local", Color.parseColor("#8BC34A")) // Light Green
            oddsAway < 2.0 -> Recommendation("Probable - Visitante", Color.parseColor("#8BC34A"))
            else -> Recommendation("No Apostar", Color.parseColor("#9E9E9E")) // Grey
        }
    }
}