package com.qt.aplicaciondispositivosmoviles.model

class Automoviles (marca :String, precio : Int, modelo : Int, cilindraje : Int, numeroPuertas : Int, color :String, urlFoto : String ){
var marca : String
var precio : Int
var modelo :Int
var cilindraje : Int
var numeroPuertas : Int
var color :String
var urlFoto : String

//inicializar atributos(dar valores)
init {
    this.marca = marca
    this.precio = precio
    this.modelo = modelo
    this.cilindraje = cilindraje
    this.numeroPuertas = numeroPuertas
    this.color = color
    this.urlFoto = urlFoto
}



}
