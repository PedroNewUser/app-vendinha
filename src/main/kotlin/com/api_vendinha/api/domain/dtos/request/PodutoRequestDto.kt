package com.api_vendinha.api.domain.dtos.request

data class PodutoRequestDto(
    val name: String,
    val preco: Float,
    val quantidade: Long,
    val user: Long,
)