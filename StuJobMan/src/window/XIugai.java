package window;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import bean.Student;
import dao.DAO;

import java.awt.Panel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class XIugai extends JPanel {

	/**
	 * Create the panel.
	 */
	public XIugai() {
		String date="";
		setLayout(new BorderLayout(0, 0));//组件之间横纵距离0像素
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);//上方布置一个容器
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		panel.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("学   号：");
		TextField t1 = new TextField(20);
		panel1.add(lblNewLabel);
		panel1.add( t1);
		
		
		
		panel.add(panel2);
		
		JLabel lblNewLabel_1 = new JLabel("姓       名：");
		panel2.add(lblNewLabel_1);
		
		TextField textField = new TextField(20);
		panel2.add(textField);
		panel.add(panel3);
		
		JLabel lblNewLabel_2 = new JLabel("                    性     别：  ");
		
		panel3.add(lblNewLabel_2);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel3.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		JRadioButton rdbtnNewRadioButton = new JRadioButton("     男");
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("    女");
		panel3.add(rdbtnNewRadioButton);
		panel3.add(rdbtnNewRadioButton_1);
		panel.add(panel4);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				rdbtnNewRadioButton_1.setSelected(false);
			}
		});
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				rdbtnNewRadioButton.setSelected(false);
			}
		});
		
		
		//panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		//panel4.setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("出生年月：");
		panel4.add(lblNewLabel_3);
		
	
		
		
		//修改
		
		
		TextField textField_1 = new TextField(10);
		panel4.add(textField_1);
		CalendarPanel p = new CalendarPanel(textField_1, "yyyy.MM.dd");
		p.initCalendarPanel();
		
		panel4.add(p);
		
		//添加一个按钮
		Button 	selectt = new Button("选择日期");
		panel4.add(selectt);
		selectt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					JFrame f = new JFrame("日期选择");
				
				f.setLayout(null);
				JTextField txt1 = new JTextField();
				JTextField txt2 = new JTextField();
				txt1.setBounds(0, 0, 300, 30);
				//txt2.setBounds(20, 80, 300, 30);
		 
				// 定义选择日期控件面板类
				CalendarPanel p = new CalendarPanel(txt1, "yyyy.MM.dd");
				p.initCalendarPanel();
		 
				Button 	conf = new Button("确定");
				conf.setBounds(300, 0,50,30);
				
				f.getContentPane().add(p);
				f.getContentPane().add(txt1);
				f.getContentPane().add(conf);
				conf.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						textField_1.setText(txt1.getText());
						
					}
				});
				//f.getContentPane().add(txt2);
				f.setSize(380,320);
				f.setBackground(Color.WHITE);
				
				f.setVisible(true);
				
				
			}
		});
		
		
		
		panel4.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		
		Panel panel_1 = new Panel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		JPanel panelc1 = new JPanel();
		JPanel panelc2 = new JPanel();
		JPanel panelc3 = new JPanel();
		JPanel panelc4 = new JPanel();
		
		panel_1.add(panelc1);
		panelc1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("                     籍    贯：");
		panelc1.add(lblNewLabel_4);
		panelc1.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		TextField textField_2 = new TextField(20);
		panelc1.add(textField_2);
		panel_1.add(panelc2);
		 
		JLabel lblNewLabel_5 = new JLabel("                    学院名称：");
		panelc2.add(lblNewLabel_5);
		panelc2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelc2.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		
		
		
		//修改
		//TextField textField_4_2 = new TextField(20);
		//panelc2.add(textField_4_2);
		 JComboBox comboBox_1 = new JComboBox();
		 panelc2.add(comboBox_1);
		 {
			  DAO dd= new DAO();
			  ResultSet re =  dd.duqu("college.collegename", "college");
			  try {
				while(re.next()) {
					comboBox_1.addItem(re.getString("collegename"));
					 System.out.println(re.getString("collegename"));
				  }
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		  }
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("                      	                               专         业：");
		panelc2.add(lblNewLabel_6);
	
		//修改
		//TextField textField_4_1 = new TextField(20);
		//panelc2.add(textField_4_1);
		JComboBox comboBox_2 = new JComboBox();
	       panelc2.add(comboBox_2);
	       {
				  DAO dd= new DAO();
				  ResultSet re =  dd.duqu1("major.majorname", "major","collegename",(String) comboBox_1.getSelectedItem());
				  try {
					while(re.next()) {
						comboBox_2.addItem(re.getString("majorname"));
						 System.out.println(re.getString("majorname"));
					  }
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			  }
		
	       
	       comboBox_1.addActionListener(new ActionListener() {
	    	   
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					comboBox_2.removeAllItems();
					DAO dd= new DAO();
					  ResultSet re =  dd.duqu1("major.majorname", "major","collegename",(String) comboBox_1.getSelectedItem());
					  try {
						while(re.next()) {
							comboBox_2.addItem(re.getString("majorname"));
							 System.out.println(re.getString("majorname"));
						  }
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
		
		panel_1.add(panelc3);
		
		JLabel lblNewLabel_7 = new JLabel("就业情况：");
		panelc3.add(lblNewLabel_7);
		panelc3.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("待业");
		rdbtnNewRadioButton_2.setSelected(true);
		panelc3.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("就业");
		panelc3.add(rdbtnNewRadioButton_3);
		panelc4.setVisible(false);
		
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				rdbtnNewRadioButton_3.setSelected(false);
					panelc4.setVisible(false);
			}
		});
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				rdbtnNewRadioButton_2.setSelected(false);		
					panelc4.setVisible(true);
			}
		});
		
		panel_1.add(panelc4);
		
		JLabel lblNewLabel_8 = new JLabel("职业编号：");
		panelc4.add(lblNewLabel_8);
		//修改
		//TextField textField_3 = new TextField(15);
		//panelc4.add(textField_3);
		JComboBox comboBox_11 = new JComboBox();
		 panelc4.add(comboBox_11);
		 {
			  DAO dd= new DAO();
			  ResultSet re =  dd.duqu("company.jobno", "company");
			  try {
				while(re.next()) {
					comboBox_11.addItem(re.getString("jobno"));
					 System.out.println(re.getString("jobno"));
				  }
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		  }
		
		
		
		JLabel lblNewLabel_9 = new JLabel("职业名称：");
		panelc4.add(lblNewLabel_9);
		
		//TextField textField_4 = new TextField(15);
		//panelc4.add(textField_4);
		JComboBox comboBox_22 = new JComboBox();
		 panelc4.add(comboBox_22);
		 
		 {
			  DAO dd= new DAO();
			  ResultSet re =  dd.duqu1("company.jobtype", "company","company.jobno",(String) comboBox_11.getSelectedItem());
			  try {
				while(re.next()) {
					comboBox_22.addItem(re.getString("jobtype"));
					 System.out.println(re.getString("jobtype"));
				  }
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		  }
		 
		 
		 
		 comboBox_11.addActionListener(new ActionListener() {
	    	   
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					comboBox_22.removeAllItems();
					DAO dd= new DAO();
					  ResultSet re =  dd.duqu1("company.jobtype", "company","company.jobno",(String) comboBox_11.getSelectedItem());
					  try {
						while(re.next()) {
							comboBox_22.addItem(re.getString("jobtype"));
							 System.out.println(re.getString("jobtype"));
						  }
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
		
		
		JLabel lblNewLabel_10 = new JLabel("公司名称：");
		panelc4.add(lblNewLabel_10);
		
		//TextField textField_5 = new TextField(15);
		//panelc4.add(textField_5);
		JComboBox comboBox_33 = new JComboBox();
		 panelc4.add(comboBox_33);
		 {
			  DAO dd= new DAO();
			  ResultSet re =  dd.duqu1("company.jobfrom", "company","company.jobno",(String) comboBox_11.getSelectedItem());
			  try {
				while(re.next()) {
					comboBox_33.addItem(re.getString("jobfrom"));
					 System.out.println(re.getString("jobfrom"));
				  }
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		  }
		 
		 
		 
		 
		 
		 
		 
		 comboBox_11.addActionListener(new ActionListener() {
	    	   
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					comboBox_33.removeAllItems();
					DAO dd= new DAO();
					  ResultSet re =  dd.duqu1("company.jobfrom", "company","company.jobno",(String) comboBox_11.getSelectedItem());
					  try {
						while(re.next()) {
							comboBox_33.addItem(re.getString("jobfrom"));
							 System.out.println(re.getString("jobfrom"));
						  }
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
		
		
		
		
		Panel panel_2 = new Panel();
		
		add(panel_2, BorderLayout.SOUTH);
		
		
		JButton btnNewButton = new JButton("添加学生信息");
		panel_2.add(btnNewButton);
		
		
		
		
		JButton btnNewButton_1 = new JButton("修改学生信息");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除学生信息");
		panel_2.add(btnNewButton_2);
		setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
		
		
		
		/*JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		TextField t2 = new TextField();
		panel.add(t2);
		
		TextField t1 = new TextField();
		panel.add(t1);*/
		//添加学生信息
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Student stu = new Student();
				stu.setNo(t1.getText().toString());
				stu.setName(textField.getText());
				stu.setSex(rdbtnNewRadioButton.isSelected()?"男":"女");
				stu.setBirth(textField_1.getText());
				stu.setFrom(textField_2.getText());
				stu.setMajorno((String) comboBox_2.getSelectedItem());
				stu.setCollegeno((String) comboBox_1.getSelectedItem());
				stu.setIsjob(rdbtnNewRadioButton_2.isSelected()?"待业":"已就业");
				stu.setJobno((String) comboBox_11.getSelectedItem());
				stu.setJobname((String) comboBox_22.getSelectedItem());
				stu.setJobfrom((String) comboBox_33.getSelectedItem());
				if(comboBox_11.getSelectedItem().equals(""))
					stu.setJobno("Null");
				if(comboBox_22.getSelectedItem().equals(""))
					stu.setJobname("Null");
				if(comboBox_33.getSelectedItem().equals(""))
					stu.setJobfrom("Null");
				System.out.println(stu.getJobno()+"aaa");
				System.out.println(stu.getJobname()+"aaaa");			
				System.out.println(stu.getJobfrom()+"aaaaa");
				DAO dao = new DAO();
				dao.add(stu);
				if(rdbtnNewRadioButton_3.isSelected()) {
					/**
					 * 要对就业岗位的数量进行修改，
					 */
				}
			}
		});
		
		
		//修改学生信息
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Student stu = new Student();
				stu.setNo(t1.getText().toString());
				stu.setName(textField.getText());
				stu.setSex(rdbtnNewRadioButton.isSelected()?"男":"女");
				stu.setBirth(textField_1.getText());
				stu.setFrom(textField_2.getText());
				stu.setMajorno((String) comboBox_2.getSelectedItem());
				stu.setCollegeno((String) comboBox_1.getSelectedItem());
				stu.setIsjob(rdbtnNewRadioButton_2.isSelected()?"待业":"已就业");
				stu.setJobno((String) comboBox_11.getSelectedItem());
				stu.setJobname((String) comboBox_22.getSelectedItem());
				stu.setJobfrom((String) comboBox_33.getSelectedItem());
				//stu.setJobno((String) comboBox_11.getSelectedItem());
				//stu.setJobname(textField_4.getText());
				//stu.setJobfrom(textField_5.getText());
				if(comboBox_11.getSelectedItem().equals(""))
					stu.setJobno("Null");
				if(comboBox_22.getSelectedItem().equals(""))
					stu.setJobname("Null");
				if(comboBox_33.getSelectedItem().equals(""))
					stu.setJobfrom("Null");
				System.out.println(stu.getJobno()+"aaa");
				System.out.println(stu.getJobname()+"aaaa");			
				System.out.println(stu.getJobfrom()+"aaaaa");
				DAO dao = new DAO();
				dao.delete(stu);
				dao.add(stu);
				if(rdbtnNewRadioButton_3.isSelected()) {
					/**
					 * 要对就业岗位的信息进行修改
					 */
				}
			}
		});
		
		
		//删除学生信息
				btnNewButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						Student stu = new Student();
						stu.setNo(t1.getText().toString());
						stu.setName(textField.getText());
						stu.setSex(rdbtnNewRadioButton.isSelected()?"男":"女");
						stu.setBirth(textField_1.getText());
						stu.setFrom(textField_2.getText());
						stu.setMajorno((String) comboBox_2.getSelectedItem());
						stu.setCollegeno((String) comboBox_1.getSelectedItem());
						stu.setIsjob(rdbtnNewRadioButton_2.isSelected()?"待业":"已就业");
						stu.setJobno((String)comboBox_11.getSelectedItem());
						stu.setJobname((String)comboBox_22.getSelectedItem());
						stu.setJobfrom((String)comboBox_33.getSelectedItem());
						System.out.println("aaaaaa"+stu.getNo()+"");
						DAO dao = new DAO();
						dao.delete(stu);
						if(rdbtnNewRadioButton_3.isSelected()) {
							/**
							 * 要对就业岗位的信息进行修改
							 */
						}
					}
				});
		

	}

}
