package com.android.biblio.biblio.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.fragments.user.ReservasFragment;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.models.Reserva;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterReserva extends RecyclerView.Adapter<AdapterReserva.ViewHolder> {
    private final Context context;
    private final List<Reserva> reservas;
    private APIService apiService;
    private Preferencias preferencias;
    private Mensagens mensagens;
    private Titulo titulo;
    private Categoria categoria;
    private List<Titulo> titulos;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView titulo;
        protected TextView dataReserva;
        protected TextView genero;
        protected CheckBox ativa;
        protected Button removerReserva;

        public ViewHolder(View view) {
            super(view);
            titulo = view.findViewById(R.id.reserva_titulo_id);
            dataReserva = view.findViewById(R.id.data_reserva_id);
            genero = view.findViewById(R.id.reserva_categoria_id);
            ativa = view.findViewById(R.id.reserva_ativa_id);
            removerReserva = view.findViewById(R.id.remover_reserva_id);
        }
    }

    public AdapterReserva(Context context, List<Reserva> reservas) {
        this.context = context;
        this.reservas = reservas;
        setupInit();
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(context);
        apiService = new APIService(getToken());
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
        Toast.makeText(context, "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    @NonNull
    @Override
    public AdapterReserva.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_reserva, parent, false);
        AdapterReserva.ViewHolder viewHolder = new AdapterReserva.ViewHolder(view);
        return viewHolder;
    }

    public void carregarTitlo(long id) {

        Call<ListaTitulosAPIModel> call = apiService.getTituloEndPoint().titulos();
        call.enqueue(new Callback<ListaTitulosAPIModel>() {

            @Override
            public void onResponse(Call<ListaTitulosAPIModel> call, Response<ListaTitulosAPIModel> response) {
                if (response.isSuccessful()) {
                    titulos = response.body().getResults();
                }
            }


            @Override
            public void onFailure(Call<ListaTitulosAPIModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReserva.ViewHolder holder, final int position) {

        carregarTitlo(reservas.get(position).getTitulo());

//        holder.titulo.setText(reservas.get(position).getTitulo().getNome());
//        holder.genero.setText(reservas.get(position).getTitulo().getCategoria().getNome());
//        holder.dataReserva.setText("" + reservas.get(position).getDataReserva());
        holder.ativa.setActivated(reservas.get(position).isAtive());

        holder.removerReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Nova Editora").setMessage("Deseja cancelar sua reserva?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Call<ResponseBody> call = apiService.getReservaEndPoint().deleteReserva(reservas.get(position).getId());
                                call.enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        Toast.makeText(context, "RESERVA CANCELADA", Toast.LENGTH_LONG).show();
                                        ReservasFragment reservasFragment = new ReservasFragment();
                                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                                        fragmentManager.beginTransaction().replace(R.id.content_frame, reservasFragment).addToBackStack(null).commit();
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        Toast.makeText(context, "" + mensagens.ERROR_CONECTION, Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).setNegativeButton("Não", null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }
}
