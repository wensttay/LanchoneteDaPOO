package sistem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version 1.0
 * @author wensttay <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class ConjuntoDePedidos {

    /// CARACTERISTICAS ///
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private Date data;
    private int mesaID;

    /// CONSTRUTORES ///
    public ConjuntoDePedidos(ArrayList<Pedido> pedidos, int mesaID) {
        this.pedidos = pedidos;
        this.data = new Date();
        this.mesaID = mesaID;
    }

    public ConjuntoDePedidos() {
    }

    /// METODOS GET ///
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public String getData() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        return dataFormatada.format(this.data);
    }

    public int getMesaID() {
        return mesaID;
    }

    public double getLucroParcial() {
        float total = 0;
        
        for (Pedido pedido : pedidos) {
            total += pedido.getLucroParcial();
        }
        
        return total;
    }

    public double getValorTotal() {
        float total = 0;
        
        for (Pedido pedido : pedidos) {
            total += pedido.getSubtotal();
        }
        
        return total;
    }

    /// METODOS SET ///
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        String tudo = "";
        tudo += "\nMesa escolhida: " + mesaID;
        
        for (Pedido pedido : pedidos) {
            tudo += "\n" + pedido.toString();
        }
        
        return tudo;
    }
}
