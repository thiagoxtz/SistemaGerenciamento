package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FecharTela implements ActionListener{
	
	// atributo
	JFrame tela;
	//
	
	//construtor
	//JFRAME = TELA!
	public FecharTela(JFrame telaQueEuDesejo){
		this.tela = telaQueEuDesejo;
	}
	//
	
	@Override
	//Ação para fechar tela!
	public void actionPerformed(ActionEvent e) {
		
		this.tela.setVisible(false);
		this.tela.dispose();
	}

		
}
