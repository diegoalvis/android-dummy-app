package com.diegoalvis.sandbox

import com.diegoalvis.sandbox.data.DummyRepository
import com.diegoalvis.sandbox.data.model.ExampleData
import com.diegoalvis.sandbox.feature.ui.DummyViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class DummyViewModelTest {

    private lateinit var dummyViewModel: DummyViewModel
    private val repository: DummyRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())

        dummyViewModel = DummyViewModel(repository)
    }

    @Test
    fun `load ExampleData Successfully`() = runTest {
        val mockData = listOf(ExampleData("test"))
        every { repository.getExampleData() } returns mockData

        dummyViewModel.loadExampleData()

        assertEquals(mockData, dummyViewModel.exampleData.value)
    }

}