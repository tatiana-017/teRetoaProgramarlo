package view;

import controllers.ClickEvent;
import controllers.ControladorUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import model.usuarioModel;

public class ControlsPanel extends JPanel {

    ControladorUsuario controladorUsuario = new ControladorUsuario();

    private JButton    buscar;
    private JButton    eliminar;
    private JButton    agregar;
    private JTextField inputBuscar; 
    private JTable     tblResults;
    public usuarioModel usuario = new usuarioModel();

    ControlsPanel(ResultsPanel resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {

        ClickEvent clickEvent = new ClickEvent(this);

        this.inputBuscar = new JTextField("", 20);
        add(this.getInputBuscar());
        this.inputBuscar.addActionListener(clickEvent);

        this.buscar = new JButton("Buscar");
        add(this.getBuscar());
        this.buscar.addActionListener(clickEvent);

        this.eliminar = new JButton("Eliminar");
        add(this.getEliminar());
        this.eliminar.addActionListener(clickEvent);

        this.agregar = new JButton("Agregar");
        add(this.getAgregar());
        this.agregar.addActionListener(clickEvent);

        this.setTblResults(controladorUsuario.getUsuarios());

    }

    public void setTblResults(ArrayList<usuarioModel> usuarios) {
        
        String[] headers = {"Alias", "Nombre", "Apellido", "Correo", "Celular", "Contraseña", "Fecha"};

        this.tblResults.removeAll();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);

        for (int i = 0; i < usuarios.size(); i++) {
            tableModel.addRow(usuarios.get(i).toArray());
        }
        this.tblResults.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblResults.getSelectedRow();
                usuario.setOldAlias(tableModel.getValueAt(row, 0).toString());
                System.out.println(usuario.getOldAlias());
            }
        });

        tableModel.addTableModelListener((TableModelEvent e) -> {
            controladorUsuario.actualizarValores(e, usuario);
        });
    }

    /**
     * @return the buscar
     */
    public JButton getBuscar() {
        return buscar;
    }

    /**
     * @return the eliminar
     */
    public JButton getEliminar() {
        return eliminar;
    }

    /**
     * @return the agregar
     */
    public JButton getAgregar() {
        return agregar;
    }

    /**
     * @return the inputBuscar
     */
    public JTextField getInputBuscar() {
        return inputBuscar;
    }

}
