package secure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class StatisticFirstOfficerPF extends JFrame {

    private Object[] events = null;

    public StatisticFirstOfficerPF() {
        initComponents();
        retrieve();
        jPanel2.revalidate();
    }

    private void retrieve() {
        String firstDate = new StatisticDBUpdater().getFirstRow();
        String lastDate = new StatisticDBUpdater().getLastRow();
        txtFirstDate.setText(firstDate);
        txtLastDate.setText(lastDate);
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        // метод для изменения размера шрифта в программе
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFirstDate = new javax.swing.JTextField();
        txtLastDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        chooserYearStart = new com.toedter.calendar.JYearChooser();
        chooserYearFinish = new com.toedter.calendar.JYearChooser();
        chooserMonthFinish = new com.toedter.calendar.JMonthChooser();
        chooserMonthStart = new com.toedter.calendar.JMonthChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bSelect = new javax.swing.JButton();
        tfEvent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: First Officer PF Statistics");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelChart.setLayout(new javax.swing.BoxLayout(panelChart, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help.png"))); // NOI18N
        jLabel1.setToolTipText("Нажмите правой кнопкой мыши по диаграмме чтобы вызвать меню настроек или сохранить диаграмму как картинку. Размер сохраняемой картинки можно менять, изменяя размер этого окна.");

        jLabel4.setText("Период записей в базе данных");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chooserMonthFinish.setDayChooser(null);
        chooserMonthFinish.setOpaque(false);

        chooserMonthStart.setOpaque(false);

        jLabel2.setText("Начальная дата выборки");

        jLabel3.setText("Конечная дата выборки");

        bSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/okey.png"))); // NOI18N
        bSelect.setText("ОК");
        bSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectActionPerformed(evt);
            }
        });

        jLabel5.setText("№ события");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfEvent)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(chooserMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chooserYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(chooserMonthFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chooserYearFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bSelect))
                                        .addComponent(jLabel3))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(chooserMonthStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(chooserYearStart, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(chooserYearFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(bSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chooserMonthFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Look and feel menu

    private void bSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectActionPerformed

        if (tfEvent.getText().length() < 4 || tfEvent.getText().length() > 5) {
            JOptionPane.showMessageDialog(null, "Введите 4 значный номер события!");
        } else {

            Object[] dataFromSQL;
            int chMonthStart = chooserMonthStart.getMonth() + 1;
            int chYearStart = chooserYearStart.getYear();
            int chMonthFinish = chooserMonthFinish.getMonth() + 1;
            int chYearFinish = chooserYearFinish.getYear();
            String startDate;
            String finishDate;

            if (chMonthStart < 10) {
                startDate = chYearStart + "-0" + chMonthStart + "-01";
            } else {
                startDate = chYearStart + "-" + chMonthStart + "-01";
            }

            if (chMonthFinish < 10) {
                finishDate = chYearFinish + "-0" + chMonthFinish + "-01";
            } else {
                finishDate = chYearFinish + "-" + chMonthFinish + "-01";
            }

            String eventNbr = tfEvent.getText();
            dataFromSQL = new StatisticDBUpdater().getDataFirstOfficerPF(startDate, finishDate, eventNbr);
            DefaultCategoryDataset barChartData = new DefaultCategoryDataset();

            String startDateForGraph = null;
            String finishDateForGraph = null;
            if (chMonthStart < 10) {
                startDateForGraph = "01.0" + chMonthStart + "." + chYearStart;
            } else {
                startDateForGraph = "01." + chMonthStart + "." + chYearStart;
            }

            if (chMonthFinish < 10) {
                finishDateForGraph = "01.0" + chMonthFinish + "." + chYearFinish;
            } else {
                finishDateForGraph = "01." + chMonthFinish + "." + chYearFinish;
            }

            if (dataFromSQL.length > 20) {
                for (int i = 0; i < 20; i = i + 2) {
                    int quantity = Integer.parseInt(dataFromSQL[i + 1].toString());
                    barChartData.setValue(quantity, "Номер события", dataFromSQL[i].toString());
                }
            } else {
                for (int i = 0; i < dataFromSQL.length; i = i + 2) {
                    int quantity = Integer.parseInt(dataFromSQL[i + 1].toString());
                    barChartData.setValue(quantity, "Номер события", dataFromSQL[i].toString());
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart("Количество событий AirFASE №" + eventNbr + " за период с " + startDateForGraph + " по " + finishDateForGraph + ". Пилотирующий: второй пилот.", "ВП", "Количество событий", barChartData, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot barChartCategory = barChart.getCategoryPlot();
            barChartCategory.setRangeGridlinePaint(Color.BLACK);

            //целочисленные значения для осей
            CategoryAxis xAxis = barChartCategory.getDomainAxis();
            NumberAxis numberAxis = (NumberAxis) barChartCategory.getRangeAxis();
            numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            // Альтернативная раскраска
            Color col10 = new Color(199, 30, 90);
            Color back = new Color(249, 239, 243);
            final CategoryItemRenderer renderer = new BarChartRenderer(
                    new Paint[]{col10, col10, col10,
                            col10, col10, col10,
                            col10, col10, col10, col10});

            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);

            barChart.getCategoryPlot().setRenderer(renderer);
            barChart.getPlot().setBackgroundPaint(back);

            ChartPanel barPanel = new ChartPanel(barChart);
            //готовим панель под прорисовку диаграммы
            panelChart.removeAll();
            panelChart.add(barPanel, BorderLayout.CENTER);
            //обновить экран
            panelChart.validate();
        }
    }//GEN-LAST:event_bSelectActionPerformed

    private void mniCommanderNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSelect;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JMonthChooser chooserMonthFinish;
    private com.toedter.calendar.JMonthChooser chooserMonthStart;
    private com.toedter.calendar.JYearChooser chooserYearFinish;
    private com.toedter.calendar.JYearChooser chooserYearStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel panelChart;
    private javax.swing.JTextField tfEvent;
    private javax.swing.JTextField txtFirstDate;
    private javax.swing.JTextField txtLastDate;
    // End of variables declaration//GEN-END:variables
}
