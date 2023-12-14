import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen {

    private JFrame frame;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginScreen window = new LoginScreen();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginScreen() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(100, 70, 100, 25);
        frame.getContentPane().add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 70, 150, 25);
        frame.getContentPane().add(userField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 110, 100, 25);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 110, 150, 25);
        frame.getContentPane().add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener((ActionEvent e) -> {
            String user = userField.getText();
            String password = new String(passwordField.getPassword());
            if (isUserValid(user) && isPasswordValid(password)) {
                JOptionPane.showMessageDialog(frame, "Acceso exitoso");
                // Mostrar el menú del sistema aquí
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecta");
            }
        });
        loginButton.setBounds(200, 150, 100, 25);
        frame.getContentPane().add(loginButton);
    }

    private boolean isUserValid(String user) {
        // Verificar si el usuario es válido.
        // Aquí puedes realizar consultas a la base de datos, por ejemplo.
        return user.equals("admin");
    }

    private boolean isPasswordValid(String password) {
        // Verificar si la contraseña es válida.
        // Aquí puedes realizar consultas a la base de datos, por ejemplo.
        return password.equals("1234");
    }
}