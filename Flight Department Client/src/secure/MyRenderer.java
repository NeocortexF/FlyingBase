/*
 * Класс для форматирования таблицы JTable
 */
package secure;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            this.setBackground(table.getSelectionBackground());
            this.setForeground(table.getSelectionForeground());
        } else {
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }

        Component cellComponent = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        if (table.getValueAt(row, 11).equals(1)) {
            cellComponent.setForeground(Color.GREEN);
        } else {
            cellComponent.setForeground(table.getForeground());
        }

        if (value != null) {
            setBackground(Color.red);
        } else {
            setBackground(Color.blue);
        }

        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }

}
