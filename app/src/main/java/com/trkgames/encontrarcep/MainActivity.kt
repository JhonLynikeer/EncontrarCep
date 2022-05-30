package com.trkgames.encontrarcep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.trkgames.encontrarcep.databinding.ActivityMainBinding
import retrofit2.Call

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        binding.btBuscar.setOnClickListener {
            if (binding.edCep.text.toString().length == 8){
                val intent = Intent(this, RespActivity::class.java)
                intent.putExtra("cep", binding.edCep.text.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"O CEP contem 8 numeros.", Toast.LENGTH_SHORT).show()
            }
        }


    }




}