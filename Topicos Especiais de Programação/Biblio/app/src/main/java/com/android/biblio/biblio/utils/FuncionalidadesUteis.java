package com.android.biblio.biblio.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class FuncionalidadesUteis {

    public static ProgressDialog progressDialog(Context context, String mensagem) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(mensagem);
        return progressDialog;
    }

    public static String getToken(Context context) {
        Preferencias preferencias = new Preferencias(context);
        return preferencias.getSavedString("tokenLogado");
    }
}
