package org.example

// Etapa 1: Definición de la Clase
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

    init {
        if (d == 0) throw IllegalArgumentException("El denominador no puede ser cero")
        simplificar()
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun mostrar() {
        println(this.toString())
    }

// Etapa 2: Suma y Resta de Fracciones

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

// Etapa 3: Multiplicación y División de Fracciones

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        if (otra.numerador == 0) throw IllegalArgumentException("No se puede dividir por una fracción con numerador 0")
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    private fun simplificar() {
        val mcd = mcd(Math.abs(numerador), Math.abs(denominador))
        numerador /= mcd
        denominador /= mcd

        if (denominador < 0) {
            numerador *= -1
            denominador *= -1
        }
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }
}

fun main() {
    println("Hola app!")

    val f1 = Fraccion(2, 5)
    val f2 = Fraccion(1, 10)

    val suma = f1 + f2
    val resta = f1 - f2
    val multiplicacion = f1 * f2
    val division = f1 / f2

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $suma")
    println("Resta: $resta")
    println("Multiplicación: $multiplicacion")
    println("División: $division")
}
