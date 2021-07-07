package window;

import javax.swing.JPanel;

import bean.Company;
import bean.Posion;
import dao.DAO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class Dengji extends JPanel {

	/**
	 * Create the panel.
	 */
	public Dengji() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("学生学号：");
		panel.add(lblNewLabel);
		
		TextField textField = new TextField(10);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("入职职业编号：");
		panel_1.add(lblNewLabel_1);
		
		TextField textField_1 = new TextField(10);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("确认登记");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Posion po = new Posion();
				po.setStuno(textField.getText());
				po.setJobno(textField_1.getText());
				DAO d1 = new DAO();
				try {
					d1.add2(po);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

	}

}
