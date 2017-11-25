

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class DeleteFrame extends JFrame
{
	Container c;
     JLabel lblRollno   ;
      JTextField txtRollno  ;
    JButton btnDelete , btnBack ;
     JPanel p1,p2;

      DeleteFrame()
     {
     	c = getContentPane();
     	p1 = new JPanel();
     	lblRollno = new JLabel("Rollno");
     	txtRollno = new JTextField(4);
     	

     	p1.add(lblRollno);
     	p1.add(txtRollno);
     	
     	c.add(p1);

     	p2 = new JPanel();
     	btnDelete = new JButton("Delete");
     	btnBack = new JButton("Back");
     	p2.add(btnBack);
     	p2.add(btnDelete);
     	c.add("South" , p2);

     	 btnDelete.addActionListener(new ActionListener()
	 {

	 	public void actionPerformed(ActionEvent ae)
	 	{
	 	try{

	 		int rno = Integer.parseInt(txtRollno.getText());
	 		
	 		new DbHandler().deleteStudent(rno );
	 		txtRollno.setText("");
	 		
	 		txtRollno.requestFocus();
	 	}

	 	catch(NumberFormatException e){
  JOptionPane.showMessageDialog(new JDialog(), "Enter proper roll no");
  txtRollno.requestFocus();
 // txtName.requestFocus();
  return;
}
	 }
	}
	 );


     	  btnBack.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		HomeFrame a = new HomeFrame();
	 		dispose();
	 	}
	 }
	 );


     	   setSize(350, 200);
      setTitle("Delete st");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


 }
 }
