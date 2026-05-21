package com.senai.carterinhadigital.feature.unidadecurricular.data

import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

fun dataSource () : List<UnidadeCurricular> {
    return listOf(
UnidadeCurricular(id = "1", nome = "Matemática", professor = "Dr. Silva", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 2),
    UnidadeCurricular(id = "2", nome = "Português", professor = "Dr. Pablo", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 0),
    UnidadeCurricular(id = "3", nome = "História", professor = "Dr. Hamood", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 1),
    UnidadeCurricular(id = "4", nome = "Geografia", professor = "Dr. Habibi", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 5),
    UnidadeCurricular(id = "5", nome = "Biologia", professor = "Dr. Ahmad", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 3),
    UnidadeCurricular(id = "6", nome = "Física", professor = "Dr. Cléber", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 2),
    UnidadeCurricular(id = "7", nome = "Ciências", professor = "Dr. Rogério", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 2),
    UnidadeCurricular(id = "8", nome = "Farmação de Aura", professor = "Dr. Sixvanilson Sevenaldo", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 1)
    )
}