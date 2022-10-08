import javax.swing.ImageIcon;

public class Test {
	public static void main(String args[])
{
	Progressbar p1=new Progressbar();		
	p1.setVisible(true);
		p1.iterate();
     	for(int i=0;i<=2000;i=i+20)
		{    
		       if(i==2000)
		       {
		    	 p1.setVisible(false);
		    	 Introduction intr=new Introduction();
		    	 intr.setVisible(true);
		       }
		}   
		
		
			
			
}
}
