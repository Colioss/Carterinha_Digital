package com.senai.carterinhadigital.feature.professor.turma.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carterinhadigital.feature.professor.turma.domain.repository.ProfessorTurmaRepository
import com.senai.carterinhadigital.feature.professor.turma.presentation.TurmaViewModel

class TurmaViewModelFactory(
    private val repository: ProfessorTurmaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmaViewModel::class.java)) {
            return TurmaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
