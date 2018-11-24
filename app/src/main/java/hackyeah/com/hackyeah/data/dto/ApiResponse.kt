package hackyeah.com.hackyeah.data.dto


data class ApiResponse<T>(
    val data: T,
    val error: Any,
    val code: Int
)