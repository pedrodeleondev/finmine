package com.dappsm.core_data.repository

import com.dappsm.core_data.model.Movimiento
import com.dappsm.core_data.model.ResumenMensual
import kotlinx.coroutines.flow.Flow

interface MovimientoRepository {
    fun observarTodos(): Flow<List<Movimiento>>
    fun observarPorId(id: Long): Flow<Movimiento?>
    fun observarPorMes(anio: Int, mes: Int): Flow<List<Movimiento>>
    fun observarResumenMensual(anio: Int, mes: Int): Flow<ResumenMensual>
    suspend fun guardar(movimiento: Movimiento): Long
    suspend fun eliminar(id: Long)
}
