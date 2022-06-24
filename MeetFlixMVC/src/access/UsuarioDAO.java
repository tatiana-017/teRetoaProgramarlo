package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.usuarioModel;
import utils.conectionDB;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioDAO {

    private Connection conn = null;

    public ArrayList<usuarioModel> todoUsuario() {
        ArrayList<usuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }

            //Traemos nuestros datos de la BD
            String sql = "SELECT alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua  FROM usuario; ";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            //Llenamos nuestra ArrayList
            while (result.next()) {
                usuarioModel usuario;
                usuario = new usuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    public ArrayList<usuarioModel> usuarioPorAlias(String alias) {
        ArrayList<usuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }

            String sql = "SELECT alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua  FROM usuario WHERE alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usuarioModel usuario = new usuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    public ArrayList<usuarioModel> usuarioPorNombre(String nombre) {
        ArrayList<usuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }

            String sql = "SELECT alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua  FROM usuario WHERE nombre=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usuarioModel usuario = new usuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    public void insertarUsuario(usuarioModel usuario) throws ParseException {
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }
                        
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = formatter.parse(usuario.getFechaUsua());
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            
            String sql = "INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) \n"
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getAlias());
            statement.setString(2, usuario.getNombreUsua());
            statement.setString(3, usuario.getApellidoUsua());
            statement.setString(4, usuario.getEmailUsua());
            statement.setString(5, usuario.getCelular());
            statement.setString(6, usuario.getContrasenia());
            statement.setDate(7, sqlDate);

            //Acá verificamos que la filas hayan sido modificadas 
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro existoso.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void modificarUsuario(usuarioModel usuario) {
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }

            String sql = "UPDATE usuario SET alias =?, nombre_usua =? , apellido_usua =? , email_usua=?, celular=?, contrasenia=?, fecha_usua=? WHERE alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getAlias());
            statement.setString(2, usuario.getNombreUsua());
            statement.setString(3, usuario.getApellidoUsua());
            statement.setString(4, usuario.getEmailUsua());
            statement.setString(5, usuario.getCelular());
            statement.setString(6, usuario.getContrasenia());
            statement.setString(7, usuario.getFechaUsua());
            statement.setString(8, usuario.getOldAlias());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void eliminarUsuario(String alias) {
        try {
            if (conn == null) {
                conn = conectionDB.getConnection();
            }

            String sql = "DELETE FROM usuario WHERE alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

}
