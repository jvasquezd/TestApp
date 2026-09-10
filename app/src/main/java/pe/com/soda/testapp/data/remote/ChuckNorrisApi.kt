package pe.com.soda.testapp.data.remote

import retrofit2.http.GET

interface ChuckNorrisApi {

    @GET("jokes/categories")
    suspend fun getCategories(): List<String>
}