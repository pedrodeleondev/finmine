package com.dappsm.core_data.dao

import androidx.room.*
import com.dappsm.core_data.model.Movimiento
import com.dappsm.core_data.model.MovimientoTipo
import kotlinx.coroutines.flow.Flow

@Dao
interface MovimientoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(movimiento: Movimiento): Long

    @Update
    suspend fun actualizar(movimiento: Movimiento)

    @Delete
    suspend fun eliminar(movimiento: Movimiento)

    @Query("DELETE FROM movimientos WHERE id = :id")
    suspend fun eliminarPorId(id: Long)

    @Query("SELECT * FROM movimientos ORDER BY fechaHora DESC")
    fun observarTodos(): Flow<List<Movimiento>>

    @Query("SELECT * FROM movimientos WHERE id = :id LIMIT 1")
    fun observarPorId(id: Long): Flow<Movimiento?>

    @Query("""
        SELECT * FROM movimientos
        WHERE anio = :anio AND mes = :mes
        ORDER BY fechaHora DESC
    """)
    fun observarPorMes(anio: Int, mes: Int): Flow<List<Movimiento>>

    @Query("""
        SELECT COALESCE(SUM(cantidadCentavos),0) FROM movimientos
        WHERE anio = :anio AND mes = :mes AND tipo = :tipo
    """)
    fun observarTotalMensual(anio: Int, mes: Int, tipo: MovimientoTipo): Flow<Long>
}
