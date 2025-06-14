
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.sql.*;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class VistaGeneral {
//Componentes graficos globales para agregar actionListener mediante un solo metodo.

    JButton btnCaso;
    JButton btnMostrarCaso;
    JButton btnEliminarCaso;
    JButton btnModificarCaso;
    JButton btnsalir;
    JButton btnVisualizarCaso;
    JButton btnSalir1;


    public VistaGeneral() throws UnsupportedLookAndFeelException, ClassNotFoundException, SQLException {
        //Metodos utilizados para darle una vista mas atractiva utilizando libreria FlatLaf.     
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        UIManager.put("Button.arc", 100);
        UIManager.put("TextComponent.arc", 100);
        UIManager.put("Component.arc", 100);
        UIManager.put("Button.background", new Color(30, 144, 255));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.focusColor", Color.ORANGE);
        //Inicializacion de componente necesario para establecer conexion con el motor de base de datos.                    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto1?verifyServerCertificate=false&useSSL=true", "root", "cRojas34");
        Statement stmt = con.createStatement();
        //Se llama al metodo necesario para mostrar la pantalla de validar usuario y contraseña.
        pantallaLoguear(stmt);
    }

    //Metodo declarado para mostrar la pantalla donde se verifica un usuario.
    public void pantallaLoguear(Statement stmt) {
        //inicializacion de componentes graficos
        JFrame vistaLogin = new JFrame("Login de usuario");
        Container conte = new Container();
        vistaLogin.setSize(300, 500);
        vistaLogin.setLocationRelativeTo(null);
        JLabel etiquetaUsuario = new JLabel("Nombre de usuario");
        etiquetaUsuario.setBounds(50, 20, 200, 30);
        conte.add(etiquetaUsuario);
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(40, 60, 200, 40);
        campoUsuario.setToolTipText("Ingrese su nombre de usuario");
        conte.add(campoUsuario);

        JLabel etiquetaContraseña = new JLabel("Contraseña");
        etiquetaContraseña.setBounds(50, 120, 200, 30);
        conte.add(etiquetaContraseña);
        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setBounds(40, 160, 200, 40);
        campoContraseña.setToolTipText("Ingrese Contraseña");
        conte.add(campoContraseña);
        JCheckBox mostrarContraseña = new JCheckBox("Mostrar contraseña");
        mostrarContraseña.setBounds(40, 200, 200, 30);
        conte.add(mostrarContraseña);
        mostrarContraseña.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (mostrarContraseña.isSelected()) {
            campoContraseña.setEchoChar((char) 0); // mostrar contraseña
        } else {
            campoContraseña.setEchoChar('•'); // ocultar contraseña
        }
    }
});
        JButton ingreso = new JButton("Ingresar");
        ingreso.setBounds(50, 240, 100, 40);
        ImageIcon icon = new ImageIcon("Iconos/entrar.PNG");
        ingreso.setIcon(icon);
        conte.add(ingreso);
        JButton crearLogin = new JButton("Crear usuario");
        crearLogin.setBounds(50, 300, 150, 40);
        ImageIcon icon2 = new ImageIcon("Iconos/agregar-usuario.PNG");
        crearLogin.setIcon(icon2);
        conte.add(crearLogin);
        JButton editarUsuario = new JButton("Editar usuario");
        editarUsuario.setBounds(50, 360, 150, 40);
        editarUsuario.setIcon(new ImageIcon("Iconos/boton-editar.PNG"));
        conte.add(editarUsuario);
        vistaLogin.add(conte);
        vistaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaLogin.setLocationRelativeTo(null);
        vistaLogin.setVisible(true);
        ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Al presionar boton Ingresar se llama al metodo verificar login para validad si el usuario y la contraseña estan correctos.
                    verificarLogin(stmt, campoUsuario.getText(), campoContraseña.getText(), vistaLogin);
                    campoUsuario.setText("");
                    campoContraseña.setText("");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        crearLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al presionar boton Crear Usuario se llama al metodo con el mismo nombre para que se despliegue una pantalla solicitando toda la informacion
                crearUsuario(stmt);
            }
        });
        editarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proyecto1?verifyServerCertificate=false&useSSL=true",
                "root", "cRojas34"
            );
            Statement stmt = con.createStatement();

            // Llama al método que abre la ventana de edición
            editarUsiario(con, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + ex.getMessage());
        }
            }
        });
        editarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                editarUsuario.setBounds(50, 360, 150, 50);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                editarUsuario.setBounds(50, 360, 150, 40);
            }
        });
        ingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Acción al pasar el mouse por encima
                ingreso.setBounds(50, 240, 100, 50);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                ingreso.setBounds(50, 240, 100, 40);
            }
        });
        crearLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                crearLogin.setBounds(50, 300, 150, 50);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                crearLogin.setBounds(50, 300, 150, 40);
            }
        });
       

    }

    //Metodo para editar un usuario ya existente en la base de datos.
    public void editarUsiario(Connection con, Statement stmt) {
    JFrame frame = new JFrame("Editar Usuario");
    Container conte = frame.getContentPane();
    conte.setLayout(null);

    JLabel etiSeleccionar = new JLabel("Selecciona usuario:");
    etiSeleccionar.setBounds(30, 10, 200, 30);
    conte.add(etiSeleccionar);

    JComboBox<String> comboUsuarios = new JComboBox<>();
    comboUsuarios.setBounds(30, 40, 250, 30);
    conte.add(comboUsuarios);

    // Cargar usuarios en el combo
    try {
        ResultSet rs = stmt.executeQuery("SELECT Cedula, Nombre1, Apellido1 FROM usuario");
        while (rs.next()) {
            String cedula = rs.getString("Cedula");
            String nombre = rs.getString("Nombre1");
            String apellido = rs.getString("Apellido1");
            comboUsuarios.addItem(cedula + " - " + nombre + " " + apellido);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    JLabel etiNombre = new JLabel("Nuevo nombre  *");
    etiNombre.setBounds(30, 80, 200, 30);
    conte.add(etiNombre);

    JTextField campoNombre = new JTextField();
    campoNombre.setBounds(30, 110, 200, 30);
    campoNombre.setToolTipText("Ingrese el nuevo nombre del usuario");
    conte.add(campoNombre);

    JLabel etiSegundoNombre = new JLabel("Nuevo segundo nombre  *");
    etiSegundoNombre.setBounds(30, 140, 200, 30);
    conte.add(etiSegundoNombre);

    JTextField campoSegundoNombre = new JTextField();
    campoSegundoNombre.setBounds(30, 170, 200, 30);
    campoSegundoNombre.setToolTipText("Ingrese el nuevo segundo nombre del usuario");
    conte.add(campoSegundoNombre);

    JLabel etiApellido = new JLabel("Nuevo apellido   *");
    etiApellido.setBounds(30, 200, 200, 30);
    conte.add(etiApellido);

    JTextField campoApellido = new JTextField();
    campoApellido.setBounds(30, 230, 200, 30);
    campoApellido.setToolTipText("Ingrese el nuevo apellido del usuario");
    conte.add(campoApellido);

    JLabel etiSegundoApellido = new JLabel("Nuevo segundo apellido    *");
    etiSegundoApellido.setBounds(30, 260, 200, 30);
    conte.add(etiSegundoApellido);

    JTextField campoSegundoApellido = new JTextField();
    campoSegundoApellido.setBounds(30, 290, 200, 30);
    campoSegundoApellido.setToolTipText("Ingrese el nuevo segundo apellido del usuario");
    conte.add(campoSegundoApellido);

    JLabel etiUsuario = new JLabel("Nuevo nombre de usuario   *");
    etiUsuario.setBounds(30, 320, 200, 30);
    conte.add(etiUsuario);

    JTextField campoUsuario = new JTextField();
    campoUsuario.setBounds(30, 350, 200, 30);
    campoUsuario.setToolTipText("Ingrese el nuevo nombre de usuario");
    conte.add(campoUsuario);

    JLabel etiContraseña = new JLabel("Nueva contraseña   *");
    etiContraseña.setBounds(30, 380, 200, 30);
    conte.add(etiContraseña);

    JTextField campoContraseña = new JTextField();
    campoContraseña.setBounds(30, 410, 200, 30);
    campoContraseña.setToolTipText("Ingrese la nueva contraseña del usuario");
    conte.add(campoContraseña);

    JButton btnGuardar = new JButton("Guardar");
        ImageIcon iconEditar = new ImageIcon("Iconos/boton-editar.PNG");
    btnGuardar.setIcon(iconEditar);
    btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
    btnGuardar.setIconTextGap(50);
    btnGuardar.setBounds(30, 460, 150, 40);
    conte.add(btnGuardar);

    // Cuando seleccionan un usuario en el combo, cargar sus datos
    comboUsuarios.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccionado = (String) comboUsuarios.getSelectedItem();
            if (seleccionado != null) {
                String cedula = seleccionado.split(" - ")[0]; // Extraer solo la cédula
                try {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE Cedula = '" + cedula + "'");
                    if (rs.next()) {
                        campoNombre.setText(rs.getString("Nombre1"));
                        campoSegundoNombre.setText(rs.getString("Nombre2"));
                        campoApellido.setText(rs.getString("Apellido1"));
                        campoSegundoApellido.setText(rs.getString("Apellido2"));
                        campoUsuario.setText(rs.getString("login"));
                        campoContraseña.setText(rs.getString("clave"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    });

    btnGuardar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccionado = (String) comboUsuarios.getSelectedItem();
            if (seleccionado != null) {
                String cedula = seleccionado.split(" - ")[0];
                try {
                    String sql = "UPDATE usuario SET " +
                                 "Nombre1 = '" + campoNombre.getText() + "', " +
                                 "Nombre2 = '" + campoSegundoNombre.getText() + "', " +
                                 "Apellido1 = '" + campoApellido.getText() + "', " +
                                 "Apellido2 = '" + campoSegundoApellido.getText() + "', " +
                                 "login = '" + campoUsuario.getText() + "', " +
                                 "clave = '" + campoContraseña.getText() + "' " +
                                 "WHERE Cedula = '" + cedula + "'";
                    int actualizado = stmt.executeUpdate(sql);

                    if (actualizado > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
                }
            }
        }
    });
    btnGuardar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            btnGuardar.setBounds(30, 460, 150, 50); 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnGuardar.setBounds(30, 460, 150, 40); 
        }
    });

    frame.setSize(350, 560);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
    public void crearUsuario(Statement stmt) {
        //Inicializacion de componentes graficos para solicitar la informacion de un nuevo usuario.
        JFrame frame = new JFrame("Informacion de nuevo usuario");
        Container conte = new Container();
        JLabel etiCedula = new JLabel("Ingrese su cedula");
        etiCedula.setBounds(50, 10, 200, 30);
        conte.add(etiCedula);
        JTextField campoCedula = new JTextField();
        campoCedula.setBounds(50, 40, 200, 30);
        campoCedula.setToolTipText("Ingrese su cedula para crear un nuevo usuario");
        conte.add(campoCedula);
        JLabel etiNombre = new JLabel("Ingrese su nombre");
        etiNombre.setBounds(50, 70, 200, 30);
        conte.add(etiNombre);
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(50, 100, 200, 30);
        campoNombre.setToolTipText("Ingrese su primer nombre para crear un nuevo usuario");
        conte.add(campoNombre);
        JLabel etiSegundoNombre = new JLabel("Ingrese su segundo nombre");
        etiSegundoNombre.setBounds(50, 130, 200, 30);
        conte.add(etiSegundoNombre);
        JTextField campoSegundoNombre = new JTextField();
        campoSegundoNombre.setBounds(50, 160, 200, 30);
        campoSegundoNombre.setToolTipText("Ingrese su segundo nombre para crear un nuevo usuario");
        conte.add(campoSegundoNombre);
        JLabel etiApellido = new JLabel("Ingrese su apellido");
        etiApellido.setBounds(50, 190, 200, 30);
        conte.add(etiApellido);
        JTextField campoApellido = new JTextField();
        campoApellido.setBounds(50, 220, 200, 30);
        campoApellido.setToolTipText("Ingrese su primer apellido para crear un nuevo usuario");
        conte.add(campoApellido);
        JLabel etiSegundoApellido = new JLabel("Ingrese su segundo apellido");
        etiSegundoApellido.setBounds(50, 250, 200, 30);
        conte.add(etiSegundoApellido);
        JTextField campoSegundoApellido = new JTextField();
        campoSegundoApellido.setBounds(50, 280, 200, 30);
        campoSegundoApellido.setToolTipText("Ingrese su segundo apellido para crear un nuevo usuario");
        conte.add(campoSegundoApellido);
        JLabel etiUsuario = new JLabel();
        etiUsuario.setText("Ingrese su nombre de usuario");
        etiUsuario.setBounds(50, 310, 200, 30);
        conte.add(etiUsuario);
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(50, 340, 200, 30);
        campoUsuario.setToolTipText("Ingrese el nombre que desea tener a la hora de crear un nuevo usuario");
        conte.add(campoUsuario);
        JLabel etiContraseña = new JLabel("Ingrese su contraseña");
        etiContraseña.setBounds(50, 370, 200, 30);
        conte.add(etiContraseña);
        JTextField campoContraseña = new JTextField();
        campoContraseña.setBounds(50, 400, 200, 30);
        campoContraseña.setToolTipText("Ingrese la contraseña que desea tener a la hora de crear un nuevo usuario");
        conte.add(campoContraseña);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 440, 200, 30);
        ImageIcon iconGuardar = new ImageIcon("Iconos/guardar-el-archivo.PNG");
        btnGuardar.setIcon(iconGuardar);
        conte.add(btnGuardar);
        frame.add(conte);
        frame.setSize(300, 540);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Aqui se ejecuta la sentencia para insertar el nuevo usuario en la base de datos
                    int valor = stmt.executeUpdate("insert into usuario(Cedula, Nombre1, Nombre2, Apellido1, Apellido2, login, clave) value (" + "'" + campoCedula.getText() + "'" + ",'" + campoNombre.getText() + "','" + campoSegundoNombre.getText() + "','" + campoApellido.getText() + "','" + campoSegundoApellido.getText() + "','" + campoUsuario.getText() + "','" + campoContraseña.getText() + "')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
                    //While para comprobar los datos actual de la base de datos.
                   
                    frame.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //Acciones al pasar el mouse por encima del boton Guardar.
       btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        btnGuardar.setBounds(50, 440, 150, 50); // aumentar altura al pasar el mouse
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        btnGuardar.setBounds(50, 440, 150, 40); // restaurar tamaño original
    }
});
    }
//Metodo declarado para verificar los datos al momento de intentar ingresar al sistema.

    public void verificarLogin(Statement stmt, String usuario, String contra, JFrame pantalla) throws SQLException {
        boolean encontrado = false;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                //Aqui se valida la informacion
                if (rs.getString("login").equals(usuario) && rs.getString("clave").equals(contra)) {
                    encontrado = true;
                    break;
                }
            }
            //Si la informacion coincide se llama a la pantalla general del sistema.
            if (encontrado == true) {
                JOptionPane.showMessageDialog(null, "Login exitoso\nInformacion de la persona\nCedula: " + rs.getString("Cedula") + "\nNombre: " + rs.getString("Nombre1") + "\nNombre2: " + rs.getString("Nombre2") + "\nApellido1: " + rs.getString("Apellido1") + "\nApellido2: " + rs.getString("Apellido2") + "\nLogin: " + rs.getString("login") + "\nClave: " + rs.getString("clave"));

                pantallaGeneral(stmt);
                pantalla.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void pantallaGeneral(Statement stmt) {
        //Inicializacion de componentes mostrados en la ventana principal del sistema.
        JFrame frame = new JFrame("Bienvenido al sistema de denuncia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();
        JPanel panelCaso = new JPanel();
        JPanel panelMostrarCaso = new JPanel();

        panelCaso.setLayout(null);
        panelMostrarCaso.setLayout(null);

        btnCaso = new JButton("Caso");
        btnCaso.setBounds(40, 50, 200, 30);
        ImageIcon icon = new ImageIcon("Iconos/anadir.PNG");
btnCaso.setHorizontalAlignment(SwingConstants.LEFT);
btnCaso.setIconTextGap(50);
        btnCaso.setIcon(icon);
        panelCaso.add(btnCaso);
        btnCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCasos(stmt);
            }
        });
        btnCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Acción al pasar el mouse por encima
                btnCaso.setBounds(40, 50, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnCaso.setBounds(40, 50, 200, 30);
            }
        });

        btnMostrarCaso = new JButton("Mostrar Casos");
        btnMostrarCaso.setBounds(50, 60, 200, 30);
        ImageIcon icon2 = new ImageIcon("Iconos/mostrar.PNG");
        btnMostrarCaso.setHorizontalAlignment(SwingConstants.LEFT);
        btnMostrarCaso.setIconTextGap(30);
        btnMostrarCaso.setIcon(icon2);
        panelMostrarCaso.add(btnMostrarCaso);
        btnMostrarCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostratCasos(stmt);
            }
        });
        btnMostrarCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Acción al pasar el mouse por encima
                btnMostrarCaso.setBounds(50, 60, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnMostrarCaso.setBounds(50, 60, 200, 30);
            }
        });

        btnEliminarCaso = new JButton("Resolver Caso");
        btnEliminarCaso.setBounds(50, 110, 200, 30);
        ImageIcon icon3 = new ImageIcon("Iconos/resolviendo-el-problema.PNG");
        btnEliminarCaso.setHorizontalAlignment(SwingConstants.LEFT);
        btnEliminarCaso.setIconTextGap(30);
        btnEliminarCaso.setIcon(icon3);
        panelMostrarCaso.add(btnEliminarCaso);
        btnEliminarCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolverCaso(stmt);
            }
        });

        btnEliminarCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnEliminarCaso.setBounds(50, 110, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnEliminarCaso.setBounds(50, 110, 200, 30);
            }
        });

        btnSalir1 = new JButton("Salir");
        btnSalir1.setBounds(50, 210, 200, 30);
        ImageIcon iconSalir = new ImageIcon("Iconos/cerrar-sesion.PNG");
        btnSalir1.setHorizontalAlignment(SwingConstants.LEFT);
        btnSalir1.setIconTextGap(50);
        btnSalir1.setIcon(iconSalir);
        panelMostrarCaso.add(btnSalir1);
        btnSalir1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Ventana para mostrar los desarrolladores y sus carnets.
        JFrame ventana = new JFrame("Desarrolladores");
        ventana.setSize(500, 500);  
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel texto1 = new JLabel("Desarrolladores:");
        texto1.setBounds(180, 10, 200, 20);
        ventana.add(texto1);
        JLabel texto2 = new JLabel("Marcos Ortega C35750");
        texto2.setBounds(60, 40, 160, 20);  
        ventana.add(texto2);

        JLabel texto3 = new JLabel("Eddie Rojas C36934");
        texto3.setBounds(280, 40, 160, 20); 
        ventana.add(texto3);

        // Imagen de Marcos
        ImageIcon img1 = new ImageIcon("Iconos/imagen-marcos.JPG");
        Image esc1 = img1.getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);  
        JLabel lbl1 = new JLabel(new ImageIcon(esc1));
        lbl1.setBounds(60, 70, 160, 240);  
        ventana.add(lbl1);

        // Imagen de Eddie
        ImageIcon img2 = new ImageIcon("Iconos/imagen eddie.JPG");
        Image esc2 = img2.getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);  
        JLabel lbl2 = new JLabel(new ImageIcon(esc2));
        lbl2.setBounds(280, 70, 160, 240);  
        ventana.add(lbl2);

        ventana.setVisible(true);

        // Cierre automático en 5 segundos
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }).start();
    }
});
        btnSalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnSalir1.setBounds(50, 210, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnSalir1.setBounds(50, 210, 200, 30);
            }
        });

        btnVisualizarCaso = new JButton("Visualizar Caso");
        btnVisualizarCaso.setBounds(40, 100, 200, 30);
        ImageIcon icon4 = new ImageIcon("Iconos/mostrar-contrasena.PNG");
        btnVisualizarCaso.setHorizontalAlignment(SwingConstants.LEFT);
        btnVisualizarCaso.setIconTextGap(30);
        btnVisualizarCaso.setIcon(icon4);
        panelCaso.add(btnVisualizarCaso);
        btnVisualizarCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarCaso(stmt);
            }
        });
        btnVisualizarCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnVisualizarCaso.setBounds(40, 100, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnVisualizarCaso.setBounds(40, 100, 200, 30);
            }
        });

        btnModificarCaso = new JButton("Modificar Caso");
        btnModificarCaso.setBounds(40, 150, 200, 30);
        ImageIcon icon5 = new ImageIcon("Iconos/boton-editar.PNG");
        btnModificarCaso.setHorizontalAlignment(SwingConstants.LEFT);
        btnModificarCaso.setIconTextGap(30);
        btnModificarCaso.setIcon(icon5);
        panelCaso.add(btnModificarCaso);
        btnModificarCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCaso(stmt);
            }
        });
        btnModificarCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Acción al pasar el mouse por encima
                btnModificarCaso.setBounds(40, 150, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnModificarCaso.setBounds(40, 150, 200, 30);
            }
        });

        btnsalir = new JButton("Salir");
        btnsalir.setBounds(40, 250, 200, 30);
        ImageIcon iconSalir2 = new ImageIcon("Iconos/cerrar-sesion.PNG");
        btnsalir.setHorizontalAlignment(SwingConstants.LEFT);
        btnsalir.setIconTextGap(50);
        btnsalir.setIcon(iconSalir2);
        panelCaso.add(btnsalir);
        btnsalir.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            //Ventana para mostrar los desarrolladores y sus carnets.
        JFrame ventana = new JFrame("Desarrolladores");
        ventana.setSize(500, 500);  
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel texto1 = new JLabel("Desarrolladores:");
        texto1.setBounds(180, 10, 200, 20);
        ventana.add(texto1);
        JLabel texto2 = new JLabel("Marcos Ortega C35750");
        texto2.setBounds(60, 40, 160, 20);  
        ventana.add(texto2);

        JLabel texto3 = new JLabel("Eddie Rojas C36934");
        texto3.setBounds(280, 40, 160, 20); 
        ventana.add(texto3);

        // Imagen de Marcos
        ImageIcon img1 = new ImageIcon("Iconos/imagen-marcos.JPG");
        Image esc1 = img1.getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);  
        JLabel lbl1 = new JLabel(new ImageIcon(esc1));
        lbl1.setBounds(60, 70, 160, 240);  
        ventana.add(lbl1);

        // Imagen de Eddie
        ImageIcon img2 = new ImageIcon("Iconos/imagen eddie.JPG");
        Image esc2 = img2.getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);  
        JLabel lbl2 = new JLabel(new ImageIcon(esc2));
        lbl2.setBounds(280, 70, 160, 240);  
        ventana.add(lbl2);

        ventana.setVisible(true);

        // Cierre automático en 5 segundos
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }).start();
    }
});
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnsalir.setBounds(40, 250, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnsalir.setBounds(40, 250, 200, 30);
            }
        });

        JButton btnEliminarCaso = new JButton("Eliminar Caso");
        btnEliminarCaso.setBounds(40, 200, 200, 30);
        ImageIcon icon6 = new ImageIcon("Iconos/eliminar.PNG");
        btnEliminarCaso.setHorizontalAlignment(SwingConstants.LEFT);
        btnEliminarCaso.setIconTextGap(30);
        btnEliminarCaso.setIcon(icon6);
        panelCaso.add(btnEliminarCaso);
        btnEliminarCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JFrame frame = new JFrame("Eliminar Caso");
                Container conte = new Container();
                conte.setLayout(null);

                JTextArea textArea = new JTextArea();
                ResultSet rs;
                try {
                    rs = stmt.executeQuery("SELECT * FROM caso");
                    while (rs.next()) {
                        textArea.append(rs.getString("Cedula")+"\n");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setBounds(30, 30, 200, 200);
                conte.add(scroll);

                JLabel lblCedula = new JLabel("Ingrese la cédula del caso:");
                lblCedula.setBounds(30, 230, 200, 30);
                conte.add(lblCedula);
                JTextField txtCedula = new JTextField();
                txtCedula.setBounds(30, 260, 200, 30);
                txtCedula.setToolTipText("Ingrese la cédula del caso a eliminar");
                conte.add(txtCedula);

                 textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textoSeleccionado = textArea.getSelectedText();
                if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
                    txtCedula.setText(textoSeleccionado);
                }
            }
        });
   txtCedula.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        String texto = txtCedula.getText().trim();

        if (texto.isEmpty()) {
           if (texto.isEmpty()) {
          try {
          
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM caso");
            textArea.setText("");
            while (rs1.next()) {
                textArea.append(rs1.getString("Cedula")+"\n");
            }
     
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            return;
        }

        }

        try {
            // Usa LIKE para filtrar desde SQL
            String query = "SELECT * FROM caso WHERE Cedula LIKE '" + texto + "%'";
            ResultSet rs = stmt.executeQuery(query);
            textArea.setText(""); 

            while (rs.next()) {
                String cedula = rs.getString("Cedula");
                textArea.append(cedula + "\n"); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});

                JButton btnEliminar = new JButton("Eliminar");
                btnEliminar.setBounds(30, 310, 200, 30);
                ImageIcon iconEliminar = new ImageIcon("Iconos/eliminar.PNG");
                btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
                btnEliminar.setIconTextGap(50);
                btnEliminar.setIcon(iconEliminar);
                conte.add(btnEliminar);

                btnEliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String cedula = txtCedula.getText();
                        boolean index = false;

                        try {
                            ResultSet rs2 = stmt.executeQuery("SELECT * FROM caso");
                            while (rs2.next()) {
                                if (rs2.getString("Cedula").equals(cedula)) {
                                    index = true;
                                }
                            }
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }

                        //Si el caso no es encontrado se despliega un JOptionPane con el mensaje de que no se encontro el caso.
                        if (index == true) {
                            frame.dispose();
                            eliminarCaso(stmt, cedula); // TODO Auto-generated catch block
                        } else {
                            JOptionPane.showMessageDialog(null, "Caso no encontrado.");
                            txtCedula.setText("");
                        }
                    }
                });
                btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        btnEliminar.setBounds(30, 310, 200, 40);
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        btnEliminar.setBounds(30, 310, 200, 30);
                    }
                });

                frame.add(conte);
                frame.setSize(300, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnEliminarCaso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnEliminarCaso.setBounds(40, 200, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnEliminarCaso.setBounds(40, 200, 200, 30);
            }
        });
         JButton btnEditarFunci = new JButton("Editar Funcionario");
        btnEditarFunci.setBounds(50, 160, 200, 30);
        ImageIcon iconEditar = new ImageIcon("Iconos/boton-editar.PNG");
        btnEditarFunci.setIcon(iconEditar);
        btnEditarFunci.setHorizontalAlignment(SwingConstants.LEFT);
        btnEditarFunci.setIconTextGap(20);
        panelMostrarCaso.add(btnEditarFunci);
        btnEditarFunci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             editarFuncionario(stmt);
            }
        });
        btnEditarFunci.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnEditarFunci.setBounds(50, 160, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnEditarFunci.setBounds(50, 160, 200, 30);
            }
        });

        tab.addTab("Usuario", panelCaso);
        tab.addTab("Institucion", panelMostrarCaso);
        frame.setSize(300, 400);
        frame.add(tab);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //Fin de inicializacion y edicion de componentes de la pantalla principal.
    }

    public void eliminarCaso(Statement stmt, String cedula) {
        try {
            //Se ejecuta la sentencia para eliminar un caso de la base de datos.
            int valor = stmt.executeUpdate("DELETE FROM caso WHERE Cedula = '" + cedula + "'");
            valor += stmt.executeUpdate("DELETE FROM oficinaregional WHERE CedulaCaso = '" + cedula + "'");
            if (valor > 0) {
                JOptionPane.showMessageDialog(null, "Caso eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el caso con la cédula proporcionada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el caso: " + e.getMessage());
        }

    }
//Metodo declarado para la obtencion de la fecha correspondiente cuando se ingrese un caso o se de una solucion.

    public String obtenerFecha() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }
//Metodo declarado para la obtencion de la hora correspondiente cuando se ingrese un caso o se de una solucion.

    public String obtenerHora() {
        Date hora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss a");
        return formato.format(hora);
    }

    //Metodo declarado para buscar un registro de una solucion propuesta por un funcionario y editar la informacio.
    public void editarFuncionario(Statement stmt) {
        
        JFrame frame = new JFrame("Editar Funcionario");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel lblTitulo = new JLabel("Seleccione la cedula del funcionario para editar:");
        lblTitulo.setBounds(20, 10, 300, 30);
        conte.add(lblTitulo);
        JTextArea textArea = new JTextArea();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM oficinaregional");
            while (rs.next()) {
                textArea.append(rs.getString("Cedula") + "\n");
            }
            if(textArea.getText().equals("")){
                textArea.setText("Ningun funcionario a registrado una solucion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(30, 50, 220, 200);
        conte.add(scroll);
        JLabel lblCedula = new JLabel("Ingrese la cédula del funcionario:");
        lblCedula.setBounds(30, 270, 200, 30);
        conte.add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(30, 300, 200, 30);
        txtCedula.setToolTipText("Ingrese la cédula del funcionario a editar");
        conte.add(txtCedula);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(30, 340, 200, 30);
        ImageIcon iconBuscar = new ImageIcon("Iconos/buscar.PNG");
        btnBuscar.setIcon(iconBuscar);
        conte.add(btnBuscar);

        frame.setSize(300, 430);
        frame.setLocationRelativeTo(null);
        frame.add(conte);
        frame.setVisible(true);

         textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textoSeleccionado = textArea.getSelectedText();
                if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
                    txtCedula.setText(textoSeleccionado);
                }
            }
        });
        txtCedula.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        String texto = txtCedula.getText().trim();

        if (texto.isEmpty()) {
          
            
            try {
          
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM oficinaregional");
            textArea.setText("");
            while (rs1.next()) {
                textArea.append(rs1.getString("Cedula")+"\n");
            }
            if(textArea.getText().equals("")){
                textArea.setText("Ningun funcionario a registrado una solucion.");
            }
     
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            return;
        }

        try {
            // Usa LIKE para filtrar desde SQL
            String query = "SELECT * FROM oficinaregional WHERE Cedula LIKE '" + texto + "%'";
            ResultSet rs = stmt.executeQuery(query);
            textArea.setText(""); 

            while (rs.next()) {
                String cedula = rs.getString("Cedula");
                textArea.append(cedula + "\n"); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Se declara ResultSet para comparar el caso de la cedula buscada con la cedula de la base de datos
                try {
                    ResultSet rs2 = stmt.executeQuery("SELECT * FROM oficinaregional");
                    while (rs2.next()) {
                        
                        if (rs2.getString("Cedula").equals(txtCedula.getText())) {
                            
                            
                            frame.dispose();
                            JOptionPane.showMessageDialog(null, "Caso encontrado");
                            actualizarRegistro(stmt, txtCedula.getText());
                            return;
                        }
                    }
                    
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso no encontrado.");
                txtCedula.setText("");
               
                 try {
          
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM oficinaregional");
            textArea.setText("");
            while (rs3.next()) {
                textArea.append(rs3.getString("Cedula")+"\n");
            }

            if(textArea.getText().equals("")){
                textArea.setText("Ningun funcionario a registrado una solucion.");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            }
        });
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnBuscar.setBounds(30, 340, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnBuscar.setBounds(30, 340, 200, 30);
            }
        });
    }//Fin de metodo

    public void actualizarRegistro(Statement stmt, String cedula){
        JFrame frame = new JFrame("Actualizar registro de solucion");
        Container conte = new Container();
        conte.setLayout(null);
        JLabel lblCedula = new JLabel("Ingrese la nueva cédula del funcionario:   *");
        lblCedula.setBounds(30, 20, 250, 30);
        conte.add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(30, 50, 200, 30);
        txtCedula.setToolTipText("Ingrese la nueva cédula del funcionario");
        conte.add(txtCedula);
        JLabel lblNombre = new JLabel("Ingrese el nuevo nombre del funcionario:   *");
        lblNombre.setBounds(30, 90, 250, 30);
        conte.add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(30, 120, 200, 30);
        txtNombre.setToolTipText("Ingrese el nuevo nombre del funcionario");
        conte.add(txtNombre);
        JLabel lblApellido = new JLabel("Ingrese el nuevo ID del funcionario:   *");
        lblApellido.setBounds(30, 160, 250, 30);
        conte.add(lblApellido);
        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(30, 190, 200, 30);
        txtApellido.setToolTipText("Ingrese el nuevo ID del funcionario");
        conte.add(txtApellido);
        JLabel lblSegundoApellido = new JLabel("Ingrese la nueva direccion del funcionario:   *");
        lblSegundoApellido.setBounds(30, 230, 250, 30);
        conte.add(lblSegundoApellido);
        JTextField txtSegundoApellido = new JTextField();
        txtSegundoApellido.setBounds(30, 260, 200, 30);
        txtSegundoApellido.setToolTipText("Ingrese la nueva direcion del funcionario");
        conte.add(txtSegundoApellido);
        JLabel lblTelefono = new JLabel("Ingrese el nuevo telefono del funcionario:   *");
        lblTelefono.setBounds(30, 300, 250, 30);
        conte.add(lblTelefono);
        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(30, 330, 200, 30);
        txtTelefono.setToolTipText("Ingrese el nuevo telefono del funcionario");
        conte.add(txtTelefono);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(30, 380, 200, 30);
        ImageIcon iconActualizar = new ImageIcon("Iconos/procesamiento-de-datos.PNG");
        btnActualizar.setIcon(iconActualizar);
        btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
        btnActualizar.setIconTextGap(50);
        conte.add(btnActualizar);
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
  
  if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtSegundoApellido.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
      return;
  }
  int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    return;
                }
                try {
                    //Se ejecuta la sentencia para actualizar el registro del funcionario en la base de datos.
                    int valor = stmt.executeUpdate("UPDATE oficinaregional SET Cedula = '" + txtCedula.getText() + "', Nombre = '" + txtNombre.getText() + "', IDempleado = '" + txtApellido.getText() + "', Direccion = '" + txtSegundoApellido.getText() + "', Telefono = '" + txtTelefono.getText() +"', HoraAtencion = '"+obtenerHora()+"', FechaAtencion = '"+obtenerFecha()+"' WHERE Cedula = '" + cedula + "'");
                    if (valor > 0) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente.");
                        frame.dispose();
                    } 
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el registro: " + e1.getMessage());
                }
            }
        });
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnActualizar.setBounds(30, 380, 200, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnActualizar.setBounds(30, 380, 200, 30);
            }
        });
        frame.add(conte);
        frame.setSize(300, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
    
    //Metodo declarado para visualizar la pestaña donde se nos solicita la informacion general del caso.
    public void vistaCasos(Statement stmt) {
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
        JLabel lblDescripcion = new JLabel("Descripción de la denuncia* : ");
        lblDescripcion.setBounds(330, 20, 200, 30);
        conte.add(lblDescripcion);
        JTextArea txtDescripcion = new JTextArea();
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setToolTipText("Escriba una breve descripción del caso");
        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(260, 60, 300, 200);
        conte.add(scroll);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 510, 100, 30);
        ImageIcon iconGuardar = new ImageIcon("Iconos/guardar-el-archivo.PNG");
        btnGuardar.setIcon(iconGuardar);
        conte.add(btnGuardar);

        JLabel iVictima = new JLabel("Información de la víctima");
        iVictima.setBounds(30, 190, 200, 30);
        conte.add(iVictima);

        JLabel vNombre = new JLabel("Nombre de la persona *");
        vNombre.setBounds(30, 270, 200, 30);
        conte.add(vNombre);
        JTextField vNombre1 = new JTextField();
        vNombre1.setBounds(30, 300, 150, 30);
        vNombre1.setToolTipText("Ingrese el nombre de la victima del caso");
        conte.add(vNombre1);

        JLabel vCedula = new JLabel("Cédula de la persona *");
        vCedula.setBounds(30, 340, 150, 30);
        conte.add(vCedula);
        JTextField cVictima = new JTextField();
        cVictima.setBounds(30, 370, 150, 30);
        cVictima.setToolTipText("Ingrese la cédula de la victima del caso");
        conte.add(cVictima);

        JLabel vNumero = new JLabel("Número celular de la persona *");
        vNumero.setBounds(30, 410, 190, 30);
        conte.add(vNumero);
        JTextField vNumero1 = new JTextField();
        vNumero1.setBounds(30, 440, 150, 30);
        vNumero1.setToolTipText("Ingrese el número celular de la victima del caso");
        conte.add(vNumero1);

        JLabel vDireccion = new JLabel("Dirección de la persona *");
        vDireccion.setBounds(220, 340, 190, 30);
        conte.add(vDireccion);
        JTextField vDireccion1 = new JTextField();
        vDireccion1.setBounds(220, 370, 150, 30);
        vDireccion1.setToolTipText("Ingrese la dirección de la victima del caso");
        conte.add(vDireccion1);

        JLabel vEdad = new JLabel("Edad de la persona *");
        vEdad.setBounds(220, 270, 150, 30);
        conte.add(vEdad);
        JTextField vEdad1 = new JTextField();
        vEdad1.setBounds(220, 300, 150, 30);
        vEdad1.setToolTipText("Ingrese la edad de la victima del caso");
        conte.add(vEdad1);

        JLabel vGenero = new JLabel("Género de la persona *");
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

        JLabel vEcivil = new JLabel("Estado civil de la persona *");
        vEcivil.setBounds(410, 340, 190, 30);
        conte.add(vEcivil);
        JComboBox vEcivil1 = new JComboBox(estado);
        vEcivil1.setBounds(410, 370, 150, 30);
        vEcivil1.setToolTipText("Seleccione el estado civil de la victima del caso");
        conte.add(vEcivil1);

        JLabel vOcupacion = new JLabel("Ocupación de la persona *");
        vOcupacion.setBounds(220, 410, 190, 30);
        conte.add(vOcupacion);
        JTextField vOcupacion1 = new JTextField();
        vOcupacion1.setBounds(220, 440, 150, 30);
        vOcupacion1.setToolTipText("Ingrese la ocupación de la victima del caso");
        conte.add(vOcupacion1);

        JLabel vNacionalidad = new JLabel("Nacionalidad de la persona *");
        vNacionalidad.setBounds(410, 410, 190, 30);
        conte.add(vNacionalidad);
        JTextField vNacionalidad1 = new JTextField();
        vNacionalidad1.setBounds(410, 440, 150, 30);
        vNacionalidad1.setToolTipText("Ingrese la nacionalidad de la victima del caso");
        conte.add(vNacionalidad1);

        JLabel tViolencia = new JLabel("Tipo de violencia *");
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
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
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

                if (txtDescripcion.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "La descripción de la denuncia no puede estar vacia");
                    return;
                }
                // Validar campos de texto
                if (vNombre1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese el nombre de la persona");
                    return;
                }
                if (cVictima.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese la cédula de la persona");
                    return;
                }
                if (vNumero1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese el número celular de la persona");
                    return;
                }
                if (vDireccion1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese la dirección de la persona");
                    return;
                }
                if (vEdad1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese la edad de la persona");
                    return;
                }
                if (vOcupacion1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese la ocupación de la persona");
                    return;
                }
                if (vNacionalidad1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ingrese la nacionalidad de la persona");
                    return;
                }

                // Validar formato de número celular y edad
                int numeroCelular, edad;
                try {
                    numeroCelular = Integer.parseInt(vNumero1.getText().trim());
                    if (numeroCelular < 100000 || numeroCelular > 999999999) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número celular válido (solo números)");
                    return;
                }

                try {
                    edad = Integer.parseInt(vEdad1.getText().trim());
                    if (edad < 1 || edad > 100) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese una edad válida (entre 1 y 100)");
                    return;
                }

                // Validar tipo de violencia
                String tipoViolencia = tViolencia1.getSelectedItem().toString();
                if (tipoViolencia.equals("Seleccione")) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un tipo de violencia.");
                    return;
                }

                try {
                    //Si alguno de los campos de texto esta vacio entra a este metodo y se solicita llenar todos los componentes.
                    if (vNombre1.getText().isEmpty() || cVictima.getText().isEmpty() || vNumero1.getText().isEmpty()
                            || vDireccion1.getText().isEmpty() || vEdad1.getText().isEmpty() || vOcupacion1.getText().isEmpty()
                            || vNacionalidad1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Complete todos los campos");
                        return;
                    }

                    try {
                        //Si toda la informacion esta completa dependiendo de la seccion de un JComboBox donde se debe de eligir un tipo de violencia se me desplegara otra ventana solicitando los datos especificos de tipo de violencia.
                        if (tViolencia1.getSelectedItem().toString().equals("Violencia Digital")) {
                            vDigital caso = new vDigital(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                    Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                    genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            // ListaCasos.add(new vDigital(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                            //Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                            //genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText()));

                            ingresarCaso1(caso, stmt);
                            //ListaCasos.add(caso);
                            //listaResultados.add(ListaCasos.get(ListaCasos.size()-1).mostrarcaso());
                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Economica")) {
                            vEconomica caso = new vEconomica(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                    Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                    genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());
                            //ListaCasos.add(new vEconomica(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                            //Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                            //genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText()));
                            ingresarCaso2(caso, stmt);

                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Emocional")) {
                            vEmocional caso = new vEmocional(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                    Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                    genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());

                            ingresarCaso3(caso, stmt);

                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Fisica")) {
                            vFisica caso = new vFisica(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                    Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                    genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());

                            ingresarCaso4(caso, stmt);

                            frame.dispose();
                        } else if (tViolencia1.getSelectedItem().toString().equals("Violencia Sexual")) {
                            vSexual caso = new vSexual(f, h, txtDescripcion.getText(), vNombre1.getText(), cVictima.getText(),
                                    Integer.parseInt(vNumero1.getText()), vDireccion1.getText(), Integer.parseInt(vEdad1.getText()),
                                    genero, vEcivil1.getSelectedItem().toString(), vOcupacion1.getText(), vNacionalidad1.getText());

                            ingresarCaso5(caso, stmt);
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
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnGuardar.setBounds(30, 510, 100, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnGuardar.setBounds(30, 510, 100, 30);
            }
        });
    }
    //Fin de metodo donde se nos solicita la informacion general.    

    //Declaracion de este metodo para poder ver la informacion de un caso en especifico y ver si tiene respuesta o no.
    public void visualizarCaso(Statement stmt) {
      
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
        campo.setToolTipText("Ingrese alguno de los ID de los casos registrados, que desea visualizar");
        conte.add(campo);
        campo.requestFocus();
        JTextArea txtId = new JTextArea();
        txtId.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textoSeleccionado = txtId.getSelectedText();
                if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
                    campo.setText(textoSeleccionado);
                }
            }
        });
   campo.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        String texto = campo.getText().trim();

        if (texto.isEmpty()) {
          
            
            try {
          
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM caso");
            txtId.setText("");
            while (rs1.next()) {
                txtId.append(rs1.getString("Cedula")+"\n");
            }
     
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            return;
        }

        try {
            // Usa LIKE para filtrar desde SQL
            String query = "SELECT * FROM caso WHERE Cedula LIKE '" + texto + "%'";
            ResultSet rs = stmt.executeQuery(query);
            txtId.setText(""); 

            while (rs.next()) {
                String cedula = rs.getString("Cedula");
                txtId.append(cedula + "\n"); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
            while (rs.next()) {
                txtId.append(rs.getString("Cedula")+"\n");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        txtId.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtId);
        scroll.setBounds(80, 80, 200, 200);
        conte.add(scroll);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(80, 380, 100, 30);
        ImageIcon iconBuscar = new ImageIcon("Iconos/buscar.PNG");
        btnBuscar.setIcon(iconBuscar);
        conte.add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campo.getText();
                frame.dispose();
                //Se declara ResultSet para comparar el caso de la cedula buscada con la cedula de la base de datos
                try {
                    ResultSet rs2 = stmt.executeQuery("SELECT * FROM caso");
                    while (rs2.next()) {
                        if (rs2.getString("Cedula").equals(id)) {
                            String cedulaReferencia = rs2.getString("Cedula");
                            String mensaje = "Caso encontrado\n"
                                    + "Cedula: " + cedulaReferencia
                                    + "\nNombre: " + rs2.getString("Nombre")
                                    + "\nNumero Celular: " + rs2.getString("NumeroCelular")
                                    + "\nDireccion: " + rs2.getString("Direccion")
                                    + "\nEdad: " + rs2.getString("Edad")
                                    + "\nGenero: " + rs2.getString("Genero")
                                    + "\nEstadoCivil: " + rs2.getString("EstadoCivil")
                                    + "\nOcupacion: " + rs2.getString("Ocupacion")
                                    + "\nNacionalidad: " + rs2.getString("Nacionalidad")
                                    + "\nTipo de violencia: " + rs2.getString("TipoViolencia")
                                    + "\nNombre del Agresor: " + rs2.getString("Agresor")
                                    + "\nTipo de relacion con Agresor: " + rs2.getString("RelacionAgresor")
                                    + "\nGenero del Agresor: " + rs2.getString("GeneroAgresor");

                            // Agregar los campos adicionales segun el tipo de violencia
                            String tipoViolencia = rs2.getString("TipoViolencia");

                            if (tipoViolencia.equals("Violencia Emocional")) {
                                mensaje += "\nImpacto Psicologico: " + rs2.getString("ImpactoPsicologico");
                            } else if (tipoViolencia.equals("Violencia Fisica")) {
                                mensaje += "\nTipo de Lesion: " + rs2.getString("TipoLesion")
                                        + "\nAtencion Medica: " + rs2.getString("AtencionMedica");
                            } else if (tipoViolencia.equals("Violencia Sexual")) {
                                mensaje += "\nTipo de Abuso Sexual: " + rs2.getString("TipoAbusoSexual");
                            } else if (tipoViolencia.equals("Violencia Economica")) {
                                mensaje += "\nTipo de Ingreso: " + rs2.getString("TipoIngreso")
                                        + "\nCantidad de Ingreso: " + rs2.getString("CantidadIngreso");
                            } else if (tipoViolencia.equals("Violencia Digital")) {
                                mensaje += "\nPlataforma digital en donde se dio la Agresion: " + rs2.getString("PlataformaDigital");
                            }

                            mensaje += "\nDescripcion: " + rs2.getString("Descripcion");
                            ResultSet rs3 = stmt.executeQuery("select *from oficinaregional");
                            while (rs3.next()) {
                                if (rs3.getString("CedulaCaso").equals(cedulaReferencia)) {
                                    mensaje += "\n\n✅ Seguimiento registrado:"
                                            + "\nFuncionario: " + rs3.getString("Nombre")
                                            + "\nCódigo Funcionario: " + rs3.getString("IDempleado")
                                            + "\nSolución: " + rs3.getString("Solucion")
                                            + "\nOficina: " + rs3.getString("Lugar")
                                            + "\nDirección Oficina: " + rs3.getString("Direccion")
                                            + "\nTeléfono Oficina: " + rs3.getString("Telefono")
                                            + "\nFecha Atención: " + rs3.getString("FechaAtencion")
                                            + "\nHora Atención: " + rs3.getString("HoraAtencion");
                                }
                            }

                            JOptionPane.showMessageDialog(null, mensaje);
                            return;
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso no encontrado.");
            }
            
        });
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnBuscar.setBounds(80, 380, 100, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnBuscar.setBounds(80, 380, 100, 30);
            }
        });
        frame.add(conte);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Fin de moetodo visualizar un caso en especifico.

    //Metodo declarado para mostrar los componente graficos utilizados para solicitar la informacion especifica de Violencio digital.
    public void ingresarCaso1(vDigital caso, Statement stmt) {
        JFrame frame = new JFrame("Información adicional del caso Violencia digital");
        Container conte = new Container();
        conte.setLayout(null);

        JLabel pDigital = new JLabel("Ingrese la plataforma donde se dio la agresión: *");
        pDigital.setBounds(30, 50, 300, 30);
        conte.add(pDigital);
        JTextField pDigital1 = new JTextField();
        pDigital1.setBounds(50, 80, 200, 30);
        pDigital1.setToolTipText("Ingrese la plataforma digital (facebook, instagram, twitter, etc.) donde se dio la agresión");
        conte.add(pDigital1);
        JLabel agresor = new JLabel("Nombre del agresor: *");
        agresor.setBounds(30, 120, 200, 30);
        conte.add(agresor);
        JTextField agresor1 = new JTextField();
        agresor1.setBounds(50, 150, 200, 30);
        agresor1.setToolTipText("Ingrese el nombre de la persona que agredio a la victima");
        conte.add(agresor1);
        JLabel rAgresor = new JLabel("Relación con el agresor: *");
        rAgresor.setBounds(30, 190, 200, 30);
        conte.add(rAgresor);
        JTextField rAgresor1 = new JTextField();
        rAgresor1.setToolTipText("Ingrese la relación con el agresor (amigo, familiar, desconocido, etc.)");
        rAgresor1.setBounds(50, 220, 200, 30);
        conte.add(rAgresor1);
        JLabel gAgresor = new JLabel("Género del agresor: *");
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
        ImageIcon iconGuardar = new ImageIcon("Iconos/guardar-el-archivo.PNG");
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                // caso.iDatos(pDigital1.getText(), agresor1.getText(), rAgresor1.getText(), gAgresor);
                //ListaCasos.add(caso);
                //listaResultados.add(ListaCasos.get(ListaCasos.size()-1).mostrarcaso());
                // ListaCasos.get(ListaCasos.size()-1).iDatos(pDigital1.getText(), agresor1.getText(), rAgresor1.getText(), gAgresor);
                if (pDigital1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la plataforma digital donde se dio la agresión");
                    return;
                }
                if (agresor1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del agresor");
                    return;
                }
                if (rAgresor1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la relación con el agresor");
                    return;
                }
                if (gAgresor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe Seleccionar el género del agresor");
                    return;
                }
                //Si todos los campos estan completos se procede a guardar el caso en la base de datos.    
                try {
                    int valor = stmt.executeUpdate("INSERT INTO caso (Cedula, Nombre, NumeroCelular, Direccion, Edad, Genero, EstadoCivil, Ocupacion, Nacionalidad, TipoViolencia, Agresor, RelacionAgresor, GeneroAgresor, TipoLesion, AtencionMedica, ImpactoPsicologico, TipoAbusoSexual, TipoIngreso, CantidadIngreso, PlataformaDigital, Fecha, Hora, Descripcion, Resuelto) VALUES ('" + caso.getVictima().getCedula() + "','" + caso.getVictima().getNombre() + "','" + caso.getVictima().getnCelular() + "','" + caso.getVictima().getDireccion() + "','" + caso.getVictima().getEdad() + "','" + caso.getVictima().getGenero() + "','" + caso.getVictima().getEstadoCivil() + "','" + caso.getVictima().getOcupacion() + "','" + caso.getVictima().getNacionalidad() + "','" + "Violencia Digital" + "','" + agresor1.getText() + "','" + rAgresor1.getText() + "','" + gAgresor + "','" + " " + "','" + " " + "','" + " " + "','" + " " + "','" + " " + "','" + "0" + "','" + pDigital1.getText() + "','" + caso.getFecha() + "','" + caso.getHora() + "','" + caso.getDescripcion() + "','FALSE')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
                    //While para comprobar los datos actual de la base de datos.
                    while (rs.next()) {
                        System.out.println("Cedula: " + rs.getString("Cedula") + " Nombre: " + rs.getString("Nombre") + " Plataforma Digital:" + rs.getString("PlataformaDigital"));
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }
        });
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnGuardar.setBounds(30, 400, 100, 40);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnGuardar.setBounds(30, 400, 100, 30);
            }
        });

        frame.add(conte);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar la informacion de violencia digital.
    //Metodo declarado para mostrar los componente graficos utilizados para solicitar la informacion especifica de Violencio economica.
    public void ingresarCaso2(vEconomica caso, Statement stmt) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Económica");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel tipoIngresoLabel = new JLabel("Ingrese el tipo de ingreso afectado: *");
        tipoIngresoLabel.setBounds(20, 20, 350, 30);
        conte.add(tipoIngresoLabel);
        JTextField tipoIngresoField = new JTextField();
        tipoIngresoField.setBounds(20, 50, 340, 30);
        tipoIngresoField.setToolTipText("Ingrese el tipo de ingreso afectado (salario, pensión, etc.)");
        conte.add(tipoIngresoField);

        JLabel impactoFinancieroLabel = new JLabel("Ingrese el impacto financiero: *");
        impactoFinancieroLabel.setBounds(20, 90, 350, 30);
        conte.add(impactoFinancieroLabel);
        JTextField impactoFinancieroField = new JTextField();
        impactoFinancieroField.setBounds(20, 120, 340, 30);
        impactoFinancieroField.setToolTipText("Ingrese el impacto financiero (cantidad de dinero afectada)");
        conte.add(impactoFinancieroField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor: *");
        agresorLabel.setBounds(20, 160, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 190, 340, 30);
        agresorField.setToolTipText("Ingrese el nombre de la persona que agredio a la victima");
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor: *");
        rAgresorLabel.setBounds(20, 230, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 260, 340, 30);
        rAgresorField.setToolTipText("Ingrese la relación con el agresor (amigo, familiar, desconocido, etc.)");
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor: *");
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
        ImageIcon iconGuardar = new ImageIcon("Iconos/guardar-el-archivo.PNG");
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                if (tipoIngresoField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el tipo de ingreso afectado");
                    return;
                }
                if (impactoFinancieroField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el impacto financiero");
                    return;
                }
                if (agresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del agresor");
                    return;
                }
                double impactoFinanciero;
                try {
                    impactoFinanciero = Double.parseDouble(impactoFinancieroField.getText().trim());
                    if (impactoFinanciero < 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un impacto financiero válido (número positivo y ejemplo: 1000.50)");
                    return;
                }
                if (rAgresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la relación con el agresor");
                    return;
                }
                if (gAgresor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe Seleccionar el género del agresor");
                    return;
                }
                //Si todos los campos estan completos se procede a guardar el caso en la base de datos.
                try {
                    int valor = stmt.executeUpdate("INSERT INTO caso (Cedula, Nombre, NumeroCelular, Direccion, Edad, Genero, EstadoCivil, Ocupacion, Nacionalidad, TipoViolencia, Agresor, RelacionAgresor, GeneroAgresor, TipoLesion, AtencionMedica, ImpactoPsicologico, TipoAbusoSexual, TipoIngreso, CantidadIngreso, PlataformaDigital, Fecha, Hora, Descripcion, Resuelto) VALUES ('" + caso.getVictima().getCedula() + "','" + caso.getVictima().getNombre() + "','" + caso.getVictima().getnCelular() + "','" + caso.getVictima().getDireccion() + "','" + caso.getVictima().getEdad() + "','" + caso.getVictima().getGenero() + "','" + caso.getVictima().getEstadoCivil() + "','" + caso.getVictima().getOcupacion() + "','" + caso.getVictima().getNacionalidad() + "','" + "Violencia Economica" + "','" + agresorField.getText() + "','" + rAgresorField.getText() + "','" + gAgresor + "','" + " " + "','" + " " + "','" + " " + "','" + " " + "','" + tipoIngresoField.getText() + "','" + impactoFinancieroField.getText() + "','" + " " + "','" + caso.getFecha() + "','" + caso.getHora() + "','" + caso.getDescripcion() + "','FALSE')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
                    //While para comprobar los datos actual de la base de datos.
                    while (rs.next()) {
                        System.out.println("Cedula: " + rs.getString("Cedula") + " Nombre: " + rs.getString("Nombre") + " Tipo ingreso:" + rs.getString("TipoIngreso") + " Impacto Financiero: " + rs.getString("CantidadIngreso"));
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }
        });
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Acción al pasar el mouse por encima
                btnGuardar.setBounds(20, 380, 100, 40);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Acción al quitar el mouse del botón
                btnGuardar.setBounds(20, 380, 100, 30);
            }
        });

        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar la informacion de violencia economica.

    //Metodo declarado para mostrar los componente graficos utilizados para solicitar la informacion especifica de Violencio emocional.
    public void ingresarCaso3(vEmocional caso, Statement stmt) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Emocional");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel impactoPsicologicoLabel = new JLabel("Ingrese el impacto psicológico: *");
        impactoPsicologicoLabel.setBounds(20, 20, 350, 30);
        conte.add(impactoPsicologicoLabel);
        JTextField impactoPsicologicoField = new JTextField();
        impactoPsicologicoField.setBounds(20, 50, 340, 30);
        impactoPsicologicoField.setToolTipText("descripción del impacto emocional(depresión, ansiedad, etc.)");
        conte.add(impactoPsicologicoField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor: *");
        agresorLabel.setBounds(20, 90, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 120, 340, 30);
        agresorField.setToolTipText("Ingrese el nombre de la persona que agredio a la victima");
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor: *");
        rAgresorLabel.setBounds(20, 160, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 190, 340, 30);
        rAgresorField.setToolTipText("Ingrese la relación con el agresor (amigo, familiar, desconocido, etc.)");
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor: *");
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
        ImageIcon iconGuardar = new ImageIcon("Iconos/guardar-el-archivo.PNG");
        btnGuardar.setIcon(iconGuardar);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                if (impactoPsicologicoField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el impacto psicológico");
                    return;
                }
                if (agresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del agresor");
                    return;
                }
                if (rAgresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la relación con el agresor");
                    return;
                }
                if (gAgresor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe Seleccionar el género del agresor");
                    return;
                }
                try {
                    int valor = stmt.executeUpdate("INSERT INTO caso (Cedula, Nombre, NumeroCelular, Direccion, Edad, Genero, EstadoCivil, Ocupacion, Nacionalidad, TipoViolencia, Agresor, RelacionAgresor, GeneroAgresor, TipoLesion, AtencionMedica, ImpactoPsicologico, TipoAbusoSexual, TipoIngreso, CantidadIngreso, PlataformaDigital, Fecha, Hora, Descripcion, Resuelto) VALUES ('" + caso.getVictima().getCedula() + "','" + caso.getVictima().getNombre() + "','" + caso.getVictima().getnCelular() + "','" + caso.getVictima().getDireccion() + "','" + caso.getVictima().getEdad() + "','" + caso.getVictima().getGenero() + "','" + caso.getVictima().getEstadoCivil() + "','" + caso.getVictima().getOcupacion() + "','" + caso.getVictima().getNacionalidad() + "','" + "Violencia Emocional" + "','" + agresorField.getText() + "','" + rAgresorField.getText() + "','" + gAgresor + "','" + " " + "','" + " " + "','" + impactoPsicologicoField.getText() + "','" + " " + "','" + " " + "','" + "0" + "','" + " " + "','" + caso.getFecha() + "','" + caso.getHora() + "','" + caso.getDescripcion() + "','FALSE')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
                    //While para comprobar los datos actual de la base de datos
                    while (rs.next()) {
                        System.out.println("Cedula: " + rs.getString("Cedula") + " Nombre: " + rs.getString("Nombre") + " Impacto Psicologico:" + rs.getString("ImpactoPsicologico"));
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }
        });
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Acción al pasar el mouse por encima
                btnGuardar.setText("¡Estás sobre mí!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Acción al quitar el mouse del botón
                btnGuardar.setText("Pasa el cursor por aquí");
            }
        });
        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar la informacion de violencia emocional.

    //Metodo declarado para mostrar los componente graficos utilizados para solicitar la informacion especifica de Violencio fisica.
    public void ingresarCaso4(vFisica caso, Statement stmt) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Física");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel tipoLesionLabel = new JLabel("Ingrese el tipo de lesión: *");
        tipoLesionLabel.setBounds(20, 20, 350, 30);
        conte.add(tipoLesionLabel);
        JTextField tipoLesionField = new JTextField();
        tipoLesionField.setBounds(20, 50, 340, 30);
        tipoLesionField.setToolTipText("Cual fue el tipo de lesion (corte, contusión, fractura, etc.)");
        conte.add(tipoLesionField);

        JLabel atencionMedicaLabel = new JLabel("Ingrese la atención médica recibida: *");
        atencionMedicaLabel.setBounds(20, 90, 350, 30);
        conte.add(atencionMedicaLabel);
        JTextField atencionMedicaField = new JTextField();
        atencionMedicaField.setBounds(20, 120, 340, 30);
        atencionMedicaField.setToolTipText("Que atencion medica recibio la victima (hospitalización, consulta médica, etc.)");
        conte.add(atencionMedicaField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor: *");
        agresorLabel.setBounds(20, 160, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 190, 340, 30);
        agresorField.setToolTipText("Ingrese el nombre de la persona que agredio a la victima");
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor: *");
        rAgresorLabel.setBounds(20, 230, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 260, 340, 30);
        rAgresorField.setToolTipText("Ingrese la relación con el agresor (amigo, familiar, desconocido, etc.)");
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor: *");
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
        ImageIcon icono = new ImageIcon("Iconos/guardar-el-archivo.png");
        btnGuardar.setIcon(icono);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                if (tipoLesionField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el tipo de lesión");
                    return;
                }
                if (atencionMedicaField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la atención médica recibida");
                    return;
                }
                if (agresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del agresor");
                    return;
                }
                if (rAgresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la relación con el agresor");
                    return;
                }
                if (gAgresor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe Seleccionar el género del agresor");
                    return;
                }
                //Si todos los campos estan completos se procede a guardar el caso en la base de datos.
                try {
                    int valor = stmt.executeUpdate("INSERT INTO caso (Cedula, Nombre, NumeroCelular, Direccion, Edad, Genero, EstadoCivil, Ocupacion, Nacionalidad, TipoViolencia, Agresor, RelacionAgresor, GeneroAgresor, TipoLesion, AtencionMedica, ImpactoPsicologico, TipoAbusoSexual, TipoIngreso, CantidadIngreso, PlataformaDigital, Fecha, Hora, Descripcion, Resuelto) VALUES ('" + caso.getVictima().getCedula() + "','" + caso.getVictima().getNombre() + "','" + caso.getVictima().getnCelular() + "','" + caso.getVictima().getDireccion() + "','" + caso.getVictima().getEdad() + "','" + caso.getVictima().getGenero() + "','" + caso.getVictima().getEstadoCivil() + "','" + caso.getVictima().getOcupacion() + "','" + caso.getVictima().getNacionalidad() + "','" + "Violencia Fisica" + "','" + agresorField.getText() + "','" + rAgresorField.getText() + "','" + gAgresor + "','" + tipoLesionField.getText() + "','" + atencionMedicaField.getText() + "','" + " " + "','" + " " + "','" + " " + "','" + "0" + "','" + " " + "','" + caso.getFecha() + "','" + caso.getHora() + "','" + caso.getDescripcion() + "','FALSE')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
                    //While para comprobar los datos actual de la base de datos.
                    while (rs.next()) {
                        
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }

        });
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnGuardar.setBounds(20, 380, 100, 40);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnGuardar.setBounds(20, 380, 100, 30);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar la informacion de violencia fisica.

    //Metodo declarado para mostrar los componente graficos utilizados para solicitar la informacion especifica de Violencio sexual.
    public void ingresarCaso5(vSexual caso, Statement stmt) {
        JFrame frame = new JFrame("Información adicional del caso Violencia Sexual");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel tipoAbusoSexualLabel = new JLabel("Ingrese el tipo de abuso sexual: *");
        tipoAbusoSexualLabel.setBounds(20, 20, 350, 30);
        conte.add(tipoAbusoSexualLabel);
        JTextField tipoAbusoSexualField = new JTextField();
        tipoAbusoSexualField.setBounds(20, 50, 340, 30);
        tipoAbusoSexualField.setToolTipText("Cual fue el abuso recibido (acoso, violación, etc.)");
        conte.add(tipoAbusoSexualField);

        JLabel agresorLabel = new JLabel("Ingrese el nombre del agresor: *");
        agresorLabel.setBounds(30, 90, 350, 30);
        conte.add(agresorLabel);
        JTextField agresorField = new JTextField();
        agresorField.setBounds(20, 120, 340, 30);
        agresorField.setToolTipText("Ingrese el nombre de la persona que agredio a la victima");
        conte.add(agresorField);

        JLabel rAgresorLabel = new JLabel("Ingrese la relación con el agresor: *");
        rAgresorLabel.setBounds(20, 160, 350, 30);
        conte.add(rAgresorLabel);
        JTextField rAgresorField = new JTextField();
        rAgresorField.setBounds(20, 190, 340, 30);
        rAgresorField.setToolTipText("Ingrese la relación con el agresor (amigo, familiar, desconocido, etc.)");
        conte.add(rAgresorField);

        JLabel gAgresor = new JLabel("Género del agresor: *");
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
        ImageIcon icon = new ImageIcon("Iconos/guardar-el-archivo.png");
        btnGuardar.setIcon(icon);
        conte.add(btnGuardar);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                String gAgresor = "";
                if (gAgresor1.isSelected()) {
                    gAgresor = "Masculino";
                } else if (gAgresor2.isSelected()) {
                    gAgresor = "Femenino";
                } else if (gAgresor3.isSelected()) {
                    gAgresor = "Otro";
                }
                if (tipoAbusoSexualField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el tipo de abuso sexual");
                    return;
                }
                if (agresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del agresor");
                    return;
                }
                if (rAgresorField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la relación con el agresor");
                    return;
                }
                if (gAgresor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe Seleccionar el género del agresor");
                    return;
                }
                //Si todos los campos estan completos se procede a guardar el caso en la base de datos.
                try {
                    int valor = stmt.executeUpdate("INSERT INTO caso (Cedula, Nombre, NumeroCelular, Direccion, Edad, Genero, EstadoCivil, Ocupacion, Nacionalidad, TipoViolencia, Agresor, RelacionAgresor, GeneroAgresor, TipoLesion, AtencionMedica, ImpactoPsicologico, TipoAbusoSexual, TipoIngreso, CantidadIngreso, PlataformaDigital, Fecha, Hora, Descripcion, Resuelto) VALUES ('" + caso.getVictima().getCedula() + "','" + caso.getVictima().getNombre() + "','" + caso.getVictima().getnCelular() + "','" + caso.getVictima().getDireccion() + "','" + caso.getVictima().getEdad() + "','" + caso.getVictima().getGenero() + "','" + caso.getVictima().getEstadoCivil() + "','" + caso.getVictima().getOcupacion() + "','" + caso.getVictima().getNacionalidad() + "','" + "Violencia Sexual" + "','" + agresorField.getText() + "','" + rAgresorField.getText() + "','" + gAgresor + "','" + " " + "','" + " " + "','" + " " + "','" + tipoAbusoSexualField.getText() + "','" + " " + "','" + "0" + "','" + " " + "','" + caso.getFecha() + "','" + caso.getHora() + "','" + caso.getDescripcion() + "','FALSE" + "')");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
                    //While para comprobar los datos actual de la base de datos.    
                    while (rs.next()) {
                        System.out.println("Cedula: " + rs.getString("Cedula") + " Nombre: " + rs.getString("Nombre") + " Tipo Abuso Sexual:" + rs.getString("TipoAbusoSexual"));
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Caso registrado correctamente.");
                frame.dispose();
            }
        });
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnGuardar.setBounds(20, 310, 100, 40);
            }

            public void mouseExited(MouseEvent e) {
                btnGuardar.setBounds(20, 310, 100, 30);

            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar la informacion de violencia sexual.

    //Metodo declarado para mostrar los componente graficos utilizados para solicitar poder editar la descripcion de un caso registrado, a su misma vez al hacerlo se cambian la fecha y hora del caso que se este editando.
    public void modificarCaso(Statement stmt) {
        JFrame frame = new JFrame("Modificar Caso");
        Container conte = new Container();
        conte.setLayout(null);

        JTextArea textArea = new JTextArea();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM caso");
            while (rs.next()) {
                textArea.append(rs.getString("Cedula")+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(30, 30, 200, 200);
        conte.add(scroll);

        JLabel lblCedula = new JLabel("Ingrese la cédula del caso:");
        lblCedula.setBounds(30, 230, 200, 30);
        conte.add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(30, 260, 200, 30);
        txtCedula.setToolTipText("Ingrese la cédula del caso que desea editar la descripcion");
        conte.add(txtCedula);

         textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textoSeleccionado = textArea.getSelectedText();
                if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
                    txtCedula.setText(textoSeleccionado);
                }
            }
        });
   txtCedula.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        String texto = txtCedula.getText().trim();

       
        if (texto.isEmpty()) {
          try {
          
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM caso");
            textArea.setText("");
            while (rs1.next()) {
                textArea.append(rs1.getString("Cedula")+"\n");
            }
     
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            return;
        }

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM caso");
            textArea.setText(""); 

            while (rs.next()) {
                String cedula = rs.getString("Cedula");
                if (cedula.startsWith(texto)) {
                    textArea.append(cedula + "\n"); 
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});

        JButton btnBuscar = new JButton("Buscar");
        ImageIcon icon = new ImageIcon("Iconos/buscar.png");
        btnBuscar.setIcon(icon);
        btnBuscar.setBounds(30, 310, 100, 30);
        conte.add(btnBuscar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                boolean index = false;

                try {
                    ResultSet rs2 = stmt.executeQuery("SELECT * FROM caso");
                    while (rs2.next()) {
                        if (rs2.getString("Cedula").equals(cedula)) {
                            index = true;

                        }
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

                //Si el caso no es encontrado se despliega un JOptionPane con el mensaje de que no se encontro el caso.
                if (index == true) {
                    frame.dispose();
                    try {
                        editarCaso(stmt, cedula);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Caso no encontrado.");
                    txtCedula.setText("");
                }
            }
        });
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBuscar.setBounds(30, 310, 100, 40);
            }

            public void mouseExited(MouseEvent e) {
                btnBuscar.setBounds(30, 310, 100, 30);

            }
        });

        frame.add(conte);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Fin de metodo utilizado para solicitar poder editar la descripcion de un caso registrado.

//Si al momento de editar un caso se encuentra un registro entonces se llama a este metodo, solicitando que ingresemos una nueva descripcion.
    public void editarCaso(Statement stmt, String cedula) throws SQLException {
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM caso ");
            while (rs.next()) {
                if (rs.getString("Cedula").equals(cedula)) {
                    break;
                }
            }

            JFrame frame = new JFrame("Editar Caso");
            Container conte = new Container();
            conte.setLayout(null);

            JLabel lblFecha = new JLabel("Fecha:");
            lblFecha.setBounds(30, 30, 100, 30);
            conte.add(lblFecha);
            JTextField txtFecha = new JTextField(rs.getString("Fecha"));
            txtFecha.setBounds(130, 30, 150, 30);
            conte.add(txtFecha);

            JLabel lblHora = new JLabel("Hora:");
            lblHora.setBounds(30, 70, 100, 30);
            conte.add(lblHora);
            JTextField txtHora = new JTextField(rs.getString("Hora"));
            txtHora.setBounds(130, 70, 150, 30);
            conte.add(txtHora);

            JLabel lblDescripcion = new JLabel("Descripción:");
            lblDescripcion.setBounds(30, 110, 100, 30);
            conte.add(lblDescripcion);
            JTextArea txtDescripcion = new JTextArea(rs.getString("Descripcion"));
            txtDescripcion.setLineWrap(true);
            JScrollPane scroll = new JScrollPane(txtDescripcion);
            scroll.setBounds(130, 110, 300, 100);
            txtDescripcion.setToolTipText("Ingrese la nueva descripcion del caso");
            conte.add(scroll);

            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.setBounds(30, 230, 100, 30);
            ImageIcon icon = new ImageIcon("Iconos/guardar-el-archivo.png");
            btnGuardar.setIcon(icon);
            conte.add(btnGuardar);
            btnGuardar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Respuesta", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.NO_OPTION) {
                        frame.dispose();
                        return;
                    }
                    try {
                        int valor = stmt.executeUpdate("UPDATE Caso Set Fecha = '" + txtFecha.getText() + "' WHERE Cedula = '" + cedula + "'");
                        valor = stmt.executeUpdate("UPDATE Caso Set Hora = '" + txtHora.getText() + "' WHERE Cedula = '" + cedula + "'");
                        valor = stmt.executeUpdate("UPDATE Caso Set Descripcion = '" + txtDescripcion.getText() + "' WHERE Cedula = '" + cedula + "'");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    //Al presionar el boton guardar se llama al metodo modificarcaso de la clase caso, donde se le pasan los nuevos valores de fecha, hora y descripcion.
                    // caso.modificarcaso(txtFecha.getText(), txtHora.getText(), txtDescripcion.getText());
                    //Como al mostrar los casos se utiliza el arraiList listaResultados entonces hay que editar este registro tambien en dondes se agreguen los valores nuevos y una respuesta si es que la tiene
                    // listaResultados.set(index, caso.mostrarcaso());
                    JOptionPane.showMessageDialog(null, "Caso modificado correctamente.");
                    frame.dispose();
                }
            });
            btnGuardar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnGuardar.setBounds(30, 230, 100, 40);
                }

                public void mouseExited(MouseEvent e) {
                    btnGuardar.setBounds(30, 230, 100, 30);

                }
            });
            frame.add(conte);
            frame.setSize(460, 320);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Fin de metodo utilizado para editar la descripcion de un caso.

    //Metodo declarado para mostrar los casos registrados y solicitar el # de cedula para poder mostrar ese caso.
    public void mostratCasos(Statement stmt) {
        System.out.println("Hola");
        JFrame frame = new JFrame("Casos Registrados");
        frame.setSize(500, 520);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel lblID = new JLabel("Todos los casos registrados:");
        lblID.setBounds(100, 20, 300, 30);
        conte.add(lblID);

        JTextArea txtId = new JTextArea();
        txtId.setEditable(false);
        txtId.setFont(new Font("Arial", Font.PLAIN, 12));
        txtId.setLineWrap(true);
        txtId.setWrapStyleWord(true);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(160, 430, 150, 30);
        ImageIcon icon = new ImageIcon("Iconos/aceptar-el-contorno-del-boton-circular.png");
        btnAceptar.setIcon(icon);
        conte.add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
    }
});
btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAceptar.setBounds(160, 430, 150, 40);
            }

            public void mouseExited(MouseEvent e) {
                btnAceptar.setBounds(160, 430, 150, 30);
            }
        });

        conte.add(btnAceptar);

        // Botón para mostrar los casos
       
                txtId.setText(""); // Limpiar el área de texto antes de mostrar los casos
// Conexión a la base de datos
                Connection con = null;
                //Statement stmt1 = null;
                Statement stmt2 = null;

                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto1?verifyServerCertificate=false&useSSL=true", "root", "cRojas34");
                    stmt = con.createStatement();
                    stmt2 = con.createStatement();

// Consulta para obtener los casos y sus seguimientos
                    ResultSet rs = stmt.executeQuery(
                            "SELECT c.*, o.Nombre AS NombreFuncionario, o.IDempleado, o.Solucion, o.Lugar, o.Direccion AS DireccionOficina, o.Telefono, o.FechaAtencion, o.HoraAtencion "
                            + "FROM caso c LEFT JOIN oficinaregional o ON c.Cedula = o.CedulaCaso"
                    );
                    int contador = 1;

                    while (rs.next()) {
                        System.out.println("Hola2");
                        String cedula = rs.getString("Cedula");
                        String tipoViolencia = rs.getString("TipoViolencia");

                        String mensaje = "CASO REGISTRADO N° " + contador + "\n"
                                + "Cédula: " + cedula
                                + "\nNombre: " + rs.getString("Nombre")
                                + "\nCelular: " + rs.getString("NumeroCelular")
                                + "\nDirección: " + rs.getString("Direccion")
                                + "\nEdad: " + rs.getString("Edad")
                                + "\nGénero: " + rs.getString("Genero")
                                + "\nEstado Civil: " + rs.getString("EstadoCivil")
                                + "\nOcupación: " + rs.getString("Ocupacion")
                                + "\nNacionalidad: " + rs.getString("Nacionalidad")
                                + "\nTipo de violencia: " + tipoViolencia
                                + "\nAgresor: " + rs.getString("Agresor")
                                + "\nRelación con agresor: " + rs.getString("RelacionAgresor")
                                + "\nGénero del agresor: " + rs.getString("GeneroAgresor");

                        // Dependiendo del tipo de violencia, agrega información específica
                        if (tipoViolencia.equals("Violencia Emocional")) {
                            mensaje += "\nImpacto Psicológico: " + rs.getString("ImpactoPsicologico");
                        } else if (tipoViolencia.equals("Violencia Fisica")) {
                            mensaje += "\nTipo de Lesión: " + rs.getString("TipoLesion")
                                    + "\nAtención Médica: " + rs.getString("AtencionMedica");
                        } else if (tipoViolencia.equals("Violencia Sexual")) {
                            mensaje += "\nTipo de Abuso Sexual: " + rs.getString("TipoAbusoSexual");
                        } else if (tipoViolencia.equals("Violencia Economica")) {
                            mensaje += "\nTipo de Ingreso: " + rs.getString("TipoIngreso")
                                    + "\nCantidad de Ingreso: " + rs.getString("CantidadIngreso");
                        } else if (tipoViolencia.equals("Violencia Digital")) {
                            mensaje += "\nPlataforma de Agresión: " + rs.getString("PlataformaDigital");
                        }

                        mensaje += "\nDescripción del caso: " + rs.getString("Descripcion");

                        // Verifica si hay seguimiento del caso)
                        if (rs.getString("NombreFuncionario") != null) {
                            mensaje += "\n\n✅ Seguimiento registrado:"
                                    + "\nFuncionario: " + rs.getString("NombreFuncionario")
                                    + "\nCódigo Funcionario: " + rs.getString("IDempleado")
                                    + "\nSolución: " + rs.getString("Solucion")
                                    + "\nOficina: " + rs.getString("Lugar")
                                    + "\nDirección Oficina: " + rs.getString("DireccionOficina")
                                    + "\nTeléfono Oficina: " + rs.getString("Telefono")
                                    + "\nFecha Atención: " + rs.getString("FechaAtencion")
                                    + "\nHora Atención: " + rs.getString("HoraAtencion");
                        }
                        mensaje += "\n-----------------------------------------------------------\n\n";
                        txtId.append(mensaje);
                        contador++;
                    }

                    rs.close();

                    if (contador == 1) {
                        txtId.setText("No hay casos resueltos registrados.");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos.");
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                        if (stmt2 != null) {
                            stmt2.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            
      
        JScrollPane scroll = new JScrollPane(txtId);
        scroll.setBounds(30, 60, 420, 360);
        conte.add(scroll);
        //conte.add(btnMostrar);

        frame.setContentPane(conte);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
//Fin de metodo utilizado para mostrar los casos registrados y solicitar el # de cedula para poder mostrar ese caso.

    //Metodo utilizado para solicitar la cedula de un caso y poder darle una solucion.
    public void resolverCaso(Statement stmt) {
        // ResultSet rs = stmt.executeQuery("select *from caso")
        JFrame frame = new JFrame("Resolver Caso");
        Container conte = frame.getContentPane(); // Usamos el contentPane correctamente
        conte.setLayout(null);

        JLabel lbl = new JLabel("Casos registrados");
        lbl.setBounds(40,10,150,30);
        conte.add(lbl);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        try {
            // Consulta para obtener los casos no resueltos
            ResultSet rs = stmt.executeQuery("SELECT Cedula, TipoViolencia FROM caso WHERE Resuelto = FALSE");
            while (rs.next()) {
                String cedula = rs.getString("Cedula");
                String tipo = rs.getString("TipoViolencia");
                textArea.append("Cédula: " + cedula + " - Tipo de violencia: " + tipo + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(40, 40, 400, 250);
        conte.add(scroll);

        JLabel lblCedula = new JLabel("Ingrese la cédula del caso:");
        lblCedula.setBounds(45, 300, 200, 30);
        conte.add(lblCedula);

        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(40, 330, 200, 30);
        txtCedula.setToolTipText("Ingrese la cédula del caso que desea resolver");
        conte.add(txtCedula);

 textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textoSeleccionado = textArea.getSelectedText();
                if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
                    txtCedula.setText(textoSeleccionado);
                }
            }
        });
  txtCedula.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        String texto = txtCedula.getText().trim();

        if (texto.isEmpty()) {
            if (texto.isEmpty()) {
          try {
          
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM caso");
            textArea.setText("");
            while (rs1.next()) {
                textArea.append("Cedula: " + rs1.getString("Cedula") + " - Tipo de violencia: " + rs1.getString("TipoViolencia") + "\n");
            }
     
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            return;
        }
        }

        try {
            // Usa LIKE para filtrar desde SQL
            String query = "SELECT * FROM caso WHERE Cedula LIKE '" + texto + "%'";
            ResultSet rs2 = stmt.executeQuery(query);
            textArea.setText(""); 

            while (rs2.next()) {
                String cedula = rs2.getString("Cedula");
                textArea.append("Cedula: "+cedula +" - Tipo de violencia: "+ rs2.getString("TipoViolencia")+ "\n"); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});



        JButton btnResolver = new JButton("Resolver");
        btnResolver.setBounds(260, 330, 100, 30);
        ImageIcon icon = new ImageIcon("Iconos/resolviendo-el-problema.png");
        btnResolver.setIcon(icon);
        conte.add(btnResolver);

        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedulaInput = txtCedula.getText().trim();
                boolean encontrado = false;

                try {
                    // Verificar si el caso existe en la base de datos
                    ResultSet rs = stmt.executeQuery("SELECT * FROM caso WHERE Cedula = '" + cedulaInput + "'");
                    if (rs.next()) {
                        encontrado = true;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                if (encontrado) {
                    // Si el caso existe, se cierra el frame y llamamos al método seguimientodeCaso
                    frame.dispose();
                    seguimientodeCaso(cedulaInput, stmt);
                } else {
                    JOptionPane.showMessageDialog(null, "Caso no encontrado");
                    txtCedula.setText("");
                }
            }
        });
        btnResolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnResolver.setBounds(260, 330, 100, 40);
            }

            public void mouseExited(MouseEvent e) {
                btnResolver.setBounds(260, 330, 100, 30);
            }
        });
        frame.setSize(500, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Fin de metodo utilizado para solicitar la cedula de un caso y poder darle una solucion.
    //Metodo utilizado para darle seguimiento a un caso, solicitando la informacion del funcionario y de la oficina regional.
    public void seguimientodeCaso(String cedulaCaso, Statement stmt) {
        JFrame frame = new JFrame("Seguimiento de Caso");
        Container conte = frame.getContentPane();
        conte.setLayout(null);

        JLabel l1 = new JLabel("Informacion de funcionario");
        l1.setBounds(20, 30, 200, 30);
        conte.add(l1);

        JLabel l2 = new JLabel("Nombre del funcionario: *");
        l2.setBounds(20, 70, 200, 30);
        conte.add(l2);
        JTextField t1 = new JTextField();
        t1.setBounds(20, 100, 200, 30);
        t1.setToolTipText("Ingrese el nombre del funcionario que esta atendiendo el caso");
        conte.add(t1);

        JLabel l3 = new JLabel("Cedula de funcionario: *");
        l3.setBounds(20, 150, 200, 30);
        conte.add(l3);
        JTextField t2 = new JTextField();
        t2.setBounds(20, 180, 200, 30);
        t2.setToolTipText("Ingrese la cedula del funcionario que esta atendiendo el caso");
        conte.add(t2);

        JLabel l4 = new JLabel("Codigo de funcionario: *");
        l4.setBounds(20, 220, 200, 30);
        conte.add(l4);
        JTextField t3 = new JTextField();
        t3.setBounds(20, 250, 200, 30);
        t3.setToolTipText("Ingrese el codigo del funcionario que esta atendiendo el caso");
        conte.add(t3);

        JLabel l5 = new JLabel("Solución propuesta: *");
        l5.setBounds(20, 290, 200, 30);
        conte.add(l5);
        JTextArea t4 = new JTextArea();
        t4.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(t4);
        scroll.setBounds(20, 320, 200, 100);
        t4.setToolTipText("Ingrese la solucion propuesta para el caso");
        conte.add(scroll);

        JButton grdr = new JButton("Guardar");
        grdr.setBounds(30, 440, 100, 30);
        ImageIcon icon = new ImageIcon("Iconos/guardar-el-archivo.png");
        grdr.setIcon(icon);
        conte.add(grdr);

        JLabel l6 = new JLabel("Informacion de oficina:");
        l6.setBounds(280, 30, 200, 30);
        conte.add(l6);

        JLabel l7 = new JLabel("Lugar de la oficina: *");
        l7.setBounds(280, 70, 200, 30);
        conte.add(l7);
        JTextField t7 = new JTextField();
        t7.setBounds(280, 100, 200, 30);
        t7.setToolTipText("Ingrese el lugar de la oficina regional donde se esta atendiendo el caso");
        conte.add(t7);

        JLabel l8 = new JLabel("Telefono de la oficina: *");
        l8.setBounds(280, 150, 200, 30);
        conte.add(l8);
        JTextField t8 = new JTextField();
        t8.setBounds(280, 180, 200, 30);
        t8.setToolTipText("Ingrese el telefono de la oficina regional donde se esta atendiendo el caso");
        conte.add(t8);

        JLabel l9 = new JLabel("Dirección de la oficina: *");
        l9.setBounds(280, 220, 200, 30);
        conte.add(l9);
        JTextField t9 = new JTextField();
        t9.setBounds(280, 250, 200, 30);
        t9.setToolTipText("Ingrese la direccion de la oficina regional donde se esta atendiendo el caso");
        conte.add(t9);

        grdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validación de campos vacíos
                int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea guardar los datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    return;
                }
                if (t1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el nombre del funcionario");
                    return;
                }
                if (t2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la cedula del funcionario");
                    return;
                }
                if (t2.getText().matches("[0-9]+") == false) {
                    JOptionPane.showMessageDialog(frame, "La cedula del funcionario debe contener solo numeros");
                    return;
                }
                if (t3.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el codigo del funcionario");
                    return;
                }
                if (t4.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la solucion propuesta");
                    return;
                }
                if (t7.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el lugar de la oficina");
                    return;
                }
                if (t8.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar el telefono de la oficina");
                    return;
                }
                if (!t8.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(frame, "El telefono de la oficina debe contener solo numeros");
                    return;
                }
                if (t9.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Debe ingresar la direccion de la oficina");
                    return;
                }
                // Si todos los campos están completos, se procede a guardar el seguimiento en la base de datos
                try {
                            // Validación de campos vacíos
                            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto1?verifyServerCertificate=false&useSSL=true", "root", "cRojas34");
                    Statement stmt = cn.createStatement();
                            
                            String sql = "INSERT INTO oficinaregional (IDempleado, Lugar, Direccion, Telefono, Nombre, Cedula, CedulaCaso, HoraAtencion, FechaAtencion, Solucion) VALUES ('" +
                                    t3.getText() + "', '" + t7.getText() + "', '" + t9.getText() + "', '" + t8.getText() + "', '" +
                                    t1.getText() + "', '" + t2.getText() + "', '" + cedulaCaso + "', '" + obtenerHora() + "', '" +
                                    obtenerFecha() + "', '" + t4.getText() + "')";
                            // Ejecutar la inserción en la base de datos
                            stmt.executeUpdate(sql);
                            // Actualizar el caso como resuelto
                            stmt.executeUpdate("UPDATE caso SET Resuelto = TRUE WHERE Cedula = '" + cedulaCaso + "'");
                    
                            JOptionPane.showMessageDialog(null, "Seguimiento guardado correctamente.");
                    frame.dispose();
                
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
                        }
                    }
                });
        grdr.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        grdr.setBounds(30, 440, 100, 40);
                    }
            public void mouseExited(MouseEvent e) {
                        grdr.setBounds(30, 440, 100, 30);
                    }
                });
                frame.setSize(520, 550);
                frame.setLocationRelativeTo(null);
        frame.setVisible(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
            }
        }
                                     
                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                                                                                                                                    
        
