package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.xdevapi.Result;

import bean.Company;
import bean.Posion;
import bean.Student;
import util.DBConnection;

public class DAO {
	private Connection conn = null;
	private Statement st = null;
	
public DAO() {
		
		conn = DBConnection.getConnection();//连接数据库
		
		try {
			
			st = conn.createStatement();//依赖于connection创建statement对象
			
		} catch (SQLException e) {
			
			System.out.println("连接到数据库失败！");
			
			e.printStackTrace();
		}
	}



public void close() {
	
	try {
		
		st.close();
		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	}
}


//添加学生信息

public void add(Student stu) {
	String sql = "insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
			+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"','"+stu.getJobno()+"','"+stu.getJobname()+"','"+stu.getJobfrom()+"')";
	String sql1 = "insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
	+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"',Null,Null,Null)";
	
	
	System.out.println("insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
			+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"','"+stu.getJobno()+"','"+stu.getJobname()+"','"+stu.getJobfrom()+"')");
	if(stu.getIsjob()=="待业")
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "输入的信息格式有误！添加失败!","提示信息", 2);
			//e.printStackTrace();
		}
	else
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "输入的信息格式有误！添加失败!","提示信息", 2);
		//e.printStackTrace();
	}
}
//修改学生信息
/*public void update(Student stu) {
	String sql = "update student set(no='" + stu.getNo() + "',name='" + stu.getName() + "',sex='" + stu.getSex()
			+ "',birth='" + stu.getBirth() + "',from='" + stu.getFrom() + "',majorno='" + stu.getMajorno() + "',collegeno='" + stu.getCollegeno() + "',isjob='" + stu.getIsjob() +"') where no = "+stu.getNo()+"";
	System.out.println( "update student set(no='" + stu.getNo() + "',name='" + stu.getName() + "',sex='" + stu.getSex()
	+ "',birth='" + stu.getBirth() + "',from='" + stu.getFrom() + "',majorno='" + stu.getMajorno() + "',collegeno='" + stu.getCollegeno() + "',isjob='" + stu.getIsjob() +"') where no = "+stu.getNo()+"");
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "输入的信息格式有误！添加失败!","提示信息", 2);
		//e.printStackTrace();
	}
}*/

//删除学生信息
public void delete(Student stu) {
	String sql = "delete from student where no = " + stu.getNo() + "";
	System.out.println("delete from student where no = " + stu.getNo() + "");
	try {
		st.executeUpdate(sql);
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "输入的信息格式有误！删除失败!","提示信息", 2);
		//e.printStackTrace();
	}
}

//添加职位信息
public void add1(Posion po) {
	String sql = "insert into posion values('" + po.getStuno() + "','" + po.getJobno() +"')";
	System.out.println("insert into posion values('" + po.getStuno() + "','" + po.getJobno() +"')");
	
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "输入的信息格式有误！添加失败!","提示信息", 2);
		//e.printStackTrace();
	}
}

public void add2(Posion po) throws SQLException {
	String sql = "select * from company where jobno='"+po.getJobno()+"'";
	System.out.println("select * from company where jobno='"+po.getJobno()+"'");
	
	String jobno = null;
	String jobtype = null;
	String need =null;
	String inneed =null;
	String jobfrom =null;
	String isjob="已就业";
	
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
	
	while (rs.next()) {
		
		 jobno=rs.getString("jobno");
		 jobtype=rs.getString("jobtype");
		 need=rs.getString("need");
		 inneed=rs.getString("inneed");
		 jobfrom=rs.getString("jobfrom");
		 
		
	}
	System.out.println(jobno);
	System.out.println(jobtype);
	System.out.println(need);
	System.out.println(inneed);
	System.out.println(jobfrom);
	String sql1 = "update student set jobno='"+jobno+"',isjob='"+isjob+"',jobtype='"+jobtype+"',jobfrom='"+jobfrom+"' where no='"+po.getStuno()+"'";
	System.out.println("update student set jobno='"+jobno+"',isjob='"+isjob+"',jobtype='"+jobtype+"',jobfrom='"+jobfrom+"'where no='"+po.getStuno()+"'");
	try {
		st.executeUpdate(sql1);
		JOptionPane.showMessageDialog(null, "修改就业状态成功！","提示信息", 2);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "修改就业状态失败！请重试！","提示信息", 2);
		//e.printStackTrace();
	}
	rs.close();
	
	
	
	
	
	
	//String sql1 = "update student set jobno="++",jobtype=",++"jobfrom=";
	
}

//查询
public ResultSet duqu(String n,String m) {
	String sql ="select "+ n +" from " + m ;
	System.out.println(sql);
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
	
	return rs;
}


//查询1
public ResultSet duqu1(String n,String m,String x,String y) {
	String sql ="select "+ n +" from " + m +" where " + x +" = " + "'"+y+"'";
	System.out.println(sql);
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
	
	return rs;
}

//已经就业信息
public ResultSet yijiuye(String st1,String st2) {
	ResultSet rs = null;
	try {
		java.sql.CallableStatement proc = conn.prepareCall("{ call yijiuye(?,?) }");
		proc.setString(1,st1);
		proc.setString(2,st2);
		boolean bl = proc.execute();//-----执行存储过程
		rs=proc.getResultSet();//----取得一个结果集，
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}

	return rs;
}


//未就业信息
public ResultSet weijiuye() {
	
	
	return null;
}



//存储过程查询所有人数
public String ccgc1() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuall() }");
	boolean bl = proc.execute();//-----执行存储过程
		if	(bl){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
		ResultSet rs=proc.getResultSet();//----取得一个结果集，
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- 随便输出一个值。
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}

//查询未就业人数
public String ccgc2() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stunojob() }");
	boolean bl = proc.execute();//-----执行存储过程
		if	(bl){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
		ResultSet rs=proc.getResultSet();//----取得一个结果集，
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- 随便输出一个值。
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}

//查询已经就业人数
public String ccgc3() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuisjob() }");
	boolean bl = proc.execute();//-----执行存储过程
		if	(bl){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
		ResultSet rs=proc.getResultSet();//----取得一个结果集，
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- 随便输出一个值。
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}


public String ccgc4(String st1) throws SQLException {
	float s =0;
	float b =0;
	String s1="";
	 System.out.println(st1);
	/*java.sql.CallableStatement proc = conn.prepareCall("{ call dfjiuyelv(?,?) }");
	 proc.setString(1,st1);
	boolean bl = proc.execute();//-----执行存储过程
		if	(bl){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
		ResultSet rs=proc.getResultSet();//----取得一个结果集，
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- 随便输出一个值。
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getFloat(1);
	       break;
	       }
	    }
	}*/
	 String sql ="select count(*) from student where collegeno ='"+st1+"'and isjob='已就业'" ;
	 System.out.println("select count(*) from student where collegeno ='"+st1+"'and isjob='已就业'");
		System.out.println(sql);
		ResultSet rs = null;
		try {
			 rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		 while(rs.next()){
		       System.out.println(rs.getInt(1));//--- 随便输出一个值。
		       if(rs.getInt(1) != 0)
		       {
		       b= rs.getFloat(1);
		       break;
		       }
		    }
		
		 String sql2 ="select count(*) from student where collegeno ='"+st1+"'" ;
		 System.out.println("select count(*) from student where collegeno ='"+st1+"'");
			System.out.println(sql2);
			ResultSet rs1 = null;
			try {
				 rs1 = st.executeQuery(sql2);
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
			 while(rs1.next()){
			       System.out.println(rs1.getInt(1));//--- 随便输出一个值。
			       if(rs1.getInt(1) != 0)
			       {
			       s= rs1.getFloat(1);
			       break;
			       }
			    }
		 
		 
		
	 
	return b/s*100+"%";
	 
	 
}


public String ccgc5() throws SQLException {
	float s =0;
	float b =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuisjob() }");
	boolean bl = proc.execute();//-----执行存储过程
		if	(bl){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
		ResultSet rs=proc.getResultSet();//----取得一个结果集，
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- 随便输出一个值。
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getFloat(1);
	       break;
	       }
	    }
	}
	java.sql.CallableStatement proc1 = conn.prepareCall("{ call stuall() }");
	boolean b2 = proc1.execute();//-----执行存储过程
			if	(b2){//----若存储过程成功执行了，并且有结果集返回了，那么bl就是true
			ResultSet rs=proc1.getResultSet();//----取得一个结果集，
		     while(rs.next()){
		       System.out.println(rs.getInt(1));//--- 随便输出一个值。
		       if(rs.getInt(1) != 0)
		       {
		       b= rs.getFloat(1);
		       break;
		       }
		    }
		}
			s=s/b*100;
	return s1+s+"%";
}

 



public void add2(Company com) {
	String sql = "insert into company values('" + com.getJobno() + "','" + com.getJobtype() +"','" + com.getNeed() +"','" + com.getInneed() +"','" + com.getJobfrom() +"')";
	System.out.println( "insert into posion values('" + com.getJobno() + "','" + com.getJobtype() +"','" + com.getNeed() +"','" + com.getInneed() +"','" + com.getJobfrom() +"')");
	
	try {
		st.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "添加成功！","提示信息", 2);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "输入的信息格式有误！添加失败!","提示信息", 2);
		//e.printStackTrace();
	}
}



/**
 * 按sql语句查找学生的信息
 * 
 */
public ArrayList<Student> list(String sql) {
	
	ArrayList<Student> students = new ArrayList<>();//创建一个学生信息的集合，将所有数据放入students里
	
	try {
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			Student stu = new Student();
			
			stu.setNo(rs.getString("no"));
			
			stu.setName(rs.getString("name"));
			
			stu.setSex(rs.getString("sex"));
			
			stu.setBirth(rs.getString("birth"));
			
			stu.setFrom(rs.getString("from"));
			
			stu.setMajorno(rs.getString("majorno"));
			
			stu.setCollegeno(rs.getString("collegeno"));
			
			stu.setIsjob(rs.getString("isjob"));
			
			stu.setJobno(rs.getString("jobno"));
			
			stu.setJobname(rs.getString("jobtype"));
			
			stu.setJobfrom(rs.getString("jobfrom"));
			
			students.add(stu);
			
		}
		
		rs.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
		
	}
	return students;
}




public ArrayList<Company> list1(String sql) {
	
	ArrayList<Company> company = new ArrayList<>();//创建一个学生信息的集合，将所有数据放入company里
	
	try {
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			Company com = new Company();
			
			com.setJobno(rs.getString("jobno"));
			
			com.setJobtype(rs.getString("jobtype"));
			
			com.setNeed(rs.getString("need"));
			
			com.setInneed(rs.getString("inneed"));
			
			com.setJobfrom(rs.getString("jobfrom"));
			
			
			
			company.add(com);
			
		}
		
		rs.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
		
	}
	return company;
}



}
