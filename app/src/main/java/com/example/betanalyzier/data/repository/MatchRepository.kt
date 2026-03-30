package com.example.betanalyzier.data.repository

import com.example.betanalyzier.data.model.Match
import kotlinx.coroutines.delay

class MatchRepository {

    suspend fun fetchMatches(): List<Match> {
        // Simulate network delay
        delay(2000)

        // Return hardcoded mock data
        return listOf(
            Match(1, "Real Madrid", "Barcelona", "https://upload.wikimedia.org/wikipedia/en/5/56/Real_Madrid_CF.svg", "https://upload.wikimedia.org/wikipedia/en/4/47/FC_Barcelona.svg", "Hoy 21:00", "La Liga", 2.10, 3.40, 3.20),
            Match(2, "Manchester City", "Arsenal", "https://upload.wikimedia.org/wikipedia/en/eb/eb/Manchester_City_FC_badge.svg", "https://upload.wikimedia.org/wikipedia/en/5/53/Arsenal_FC.svg", "Hoy 17:30", "Premier League", 1.80, 3.60, 4.20),
            Match(3, "Bayern Munich", "Dortmund", "https://upload.wikimedia.org/wikipedia/commons/1/1b/FC_Bayern_München_logo_%282017%29.svg", "https://upload.wikimedia.org/wikipedia/commons/6/67/Borussia_Dortmund_logo.svg", "Hoy 18:30", "Bundesliga", 1.40, 4.50, 6.00),
            Match(4, "PSG", "Marseille", "https://upload.wikimedia.org/wikipedia/en/a/a7/Paris_Saint-Germain_F.C..svg", "https://upload.wikimedia.org/wikipedia/en/3/3f/Olympique_de_Marseille_logo.svg", "Mañana 20:45", "Ligue 1", 1.30, 5.00, 8.50),
            Match(5, "Inter Milan", "Juventus", "https://upload.wikimedia.org/wikipedia/en/0/05/FC_Internazionale_Milano_2021.svg", "https://upload.wikimedia.org/wikipedia/commons/b/bc/Juventus_FC_2017_icon_%28black%29.svg", "Mañana 20:45", "Serie A", 2.05, 3.20, 3.80)
        )
    }
}