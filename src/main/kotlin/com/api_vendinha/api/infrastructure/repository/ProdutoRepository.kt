package com.api_vendinha.api.infrastructure.repository

import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto
import com.api_vendinha.api.domain.entities.Produto
import com.api_vendinha.api.domain.entities.User
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ProdutoRepository : CrudRepository<Produto, Long>{

    @Query("SELECT name FROM Produto p WHERE p.name = :name")
    fun findByName(@Param("name") name: String): String

    @Modifying
    @Transactional
    @Query("UPDATE Produto AS p INNER JOIN Vendas AS v ON p.id = v.product_id" +
            "SET p.quantidade  = p.quantidade - :quantidade WHERE p.id = v.product_id;")
    fun comprar(@Param("product_id") product_id:Long ,@Param("quantidade") quantidade:Long)

}
