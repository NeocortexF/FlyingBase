package secure;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class StatisticGeneralRisk extends JFrame {

    private Object[] events = null;

    public StatisticGeneralRisk() {
        initComponents();
        retrieve();
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
        bSelect = new javax.swing.JButton();
        dateFinish = new com.toedter.calendar.JDateChooser();
        dateStart = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbAbsolute = new javax.swing.JRadioButton();
        rbRelative = new javax.swing.JRadioButton();
        txtFirstDate = new javax.swing.JTextField();
        txtLastDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: General Risk Observation");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/okey.png"))); // NOI18N
        bSelect.setText("ОК");
        bSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectActionPerformed(evt);
            }
        });

        jLabel2.setText("Начальная дата выборки");

        jLabel3.setText("Конечная дата выборки");

        panelChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelChart.setLayout(new javax.swing.BoxLayout(panelChart, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help.png"))); // NOI18N
        jLabel1.setToolTipText("Нажмите правой кнопкой мыши по диаграмме чтобы вызвать меню настроек или сохранить диаграмму как картинку. Размер сохраняемой картинки можно менять, изменяя размер этого окна.");

        buttonGroup2.add(rbAbsolute);
        rbAbsolute.setText("Абсолютные величины");

        buttonGroup2.add(rbRelative);
        rbRelative.setSelected(true);
        rbRelative.setText("Относительные  величины");

        jLabel4.setText("Период записей в базе данных");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(panelChart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                                                .addComponent(rbAbsolute)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rbRelative))
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel3))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bSelect)))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bSelect)
                                        .addComponent(dateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rbRelative)
                                                .addComponent(rbAbsolute)
                                                .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        Color greenMatrix = new Color(34, 177, 76);
        Color yellowMatrix = new Color(206, 197, 2);
        Color yellow2 = new Color(242, 231, 4);
        Color orangeMatrix = new Color(247, 75, 7);
        Color redMatrix = new Color(237, 28, 36);
        Color back = new Color(236, 249, 229);

        Date startDate = dateStart.getDate();
        Date finishDate = dateFinish.getDate();
        int[] arrayOfCalulatedRisks;

        if (startDate != null && finishDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String startDateForSQL = formatter.format(startDate);
            String finishDateForSQL = formatter.format(finishDate);

            arrayOfCalulatedRisks = new StatisticDBUpdater().getDataForEvents(startDateForSQL, finishDateForSQL);
            String startDateForGraph = DateFormat.getDateInstance().format(startDate);
            String finishDateForGraph = DateFormat.getDateInstance().format(finishDate);

            if (rbAbsolute.isSelected()) {
                DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
                barChartData.setValue(arrayOfCalulatedRisks[0], "Уровень события", "Низкий");
                barChartData.setValue(arrayOfCalulatedRisks[1], "Уровень события", "Умеренный");
                barChartData.setValue(arrayOfCalulatedRisks[2], "Уровень события", "Высокий");

                JFreeChart barChart = ChartFactory.createBarChart("Распределение событий по уровню риска за период с " + startDateForGraph + " по " + finishDateForGraph, "Уровень риска", "Количество событий", barChartData, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot barChartCategory = barChart.getCategoryPlot();
                barChartCategory.setRangeGridlinePaint(Color.BLACK);

                //Альтернативная раскраска
                final CategoryItemRenderer renderer = new BarChartRenderer(
                        new Paint[]{greenMatrix, yellowMatrix, orangeMatrix,
                                redMatrix, Color.orange, Color.cyan,
                                Color.magenta, Color.blue});

                renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
                renderer.setBaseItemLabelsVisible(true);

                barChart.getCategoryPlot().setRenderer(renderer);
                barChart.getPlot().setBackgroundPaint(Color.white);

                ChartPanel barPanel = new ChartPanel(barChart);
                //готовим панель под прорисовку диаграммы
                panelChart.removeAll();
                panelChart.add(barPanel, BorderLayout.CENTER);
                //обновить экран
                panelChart.validate();
            } else {
                DefaultPieDataset pieData = new DefaultPieDataset();
                pieData.setValue("Низкий", arrayOfCalulatedRisks[0]);
                pieData.setValue("Умеренный", arrayOfCalulatedRisks[1]);
                pieData.setValue("Высокий", arrayOfCalulatedRisks[2]);

                JFreeChart pieChart = ChartFactory.createPieChart("Распределение событий по уровню риска за период с " + startDateForGraph + " по " + finishDateForGraph, pieData, true, true, false);

                PiePlot plot = (PiePlot) pieChart.getPlot();
                plot.setSectionPaint("Низкий", greenMatrix);
                plot.setSectionPaint("Умеренный", yellow2);
                plot.setSectionPaint("Высокий", orangeMatrix);
                plot.setExplodePercent("Низкий", 0.10);
                plot.setSimpleLabels(true);

                PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                        "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
                plot.setLabelGenerator(gen);
                plot.setLabelFont(new java.awt.Font("Tahoma", 0, 11));
                plot.setLabelPaint(Color.BLACK);
                plot.setInteriorGap(0.01);
                plot.setLabelGap(0.5);

                // белая оконтовка границ пирога
                plot.setBaseSectionOutlinePaint(Color.WHITE);
                plot.setSectionOutlinesVisible(true);
                plot.setBaseSectionOutlineStroke(new BasicStroke(1.5f));

                pieChart.getPlot().setBackgroundPaint(back);

                ChartPanel barPanel = new ChartPanel(pieChart);
                //готовим панель под прорисовку диаграммы
                panelChart.removeAll();
                panelChart.add(barPanel, BorderLayout.CENTER);
                //обновить экран
                panelChart.validate();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите начальную и конечную дату периода выборки");
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
    private com.toedter.calendar.JDateChooser dateFinish;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel panelChart;
    private javax.swing.JRadioButton rbAbsolute;
    private javax.swing.JRadioButton rbRelative;
    private javax.swing.JTextField txtFirstDate;
    private javax.swing.JTextField txtLastDate;
    // End of variables declaration//GEN-END:variables
}
