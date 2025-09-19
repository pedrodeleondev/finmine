package com.dappsm.core_data.model

data class ResumenMensual(
    val anio: Int,
    val mes: Int,
    val ingresosCentavos: Long,
    val egresosCentavos: Long
) {
    val balanceCentavos: Long get() = ingresosCentavos - egresosCentavos
}
