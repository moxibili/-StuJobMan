package window;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.Student;
import dao.DAO;
import java.awt.BorderLayout;
import java.awt.ScrollPane;

public class Chaxun1 extends JPanel {
	private String[] headers = new String[] { "学号", "姓名", "性别", "出生年月", "籍贯", "专业", "学院名称" ,"是否就业"};
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public Chaxun1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		table_1 = new JTable();
		JScrollPane jp = new JScrollPane(table_1);
		
		panel.add(jp);
		//setLayout(new BorderLayout(0, 0));
		


		String sql = "select * from student where 1=1 ";
	       DAO da1 = new DAO();
	       ArrayList<Student> students = da1.list(sql);
	       String[][] datas = new String[students.size()][8];
			for (int i = 0; i < students.size(); i++) {
				datas[i][0] = students.get(i).getNo();
				datas[i][1] = students.get(i).getName();
				datas[i][2] = students.get(i).getSex();
				datas[i][3] = students.get(i).getBirth();
				datas[i][4] = students.get(i).getFrom();
				datas[i][5] = students.get(i).getMajorno();
				datas[i][6] = students.get(i).getCollegeno();	
				datas[i][7] = students.get(i).getIsjob();	
				
			}
			table_1.setModel(new DefaultTableModel(datas, headers));
	}

}
