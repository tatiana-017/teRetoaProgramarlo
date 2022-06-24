package controllers;

import access.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.usuarioModel;
import view.AddUsuario;
import view.ControlsPanel;

public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ClickEvent(ControlsPanel controlsPanel) {
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (actionEvent.getSource() == this.controlsPanel.getEliminar()) {
            usuarioDAO.eliminarUsuario(this.controlsPanel.usuario.getOldAlias());
            this.controlsPanel.setTblResults(usuarioDAO.todoUsuario());
            
        } else if (actionEvent.getSource() == this.controlsPanel.getAgregar()) {
            AddUsuario addUsuario = new AddUsuario(this.controlsPanel);
            addUsuario.setVisible(true);
            
        } else if (actionEvent.getSource() == this.controlsPanel.getInputBuscar() || actionEvent.getSource() == this.controlsPanel.getBuscar()) {
            String buscarUsuario = this.controlsPanel.getInputBuscar().getText();

            if (buscarUsuario.isEmpty()) {
                this.controlsPanel.setTblResults(usuarioDAO.todoUsuario());
            } else {
                this.controlsPanel.setTblResults(usuarioDAO.usuarioPorAlias(buscarUsuario));
            }
        }

    }
}
