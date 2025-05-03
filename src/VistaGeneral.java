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
import javax.swing.JOptionPane;
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
    JButton btnVisualizarCaso;
    
    ArrayList<Caso> ListaCasos = new ArrayList();

    public VistaGeneral() {
        JFrame frame = new JFrame("Bienvenido al sistema de denuncia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();
        JPanel panelCaso = new JPanel();
        JPanel panelMostrarCaso = new JPanel();
     
        panelCaso.setLayout(null);
        panelMostrarCaso.setLayout(null);

        btnCaso = new JButton("Caso");
        btnCaso.setBounds(40, 50, 200, 30);
        panelCaso.add(btnCaso);
        btnCaso.addActionListener(this);

        btnMostrarCaso = new JButton("Mostrar Casos");
        btnMostrarCaso.setBounds(50, 100, 200, 30);
        panelMostrarCaso.add(btnMostrarCaso);
        btnMostrarCaso.addActionListener(this);

        btnEliminarCaso = new JButton("Resolver Caso"); 
        btnEliminarCaso.setBounds(50, 150, 200, 30);
        panelMostrarCaso.add(btnEliminarCaso);
        btnEliminarCaso.addActionListener(this);

        btnVisualizarCaso = new JButton("Visualizar Caso"); 
        btnVisualizarCaso.setBounds(40, 100, 200, 30);
        panelCaso.add(btnVisualizarCaso);
        btnVisualizarCaso.addActionListener(this);

        btnModificarCaso = new JButton("Modificar Caso");
        btnModificarCaso.setBounds(40, 150, 200, 30);
        panelCaso.add(btnModificarCaso);
        btnModificarCaso.addActionListener(this);

        btnsalir = new JButton("Salir");
        btnsalir.setBounds(40, 200, 200, 30);
        panelCaso.add(btnsalir);
        btnsalir.addActionListener(this);

        tab.addTab("Usuario", panelCaso);
        tab.addTab("Institucion", panelMostrarCaso);
        frame.setSize(300, 400);
        frame.add(tab);
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
            resolverCaso();
        }
        if (e.getSource() == btnVisualizarCaso) {
            visualizarCaso();
        }
        if (e.getSource() == btnModificarCaso) {
            modificarCaso();
        }
        if (e.getSource() == btnsalir) {
            System.exit(0);
        }
    }

    public String obtenerFecha() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    public String obtenerHora() {
        Date hora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss a");
        return formato.format(hora);
    }

    public void vistaCasos() {
        String estado[] = {"Soltero/a", "Casado/a", "Divorciado/a", "Separado/a", "Viudo/a", "Concubinato"};
        String cViolencia[] = {"Violencia Digital", "Violencia Economica", "Violencia Emocional", "Violencia Fisica", "Violencia Sexual"};
         
        JFrame frame = new JFrame("Registre la informacion solicitada");
        Container conte = new Container();
        conte.setLayout(null);
        String f = obtenerFecha();
        String h = obtenerHora();

        JLabel lblFecha = new JLabel("Fecha de la denuncia:  " + f);
        lblFecha.setBounds(30, 50, 200, 30);
        conte.add(lblFecha);
        JLabel lblHora = new JLabel("Hora de la denuncia:   " + h);
        lblHora.setBounds(30, 100, 220, 30);
        conte.add(lblHora);
        JLabel lblDescripcion = new JLabel("Descripción de la denuncia:");
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

        JLabel iVictima = new JLabel("Información de la víctima");
        iVictima.setBounds(30, 190, 200, 30);
        conte.add(iVictima);

        JLabel vNombre = new JLabel("Nombre de la persona");
        vNombre.setBounds(30, 270, 200, 30);
        conte.add(vNombre);
        JTextField vNombre1 = new JTextField();
        vNombre1.setBounds(30, 300, 150, 30); 
        conte.add(vNombre1);

        JLabel vCedula = new JLabel("Cédula de la persona");
        vCedula.setBounds(30, 340, 150, 30);
        conte.add(vCedula);
        JTextField cVictima = new JTextField();
        cVictima.setBounds(30, 370, 150, 30);
        conte.add(cVictima);

        JLabel vNumero = new JLabel("Número celular de la persona");
        vNumero.setBounds(30, 410, 190, 30);
        conte.add(vNumero);
        JTextField vNumero1 = new JTextField();
        vNumero1.setBounds(30, 440, 150, 30);
        conte.add(vNumero1);

        JLabel vDireccion = new JLabel("Dirección de la persona");
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

        JLabel vGenero = new JLabel("Género de la persona");
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

        JLabel vOcupacion = new JLabel("Ocupación de la persona");
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

        frame.setSize(630, 600);
        frame.add(conte);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = "";
                if (vGenero1.isSelected()) {
                    genero = "Masculino";
                } else if (vGenero2.isSelected()) {
                    genero = "Femenino";
                } else if (vGenero3.isSelected()) {
                    genero = "Otro";
                }

                if (genero.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un genero");
                    return;
                }
                
                try {
                    if (vNombre1.getText().isEmpty() || cVictima.getText().isEmpty() || vNumero1.getText().isEmpty() ||
                        vDireccion1.getText().isEmpty() || vEdad1.getText().isEmpty() || vOcupacion1.getText().isEmpty() ||
                        vNacionalidad1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Complete todos los campos");
                        return;
                    }

                    try {
                        if (tViolencia1.getSelectedItem().toString().equals("Violencia Digital")) {
                            vDigital caso = new vDigital(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            ListaCasos.add(caso);
                            ingresarCaso1(caso);
                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Economica")) {
                            vEconomica caso = new vEconomica(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            ListaCasos.add(caso);
                            ingresarCaso2(caso); 
                            frame.dispose();
                        } else if( tViolencia1.getSelectedItem().toString().equals("Violencia Emocional")){ 
                            vEmocional caso = new vEmocional(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            ListaCasos.add(caso);
                            ingresarCaso3(caso);
                            frame.dispose();
                        } else if( tViolencia1.getSelectedItem().toString().equals("Violencia Fisica")){ 
                            vFisica caso = new vFisica(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            ListaCasos.add(caso);
                            ingresarCaso4(caso);
                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Sexual")){ 
                            vSexual caso = new vSexual(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            ListaCasos.add(caso);
                            ingresarCaso5(caso);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione un tipo de violencia");

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos para número celular y edad.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar el caso: " + ex.getMessage());
                }
            }
        });
    }
    public void mosCasos() {
        JFrame frame = new JFrame("Casos registrados");
        Container conte = new Container();
        conte.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(40, 50, 700, 400);
        conte.add(scroll);
        
        String a = "";
        if (ListaCasos.isEmpty()) {
            a = "No hay casos registrados.";
        } else {
            for (int i = 0; i < ListaCasos.size(); i++) {
                a += "-----------------------------------\n";
                a += "Caso #" + (i + 1) + "\n";
                a += "------------------------------------\n";
                a += ListaCasos.get(i).mostrarcaso() + "\n\n";
            }
        }

        textArea.setText(a);

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

    public void visualizarCaso() {
        JFrame frame = new JFrame("Ingrese el ID del caso que desea visualizar");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel lblID = new JLabel("ID de casos registrados:");
        lblID.setBounds(110, 40, 200, 30);
        conte.add(lblID);
        JLabel lblID1 = new JLabel("Ingrese el ID del caso que desea visualizar:");
        lblID1.setBounds(50, 300, 300, 30);
        conte.add(lblID1);
        JTextField campo = new JTextField();
        campo.setBounds(80, 330, 200, 30);
        conte.add(campo);
        campo.requestFocus();
        JTextArea txtId = new JTextArea();
        for (int i = 0; i < ListaCasos.size(); i++) {
            txtId.setText(txtId.getText() + "\n" + ListaCasos.get(i).buscarCaso());
        }
        txtId.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtId);
        scroll.setBounds(80, 80, 200, 200);
        conte.add(scroll);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(80, 380, 100, 30);
        conte.add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campo.getText();
                frame.dispose();
                for (int i = 0; i < ListaCasos.size(); i++) {
                    if (ListaCasos.get(i).getVictima().getCedula().equals(id)) {
                        JOptionPane.showMessageDialog(null, "Caso encontrado:\n" + ListaCasos.get(i).mostrarcaso());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Caso no encontrado.");
            }
        });
            
        frame.add(conte);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void ingresarCaso1(vDigital caso) {
        JFrame frame = new JFrame("Información adicional del caso Violencia digital");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel pDigital = new JLabel("Ingrese la plataforma donde se dio la agresión:");
        pDigital.setBounds(30, 50, 300, 30);
        conte.add(pDigital);
        JTextField pDigital1 = new JTextField();
        pDigital1.setBounds(50, 80, 200, 30);
        conte.add(pDigital1);
        JLabel agresor = new JLabel("Nombre del agresor:");
        agresor.setBounds(30, 120, 200, 30);
        conte.add(agresor);
        JTextField agresor1 = new JTextField();
        agresor1.setBounds(50, 150, 200, 30);
        conte.add(agresor1);
        JLabel rAgresor = new JLabel("Relación con el agresor:");
        rAgresor.setBounds(30, 190, 200, 30);
        conte.add(rAgresor);
        JTextField rAgresor1 = new JTextField();
        rAgresor1.setBounds(50, 220, 200, 30);
        conte.add(rAgresor1);
        JLabel gAgresor = new JLabel("Género del agresor:");
        gAgresor.setBounds(30, 260, 200, 30);
        conte.add(gAgresor);
        JRadioButton gAgresor1 = new JRadioButton("Masculino");
        gAgresor1.setBounds(50, 290, 200, 30);  
        conte.add(gAgresor1);
        JRadioButton gAgresor2 = new JRadioButton("Femenino");
        gAgresor2.setBounds(50, 320, 200, 30);
        conte.add(gAgresor2);
        JRadioButton gAgresor3 = new JRadioButton("Otro");
        gAgresor3.setBounds(50, 350, 200, 30);
        conte.add(gAgresor3);
        ButtonGroup botones = new ButtonGroup();
        botones.add(gAgresor1);
        botones.add(gAgresor2);
        botones.add(gAgresor3);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 400, 100, 30);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                caso.iDatos(pDigital1.getText(), agresor1.getText(), rAgresor1.getText(), gAgresor);
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }
        });

        frame.add(conte);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void ingresarCaso2(vEconomica caso) {
            JFrame frame = new JFrame("Información adicional del caso Violencia Económica");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 500);
            Container conte = frame.getContentPane();
            conte.setLayout(null);
    
            JLabel tipoIngresoLabel = new JLabel("Ingrese el tipo de ingreso afectado:");
            tipoIngresoLabel.setBounds(20, 20, 350, 30);
            conte.add(tipoIngresoLabel);
            JTextField tipoIngresoField = new JTextField();
            tipoIngresoField.setBounds(20, 50, 340, 30);
            conte.add(tipoIngresoField);
    
            JLabel impactoFinancieroLabel = new JLabel("Ingrese el impacto financiero:");
            impactoFinancieroLabel.setBounds(20, 90, 350, 30);
            conte.add(impactoFinancieroLabel);
            JTextField impactoFinancieroField = new JTextField();
            impactoFinancieroField.setBounds(20, 120, 340, 30);
            conte.add(impactoFinancieroField);

            JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor:");
            agresorLabel.setBounds(20, 160, 350, 30);
            conte.add(agresorLabel);
            JTextField agresorField = new JTextField();
            agresorField.setBounds(20, 190, 340, 30);
            conte.add(agresorField);
 
            JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor:");
            rAgresorLabel.setBounds(20, 230, 350, 30);
            conte.add(rAgresorLabel);
            JTextField rAgresorField = new JTextField();
            rAgresorField.setBounds(20, 260, 340, 30);
            conte.add(rAgresorField);
    
            JLabel gAgresor = new JLabel("Género del agresor:");
            gAgresor.setBounds(20, 300, 350, 30);
            conte.add(gAgresor);
            JRadioButton gAgresor1 = new JRadioButton("Masculino");
            gAgresor1.setBounds(20, 330, 100, 30);  
            conte.add(gAgresor1);
            JRadioButton gAgresor2 = new JRadioButton("Femenino");
            gAgresor2.setBounds(130, 330, 100, 30);
            conte.add(gAgresor2);
            JRadioButton gAgresor3 = new JRadioButton("Otro");
            gAgresor3.setBounds(240, 330, 100, 30);
            conte.add(gAgresor3);
            ButtonGroup botones = new ButtonGroup();
            botones.add(gAgresor1);
            botones.add(gAgresor2);
            botones.add(gAgresor3);
            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.setBounds(20, 380, 100, 30);
            conte.add(btnGuardar);
            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String gAgresor = "";
                    if (gAgresor1.isSelected()) {
                        gAgresor = "Masculino";
                    } else if (gAgresor2.isSelected()) {
                        gAgresor = "Femenino";
                    } else if (gAgresor3.isSelected()) {
                        gAgresor = "Otro";
                    }
                 caso.iDatos(tipoIngresoField.getText(), agresorField.getText(), rAgresorField.getText(), gAgresor);
                        caso.setCantidadIngreso(Double.parseDouble(impactoFinancieroField.getText()));
                        JOptionPane.showMessageDialog(null, "Caso registrado correctamente");
                        frame.dispose();
                }
            });
    
            frame.setVisible(true);
        }

    public void ingresarCaso3(vEmocional caso) {
            JFrame frame = new JFrame("Información adicional del caso Violencia Emocional");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 500);
            Container conte = frame.getContentPane();
            conte.setLayout(null);
    
            JLabel impactoPsicologicoLabel = new JLabel("Ingrese el impacto psicológico:");
            impactoPsicologicoLabel.setBounds(20, 20, 350, 30);
            conte.add(impactoPsicologicoLabel);
            JTextField impactoPsicologicoField = new JTextField();
            impactoPsicologicoField.setBounds(20, 50, 340, 30);
            conte.add(impactoPsicologicoField);

            JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor:");
            agresorLabel.setBounds(20, 90, 350, 30);
            conte.add(agresorLabel);
            JTextField agresorField = new JTextField();
            agresorField.setBounds(20, 120, 340, 30);
            conte.add(agresorField);
 
            JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor:");
            rAgresorLabel.setBounds(20, 160, 350, 30);
            conte.add(rAgresorLabel);
            JTextField rAgresorField = new JTextField();
            rAgresorField.setBounds(20, 190, 340, 30);
            conte.add(rAgresorField);
    
            JLabel gAgresor = new JLabel("Género del agresor:");
            gAgresor.setBounds(20, 230, 350, 30);
            conte.add(gAgresor);
            JRadioButton gAgresor1 = new JRadioButton("Masculino");
            gAgresor1.setBounds(20, 260, 100, 30);  
            conte.add(gAgresor1);
            JRadioButton gAgresor2 = new JRadioButton("Femenino");
            gAgresor2.setBounds(130, 260, 100, 30);
            conte.add(gAgresor2);
            JRadioButton gAgresor3 = new JRadioButton("Otro");
            gAgresor3.setBounds(240, 260, 100, 30);
            conte.add(gAgresor3);
            ButtonGroup botones = new ButtonGroup();
            botones.add(gAgresor1);
            botones.add(gAgresor2);
            botones.add(gAgresor3);
            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.setBounds(20, 310, 100, 30);
            conte.add(btnGuardar);
            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String gAgresor = "";
                    if (gAgresor1.isSelected()) {
                        gAgresor = "Masculino";
                    } else if (gAgresor2.isSelected()) {
                        gAgresor = "Femenino";
                    } else if (gAgresor3.isSelected()) {
                        gAgresor = "Otro";
                    }
                    caso.iDatos(impactoPsicologicoField.getText(), agresorField.getText(), rAgresorField.getText(), gAgresor);
                    JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                    frame.dispose();
                }
            });
            frame.setVisible(true);
        }

    public void ingresarCaso4(vFisica caso) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Física");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel tipoLesionLabel = new JLabel("Ingrese el tipo de lesión:");
        tipoLesionLabel.setBounds(20, 20, 350, 30);
        conte.add(tipoLesionLabel);
        JTextField tipoLesionField = new JTextField();
        tipoLesionField.setBounds(20, 50, 340, 30);
        conte.add(tipoLesionField);

        JLabel atencionMedicaLabel = new JLabel("Ingrese la atención médica recibida:");
        atencionMedicaLabel.setBounds(20, 90, 350, 30);
        conte.add(atencionMedicaLabel);
        JTextField atencionMedicaField = new JTextField();
        atencionMedicaField.setBounds(20, 120, 340, 30);
        conte.add(atencionMedicaField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor:");
        agresorLabel.setBounds(20, 160, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 190, 340, 30);
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor:");
        rAgresorLabel.setBounds(20, 230, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 260, 340, 30);
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor:");
        gAgresor.setBounds(20, 300, 350, 30);
        conte.add(gAgresor);
        JRadioButton gAgresor1 = new JRadioButton("Masculino");
        gAgresor1.setBounds(20, 330, 100, 30);  
        conte.add(gAgresor1);
        JRadioButton gAgresor2 = new JRadioButton("Femenino");
        gAgresor2.setBounds(130, 330, 100, 30);
        conte.add(gAgresor2);
        JRadioButton gAgresor3 = new JRadioButton("Otro");
        gAgresor3.setBounds(240, 330, 100, 30);
        conte.add(gAgresor3);
        ButtonGroup botones = new ButtonGroup();
        botones.add(gAgresor1);
        botones.add(gAgresor2);
        botones.add(gAgresor3);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 380, 100, 30);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                caso.iDatos(tipoLesionField.getText(), agresorField.getText(), rAgresorField.getText(), gAgresor);
                caso.setAtencionMedica(atencionMedicaField.getText());
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente");
                frame.dispose();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void ingresarCaso5(vSexual caso) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Sexual");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel tipoAbusoSexualLabel = new JLabel("Ingrese el tipo de abuso sexual:");
        tipoAbusoSexualLabel.setBounds(20, 20, 350, 30);
        conte.add(tipoAbusoSexualLabel);
        JTextField tipoAbusoSexualField = new JTextField();
        tipoAbusoSexualField.setBounds(20, 50, 340, 30);
        conte.add(tipoAbusoSexualField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor:");
        agresorLabel.setBounds(30, 90, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 120, 340, 30);
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor:");
        rAgresorLabel.setBounds(20, 160, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 190, 340, 30);
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor:");
        gAgresor.setBounds(20, 230, 350, 30);
        conte.add(gAgresor);
        JRadioButton gAgresor1 = new JRadioButton("Masculino");
        gAgresor1.setBounds(20, 260, 100, 30);  
        conte.add(gAgresor1);
        JRadioButton gAgresor2 = new JRadioButton("Femenino");
        gAgresor2.setBounds(130, 260, 100, 30);
        conte.add(gAgresor2);
        JRadioButton gAgresor3 = new JRadioButton("Otro");
        gAgresor3.setBounds(240, 260, 100, 30);
        conte.add(gAgresor3);
        ButtonGroup botones = new ButtonGroup();
        botones.add(gAgresor1);
        botones.add(gAgresor2);
        botones.add(gAgresor3);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 310, 100, 30);
        conte.add(btnGuardar);
            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String gAgresor = "";
                    if (gAgresor1.isSelected()) {
                        gAgresor = "Masculino";
                    } else if (gAgresor2.isSelected()) {
                        gAgresor = "Femenino";
                    } else if (gAgresor3.isSelected()) {
                        gAgresor = "Otro";
                    }
                caso.iDatos(tipoAbusoSexualField.getText(), agresorField.getText(), rAgresorField.getText(), gAgresor);
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente");
                frame.dispose();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void modificarCaso() {
        JFrame frame = new JFrame("Modificar Caso");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel lblCedula = new JLabel("Ingrese la cédula del caso:");
        lblCedula.setBounds(30, 30, 200, 30);
        conte.add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(30, 60, 200, 30);
        conte.add(txtCedula);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(30, 100, 100, 30);
        conte.add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                int index = -1;
                for (int i = 0; i < ListaCasos.size(); i++) {
                    if (ListaCasos.get(i).getVictima().getCedula().equals(cedula)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    frame.dispose();
                    editarCaso(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Caso no encontrado.");
                }
            }
        });

        frame.add(conte);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void editarCaso(int index) {
        Caso caso = ListaCasos.get(index);
        JFrame frame = new JFrame("Editar Caso");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(30, 30, 100, 30);
        conte.add(lblFecha);
        JTextField txtFecha = new JTextField(caso.getFecha());
        txtFecha.setBounds(130, 30, 150, 30);
        conte.add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(30, 70, 100, 30);
        conte.add(lblHora);
        JTextField txtHora = new JTextField(caso.getHora());
        txtHora.setBounds(130, 70, 150, 30);
        conte.add(txtHora);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(30, 110, 100, 30);
        conte.add(lblDescripcion);
        JTextArea txtDescripcion = new JTextArea(caso.getDescripcion());
        txtDescripcion.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(130, 110, 300, 100);
        conte.add(scroll);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 230, 100, 30);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                caso.modificarcaso(txtFecha.getText(), txtHora.getText(), txtDescripcion.getText());
                JOptionPane.showMessageDialog(null, "Caso modificado correctamente.");
                frame.dispose();
            }
        });

        frame.add(conte);
        frame.setSize(460, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void resolverCaso() {
        JFrame frame = new JFrame("Resolver Caso");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel lblCedula = new JLabel("Ingrese la cédula del caso:");
        lblCedula.setBounds(30, 30, 200, 30);
        conte.add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(30, 60, 200, 30);
        conte.add(txtCedula);
        JButton btnResolver = new JButton("Resolver");
        btnResolver.setBounds(30, 100, 100, 30);
        conte.add(btnResolver);

        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                for (int i = 0; i < ListaCasos.size(); i++) {
                    if (ListaCasos.get(i).getVictima().getCedula().equals(cedula)) {
                        ListaCasos.remove(i);
                        JOptionPane.showMessageDialog(null, "Caso resuelto y eliminado correctamente.");
                        frame.dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Caso no encontrado.");
            }
        });

        frame.add(conte);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}