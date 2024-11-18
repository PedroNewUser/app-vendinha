package com.api_vendinha.api.domain.dtos.request

data class ProductRequestDtoCompra (
    val id: Long,
    val name: String,
    val preco: Float,
    val quantidade: Long
)

