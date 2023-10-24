package com.qt.aplicaciondispositivosmoviles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.text.Editable
import androidx.appcompat.app.AlertDialog
import com.qt.aplicaciondispositivosmoviles.adapters.AutomovilesAdapter
import com.qt.aplicaciondispositivosmoviles.databinding.ActivityMainAutomovilesBinding
import com.qt.aplicaciondispositivosmoviles.model.Automoviles


class MainActivityAutomoviles : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainAutomovilesBinding
    lateinit var listaAutomoviles: ArrayList<Automoviles>
    lateinit var customAdapter: AutomovilesAdapter


    //metodo que se inicializa para mostrar la vista activity_main_automoviles en pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainAutomovilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaAutomoviles = ArrayList()

        customAdapter = AutomovilesAdapter(this, listaAutomoviles)
        binding.listViewAutomoviles.adapter = customAdapter

        binding.buttonIngresar.setOnClickListener(this)
        binding.buttonRegresar.setOnClickListener(this)
    }

    override fun onClick(button: View?) {
        if (button?.id == R.id.buttonIngresar) {
            if (binding.editTextMarca.text.isNotEmpty()
                and binding.editTextPrecio.text.isNotEmpty()
                and binding.editTextNumberModelo.text.isNotEmpty()
                and binding.editTextNumberCilindreje.text.isNotEmpty()
                and binding.editTextNumberPuertas.text.isNotEmpty()
                and binding.editTextColor.text.isNotEmpty()
                and binding.editTextUrl.text.isNotEmpty() ){

                if (binding.editTextNumberCilindreje.text.toString().toInt() > 2000
                    && binding.editTextNumberModelo.text.toString().toInt() < 2000) {
                    showAlertDialog(this, "ERROR", "El carro no puede ser menor a un modelo 2000")
                }

                else {
                    val auto: Automoviles = Automoviles(
                        binding.editTextMarca.text.toString(),
                        binding.editTextPrecio.text.toString().toInt(),
                        binding.editTextNumberModelo.text.toString().toInt(),
                        binding.editTextNumberCilindreje.text.toString().toInt(),
                        binding.editTextNumberPuertas.text.toString().toInt(),
                        binding.editTextColor.text.toString(),
                        binding.editTextUrl.text.toString() );

                    listaAutomoviles.add(auto);

                    customAdapter.notifyDataSetChanged()
                    binding.editTextMarca.text.clear()
                    binding.editTextPrecio.text.clear()
                    binding.editTextNumberModelo.text.clear()
                    binding.editTextNumberCilindreje.text.clear()
                    binding.editTextNumberPuertas.text.clear()
                    binding.editTextColor.text.clear()
                    binding.editTextUrl.text.clear()


                }
            } else {
                showAlertDialog(this, "ERROR", "No deben haber campos vacios.")
            }
        }

        else if (button?.id == R.id.buttonRegresar){
            val intent : Intent = Intent(this, MainActivityBotones::class.java)
            startActivity(intent)
        }
    }

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


/*impresiones de pruebas
Log.i("List", auto.marca);*/
