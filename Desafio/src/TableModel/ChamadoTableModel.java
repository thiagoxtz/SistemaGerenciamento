package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Chamado;

public class ChamadoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3643381601000264927L;

	private List<Chamado> chamados;

	private String[] colunas = new String[] { "Numero Chamado:", "Empresa", "Cliente", "Descri\u00E7\u00E3o",
			"Status Chamado" };
	@SuppressWarnings("rawtypes")
	Class[] rows = { int.class, String.class, String.class, String.class, String.class };

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return rows[columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public ChamadoTableModel(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	@Override
	public int getColumnCount() {
		return rows.length;
	}

	@Override
	public int getRowCount() {
		return chamados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Chamado chamado = chamados.get(linha);
		switch (coluna) {
		case 0:
			return chamado.getIdNumeroChamado();
		case 1:
			return "Group-IT(THIAGO)";
		case 2:
			return chamado.getNomeCliente();
		case 3:
			return chamado.getDescricao();
		case 4:
			return chamado.getStatus();
		default:
			return false;
		}
	}
}