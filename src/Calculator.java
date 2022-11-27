//단축키 - import- ctrl+shitf+o / 정렬 ctrl + shit + F

import java.awt.Color;
import java.awt.Font; //Font
import java.awt.GridLayout; // GridLayout 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame; //Ctrl + Shift + O -> Import 단축키
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JTextField inputSpace; // 이것으로 화면 구현.
	private String num = ""; // 계산식의 숫자를 담을 변수 num을 만든다.
	private ArrayList<String> equation = new ArrayList<String>(); // equation = 적도

	public Calculator() {
		// 별다른 레이아웃을 보여주지않을것이기에
		setLayout(null);

		// 빈공간의 JText를 생성하고 버튼으로만 입력받을것이기에 edit 불가하게 만듬.
		inputSpace = new JTextField();
		inputSpace.setEditable(false);
		// 배경색, 정렬위치, 글씨페
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial", Font.BOLD, 50));
		inputSpace.setBounds(8, 10, 270, 70);// x:80, y:10의 위치에 270 * 70의 크기를 의미한다.

		JPanel buttonPanel = new JPanel(); // 버튼들을 담을 패널
		buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
		buttonPanel.setBounds(8, 90, 270, 235);

		String button_names[] = { "C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };
		JButton buttons[] = new JButton[button_names.length]; // 버튼들의 배열

		for (int i = 0; i < button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			// 버튼 배경 검정, 나머지 버튼은 회색으로 설정하고 글자색은 흰색으로 설정.
			if (button_names[i] == "C")
				buttons[i].setBackground(Color.RED);
			else if ((i >= 4 && i <= 6 || i >= 8 && i <= 10) || (i >= 12 && i <= 14))
				buttons[i].setBackground(Color.BLACK);
			else
				buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setBorderPainted(false); // 테두리 없애기,
			buttons[i].addActionListener(new PadActionListener());
			buttonPanel.add(buttons[i]);

		}

		add(inputSpace);
		add(buttonPanel);

		// 창의 제목,사이즈,보이기 등
		setTitle("Calculator");
		setVisible(true);
		setSize(300, 370);
		setLocationRelativeTo(null); // be center a JFrame on screen
		setResizable(false); // can't change the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close operation을 해줘야 창을 닫을때 실행 중인 프로그램도 같이 종료됨.

	}

	// actionlistener를 상속시켜주고 actionperformed 메소드로 이벤트를 처리한다
	class PadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String operation = e.getActionCommand(); // 어떤 버튼이 눌렸는지 받아오기
			if (operation.equals("C")) {
				inputSpace.setText("");
			} else if (operation.equals("=")) {
				String result = Double.toString(calculate(inputSpace.getText()));
				inputSpace.setText("" + result);
				//앞서 ㅁㄴ든 메소드를 이용해 계산을 한 후 계산식 화면에 값을 띄어주면 됨.
				num = "";

			} else {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand());
			}
		}
	}

	// 계산 기능을 구현하기 위해 Array List에 숫자와 연산기호를 하나씩 구분에 담음.
	private void fullTextParsing(String inputText) {
		equation.clear();
		// for문을 열어서 계산식의 글자를 하나하나 거쳐나가게끔 한다음 검사함
		for (int i = 0; i < inputText.length(); i++) {
			char ch = inputText.charAt(i);

			if (ch == '=' | ch == '+' | ch == '×' | ch == '÷') {
				equation.add(num);
				// 연산기호를 거치게 될 시 앞은 숫자임으로 숫자를 먼저 ArrayList에 추가한다음
				// num을 초기화해 준다음 연산기호를 ArrayList에 추가한다
				num = "";
				equation.add(ch + "");
			} else {
				num = num + ch; // 나머지(숫자)일경우 num문자에 더한다.
				// num - "" / num="6" / num = "69"가 되며 연산기호가 나올시 ArrayList에 추가된 후 초기화된다.
			}
		}
		equation.add(num);
	}

	// 반복문이 끝난 후 최종으로 있는 num도 ArrayList에 추가해준다.
	public double calculate(String inputText) {
		fullTextParsing(inputText);
		// 앞서 만든 메소드를 실행해주면 ArrayList에 숫자와 연산기호가 담기게된다.
		// made라는 변수를 선언해 연산 기호에 대한 처리를 함
		double prev = 0;
		double current = 0;
		String made = "";

		for (String s : equation) {
			if (s.equals("+")) {
				made = "add";
			} else if (s.equals("-")) {
				made = "sub";
			} else if (s.equals("×")) {
				// 이경우 made가 "mul",
				made = "mul";
			} else if (s.equals("÷")) {
				// 이경우 made기 "div"가 됨
				made = "div";
			} else {
				// 나머지의(숫자)의 경우 문자열을 double로 형변환을 해줘야함.
				current = Double.parseDouble(s);
				// 이제 made에 따라 연산을 처리해주면도니다.
				if (made == "add") {
					prev += current;
				} else if (made == "sub") {
					prev -= current;
				} else if (made == "mul") {
					prev *= current;
				} else if (made == "div") {
					prev /= current;
				} else {
					prev = current;
				}

			}
		}
		return prev; //prev값 반환
 	}

	public static void main(String[] args) {
		new Calculator();
	}
}
