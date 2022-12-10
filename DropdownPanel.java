package AirportProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DropdownPanel extends JPanel {

    JComboBox<String> country, continent, airport;
    JButton dropdownBtn;
    DBTest dbtest = new DBTest();
    
    public DropdownPanel() {

        int frame_size_width = 900;               //프레임의 가로 크기
        int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
        int top_panel_height = 100;   //상단 검색 바 고정 높이
        
        int bottom_empty = top_panel_height/3;	//top_panel_height의 위아래 공백 기준
        
        this.country = new JComboBox<>();
        this.continent = new JComboBox<>();
        this.airport = new JComboBox<>();
        String[] continentArr = dbtest.getContinentData();
        String[] airportArr = {"전체공항", "국제공항"};
        ArrayList<String> al = new ArrayList<String>();
      
//        String[] countryArr = dbtest.getData("한글국가명");
        String[] countryArr = dbtest.getCountryData();
        
        for (String str : continentArr) {
            continent.addItem(str);
        }
        for (String str : airportArr) {
            airport.addItem(str);
        }
        for (String str : countryArr) {
            country.addItem(str);
        }
        
        country.setMaximumSize(new Dimension(115, 100));
        continent.setMaximumSize(new Dimension(115, 100));
        airport.setMaximumSize(new Dimension(115, 100));

        continent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox) e.getSource();
				String index = cb.getSelectedItem().toString();
//				switch(index) {
//					case "유럽": al = dbtest.getData("유럽");
//						break;
//					case "아프리카":
//						break;
//					case "중동":
//						break;
//					case "북미":
//						break;
//					case "남미":
//						break;
//					case "중남미":
//						break;
//					case "아시아":
//						break;
//					case "대양주":
//						break;
//				}
				// 대륙 선택시 나오는 국가 재설정 case문 구현 중
			}
		});

        this.dropdownBtn = new JButton("검색");
        
        this.add(continent);
        this.add(country);
        this.add(airport);
        this.add(dropdownBtn);
    }

}