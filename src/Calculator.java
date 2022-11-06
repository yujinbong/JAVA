import java.awt.Color;
import java.awt.Font; //Font
import java.awt.GridLayout; // GridLayout 

import javax.swing.JButton;
import javax.swing.JFrame; //Ctrl + Shift + O -> Import 단축키
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Calculator extends JFrame{
	
	private JTextField inputSpace; //이것으로 화면 구현.
	
	
	public Calculator() {
		//별다른 레이아웃을 보여주지않을것이기에
		setLayout(null);
		
		//빈공간의 JText를 생성하고 버튼으로만 입력받을것이기에 edit 불가하게 만듬.
		inputSpace = new JTextField(); 
		inputSpace.setEditable(false);
		//배경색, 정렬위치, 글씨페
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial",Font.BOLD,50));
		inputSpace.setBounds(8,10,270,70);//x:80, y:10의 위치레 270 * 70의 크기를 의미한다.
		
		JPanel buttonPanel = new JPanel(); //버튼들을 담을 패널
		buttonPanel.setLayout(new GridLayout(4,4,10,10));
		buttonPanel.setBounds(8,90,270,235);
		
		String button_names[] = { "C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };
		JButton buttons[] = new JButton[button_names.length]; //버튼들의 배열
		
		for(int i=0; i < button_names.length; i++) {
			buttons[i] =  new JButton(button_names[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD,20));
			//버튼 배경 검정, 나머지 버튼은 회색으로 설정하고 글자색은 흰색으로 설정.
			if(button_names[i] == "C")buttons[i].setBackground(Color.RED);
			else if((i >= 4 && i <=6 || i >=8 && i <= 10 ) || (i >=12 && i <=14)) buttons[i].setBackground(Color.BLACK);
			else buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setBorderPainted(false); //테두리 없애기,
			buttonPanel.add(buttons[i]);
			
		}
		
	
		add(inputSpace);
		add(buttonPanel);
		
		
		//창의 제목,사이즈,보이기 등
		setTitle("Calculator");
		setVisible(true);
		setSize(300,370);
		setLocationRelativeTo(null); // be center a JFrame on screen
		setResizable(false); //can't change the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operation을 해줘야 창을 닫을때 실행 중인 프로그램도 같이 종료됨.
		
	}
	public static void main(String[] args) {
	new Calculator();
	}
}
