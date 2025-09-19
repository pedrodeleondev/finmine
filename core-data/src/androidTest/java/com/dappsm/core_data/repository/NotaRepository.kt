package com.dappsm.core_data.repository

import com.dappsm.core_data.model.Nota
import kotlinx.coroutines.flow.Flow

interface NotaRepository {
    fun observarTodas(): Flow<List<Nota>>
    fun observarPorId(id: Long): Flow<Nota?>
    suspend fun guardar(nota: Nota): Long
    suspend fun eliminar(id: Long)
}
