package org.example
///Etapa 1: Definición de la Clase

class Fraccion(n: Int, d: Int) {

    var numerador: Int = n
        get() = field
        set(value) {
            field = value
        }

    var denominador: Int = d
        get() = field
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun mostrar() {
        println(this.toString())
    }
}

fun main() {
    println("Hola app!") 

    val f = Fraccion(2, 5)
    f.mostrar()
}

