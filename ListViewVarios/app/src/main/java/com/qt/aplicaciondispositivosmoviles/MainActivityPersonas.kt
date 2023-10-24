package com.qt.aplicaciondispositivosmoviles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.qt.aplicaciondispositivosmoviles.adapters.personasAdapter
import com.qt.aplicaciondispositivosmoviles.databinding.ActivityMainPersonasBinding
import com.qt.aplicaciondispositivosmoviles.model.personas

class MainActivityPersonas : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainPersonasBinding
    lateinit var listaPersonas : ArrayList<personas>
    lateinit var customAdapter2 : personasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaPersonas = ArrayList()

        customAdapter2 = personasAdapter(this, listaPersonas )
        binding.listViewPersonas.adapter = customAdapter2

        binding.buttonIngresar2.setOnClickListener(this)
        binding.buttonRegresar2.setOnClickListener(this)

    }

    override fun onClick(button2: View?) {
        if(button2?.id == R.id.buttonIngresar2){
            if(binding.editTextNombre.text.isNotEmpty()
                and binding.editTextApellidos.text.isNotEmpty()
                and binding.editTextEdad.text.isNotEmpty()
                and binding.editTextSexo.text.isNotEmpty()
                and binding.editTextDireccion.text.isNotEmpty()
                and binding.editTextTelefono.text.isNotEmpty()
                and binding.editTextUrlImagen.text.isNotEmpty()){

                Log.i("LOG", binding.editTextTelefono.toString());

                val persona : personas = personas(
                    binding.editTextNombre.text.toString(),
                    binding.editTextApellidos.text.toString(),
                    binding.editTextEdad.text.toString().toInt(),
                    binding.editTextSexo.text.toString(),
                    binding.editTextDireccion.text.toString(),
                    binding.editTextTelefono.text.toString(),
                    binding.editTextUrlImagen.text.toString() )

                listaPersonas.add(persona)

                customAdapter2.notifyDataSetChanged()

                binding.editTextNombre.text.clear()
                binding.editTextApellidos.text.clear()
                binding.editTextEdad.text.clear()
                binding.editTextSexo.text.clear()
                binding.editTextDireccion.text.clear()
                binding.editTextTelefono.text.clear()
                binding.editTextUrlImagen.text.clear()
            }

            else{
                showAlertDialog(this, "ERROR", "no deben haber campos vacios")
            }
        }

        else if (button2?.id == R.id.buttonRegresar2){
            val intent : Intent = Intent(this, MainActivityBotones::class.java)
            startActivity(intent)
        }



    }


//funcion para mostrar alguna condicion que no se cupla en los editText
    fun showAlertDialog(context: Context, title: String, message: String) {
        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)

        // Configura el botón "Aceptar"
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.dismiss()
        }

        // Crea y muestra el AlertDialog
        val alertDialog = builder.create()
        alertDialog.show()
    }
}