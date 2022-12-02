package AirportProject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TablePanel extends JPanel {
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane sc;
    DataTablePanel datatablePanel;
    GraphPanel graphPanel;

    public TablePanel() {
        int frame_size_width = 900;               //프레임의 가로 크기
        int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
        int top_panel_height = 100;   //상단 검색 바 고정 높이
        int change_panel_height = frame_size_height - top_panel_height;   //상단 바를 제외한 바뀌는 Panel의 고정 높이
        
        String[] a = { "Country","city", "AirportCode", "AirportName", "Travel More" };
        String[][] b = {
                { "대한민국","","INC", "인천국제공함" },
                { "대한민국","","INC", "김포공항" },
        };

        model = new DefaultTableModel(b, a);

        table = new JTable(model); //

        datatablePanel = new DataTablePanel();
        
        graphPanel = new GraphPanel();

        sc = new JScrollPane(table);
        //검색 화면 표 크기 수정
        sc.setPreferredSize(new Dimension(frame_size_width,change_panel_height));
        add(sc);

        datatablePanel.setPreferredSize(new Dimension(frame_size_width,change_panel_height));
        datatablePanel.setVisible(false);
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        // 맨 마지막 줄에 행 추가

        //table은 표에 들어가는 행 나타냄
        table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
        table.getColumnModel().getColumn(4).setCellEditor(new TableCell());
    }

    @SuppressWarnings("rawtypes")

    public void JTableTravelMore() {
        sc.setVisible(false);
        add(datatablePanel);
        datatablePanel.setVisible(true);
        
        //용도 모르겠음
        graphPanel.setVisible(true);
    }

   public void deleteDatatablePanel() {
       datatablePanel.setVisible(false);
       sc.setVisible(true);
    }

    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;

        public TableCell() {
            jb = new JButton("travel More");
            jb.addActionListener(e -> {
                JTableTravelMore();
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            return jb;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            return jb;
        }
    }

    public void setDataByDropdown(String country, String airport, String continent) {

    }

    public void setDataByIATA(String airportCode) {

    }

}