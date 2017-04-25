package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Actions.FecharTela;
import DAO.CadastroDAO;

public class TelaCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNomeFuncionario;
	private JTextField txtFuncao;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JTextField txtSenhaAdm;
	private JComboBox<String> cbSetor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroFuncionario() {
		setTitle("Cadastro Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeFuncionario = new JLabel("Nome Funcionario:* ");
		lblNomeFuncionario.setBounds(10, 86, 124, 25);
		contentPane.add(lblNomeFuncionario);

		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o: *");
		lblFuncao.setBounds(57, 148, 77, 25);
		contentPane.add(lblFuncao);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:* ");
		lblUsurio.setBounds(57, 213, 69, 25);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:* ");
		lblSenha.setBounds(57, 249, 68, 25);
		contentPane.add(lblSenha);

		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setBounds(137, 88, 336, 20);
		contentPane.add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);

		txtFuncao = new JTextField();
		txtFuncao.setBounds(137, 150, 238, 20);
		contentPane.add(txtFuncao);
		txtFuncao.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(137, 215, 139, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(137, 246, 139, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblCadastroFunc = new JLabel("                                  Cadastro Funcionario");
		lblCadastroFunc.setBackground(new Color(248, 248, 255));
		lblCadastroFunc.setFont(new Font("Impact", Font.PLAIN, 24));
		lblCadastroFunc.setBounds(0, 0, 489, 90);
		contentPane.add(lblCadastroFunc);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
			}
		});

		FecharTela fecharTela = new FecharTela(this);
		btnVoltar.addActionListener(fecharTela);
		btnVoltar.setBounds(357, 300, 106, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtNomeFuncionario.setText("");
				txtFuncao.setText("");
				txtSenhaAdm.setText("");
				txtUsuario.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setBounds(212, 300, 101, 23);
		contentPane.add(btnLimpar);

		JButton btnCadastrar = new JButton("Cadastrar");
		FecharTela fecharTela1 = new FecharTela(this);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senhaAdm = txtSenhaAdm.getText();
				String selecionarSetor = cbSetor.getSelectedItem().toString();
				String nomeFuncionario = txtNomeFuncionario.getText();
				String funcao = txtFuncao.getText();
				String usuario =  txtUsuario.getText();
				String senha = txtSenha.getText();
				
				if (senhaAdm.equals("thiago99")) {
					CadastroDAO cadastro = new CadastroDAO();
					if (nomeFuncionario != "" && (funcao != "") && (usuario != "") && (senha != "") ) {
						if (cadastro.compararLogin(txtUsuario.getText()) == false) {
							cadastro.inserirLogin(txtNomeFuncionario.getText(), txtFuncao.getText(),
									txtUsuario.getText(), txtSenha.getText(), selecionarSetor);
							JOptionPane.showMessageDialog(null, "Cadastro com Sucesso");
							fecharTela1.actionPerformed(arg0);
							Principal telaprincipal = new Principal();
							telaprincipal.setVisible(true);
							telaprincipal.setLocationRelativeTo(null);
						} else {
							JOptionPane.showMessageDialog(null, "Este usuario já existe! ");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senha adminstrador incorreta! ");
					}
					
				}else{
				JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente! ");
				}}
		});
		btnCadastrar.setBounds(43, 300, 106, 23);
		contentPane.add(btnCadastrar);

		JLabel lblSenhaAdminstrador = new JLabel("Senha administrador:");
		lblSenhaAdminstrador.setBounds(11, 181, 123, 21);
		contentPane.add(lblSenhaAdminstrador);

		txtSenhaAdm = new JPasswordField();
		txtSenhaAdm.setBounds(137, 181, 139, 20);
		contentPane.add(txtSenhaAdm);
		txtSenhaAdm.setColumns(10);

		JLabel lblSetor = new JLabel("Setor:* ");
		lblSetor.setBounds(67, 120, 59, 17);
		contentPane.add(lblSetor);

		cbSetor = new JComboBox();
		cbSetor.setModel(new DefaultComboBoxModel(new String[] { "Selecione um Setor:", "-TELECOM-",
				"-AUTOMA\u00C7\u00C3O-", "-OTG-", "-SERVICE/DESK-", "-DEVELOPER-" }));
		cbSetor.setBounds(137, 119, 139, 20);
		contentPane.add(cbSetor);
	}
}
