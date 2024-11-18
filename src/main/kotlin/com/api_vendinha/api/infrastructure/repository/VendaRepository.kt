package com.api_vendinha.api.infrastructure.repository

import com.api_vendinha.api.domain.entities.Venda
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface VendaRepository : CrudRepository<Venda, Long> {

    @Query("SELECT name FROM Produto p WHERE p.name = :name")
    fun findByName(@Param("name") name: String): String

//    @Query("SELECT quantidade FROM Venda v WHERE v.quantidade = :quantidade")
//    fun findByQuantidade(@Param("quantidade") quantidade: Long): Long
}