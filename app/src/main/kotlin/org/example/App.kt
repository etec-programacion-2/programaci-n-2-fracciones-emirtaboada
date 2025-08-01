package org.example

import java.util.InputMismatchException
import java.util.Scanner

fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    println("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
    while (true) {
        try {
            println(mensaje)
            print("Numerador: ")
            val numerador = scanner.nextInt()
            print("Denominador: ")
            val denominador = scanner.nextInt()
            return Fraccion(numerador, denominador)
        } catch (e: InputMismatchException) {
            println("Entrada inválida. Ingrese números enteros.")
            scanner.nextLine()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            scanner.nextLine()
        }
    }
}

fun realizarSuma(scanner: Scanner) {
    try {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
        println("Resultado: $f1 + $f2 = ${f1 + f2}")
    } catch (e: Exception) {
        println("Error durante la suma: ${e.message}")
    }
}

fun realizarResta(scanner: Scanner) {
    try {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
        println("Resultado: $f1 - $f2 = ${f1 - f2}")
    } catch (e: Exception) {
        println("Error durante la resta: ${e.message}")
    }
}

fun realizarMultiplicacion(scanner: Scanner) {
    try {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
        println("Resultado: $f1 * $f2 = ${f1 * f2}")
    } catch (e: Exception) {
        println("Error durante la multiplicación: ${e.message}")
    }
}

fun realizarDivision(scanner: Scanner) {
    try {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
        println("Resultado: $f1 / $f2 = ${f1 / f2}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    } catch (e: Exception) {
        println("Error durante la división: ${e.message}")
    }
}

fun realizarComparacion(scanner: Scanner) {
    try {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")
        when {
            f1 > f2 -> println("$f1 es mayor que $f2")
            f1 < f2 -> println("$f1 es menor que $f2")
            else -> println("$f1 es igual a $f2")
        }
    } catch (e: Exception) {
        println("Error durante la comparación: ${e.message}")
    }
}

fun convertirADecimal(scanner: Scanner) {
    try {
        val f = leerFraccion(scanner, "Ingrese la fracción a convertir:")
        println("$f en decimal es ${f.aDecimal()}")
    } catch (e: Exception) {
        println("Error en la conversión: ${e.message}")
    }
}

fun crearDesdeDecimal(scanner: Scanner) {
    while (true) {
        try {
            print("Ingrese un número decimal: ")
            val decimal = scanner.nextDouble()
            val fraccion = Fraccion.desdeDecimal(decimal)
            println("Fracción equivalente: $fraccion")
            break
        } catch (e: InputMismatchException) {
            println("Entrada inválida. Ingrese un número decimal.")
            scanner.nextLine()
        } catch (e: Exception) {
            println("Error creando fracción desde decimal: ${e.message}")
            scanner.nextLine()
        }
    }
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")

    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
}

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int

    do {
        mostrarMenu()
        try {
            opcion = scanner.nextInt()

            when (opcion) {
                1 -> realizarSuma(scanner)
                2 -> realizarResta(scanner)
                3 -> realizarMultiplicacion(scanner)
                4 -> realizarDivision(scanner)
                5 -> realizarComparacion(scanner)
                6 -> convertirADecimal(scanner)
                7 -> crearDesdeDecimal(scanner)
                8 -> mostrarEjemplos()
                0 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Intente de nuevo.")
            }
        } catch (e: InputMismatchException) {
            println("Entrada inválida. Por favor, ingrese un número entero.")
            scanner.nextLine()
            opcion = -1
        } catch (e: Exception) {
            println("Error inesperado: ${e.message}")
            scanner.nextLine()
            opcion = -1
        }

        if (opcion != 0) {
            println("\nPresione Enter para continuar...")
            try {
                System.`in`.read()
            } catch (e: Exception) {
                println("No se pudo esperar Enter: ${e.message}")
            }
        }
    } while (opcion != 0)

    scanner.close()
}
