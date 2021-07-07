package window;

import javax.swing.JPanel;

import bean.Company;
import dao.DAO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Dengji1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Dengji1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("职位编号：");
		panel.add(lblNewLabel);
		
		TextField textField = new TextField(10);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("职位名称：");
		panel.add(lblNewLabel_1);
		
		TextField textField_1 = new TextField(10);
		panel.add(textField_1);
		
		Panel panel_1 = new Panel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("需求数量：");
		panel_1.add(lblNewLabel_2);
		
		TextField textField_2 = new TextField(10);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("已经聘用数量：");
		panel_1.add(lblNewLabel_3);
		
		TextField textField_3 = new TextField(10);
		panel_1.add(textField_3);
		
		Panel panel_2 = new Panel();
		add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("企业名称：");
		panel_2.add(lblNewLabel_4);
		
		TextField textField_4 = new TextField(10);
		panel_2.add(textField_4);
		
		JButton btnNewButton = new JButton("登记");
		panel_2.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Company com = new Company();
				com.setJobno(textField.getText());
				com.setJobtype(textField_1.getText());
				com.setNeed(textField_2.getText());
				com.setInneed(textField_3.getText());
				com.setJobfrom(textField_4.getText());
				DAO d2 = new DAO();
				d2.add2(com);
				
			}
		});
	}

}
