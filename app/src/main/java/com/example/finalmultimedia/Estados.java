package com.example.finalmultimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import cz.msebera.android.httpclient.Header;

public class Estados extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

            BottomNavigationView btnNav;
            RecyclerView rViewJAVAStatus;
            EstadosAdapter estadosAdapter;
            MaterialTextView usuarioStatusXML,
                    StatusInfoXML;
            ImageButton imgStatusXML;
            MaterialButton btnStatusXML;

            ArrayList<EstadosP> estadosLista = new ArrayList<EstadosP>();//Arreglo de mensajes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);
        //getSupportActionBar().hide();

        btnNav = (BottomNavigationView) findViewById(R.id.btnNavXML);
        btnNav.setOnNavigationItemSelectedListener(this);

        leerStatus();
    }

    void leerStatus(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://.edcosoft.com.mx/edcosoft.com.mx/equipo02/status.json";

        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String cadena = new String(responseBody);

                try {
                    JSONArray jsonArray = new JSONArray(cadena);
                    for (int i=0; i< jsonArray.length(); i++){
                        EstadosP p = new EstadosP();
                        p.setImgStatusXML(jsonArray.getJSONObject(i).getString("imgStatusXML"));
                        p.setUsuarioStatusXML(jsonArray.getJSONObject(i).getString("usuarioStatusXML"));
                        p.setFechayhoraStatusXML(jsonArray.getJSONObject(i).getString("fechayhoraStatusXML"));
                        estadosLista.add(p);
                    }
                    rViewJAVAStatus = findViewById(R.id.rViewStatusXML);
                    rViewJAVAStatus.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    estadosAdapter = new EstadosAdapter(getBaseContext(),estadosLista);
                    rViewJAVAStatus.setAdapter(estadosAdapter);
                    btnNav = findViewById(R.id.btnNavXML);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                int i = 0;
            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { //funcion de Click para cada item
        if (item.getItemId() == R.id.btnNav_chats) {
            Intent mainActivity2 = new Intent(this, Mensaje.class);
            startActivity(mainActivity2);
        }
        if (item.getItemId() == R.id.btnNav_status) {
        }
        if (item.getItemId() == R.id.btnNav_calls) {
            Intent mainActivity3 = new Intent(this, LLamada.class);
            startActivity(mainActivity3);
        }
        if (item.getItemId() == R.id.btnNav_camera) {
            Intent mainActivity4 = new Intent(this, Camara.class);
            startActivity(mainActivity4);
        }
        return true;
    }

    public void newStatus(View view) {
    }

    public void newStatusText(View view) {
    }
}