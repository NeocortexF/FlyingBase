/*
 * класс расширяет jlabel для отображения картинок в jtable
 */
package secure;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class JLabelCellenderer extends JLabel implements TableCellRenderer {

    public JLabelCellenderer(String path) {
        setOpaque(true);
        setBackground(Color.WHITE);
        java.net.URL imgURL = getClass().getResource(path);
        this.setIcon(new ImageIcon(imgURL));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
