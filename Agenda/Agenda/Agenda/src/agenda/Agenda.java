package agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Agenda {
	private String nome;
	private String telefone;
	private String email;
	private static ArrayList<Agenda> lista = new ArrayList<>(); //array criado para armazenar todos os contatos
	private static int vCont;
	
	
	
	//construtor de agenda
	public Agenda(){
		
	}
	
	
	
	//utilizado na tela de cadastro
	//para inserir o novo contato
	public void EditaContato(int num, Agenda agenda){
		lista.set(num, agenda);
	}
	
		
	
	//metodo para armazenar os dados do usuario na coleção
	//utilizado na tela de adastro
	 public  void AdicionarItem(Agenda objeto){
	        lista.add(objeto);
	 }
	 
	 
	 
	 //metodo que mostra a quantidade de objetos criados, 
	 //utiizado na tela principal
	 public int QuantidadeObjetos(){
		 return lista.size();
	 }
	 
	 
	 
	 //metodo utilizado na tela de cadastro
	 //para verificar o nome
	 public boolean verificaNome(String nome){
		 boolean teste = false;
		 for(Agenda agenda: lista){
			 if(agenda.getNome()!= null && agenda.getNome().equals(nome)){
				 teste = true;
				 break;
			 }			 
		 }
		return teste;
	 }
	 
	 
	 //metodo utilizado na tela de cadastro
	 //para verificar o telefone
	 public boolean verificaTelefone(String nome){
		 boolean teste = false;
		 for(Agenda agenda: lista){
			 if(agenda.getTelefone()!= null && agenda.getTelefone().equals(nome)){
				 teste = true;
				 break;
			 }			 
		 }
		return teste;
	 }
	 
	 
	 //metodo utilizado na tela de cadastro
	 //para verificar o e-mail
	 public boolean verificaEmail(String nome){
		 boolean teste = false;
		 for(Agenda agenda: lista){
			 if(agenda.getEmail()!= null && agenda.getEmail().equals(nome)){
				 teste = true;
				 break;
			 }			 
		 }
		return teste;
	 }
	 
	 
	 //metodo que mostra os dados do usuario informado
	 //utizado na tela de busca
	 public  void Procura(String nome){		
		 for(Agenda agenda: lista){
			 if(agenda.getNome()!= null && agenda.getNome().equals(nome)){
				 JOptionPane.showMessageDialog(null, agenda.toString());
				 break;
			 }
		 }
	 }	 
	 
	 
	 
	 
	 
	//metodo utilizado na tela de busca
		public int VereificaEditar(String nome){
			int cont = 0;	//variavel criada para saber a posição exata do contato, para que a edição seja bem sucedida
			 for(Agenda agenda: lista){
				 if(agenda.getNome()!= null && agenda.getNome().equals(nome)){
					 break;
				 }
				 else{
					 vCont++;
				 }
			 }
			 return vCont;
		}
		
		
		//metodo para retornar o valor do contador
		//utilizado na tea de cadastro
		public int getVereifica(){
			return vCont;
		}
		
		
		//metodo para zerar o contador
		//utilizado na tela de cadastro
		public void ZeraVerifica(){
			this.vCont = 0;
		} 
	 
	 
	 //metodo para excluir o contato
	 //utilizado na tela de busca
	 public void Excluir(String nome){
		 
		 int cont = 0;	//variavel criada para saber a posição exata do contato, para que a exclusão seja bem sucedida
		 for(Agenda agenda: lista){
			 Agenda a = new Agenda();
			 if(agenda.getNome()!= null && agenda.getNome().equals(nome)){
				 lista.remove(lista.get(cont));
				 JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso      ");
				 break;
			 }
			 else{
				 cont++;
			 }
		 }
	 }
	 
	  
	 
	 
	 //metodo para mostra todos os contatos armazenados
	 //utilizado na tela principal
	 public  void Mostra(){
		 if(lista.size() != 0){
			 Iterator<Agenda> it;
			 it = lista.iterator();
			 while(it.hasNext()){
				 System.out.println(it.next());
			 }
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "              Lista vazia");
		}
	 }
	 
	 
	 
	 
	 //metodo para remover todos os contatos da lista
	 //utilizado na tela principal
	 public void Resetar(){
		 lista.clear();
	 }

	public  String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getTelefone() {
		return telefone;
	}
	

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString(){
		return "Nome: " + this.nome.toUpperCase() + "\nTelefone: " + this.telefone.toUpperCase() + "\nE-mail: " + this.email.toUpperCase() + "\n";
	}	
	
}

//ALisson Meneses
