package com.example.exercisesapplication.app.ui.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exercisesapplication.app.data.Exercise
import com.example.exercisesapplication.app.ui.viewmodel.ExerciseStatus

// BindingAdapters for ExerciseListActivity
@BindingAdapter("exerciseGif")
fun bindExerciseGifUrlIV(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .asGif()
        .load(url)
        .into(imageView)

//    imgUrl?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        imgView.load(imgUri) {
//            placeholder(R.drawable.circle_animation)
//            error(R.drawable.pet_icon)
//        }
//    }
//    Glide.with(this@ItemActivity)
//        .load(imageURL)
//        .into(itemImageView)
}

@BindingAdapter("exerciseTarget")
fun bindExerciseTargetTV(textView: TextView, text: String) {
    textView.text = text
}
@BindingAdapter("exerciseEquipment")
fun bindExerciseEquipmentTV(textView: TextView, text: String) {
    textView.text = text
}

@BindingAdapter("exerciseBodyPart")
fun bindExerciseBodyPartTV(textView: TextView, text: String) {
    textView.text = text
}

@BindingAdapter("exerciseName")
fun bindExerciseNameTV(textView: TextView, text: String) {
    textView.text = text
}

@BindingAdapter("allListData")
fun bindAllListRV(recyclerView: RecyclerView, data: List<Exercise>?) {
    val adapter = recyclerView.adapter as ExerciseListAdapter
    adapter.submitList(data)
}


@BindingAdapter("allTV")
fun bindAllTV(statusTextView: TextView, status: ExerciseStatus?) {
    when (status) {
        ExerciseStatus.LOADING -> {
            statusTextView.visibility = View.VISIBLE
            statusTextView.text = "Loading..."
        }
        ExerciseStatus.ERROR -> {
            statusTextView.visibility = View.VISIBLE
            statusTextView.text = "Something went wrong. Please try again later."
        }
        ExerciseStatus.DONE -> {
            statusTextView.visibility = View.GONE
        }
    }
}

@BindingAdapter("allBtn")
fun bindAllBtn(statusBtn: Button, status: ExerciseStatus?) {
    when (status) {
        ExerciseStatus.LOADING -> {
            statusBtn.visibility = View.GONE
        }
        ExerciseStatus.ERROR -> {
            statusBtn.visibility = View.VISIBLE
        }
        ExerciseStatus.DONE -> {
            statusBtn.visibility = View.GONE
        }
    }
}

@BindingAdapter("allRV")
fun bindAllRV(recyclerView: RecyclerView, status: ExerciseStatus?) {
    when (status) {
        ExerciseStatus.LOADING -> {
            recyclerView.visibility = View.GONE
        }
        ExerciseStatus.ERROR -> {
            recyclerView.visibility = View.GONE
        }
        ExerciseStatus.DONE -> {
            recyclerView.visibility = View.VISIBLE
        }
    }
}