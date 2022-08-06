package me.dio.cartaodenegocios

import android.app.Application
import me.dio.cartaodenegocios.data.AppDatabase
import me.dio.cartaodenegocios.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}