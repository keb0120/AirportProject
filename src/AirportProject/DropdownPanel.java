package AirportProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownPanel extends JPanel {

    JComboBox<String> country, continent, airport;
    JButton dropdownBtn;

    public DropdownPanel() {

        int frame_size_width = 900;               //프레임의 가로 크기
        int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
        int top_panel_height = 100;   //상단 검색 바 고정 높이
        
        int bottom_empty = top_panel_height/3;	//top_panel_height의 위아래 공백 기준
        
        this.country = new JComboBox<>();
        this.continent = new JComboBox<>();
        this.airport = new JComboBox<>();
        String[] countryArr = {"한국", "중국"};
        String[] continentArr = {"유럽", "아시아", "아프리카", "남아메리카", "북아메리카", "오세아니아"};
        String[] airportArr = {"국제공항", "국내공함"};
        for (String str : countryArr) {
            country.addItem(str);
        }
        for (String str : continentArr) {
            continent.addItem(str);
        }
        for (String str : airportArr) {
            airport.addItem(str);
        }
       
        continent.setPreferredSize(new Dimension(100, bottom_empty));
        country.setPreferredSize(new Dimension(100, bottom_empty));
        airport.setPreferredSize(new Dimension(100, bottom_empty));

        this.dropdownBtn = new JButton("검색");
        dropdownBtn.setPreferredSize(new Dimension(60, bottom_empty));

        this.add(continent);
        this.add(country);
        this.add(airport);
        this.add(dropdownBtn);
    }

}