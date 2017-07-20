// рендеринг цвета риска
package secure;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRendererAE extends DefaultTableCellRenderer {

    private static final int COLORED_COLUMN_RISK = 13;
    private static final int COLORED_COLUMN_ASSESSMENT = 14;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);

        if (table.getValueAt(row, COLORED_COLUMN_RISK) == null || table.getValueAt(row, COLORED_COLUMN_RISK) == "" || table.getValueAt(row, COLORED_COLUMN_RISK) == " ") {
            c.setFont(new Font("Arial", Font.BOLD, 14));
        }

        if (table.getValueAt(row, COLORED_COLUMN_ASSESSMENT) == null || table.getValueAt(row, COLORED_COLUMN_ASSESSMENT) == "" || table.getValueAt(row, COLORED_COLUMN_ASSESSMENT) == " ") {
            c.setFont(new Font("Arial", Font.BOLD, 14));
        }

        return c;
    }
}
