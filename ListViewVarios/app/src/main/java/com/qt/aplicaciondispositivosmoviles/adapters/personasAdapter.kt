package com.qt.aplicaciondispositivosmoviles.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import coil.load
import com.qt.aplicaciondispositivosmoviles.databinding.ViewPersonasBinding
import com.qt.aplicaciondispositivosmoviles.model.personas

class personasAdapter(val contexEntrada : Context, val listaPersonasEntrada : ArrayList<personas>) : BaseAdapter() {
    var context:Context
    var listaPersonas:ArrayList<personas>

    init {
        this.context = contexEntrada
        this.listaPersonas = listaPersonasEntrada
    }

    override fun getCount(): Int {
        val sizeList = this.listaPersonas.size
        return sizeList
    }

    override fun getItem(position: Int): Any {
        val itemList = listaPersonas.get(position)
        return itemList
    }

    override fun getItemId(posicion: Int): Long {
        val itemId = posicion.toLong()
        return itemId

    }

    override fun getView(position: Int,convertView: View?, parent: ViewGroup?): View {

        var binding = ViewPersonasBinding.inflate(LayoutInflater.from(parent?.context),parent,false)

        val personaActual = listaPersonas.get(position)

        binding.textViewNombre.text = personaActual.nombre
        binding.textViewApellidos.text = personaActual.apellidos
        binding.textViewEdad.text = personaActual.edad.toString()
        binding.textViewSexo.text = personaActual.sexo
        binding.textViewDireccion.text = personaActual.direccion
        binding.textViewTelefono.text = personaActual.telefono.toString()
        binding.imageViewFoto.load(personaActual.urlFoto2)

        return binding.root
    }
}