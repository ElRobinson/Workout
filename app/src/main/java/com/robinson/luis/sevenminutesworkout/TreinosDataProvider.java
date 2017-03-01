package com.robinson.luis.sevenminutesworkout;

/**
 * Created by Luis on 21/02/2017.
 */

public class TreinosDataProvider {
    private int listaIcones;
    private String listaTreinos;
    private String listaIniciais;


    public TreinosDataProvider(int listaIcones, String listaTreinos, String listaIniciais) {
        this.listaIcones = listaIcones;
        this.listaTreinos = listaTreinos;
        this.listaIniciais = listaIniciais;
    }

    public int getListaIcones() {
        return listaIcones;
    }

    public void setListaIcones(int listaIcones) {
        this.listaIcones = listaIcones;
    }

    public String getListaTreinos() {
        return listaTreinos;
    }

    public void setListaTreinos(String listaTreinos) {
        this.listaTreinos = listaTreinos;
    }

    public String getListaIniciais() {
        return listaIniciais;
    }

    public void setListaIniciais(String listaIniciais) {
        this.listaIniciais = listaIniciais;
    }
}
