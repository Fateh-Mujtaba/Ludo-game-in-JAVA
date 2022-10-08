import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PlayerOption extends JFrame implements ActionListener{
		JButton player2;
		JButton player4;
		JPanel background;
		JButton back;
		
		PlayerOption(){
		setSize (1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		back=new JButton();
		back.setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\back.jpg"));
		back.setBounds(0, 0, 96, 96);
		
		background=new JPanel();
		background.setSize(1024,768);
		background.setBackground(Color.black);
		
		player2=new JButton(new ImageIcon("D:\\bS CS IV\\Project\\Images\\2players.jpg"));	
		player2.setBounds(250,250,200,200);     
		player4=new JButton(new ImageIcon("D:\\bS CS IV\\Project\\Images\\4players.jpg"));
		player4.setBounds(500,250,200,200);
		add(player2);  
	    add(player4);
	    add(background);
	    add(back);
	    player2.addActionListener(this);
	    player4.addActionListener(this);
	    back.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==back)
			{			
				this.setVisible(false);
				Introduction in=new Introduction();
		    	in.setVisible(true);
			}
			
			if(e.getSource()==player2)
			{
				this.setVisible(false);      
				Ludo2 l=new Ludo2();
				l.setVisible(true);
			}
			
			else if(e.getSource()==player4)
			{
				this.setVisible(false);      
				Ludo4 l=new Ludo4();
				l.setVisible(true);
			}
		}

}