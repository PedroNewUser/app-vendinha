package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDtoLista

interface ProdutoServiceInterface {
    fun save(produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto
    fun update(id: Long, productRequestDto: ProdutoRequestDto): ProdutoResponseDto

    fun listProduct(): List<ProdutoResponseDtoLista>

}
