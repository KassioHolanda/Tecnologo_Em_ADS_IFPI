package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Reserva;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.ListaEmprestimoAPIModel;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmprestimoEndPoint {

    @GET("emprestimos/")
    Call<ListaEmprestimoAPIModel> emprestimos();

    @POST("emprestimos/")
    Call<Emprestimo> postEmprestimo(@Body Emprestimo emprestimo);

    @PUT("emprestimos/{id}/")
    Call<Emprestimo> putEmprestimo(@Path("id") long id, @Body Emprestimo emprestimo);

    @DELETE("emprestimos/{id}/")
    Call<ResponseBody> deleteEmprestimo(@Path("id") long id);

}
