
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GreenWin extends JFrame implements ActionListener{

	JLabel play;
	
	GreenWin(){
		
		setSize (1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		play=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\GreenPlayerWon.png"));
		play.setSize(1024,768);
		add(play);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}