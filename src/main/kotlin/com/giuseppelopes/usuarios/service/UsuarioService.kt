package com.giuseppelopes.usuarios.service

import com.giuseppelopes.usuarios.domain.Usuario
import com.giuseppelopes.usuarios.dto.UsuarioDTO
import org.springframework.stereotype.Component

@Component
class UsuarioService : IUsuarioService {

    private var usuarios: MutableList<Usuario> =
        mutableListOf(
            Usuario(1, "Giuseppe", "1234"),
            Usuario(2, "Anita", "5678"),
            Usuario(3, "Ana", "45664"),
            Usuario(4, "Ana", "12312"))

    override fun getUsuario(id: Int): Usuario? {
        return usuarios.get(id)
    }

    override fun findUsuario(nome: String): List<Usuario>? {
        return usuarios.filter { it.nome.equals(nome)}
    }

    override fun getAll(): List<Usuario> {
        return usuarios
    }

    override fun add(usuario: UsuarioDTO) {
        if (usuario.id > 0 && usuario.nome.length > 0 && usuario.senha.length > 0){
            usuarios.add(Usuario(usuario.id, usuario.nome, usuario.senha))
        }
    }

    override fun delete(id: Int){
        usuarios.removeIf{it.id == id}
    }
}