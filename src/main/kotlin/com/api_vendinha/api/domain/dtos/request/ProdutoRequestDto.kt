package com.api_vendinha.api.domain.dtos.request

data class ProdutoRequestDto(
    val name: String,
    val preco: Float,
    val quantidade: Long
)
