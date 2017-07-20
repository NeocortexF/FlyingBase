// рендеринг цвета риска для 11 колонки (финальный риск) в welcome Jtable1
package secure;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorRenderer extends DefaultTableCellRenderer {

    private static final int IMPORTANT_COLUMN = 11;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);

        Color greenMatrix = new Color(34, 177, 76);
        Color yellowMatrix = new Color(255, 242, 0);
        Color orangeMatrix = new Color(255, 127, 39);
        Color redMatrix = new Color(237, 28, 36);

        if (table.getValueAt(row, IMPORTANT_COLUMN) != null) {
            String riskValue = table.getValueAt(row, IMPORTANT_COLUMN).toString();
            int risk = Integer.parseInt(riskValue);
            if (risk == 0) {
                c.setBackground(new Color(220, 220, 220));
                c.setForeground(Color.BLACK);
                c.setFont(new Font("Consolas", Font.BOLD, 14));
            } else if (risk <= 19) {
                c.setBackground(greenMatrix);
                c.setForeground(Color.BLACK);
                c.setFont(new Font("Arial", Font.BOLD, 14));
            } else if (risk > 19 && risk <= 99) {
                c.setBackground(yellowMatrix);
                c.setForeground(Color.BLACK);
                c.setFont(new Font("Arial", Font.BOLD, 14));
            } else if (risk >= 100 && risk < 104) {
                c.setBackground(orangeMatrix);
                c.setForeground(Color.BLACK);
                c.setFont(new Font("Arial", Font.BOLD, 14));
            } else if (risk >= 105) {
                c.setBackground(redMatrix);
                c.setForeground(Color.WHITE);
                c.setFont(new Font("Arial", Font.BOLD, 14));
            } else {
                c.setBackground(null);
                c.setForeground(Color.BLACK);
                c.setFont(new Font("Arial", Font.PLAIN, 14));
            }
        } else {
            c.setBackground(null);
            c.setForeground(Color.BLACK);
            c.setFont(new Font("Arial", Font.PLAIN, 14));
        }


        return c;
    }
}
