
package com.mycompany.servicios;
import com.mycompany.infraestructura.DBManagement.Usuario;
import com.mycompany.infraestructura.Modelo.UsuarioModelo;



public class UsuarioService {
        Usuario usuarioDB;
    public UsuarioService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        usuarioDB = new Usuario(userBD, passDB, hostDB, portDB, dataBase);
    }

    public UsuarioModelo consultarUsuario(int id){
        return  usuarioDB.consultarusuario(id);
    }

    public boolean validarDatos(String email, String pass, UsuarioModelo usuario) {
        try {
        if(email.trim().isEmpty())
            throw new Exception("El email no debe estar vacío");
        else if (email.trim().length() < 3) {
            throw new Exception("El email no tiene la longitud necesaria");
        } else if (pass.trim().length() < 3) {
            throw new Exception("La contrasena no tiene la longitud necesaria");
        }else if (pass != usuario.getPass() ){
            throw new Exception("La contrasena es incorrecta");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}

