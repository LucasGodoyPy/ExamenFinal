
package com.mycompany.infraestructura.DBManagement;

import com.mycompany.infraestructura.Modelo.UsuarioModelo;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;

public class Usuario {
    private Conexiones conexion;


    public Usuario(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarUsuario(UsuarioModelo usuario){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO usuario(" +
                    "nombre, " +
                    "email, " +
                    "pass) " +
                    " values('" +
                    usuario.getNombre() + "', '" +
                    usuario.getEmail() + "', '" +
                    usuario.getPass() +
                    "')");
            conexion.conexionDB().close();
            return "El usuario " + usuario.getNombre() + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarusuario(UsuarioModelo usuario, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE usuario SET " +
                    "Nombre = '" + usuario.getNombre() + "'," +
                    "Email = '" + usuario.getEmail() + "'," +
                    "Pass = '" + usuario.getPass() + "'" 
                            + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos del usuario " + usuario.getNombre() + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UsuarioModelo consultarusuario(int id){
            UsuarioModelo usuario= new UsuarioModelo();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from usuario where id = " + id));
            if(conexion.getResultadoQuery().next()){
                usuario.setNombre(conexion.getResultadoQuery().getString("Nombre"));
                usuario.setEmail(conexion.getResultadoQuery().getString("Email"));
                usuario.setPass(conexion.getResultadoQuery().getString("Pass"));

                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

