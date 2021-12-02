package com.example.finalmultimedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Mensaje extends AppCompatActivity implements
        View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

   // FloatingActionButton btn;

    BottomNavigationView btnNav;
    RecyclerView rcViewJAVA;
    MensajeAdapter mensajeAdapter;
    ExtendedFloatingActionButton btnNewMsgXML;
    ArrayList<MensajeP> mensajeLista = new ArrayList<MensajeP>();//Arreglo de mensajes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        //getSupportActionBar().hide();

        btnNav = (BottomNavigationView) findViewById (R.id.btnNavXML);
        //btnNav.setSelectedItemId(R.id.btnNav_chats);
        btnNav.setOnNavigationItemSelectedListener(this);
        leerPost();


    }

    void leerPost() {

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://edcosoft.com.mx/edcosoft.com.mx/equipo02/chats-Index.json";

        client.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String cadena = new String(responseBody);
                try {
                    JSONArray jsonArray = new JSONArray(cadena);
                    for (int i=0; i< jsonArray.length(); i++){
                        MensajeP p = new MensajeP();
                        p.setUsuarioXML(jsonArray.getJSONObject(i).getString("usuarioXML"));
                        p.setHoraXML(jsonArray.getJSONObject(i).getString("horaXML"));
                        p.setImgXML(jsonArray.getJSONObject(i).getString("imgXML"));
                        p.setMensajeXML(jsonArray.getJSONObject(i).getString("mensajeXML"));
                        mensajeLista.add(p);
                    }
                    rcViewJAVA = findViewById(R.id.rcViewXML);
                    rcViewJAVA.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    mensajeAdapter = new MensajeAdapter(getBaseContext(), mensajeLista);
                    rcViewJAVA.setAdapter(mensajeAdapter);
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

    public void newMSG(View view) {
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.btnNav_chats) {
        }
        if (item.getItemId() == R.id.btnNav_status) {
            Intent mainActivity = new Intent(this, Estados.class);
            overridePendingTransition(0,0);
            startActivity(mainActivity);
        }
        if (item.getItemId() == R.id.btnNav_calls) {
            Intent mainActivity3 = new Intent(this, LLamada.class);
            overridePendingTransition(0,0);
            startActivity(mainActivity3);
        }
        if (item.getItemId() == R.id.btnNav_camera) {
            Intent mainActivity4 = new Intent(this, Camara.class);
            overridePendingTransition(0,0);
            startActivity(mainActivity4);
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) { //es para que sirva el boton flotante
            case R.id.btnNewStatusTextXML:
                Intent mainActivity = new Intent(this, Chat.class);
                startActivity(mainActivity);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
