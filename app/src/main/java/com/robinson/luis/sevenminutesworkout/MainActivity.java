package com.robinson.luis.sevenminutesworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int treinoSelecionado;
    ImageView imagemTreinos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView;

        String[] lista_nome_treinos;
        String[] inicial_treinos;

        TreinosAdapter adapter;

        int[] lista_e_icones = {    R.drawable.estrelaa,R.drawable.estrelaa,R.drawable.estrelaa,
                R.drawable.estrelaa,R.drawable.estrelaa,R.drawable.estrelaa,
                R.drawable.estrelaa,R.drawable.estrelaa,R.drawable.estrelaa};

        listView = (ListView) findViewById(R.id.listaTreinos);
        imagemTreinos = (ImageView)findViewById(R.id.imgTreinos);

        imagemTreinos.animate().alpha(1f).setDuration(2000);

        lista_nome_treinos  = getResources().getStringArray(R.array.lista_treinos);
        inicial_treinos = getResources().getStringArray(R.array.inicial_treinos);

        int i = 0;
        adapter = new TreinosAdapter(getApplicationContext(),R.layout.celula_treino);
        listView.setAdapter(adapter);

        for (String titles:lista_nome_treinos)
        {
            TreinosDataProvider dataProvider = new TreinosDataProvider(lista_e_icones[i],titles,inicial_treinos[i]);
            adapter.add(dataProvider);
            i++;
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                treinoSelecionado = position;
                Toast.makeText(getApplicationContext(),"Hello " + String.valueOf(position),Toast.LENGTH_LONG).show();
                loadTelaExercicio();
            }
        });
    }

    public void loadTelaExercicio(){
        Intent intent = new Intent(getApplicationContext(),TelaExercicios.class);
        intent.putExtra("numeroTreino", treinoSelecionado);
        startActivity(intent);
    }
}
