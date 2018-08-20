package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.service.ListaEditoraAPIModel;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EditoraEndPoint {

    @GET("editoras/")
    Call<ListaEditoraAPIModel> editoras();

    @GET("editoras/{id}/")
    Call<Editora> getEditora(@Path("id") long id);

    @POST("editoras/")
    Call<Editora> postEditora(@Body Editora editora);

    @PUT("editoras/{id}/")
    Call<Editora> putEditora(@Path("id") long id, @Body Editora editora);

    @DELETE("editoras/{id}/")
    Call<ResponseBody> deleteEditora(@Path("id") long id);


}
