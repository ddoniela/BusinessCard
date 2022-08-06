package me.dio.cartaodenegocios.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import me.dio.cartaodenegocios.data.BusinessCard
import me.dio.cartaodenegocios.data.BusinessCardRepository

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)

    }

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}