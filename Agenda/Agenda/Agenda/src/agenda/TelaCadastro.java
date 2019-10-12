package agenda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField TextoNome;
	private JTextField TextoTelefone;
	private JTextField TextoEmail;
	private String nome, telefone, email;

	/**
	 * Launch the application.
	 */
	
	Agenda a = new Agenda(); //instancia da classe agenda
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setLocationRelativeTo(null); //mostra aplicação no centro da tela
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextoNome = new JTextField();
		TextoNome.setFont(new Font("Arial", Font.PLAIN, 13));
		TextoNome.setBounds(46, 76, 424, 27);
		contentPane.add(TextoNome);
		TextoNome.setColumns(10);
		
		TextoTelefone = new JTextField();
		TextoTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		TextoTelefone.setColumns(10);
		TextoTelefone.setBounds(46, 137, 424, 27);
		contentPane.add(TextoTelefone);
		
		TextoEmail = new JTextField();
		TextoEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		TextoEmail.setColumns(10);
		TextoEmail.setBounds(46, 198, 424, 27);
		contentPane.add(TextoEmail);
		
		Label labelNome = new Label("Nome Completo: ");
		labelNome.setFont(new Font("Arial", Font.PLAIN, 14));
		labelNome.setBounds(46, 48, 106, 22);
		contentPane.add(labelNome);
		
		Label labelTelefone = new Label("Telefone:");
		labelTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		labelTelefone.setBounds(46, 109, 113, 22);
		contentPane.add(labelTelefone);
		
		Label labelEmail = new Label("E-mail: ");
		labelEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		labelEmail.setBounds(46, 170, 62, 22);
		contentPane.add(labelEmail);
		
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				nome = TextoNome.getText();
				telefone = TextoTelefone.getText();
				email = TextoEmail.getText();
				
				TelaPrincipal principal = new TelaPrincipal();
				//teste para cadastro do usuario
				TelaBusca t = new TelaBusca();
				if(principal.getNumero() == 4){  //4 botao editar
					if(nome.equals("") || (telefone.equals("") || (email.equals("")))){
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");	
					}
					else if(a.verificaNome(nome)){ 
						JOptionPane.showMessageDialog(null, "           Nome invalido");
						
						TextoNome.setText(""); //comando para limpar o JTextField.
					}
					else if(a.verificaTelefone(telefone)){ 
						JOptionPane.showMessageDialog(null, "           Telefone invalido");
						
						TextoTelefone.setText(""); //comando para limpar o JTextField.
					}
					else if(a.verificaEmail(email)){ 
						JOptionPane.showMessageDialog(null, "           Email invalido");
						
						TextoEmail.setText(""); //comando para limpar o JTextField.
					}
					else{
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso        ");
						 
						a.setNome(nome);
						a.setTelefone(telefone);
						a.setEmail(email);
						a.EditaContato(a.getVereifica(), a);
						a.ZeraVerifica();
						
						setVisible(false); 
						TelaPrincipal tela = new TelaPrincipal();
						tela.setLocationRelativeTo(null);
						tela.setVisible(true);
						
						}
				}
				else{
						
						if(nome.equals("") || (telefone.equals("") || (email.equals("")))){
							JOptionPane.showMessageDialog(null, "Preencha todos os campos");	
						}
						else if(a.verificaNome(nome)){ 
							JOptionPane.showMessageDialog(null, "           Nome invalido");
								
							TextoNome.setText(""); //comando para limpar o JTextField.
						}
						else if(a.verificaTelefone(telefone)){ 
							JOptionPane.showMessageDialog(null, "           Telefone invalido");
								
							TextoTelefone.setText(""); //comando para limpar o JTextField.
						}
						else if(a.verificaEmail(email)){ 
							JOptionPane.showMessageDialog(null, "           Email invalido");
								
							TextoEmail.setText(""); //comando para limpar o JTextField.
						}
						else{
							JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso        ");
					
							a.setNome(nome);
							a.setTelefone(telefone);
							a.setEmail(email);
							a.AdicionarItem(a);
							setVisible(false); 
							TelaPrincipal tela = new TelaPrincipal();
							tela.setLocationRelativeTo(null);
							tela.setVisible(true);
						}
					}
				}
		});
		botaoSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoSalvar.setBounds(158, 256, 113, 23);
		contentPane.add(botaoSalvar);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaPrincipal tela = new TelaPrincipal();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				setVisible(false);
			}
		});
		botaoCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoCancelar.setBounds(281, 256, 106, 23);
		contentPane.add(botaoCancelar);
		
		Label label_3 = new Label("TELA DE CADASTRO");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Arial", Font.BOLD, 20));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(0, 0, 575, 42);
		contentPane.add(label_3);
		
		Label label = new Label("");
		label.setBackground(new Color(25, 25, 112));
		label.setBounds(0, 308, 585, 7);
		contentPane.add(label);
		
		Label label_1 = new Label("");
		label_1.setBackground(Color.YELLOW);
		label_1.setBounds(0, 295, 585, 7);
		contentPane.add(label_1);
	}
}

//ALisson Meneses
