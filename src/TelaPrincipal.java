import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame implements ActionListener {
	
	ArrayList<JTextField> listaTf = new ArrayList<JTextField>();
	Container container = getContentPane();
	Connection conexao;
	ValorHumano pessoa;
	ValorHumanoDAO dao;
	
	public TelaPrincipal() {
		
		setBounds(40, 40, 500, 600);
		setLayout(null);
		
		criarLabel("Nome:", 70, 50, 100, 15);
		criarLabel("Rua:", 70, 75, 100, 15);
		criarLabel("Cidade:", 70, 100, 100, 15);
		criarLabel("CEP:", 70, 125, 100, 15);
		criarLabel("CPF:", 70, 150, 100, 15);
		criarLabel("Telefone:", 70, 175, 100, 15);
		criarLabel("Email:", 70, 200, 100, 15);
		criarLabel("Data de Nascimento:", 70, 225, 150, 15);
		criarLabel("Sexo:", 70, 250, 100, 15);
		criarLabel("Escolaridade:", 70, 275, 100, 15);
		criarLabel("Formação adicional:", 70, 300, 150, 15);
		criarLabel("Áreas de Interesse:", 70, 325, 150, 15);
		criarLabel("Pretensão Salarial:", 70, 350, 150 ,15);
		
		criarTextFields();
		
		JButton b1 = criarBotao("Inserir", 140, 400, 100, 30);
		b1.addActionListener(this);
		JButton bt =criarBotao("Select",140,450,100,30);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InterfaceSelect();
				
			}
			
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		
		new TelaPrincipal();
		
	}
	
	public JLabel criarLabel(String texto, int x, int y, int w, int h) {
		
		JLabel lb = new JLabel();
		lb.setText(texto);
		lb.setBounds(x, y, w, h);
		container.add(lb);
		return lb;
		
	}
	
	public void criarTextFields() {
		
		JTextField tfNome = new JTextField();
		tfNome.setBounds(110, 50, 200, 20);
		container.add(tfNome);
		listaTf.add(tfNome);
		
		JTextField tfRua = new JTextField();
		tfRua.setBounds(100, 75, 200, 20);
		container.add(tfRua);
		listaTf.add(tfRua);
		
		JTextField tfCidade = new JTextField();
		tfCidade.setBounds(120, 100, 200, 20);
		container.add(tfCidade);
		listaTf.add(tfCidade);
		
		JTextField tfCEP = new JTextField();
		tfCEP.setBounds(100, 125, 100, 20);
		container.add(tfCEP);
		listaTf.add(tfCEP);
		
		JTextField tfCPF = new JTextField();
		tfCPF.setBounds(100, 150, 100, 20);
		container.add(tfCPF);
		listaTf.add(tfCPF);
		
		JTextField tfTelefone = new JTextField();
		tfTelefone.setBounds(125, 175, 100, 20);
		container.add(tfTelefone);
		listaTf.add(tfTelefone);
		
		JTextField tfEmail = new JTextField();
		tfEmail.setBounds(110, 200, 200, 20);
		container.add(tfEmail);
		listaTf.add(tfEmail);
		
		JTextField tfDtNascimento = new JTextField();
		tfDtNascimento.setBounds(190, 225, 70, 20);
		container.add(tfDtNascimento);
		listaTf.add(tfDtNascimento);
		
		JTextField tfSexo = new JTextField();
		tfSexo.setBounds(110, 250, 30, 20);
		container.add(tfSexo);
		listaTf.add(tfSexo);
		
		JTextField tfEscolaridade = new JTextField();
		tfEscolaridade.setBounds(150, 275, 200, 20);
		container.add(tfEscolaridade);
		listaTf.add(tfEscolaridade);
		
		JTextField tfFormAd = new JTextField();
		tfFormAd.setBounds(190, 300, 200, 20);
		container.add(tfFormAd);
		listaTf.add(tfFormAd);
		
		JTextField tfAreaInt = new JTextField();
		tfAreaInt.setBounds(190, 325, 200, 20);
		container.add(tfAreaInt);
		listaTf.add(tfAreaInt);
		
		JTextField tfPretSal = new JTextField();
		tfPretSal.setBounds(190, 350, 100, 20);
		container.add(tfPretSal);
		listaTf.add(tfPretSal);
		
	}
	
	public JButton criarBotao(String texto, int x, int y, int w, int h) {
		
		JButton bt = new JButton();
		bt.setText(texto);
		bt.setBounds(x, y, w, h);
		container.add(bt);
		return bt;
		
	}
	
	public void actionPerformed(ActionEvent f) {
		
		String nome = "", rua = "", cidade = "", cep = "", cpf = "", telefone = "", email = "", 
		dtNasc = "", sexo = "", escolaridade = "";
		String formAd = "", areaInt = "";
		double pretSal = 0;
		
		try {
			
			System.out.println("Estabeleci a conexão!");
		
		for(int i = 0; i < listaTf.size()-1; i++) {
			
			if(i == 0) {
				
				nome = listaTf.get(i).getText();
				
			}
			else {
				
				if(i == 1) {
					
					rua = listaTf.get(i).getText();
					
				}
				else {
					
					if(i == 2) {
						
						cidade = listaTf.get(i).getText();
						
					}
					else {
						
						if(i == 3) {
							
							cep = listaTf.get(i).getText();
							
						}
						else {
							
							if(i == 4) {
								
								cpf = listaTf.get(i).getText();
								
							}
							else {
								
								if(i == 5) {
									
									telefone = listaTf.get(i).getText();
									
								}
								else {
									
									if(i == 6) {
										
										email = listaTf.get(i).getText();
										
									}
									else {
										
										if(i == 7) {
											
											dtNasc = listaTf.get(i).getText();
											
										}
										else {
											
											if(i == 8) {
												
												sexo = listaTf.get(i).getText();
												
											}
											else {
												
												if(i == 9) {
													
													escolaridade = listaTf.get(i).getText();
													
												}
												else {
													
													if(i == 10) {
														
														formAd = listaTf.get(i).getText();
														
													}
													else {
														
														if(i == 11) {
															
															areaInt =(listaTf.get(i).getText());
															
														}
														else if(i==12) {
															pretSal = new Double(listaTf.get(i).getText());
															
														}
														
													}
													
												}
												
											}
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		Date data = (Date) dateFormat.parse(dtNasc);
		Timestamp t = new Timestamp(data.getTime());
		
		System.out.println("Começando a operação de insert!");
		pessoa = new ValorHumano();
		pessoa.setDsNome(nome);
		pessoa.setDsLogradouro(rua);
		pessoa.setDsCEP(cep);
		pessoa.setDsCPF(cpf);
		pessoa.setDsCidade(cidade);
		pessoa.setDsTelefone(telefone);
		pessoa.setDsEmail(email);
		pessoa.setDtNascimento(t);
		pessoa.setTpSexo(sexo);
		pessoa.setDsEscolaridade(escolaridade);
		pessoa.setFormacaoAdicional(formAd);
		pessoa.setDsAreaDeInteresse(areaInt);
		pessoa.setVlPretencaoSalarial(pretSal);
		ValorHumanoDAO.insere(pessoa);
		
		
		} catch (SQLException | IOException | ParseException e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			//cnx.liberaConexao();
			System.out.println("Encerrei a conexão!");
			
		}
		
	}
	
	
}