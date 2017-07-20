/*
 * Класс для форматирования таблицы JTable
 * Позволяет добавлять иконки в таблицу 
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
        if (value != null) {
            setBackground(Color.red);
            // setIcon(new ImageIcon("C:\\Users\\NeocortexF\\Documents\\NetBeansProjects\\Aviaescardra\\src\\images\\OK.png"));
        } else {
            setBackground(Color.blue);
            //setIcon(new ImageIcon("C:\\Users\\NeocortexF\\Documents\\NetBeansProjects\\Aviaescardra\\src\\images\\Error.png"));
        }
        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}
