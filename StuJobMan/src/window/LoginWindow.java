/**
 * 登录窗口
 */
package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.User;
import dao.UserDAO;

public class LoginWindow extends JFrame {
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static LoginWindow frame;

	/**
	 * 启动登陆界面
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new LoginWindow();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
});
	}

	/**
	 * 创建窗体
	 */
	public LoginWindow() {
		
		setTitle("登录界面");//设置窗口标题
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式
		
		setBounds(100, 100, 450, 300);//设置位置及大小
		
		JPanel pane = new JPanel();
				
		getContentPane().add(pane, BorderLayout.NORTH);
		
		JLabel labelbt = new JLabel("高校学生就业信息管理系统登陆界面");
		
		pane.setBackground(Color.yellow);
		
		pane.add(labelbt);
		
		
		
		
		contentPane = new JPanel();//创建一个容器
		
		
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		contentPane.setBackground(Color.green);
		
		
		
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//设置容器四周距离边框的空白像素
		
		//setContentPane(contentPane);//给窗体加上容器
		
		
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));//设置布局
		
		JLabel label = new JLabel("用户名：");//用户名
		contentPane.add(label);
		
		textField = new JTextField();//设置用户名的输入框
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码：");//密码
		contentPane.add(label_1);
		
		JPasswordField textField_1 = new JPasswordField();//设置密码框
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*') ;//设置会写，输入密码时显示*
		
		JButton button = new JButton("登录");//登录按钮
		button.addActionListener(new ActionListener() {//添加监听
			
			public void actionPerformed(ActionEvent e) {
				
				UserDAO dao = new UserDAO();//新建一个**对象
				
				User user = dao.check(textField.getText(), textField_1.getText());//验证登录名和密码
				
				if(textField.getText()==null) {
					JOptionPane.showMessageDialog(null, "请输入用户名！","提示信息", 1);
				}
				
				else if(textField_1.getText() == null) {
					JOptionPane.showMessageDialog(null, "请输入密码！","提示信息", 1);
				}
				
				else if(user==null) {//验证失败的情况
					
					JOptionPane.showMessageDialog(null, "用户名或者密码错误！","提示信息", 2);
					
				}
				
				else if (user != null) {//验证成功的情况
					
					EventQueue.invokeLater(new Runnable() {
						
						public void run() {
							
							try {
								
								Mainjm window = new Mainjm();//创建一个主窗口
								window.go();
								
								//window.MainWindow();
								//window.setVisible(true);//设置窗口可见
								
							} catch (Exception e) {
								
								System.out.println("主界面获取失败！");
								
								e.printStackTrace();
								
							}
							
						}
						
					});
				
					frame.setVisible(false);//设置登陆界面不可见
					
				}
				
			}
			
		});
		
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("重置");
		
		button_1.addActionListener(new ActionListener() {//为重置添加监听，清空输入框
			
			public void actionPerformed(ActionEvent e) {
			
				textField_1.setText("");//清空输入框
				
				textField.setText("");//清空输入框
				
				
			}
		});
		
		contentPane.add(button_1);
		getRootPane().setDefaultButton(button);
		
	}

}
