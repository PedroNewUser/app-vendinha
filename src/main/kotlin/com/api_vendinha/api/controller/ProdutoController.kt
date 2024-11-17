package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.PodutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDtoLista
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.service.ProdutoServiceInterface
import com.api_vendinha.api.infrastructure.repository.ProdutoRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/produto")
class ProdutoController (
    val produtoServiceInterface: ProdutoServiceInterface
) {

    @PostMapping("/save")
    fun save(@RequestBody podutoRequestDto: PodutoRequestDto): ProdutoResponseDto {
        return produtoServiceInterface.save(podutoRequestDto)
    }

    @GetMapping("/list")
    fun getAllProduct(): List<ProdutoResponseDtoLista> {
        return produtoServiceInterface.listProduct()
    }

    @PutMapping("/update/{id}")
    fun putProduct(
        @PathVariable id: Long,
        @RequestBody productRequestDto: PodutoRequestDto
    ):ProdutoResponseDto{
        return produtoServiceInterface.update(id, productRequestDto)
    }
}
