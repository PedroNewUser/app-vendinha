package com.api_vendinha.api.domain.service.impl

import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.entities.User
import com.api_vendinha.api.domain.service.UserServiceInterface
import com.api_vendinha.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
): UserServiceInterface {

    override fun save(userRequestDto: UserRequestDto): UserResponseDto {
        // Cria uma nova instância da entidade User usando os dados do DTO.
        val user = userRepository.save(
            User(
                // Define o nome do usuário a partir dos dados fornecidos no DTO.
                name = userRequestDto.name,
                email = userRequestDto.email,
                password = userRequestDto.password,
                cpf_cnpj = userRequestDto.cpf_cnpj,
                is_active = userRequestDto.is_active
            )
        )

        // Cria e retorna um UserResponseDto com o ID e nome do usuário salvo.
        return UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password,
            cpf_cnpj = user.cpf_cnpj,
            is_active = user.is_active
        )
    }

    override fun update(id:Long, userRequestDto: UserRequestDto): UserResponseDto{
        val user = userRepository.findById(id).orElseThrow {
            IllegalArgumentException("Erro");
        }
        user.name = userRequestDto.name
        user.email = userRequestDto.email
        user.password = userRequestDto.password
        user.cpf_cnpj = userRequestDto.cpf_cnpj
        user.is_active = userRequestDto.is_active

        val userUpdate = userRepository.save(user)

        return UserResponseDto(
            id = userUpdate.id,
            name = userUpdate.name,
            email = userUpdate.email,
            password = userUpdate.password,
            cpf_cnpj = userUpdate.cpf_cnpj,
            is_active = userUpdate.is_active
        )
    }

    override fun findUser(id: Long): UserResponseDto {
        val user = userRepository.findById(id).orElseThrow {
            IllegalArgumentException("Erro");
        }

        return UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password,
            cpf_cnpj = user.cpf_cnpj,
            is_active = user.is_active
        )
    }

    override fun changeStatus(id: Long, status:Boolean): UserResponseDto {
        val user = userRepository.findById(id).orElseThrow {
            IllegalArgumentException("Erro");
        }

        user.is_active = status

        val userUpdate = userRepository.save(user)

        return UserResponseDto(
            id = userUpdate.id,
            name = userUpdate.name,
            email = userUpdate.email,
            password = userUpdate.password,
            cpf_cnpj = userUpdate.cpf_cnpj,
            is_active = userUpdate.is_active
        )
    }
}
