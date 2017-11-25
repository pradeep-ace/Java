
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddFrame extends JFrame
{
	Container c;
     JLabel lblRollno , lblName  ;
      JTextField txtRollno , txtName ;
    JButton btnSave , btnBack ;
     JPanel p1,p2;


     AddFrame()
     {
     	c = getContentPane();
     	p1 = new JPanel();
     	lblRollno = new JLabel("Rollno");
     	txtRollno = new JTextField(4);
     	lblName = new JLabel("Name");
     	txtName = new JTextField(10);

     	p1.add(lblRollno);
     	p1.add(txtRollno);
     	p1.add(lblName);
     	p1.add(txtName);
     	c.add(p1);

     	p2 = new JPanel();
     	btnSave = new JButton("save");
     	btnBack = new JButton("Back");
     	p2.add(btnBack);
     	p2.add(btnSave);
     	c.add("South" , p2);



     	 btnSave.addActionListener(new ActionListener()
	 {
	 	public void actionPerformed(ActionEvent ae)
	 	{

            try 
            {
	 		int rno = Integer.parseInt(txtRollno.getText());
	 		String name = txtName.getText();
	 		new DbHandler().addStudent(rno , name);
	 		txtRollno.setText("");
	 		txtName.setText("");
	 		txtRollno.requestFocus();
        }

            catch(NumberFormatException e){
  JOptionPane.showMessageDialog(new JDialog(), "Enter proper roll no. and name");
  txtRollno.requestFocus();
  txtName.requestFocus();
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
      setTitle("Add St");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);



     }
 }
