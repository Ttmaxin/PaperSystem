package 选项卡demo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class openEFileDemo {

	public static void main(String[] args) {
		Frame frame = new Frame("打开文件窗口");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setBounds(100, 200, 400, 300);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		final TextField txtField = new TextField(50);
		Button button = new Button("打开指定文件");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String path = txtField.getText();
				String path ="\\Users\\apple\\Desktop\\第1份试卷.txt";
				System.out.println(path);
				if (path.length() == 0) {
					return;
				}
				try {
					Runtime.getRuntime().exec("Safari.app /n, " + path);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		frame.add(txtField);
		frame.add(button);
		frame.setVisible(true);
	}
}
