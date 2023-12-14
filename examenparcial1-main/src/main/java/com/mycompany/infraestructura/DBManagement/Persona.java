/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura.DBManagement;

import com.mycompany.infraestructura.Modelo.PersonaModelos;
import com.mycompany.infraestructura.conexiones.Conexiones;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Persona {
    private Conexiones conexion;

    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModelos persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO persona(" +
                    "idpersona, " +
                    "idciudad, " +
                    "nombre, " +
                    "apellido, " +
                    "tipodocumento, " +
                    "nrodocumento, " +
                    "direccion," +
                    "celular, " +
                    "email, " +
                    "estado) " +
                    "values('" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.Estado + "'))");
            conexion.conexionDB().close();
            return "La persona " + persona.Nombre + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModelos persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "idciudad = '" + persona.IdCiudad + "'," +
                    "nombre = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipodocumento = '" + persona.TipoDocumento + "'," +
                    "nrodocumento = '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "estado = '" + persona.Estado + "' Where idPersona = " + persona.IdPersona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModelos consultarPersona(int id){
        PersonaModelos persona = new PersonaModelos();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where idPersona = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.IdPersona = conexion.getResultadoQuery().getInt("idpersona");
                persona.IdCiudad = conexion.getResultadoQuery().getInt("idciudad");
                persona.Nombre = conexion.getResultadoQuery().getString("nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("apellido");
                persona.TipoDocumento = conexion.getResultadoQuery().getString("tipodocumento");
                persona.NroDocumento = conexion.getResultadoQuery().getString("nrodocumento");
                persona.Direccion = conexion.getResultadoQuery().getString("direccion");
                persona.Celular = conexion.getResultadoQuery().getString("celular");
                persona.Email = conexion.getResultadoQuery().getString("email");
                persona.Estado = conexion.getResultadoQuery().getString("estado");


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
