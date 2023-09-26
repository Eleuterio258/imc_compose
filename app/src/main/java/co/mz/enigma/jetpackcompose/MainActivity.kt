package co.mz.enigma.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.mz.enigma.jetpackcompose.ui.theme.calcularIMC
import co.mz.enigma.jetpackcompose.ui.theme.mostrarResultadoIMC


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImcPage()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeiraTela() {


    val usuario = Usuario(
        nome = "João",
        sobrenome = "Silva",
        endereco = "Rua 1",
        telefone = "123456789",
        email = "j4n1w@example.com"
    )
    Scaffold(
        Modifier.background(Color.Red),
        topBar = {
            TopAppBar(title = { Text("Top app bar")},


                )
        },

        ){
            Column(modifier = Modifier
                .background(Color.White)
                .fillMaxWidth() // lagura total da tela
                .fillMaxHeight() // altura total da tela
                , verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "NOME:" + usuario.nome)
                Text(text = "SOBRENOME:" + usuario.sobrenome)
                Text(text = "ENDEREÇO:" + usuario.endereco)
                Text(text = "TELEFONE:" + usuario.telefone)
                Text(text = "EMAIL:" + usuario.email)
                Row( ) {
                    Text(text = "Nome: ",
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Blue

                        )
                    Text(text = usuario.nome)

                }

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcPage( ) {

    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var imcCalc by remember { mutableStateOf(0.0) }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(text = "Calculadora de IMC", modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        OutlinedTextField(
            label = {
                Text(text = "Altura")
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp),
            value = altura,
            onValueChange ={
                altura = it
        } )

        OutlinedTextField(
            label = {
                Text(text = "Peso")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp),
            value = peso, onValueChange ={
                peso =it
            } )
        
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp),
            onClick = {
                if(  peso.isNotEmpty()&&altura.isNotEmpty()){
                    imcCalc=calcularIMC(peso.toDouble(), altura.toDouble())
                 resultado =   mostrarResultadoIMC(imcCalc)
                }else{
                    imcCalc=0.0
                }

            }) {
            Text(text = "Calcular")
            
        }
        Text(
            text = "IMC: $imcCalc",
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta,
        )
        Text(text = "Resultado $resultado",
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            )
    }

}


