package com.android.biblio.biblio.service;

import com.android.biblio.biblio.helpers.AutorEndPoint;
import com.android.biblio.biblio.helpers.CategoriaEndPoint;
import com.android.biblio.biblio.helpers.EditoraEndPoint;
import com.android.biblio.biblio.helpers.EmprestimoEndPoint;
import com.android.biblio.biblio.helpers.LivroEndPoint;
import com.android.biblio.biblio.helpers.ReservaEndPoint;
import com.android.biblio.biblio.helpers.TituloEndPoint;
import com.android.biblio.biblio.helpers.TokenEndPoint;
import com.android.biblio.biblio.helpers.UserEndPoint;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static String TAG = APIService.class.getSimpleName();
//    public static final String BASE_URL = "http://192.168.0.107:8000/";
//    public static final String BASE_URL = "http://10.20.30.162:8000/";
    public static final String BASE_URL = "http://192.168.43.248:8000/";
//    public static final String BASE_URL = "http://192.168.8.2:8000/";

    private Retrofit retrofit;
    private Interceptor interceptor;
    private UserEndPoint userEndPoint;
    private TituloEndPoint tituloEndPoint;
    private AutorEndPoint autorEndPoint;
    private CategoriaEndPoint categoriaEndPoint;
    private LivroEndPoint livroEndPoint;
    private ReservaEndPoint reservaEndPoint;
    private EditoraEndPoint editoraEndPoint;
    private EmprestimoEndPoint emprestimoEndPoint;
    private TokenEndPoint tokenEndPointAPI;


    public APIService(String token) {

        this.interceptor = new InterceptorMuralAPI("Bearer " + token);

        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);

        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();

        retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        tokenEndPointAPI = retrofit.create(TokenEndPoint.class);
        tituloEndPoint = retrofit.create(TituloEndPoint.class);
        userEndPoint = retrofit.create(UserEndPoint.class);
        autorEndPoint = retrofit.create(AutorEndPoint.class);
        emprestimoEndPoint = retrofit.create(EmprestimoEndPoint.class);
        reservaEndPoint = retrofit.create(ReservaEndPoint.class);
        livroEndPoint = retrofit.create(LivroEndPoint.class);
        categoriaEndPoint = retrofit.create(CategoriaEndPoint.class);
        editoraEndPoint = retrofit.create(EditoraEndPoint.class);
    }

    public APIService() {

//        this.interceptor = new InterceptorMuralAPI("Bearer " + token);
//
//        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
//        builderCliente.interceptors().add(this.interceptor);
//
//        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();

        retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(cliente)
                .build();

        tokenEndPointAPI = retrofit.create(TokenEndPoint.class);
        tituloEndPoint = retrofit.create(TituloEndPoint.class);
        userEndPoint = retrofit.create(UserEndPoint.class);
        autorEndPoint = retrofit.create(AutorEndPoint.class);
        emprestimoEndPoint = retrofit.create(EmprestimoEndPoint.class);
        reservaEndPoint = retrofit.create(ReservaEndPoint.class);
        livroEndPoint = retrofit.create(LivroEndPoint.class);
        categoriaEndPoint = retrofit.create(CategoriaEndPoint.class);
        editoraEndPoint = retrofit.create(EditoraEndPoint.class);
    }

    public TokenEndPoint getTokenEndPointAPI() {
        return tokenEndPointAPI;
    }

    public UserEndPoint getUserEndPoint() {
        return userEndPoint;
    }

    public TituloEndPoint getTituloEndPoint() {
        return tituloEndPoint;
    }

    public AutorEndPoint getAutorEndPoint() {
        return autorEndPoint;
    }

    public CategoriaEndPoint getCategoriaEndPoint() {
        return categoriaEndPoint;
    }

    public LivroEndPoint getLivroEndPoint() {
        return livroEndPoint;
    }

    public ReservaEndPoint getReservaEndPoint() {
        return reservaEndPoint;
    }

    public EditoraEndPoint getEditoraEndPoint() {
        return editoraEndPoint;
    }

    public EmprestimoEndPoint getEmprestimoEndPoint() {
        return emprestimoEndPoint;
    }


}
