
import javax.swing.*;
import java.awt.*;
public class Align extends JFrame {
 
private JCheckBox checkBox = new JCheckBox("Snap to Grid");
 
private JCheckBox checkBox2 = new JCheckBox("Show Grid");
 
private JLabel JL_X=new JLabel("X: ");
 
private JLabel JL_Y=new JLabel("Y: ");
 
private JTextField JF_X = new JTextField(" 8",15);
 
private JTextField JF_Y = new JTextField(" 8",15);
 
public Align()
{
 
JPanel panel = new JPanel(new GridLayout(2,1,5,2)
);
 
panel.add(checkBox);
 
panel.add(checkBox2);
 
//2panel
 
JPanel panel_1 = new JPanel(new GridLayout(2,2,5,5)
);
 
panel_1.add(JL_X);
 
panel_1.add(JF_X);
 
panel_1.add(JL_Y);
 
panel_1.add(JF_Y);
 
//panel3
 
JPanel panel_2 = new JPanel(new GridLayout(3,1,5,5)
);
 
panel_2.add(new JButton("OK")
);
 
panel_2.add(new JButton("Cancel")
);
 
panel_2.add(new JButton("Help")
);
 
JPanel panelFrame = new JPanel(new BorderLayout()
);
 
panelFrame.add(panel,BorderLayout.WEST);
 
panelFrame.add(panel_1,BorderLayout.CENTER);
 
panelFrame.add(panel_2,BorderLayout.EAST);
 
add(panelFrame);
 
}
 
public static void main(String[] args) {
 
Align align = new Align();
 
align.setTitle("Align");
 
align.setSize(300,100);
 
align.setLocationRelativeTo(null);
 
align.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
align.setVisible(true);
 
}
}
