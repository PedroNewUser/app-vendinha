package com.api_vendinha.api.domain.service.impl

import com.api_vendinha.api.domain.dtos.request.PodutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
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
    override fun save(podutoRequestDto: PodutoRequestDto): ProdutoResponseDto {

        var user = userRepository.findById(podutoRequestDto.user).orElseThrow();

        val  produto = produtoRepository.save(
            Produto(
                name = podutoRequestDto.name,
                preco = podutoRequestDto.preco,
                quantidade = podutoRequestDto.quantidade,
                user = user
            )
        )

        return  ProdutoResponseDto(
            id = produto.id,
            name=produto.name,
            preco = produto.preco,
            quantidade = produto.quantidade,
            user = UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email,
                password = user.password,
                cpf_cnpj = user.cpf_cnpj,
                is_active = user.is_active
            )
        )
    }

}
