package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProductRequestDtoCompra
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto

interface ProdutoServiceInterface {
    fun save(produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto
    fun update(id: Long, productRequestDto: ProdutoRequestDto): ProdutoResponseDto

    fun listProductVenda(): List<ProdutoResponseDto>
    fun listProduct(): List<ProdutoResponseDto>

    fun comprar(id:Long)
}
