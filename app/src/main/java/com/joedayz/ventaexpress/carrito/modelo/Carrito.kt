package com.joedayz.ventaexpress.carrito.modelo

data class Carrito(
    var codigoProducto: String,
    var nombreProducto: String,
    var cantidadProducto: Int,
    var imagenProducto: String,
    var precioProducto: String,
    var precioTotalProducto: String,
    var descripcionCorta: String
)