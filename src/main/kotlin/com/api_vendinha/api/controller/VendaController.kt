//package com.api_vendinha.api.controller
//
//import com.api_vendinha.api.domain.dtos.request.VendaRequestDto
//import com.api_vendinha.api.domain.service.VendaServiceInterface
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/usuarios")
//class VendaController (
//    val vendaServiceInterface: VendaServiceInterface,
//) {
//
//    @PostMapping("/comprar")
//    fun comprar(@RequestBody vendaRequestDto: VendaRequestDto){
//        return vendaServiceInterface.comprar(vendaRequestDto)
//    }
//
//}