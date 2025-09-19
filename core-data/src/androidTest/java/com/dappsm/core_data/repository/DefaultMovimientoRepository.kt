package com.dappsm.core_data.repository

import com.dappsm.core_data.dao.MovimientoDao
import com.dappsm.core_data.model.Movimiento
import com.dappsm.core_data.model.MovimientoTipo
import com.dappsm.core_data.model.ResumenMensual
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class DefaultMovimientoRepository(
    private val dao: MovimientoDao
) : MovimientoRepository {

    override fun observarTodos(): Flow<List<Movimiento>> = dao.observarTodos()

    override fun observarPorId(id: Long): Flow<Movimiento?> = dao.observarPorId(id)

    override fun observarPorMes(anio: Int, mes: Int): Flow<List<Movimiento>> =
        dao.observarPorMes(anio, mes)

    override fun observarResumenMensual(anio: Int, mes: Int): Flow<ResumenMensual> {
        val ingresos = dao.observarTotalMensual(anio, mes, MovimientoTipo.INGRESO)
        val egresos = dao.observarTotalMensual(anio, mes, MovimientoTipo.EGRESO)
        return ingresos.combine(egresos) { inc, eg ->
            ResumenMensual(anio, mes, inc, eg)
        }
    }

    override suspend fun guardar(movimiento: Movimiento): Long =
        if (movimiento.id == 0L) dao.insertar(movimiento) else { dao.actualizar(movimiento); movimiento.id }

    override suspend fun eliminar(id: Long) = dao.eliminarPorId(id)
}
