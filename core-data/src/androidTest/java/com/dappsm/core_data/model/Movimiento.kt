package com.dappsm.core_data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "movimientos",
    indices = [
        Index(value = ["anio","mes"]),
        Index(value = ["fechaHora"]),
        Index(value = ["tipo"])
    ]
)
data class Movimiento(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val tipo: MovimientoTipo,
    val cantidadCentavos: Long,
    val categoria: String? = null,
    val descripcion: String? = null,
    val fechaHora: LocalDateTime = LocalDateTime.now(),
    val anio: Int = fechaHora.year,
    val mes: Int = fechaHora.monthValue
)
