package MyVirtualKeyboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class MyVirtualKeyboard extends JFrame implements KeyListener {
 
private static final long serialVersionUID = 1L;
 
Map<Integer, JButton> map = new HashMap<>(); //나중에 설명하기
 
String firstRow[] = { "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "fill",
 
"BackSpace" };
 
String secondRow[] = { "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\" };
 
String thirdRow[] = { "Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "fill",
 
"Enter" };
 
String fourthRow[] = { "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "blank", "^" };
 
String fifthRow[] = { "blank", "blank","blank", "blank","fill", "fill", "fill", "fill", "fill", "","blank", "<", "v", ">" };
 
String typedText = "";
 
int keycode;
 
JTextArea text = new JTextArea();
 
JButton first[];
 
JButton second[];
 
JButton third[];
 
JButton fourth[];
 
JButton fifth[];
 
public static void main(String[] args) {
 
MyVirtualKeyboard virtualKeyboardFrame = new MyVirtualKeyboard();
 
}
 
public MyVirtualKeyboard() {
 
super("Typing Tutor");
 
initializeGUI();
 
}
 
public final void initializeGUI()
{ /////////////////////
 
JLabel info = new JLabel(
 
"<html>&nbsp;&nbsp;Type some text using your keyboard.The keys "
 
+ "you press will be highlighted and text will be displayed."
+ "<br> &nbsp;&nbsp;Note : Clicking the buttons with your "
+ "mouse will not perform any action. <br><br> </html>");
 
info.setFont(new Font("Calibri", Font.BOLD, 15)
);
 
setLayout(new BorderLayout()
);
 
// Various panel for the layout
 
JPanel jpNorth = new JPanel();
 
JPanel jpWest = new JPanel();
 
JPanel jpEast = new JPanel();
 
JPanel jpCenter = new JPanel();
 
JPanel jpKeyboard = new JPanel(new GridBagLayout()
);
 
JPanel jpNote = new JPanel();
 
// adding Panels
 
add(jpNorth, BorderLayout.NORTH);
 
add(jpNote);
 
// adding Panels
 
add(jpWest, BorderLayout.WEST);
 
add(jpEast, BorderLayout.EAST);
 
// adding Panels.
 
add(jpCenter, BorderLayout.CENTER);
 
add(jpKeyboard, BorderLayout.SOUTH);
 
// setting layout and adding BorderLayout
 
jpNorth.setLayout(new BorderLayout()
);
 
jpNorth.add(info, BorderLayout.SOUTH);
 
jpCenter.setLayout(new BorderLayout()
);
 
jpCenter.add(text, BorderLayout.CENTER);
 
jpCenter.setPreferredSize(new Dimension(300, 200)
);
 
first = new JButton[firstRow.length];
 
second = new JButton[secondRow.length];
 
third = new JButton[thirdRow.length];
 
fourth = new JButton[fourthRow.length];
 
fifth = new JButton[fifthRow.length];
 
addKeys(jpKeyboard, 0, firstRow, first);
 
addKeys(jpKeyboard, 1, secondRow, second);
 
addKeys(jpKeyboard, 2, thirdRow, third);
 
addKeys(jpKeyboard, 3, fourthRow, fourth);
 
addKeys(jpKeyboard, 4, fifthRow, fifth);
 
jpKeyboard.setPreferredSize(new Dimension(400, 180)
);
 
text.addKeyListener(this);
 
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
this.setResizable(false);
 
this.getContentPane()
.setPreferredSize(new Dimension(700, 400)
);
 
pack();
 
this.setLocationRelativeTo(null);
 
this.setVisible(true);
 
}
 
@Override
 
public void keyPressed(KeyEvent evtent) {
 
int keyCode = evtent.getKeyCode();
 
String keyText = KeyEvent.getKeyText(keyCode);
 
JButton btn = map.get(keyCode); //////check
 
if (btn != null) {
 
btn.setBackground(new Color(0, 255, 0)
);
 
}
 
}
 
@Override
 
public void keyReleased(KeyEvent evt) {
 
keycode = evt.getKeyCode(); //
 
typedText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()
)
);
 
JButton btn = map.get(keycode);
 
if (btn != null) {
 
btn.setBackground(
(Color) btn.getClientProperty("originalBackground")
);
 
}
 
}
 
@Override
 
public void keyTyped(KeyEvent evtent) {
 
typedText = String.format("%s", evtent.getKeyChar()
);
 
}
 
protected final void addKeys(JPanel parent, int row, String[] keys, JButton[] buttons) {
 
GridBagConstraints GBC = new GridBagConstraints();
 
GBC.gridy = row;
 
GBC.gridx = 0;
 
GBC.fill = GridBagConstraints.BOTH;
 
int gap = 0;
 
for (int index = 0; index < keys.length; index++) {
 
String key = keys[index];
 
if ("blank".equalsIgnoreCase(key)
) {
 
GBC.gridx++;
 
} else if ("fill".equalsIgnoreCase(key)
) {
 
GBC.gridwidth++;
 
gap++;
 
} else {
 
JButton btn = new JButton(key);
 
buttons[index] = btn;
 
if (key.equals("Shift")
) {
 
btn.setText("Shift ");
 
GBC.gridwidth = 2;
 
}
 
parent.add(btn, GBC);
 
GBC.gridx += gap + 1;
 
GBC.gridwidth = 1;
 
gap = 0;
 
map.put(getKeyCode(key), btn);
 
}
 
}
 
}
 
// events!! even drven program recording -> 14:00
 
private int getKeyCode(String key) {
 
switch (key) {
 
case "BackSpace":
 
return KeyEvent.VK_BACK_SPACE;
 
case "Tab":
 
return KeyEvent.VK_TAB;
 
case "Caps":
 
return KeyEvent.VK_CAPS_LOCK;
 
case "Enter":
 
return KeyEvent.VK_ENTER;
 
case "Shift":
 
return KeyEvent.VK_SHIFT;
 
case "":
 
return KeyEvent.VK_SPACE;
 
case "+":
 
return KeyEvent.VK_EQUALS;
 
case ":":
 
return KeyEvent.VK_SEMICOLON;
 
case "\"":
 
return KeyEvent.VK_QUOTE;
 
case "?":
 
return KeyEvent.VK_SLASH;
 
case "~":
 
return KeyEvent.VK_BACK_QUOTE;
 
case "^":
 
return KeyEvent.VK_UP;
 
case "v":
 
return KeyEvent.VK_DOWN;
 
case "<":
 
return KeyEvent.VK_LEFT;
 
case ">":
 
return KeyEvent.VK_RIGHT;
 
default:
 
return (int) key.charAt(0);
 
}
 
}
}
