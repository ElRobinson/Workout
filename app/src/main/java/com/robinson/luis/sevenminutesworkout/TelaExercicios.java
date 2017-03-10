package com.robinson.luis.sevenminutesworkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TelaExercicios extends AppCompatActivity {

    ListView listaExercicios;
    String exercicioSelecionado;
    int treinoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exercicios);
        listaExercicios = (ListView)findViewById(R.id.listaExercicios);

        treinoSelecionado = getIntent().getExtras().getInt("numeroTreino");
        String[] listaTreino = {};
        switch (treinoSelecionado){
            case 0: listaTreino = new String[] {"Aquecimento","Corrida","Barra","Flexao","Abdominal","Agachamento","Minhoca","Jacaré","Urso","Caranguejo","Barra"};
                break;
            case 1: listaTreino = new String[] {"Corrida","Barra","Flexao","Corrida","Barra","Flexao","Corrida","Barra","Flexao","Corrida","Barra","Flexao","Corrida","Barra","Flexão"};
                break;
            default: listaTreino = new String[] {"Minhoca","Jacará","Urso","Caranguejo","Barra","Minhoca","Jacará","Urso","Caranguejo","Barra"};

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaTreino);

        listaExercicios.setAdapter(adapter);

        listaExercicios.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listaExercicios.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Item : " + itemPosition +" Listitem: " + itemValue,Toast.LENGTH_SHORT).show();
                exercicioSelecionado = itemValue;
                loadTelaVideos();

            }
        });

    }

    public void loadTelaVideos(){
        Intent intent = new Intent(getApplicationContext(),TelaVideos.class);
        intent.putExtra("nomeVideo",exercicioSelecionado);
        startActivity(intent);
    }

    public void loadTelaTreinoRun(){
        Intent intent = new Intent(getApplicationContext(), TelaTreinoRun.class);
        intent.putExtra("numeroTreino",treinoSelecionado);
        startActivity(intent);
    }
}
