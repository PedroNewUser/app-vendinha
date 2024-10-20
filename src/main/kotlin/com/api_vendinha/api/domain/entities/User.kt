package com.api_vendinha.api.domain.entities

import jakarta.persistence.*

// Marca a classe como uma entidade JPA que será mapeada para uma tabela no banco de dados.
// Define que a entidade é associada à tabela "users".
@Table(name = "users")
@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email:String,

    @Column(name = "password")
    var password: String,

    @Column(name = "cpf_cnpj")
    var cpf_cnpj: String,

    @Column(name = "is_active")
    var is_active: Boolean,

    @OneToMany(mappedBy = "user")
    var produtos: List<Produto>? = arrayListOf()
)
