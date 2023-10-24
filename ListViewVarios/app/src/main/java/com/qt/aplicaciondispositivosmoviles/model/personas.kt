package com.qt.aplicaciondispositivosmoviles.model

class personas (nombre:String, apellidos:String, edad:Int, sexo:String, direccion:String, telefono:String, urlFoto2:String ) {
    var nombre:String
    var apellidos:String
    var edad:Int
    var sexo:String
    var direccion:String
    var telefono:String
    var urlFoto2:String

    init {
        this.nombre = nombre
        this.apellidos = apellidos
        this.edad = edad
        this.sexo = sexo
        this.direccion = direccion
        this.telefono = telefono
        this.urlFoto2 = urlFoto2
    }

}