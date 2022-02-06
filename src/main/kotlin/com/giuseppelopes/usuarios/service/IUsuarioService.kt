package com.giuseppelopes.usuarios.service

import com.giuseppelopes.usuarios.domain.Usuario
import com.giuseppelopes.usuarios.dto.UsuarioDTO

interface IUsuarioService {
    fun getUsuario(id: Int): Usuario?
    fun findUsuario(nome: String): List<Usuario>?
    fun getAll(): List<Usuario>
    fun add(usuario: UsuarioDTO)
    fun delete(id: Int)
}