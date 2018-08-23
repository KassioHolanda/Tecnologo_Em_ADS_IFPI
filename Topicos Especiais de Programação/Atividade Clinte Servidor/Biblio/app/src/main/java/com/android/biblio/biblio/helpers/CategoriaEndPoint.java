package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.service.ListaAutoresAPIModel;
import com.android.biblio.biblio.service.ListaCategoriaAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CategoriaEndPoint {

    @GET("categorias/")
    Call<ListaCategoriaAPIModel> categorias();

    @GET("categorias/{id}/")
    Call<Categoria> getCategoria(@Path("id") long id);

    @POST("categorias/")
    Call<Categoria> postCategoria(@Body Categoria categoria);

    @PUT("categorias/{id}/")
    Call<Categoria> putCategoria(@Path("id") long id, @Body Categoria categoria);

    @DELETE("categorias/{id}/")
    Call<ResponseBody> deleteCategoria(@Path("pk") long id);

}
