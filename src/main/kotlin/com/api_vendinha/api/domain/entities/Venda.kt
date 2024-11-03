//package com.api_vendinha.api.domain.entities
//
//import jakarta.persistence.*
//
//@Table(name = "venda")
//@Entity
//data class Venda(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true)
//    val id: Long? = null,
//
//    @Column(name = "preco")
//    var preco: Float,
//
//    @Column(name = "quantidade")
//    var quantidade: Int,
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    var product_id: Produto? = null,
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    var user_id: User? = null,
//
//    )
