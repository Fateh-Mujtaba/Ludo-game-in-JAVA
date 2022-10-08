import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
public class Introduction  extends JFrame implements ActionListener{
	JButton play,about;
	JLabel background;
	JPanel bg;
	
	Introduction(){
		setSize (1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		bg=new JPanel();
		bg.setSize(1024, 768);
		bg.setBackground(Color.black);
		
		background=new JLabel(new ImageIcon("BACKGROUND.jpg"));
		background.setSize(1024,768);
		play=new JButton(new ImageIcon("D:\\bS CS IV\\Project\\Images\\play.jpg"));
		play.setBounds(250,300 , 200, 200);
		about=new JButton(new ImageIcon("D:\\bS CS IV\\Project\\Images\\game about.jpg"));
		about.setBounds(500, 300, 200, 200);
		add(play);
		add(about);
		add(background);
		add(bg);
		play.addActionListener(this);
		about.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play)
		{   this.setVisible(false);			
			PlayerOption p=new PlayerOption();
			p.setVisible(true);
		}
		else if(e.getSource()==about)
		{
			this.setVisible(false);
			AboutUs a= new AboutUs();
			a.setVisible(true);
			
		}
	}

}
