package co.mz.enigma.jetpackcompose.ui.theme

import java.text.DecimalFormat


fun calcularIMC(peso: Double, altura: Double): Double {
    val decimalFormat = DecimalFormat("0.00")
 var imc:Double = (peso / (altura * altura))
    return decimalFormat.format(imc).toString().toDouble()
}

fun mostrarResultadoIMC(imc: Double ):String {
    println("Seu IMC é: $imc")
    return when {
        imc < 18.5 ->  "Você está abaixo do peso."
        imc >= 18.5 && imc < 24.9 -> "Seu peso está dentro da faixa saudável."
        imc >= 25 && imc < 29.9 -> "Você está com sobrepeso."
        imc >= 30 && imc < 34.9 -> "Você está com obesidade grau I."
        imc >= 35 && imc < 39.9 -> "Você está com obesidade grau II."
        else -> "Você está com obesidade grau III ou mórbida."
    }
}

