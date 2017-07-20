/*
 * Класс для форматирования таблицы JTable
 * Позволяет раскрашивать колонки в таблице по условию
 */
package secure;

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

        if (value != null) {
            setBackground(Color.red);
        } else {
            setBackground(Color.blue);
        }

        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}
