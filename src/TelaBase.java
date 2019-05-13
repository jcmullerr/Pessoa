
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaBase extends JFrame {
	
	Container container = getContentPane();
	ArrayList<JTextField> listaTF = new ArrayList<JTextField>();
	
	public TelaBase() {
		
		setBounds(120, 100, 950, 600);
		setLayout(null);
		//setTitulo("Calculadora");
		
		//addLabel("Cateto Oposto:", 50, 85, 100, 15);
		//addTextField(150, 82, 100, 20);
		//addLabel("Cateto Adjacente:", 35, 112, 100, 15);
		//addTextField(150, 110, 100, 20);
		//addLabel("Hipotenusa:", 68, 140, 100, 15);
		//addTextField(150, 138, 100, 20);
		//addButton("Calcular", 100, 200, 100, 30);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public JLabel addLabel(String texto, int x, int y, int w, int h) {
		
		JLabel l = new JLabel(texto);
		l.setBounds(x, y, w, h);
		container.add(l);
		return l;
		
	}
	
	public JTextField addTextField(int x, int y, int w, int h) {
		
		JTextField tf = new JTextField();
		tf.setBounds(x, y, w, h);
		container.add(tf);
		listaTF.add(tf);
		tf.setOpaque(true);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				tf.setBackground(Color.LIGHT_GRAY);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				tf.setBackground(Color.WHITE);
				
			}
			
		});
		return tf;
		
	}
	
	public JButton addButton(String titulo, int x, int y, int w, int h) {
		
		JButton bt = new JButton(titulo);
		bt.setBounds(x, y, w, h);
		container.add(bt);
		return bt;
		
	}
public JTextArea addTextArea( int x, int y, int w, int h) {
		
		JTextArea bt = new JTextArea();
		bt.setBounds(x, y, w, h);
		container.add(bt);
		return bt;
		
	}
	
	
	public void setTitulo(String título) {
		
		Color cor = new Color(173, 255, 77);
		
		JLabel l = new JLabel(título);
		getContentPane().add(l);
		l.setBounds(0, 0, 800, 35);
		
		l.setForeground(cor);
		l.setBackground(Color.DARK_GRAY);
		l.setOpaque(true);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		
	}

	
}