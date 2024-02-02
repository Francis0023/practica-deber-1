//import javax.swing.*;
//
//// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
//// then press Enter. You can now see whitespace characters in your code.
//public class Main {
//    public static void main(String[] args) {
//        JFrame pantalla = new JFrame("Pantalla Prueba");
//        pantalla.setContentPane(new form1().panel1);
//        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pantalla.pack();
//        pantalla.setVisible(true);
//        pantalla.setSize(700,450);
//
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.pack();
////        frame.setSize(700, 450);
////        frame.setVisible(true);
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSwing extends JFrame {
    private JTextField nombreTextField;
    private JComboBox<String> generoComboBox;
    private JCheckBox recibirCorreoCheckBox;

    public FormularioSwing() {
        // Configuración del JFrame
        setTitle("Formulario de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField(15);

        JLabel generoLabel = new JLabel("Género:");
        String[] opcionesGenero = {"Masculino", "Femenino", "Otro"};
        generoComboBox = new JComboBox<>(opcionesGenero);

        recibirCorreoCheckBox = new JCheckBox("Recibir actualizaciones por correo electrónico");

        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(nombreLabel);
        panel.add(nombreTextField);
        panel.add(generoLabel);
        panel.add(generoComboBox);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(recibirCorreoCheckBox);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(enviarButton);

        // Agregar panel al JFrame
        add(panel);

        // Mostrar el JFrame
        setVisible(true);
    }

    private void enviarDatos() {
        String nombre = nombreTextField.getText();
        String genero = (String) generoComboBox.getSelectedItem();
        boolean recibirCorreo = recibirCorreoCheckBox.isSelected();

        String mensaje = "Nombre: " + nombre + "\nGénero: " + genero + "\nRecibir Correo: " + (recibirCorreo ? "Sí" : "No");

        JOptionPane.showMessageDialog(this, mensaje, "Información del Usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioSwing();
            }
        });
    }
}
