package com.api_vendinha.api.domain.dtos.response

data class ProdutoResponseDto(

    val id: Long?,
    val name: String,
    val preco: Float,
    val quantidade: Long,
)
