package AirportProject;

import AirportProject.PlaceholderTextField;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    PlaceholderTextField searchText;
    JButton searchBtn;

    public SearchPanel() {
    	int frame_size_width = 900;               //프레임의 가로 크기
        int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
        int top_panel_height = 100;   //상단 검색 바 고정 높이
        
        int bottom_empty = top_panel_height/3;	//top_panel_height의 위아래 공백 기준
        

        searchText = new PlaceholderTextField();
        searchText.setPlaceholder("공항코드를 입력하세요");
        searchText.setColumns(20);

        searchBtn = new JButton("입력");

        searchBtn.addActionListener(new SearchBtnListener(searchText));

        searchText.setPreferredSize(new Dimension(200, bottom_empty));
        searchBtn.setPreferredSize(new Dimension(60, bottom_empty));
        
        this.add(searchText);
        this.add(searchBtn);
    }

    static class SearchBtnListener implements ActionListener {

        PlaceholderTextField placeholderTextField;

        public SearchBtnListener (PlaceholderTextField placeholderTextField) {
            this.placeholderTextField = placeholderTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}