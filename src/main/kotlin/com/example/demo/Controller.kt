package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.relational.core.mapping.Table
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping

@RestController
class Controller(val service: MessageService) {
    @GetMapping("/messages")
    fun index(): List<Message> = service.findMessages()

    @RequestMapping("/Test")
    fun index(model : Model):String{
        return "house"
    }

    @PostMapping("/messages")
    fun post(@RequestBody message: Message){
        service.post(message)
    }
}

@Table("messages")
data class Message(@Id val id: String?, val passwords: String)