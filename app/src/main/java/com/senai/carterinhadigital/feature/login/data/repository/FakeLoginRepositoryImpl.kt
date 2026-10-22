package com.senai.carterinhadigital.feature.login.data.repository

import com.senai.carterinhadigital.feature.login.domain.model.PerfilAcesso
import com.senai.carterinhadigital.feature.login.domain.model.UsuarioLogado
import kotlinx.coroutines.delay

class FakeLoginRepositoryImpl : LoginRepository {
    override suspend fun login(
        usuario: String,
        senha: String
    ): Result<UsuarioLogado> {
        delay(1500)
        return if (usuario.equals("aluno", ignoreCase = true) && senha == "123") {
            Result.success(
                UsuarioLogado(
                    id = "123",
                    nome = "Coelho",
                    matricula = "123456",
                    perfil = PerfilAcesso.ALUNO,
                    curso = "Desenvolvimento de Sistemas",
                    turma = "2DEVEST-A",
                    token = "token-fake-vindo-do-sistema"
                )
            )
        } else if (usuario.equals("professor", ignoreCase = true) && senha == "123") {
            Result.success(
                UsuarioLogado(
                    id = "456",
                    nome = "Professor SENAI",
                    matricula = "PROF1234",
                    perfil = PerfilAcesso.PROFESSOR,
                    curso = "",
                    turma = "",
                    token = "token-fake-professor"
                )
            )
        } else {
            Result.failure(
                IllegalArgumentException("Login ou senha inválidos")
            )
        }
    }
}
