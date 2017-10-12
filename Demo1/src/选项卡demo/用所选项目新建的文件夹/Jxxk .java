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
public class Jxxk extends JFrame
{
	private JTabbedPane tabbedPane;
	private JLabel label1,label2,label3,label4;
	private JPanel panel1,panel2,panel3;
	//private JScrollPane panel1;
	//private JLabel textJLabel;    // JLabel that displays text
	private JTextArea ta; //显示试题
	private int j=1;
	
	public Jxxk(String s)
	{
		super("选项卡窗口"); 
		setSize(600,1000);

		Container c = getContentPane();
		tabbedPane=new JTabbedPane();	//创建选项卡面板对象
		//创建标签
		label1=new JLabel("输入题数",SwingConstants.CENTER);
		label4=new JLabel("选择难度",SwingConstants.CENTER);
		//label2=new JLabel("第二个标签的面板",SwingConstants.CENTER);
		//label3=new JLabel("第三个标签的面板",SwingConstants.CENTER);
		//创建面板
		panel1=new JPanel();
		panel2=new JPanel();
		//panel3=new JPanel();
		
		  // set up textJLabel
		 //  textJLabel = new JLabel();   //分配空间
		   ta=new JTextArea(30,48);
		  // JScrollPane jsp = new JScrollPane(ta); //创建滚动条
		 //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
	       // jsp.setBounds(13, 10, 350, 340);
		  // ta.setSize(500, 500);
		   ta.setLineWrap(true);
		   //s="welcome bro!";
		  // textJLabel.setText( s );
		  // textJLabel.setLocation(10,40);
		  // textJLabel.setSize(500,88);
		  // textJLabel.setFont( new Font( "SansSerif", Font.PLAIN, 36 ) );
		  // textJLabel.setHorizontalAlignment( JLabel.CENTER );
		 
		
		//创建复选框
		JComboBox combo1=new JComboBox();
		combo1.setEditable(true);
		combo1.setSize(200, 50);
		combo1.addItem("3");
		combo1.addItem("5");
		combo1.addItem("8");
		combo1.addItem("10");
		
		JComboBox combo2=new JComboBox();
		combo2.setEditable(false);
		combo2.setSize(200, 50);
		combo2.addItem("简单");
		combo2.addItem("中等");
		combo2.addItem("困难");
		
		//创建按钮
		Button b = new Button("生成试卷");// 在窗口中添加一个按钮；
		b.setSize(50, 50);
		//b.addMouseListener(new MyMouseDoubleClick());
		//让按钮具备关闭窗口的功能
		    b.addActionListener(new ActionListener()
		        {
		             public void actionPerformed(ActionEvent e)
		            {
		                 //System.out.println("按钮执行关闭窗口的功能");
		                 // System.exit(0);
		            	 String tishu=(String) combo1.getSelectedItem();//题目数量
		            	 String nandu=(String) combo2.getSelectedItem();//题目难度
		            	 sqlQuery.sqlQuery(tishu,nandu) ;
		            	 
		            	 try {
							String s2=readtxt();
							ta.setText(s2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	 
		             }
	         });
		
		
//在面板里加文字
		   
			//  panel1.add(jsp);
		
		panel1.add(label1);
		panel1.add(combo1);
		panel1.add(label4);
		panel1.add(combo2);
		panel1.add(b);
		 panel1.add( ta );
		 panel1.add(new JScrollPane(ta));
		 
//		panel1.paintComponents(g);
//		g.drawString("I am a student",30,20);
		//panel2.add(label2);
		//panel3.add(label3);

		panel1.setBackground(Color.gray);
		//panel2.setBackground(Color.blue);
		//panel3.setBackground(Color.green);
		//将标签面板加入到选项卡面板对象上
		tabbedPane.addTab("学生界面",null,panel1,"First panel");
		tabbedPane.addTab("老师界面",null,panel2,"Second panel");
		//tabbedPane.addTab("标签3",null,panel3,"Third panel");

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
	
	/*
	//定义内部类
	private static final class MyMouseDoubleClick extends MouseAdapter{
	  public void mouseDoubleClick(MouseEvent e){
	  MessageDialog.openInformation(null,"","Hello World");
	}
	}*/
	
	private String readtxt() throws IOException{
		String s ="\\Users\\apple\\Desktop\\第"+j+"份试卷.txt";
		BufferedReader br=new BufferedReader(new FileReader(s));
		j++;
		String str="";
		String r=br.readLine();
		while(r!=null){
		str+=r+"\n";
		r=br.readLine();
		}
		return str;
		}
}