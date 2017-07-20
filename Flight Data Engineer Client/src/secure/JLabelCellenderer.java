package secure;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

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
