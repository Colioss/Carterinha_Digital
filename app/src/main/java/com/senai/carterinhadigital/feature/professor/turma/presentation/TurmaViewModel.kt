package com.senai.carterinhadigital.feature.professor.turma.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.carterinhadigital.feature.professor.turma.domain.repository.ProfessorTurmaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TurmaViewModel(
    private val repository: ProfessorTurmaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TurmaUiState())
    val uiState: StateFlow<TurmaUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.listarTurmas()
                .onSuccess { turmas ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            turmas = turmas,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar turmas."
                        )
                    }
                }
        }
    }
}
