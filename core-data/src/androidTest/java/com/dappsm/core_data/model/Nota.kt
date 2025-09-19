package com.dappsm.core_data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "notas",
    indices = [Index(value = ["actualizadaEn"])]
)
data class Nota(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val titulo: String? = null,
    val contenido: String,
    val creadaEn: LocalDateTime = LocalDateTime.now(),
    val actualizadaEn: LocalDateTime = creadaEn
)
