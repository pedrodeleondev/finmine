package com.dappsm.core_data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dappsm.core_data.dao.MovimientoDao
import com.dappsm.core_data.dao.NotaDao
import com.dappsm.core_data.model.Converters
import com.dappsm.core_data.model.Movimiento
import com.dappsm.core_data.model.Nota

@Database(
    entities = [Movimiento::class, Nota::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movimientoDao(): MovimientoDao
    abstract fun notaDao(): NotaDao

    companion object {
        @Volatile private var instancia: AppDatabase? = null

        fun obtener(contexto: Context): AppDatabase =
            instancia ?: synchronized(this) {
                instancia ?: Room.databaseBuilder(
                    contexto.applicationContext,
                    AppDatabase::class.java,
                    "finanzas.db"
                ).build().also { instancia = it }
            }
    }
}
