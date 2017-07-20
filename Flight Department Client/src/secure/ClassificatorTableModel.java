package secure;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClassificatorTableModel extends AbstractTableModel {

    private final List<ClassificatorEntity> classificatorList;
    private final String[] columnNames = new String[]{
            "ID", "Категория", "Пункт классификатора"
    };
    private final Class[] columnClass = new Class[]{
            Integer.class, Integer.class, String.class
    };

    public ClassificatorTableModel(List<ClassificatorEntity> classificatorList) {
        this.classificatorList = classificatorList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return classificatorList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClassificatorEntity row = classificatorList.get(rowIndex);
        if (0 == columnIndex) {
            return row.getId();
        } else if (1 == columnIndex) {
            return row.getCategory();
        } else if (2 == columnIndex) {
            return row.getClassificatorPoint();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ClassificatorEntity row = classificatorList.get(rowIndex);
        if (0 == columnIndex) {
            row.setId((Integer) aValue);
        } else if (1 == columnIndex) {
            row.setCategory((Integer) aValue);
        } else if (2 == columnIndex) {
            row.setClassificatorPoint((String) aValue);
        }
    }
}
