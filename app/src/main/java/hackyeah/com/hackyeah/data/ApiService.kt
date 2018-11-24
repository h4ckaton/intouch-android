package hackyeah.com.hackyeah.data

import hackyeah.com.hackyeah.data.dto.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("questions")
    fun getQuestions(@Query("lang") lang: String, @Query("categoryId") categoryId: Int): Observable<ApiResponse<List<Any>>>


}
