package com.mycompany.infraestructura.DBManagement;

import com.mycompany.infraestructura.Modelo.ClienteModelo;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Cliente {
     private Conexiones conexion;

    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModelo cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "idcliente, " +
                    "idpersona, " +
                    "calificacion, " +
                    "estado, " +
                    "fechaingreso) " +
                    "values('" +
                    cliente.IdCliente + "', '" +
                    cliente.IdPersona + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado + "', '" +
                    cliente.FechaIngreso + "')");
            conexion.conexionDB().close();
            return "El cliente " + cliente.IdCliente + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModelo cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "idpersona = '" + cliente.IdPersona + "'," +
                    "calificacion = '" + cliente.Calificacion + "'," +
                    "estado = '" + cliente.Estado + "'," +
                    "fechaingreso = '" + cliente.FechaIngreso + "' Where idcliente = " + cliente.IdCliente);
            conexion.conexionDB().close();
            return "Los datos del cliente " + cliente.IdCliente + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModelo consultarCliente(int id){
        ClienteModelo cliente= new ClienteModelo();
       
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cliente where idcliente = " + id));
            if(conexion.getResultadoQuery().next()){
                cliente.setIdCliente(conexion.getResultadoQuery().getInt("idcliente"));
                cliente.setIdPersona(conexion.getResultadoQuery().getInt("idpersona"));
                cliente.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
                cliente.setEstado(conexion.getResultadoQuery().getString("estado"));
                cliente.setFechaIngreso(conexion.getResultadoQuery().getDate("fechaingreso"));
               
                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
   
}
