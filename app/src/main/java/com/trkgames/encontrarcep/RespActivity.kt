package com.trkgames.encontrarcep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import com.trkgames.encontrarcep.databinding.ActivityMainBinding

import com.trkgames.encontrarcep.databinding.ActivityRespBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL




class RespActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRespBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRespBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        getCep(intent.getStringExtra("cep").toString())
        binding.btFechar.setOnClickListener {
            finish()
        }

    }

    private fun getCep(cep: String){

        val url = "https://viacep.com.br/ws/$cep/json/"
        GlobalScope.launch(Dispatchers.Default) {
            val url = URL(url)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connectTimeout = 7000
            val content = urlConnection.inputStream.bufferedReader().use(BufferedReader::readText)
            var json = JSONObject(content)
            launch(Dispatchers.Main) {
               Anime().tradeView(binding.progressBar, binding.cepResp)
                if (json.has("erro")){
                    binding.cepResp.text = "Erro no Cep"
                }
                else{
                    val cep = json.getString("cep")
                    val logradouro = json.getString("logradouro")
                    val bairro = json.getString("bairro")
                    val cidade = json.getString("localidade")
                    val estado = json.getString("uf")
                    binding.cepResp.text = "Cep: $cep \nRua: $logradouro \nBairro: $bairro \nCidade: $cidade \nEstado: $estado"
            }

        }
        }



    }



}