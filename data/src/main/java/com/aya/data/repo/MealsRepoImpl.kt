package com.aya.data.repo

import com.aya.data.remote.ApiService
import com.aya.domain.entity.MealsResponse
import com.aya.domain.repo.MealsRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MealsRepoImpl(private val apiService: ApiService ,
                    private val ktor: HttpClient
) : MealsRepo {

    override suspend fun getMealsFromRemote(): MealsResponse {
        return apiService.getMeals()
    }

    //https://apiumhub.com/tech-blog-barcelona/migrating-retrofit-to-ktor/

    override suspend fun getMealsFromKtor(): Result<MealsResponse> {
     return   runCatching {
            ktor.get("categories.php").body()
        }
    }

         /*
            *
            * // request body
        suspend fun createUser(user: User): Result<User> = runCatching {
            Ktor.post("/user") { setBody(user) }.body()
        }

        // request using x-www-form-urlencoded
        suspend fun editUser(first: String, last: String): Result<User> = runCatching {
            Ktor.submitForm(
                url = "/user/edit",
                formParameters = Parameters.build {
                    append("first_name", first)
                    append("last_name", last)
                }
            ).body()
        }

        // request multi-part
        suspend fun updateUser(photo: String): Result<User> = runCatching {
            Ktor.post("/user/update") {
                setBody(MultiPartFormDataContent(
                    formData {
                        append("photo", File(photo).readBytes())
                    }
                ))
            }.body()
        }
        *
        * */
}