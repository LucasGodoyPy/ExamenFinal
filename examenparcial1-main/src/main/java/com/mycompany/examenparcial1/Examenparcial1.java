/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenparcial1;

import com.mycompany.infraestructura.DBManagement.Ciudad;
import com.mycompany.infraestructura.DBManagement.Cliente;
import com.mycompany.infraestructura.DBManagement.Cuentas;
import com.mycompany.infraestructura.DBManagement.Movimientos;
import com.mycompany.infraestructura.DBManagement.Persona;
import com.mycompany.infraestructura.Modelo.CiudadModelo;
import com.mycompany.infraestructura.Modelo.ClienteModelo;
import com.mycompany.infraestructura.Modelo.CuentaModelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Examenparcial1 {
    

    public static void main(String[] args) {
        Ciudad ciudadConex = new Ciudad("postgres","0000","localhost","5432","exapar");
        Cliente clienteConex = new Cliente("postgres","0000","localhost","5432","exapar");
        Cuentas cuentaConex = new Cuentas("postgres","0000","localhost","5432","exapar");
        Movimientos movimientoConex = new Movimientos("postgres","0000","localhost","5432","exapar");
        Persona personaConex = new Persona("postgres","0000","localhost","5432","exapar");
        CiudadModelo newCity = new CiudadModelo();
        CuentaModelo newCuenta = new CuentaModelo();
        ClienteModelo newCliente= new ClienteModelo();
        
 
        newCliente.IdPersona=2 ;
        newCliente.Calificacion="Buena" ;
        newCliente.Estado="Activa" ;
        newCliente.FechaIngreso= java.sql.Date.valueOf("2023-09-20"); 
        
        // CUENTAAA
        /*newCuenta.IdCliente= 1;
        newCuenta.TipoCuenta= " ";
        newCuenta.Estado= " ";
        newCuenta.Saldo= ;
        newCuenta.NroCuenta= " ";
        newCuenta.NroContrato= " ";
        newCuenta.CostoMantenimiento= 1;
        newCuenta.PromedioAcreditacion= " ";
        newCuenta.Moneda=" ";
        newCuenta.FechaAlta= ;*/
        
 
        /*newCuenta.IdCliente = 101;
        newCuenta.TipoCuenta = "Cuenta de Ahorro";
        newCuenta.Estado = "Activa";
        newCuenta.Saldo = (float) 5000.00;
        newCuenta.NroCuenta = "123456789";
        newCuenta.NroContrato = "CONTRATO-001";
        newCuenta.CostoMantenimiento = 10;
        newCuenta.PromedioAcreditacion = "Mensual";
        newCuenta.Moneda = "USD";
        newCuenta.FechaAlta = java.sql.Date.valueOf("2023-09-20");*/
        
        /*int id = 1;
        CuentaModelo consulta1 = cuentaConex.consultarcuenta(id);
        System.out.println("Inicio Consulta cuenta");
        System.out.println(consulta1.get);*/
        
        
        
        /*int id = 1;
        CiudadModelo consulta = ciudadConex.consultarciudad(id);
        System.out.println("Inicio Consulta ciudad");
        System.out.println(consulta.getCiudad());*/
        
         clienteConex.registrarCliente(newCliente);
          System.out.println("Terminado");
        
        
        
        //ciudadConex.modificarciudad(newCity, 1);
        
        //CLIENTE
        
        
       /* cuentaConex.registrarCuentas(newCuenta);
        System.out.println("Terminado");*/
    }
}
