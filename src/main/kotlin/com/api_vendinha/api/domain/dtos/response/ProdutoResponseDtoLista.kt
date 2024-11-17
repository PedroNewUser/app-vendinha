package com.api_vendinha.api.domain.dtos.response

data class ProdutoResponseDtoLista(

    val id: Long?,
    val name: String,
    val preco: Float,
    val quantidade: Long
)
