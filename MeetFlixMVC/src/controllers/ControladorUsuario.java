package controllers;

import access.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.usuarioModel;

public class ControladorUsuario {

  private ArrayList<usuarioModel> usuarios = null; 
   
  
  public ControladorUsuario(){
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      this.usuarios = usuarioDAO.todoUsuario();
      
  }
    /**
     * @return the usuarios
     */
    public ArrayList<usuarioModel> getUsuarios() {
        return usuarios;
    }

    public void actualizarValores(TableModelEvent event, usuarioModel usuario) {
        TableModel model = (TableModel) event.getSource();
        int filaAfectada = event.getFirstRow();

        usuario.setAlias(model.getValueAt(filaAfectada, 0).toString());
        usuario.setNombreUsua(model.getValueAt(filaAfectada, 1).toString());
        usuario.setApellidoUsua(model.getValueAt(filaAfectada, 2).toString());
        usuario.setEmailUsua(model.getValueAt(filaAfectada, 3).toString());
        usuario.setCelular(model.getValueAt(filaAfectada, 4).toString());
        usuario.setContrasenia(model.getValueAt(filaAfectada, 5).toString());
        usuario.setFechaUsua(model.getValueAt(filaAfectada, 6).toString());
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.modificarUsuario(usuario);

    }


  
  
}
