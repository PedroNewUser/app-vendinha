package com.api_vendinha.api.domain.service.impl

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDtoLista
import com.api_vendinha.api.domain.entities.Produto
import com.api_vendinha.api.domain.service.ProdutoServiceInterface
import com.api_vendinha.api.infrastructure.repository.ProdutoRepository
import com.api_vendinha.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ProdutoServiceImpl (
    private val produtoRepository: ProdutoRepository,
    private val userRepository: UserRepository
): ProdutoServiceInterface {
    override fun save(produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto {

        val  produto = produtoRepository.save(
            Produto(
                name = produtoRequestDto.name,
                preco = produtoRequestDto.preco,
                quantidade = produtoRequestDto.quantidade,
            )
        )

        return  ProdutoResponseDto(
            id = produto.id,
            name =produto.name,
            preco = produto.preco,
            quantidade = produto.quantidade
        )
    }

    override fun update(id: Long, productRequestDto: ProdutoRequestDto): ProdutoResponseDto {

        val produto = produtoRepository.findById(id).orElseThrow {
            IllegalArgumentException("Erro");
        }
        produto.name = productRequestDto.name
        produto.quantidade = productRequestDto.quantidade
        produto.preco = productRequestDto.preco


        val produtoUpdate = produtoRepository.save(produto)

        return ProdutoResponseDto(
            id = produtoUpdate.id,
            name = produtoUpdate.name,
            preco = produtoUpdate.preco,
            quantidade = produtoUpdate.quantidade,

        )
    }

    override fun listProduct(): List<ProdutoResponseDtoLista> {
        val produto = produtoRepository.findAll()

        return produto.map {
            ProdutoResponseDtoLista(
                id = it.id,
                name = it.name,
                quantidade = it.quantidade,
                preco = it.preco
            )
        }
    }

}
