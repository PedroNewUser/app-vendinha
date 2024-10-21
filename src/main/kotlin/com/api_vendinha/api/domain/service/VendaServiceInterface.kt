package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.VendaRequestDto

interface VendaServiceInterface {
    fun comprar(vendaRequestDto: VendaRequestDto)
}