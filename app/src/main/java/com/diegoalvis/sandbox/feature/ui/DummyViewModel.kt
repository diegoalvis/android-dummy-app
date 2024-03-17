package com.diegoalvis.sandbox.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoalvis.sandbox.data.DummyRepository
import com.diegoalvis.sandbox.data.model.ExampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DummyViewModel(private val repository: DummyRepository) : ViewModel() {

    private val _exampleData = MutableStateFlow<List<ExampleData>>(emptyList())
    val exampleData: StateFlow<List<ExampleData>> = _exampleData


    fun loadExampleData() {
        viewModelScope.launch {
            val data = repository.getExampleData()
            _exampleData.value = data
        }
    }
}


