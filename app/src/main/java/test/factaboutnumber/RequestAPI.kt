
import retrofit2.Response
import retrofit2.http.*
import test.factaboutnumber.remote.response.InterestFactResponse

interface RequestAPI {

    @GET("{number}?json")
    suspend fun getFactAboutNumber(
        @Path("number") number: String,
    ): InterestFactResponse

    @GET("random/math?json")
    suspend fun getFactAboutRandomNumber(
    ): InterestFactResponse
}