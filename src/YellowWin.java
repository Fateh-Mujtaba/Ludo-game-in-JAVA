
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class YellowWin extends JFrame implements ActionListener{

	JLabel play;
	YellowWin(){
		
		setSize (1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		play=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\YellowPlayerWon.png"));
		play.setSize(1024,768);
		add(play);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}