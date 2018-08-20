package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.service.ListaAutoresAPIModel;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AutorEndPoint {

    @GET("autores/")
    Call<ListaAutoresAPIModel> autores();

    @GET("autores/{id}/")
    Call<Autor> getAutor(@Path("id") long id);

    @POST("autores/")
    Call<Autor> postAutor(@Body Autor autor);

    @PUT("autores/{id}/")
    Call<Autor> putAutor(@Path("id") long id, @Body Autor autor);

    @DELETE("autores/{id}/")
    Call<ResponseBody> deleteAutor(@Path("id") long id);

}
