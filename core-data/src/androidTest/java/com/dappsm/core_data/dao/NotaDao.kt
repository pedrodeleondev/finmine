package com.dappsm.core_data.dao

import androidx.room.*
import com.dappsm.core_data.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(nota: Nota): Long

    @Update
    suspend fun actualizar(nota: Nota)

    @Delete
    suspend fun eliminar(nota: Nota)

    @Query("DELETE FROM notas WHERE id = :id")
    suspend fun eliminarPorId(id: Long)

    @Query("SELECT * FROM notas ORDER BY actualizadaEn DESC")
    fun observarTodas(): Flow<List<Nota>>

    @Query("SELECT * FROM notas WHERE id = :id LIMIT 1")
    fun observarPorId(id: Long): Flow<Nota?>
}
