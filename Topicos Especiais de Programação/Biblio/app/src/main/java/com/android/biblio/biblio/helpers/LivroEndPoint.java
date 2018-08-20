package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Livro;
import com.android.biblio.biblio.service.ListaEmprestimoAPIModel;
import com.android.biblio.biblio.service.ListaLivroAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LivroEndPoint {

    @GET("livros/")
    Call<ListaLivroAPIModel> livros();

    @POST("livros/")
    Call<Livro> postLivro(@Body Livro livro);

    @PUT("livros/{id}/")
    Call<Livro> putLivro(@Path("id") long id, @Body Livro livro);

    @DELETE("livros/{id}/")
    Call<ResponseBody> deleteLivro(@Path("id") long id);


}
