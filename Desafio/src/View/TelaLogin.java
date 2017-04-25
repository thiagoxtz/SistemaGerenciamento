package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Actions.FecharTela;
import DAO.LoginDAO;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
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
	public TelaLogin() {
		setTitle("Sistema de gerenciamento de Chamados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Impact", Font.PLAIN, 24));
		lblUsuario.setBounds(79, 88, 81, 31);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(170, 88, 185, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Impact", Font.PLAIN, 24));
		lblSenha.setBounds(79, 141, 81, 26);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(170, 141, 185, 26);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnLogar = new JButton("Conectar");
		btnLogar.setForeground(new Color(105, 105, 105));
		FecharTela fecharTela = new FecharTela(this);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					LoginDAO logar = new LoginDAO();
					boolean saberResultado = logar.Logar(txtUsuario.getText(), txtSenha.getText());
					if(saberResultado == true){
						Principal principal = new Principal();
						principal.setLocationRelativeTo(null);
						principal.setVisible(true);
						fecharTela.actionPerformed(arg0);
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Não foi possivel conectar");
					}
				
			}
		});
		btnLogar.setFont(new Font("Impact", Font.PLAIN, 16));
		btnLogar.setBounds(81, 189, 94, 23);
		contentPane.add(btnLogar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(105, 105, 105));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 16));
		btnLimpar.setBounds(266, 189, 88, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblSistemaGerenciamento = new JLabel("             Sistema de Gerenciamento");
		lblSistemaGerenciamento.setBackground(new Color(0, 0, 205));
		lblSistemaGerenciamento.setForeground(Color.black);
		lblSistemaGerenciamento.setFont(new Font("Impact", Font.PLAIN, 28));
		lblSistemaGerenciamento.setForeground(new Color(248, 248, 255));
		lblSistemaGerenciamento.setBounds(0, 24, 434, 37);
		contentPane.add(lblSistemaGerenciamento);
	}
};
