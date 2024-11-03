package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.service.UserServiceInterface
import com.api_vendinha.api.infrastructure.repository.UserRepository
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
class UserController (
    val userService: UserServiceInterface,
    val userRepository: UserRepository
) {
    @PostMapping("/save")
    fun save(@RequestBody userRequestDto: UserRequestDto) : UserResponseDto {
        // Chama o método `save` do serviço de usuário passando o DTO recebido e retorna o resultado.
        return userService.save(userRequestDto)
    }

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody userRequestDto: UserRequestDto
    ):UserResponseDto{
        return userService.update(id, userRequestDto)
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long):UserResponseDto{
        return userService.findUser(id)
    }

    @PutMapping("/{id}/status/{status}")
    fun changeStatus(
        @PathVariable id: Long,
        @PathVariable status:Boolean
    ):UserResponseDto{
        return userService.changeStatus(id, status)
    }

    @GetMapping("/list")
    fun getAllUser():List<UserResponseDto>{
        val users = userRepository.findAll()

        return users.map {
            UserResponseDto(
                id = it.id,
                name = it.name,
                email = it.email,
                password = it.password,
                cpf_cnpj = it.cpf_cnpj,
                is_active = it.is_active
            )
        }
    }
}
