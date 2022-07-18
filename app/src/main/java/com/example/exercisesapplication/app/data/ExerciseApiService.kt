package com.example.exercisedb

import com.example.exercisesapplication.app.data.Exercise
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.*
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val API_URL = "https://exercisedb.p.rapidapi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

private val retrofit = Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .client(client)
    .build()

interface ExerciseApiService {
    @GET("exercises")
    @Headers("X-RapidAPI-Host: exercisedb.p.rapidapi.com", "X-RapidAPI-Key: 75be40b2c2msh83aae7a3af8fcdfp1ea10bjsna4248eaa1ddb")
    suspend fun getExercisesList(): List<Exercise>
}

object ExerciseApi {
    val retrofitService: ExerciseApiService by lazy { retrofit.create(ExerciseApiService::class.java) }
}
