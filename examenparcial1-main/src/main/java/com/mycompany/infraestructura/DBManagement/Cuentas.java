/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura.DBManagement;


import com.mycompany.infraestructura.Modelo.CuentaModelo;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Cuentas {
    private Conexiones conexion;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuentas(CuentaModelo cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "idcliente, " +
                    "tipocuenta, " +
                    "estado, " +
                    "saldo, " +
                    "nrocuenta, " +
                    "nrocontrato, " +
                    "costomantenimiento, " +
                    "promedioacreditacion, " +
                    "moneda, " +
                    "fechaalta) " +
                    "values('" +
                    cuenta.IdCliente + "', '" +
                    cuenta.TipoCuenta + "', '" +
                    cuenta.Estado + "', '" +
                    cuenta.Saldo + "', '" +
                    cuenta.NroCuenta + "', '" +
                    cuenta.NroContrato + "', '" +
                    cuenta.CostoMantenimiento + "', '" +
                    cuenta.PromedioAcreditacion + "', '" +
                    cuenta.Moneda + "', '" +
                    cuenta.FechaAlta + 
                    "')");
            conexion.conexionDB().close();
            return "La cuenta " + cuenta.NroCuenta+ " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarcuenta(CuentaModelo cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuenta SET " +
                    "tipocuenta = '" + cuenta.TipoCuenta + "'," +
                    "estado = '" + cuenta.Estado + "'," +
                    "saldo = '" + cuenta.Saldo + "'," +
                    "Nrocuenta = '" + cuenta.NroCuenta + "'," +        
                    "nrocontrato = '" + cuenta.NroContrato+ "'," +
                    "costomantenimiento = '" + cuenta.CostoMantenimiento + "'," + 
                    "promedioacreditacion = '" + cuenta.PromedioAcreditacion + "'," +
                    "moneda = '" + cuenta.Moneda + "'," +        
                    "fechaalta = '" + cuenta.FechaAlta + "'," 
                            + "' Where idcuenta = " + cuenta.IdCuenta);
            conexion.conexionDB().close();
            return "Los datos de la cuenta Nro: " + cuenta.NroCuenta + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentaModelo consultarcuenta(CuentaModelo cuenta){
        ;
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cuenta where id = " + cuenta.IdCuenta));
            if(conexion.getResultadoQuery().next()){
                cuenta.setIdCliente(conexion.getResultadoQuery().getInt("idcliente"));
                cuenta.setTipoCuenta(conexion.getResultadoQuery().getString("tipocuenta"));
                cuenta.setEstado(conexion.getResultadoQuery().getString("estado"));
                cuenta.setSaldo(conexion.getResultadoQuery().getFloat("saldo"));
                cuenta.setNroCuenta(conexion.getResultadoQuery().getString("Nrocuenta"));
                cuenta.setNroContrato(conexion.getResultadoQuery().getString("nrocontrato"));
                cuenta.setCostoMantenimiento(conexion.getResultadoQuery().getInt("costomantenimiento"));
                cuenta.setMoneda(conexion.getResultadoQuery().getString("moneda"));
                cuenta.setFechaAlta(conexion.getResultadoQuery().getDate("fechaalta"));
              cuenta.IdCuenta = conexion.getResultadoQuery().getInt("idcuenta");
              cuenta.IdCliente = conexion.getResultadoQuery().getInt("idcliente");
              cuenta.TipoCuenta = conexion.getResultadoQuery().getString("tipocuenta");
              cuenta.Estado = conexion.getResultadoQuery().getString("estado");
              cuenta.Saldo = conexion.getResultadoQuery().getFloat("saldo");
              cuenta.NroCuenta = conexion.getResultadoQuery().getString("Nrocuenta");
              cuenta.NroContrato = conexion.getResultadoQuery().getString("nrocontrato");
              cuenta.CostoMantenimiento = conexion.getResultadoQuery().getInt("costomantenimiento");
              cuenta.PromedioAcreditacion = conexion.getResultadoQuery().getString("promedioacreditacion");
              cuenta.Moneda = conexion.getResultadoQuery().getString("moneda");
              cuenta.FechaAlta= conexion.getResultadoQuery().getDate("fechaalta");
                return cuenta;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
