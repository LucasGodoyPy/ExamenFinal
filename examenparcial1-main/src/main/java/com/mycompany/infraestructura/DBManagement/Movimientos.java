/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura.DBManagement;

import com.mycompany.infraestructura.Modelo.MovimientoModelo;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Movimientos {
     private Conexiones conexion;

    public Movimientos(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientoModelo movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos(" +
                    "idmovimiento, " +
                    "idcuenta, " +
                    "tipomovimiento, " +
                    "saldoanterior, " +
                    "saldoactual, " +
                    "'montomovimiento, " +
                    "'cuentaorigen, " +
                    "'cuentadestino, " +
                    "'canal, " +
                    "'fechamovimiento, " +
                    "values('" +
                    movimientos.IdMovimiento+ "', '" +
                    movimientos.IdCuenta+ "', '" +
                    movimientos.TipoMovimiento+ "', '" +
                    movimientos.SalarioAnterior+ "', '" +
                    movimientos.SaldoActual+ "', '" +
                    movimientos.MontoMovimiento+ "', '" +
                    movimientos.CuentaOrigen+ "', '" +
                    movimientos.CuentaDestino+ "', '" +
                    movimientos.Canal + "', '" +
                    movimientos.FechaMovimiento + "'))");
            conexion.conexionDB().close();
            return "El movimiento Nro: " + movimientos.IdMovimiento + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(MovimientoModelo movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "idcuenta = '" + movimientos.IdCuenta + "'," +
                    "tipomovimiento = '" + movimientos.TipoMovimiento + "'," +
                    "saldoanterior = '" + movimientos.SalarioAnterior + "'," +
                    "saldoactual = '" + movimientos.SaldoActual + "'," +
                    "montomovimiento = '" + movimientos.MontoMovimiento + "'," +
                    "cuentaorigen = '" + movimientos.CuentaOrigen + "'," +
                    "cuentadestino = '" + movimientos.CuentaDestino + "'," +        
                    "canal = '" + movimientos.Canal + "'," +
                    "fechamovimiento = '" + movimientos.FechaMovimiento + "' " + " Where idcliente = " + movimientos.IdMovimiento);
            conexion.conexionDB().close();
            return "Los datos del movimiento Nro:" + movimientos.IdMovimiento + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientoModelo consultarMovimiento(int id){
        MovimientoModelo movimientos = new MovimientoModelo();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cliente where idmovimiento = " + id));
            if(conexion.getResultadoQuery().next()){
                movimientos.IdMovimiento = conexion.getResultadoQuery().getInt("idmovimiento");
                movimientos.IdCuenta = conexion.getResultadoQuery().getInt("idcuenta");
                movimientos.TipoMovimiento = conexion.getResultadoQuery().getString("tipomovimiento");
                movimientos.SalarioAnterior = conexion.getResultadoQuery().getFloat("salarioanterior");
                movimientos.SaldoActual = conexion.getResultadoQuery().getFloat("saldoactual");
                movimientos.MontoMovimiento = conexion.getResultadoQuery().getFloat("montomovimiento");
                movimientos.CuentaOrigen = conexion.getResultadoQuery().getFloat("cuentaorigen");
                movimientos.CuentaDestino = conexion.getResultadoQuery().getFloat("cuentadestino");
                movimientos.Canal = conexion.getResultadoQuery().getFloat("canal");
                movimientos.FechaMovimiento = conexion.getResultadoQuery().getDate("fechamovimiento");
                return movimientos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
}
