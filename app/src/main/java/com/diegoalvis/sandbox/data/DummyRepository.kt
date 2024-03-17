package com.diegoalvis.sandbox.data

import com.diegoalvis.sandbox.data.local.DummyDao
import com.diegoalvis.sandbox.data.model.ExampleData
import com.diegoalvis.sandbox.data.network.ApiService
import java.lang.Exception

class DummyRepository(val apiService: ApiService, val dao: DummyDao) {


    fun getExampleData(): List<ExampleData> {
        throw Exception()
    }

}