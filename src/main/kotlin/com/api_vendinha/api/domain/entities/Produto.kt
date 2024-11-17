package com.api_vendinha.api.domain.entities

import jakarta.persistence.*


@Table(name = "produtos")
@Entity
data class Produto (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "preco")
    var preco: Float,

    @Column(name = "quantidade")
    var quantidade: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null,
)

