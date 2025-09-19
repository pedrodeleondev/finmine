package com.dappsm.core_data.repository

import com.dappsm.core_data.dao.NotaDao
import com.dappsm.core_data.model.Nota
import kotlinx.coroutines.flow.Flow

class DefaultNotaRepository(
    private val dao: NotaDao
) : NotaRepository {

    override fun observarTodas(): Flow<List<Nota>> = dao.observarTodas()

    override fun observarPorId(id: Long): Flow<Nota?> = dao.observarPorId(id)

    override suspend fun guardar(nota: Nota): Long =
        if (nota.id == 0L) dao.insertar(nota) else { dao.actualizar(nota); nota.id }

    override suspend fun eliminar(id: Long) = dao.eliminarPorId(id)
}
