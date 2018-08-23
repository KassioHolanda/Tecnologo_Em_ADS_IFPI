package com.android.biblio.biblio.helpers;

import com.android.biblio.biblio.models.Reserva;
import com.android.biblio.biblio.service.ListaReservaAPIModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservaEndPoint {

    @GET("reserva/")
    Call<ListaReservaAPIModel> reservas();

    @POST("reserva/")
    Call<Reserva> postReserva(@Body Reserva reserva);

    @PUT("reserva/{id}/")
    Call<Reserva> putReserva(@Path("id") long id, @Body Reserva reserva);

    @DELETE("reserva/{id}/")
    Call<ResponseBody> deleteReserva(@Path("id") long id);

}
