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