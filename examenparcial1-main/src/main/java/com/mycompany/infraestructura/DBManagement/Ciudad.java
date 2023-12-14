
package com.mycompany.infraestructura.DBManagement;

import com.mycompany.infraestructura.Modelo.CiudadModelo;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;


public class Ciudad {
    private Conexiones conexion;


    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModelo ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "ciudad, " +
                    "departamento, " +
                    "postal) " +
                    " values('" +
                    ciudad.Ciudad + "', '" +
                    ciudad.Departamento + "', '" +
                    ciudad.Postal +
                    "')");
            conexion.conexionDB().close();
            return "La ciudad " + ciudad.Ciudad + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarciudad(CiudadModelo ciudad, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudad.Ciudad + "'," +
                    "departamento = '" + ciudad.Departamento + "'," +
                    "postal = '" + ciudad.Postal + "'" 
                            + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.Ciudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModelo consultarciudad(int id){
            CiudadModelo ciudad= new CiudadModelo();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudad where id = " + id));
            if(conexion.getResultadoQuery().next()){
                ciudad.setCiudad(conexion.getResultadoQuery().getString("ciudad"));
                ciudad.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
                ciudad.setPostal(conexion.getResultadoQuery().getInt("postal"));
                ciudad.Ciudad = conexion.getResultadoQuery().getString("ciudad");
                ciudad.Departamento = conexion.getResultadoQuery().getString("departamento");
                ciudad.Postal = conexion.getResultadoQuery().getInt("postal");


                return ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
