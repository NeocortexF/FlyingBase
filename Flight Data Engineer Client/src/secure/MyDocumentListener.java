/*
 * Слушатель для объектов формы Swing
 * позволяет определить изенялись ли поля пользователем
 * перед закрытием документа
 */
package secure;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyDocumentListener implements DocumentListener {

    public static boolean documentChanged = false;

    public static boolean isDocumentChanged() {
        return documentChanged;
    }

    public static void setDocumentChanged(boolean documentChanged) {
        MyDocumentListener.documentChanged = documentChanged;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged = true;
    }
}
