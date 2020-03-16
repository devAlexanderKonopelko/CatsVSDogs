package com.example.catsvsdogs

data class History (var name: String, var maxPoints: Int, var countPlays: String)

class DataStorage {
    private val list = ArrayList<History>()

    var player1Name: String? = null
    var player1Points: Int = 0

    var player2Name: String? = null
    var player2Points: Int = 0

    var statusPlay: Int = 0

    companion object {
        val instance = DataStorage()
    }
}