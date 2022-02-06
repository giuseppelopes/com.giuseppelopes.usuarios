package com.giuseppelopes.usuarios.api

import com.giuseppelopes.usuarios.domain.Usuario
import com.giuseppelopes.usuarios.dto.UsuarioDTO
import com.giuseppelopes.usuarios.service.IUsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UsuarioController(val iUsuarioService: IUsuarioService) {

    @GetMapping("/v1/usuarios")
    fun getAllUsuarios(@RequestParam(value = "nome", required = false) nome: String?): ResponseEntity<List<Usuario>> {
        return if(nome != null){
            ResponseEntity.ok(iUsuarioService.findUsuario(nome))
        } else ResponseEntity.ok(iUsuarioService.getAll())
    }

    @PostMapping("/v1/usuarios", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody usuario: UsuarioDTO){
        iUsuarioService.add(usuario)
    }

    @DeleteMapping("/v1/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable(value = "id", required = true) id: Int){
        iUsuarioService.delete(id)
    }
}