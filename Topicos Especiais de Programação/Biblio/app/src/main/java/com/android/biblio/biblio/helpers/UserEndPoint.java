package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.ListaAutoresAPIModel;
import com.android.biblio.biblio.service.ListaUsersAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserEndPoint {

    @GET("user/")
    Call<ListaUsersAPIModel> users();

    @GET("user/{id}")
    Call<Usuario> getUsuario(@Path("id") long pk);

    @POST("user/")
    Call<Usuario> postUser(@Body Usuario usuario);

    @PUT("user/{id}/")
    Call<Usuario> putUser(@Path("id") long id, @Body Usuario usuario);

    @DELETE("user/{id}/")
    Call<ResponseBody> deleteUser(@Path("id") long id);

}
