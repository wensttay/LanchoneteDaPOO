package br.edu.ifpb.ads.poo.lanchonete.sistem;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Salao {

    /// CARACTERISTICAS ///
    private ArrayList<Mesa> mesas = new ArrayList();
    private int tamanho = 0;

    /// CONSTRUTORES ///
    public Salao() {
    }

    /// METODOS GET ///
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    /// METODOS SET ///
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    /// METODOS ADD ///
    public void addMesa(Mesa mesa) {
        tamanho += 1;
        mesa.setNumero(tamanho);
        mesas.add(mesa);
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        String tudo = "";
        for (Mesa mesa : mesas) {
            tudo += mesa.toString() + "\n";
        }
        return tudo;
    }

}
