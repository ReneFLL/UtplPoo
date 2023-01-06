/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author rlozada
 */
public class Gasto {
    private int idGasto;
    private String tipoGasto;
    private String detalle;
    private double valor;
    private String fecha;

    public Gasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public Gasto(String tipoGasto, String detalle, double valor, String fecha) {
        this.tipoGasto = tipoGasto;
        this.detalle = detalle;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Gasto(int idGasto, String tipoGasto, String detalle, double valor, String fecha) {
        this.idGasto = idGasto;
        this.tipoGasto = tipoGasto;
        this.detalle = detalle;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Gasto{" + "idGasto=" + idGasto + ", tipoGasto=" + tipoGasto + ", detalle=" + detalle + ", valor=" + valor + ", fecha=" + fecha + '}';
    }
    
}


    