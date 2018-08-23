package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.TokenAPI;
import com.android.biblio.biblio.models.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TokenEndPoint {
    @POST("jwt/token/")
    Call<TokenAPI> login(@Body Usuario usuario);

//    @POST("jwt/token/")
//    Call<TokenAPI> login(@Body Usuario usuario);
}
