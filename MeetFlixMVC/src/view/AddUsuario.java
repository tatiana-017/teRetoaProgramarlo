package view;

import access.UsuarioDAO;
import controllers.ControladorUsuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.usuarioModel;
import view.ControlsPanel;

public class AddUsuario extends JFrame implements ActionListener{
    private JLabel      alias;
    private JTextField  inputAlias;
    private JLabel      nombre;
    private JTextField  inputNombre;
    private JLabel      apellido;
    private JTextField  inputApellido;
    private JLabel      email;
    private JTextField  inputEmail;
    private JLabel      celular;
    private JTextField  inputCelular;
    private JLabel      contrasenia;
    private JTextField  inputContrasenia;
    private JLabel      fecha;
    private JTextField  inputFecha;
    private JButton     crear;
    private JButton     cancelar;
    
    private ControlsPanel controlsPanel;
    
    public AddUsuario(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Agregar nuevo usuario");
        setLayout(new GridLayout(8, 2));
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        
        this.alias = new JLabel("Alias");
        add(this.alias);
        this.inputAlias = new JTextField();
        add(this.inputAlias);
        
        this.nombre = new JLabel("Nombre");
        add(this.nombre);
        this.inputNombre = new JTextField();
        add(this.inputNombre);
        
        this.apellido = new JLabel("Apellido");
        add(this.apellido);
        this.inputApellido = new JTextField();
        add(this.inputApellido);
        
        this.email = new JLabel("Email");
        add(this.email);
        this.inputEmail = new JTextField();
        add(this.inputEmail);
        
        this.celular = new JLabel("Celular");
        add(this.celular);
        this.inputCelular = new JTextField();
        add(this.inputCelular);
        
        this.contrasenia = new JLabel("Contraseña");
        add(this.contrasenia);
        this.inputContrasenia = new JTextField();
        add(this.inputContrasenia);
        
        this.fecha = new JLabel("Fecha de nacimiento");
        add(this.fecha);
        this.inputFecha = new JTextField();
        add(this.inputFecha);
        
        
        this.crear = new JButton("Crear");
        add(this.crear);
        this.crear.addActionListener(this);
        
        this.cancelar = new JButton("Cancelar");
        add(this.cancelar);
        this.cancelar.addActionListener(this);
        
        setSize(800, 600);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        pack();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()== this.crear){
            String alias       = (String)this.inputAlias.getText();
            String nombre      = (String)this.inputNombre.getText();
            String apellido    = (String)this.inputApellido.getText();
            String email       = (String)this.inputEmail.getText();
            String celular     = (String)this.inputCelular.getText();
            String contrasenia = (String)this.inputContrasenia.getText();
            String fecha       = (String)this.inputFecha.getText();
            
            usuarioModel usuarioModel = new usuarioModel(alias, nombre, apellido, email, celular, contrasenia, fecha );
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
    
            try {
                usuarioDAO.insertarUsuario(usuarioModel);
            } catch (ParseException ex) {
                Logger.getLogger(AddUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.controlsPanel.setTblResults(usuarioDAO.todoUsuario());
            
        } else if(actionEvent.getSource()== this.cancelar){
            this.dispose();
        }
        
    }

}
