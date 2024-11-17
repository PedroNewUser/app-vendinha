package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.PodutoRequestDto
import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDtoLista
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProdutoServiceInterface {
    fun save(podutoRequestDto: PodutoRequestDto): ProdutoResponseDto
    fun update(id: Long, productRequestDto: PodutoRequestDto): ProdutoResponseDto

    fun listProduct(): List<ProdutoResponseDtoLista>

}
