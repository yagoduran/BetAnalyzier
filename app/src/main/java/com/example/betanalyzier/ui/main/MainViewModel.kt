package com.example.betanalyzier.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betanalyzier.data.model.Match
import com.example.betanalyzier.data.repository.MatchRepository
import com.example.betanalyzier.utils.BetAnalyzer
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = MatchRepository()

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> get() = _matches

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadMatches() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.fetchMatches()
            
            // Apply analysis to each match
            result.forEach { match ->
                match.recommendation = BetAnalyzer.analyze(match.oddsHome, match.oddsDraw, match.oddsAway)
            }
            
            _matches.value = result
            _isLoading.value = false
        }
    }
}