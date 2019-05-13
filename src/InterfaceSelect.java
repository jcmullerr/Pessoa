import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfaceSelect extends TelaBase{
	String nome;
	int Id;
	ValorHumano pers;
	ArrayList <ValorHumano> pessoas;
	JTextArea txt;
	
	public InterfaceSelect() {
		super();
		
		 txt = addTextArea(15,15,650,500);
		JTextField tf = addTextField(700,15,200,30);
		JButton bt = addButton("Buscar por ID",700,50,200,40);
		JTextField tf1 =addTextField(700,100,200,30);
		JButton bt1 = addButton("Buscar por Nome",700,135,200,40);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					txt.setText("");
					Id = Integer.parseInt(tf.getText());
					pers = ValorHumanoDAO.buscaValorHumanoPorId(Id);
					txt.setText(pers.toString());
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					txt.setText("");
					JScrollBar bs = new JScrollBar();
					txt.add(bs);
					nome = tf1.getText();
					pessoas = ValorHumanoDAO.getValorHumanoComNome(nome);
					for(int i=0; i<pessoas.size(); i++) {
						//txt.setText(pessoas.get(i).toString()+"/n");
						txt.setText(txt.getText()+pessoas.get(i).toString()+"\n");
					}
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		
		
	}
	
	

}
