package LAF;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LookAndFeel {
	
	private JFrame ventana;
	private String laf, titulo;
	private JTextField user;
	private JPasswordField pass;
	
	public LookAndFeel(String titulo, String laf) {
		this.laf = laf;
		this.titulo = titulo;
		try {
			UIManager.setLookAndFeel(this.laf);
		} catch (Exception e) {
			System.err.println("Error aplicando el LAF: " + e);
		}
		ventana = new JFrame();
        ventana.setSize(450, 350);
        ventana.setTitle(this.titulo);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

        Container panel = ventana.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JLabel("Usuario:"));
        user = new JTextField();
        panel.add(user);
        panel.add(new JLabel("Contraseña:"));
        pass = new JPasswordField();
        panel.add(pass);
        JCheckBox recordar = new JCheckBox("Recordar inicio de sesión.");
        panel.add(recordar);
        panel.add(new JLabel("Selecciona tu rol:"));
        JComboBox<String> rol = new JComboBox<>(new String[] {"Usuario", "Administrador", "Invitado"});
        panel.add(rol);
        panel.add(new JLabel("Comentarios:"));
        JTextArea comentarios = new JTextArea(3, 20);
        comentarios.setLineWrap(true);
        comentarios.setWrapStyleWord(true);
        panel.add(new JScrollPane(comentarios));
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton()==1) {
					iniciarSesion();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

        });
        	
        panel.add(loginButton);

        ventana.pack();
        ventana.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	private void iniciarSesion() {
		String nombre = user.getText();
		String passW = pass.getText();
		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre está vacío.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
		} else {
			if (passW.isEmpty()) {
				JOptionPane.showMessageDialog(null, "La contraseña está vacía.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "¡Bienvenido!", "Sesión iniciada.", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new LookAndFeel("Flat Dark Laf", "com.formdev.flatlaf.FlatDarkLaf");
		new LookAndFeel("Flat Ligth Laf", "com.formdev.flatlaf.FlatLightLaf");
		new LookAndFeel("Default de Java", UIManager.getCrossPlatformLookAndFeelClassName());
		
		// Estos temas solo se mostrarán correctamente en IntelliJ, debido a que el IDE soporta el uso de ficheros .json
		// externos para personalizar la interfaz. Parece ser que en eclipse se interpretan igual que los temas por 
		// defecto pese a haber alguna diferencia, como los JCheckBox y JRadioButton
		new LookAndFeel("Flat IntelliJ Laf", "com.formdev.flatlaf.FlatIntelliJLaf");
		
		// Y estos de aquí dan error, puesto que son para Mac
		new LookAndFeel("Flat Mac Light", "com.formdev.flatlaf.FlatMacLight");
		new LookAndFeel("Flat Mac Dark", "com.formdev.flatlaf.FlatMacDark");		
	}
}
