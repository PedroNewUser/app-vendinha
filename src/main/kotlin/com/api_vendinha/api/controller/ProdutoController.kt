package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.ProductRequestDtoCompra
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.entities.Venda
import com.api_vendinha.api.domain.service.ProdutoServiceInterface
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
class ProdutoController (
    val produtoServiceInterface: ProdutoServiceInterface
) {

    @PostMapping("/save")
    fun save(@RequestBody produtoRequestDto: ProdutoRequestDto): ProdutoResponseDto {
        return produtoServiceInterface.save(produtoRequestDto)
    }

    @GetMapping("/list")
    fun getAllProduct(): List<ProdutoResponseDto> {
        return produtoServiceInterface.listProduct()
    }

    @PutMapping("/update/{id}")
    fun putProduct(
        @PathVariable id: Long,
        @RequestBody productRequestDto: ProdutoRequestDto
    ):ProdutoResponseDto{
        return produtoServiceInterface.update(id, productRequestDto)
    }

    //Comprar Produto
    @PostMapping("/comprar")
    fun comprarProduto(@RequestBody productRequestDtoCompra: ProductRequestDtoCompra){
        return produtoServiceInterface.comprar(productRequestDtoCompra)
    }

    //Listar Vendas
    @GetMapping("/list/vendas")
    fun listarVenda():List<ProdutoResponseDto>{
        return produtoServiceInterface.listProductVenda()
    }
}
