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
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import android.view.MenuItem;
import android.widget.CompoundButton;

import cz.msebera.android.httpclient.Header;

public class LLamada extends AppCompatActivity implements
        View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    RecyclerView rViewCalls;
    ExtendedFloatingActionButton btnNewCallXML;
    MaterialButton btnCallsBuscarXML;
    BottomNavigationView btnNav;
    LLamadaAdapter lLamadaAdapter;
    ArrayList<LLamadaP> llamadaLista = new ArrayList<LLamadaP>();//Arreglo de mensajes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);

        //getSupportActionBar().hide();

        btnNav = (BottomNavigationView) findViewById (R.id.btnNavXML);
        btnNav.setOnNavigationItemSelectedListener(this);
        leerLLamada();
    }

    private void leerLLamada() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://edcosoft.com.mx/edcosoft.com.mx/equipo02/chats-Index.json";
        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String cadena = new String(responseBody);
                try {
                    JSONArray jsonArray = new JSONArray(cadena);
                    for(int i=0; i< jsonArray.length(); i++){
                        LLamadaP p = new LLamadaP();
                        p.setImgCallsXML(jsonArray.getJSONObject(i).getString("imgCallsXML"));
                        p.setUsuarioCallsXML(jsonArray.getJSONObject(i).getString("usuarioCallsXML"));
                        p.setFechayhoraCallsXML(jsonArray.getJSONObject(i).getString("fechayhoraCallsXML"));
                        llamadaLista.add(p);
                    }
                    rViewCalls = findViewById(R.id.rViewCallsXML);
                    rViewCalls.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    lLamadaAdapter = new LLamadaAdapter(getBaseContext(),llamadaLista);
                    rViewCalls.setAdapter(lLamadaAdapter);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnNav_chats) {
            Intent mainActivity2 = new Intent(this, Mensaje.class);
            startActivity(mainActivity2);
        }
        if (item.getItemId() == R.id.btnNav_status) {
            Intent mainActivity3 = new Intent(this, Estados.class);
            startActivity(mainActivity3);
        }
        if (item.getItemId() == R.id.btnNav_calls) {
        }
        if (item.getItemId() == R.id.btnNav_camera) {
            Intent mainActivity4 = new Intent(this, Camara.class);
            startActivity(mainActivity4);
        }
        return true;
    }

    public void newCall(View view) {
    }
}