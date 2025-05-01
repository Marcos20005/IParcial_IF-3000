import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaGeneral implements ActionListener {
 
   JButton btnCaso;
    JButton btnMostrarCaso;
    JButton btnEliminarCaso;
    JButton btnModificarCaso;
    JButton btnsalir;
    
  ArrayList<Caso> ListaCasos = new ArrayList();
    public VistaGeneral() {
        JFrame frame = new JFrame("Vienvenido a sistema de denuncia.");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container conte = new Container();

            JTabbedPane tab = new JTabbedPane();
            JPanel panelCaso = new JPanel();
 
   btnCaso = new JButton("Caso");
    btnCaso.setBounds(50, 50, 200, 30);
    conte.add(btnCaso);
    btnCaso.addActionListener(this);

    btnMostrarCaso = new JButton("Mostrar Casos");
    btnMostrarCaso.setBounds(50, 100, 200, 30);
    conte.add(btnMostrarCaso);
    btnMostrarCaso.addActionListener(this);

    btnEliminarCaso = new JButton("Eliminar Caso"); 
    btnEliminarCaso.setBounds(50, 150, 200, 30);
    conte.add(btnEliminarCaso);
    btnEliminarCaso.addActionListener(this);

    btnModificarCaso = new JButton("Modificar Caso");
    btnModificarCaso.setBounds(50, 200, 200, 30);
    conte.add(btnModificarCaso);
    btnModificarCaso.addActionListener(this);

    btnsalir = new JButton("Salir");
    btnsalir.setBounds(50, 250, 200, 30);
    conte.add(btnsalir);
    btnsalir.addActionListener(this);



frame.setSize(800, 600);
frame.add(conte);
frame.setLocationRelativeTo(null);
      
        frame.setVisible(true);

    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCaso) {
           vistaCasos();

        }
        if (e.getSource() == btnMostrarCaso) {
           
           
        }
        if (e.getSource() == btnEliminarCaso) {
            // Aquí puedes agregar la lógica para manejar el evento del botón "Eliminar Caso"
           
        }
        if (e.getSource() == btnModificarCaso) {
            // Aquí puedes agregar la lógica para manejar el evento del botón "Modificar Caso"
           
        }
        if (e.getSource() == btnsalir) {
           System.exit(0);
           
        }
    }
    public String obtenerFecha(){
      Date fecha = new Date();
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      return formato.format(fecha);

    }

    public String obtenerHora(){

        Date hora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss a");
        return formato.format(hora);
    }
    public void vistaCasos(){
        JFrame frame = new JFrame("Registre la informacion solicitada");
        
        frame.setSize(600,500);

        Container conte = new Container();
        
        JLabel lblFecha = new JLabel("Fecha de la denucia:  "+obtenerFecha());
        lblFecha.setBounds(30, 50, 200, 30);
        conte.add(lblFecha);
        JLabel lblHora = new JLabel("Hora de la denuncia:   "+obtenerHora());
        lblHora.setBounds(30, 100, 220, 30);
        conte.add(lblHora);
        JLabel lblDescripcion = new JLabel("Descripcion de la denuncia:");
        lblDescripcion.setBounds(330, 30, 200, 30);
        conte.add(lblDescripcion);
        JTextArea txtDescripcion = new JTextArea();
        txtDescripcion.setLineWrap(true);
        
        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(260, 70, 300, 200);
        conte.add(scroll);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 400, 100, 30);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ListaCasos.add(new Caso(obtenerFecha(), obtenerHora(), txtDescripcion.getText()));
               frame.dispose(); 
            }
        });

        frame.add(conte);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    

    }
}


