package com.example.object_declarations

object Service {
    private val field1 = "some value"
    private var field2 = "some variable" // varも宣言可能

    fun findById(id: Long) {
        Repository.findById(id)
    }
}

object Repository {
    fun findById(id: Long) {
        println("Query DB")
    }
}

object ObjectDeclaration {
    init {
        println("ObjectDeclaration is initialized.")
    }

    fun print() {
        println("ObjectDeclaration")
    }
}

class CompanionObject {
    companion object {
        init {
            println("CompanionObject is initialized.")
        }

        fun print() {
            println("CompanionObject")
        }
    }
}
