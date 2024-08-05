package com.example.passmoo.GeneratorPage

import java.security.SecureRandom


class PasswordBuilder() {
    private var charset: List<Char> = emptyList()
    fun login() {
    }

    fun digit() {
        charset += ('1'..'9')

    }

    fun symbol() {
        charset += listOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')')
    }

    fun upper() {
        charset += ('A'..'Z')
    }

    fun lower() {
        charset += ('a'..'z')
    }

    fun unlogin() {
    }

    fun undigit() {
        charset = charset.filter { it !in ('1'..'9') }
    }

    fun unsymbol() {
        charset = charset.filter { it !in listOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')') }
    }

    fun unupper() {
        charset = charset.filter { it !in ('A'..'Z') }
    }

    fun unlower() {
        charset = charset.filter { it !in ('a'..'z') }
    }

    fun generate(length: Int): String {
        val secureRandom = SecureRandom()
        return (1..length)
            .map { charset[secureRandom.nextInt(charset.size)] }
            .joinToString("")
    }
    fun getCharSetSize(): Double = charset.size.toDouble()

}