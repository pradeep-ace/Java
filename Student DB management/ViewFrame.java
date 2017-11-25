
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame
{
	Container c;
     
      TextArea txtData;
    JButton  btnBack ;
     JPanel p1,p2;

     ViewFrame()
     {
     		c = getContentPane();

     		p1 = new JPanel();
     		txtData = new TextArea(5,30);
     		p1.add(txtData);
     		c.add(p1);


     		p2 = new JPanel();
     		btnBack = new JButton("Back");
     		p2.add(btnBack);
     		c.add("South" , p2);


     		txtData.setText(new DbHandler().viewStudent());

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
      setTitle("View st");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
     }
 }
