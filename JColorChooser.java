import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JColorChooser extends JFrame{
//	private static JColorChooser app;
	Container contentPane;
	JButton testButton;
	Color selectedColor;
	
	public JColorChooser() {
		super("JColorChooser 예제");
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		selectedColor = Color.lightGray;
		testButton = new JButton("컬러 선택");
		testButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						selectedColor = JColorChooser.showDialog(//showDialog는 윈도우에서만 지원해주는 기능이다.
								JColorChooser.this, "컬러선택 다이얼로그 박스", Color.lightGray);
						contentPane.setBackground(selectedColor);
					}
				}
			);
		contentPane.add(testButton);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
	}
	
	public static void main(String[] args) {
		JColorChooser app = new JColorChooser();
		app.setVisible(true);
	}
}
