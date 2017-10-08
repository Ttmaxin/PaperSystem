package 选项卡demo;
import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.JScrollPane;
public class Jxxk extends JFrame
{
	private JTabbedPane tabbedPane;
	private JLabel label1,label2,label3,label4;
	private JPanel panel1,panel2,panel3;
	//private JScrollPane panel1;
	private JLabel textJLabel;    // JLabel that displays text
	
	public Jxxk(String s)
	{
		super("选项卡窗口"); setSize(400,300);

		Container c = getContentPane();
		tabbedPane=new JTabbedPane();	//创建选项卡面板对象
		//创建标签
		label1=new JLabel("输入题数",SwingConstants.CENTER);
		label4=new JLabel("选择难度",SwingConstants.CENTER);
		label2=new JLabel("第二个标签的面板",SwingConstants.CENTER);
		label3=new JLabel("第三个标签的面板",SwingConstants.CENTER);
		//创建面板
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		  // set up textJLabel
		   textJLabel = new JLabel();   //分配空间
		   //s="welcome bro!";
		   textJLabel.setText( s );
		   textJLabel.setLocation(10,40);
		  // textJLabel.setSize(500,88);
		  // textJLabel.setFont( new Font( "SansSerif", Font.PLAIN, 36 ) );
		   textJLabel.setHorizontalAlignment( JLabel.CENTER );
		 
		
		//创建复选框
		JComboBox combo1=new JComboBox();
		combo1.setEditable(true);
		combo1.setSize(200, 50);
		combo1.addItem("1");
		combo1.addItem("2");
		combo1.addItem("3");
		combo1.addItem("4");
		
		JComboBox combo2=new JComboBox();
		combo2.setEditable(false);
		combo2.setSize(200, 50);
		combo2.addItem("1");
		combo2.addItem("2");
		combo2.addItem("3");
		
		//创建按钮
		Button b = new Button("按钮");// 在窗口中添加一个按钮；
		b.setSize(50, 50);
//在面板里加文字
		panel1.add(label1);
		panel1.add(combo1);
		panel1.add(label4);
		panel1.add(combo2);
		panel1.add(b);
		  panel1.add( textJLabel );
//		panel1.paintComponents(g);
//		g.drawString("I am a student",30,20);
		panel2.add(label2);
		panel3.add(label3);

		panel1.setBackground(Color.gray);
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.green);
		//将标签面板加入到选项卡面板对象上
		tabbedPane.addTab("学生界面",null,panel1,"First panel");
		tabbedPane.addTab("标签2",null,panel2,"Second panel");
		tabbedPane.addTab("标签3",null,panel3,"Third panel");

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		//ResultSet rs =sqlQuery.sqlQuery() ;
		
		Jxxk d = new Jxxk("welcome");
	}
}