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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaBusca extends JFrame {

	private JPanel contentPane;
	private JTextField TextoNome;
	private String nome; //armazena o valor que o usuario digitou
	

	/**
	 * Launch the application.
	 */
	
	
	Agenda a = new Agenda(); //instancia da classe agenda
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBusca frame = new TelaBusca();
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
	public TelaBusca() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 371);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextoNome = new JTextField();
		TextoNome.setFont(new Font("Arial", Font.PLAIN, 13));
		TextoNome.setBounds(35, 99, 442, 27);
		contentPane.add(TextoNome);
		TextoNome.setColumns(10);
		
		Label label = new Label("Nome Completo: ");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(35, 71, 111, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("TELA DE BUSCA");
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(0, 0, 573, 43);
		contentPane.add(label_1);
		
		Label label_2 = new Label("");
		label_2.setBackground(Color.YELLOW);
		label_2.setBounds(0, 289, 583, 8);
		contentPane.add(label_2);
		
		Label label_3 = new Label("");
		label_3.setBackground(new Color(25, 25, 112));
		label_3.setBounds(0, 303, 583, 8);
		contentPane.add(label_3);
		
		JButton botaoOk = new JButton("Ok");
		botaoOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nome = TextoNome.getText();
				
				if(nome.equals("")){
					JOptionPane.showMessageDialog(null, "       Preencha o campo");	
				}
				else if(!a.verificaNome(nome)){
					JOptionPane.showMessageDialog(null, "           Nome invalido");
					
					TextoNome.setText(""); //comando para limpar o JTextField.
				}
				else{					
					TelaPrincipal tela = new TelaPrincipal();
					tela.setLocationRelativeTo(null);
					
										
					/*logo abaixo testes com o numero do botao;
					 * 
					 * 2 = procurar
					 * 4 = editar
					 * 6 = excluir
					 * 
					*/
					
					int numero = tela.getNumero(); //chama o metodo que contem o valor do botao
					
					if(numero == 2){
						a.Procura(nome);
						setVisible(false); //deixa a tela atual invisivel
						tela.setVisible(true); //chama a nova tela criada
					}
					else if(numero == 4){
						a.VereificaEditar(nome);
						setVisible(false); 		
						TelaCadastro tela1 = new TelaCadastro();
						tela1.setLocationRelativeTo(null);
						tela1.setVisible(true);
					}
					else if(numero == 6){
						a.Excluir(nome);
						setVisible(false); //deixa a tela atual invisivel
						tela.setVisible(true); //chama a nova tela criada
					}
					
					
				}
			}
		});
		botaoOk.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoOk.setBounds(149, 247, 133, 23);
		contentPane.add(botaoOk);
		
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
		botaoCancelar.setBounds(292, 247, 121, 23);
		contentPane.add(botaoCancelar);
	}
	
}


//ALisson Meneses
