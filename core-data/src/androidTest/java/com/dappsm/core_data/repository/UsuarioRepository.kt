package com.dappsm.core_data.repository

import com.dappsm.core_data.model.Usuario
import kotlinx.coroutines.flow.Flow

interface UsuarioRepository {
    val usuarioActual: Flow<Usuario?>
    suspend fun registrar(nombreUsuario: String, email: String, contrasena: String): Result<Usuario>
    suspend fun iniciarSesionEmail(email: String, contrasena: String): Result<Usuario>
    suspend fun cerrarSesion()
}
