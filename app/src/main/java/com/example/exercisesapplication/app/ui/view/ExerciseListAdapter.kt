package com.example.exercisesapplication.app.ui.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercisesapplication.app.data.Exercise
import com.example.exercisesapplication.databinding.ExerciseItemBinding

class ExerciseListAdapter :
    ListAdapter<Exercise, ExerciseListAdapter.ExercisesViewHolder>(DiffCallback) {

    class ExercisesViewHolder(
        private var binding: ExerciseItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(exercise: Exercise) {
            binding.exercise = exercise
            binding.executePendingBindings()
//            binding.saveBtn.setOnClickListener {
//                //
//            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExercisesViewHolder {
        return ExercisesViewHolder(
            ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false) //inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        val exercise = getItem(position)
        holder.bind(exercise)
        holder.itemView.setOnClickListener {
//            toOneExercieActivity(exercise, holder)
        }
    }

//    public fun toOneExercieActivity(exercise: Exercise, holder: ExercisesViewHolder) {
////        val intent = Intent(AllExerciseActivity(), OneExerciseActivity()::class.java)
//        val intent = Intent(holder.itemView.context, OneExerciseActivity()::class.java)
//        intent.putExtra("name", exercise.name)
//        intent.putExtra("gifUrl", exercise.gifUrl)
//        intent.putExtra("bodyPart", exercise.bodyPart)
//        intent.putExtra("equipment", exercise.equipment)
//        intent.putExtra("target", exercise.target)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        ContextCompat.startActivity(holder.itemView.context!!, intent, null)
//    }
}