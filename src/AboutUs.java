import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class AboutUs extends JFrame implements ActionListener{
	JLabel about;
	JButton back;
	AboutUs(){
		setSize (1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);	
		
		about=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\about us.jpg"));
		about.setSize(1024,768);	
		back=new JButton(new ImageIcon("D:\\bS CS IV\\Project\\Images\\back.jpg"));
		back.setBounds(200, 50, 100, 100);
		back.addActionListener(this);
		add(about);
		add(back);
	}	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back)
		{			
			this.setVisible(false);
			Introduction in=new Introduction();
	    	in.setVisible(true);
		}
	
	}
}