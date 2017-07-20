package secure;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ImageRenderer extends DefaultTableCellRenderer {
    JLabel label = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        label.setIcon((ImageIcon) value);
        return label;
    }
}
