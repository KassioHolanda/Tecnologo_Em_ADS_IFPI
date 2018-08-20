package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.models.Titulo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TituloEndPoint {

    @GET("titulos/")
    Call<ListaTitulosAPIModel> titulos();

    @POST("titulos/")
    Call<Titulo> postTitulo(@Body Titulo titulo);

    @GET("titulos/{id}/")
    Call<Titulo> getTitulo(@Path("id") long id);

    @PUT("titulos/{id}/")
    Call<Titulo> putTitulo(@Path("id") long id, @Body Titulo titulo);

    @DELETE("titulos/{id}/")
    Call<ResponseBody> deleteTitulo(@Path("id") long id);



}
