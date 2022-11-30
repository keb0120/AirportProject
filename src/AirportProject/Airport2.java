package AirportProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Airport2 {
   public static void main(String[] args) {
      int frame_size_width = 900;               //프레임의 가로 크기
      int frame_size_height = frame_size_width/12*8;   //프레임의 세로 크기
      int top_panel_height = 100;   //상단 검색 바 고정 높이
      int change_panel_height = frame_size_height - top_panel_height;   //상단 바를 제외한 바뀌는 Panel의 고정 높이
      
      DropdownPanel dropdownPanel;
      TablePanel tablePanel;
      SearchPanel searchPanel;
      DataTablePanel datatablePanel;
      
      JFrame frame = new JFrame();               //전체 frame
      JPanel panel = new JPanel();               //전체 panel
      JPanel JPanel1 = new JPanel();            //검색할 수 있는 상단 panel
      JPanel travel_more_top_panel = new JPanel();   //travel_more 화면에서 나올 상단 panel
      JPanel before_search_panel = new JPanel();      //top_panel 아래 검색 전 화면
      JPanel JPanel2 = new JPanel();      //top_panel 아래 검색 후 화면(표가 들어갈 panel)
      JPanel travel_more_panel = new JPanel();      //travel more를 누르면 나오는 panel
      JLabel before_search_label = new JLabel("검색 전 화면");         //test용 문장
      JLabel after_search_label = new JLabel("검색 후 화면");         //test용 문장
      JLabel travel_more_label = new JLabel("travel more 화면");   //test용 문장
      JLabel travel_more_top_label = new JLabel("더 여행하고 싶으신가요?");
      //윗줄 아랫줄 글자 크기 다르게 하기 위해 따로 선언. 나중에 변경 예정
      String travel_more_selected_airport = "Airport Name";
      JLabel travel_more_top_label2 = new JLabel(travel_more_selected_airport+"에서 갈 수 있는 주변 공항을 알려드릴게요");
      
      
      /**** 설정값 ****/
      frame.setVisible(true);            //만든 프레임 보이게 하기
      frame.setSize(frame_size_width, frame_size_height);      //프레임 크기
      frame.setLocationRelativeTo(null);   //프레임 실행 시 화면 정가운데에서 시작
      frame.setResizable(false);         //사용자가 프레임 크기 조정할 수 없게 설정
      //frame.setLayout(null);
      frame.setLayout(new GridLayout(1, 1)); 
      
      panel.setLayout(null);            //Layout은 null로 해야 크기 조정 가능
      
      JPanel1.setBackground(Color.BLUE);//Top panel 색깔 blue로 지정
      JPanel1.setSize(frame_size_width, top_panel_height);
      JPanel1.setLayout(null);
      dropdownPanel = new DropdownPanel();	//드롭다운으로 검색하는 panel
      searchPanel = new SearchPanel();		//검색어로 검색하는 panel
      datatablePanel = new DataTablePanel();
      
      int top_empty = frame_size_width/30;		//top_panel_height의 상단 좌우 공백 기준
      int bottom_empty = top_panel_height/3;	//top_panel_height의 위아래 공백 기준
      
      dropdownPanel.setBounds(top_empty,bottom_empty,frame_size_width/2,bottom_empty);
      dropdownPanel.setBackground(Color.BLUE);
      
      searchPanel.setBounds(frame_size_width/2,bottom_empty,frame_size_width/2-top_empty,bottom_empty);
      searchPanel.setBackground(Color.BLUE);
      
      JPanel1.add(dropdownPanel);
      JPanel1.add(searchPanel);
      
      travel_more_top_panel.setLayout(null);
     
      
      travel_more_top_panel.setBackground(Color.BLUE);//Top panel 색깔 blue로 지정
      travel_more_top_panel.setBounds(0,0,frame_size_width, top_panel_height);
      travel_more_top_panel.add(travel_more_top_label);
      travel_more_top_panel.add(travel_more_top_label2);
      
      //travel_more_top_label.setForeground(Color.white);
      //ravel_more_top_label2.setForeground(Color.white);
      
      //testCode
      before_search_panel.setBackground(Color.pink);

      
      before_search_panel.add(before_search_label);   //test용 label. 이후 추가하면 삭제
      before_search_panel.setBounds(0, top_panel_height, frame_size_width, change_panel_height);
      
      tablePanel = new TablePanel();
      JPanel2.setLayout(null);
      JPanel2.setBounds(0, top_panel_height, frame_size_width, change_panel_height);
      //JPanel2.setPreferredSize(new Dimension(frame_size_width,change_panel_height));
      JPanel2.setBackground(Color.DARK_GRAY);
      tablePanel.setBackground(Color.GREEN);
      tablePanel.setBounds(0, 0, frame_size_width, change_panel_height);	//표 크기 설정 최대로
      JPanel2.add(tablePanel);     
      JPanel2.setVisible(true);
      tablePanel.setVisible(false);
      
      travel_more_panel.setBounds(0, top_panel_height, frame_size_width, change_panel_height);
      //travel_more_panel.setBackground(Color.YELLOW);
      travel_more_panel.add(travel_more_label);      //test용 label. 표 추가하면 삭제
      
      //test용 label들 가운데 정렬
      before_search_label.setHorizontalAlignment(JLabel.CENTER);
      after_search_label.setHorizontalAlignment(JLabel.CENTER);
      travel_more_label.setHorizontalAlignment(JLabel.CENTER);
      
      /**** 추가 및 조작 시작 ****/
      frame.add(panel);
      
      panel.add(JPanel1);
      panel.add(travel_more_top_panel);
      panel.add(before_search_panel);
      panel.add(JPanel2);
      panel.add(travel_more_panel);
      
      JPanel1.setVisible(true);
      before_search_panel.setVisible(true);
      tablePanel.setVisible(false);
      travel_more_panel.setVisible(false);
      travel_more_top_panel.setVisible(false);
      
      dropdownPanel.dropdownBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String airport = (String) dropdownPanel.airport.getSelectedItem();
              String continent = (String) dropdownPanel.continent.getSelectedItem();
              String country = (String) dropdownPanel.country.getSelectedItem();
              tablePanel.setDataByDropdown(country, airport, continent); // 드롭다운 데이터를 어케 받아오는지 몰라서 일단은 보류
              tablePanel.setVisible(true);
              tablePanel.deleteDatatablePanel();
          
          }
      });

      searchPanel.searchBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String search = searchPanel.searchText.getText();
              tablePanel.setDataByIATA(search); // 서치 했을때 IATA 코드
              tablePanel.setVisible(true);
              tablePanel.deleteDatatablePanel();
          }
      });
      
      
    
   }
}