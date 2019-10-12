package agenda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private static int numeroBotao; //variavel criada para ser utilizada na tela de busca, nas opções: procurar, editar, excluir.

	/**
	 * Launch the application.
	 */
	
	Agenda a = new Agenda(); //instancia da classe agenda
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 371);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); 		
				TelaCadastro tela = new TelaCadastro();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		botaoCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoCadastrar.setBounds(83, 82, 145, 23);
		contentPane.add(botaoCadastrar);
		
		JButton botaoProcurar = new JButton("Procurar");
		botaoProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				numeroBotao = 2;
				
				if(a.QuantidadeObjetos() == 0){
					JOptionPane.showMessageDialog(null, "              Lista vazia");
				}
				else{
					setVisible(false); 		
					TelaBusca tela = new TelaBusca();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
				}
			}
		});
		botaoProcurar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoProcurar.setBounds(83, 104, 145, 23);
		contentPane.add(botaoProcurar);
		
		JButton botaoListarTodos = new JButton("Listar Todos");
		botaoListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a.Mostra();
				
			}
		});
		botaoListarTodos.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoListarTodos.setBounds(83, 127, 145, 23);
		contentPane.add(botaoListarTodos);
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				numeroBotao = 4;
				
				
				if(a.QuantidadeObjetos() == 0){
					JOptionPane.showMessageDialog(null, "              Lista vazia");
				}
				else{
					setVisible(false); 		
					TelaBusca tela = new TelaBusca();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
				}
			}
		});
		botaoEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoEditar.setBounds(83, 148, 145, 23);
		contentPane.add(botaoEditar);
		
		JButton botaoResetar = new JButton("Resetar");
		botaoResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(a.QuantidadeObjetos() == 0){
					JOptionPane.showMessageDialog(null, "              Lista vazia");
				}
				else{
					JOptionPane.showMessageDialog(null, "Todos os contatos foram removidos da lista    ");
					a.Resetar();
				}
			}
		});
		botaoResetar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoResetar.setBounds(83, 171, 145, 23);
		contentPane.add(botaoResetar);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				numeroBotao = 6;
								
				if(a.QuantidadeObjetos() == 0){
					JOptionPane.showMessageDialog(null, "              Lista vazia");
				}
				else{
					setVisible(false); 		
					TelaBusca tela = new TelaBusca();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
				}
			}
		});
		botaoExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoExcluir.setBounds(83, 193, 145, 23);
		contentPane.add(botaoExcluir);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		botaoSair.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoSair.setBounds(83, 214, 145, 23);
		contentPane.add(botaoSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/agenda/fotos/redimensiona.jpg")));
		lblNewLabel.setBounds(355, 61, 178, 189);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("AGENDA ELETR\u00D4NICA");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 569, 59);
		contentPane.add(label);
		
		Label label_1 = new Label("");
		label_1.setBackground(Color.YELLOW);
		label_1.setBounds(0, 289, 579, 7);
		contentPane.add(label_1);
		
		Label label_2 = new Label("");
		label_2.setBackground(new Color(25, 25, 112));
		label_2.setBounds(0, 302, 579, 7);
		contentPane.add(label_2);
	}
	
	
	//metodo para retornar o numero do botao digitado
	//utiliado na tela de cadastro
	public int getNumero(){
		return numeroBotao;
	}
}

//ALisson Meneses
