package 选项卡demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.JScrollPane;

public class Jxxk extends JFrame {
	private JTabbedPane tabbedPane;
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JPanel panel1, panel2, panel3;
	private JTextArea ta, ta2; // 显示试题
	private int j = 1;

	public Jxxk() {
		super("奥数（小学）试卷生成系统");
		setSize(650, 700);

		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // 创建选项卡面板对象
		// 创建标签
		label1 = new JLabel("输入题数", SwingConstants.CENTER);
		label4 = new JLabel("选择难度", SwingConstants.CENTER);
		// 创建面板
		panel1 = new JPanel();
		panel2 = new JPanel();

		// ------------------------------------------------------------学生页面

		ta = new JTextArea(30, 48);
		ta.setLineWrap(true);

		// 创建复选框
		JComboBox combo1 = new JComboBox();
		combo1.setEditable(true);
		combo1.setSize(200, 50);
		combo1.addItem("3");
		combo1.addItem("5");
		combo1.addItem("8");
		combo1.addItem("10");

		JComboBox combo2 = new JComboBox();
		combo2.setEditable(false);
		combo2.setSize(200, 50);
		combo2.addItem("简单");
		combo2.addItem("中等");
		combo2.addItem("困难");

		// 创建按钮
		Button b = new Button("生成试卷");// 在窗口中添加一个按钮；
		b.setSize(50, 50);
		// 让按钮具备关闭窗口的功能
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tishu = (String) combo1.getSelectedItem();// 题目数量
				String nandu = (String) combo2.getSelectedItem();// 题目难度
				sqlQuery.sqlQuery(tishu, nandu);

				try {
					String s2 = readtxt();
					ta.setText(s2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// ----------------------------------------------------老师界面
		label2 = new JLabel("请选择难度", SwingConstants.CENTER);
		label3 = new JLabel("请输入知识点1", SwingConstants.CENTER);
		label6 = new JLabel("请输入知识点2", SwingConstants.CENTER);
		label7 = new JLabel("请输入知识点3", SwingConstants.CENTER);
		label5 = new JLabel("请输入题目", SwingConstants.CENTER);

		JComboBox combo3 = new JComboBox(); // 难度
		combo3.setEditable(false);
		combo3.setSize(200, 50);
		combo3.addItem("简单");
		combo3.addItem("中等");
		combo3.addItem("困难");

		JTextField txt1 = new JTextField(25); // 输入知识点
		JTextField txt2 = new JTextField(15); // 输入知识点
		JTextField txt3 = new JTextField(15); // 输入知识点

		ta2 = new JTextArea(20, 45);
		ta2.setLineWrap(true);

		Button b1 = new Button("插入题目");// 在窗口中添加一个按钮；
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nandu = (String) combo3.getSelectedItem();// 题目难度
				String zhishidian1 = (String) txt1.getText();// 知识点
				String zhishidian2 = (String) txt1.getText();// 知识点
				String zhishidian3 = (String) txt1.getText();// 知识点
				String neirong = ta2.getText();
				sqlInsert.sqlInsert(nandu, zhishidian1, neirong,zhishidian2,zhishidian3);

				try {
					String s2 = readtxt();
					ta.setText(s2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// ---------------------------------------------将控件加到学生面板上
		panel1.add(label1);
		panel1.add(combo1);
		panel1.add(label4);
		panel1.add(combo2);
		panel1.add(b);
		panel1.add(ta);
		panel1.add(new JScrollPane(ta));

		panel1.setBackground(Color.gray);
		// -----------------------------------------------控件加到老师界面上
		panel2.add(label2);
		panel2.add(combo3);
		panel2.add(label3);
		panel2.add(txt1); // 知识点1
		panel2.add(label6);
		panel2.add(txt2);// 知识点2
		panel2.add(label7);
		panel2.add(txt3); // 知识点3

		panel2.add(label5);
		panel2.add(ta2);
		panel2.add(new JScrollPane(ta2));

		panel2.add(b1);

		// 将标签面板加入到选项卡面板对象上
		tabbedPane.addTab("学生界面", null, panel1, "First panel");
		tabbedPane.addTab("老师界面", null, panel2, "Second panel");

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Jxxk d = new Jxxk();
	}

	private String readtxt() throws IOException {
		String s = "\\Users\\apple\\Desktop\\第" + j + "份试卷.txt";
		BufferedReader br = new BufferedReader(new FileReader(s));
		j++;
		String str = "";
		String r = br.readLine();
		while (r != null) {
			str += r + "\n";
			r = br.readLine();
		}
		return str;
	}
}