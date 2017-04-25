package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Actions.FecharTela;
import DAO.ChamadoDAO;
import Model.Chamado;
import TableModel.ChamadoTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaChamadosFinalizados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	@SuppressWarnings("unused")
	private FecharTela telaFechar = new FecharTela(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaChamadosFinalizados frame = new TelaChamadosFinalizados();
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
	public TelaChamadosFinalizados() {
		setTitle("Chamados Finalizados");
		setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		FecharTela fecharTela1 = new FecharTela(this); 
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fecharTela1.actionPerformed(e);
				Principal principal = new Principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblChamadosFinalizados = new JLabel("Chamados Finalizados");
		lblChamadosFinalizados.setFont(new Font("Impact", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(118)
							.addComponent(lblChamadosFinalizados))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVoltar)
						.addComponent(lblChamadosFinalizados))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		ChamadoDAO chamadoDAO = new ChamadoDAO();
		ArrayList<Chamado> listaChamados = chamadoDAO.getAllChamadosFinalizados();
		table = new JTable();
		ChamadoTableModel ctm = new ChamadoTableModel(listaChamados);
		ctm.fireTableDataChanged();
		table.setModel(ctm);
		table.revalidate();
		table.repaint();
		
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
