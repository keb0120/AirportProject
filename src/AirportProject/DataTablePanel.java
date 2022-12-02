package AirportProject;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class DataTablePanel extends JPanel {
    JTable dataTable;
    JLabel text;

    String[] header = { "Country", "Airport Code", "Airport Name" };
    String[][] data = {
            { "대한민국", "INC", "인천국제공함" },
            { "대한민국", "INC", "김포공항", },
    };

    public DataTablePanel() {
    	int frame_size_width = 900;               //프레임의 가로 크기
        int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
        int top_panel_height = 100;   //상단 검색 바 고정 높이
        int change_panel_height = frame_size_height - top_panel_height;   //상단 바를 제외한 바뀌는 Panel의 고정 높이
        
        this.setLayout(null);
        dataTable = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        
        //Travel More 화면에서 표 크기 설정
        scrollPane.setBounds(0,60,frame_size_width,change_panel_height-30);
        JLabel text = new JLabel();
        JLabel text2 = new JLabel();
        
        //Travel More 상단 설명 text에 쓸 폰트 설정, 폰트 종류는 Dialog로 기본에서 변경하지X
        Font myFont1 = new Font("Dialog", Font.BOLD, 18);
        
        text.setFont(myFont1);
        text.setBounds(10, 0, 500, 30);
        text.setText("더 여행 하고 싶은 곳이 있으신가요?");
        
        //설명 text 추가
        text2.setFont(myFont1);
        text2.setBounds(10, 30, 500, 30);
        text2.setText("선택하신 공항에서 갈 수 있는 주변 공항을 알려드릴게요");
        
        this.add(text);
        this.add(text2);
        this.add(scrollPane);
        this.setVisible(true);
    }
}