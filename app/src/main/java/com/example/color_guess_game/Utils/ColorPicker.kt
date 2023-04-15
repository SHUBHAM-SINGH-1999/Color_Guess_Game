package com.example.color_guess_game.Utils

object ColorPicker {
    val colors = arrayOf("#9400D3", "#4B0082", "#0000FF","#00FF00","#FFFF00","#FF7F00","#FF0000")
    val colorname = arrayOf("Violet","Indigo","Blue","Green","Yellow","Orange","Red")
    val generatedColorSet = mutableListOf(0,1,2,3,4,5,6)
    fun setRandomColor(){
        generatedColorSet.shuffle()
    }
    var name:String?=null
    fun setname(username:String){
        name =username.toString()
    }
}