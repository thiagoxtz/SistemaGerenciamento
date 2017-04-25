package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Actions.FecharTela;
import DAO.ChamadoDAO;
import Model.Chamado;
import TableModel.ChamadoTableModel;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		ChamadoDAO chamadoDAO = new ChamadoDAO();
		ArrayList<Chamado> listaChamados = chamadoDAO.getAllChamados();
		setTitle("Principal");
		setBackground(new Color(175, 238, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		FecharTela fecharTela = new FecharTela(this);
		JButton btnNewChamado = new JButton("NOVO CHAMADO");
		btnNewChamado.setFont(new Font("Impact", Font.PLAIN, 12));
		btnNewChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharTela.actionPerformed(arg0);
				TelaChamado telaChamado = new TelaChamado();
				telaChamado.setLocationRelativeTo(null);
				telaChamado.setVisible(true);
			}
		});

		JButton btnCadastrar = new JButton("Cadastro Funcionario");
		btnCadastrar.setFont(new Font("Impact", Font.PLAIN, 12));
		btnCadastrar.addActionListener(fecharTela);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario();
				telaCadastroFuncionario.setLocationRelativeTo(null);
				telaCadastroFuncionario.setVisible(true);
			}
		});

		JButton btnFinalizarChamado = new JButton("Finalizar chamado\r\n");
		btnFinalizarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				ChamadoDAO chamadoDAO = new ChamadoDAO();
				if (table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione um chamado: ");
				} else {
					Chamado chamadoSelecionado = listaChamados.get(table.getSelectedRow());
					fecharTela.actionPerformed(e);
					TelaChamado telaChamado = new TelaChamado();
					telaChamado.setVisible(true);
					telaChamado.setLocationRelativeTo(null);
					telaChamado.preencherInputs(chamadoSelecionado);
				}
			}
		});
		btnFinalizarChamado.setFont(new Font("Impact", Font.PLAIN, 12));

		JButton btnResolverChamado = new JButton("Chamados Resolvidos");
		btnResolverChamado.setFont(new Font("Impact", Font.PLAIN, 12));
		btnResolverChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharTela.actionPerformed(e);
				TelaChamadosFinalizados telaChamadoFinalizado = new TelaChamadosFinalizados();
				telaChamadoFinalizado.setVisible(true);
				telaChamadoFinalizado.setLocationRelativeTo(null);
			}
		});

		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharTela.actionPerformed(e);
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				telaLogin.setLocationRelativeTo(null);
			}
		});
		btnDesconectar.setFont(new Font("Impact", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(btnNewChamado, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnResolverChamado, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnFinalizarChamado, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnDesconectar, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewChamado)
								.addComponent(btnCadastrar).addComponent(btnResolverChamado)
								.addComponent(btnFinalizarChamado).addComponent(btnDesconectar))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)));

		table = new JTable();

		ChamadoTableModel ctm = new ChamadoTableModel(listaChamados);
		ctm.fireTableDataChanged();
		table.setModel(ctm);
		table.revalidate();
		table.repaint();

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
