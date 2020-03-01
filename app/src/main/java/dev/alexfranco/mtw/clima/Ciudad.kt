package dev.alexfranco.mtw.clima

//class Ciudad (nombre:String, grados:Int, status:String){
//    var nombre: String = ""
//    var grados: Int = 0
//    var status: String = ""
//
//    init{
//        this.nombre = nombre
//        this.grados = grados
//        this.status = status
//    }
//}

class Ciudad (name:String, weather:ArrayList<Weather>, main:Main){
    var name: String = ""
    var weather: ArrayList<Weather>? = null
    var main: Main? = null

    init{
        this.name = name
        this.weather = weather
        this.main = main
    }
}