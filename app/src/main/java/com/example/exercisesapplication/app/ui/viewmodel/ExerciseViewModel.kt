package com.example.exercisesapplication.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercisedb.ExerciseApi
import com.example.exercisesapplication.app.data.Exercise
import kotlinx.coroutines.launch

enum class ExerciseStatus { LOADING, ERROR, DONE }

class ExerciseViewModel : ViewModel() {
    private val _exercise_status = MutableLiveData<ExerciseStatus>()
    val exerciseStatus: LiveData<ExerciseStatus> = _exercise_status
    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    fun getAllExercisesList() {
        viewModelScope.launch {
            _exercise_status.value = ExerciseStatus.LOADING
            try {
                _exercises.value = ExerciseApi.retrofitService.getExercisesList()
                _exercise_status.value = ExerciseStatus.DONE
            } catch (e: Exception) {
                Log.d("EXCEPTION", e.toString())
                _exercise_status.value = ExerciseStatus.ERROR
                _exercises.value = listOf()
            }
        }
    }
}