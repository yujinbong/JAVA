package MyCalendar;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
public class MyCalendar extends JFrame {
 
Calendar current_date = new GregorianCalendar();
 
Calendar current_month = new GregorianCalendar(current_date.get(Calendar.YEAR), current_date.get(Calendar.MONTH), 1);
 
private CalendarPanel currentCalendarPanel = new CalendarPanel(current_month);
 
private JButton previous = new JButton("Previous");
 
private JButton next = new JButton("Next");
 
MyCalendar() {
 
JPanel panel = new JPanel();
 
panel.add(previous);
 
panel.add(next);
 
add(currentCalendarPanel , BorderLayout.CENTER);
 
add(panel, BorderLayout.SOUTH);
 
next.addActionListener(new ActionListener() {
 
@Override
 
public void actionPerformed(ActionEvent e) {
 
remove(currentCalendarPanel );
 
currentCalendarPanel = currentCalendarPanel .moveToNextMonth();
 
add(currentCalendarPanel , BorderLayout.CENTER);
 
repaint();
 
revalidate();
 
}
 
});
 
previous.addActionListener(new ActionListener() {
 
@Override
 
public void actionPerformed(ActionEvent e) {
 
remove(currentCalendarPanel );
 
currentCalendarPanel = currentCalendarPanel .moveToPreviousMonth();
 
add(currentCalendarPanel , BorderLayout.CENTER);
 
repaint();
 
revalidate();
 
}
 
});
 
}
 
public static void main(String[] args) {
 
JFrame frame = new MyCalendar();
 
frame.pack();
 
frame.setResizable(false);
 
frame.setLocationRelativeTo(null);
 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
frame.setVisible(true);
 
}
}
class CalendarPanel extends JPanel {
 
public Calendar calendar;
 
private int currentYear;
 
private int currentMonth;
 
private int numOfDaysInMonth;
 
private int starDay;
 
private int previousMonth;
 
public CalendarPanel(Calendar calendar) {
 
this.calendar = calendar;
 
setLayout(new BorderLayout()
);
 
currentYear = calendar.get(Calendar.YEAR);
 
currentMonth = calendar.get(Calendar.MONTH);
 
numOfDaysInMonth = getMaximum(currentMonth);
 
starDay = calendar.get(Calendar.DAY_OF_WEEK);
 
previousMonth = getPreviousMonth(currentMonth);
 
DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
 
String monthName = dfs.getMonths()
[currentMonth];
 
JLabel calendarHeader = new JLabel("<html><i>" + monthName + ", " + currentYear + "</i></html>");
 
calendarHeader.setHorizontalAlignment(JLabel.CENTER);
 
JPanel panel = new JPanel(new GridLayout(0, 7, 0, 0)
);
 
JLabel l1 = new JLabel("Sun");
 
l1.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l2 = new JLabel("Mon");
 
l2.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l3 = new JLabel("Tue");
 
l3.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l4 = new JLabel("Wed");
 
l4.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l5 = new JLabel("Thu");
 
l5.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l6 = new JLabel("Fri");
 
l6.setHorizontalAlignment(JLabel.CENTER);
 
JLabel l7 = new JLabel("Sat");
 
l7.setHorizontalAlignment(JLabel.CENTER);
 
panel.add(l1);
 
panel.add(l2);
 
panel.add(l3);
 
panel.add(l4);
 
panel.add(l5);
 
panel.add(l6);
 
panel.add(l7);
 
int i;
 
int daysInPreviousMonth = getMaximum(previousMonth);
 
int firstDisplayedDay = daysInPreviousMonth - starDay + 2;
 
for (i = 1; i < starDay; i++) {
 
JLabel label = new JLabel(firstDisplayedDay + "");
 
label.setHorizontalAlignment(JLabel.CENTER);
 
label.setForeground(Color.lightGray); // grey
 
panel.add(label);
 
firstDisplayedDay ++;
 
}
 
for (int j = 1 ; j <= numOfDaysInMonth; j++, i++) {
 
JLabel label = new JLabel(j + "");
 
label.setHorizontalAlignment(JLabel.CENTER);
 
panel.add(label);
 
}
 
for (int j = 1 ; i <= 42; j++, i++) {
 
JLabel label = new JLabel(j + "");
 
label.setHorizontalAlignment(JLabel.CENTER);
 
label.setForeground(Color.LIGHT_GRAY);
 
panel.add(label);
 
}
 
add(calendarHeader, BorderLayout.NORTH);
 
add(panel, BorderLayout.CENTER);
 
}
 
private int getPreviousMonth(int month) {
 
if (month == 0) {
 
return 11;
 
}
 
return month - 1;
 
}
 
private int getMaximum(int month) {
 
int maximum = 0;
 
switch (month) {
 
case 0:
 
maximum = 31;
 
break;
 
case 1:
 
if (isLeap()
)
 
maximum = 29;
 
else
 
maximum = 28;
 
break;
 
case 2:
 
maximum = 31;
 
break;
 
case 3:
 
maximum = 30;
 
break;
 
case 4:
 
maximum = 31;
 
break;
 
case 5:
 
maximum = 30;
 
break;
 
case 6:
 
maximum = 31;
 
break;
 
case 7:
 
maximum = 31;
 
break;
 
case 8:
 
maximum = 30;
 
break;
 
case 9:
 
maximum = 31;
 
break;
 
case 10:
 
maximum = 30;
 
break;
 
case 11:
 
maximum = 31;
 
break;
 
}
 
return maximum;
 
}
 
private boolean isLeap() {
 
return (currentYear % 4 == 0 && currentYear % 100 != 0) |
|
 
currentYear % 400 == 0;
 
}
 
public CalendarPanel moveToPreviousMonth() {
 
return new CalendarPanel(new GregorianCalendar(
 
currentYear,
 
currentMonth - 1,
 
1)
);
 
}
 
public CalendarPanel moveToNextMonth() {
 
return new CalendarPanel(new GregorianCalendar(
 
currentYear,
 
currentMonth + 1,
 
1)
);
 
}
 
@Override
 
public Dimension getPreferredSize() {
 
return new Dimension(400, 400);
 
}
}
