package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Chat extends AppCompatActivity {

    ImageView return2InicioXML,
            makeVideoCallMensajeXML,
            makeCallMensajeXML;

    RecyclerView rViewMensaje;
    MaterialTextView mensajeXML;
    ImageButton emojisbtnMensajeXML,
            filebtnMensajeXML,
            imgChatsXML,
            imgbtnMensajeXML;

    ArrayList<ChatP> chatLista = new ArrayList<ChatP>();//Arreglo de mensajes
    ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //getSupportActionBar().hide();

        leerPost();
    }

    void leerPost(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://edcosoft.com.mx/edcosoft.com.mx/equipo02/mensaje.json";

        client.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String cadena = new String(responseBody);

                try {
                    JSONArray jsonArray = new JSONArray(cadena);
                    for (int i=0; i< jsonArray.length(); i++){
                        ChatP p = new ChatP();

                        p.setMensaje_enviadoXML(jsonArray.getJSONObject(i).getString("mensaje_enviadoXML"));
                        p.setHoraMensaje(jsonArray.getJSONObject(i).getString("horaMensaje"));
                        p.setIdMensaje(jsonArray.getJSONObject(i).getString("idMensaje"));
                        chatLista.add(p);
                    }
                    rViewMensaje = findViewById(R.id.rViewMensajeXML);
                    rViewMensaje.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    chatAdapter = new ChatAdapter(getBaseContext(),chatLista);
                    rViewMensaje.setAdapter(chatAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void goBack(View view) {
        Intent backActMensaje = new Intent(this, Mensaje.class);
        startActivity(backActMensaje);
    }
}