package com.example.exercisesapplication.app.ui.viewmodel

import android.util.Log
import android.view.View
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

    private val _abs = MutableLiveData<List<Exercise>>()
    val abs: LiveData<List<Exercise>> = _abs
    private val _abductors = MutableLiveData<List<Exercise>>()
    val abductors: LiveData<List<Exercise>> = _abductors
    private val _adductors = MutableLiveData<List<Exercise>>()
    val adductors: LiveData<List<Exercise>> = _adductors
    private val _biceps = MutableLiveData<List<Exercise>>()
    val biceps: LiveData<List<Exercise>> = _biceps
    private val _calves = MutableLiveData<List<Exercise>>()
    val calves: LiveData<List<Exercise>> = _calves
    private val _cardiovascular_system = MutableLiveData<List<Exercise>>()
    val cardiovascularSystem: LiveData<List<Exercise>> = _cardiovascular_system
    private val _delts = MutableLiveData<List<Exercise>>()
    val delts: LiveData<List<Exercise>> = _delts
    private val _forearms = MutableLiveData<List<Exercise>>()
    val forearms: LiveData<List<Exercise>> = _forearms
    private val _glutes = MutableLiveData<List<Exercise>>()
    val glutes: LiveData<List<Exercise>> = _glutes
    private val _hamstrings = MutableLiveData<List<Exercise>>()
    val hamstrings: LiveData<List<Exercise>> = _hamstrings
    private val _lats = MutableLiveData<List<Exercise>>()
    val lats: LiveData<List<Exercise>> = _lats
    private val _levator_scapulae = MutableLiveData<List<Exercise>>()
    val levatorScapulae: LiveData<List<Exercise>> = _levator_scapulae
    private val _pectorals = MutableLiveData<List<Exercise>>()
    val pectorals: LiveData<List<Exercise>> = _pectorals
    private val _quads = MutableLiveData<List<Exercise>>()
    val quads: LiveData<List<Exercise>> = _quads
    private val _serratus_anterior = MutableLiveData<List<Exercise>>()
    val serratusAnterior: LiveData<List<Exercise>> = _serratus_anterior
    private val _spine = MutableLiveData<List<Exercise>>()
    val spine: LiveData<List<Exercise>> = _spine
    private val _traps = MutableLiveData<List<Exercise>>()
    val traps: LiveData<List<Exercise>> = _traps
    private val _triceps = MutableLiveData<List<Exercise>>()
    val triceps: LiveData<List<Exercise>> = _triceps
    private val _upper_back = MutableLiveData<List<Exercise>>()
    val upperBack: LiveData<List<Exercise>> = _upper_back


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

    fun filterExercises() {
        viewModelScope.launch {
            _exercise_status.value = ExerciseStatus.LOADING
            try {
                val exercisesList = ExerciseApi.retrofitService.getExercisesList()
                var adductorsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var absF: MutableList<Exercise> = mutableListOf<Exercise>()
                var abductorsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var bicepsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var calvesF: MutableList<Exercise> = mutableListOf<Exercise>()
                var cardiovascularSystemF: MutableList<Exercise> = mutableListOf<Exercise>()
                var deltsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var forearmsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var glutesF: MutableList<Exercise> = mutableListOf<Exercise>()
                var hamstringsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var latsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var levatorScapulaeF: MutableList<Exercise> = mutableListOf<Exercise>()
                var pectoralsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var quadsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var serratusAnteriorF: MutableList<Exercise> = mutableListOf<Exercise>()
                var spineF: MutableList<Exercise> = mutableListOf<Exercise>()
                var trapsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var tricepsF: MutableList<Exercise> = mutableListOf<Exercise>()
                var upperBack: MutableList<Exercise> = mutableListOf<Exercise>()
                for (exercise in exercisesList) {
                    when (exercise.target) {
                        "adductors" -> adductorsF.add(exercise)
                        "abs" -> absF.add(exercise)
                        "abductors" -> abductorsF.add(exercise)
                        "biceps" -> bicepsF.add(exercise)
                        "calves" -> calvesF.add(exercise)
                        "cardiovascular system" -> cardiovascularSystemF.add(exercise)
                        "delts" -> deltsF.add(exercise)
                        "forearms" -> forearmsF.add(exercise)
                        "glutes" -> glutesF.add(exercise)
                        "hamstrings" -> hamstringsF.add(exercise)
                        "lats" -> latsF.add(exercise)
                        "levator scapulae" -> levatorScapulaeF.add(exercise)
                        "pectorals" -> pectoralsF.add(exercise)
                        "quads" -> quadsF.add(exercise)
                        "serratus anterior" ->serratusAnteriorF.add(exercise)
                        "spine" -> spineF.add(exercise)
                        "traps" -> trapsF.add(exercise)
                        "triceps" -> tricepsF.add(exercise)
                        "upper back" -> upperBack.add(exercise)
                    }
//                    if (exercise.target == "abs") {
//                        abs.add(exercise)
//                    }
                }
                _abs.value = absF
                _abductors.value = abductorsF
                _adductors.value = adductorsF
                _biceps.value = bicepsF
                _calves.value = calvesF
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
//                _abs.value = abs
                _exercise_status.value = ExerciseStatus.DONE
            } catch (e: Exception) {
                Log.d("EXCEPTION", e.toString())
                _exercise_status.value = ExerciseStatus.ERROR
                _exercises.value = listOf()
            }
        }
    }

    fun getExercisesListByTarget() {
        viewModelScope.launch {
            _exercise_status.value = ExerciseStatus.LOADING
            try {
                _exercises.value = ExerciseApi.retrofitService.getExercisesListByTarget("forearms")
                _exercise_status.value = ExerciseStatus.DONE
            } catch (e: Exception) {
                Log.d("EXCEPTION", e.toString())
                _exercise_status.value = ExerciseStatus.ERROR
                _exercises.value = listOf()
            }
        }
    }
}