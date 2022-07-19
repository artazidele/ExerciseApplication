package com.example.exercisesapplication.app.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercisesapplication.app.ui.viewmodel.ExerciseViewModel
import com.example.exercisesapplication.databinding.ActivityExerciseListBinding

class ExerciseListActivity : AppCompatActivity() {
    private val viewModel: ExerciseViewModel by viewModels()
    private lateinit var binding: ActivityExerciseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("All Exercises")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.absListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.absListRv.adapter = ExerciseListAdapter()
        binding.bicepsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.bicepsListRv.adapter = ExerciseListAdapter()
        binding.abductorsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.abductorsListRv.adapter = ExerciseListAdapter()
        binding.adductorsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.adductorsListRv.adapter = ExerciseListAdapter()
        binding.calvesListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.calvesListRv.adapter = ExerciseListAdapter()
        binding.cardioListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.cardioListRv.adapter = ExerciseListAdapter()
        binding.deltsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.deltsListRv.adapter = ExerciseListAdapter()
        binding.forearmsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.forearmsListRv.adapter = ExerciseListAdapter()
        binding.glutesListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.glutesListRv.adapter = ExerciseListAdapter()
        binding.hamstringsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hamstringsListRv.adapter = ExerciseListAdapter()
        binding.latsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.latsListRv.adapter = ExerciseListAdapter()
        binding.levatorListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.levatorListRv.adapter = ExerciseListAdapter()
        binding.pectoralsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.pectoralsListRv.adapter = ExerciseListAdapter()
        binding.quadsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.quadsListRv.adapter = ExerciseListAdapter()
        binding.serratusListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.serratusListRv.adapter = ExerciseListAdapter()
        binding.spineListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.spineListRv.adapter = ExerciseListAdapter()
        binding.trapsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.trapsListRv.adapter = ExerciseListAdapter()
        binding.tricepsListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.tricepsListRv.adapter = ExerciseListAdapter()
        binding.upperListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.upperListRv.adapter = ExerciseListAdapter()
        getExercisesList()
        binding.musclesStatusBtn.setOnClickListener {
            getExercisesList()
        }
    }

    private fun getExercisesList() {
//        viewModel.getAllExercisesList()
        viewModel.filterExercises()
    }
}