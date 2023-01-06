/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import datos.GastoDAO;
import domain.Gasto;
import java.util.List;

/**
 *
 * @author User
 */
public class TestBddGastos {

    public static void main(String[] args) {
        GastoDAO gastoDAO = new GastoDAO();
//insertar nuevo gasto
/*
        Gasto gastoNuevo = new Gasto("Transporte", "Uber", 4.50, "2023-01-05");
        gastoDAO.insertar(gastoNuevo);
*/

        Gasto gastoModificar=new Gasto(6,"Supermercado","Despensa",23.78,"2022-09-02");
        gastoDAO.modificar(gastoModificar);
        
 /*
        Gasto gastoEliminar=new Gasto(1);
        gastoDAO.eliminar(gastoEliminar);
  */       
        List<Gasto> gastos = gastoDAO.seleccionar();
        for (Gasto gasto : gastos) {
            System.out.println("Gasto = " + gasto);
        }
    }

}
