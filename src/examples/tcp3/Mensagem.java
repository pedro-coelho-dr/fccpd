package examples.tcp3;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mensagem implements Serializable {

	private String assunto;
	private String mensagem;	
		
	public Mensagem(String assunto, String mensagem) {
		this.assunto = assunto;
		this.mensagem = mensagem;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}