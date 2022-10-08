import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
public class Progressbar extends JFrame{
	JProgressBar jb;    
    JLabel background;
    JLabel center;
    int i=0,num=0;     
	Progressbar(){  
		setSize(1024,791);
//		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		UIManager.put("ProgressBar.background", Color.BLACK);
		UIManager.put("ProgressBar.foreground", Color.RED);  
		background=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\Loadingbarpage.png"));
		background.setSize(1024,735);
		jb=new JProgressBar(0,2000);    
		jb.setBounds(1,733,1024,20);         
		jb.setValue(0);    
		jb.setStringPainted(true);    
		add(background);
		add(jb);      
	}    
	
	public void iterate(){    
		while(i<=2000){    
			jb.setValue(i);    
			i=i+20;    
			try{
				Thread.sleep(50);
	  		}catch(Exception e){}    
		}
	}
}