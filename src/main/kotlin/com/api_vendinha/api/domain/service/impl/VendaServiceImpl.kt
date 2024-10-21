package com.api_vendinha.api.domain.service.impl

import com.api_vendinha.api.domain.dtos.request.VendaRequestDto
import com.api_vendinha.api.domain.service.VendaServiceInterface
import com.api_vendinha.api.infrastructure.repository.ProdutoRepository
import com.api_vendinha.api.infrastructure.repository.VendaRepository
import org.springframework.stereotype.Service

@Service
class VendaServiceImpl (
    private val vendaRepository: VendaRepository,
    private val produtoRepository: ProdutoRepository
    ): VendaServiceInterface {
    override fun comprar(vendaRequestDto: VendaRequestDto) {
        val idProduto = vendaRepository.findById(vendaRequestDto.product_id)
        if (vendaRequestDto.product_id.toString() == idProduto.toString()) {
            if (vendaRequestDto.quantidade < vendaRepository.findByQuantidade(vendaRequestDto.quantidade)) {
                produtoRepository.comprar(vendaRequestDto.product_id, vendaRequestDto.quantidade)
            } else {
                println("Quantidade errada!")
            }
        }
    }
}

