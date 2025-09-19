package com.dappsm.core_data.model

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromDate(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it, formatter) }
    }

    @TypeConverter
    fun dateToString(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }

    @TypeConverter
    fun fromTipo(value: String?): MovimientoTipo? {
        return value?.let { MovimientoTipo.valueOf(it) }
    }

    @TypeConverter
    fun tipoToString(tipo: MovimientoTipo?): String? {
        return tipo?.name
    }
}
