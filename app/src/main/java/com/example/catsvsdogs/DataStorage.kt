package com.example.catsvsdogs

data class History(var name: String, var maxPoints: Int, var countPlays: Int)

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

    fun addHistory(name: String, points: Int) {
        var newPlayer = true
        list.forEach {
            if (it.name == name) {
                if (it.maxPoints < points)
                    it.maxPoints = points
                it.countPlays++
                newPlayer = false
            }
        }
        if (newPlayer)
            list.add(History(name, points, 1))
    }

    fun getHistoryList(): ArrayList<String> {
        val historyList = ArrayList<String>()
        list.forEach {
            historyList.add(it.name + ": " + it.maxPoints.toString())
        }
        return historyList
    }
}