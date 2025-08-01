package org.example

// Etapa 1: Definición de la Clase
class Fraccion(n: Int, d: Int) : Comparable<Fraccion> {

    var numerador: Int = n
        set(value) {
            field = value
        }

    var denominador: Int = d
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

// Etapa 4: Validaciones y Utilidades

    override operator fun compareTo(otra: Fraccion): Int {
        val diferencia = this.numerador * otra.denominador - otra.numerador * this.denominador
        return diferencia.compareTo(0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this.numerador == other.numerador && this.denominador == other.denominador
    }

    override fun hashCode(): Int {
        return 31 * numerador + denominador
    }

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    fun aDecimal(): Double = numerador.toDouble() / denominador.toDouble()


    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val precision = 1000000
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador)
        }
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

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: ${f1 + f2}")
    println("Resta: ${f1 - f2}")
    println("Multiplicación: ${f1 * f2}")
    println("División: ${f1 / f2}")
    println("¿f1 > f2? ${f1.esMayor(f2)}")
    println("¿f1 < f2? ${f1.esMenor(f2)}")
    println("f1 en decimal: ${f1.aDecimal()}")

    val decimal = 0.75
    val fraccionDecimal = Fraccion.desdeDecimal(decimal)
    println("Decimal $decimal convertido a fracción: $fraccionDecimal")
}
