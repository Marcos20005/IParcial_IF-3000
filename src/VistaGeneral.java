import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
           
          mosCasos();
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
        String estado[] = {"Soltero/a", "Casado/a","Divorsiado/a","Separado/a","Viudo/a","Concubinato"};
        String cViolencia[] = {"Violencia Digital","Violencia Economica","Violencia Emocional","Violencia Fisica","Violencia Sexual"};
         
        JFrame frame = new JFrame("Registre la informacion solicitada");
        
        

        Container conte = new Container();
        
        JLabel lblFecha = new JLabel("Fecha de la denucia:  "+obtenerFecha());
        lblFecha.setBounds(30, 50, 200, 30);
        conte.add(lblFecha);
        JLabel lblHora = new JLabel("Hora de la denuncia:   "+obtenerHora());
        lblHora.setBounds(30, 100, 220, 30);
        conte.add(lblHora);
        JLabel lblDescripcion = new JLabel("Descripcion de la denuncia:");
        lblDescripcion.setBounds(330, 20, 200, 30);
        conte.add(lblDescripcion);
        JTextArea txtDescripcion = new JTextArea();
        txtDescripcion.setLineWrap(true);
        
        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(260, 60, 300, 200);
        conte.add(scroll);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 510, 100, 30);
        conte.add(btnGuardar);
        

        JLabel iVictima = new JLabel("Informacion de la vicitma");
        iVictima.setBounds(30,  190, 200, 30);
      conte.add(iVictima);

      JLabel vNombre = new JLabel("Nombre de la personas");
      vNombre.setBounds(30, 270, 200, 30);
      conte.add(vNombre);

      JTextField vNombre1 = new JTextField();
      vNombre1.setBounds(30,300,150,30); 
      conte.add(vNombre1);

      JLabel vCedula = new JLabel("Cedula de la persona");
      vCedula.setBounds(30, 340, 150, 30);
      conte.add(vCedula);

      JTextField cVictima = new JTextField();
      cVictima.setBounds(30, 370, 150, 30);
      conte.add(cVictima);
     
      JLabel vNumero = new JLabel("Numero celular de la persona");
      vNumero.setBounds(30, 410, 190, 30);
      conte.add(vNumero);

      JTextField vNumero1 = new JTextField();
      vNumero1.setBounds(30, 440, 150, 30);
      conte.add(vNumero1);
      
      JLabel vDireccion = new JLabel("Direccion de lapersona");
      vDireccion.setBounds(220, 340, 190, 30);
      conte.add(vDireccion);

      JTextField vDireccion1 = new JTextField();
      vDireccion1.setBounds(220, 370, 150, 30);
      conte.add(vDireccion1);
       
      JLabel vEdad = new JLabel("Edad de la persona");
      vEdad.setBounds(220, 270, 150, 30);
      conte.add(vEdad);

      JTextField vEdad1 = new JTextField();
      vEdad1.setBounds(220, 300, 150, 30);
      conte.add(vEdad1);

      JLabel vGenero = new JLabel("Genero de la persona");
      vGenero.setBounds(410, 260, 150, 30);
      conte.add(vGenero);

      ButtonGroup botones = new ButtonGroup();

      JRadioButton vGenero1 = new JRadioButton("Masculino");
      vGenero1.setBounds(480, 290, 150, 30);
      botones.add(vGenero1);
      conte.add(vGenero1);
      
      JRadioButton vGenero2 = new JRadioButton("Femenino");
      vGenero2.setBounds(380, 290, 150, 30);
      botones.add(vGenero2);
      conte.add(vGenero2);
      
      

     JRadioButton vGenero3 = new JRadioButton("Otro");
      vGenero3.setBounds(440, 320, 150, 30);
      botones.add(vGenero3);
      conte.add(vGenero3);

      JLabel vEcivil = new JLabel("Estado civil de la persona");
      vEcivil.setBounds(410, 340, 190, 30);
      conte.add(vEcivil);

      JComboBox vEcivil1 = new JComboBox(estado);
      vEcivil1.setBounds(410, 370, 150, 30);
      conte.add(vEcivil1);

      JLabel vOcupacion = new JLabel("Ocupacion de la persona");
      vOcupacion.setBounds(220, 410, 190, 30);
      conte.add(vOcupacion);

      JTextField vOcupacion1 = new JTextField();
      vOcupacion1.setBounds(220, 440, 150, 30);
      conte.add(vOcupacion1);
      
      JLabel vNacionalidad = new JLabel("Nacionalidad de la persona");
      vNacionalidad.setBounds(410, 410, 190, 30);
      conte.add(vNacionalidad);

      JTextField vNacionalidad1 = new JTextField();
      vNacionalidad1.setBounds(410, 440, 150, 30);
      conte.add(vNacionalidad1);

      JLabel tViolencia = new JLabel("Tipo de violencia");
      tViolencia.setBounds(410, 480, 190, 30);
      conte.add(tViolencia);

      JComboBox tViolencia1 = new JComboBox(cViolencia);
      tViolencia1.setBounds(410, 510, 150, 30);
      conte.add(tViolencia1);

      
      frame.setSize(630,600);
        frame.add(conte);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

       
    btnGuardar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String genero = "";
            if (vGenero1.isSelected()) {
                genero = "Masculino";
            } else if (vGenero2.isSelected()) {
                genero ="Femenino";
            } else if (vGenero3.isSelected()) {
                genero = "Otro";
            }



            if (tViolencia1.getSelectedItem().toString()=="Violencia Digital") {
                ListaCasos.add(new vDigital(vNombre1.getText(), cVictima.getText(), Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), 
                Integer.parseInt(vEdad1.getText()), genero, vEcivil1.getSelectedItem().toString(),vOcupacion1.getText(), vNacionalidad1.getText()));
                   
                }else if (tViolencia1.getSelectedItem().toString()=="Violencia Economica") {
                    
                }else if (tViolencia1.getSelectedItem().toString()=="Violencia Emocional") {
                    
                }else if (tViolencia1.getSelectedItem().toString()=="Violencia Fisica") {
                    
                }else if (tViolencia1.getSelectedItem().toString()=="Violencia Sexual") {
                    
                }

frame.dispose();

        }
    });

    }
    public void mosCasos(){

        JFrame frame = new JFrame("Casos registrados");
        Container conte = new Container();

        JTextArea textArea = new JTextArea();
        textArea.setBounds(40, 50, 700, 400);
        conte.add(textArea);
        
        for (int i = 0; i < ListaCasos.size(); i++) {
            
            textArea.setText(textArea.getText() + "\n"+ListaCasos.get(i).mostrarcaso());
        }

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(40, 470, 100, 30);
        conte.add(btnCerrar);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(conte);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}





