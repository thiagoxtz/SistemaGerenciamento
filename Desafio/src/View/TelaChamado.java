package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Actions.FecharTela;
import DAO.ChamadoDAO;
import Model.Chamado;

public class TelaChamado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextArea txtDescricao;
	private JTextArea txtNotificacoes;
	private JTextArea txtResolucao;
	private JComboBox<String> cbStatus;
	private JComboBox<String> cbTipoIncident;
	private JButton btnSalvar;
	private JLabel lblAberturaDeChamados;
	private FecharTela fecharTela = new FecharTela(this);
	
	
	public void preencherInputs(Chamado chamadoSelecionado) {
		lblAberturaDeChamados.setText("RESOLVER CHAMADO");
 		txtNomeCliente.setText(chamadoSelecionado.getNomeCliente());
		txtDescricao.setText(chamadoSelecionado.getDescricao());
		cbTipoIncident.setSelectedItem(chamadoSelecionado.getTipoIncidente());
		txtNotificacoes.setText(chamadoSelecionado.getNotificacao());
		cbStatus.setSelectedItem(chamadoSelecionado.getStatus());
		txtResolucao.setText(chamadoSelecionado.getResolucao());
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selecionadoStatus = cbStatus.getSelectedItem().toString();
				String selecionado = cbTipoIncident.getSelectedItem().toString();
				String nomeCliente = txtNomeCliente.getText();
				String descricao = txtDescricao.getText();
				@SuppressWarnings("unused")
				ChamadoDAO chamadoDAO = new ChamadoDAO();
				if (selecionado == "Tipo de Incidente" || selecionadoStatus == "-Status- " || nomeCliente == ""
						|| descricao == "") {
					JOptionPane.showMessageDialog(null, "Campos preenchido incorretamente!");
				} else {
					ChamadoDAO chamados = new ChamadoDAO();
					chamados.updateOneChamado(txtNomeCliente.getText(), txtDescricao.getText(),
							txtNotificacoes.getText(), selecionado, txtResolucao.getText(), selecionadoStatus, chamadoSelecionado.getIdNumeroChamado());
					fecharTela.actionPerformed(e);
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaChamado frame = new TelaChamado();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaChamado() {

		setTitle("Chamado");
		setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(71, 88, 66, 25);
		contentPane.add(lblEmpresa);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(81, 118, 66, 25);
		contentPane.add(lblCliente);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(71, 154, 66, 25);
		contentPane.add(lblDescrio);

		JLabel lblNotificaoes = new JLabel("Notifica\u00E7\u00F5es:");
		lblNotificaoes.setBounds(58, 274, 79, 25);
		contentPane.add(lblNotificaoes);

		JLabel lblNewLabel = new JLabel("Group- IT (Thiago)");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNewLabel.setBounds(147, 84, 199, 25);
		contentPane.add(lblNewLabel);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(147, 120, 194, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtDescricao = new JTextArea();
		txtDescricao.setBounds(147, 154, 194, 94);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		txtNotificacoes = new JTextArea();
		txtNotificacoes.setBounds(147, 274, 194, 104);
		contentPane.add(txtNotificacoes);
		txtNotificacoes.setColumns(10);
		
		lblAberturaDeChamados = new JLabel("ABERTURA DE CHAMADOS");
		lblAberturaDeChamados.setBackground(new Color(0, 0, 255));
		lblAberturaDeChamados.setForeground(new Color(245, 255, 250));
		lblAberturaDeChamados.setFont(new Font("Impact", Font.PLAIN, 30));
		lblAberturaDeChamados.setBounds(219, 0, 300, 73);
		contentPane.add(lblAberturaDeChamados);

		JLabel lblCategoriaDeIncidente = new JLabel("Tipo de Incidente:");
		lblCategoriaDeIncidente.setBounds(405, 113, 100, 20);
		contentPane.add(lblCategoriaDeIncidente);
		cbTipoIncident = new JComboBox();
		cbTipoIncident
				.setModel(new DefaultComboBoxModel(new String[] { "Tipo de Incidente", "Alto", "medio", "Baixo" }));
		cbTipoIncident.setBounds(513, 113, 181, 20);
		contentPane.add(cbTipoIncident);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selecionadoStatus = cbStatus.getSelectedItem().toString();
				String selecionado = cbTipoIncident.getSelectedItem().toString();
				String nomeCliente = txtNomeCliente.getText();
				String descricao = txtDescricao.getText();
				
				if (selecionado == "Tipo de Incidente" || selecionadoStatus == "-Status- " || nomeCliente == ""
						|| descricao == "") {
					JOptionPane.showMessageDialog(null, "Campos preenchido incorretamente!");
				} else {
					ChamadoDAO chamados = new ChamadoDAO();
					chamados.inserirChamadosBD(txtNomeCliente.getText(), txtDescricao.getText(),
							txtNotificacoes.getText(), selecionado, txtResolucao.getText(), selecionadoStatus);
					JOptionPane.showMessageDialog(null, "Chamado Concluido com sucesso!");
					fecharTela.actionPerformed(arg0);
					Principal principal = new Principal();
					principal.setVisible(true);
					principal.setLocationRelativeTo(null);
				}
			}
		});
		btnSalvar.setBounds(25, 400, 144, 23);
		contentPane.add(btnSalvar);
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtDescricao.setText("");
				txtNotificacoes.setText("");
				txtResolucao.setText("");
			}
		});
		btnLimpar.setBounds(304, 400, 144, 23);
		contentPane.add(btnLimpar);
		JButton btnVoltar = new JButton("Voltar");
		FecharTela fecharTela1 = new FecharTela(this);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fecharTela1.actionPerformed(e);
				Principal telaPrincipal = new Principal();
				telaPrincipal.setLocationRelativeTo(null);
				telaPrincipal.setVisible(true);
			}
		});
		btnVoltar.setBounds(551, 400, 144, 23);
		contentPane.add(btnVoltar);
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"-Status- ", "-Pendente-", "-Resolvido-"}));
		cbStatus.setBounds(513, 149, 181, 20);
		contentPane.add(cbStatus);

		JLabel lblResolucao = new JLabel("Resolu\u00E7\u00E3o: ");
		lblResolucao.setBounds(430, 185, 89, 20);
		contentPane.add(lblResolucao);

		txtResolucao = new JTextArea();
		txtResolucao.setBounds(513, 183, 181, 128);
		contentPane.add(txtResolucao);
		txtResolucao.setColumns(10);

		JLabel lblSatus = new JLabel("Status:");
		lblSatus.setBounds(445, 152, 46, 14);
		contentPane.add(lblSatus);
	}
}
