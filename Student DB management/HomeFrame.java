
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class HomeFrame extends JFrame
{
	Container c;
    
    JButton btnAdd , btnUpdate , btnDelete , btnView;
    

    HomeFrame()
    {
    	c = getContentPane();
	c.setLayout(new FlowLayout());
	btnAdd = new JButton("Add");
	btnUpdate = new JButton("Update");
	btnDelete = new JButton("Delete");
	btnView = new JButton("View");

	c.add(btnAdd);
	c.add(btnUpdate);
	c.add(btnDelete);
	c.add(btnView);



	 btnAdd.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		AddFrame a = new AddFrame();
	 		dispose();
	 	}
	 }
	 );


	  btnView.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		ViewFrame a = new ViewFrame();
	 		dispose();
	 	}
	 }
	 );

	  btnUpdate.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		UpdateFrame a = new UpdateFrame();
	 		dispose();
	 	}
	 }
	 );


	   btnDelete.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		DeleteFrame a = new DeleteFrame();
	 		dispose();
	 	}
	 }
	 );




	  setSize(350, 200);
      setTitle("SMS");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


    }


    public static void main(String args[])
    {
    	HomeFrame h = new HomeFrame();

    }
}



 class DbHandler 
 {
 	static Connection c;

 	public static void getConn()
 	{
 		try
 		{
 			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
 			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "pradeep");

 		}

 		catch(SQLException e)
 		{
 			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
 		}
 	}



 	public void addStudent(int rno , String name)
 	{
 		getConn();
 		try
 		{
 			String sql = "insert into student values(? , ?)";
 			PreparedStatement ps = c.prepareStatement(sql);
 			ps.setInt(1, rno);
 			ps.setString(2 , name);
 			int r = ps.executeUpdate();
 			JOptionPane.showMessageDialog(new JDialog(), r + "record inserted" );

 		}

 		catch(SQLException e)
 		{
 			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
 		}
 	}

     

      public String viewStudent()
 	{
 		getConn();
 		StringBuffer sb = new StringBuffer();
 		try
 		{
 			String sql = "select * from student";
 			Statement stmt = c.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next())

 			sb.append("RollNo :-  " + rs.getInt(1) + "      Name :-  " + rs.getString(2) + "\n");
 		    rs.close();

 		}

 		catch(SQLException e)
 		{
 			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
 		}
 		return sb.toString();
 	}


 	public void updateStudent(int rno , String name)
 	{
 		getConn();
 		try
 		{
 			String sql = "update student set name = ? where rno = ?";
 			PreparedStatement ps = c.prepareStatement(sql);
 			ps.setString(1,name);
 			ps.setInt(2 , rno);
 			int r = ps.executeUpdate();
 			JOptionPane.showMessageDialog(new JDialog(), r + "record updated" );

 		}

 		catch(SQLException e)
 		{
 			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
 		}
 	}


 	public void deleteStudent(int rno )
 	{
 		getConn();
 		try
 		{
 			String sql = "delete from student where rno = ?";
 			PreparedStatement ps = c.prepareStatement(sql);
 			ps.setInt(1 , rno);
 			int r = ps.executeUpdate();
 			JOptionPane.showMessageDialog(new JDialog(), r + "rows delete" );

 		}

 		catch(SQLException e)
 		{
 			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
 		}
 	}



 }
