import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Ludo2 extends JFrame implements ActionListener{
	
	JTextField [][]Y=new JTextField [6][3];
	JTextField [][]G=new JTextField [3][6];
	JTextField [][]B=new JTextField [3][6];
	JTextField [][]R=new JTextField [6][3];
	
	JLabel center;
	JLabel red;
	JLabel yellow;
	JLabel green;
	JLabel blue;
	JButton y,r;
	JButton back=new JButton();
	
	int rx=479, ry=600, rx1=rx, rx2=rx, rx3=rx, ry1=ry, ry2=ry, ry3=ry;
	int yx=545, yy=128, yx1=yx, yx2=yx, yx3=yx, yy1=yy, yy2=yy, yy3=yy;
	
	final int width=25,height=25;
	JButton []redpiece=new JButton[4];
	JButton []yellowpiece=new JButton[4];
	int redcount[]= {-5,-5,-5,-5};
	int yellowcount[]= {-5,-5,-5,-5};
	
	boolean rpiece=false, ypiece=false;
	JPanel py;
	JPanel pg;
	JPanel pr;
	JPanel pb;
	int turn=0,dice=0,rwin=0,ywin=0,turn1=0;
	Ludo2(){
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		back.setBounds(0, 0, 96, 96);
		back.setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\back.jpg"));
		
		JPanel background=new JPanel();
		background.setSize(1024, 768);
		background.setBackground(Color.black);	
		
		red=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\Red.jpg"));
		yellow=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\yellow.JPG"));
		green=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\green.JPG"));
		blue=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\blue.JPG"));
		center=new JLabel(new ImageIcon("D:\\bS CS IV\\Project\\Images\\ludocenter.JPG"));
		center.setBounds(477,329,97,90);
		red.setBounds(223,424,250,250);
		yellow.setBounds(577,75,250,250);
		blue.setBounds(578,424,250,250);
		green.setBounds(223,75,250,250);
		
		py=new JPanel(new GridLayout(6,3));
		pr=new JPanel(new GridLayout(6,3));
		pg=new JPanel(new GridLayout(3,6));
		pb=new JPanel(new GridLayout(3,6));
		
		r=new JButton();
		y=new JButton();
		r.setBounds(125,600,50,50);
		y.setBounds(875,77,50,50);
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<3;j++) {
				Y[i][j]=new JTextField();
				R[i][j]=new JTextField();
				Y[i][j].setEnabled(false);
				R[i][j].setEnabled(false);
				py.add(Y[i][j]);
				pr.add(R[i][j]);
				if((i==1&&j!=0)||(i!=0&&j==1))
					Y[i][j].setBackground(Color.yellow);
				if((i!=5&&j==1)||(i==4&&j!=2))
					R[i][j].setBackground(Color.red);	
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<6;j++) {	
				G[i][j]=new JTextField();
				B[i][j]=new JTextField();
				G[i][j].setEnabled(false);
				B[i][j].setEnabled(false);
			
				pg.add(G[i][j]);
				pb.add(B[i][j]);
				if((j==1&&i!=2)||(i==1&&j!=0))
					G[i][j].setBackground(Color.green);
				if((i!=0&&j==4)||(i==1&&j!=5))
					B[i][j].setBackground(Color.blue);	
			}	
		}
		py.setBounds(473,77,105,250);
		pr.setBounds(473,422,105,250);
		pg.setBounds(225,325,250,100);
		pb.setBounds(575,325,250,100);
		for(int i=0;i<4;i++) {
			redpiece[i]=new JButton();
			redpiece[i].addActionListener(this);
			if(i==0)
				redpiece[i].setBounds(303,504,width,height);
			else if(i==1)
				redpiece[i].setBounds(353,504,width,height);	
			else if(i==2)
				redpiece[i].setBounds(303,554,width,height);
			else if(i==3)
				redpiece[i].setBounds(353,554,width,height);	
			add(redpiece[i]);
			redpiece[i].setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\red piece.jpg"));
		}
		for(int i=0;i<4;i++) {
			yellowpiece[i]=new JButton();
			yellowpiece[i].addActionListener(this);
			if(i==0)
				yellowpiece[i].setBounds(657,155,width,height);
			else if(i==1)
				yellowpiece[i].setBounds(707,155,width,height);	
			else if(i==2)
				yellowpiece[i].setBounds(657,205,width,height);
			else if(i==3)
				yellowpiece[i].setBounds(707,205,width,height);	
			add(yellowpiece[i]);
			yellowpiece[i].setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\yellowpiece.jpg"));
		}
	
		add(py);
		add(pr);
		add(pb);
		add(pg);
		add(red);
		add(green);
		add(blue);
		add(yellow);
		add(center);
		add(r);
		add(y);
		add(background);
		add(back);
		r.setBackground(Color.red);
		r.addActionListener(this);
		y.addActionListener(this);
		back.addActionListener(this);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back)
		{			
			this.setVisible(false);
			Introduction in=new Introduction();
	    	in.setVisible(true);
		}
		
		if(turn%2==0) {
			if(turn1%2==0) {
				if(e.getSource()==r) {
				
				dice=(int)(Math.random()*6)+1;
				
				if(dice!=6)
				{if(((redpiece[0].getBounds().x==303&&redpiece[0].getBounds().y==504)||(redpiece[0].getBounds().x==512&&redpiece[0].getBounds().y==395))&&((redpiece[1].getBounds().x==353&&redpiece[1].getBounds().y==504)||(redpiece[1].getBounds().x==512&&redpiece[1].getBounds().y==395))&&((redpiece[2].getBounds().x==303&&redpiece[2].getBounds().y==554)||(redpiece[2].getBounds().x==512&&redpiece[2].getBounds().y==395))&&((redpiece[3].getBounds().x==353&&redpiece[3].getBounds().y==554)||(redpiece[3].getBounds().x==512&&redpiece[3].getBounds().y==395)))
					{rpiece=false;
					}
					if(dice==1) 
					r.setText("1");
				else if(dice==2) 
					r.setText("2");
				else if(dice==3) 
					r.setText("3");
				else if(dice==4) 
					r.setText("4");
				else if(dice==5) 
					r.setText("5");
					
				}
				else {
					r.setText("6");
					rpiece=true;
				}
				if(!rpiece) {
					turn++;
					y.setBackground(Color.yellow);
					r.setBackground(Color.white);
					}
				turn1++;
				}
			
			}
			if(rpiece==true) {
				if(e.getSource()==redpiece[0]) {
					if(dice==6)
						turn1++;
					else if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					r.setBackground(Color.white);
						}
					if(redcount[0]+dice<57)	
					redcount[0]+=dice;
					if(redcount[0]<1)
						redcount[0]=-5;
					else if(redcount[0]==1)
						{redpiece[0].setBounds(rx, ry,width , height);}
					
					else if(redcount[0]>1) {
					for(int t=redcount[0]-dice;t<redcount[0];t++) {
					if(t>0&&t<5) {
						ry-=41;
					}
					else if(t==5)
					{rx-=41;
					ry-=41;}
					else if(t<11)
						rx-=41;
					else if(t<13)
						ry-=31;
					else if(t<18)
						rx+=41;
					else if(t==18) {
						rx+=41;
						ry-=41;
					}
					else if(t<24)
						ry-=41;
					else if(t<26)
						rx+=33;
					else if(t<31)
						ry+=41;
					else if(t==31) {
						rx+=41;
						ry+=41;
					}
					else if(t<37)
						rx+=41;
					else if(t<39) 
						ry+=31;
					else if(t<44)
						rx-=41;
					else if(t==44) {
						rx-=41;
						ry+=41;
						}
					else if(t<50)
						ry+=41;
					else if(t==50) 
						rx-=33;
					else if(t<56)
						ry-=41;
					else if(t==56)
						{ry-=41;
						}
					
					}
					redpiece[0].setBounds(rx, ry,width , height);
					}
					dice=0;
					rwin=0;
					for(int i=0;i<4;i++) {
						if(redpiece[i].getBounds().x==512&&redpiece[i].getBounds().y==395)
						rwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else {	
						
						if(redpiece[0].getBounds().x==yellowpiece[i].getBounds().x&&redpiece[0].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
							yellowpiece[i].setBounds(657,155,width,height);
							yx=545;
							yy=128;
									}
							else if(i==1) {
							yellowpiece[i].setBounds(707,155,width,height);
							yx1=545;
							yy1=128;}
							else if(i==2)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx2=545;
								yy2=128;}
							else if(i==3)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx3=545;
								yy3=128;}	
							yellowcount[i]=-5;
						}
					}
						}
						if(rwin==4)
						{this.setVisible(false);
						RedWin a=new RedWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==redpiece[1]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					r.setBackground(Color.white);
						}
					if(redcount[1]+dice<57)	
						redcount[1]+=dice;
						if(redcount[1]<1)
						redcount[1]=-5;
						else if(redcount[1]==1)
					redpiece[1].setBounds(rx1, ry1,width , height);	
				else if(redcount[1]>1) {
				for(int t=redcount[1]-dice;t<redcount[1];t++) {
				if(t>0&&t<5) {
					ry1-=41;
				}
				else if(t==5)
				{rx1-=41;
				ry1-=41;}
				else if(t<11)
					rx1-=41;
				else if(t<13)
					ry1-=31;
				else if(t<18)
					rx1+=41;
				else if(t==18) {
					rx1+=41;
					ry1-=41;
				}
				else if(t<24)
					ry1-=41;
				else if(t<26)
					rx1+=33;
				else if(t<31)
					ry1+=41;
				else if(t==31) {
					rx1+=41;
					ry1+=41;
				}
				else if(t<37)
					rx1+=41;
				else if(t<39) 
					ry1+=31;
				else if(t<44)
					rx1-=41;
				else if(t==44) {
					rx1-=41;
					ry1+=41;
					}
				else if(t<50)
					ry1+=41;
				else if(t==50) 
					rx1-=33;
				else if(t<56)
					ry1-=41;
				else if(t==56)
					{ry1-=41;
					}
				}
				redpiece[1].setBounds(rx1, ry1,width , height);
				}
				dice=0;
				rwin=0;
				for(int i=0;i<4;i++) {
					if(redpiece[i].getBounds().x==512&&redpiece[i].getBounds().y==395)
					rwin++;
					if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
					{
						
					}
					else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else {	
					if(redpiece[1].getBounds().x==yellowpiece[i].getBounds().x&&redpiece[1].getBounds().y==yellowpiece[i].getBounds().y)
					{
						if(i==0) {
							yellowpiece[i].setBounds(657,155,width,height);
							yx=545;
							yy=128;
									}
							else if(i==1) {
							yellowpiece[i].setBounds(707,155,width,height);
							yx1=545;
							yy1=128;}
							else if(i==2)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx2=545;
								yy2=128;}
							else if(i==3)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx3=545;
								yy3=128;}	
							yellowcount[i]=-5;
						}
				}
				}
					if(rwin==4)
					{this.setVisible(false);
					RedWin a=new RedWin();
						a.setVisible(true);	
						
					}
					
			
				}
				if(e.getSource()==redpiece[2]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					r.setBackground(Color.white);
						}
					if(redcount[2]+dice<57)	
						redcount[2]+=dice;
						if(redcount[2]<1)
							redcount[2]=-5;
						else if(redcount[2]==1)
					redpiece[2].setBounds(rx2, ry2,width , height);	
				else if(redcount[2]>1) {
				for(int t=redcount[2]-dice;t<redcount[2];t++) {
				if(t>0&&t<5) {
					ry2-=41;
				}
				else if(t==5)
				{rx2-=41;
				ry2-=41;}
				else if(t<11)
					rx2-=41;
				else if(t<13)
					ry2-=31;
				else if(t<18)
					rx2+=41;
				else if(t==18) {
					rx2+=41;
					ry2-=41;
				}
				else if(t<24)
					ry2-=41;
				else if(t<26)
					rx2+=33;
				else if(t<31)
					ry2+=41;
				else if(t==31) {
					rx2+=41;
					ry2+=41;
				}
				else if(t<37)
					rx2+=41;
				else if(t<39) 
					ry2+=31;
				else if(t<44)
					rx2-=41;
				else if(t==44) {
					rx2-=41;
					ry2+=41;
					}
				else if(t<50)
					ry2+=41;
				else if(t==50) 
					rx2-=33;
				else if(t<56)
					ry2-=41;
				else if(t==56)
					{ry2-=41;
					}
				}
				redpiece[2].setBounds(rx2, ry2,width , height);
				}
				dice=0;
				rwin=0;
				for(int i=0;i<4;i++) {
					if(redpiece[i].getBounds().x==512&&redpiece[i].getBounds().y==395)
					rwin++;
					if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
					{
						
					}
					else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else {	
					
					if(redpiece[2].getBounds().x==yellowpiece[i].getBounds().x&&redpiece[2].getBounds().y==yellowpiece[i].getBounds().y)
					{
						if(i==0) {
							yellowpiece[i].setBounds(657,155,width,height);
							yx=545;
							yy=128;
									}
							else if(i==1) {
							yellowpiece[i].setBounds(707,155,width,height);
							yx1=545;
							yy1=128;}
							else if(i==2)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx2=545;
								yy2=128;}
							else if(i==3)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx3=545;
								yy3=128;}	
							yellowcount[i]=-5;

					}		
					}
				}
					if(rwin==4)
					{this.setVisible(false);
					RedWin a=new RedWin();
						a.setVisible(true);	
						
					}
					
			
				}
				if(e.getSource()==redpiece[3]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					r.setBackground(Color.white);
						}
					if(redcount[3]+dice<57)	
						redcount[3]+=dice;
						if(redcount[3]<1)
							redcount[3]=-5;
				if(redcount[3]==1)
					redpiece[3].setBounds(rx3, ry3,width , height);	
				else if(redcount[3]>1) {
				for(int t=redcount[3]-dice;t<redcount[3];t++) {
				if(t>0&&t<5) {
					ry3-=41;
				}
				else if(t==5)
				{rx3-=41;			ry3-=41;}
				else if(t<11)
					rx3-=41;
				else if(t<13)
					ry3-=31;
				else if(t<18)
					rx3+=41;
				else if(t==18) {
					rx3+=41;
					ry3-=41;
				}
				else if(t<24)
					ry3-=41;
				else if(t<26)
					rx3+=33;
				else if(t<31)
					ry3+=41;
				else if(t==31) {
					rx3+=41;
					ry3+=41;
				}
				else if(t<37)
					rx3+=41;
				else if(t<39) 
					ry3+=31;
				else if(t<44)
					rx3-=41;
				else if(t==44) {
					rx3-=41;
					ry3+=41;
					}
				else if(t<50)
					ry3+=41;
				else if(t==50) 
					rx3-=33;
				else if(t<56)
					ry3-=41;
				else if(t==56)
					{ry3-=41;
					}
				}
				redpiece[3].setBounds(rx3, ry3,width , height);
				
				}
				dice=0;
				rwin=0;
				for(int i=0;i<4;i++) {
					if(redpiece[i].getBounds().x==512&&redpiece[i].getBounds().y==395)
					rwin++;
					 if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
					{
						
					}
					else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else {	
					
					if(redpiece[3].getBounds().x==yellowpiece[i].getBounds().x&&redpiece[3].getBounds().y==yellowpiece[i].getBounds().y)
					{
						if(i==0) {
							yellowpiece[i].setBounds(657,155,width,height);
							yx=545;
							yy=128;
									}
							else if(i==1) {
							yellowpiece[i].setBounds(707,155,width,height);
							yx1=545;
							yy1=128;}
							else if(i==2)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx2=545;
								yy2=128;}
							else if(i==3)
							{
								yellowpiece[i].setBounds(707,155,width,height);
								yx3=545;
								yy3=128;}	
							yellowcount[i]=-5;

					}
				}
				}
					if(rwin==4)
					{this.setVisible(false);
					RedWin a=new RedWin();
						a.setVisible(true);	
						
					}
					
			
				}
				}
				}
		else if(turn%2==1) {
			 if(turn1%2==1) {
			if(e.getSource()==y) {
			
			dice=(int)((Math.random()*6))+1;
			
			if(dice!=6)
			{if(((yellowpiece[0].getBounds().x==657&&yellowpiece[0].getBounds().y==155)||(yellowpiece[0].getBounds().x==553&&yellowpiece[0].getBounds().y==374))&&((yellowpiece[1].getBounds().x==707&&yellowpiece[1].getBounds().y==155)||(yellowpiece[1].getBounds().x==553&&yellowpiece[1].getBounds().y==374))&&((yellowpiece[2].getBounds().x==657&&yellowpiece[2].getBounds().y==205)||(yellowpiece[2].getBounds().x==553&&yellowpiece[2].getBounds().y==374))&&((yellowpiece[3].getBounds().x==707&&yellowpiece[3].getBounds().y==205)||(yellowpiece[3].getBounds().x==553&&yellowpiece[3].getBounds().y==374)))
				{ypiece=false;
				}
				if(dice==1) 
				y.setText("1");
			else if(dice==2) 
				y.setText("2");
			else if(dice==3) 
				y.setText("3");
			else if(dice==4) 
				y.setText("4");
			else if(dice==5) 
				y.setText("5");
				
			}
			else {
				y.setText("6");
				ypiece=true;
				
			}
			if(!ypiece) {
				turn++;
				y.setBackground(Color.white);
				r.setBackground(Color.red);
				}
			turn1++;
			}
			
			 }
			if(ypiece==true) {
				if(e.getSource()==yellowpiece[0]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					r.setBackground(Color.red);
						}
					if(yellowcount[0]+dice<57)	
						yellowcount[0]+=dice;
						if(yellowcount[0]<1)
							yellowcount[0]=-5;
						else if(yellowcount[0]==1)
						yellowpiece[0].setBounds(yx, yy,width , height);	
					else if(yellowcount[0]>1) {
					for(int t=yellowcount[0]-dice;t<yellowcount[0];t++) {
					if(t>0&&t<5) {
						yy+=41;
					}
					else if(t==5)
					{yx+=41;
					yy+=41;}
					else if(t<11)
						yx+=41;
					else if(t<13)
						yy+=31;
					else if(t<18)
						yx-=41;
					else if(t==18) {
						yx-=41;
						yy+=41;
					}
					else if(t<24)
						yy+=41;
					else if(t<26)
						yx-=33;
					else if(t<31)
						yy-=41;
					else if(t==31) {
						yx-=41;
						yy-=41;
					}
					else if(t<37)
						yx-=41;
					else if(t<39) 
						yy-=31;
					else if(t<44)
						yx+=41;
					else if(t==44) {
						yx+=41;
						yy-=41;
						}
					else if(t<50)
						yy-=41;
					else if(t==50) 
						yx+=33;
					else if(t<56)
						yy+=41;
					else if(t==56)
						{yy+=41;
						}
					}
					yellowpiece[0].setBounds(yx, yy,width , height);
					}
					dice=0;
					ywin=0;
					for(int i=0;i<4;i++) {
						if(yellowpiece[i].getBounds().x==512&&yellowpiece[i].getBounds().y==395)
						ywin++;
						if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else {	
						
						if(yellowpiece[0].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[0].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
							}
							else if(i==1) {
								redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
							}
							else if(i==2) {
								redpiece[i].setBounds(303,554,width,height);
								rx2=479;
								ry2=600;
							}
							else if(i==3) {
								redpiece[i].setBounds(353,554,width,height);	
								rx3=479;
								ry3=600;
							}
							redcount[i]=-5;
						}
					}
					}
						if(ywin==4)
						{this.setVisible(false);
						YellowWin a=new YellowWin();
							a.setVisible(true);	
							
						}
						
					}
				if(e.getSource()==yellowpiece[1]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					r.setBackground(Color.red);
						}
					if(yellowcount[1]+dice<57)	
						yellowcount[1]+=dice;
						if(yellowcount[1]<1)
							yellowcount[1]=-5;
						else if(yellowcount[1]==1)
						yellowpiece[1].setBounds(yx1, yy1,width , height);	
					else if(yellowcount[1]>1) {
					for(int t=yellowcount[1]-dice;t<yellowcount[1];t++) {
					if(t>0&&t<5) {
						yy1+=41;
					}
					else if(t==5)
					{yx1+=41;
					yy1+=41;}
					else if(t<11)
						yx1+=41;
					else if(t<13)
						yy1+=31;
					else if(t<18)
						yx1-=41;
					else if(t==18) {
						yx1-=41;
						yy1+=41;
					}
					else if(t<24)
						yy1+=41;
					else if(t<26)
						yx1-=33;
					else if(t<31)
						yy1-=41;
					else if(t==31) {
						yx1-=41;
						yy1-=41;
					}
					else if(t<37)
						yx1-=41;
					else if(t<39) 
						yy1-=31;
					else if(t<44)
						yx1+=41;
					else if(t==44) {
						yx1+=41;
						yy1-=41;
						}
					else if(t<50)
						yy1-=41;
					else if(t==50) 
						yx1+=33;
					else if(t<56)
						yy1+=41;
					else if(t==56)
						{yy1+=41;
						}
					}
					yellowpiece[1].setBounds(yx1, yy1,width , height);
					
					}
					dice=0;
					ywin=0;
					for(int i=0;i<4;i++) {
						if(yellowpiece[i].getBounds().x==512&&yellowpiece[i].getBounds().y==395)
						ywin++;
						if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else {	
						
						if(yellowpiece[1].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[1].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
							}
							else if(i==1) {
								redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
							}
							else if(i==2) {
								redpiece[i].setBounds(303,554,width,height);
								rx2=479;
								ry2=600;
							}
							else if(i==3) {
								redpiece[i].setBounds(353,554,width,height);	
								rx3=479;
								ry3=600;
							}
						}
					}
					}
						if(ywin==4)
						{this.setVisible(false);
						YellowWin a=new YellowWin();
							a.setVisible(true);	
							
						}
					
					}
				if(e.getSource()==yellowpiece[2]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					r.setBackground(Color.red);
						}
					if(yellowcount[2]+dice<57)	
						yellowcount[2]+=dice;
						if(yellowcount[2]<1)
							yellowcount[2]=-5;
						else if(yellowcount[2]==1)
						yellowpiece[2].setBounds(yx2, yy2,width , height);	
					else if(yellowcount[2]>1) {
					for(int t=yellowcount[2]-dice;t<yellowcount[2];t++) {
					if(t>0&&t<5) {
						yy2+=41;
					}
					else if(t==5)
					{yx2+=41;
					yy2+=41;}
					else if(t<11)
						yx2+=41;
					else if(t<13)
						yy2+=31;
					else if(t<18)
						yx2-=41;
					else if(t==18) {
						yx2-=41;
						yy2+=41;
					}
					else if(t<24)
						yy2+=41;
					else if(t<26)
						yx2-=33;
					else if(t<31)
						yy2-=41;
					else if(t==31) {
						yx2-=41;
						yy2-=41;
					}
					else if(t<37)
						yx2-=41;
					else if(t<39) 
						yy2-=31;
					else if(t<44)
						yx2+=41;
					else if(t==44) {
						yx2+=41;
						yy2-=41;
						}
					else if(t<50)
						yy2-=41;
					else if(t==50) 
						yx2+=33;
					else if(t<56)
						yy2+=41;
					else if(t==56)
						{yy2+=41;
						}
					}
					yellowpiece[2].setBounds(yx2, yy2,width , height);
					
					}
					dice=0;
					ywin=0;
					for(int i=0;i<4;i++) {
						if(yellowpiece[i].getBounds().x==512&&yellowpiece[i].getBounds().y==395)
						ywin++;
						if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else {	
						
						if(yellowpiece[2].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[2].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
							}
							else if(i==1) {
								redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
							}
							else if(i==2) {
								redpiece[i].setBounds(303,554,width,height);
								rx2=479;
								ry2=600;
							}
							else if(i==3) {
								redpiece[i].setBounds(353,554,width,height);	
								rx3=479;
								ry3=600;
							}
						}
					}
					}
						if(ywin==4)
						{this.setVisible(false);
						YellowWin a=new YellowWin();
							a.setVisible(true);	
							
						}
					
					}
				if(e.getSource()==yellowpiece[3]) {
					if(dice==6)
						turn1++;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					r.setBackground(Color.red);
						}
					if(yellowcount[3]+dice<57)	
						yellowcount[3]+=dice;
						if(yellowcount[3]<1)
							yellowcount[3]=-5;
						else if(yellowcount[3]==1)
						yellowpiece[3].setBounds(yx3, yy3,width , height);	
					 else if(yellowcount[3]>1) {
					for(int t=yellowcount[3]-dice;t<yellowcount[3];t++) {
					if(t>0&&t<5) {
						yy3+=41;
					}
					else if(t==5)
					{yx3+=41;
					yy3+=41;}
					else if(t<11)
						yx3+=41;
					else if(t<13)
						yy3+=31;
					else if(t<18)
						yx3-=41;
					else if(t==18) {
						yx3-=41;
						yy3+=41;
					}
					else if(t<24)
						yy3+=41;
					else if(t<26)
						yx3-=33;
					else if(t<31)
						yy3-=41;
					else if(t==31) {
						yx3-=41;
						yy3-=41;
					}
					else if(t<37)
						yx3-=41;
					else if(t<39) 
						yy3-=31;
					else if(t<44)
						yx3+=41;
					else if(t==44) {
						yx3+=41;
						yy3-=41;
						}
					else if(t<50)
						yy3-=41;
					else if(t==50) 
						yx3+=33;
					else if(t<56)
						yy3+=41;
					else if(t==56)
						{
						yy3+=41;
						}
					}
					yellowpiece[3].setBounds(yx3, yy3,width , height);
					
					}
					 dice=0;
						ywin=0;
						for(int i=0;i<4;i++) {
							if(yellowpiece[i].getBounds().x==512&&yellowpiece[i].getBounds().y==395)
							ywin++;
							if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
							{
								
							}
							else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
							{
								
							}
							else {	
							
							if(yellowpiece[3].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[3].getBounds().y==redpiece[i].getBounds().y)
							{
								if(i==0) {
									redpiece[i].setBounds(303,504,width,height);
									rx=479;
									ry=600;
								}
								else if(i==1) {
									redpiece[i].setBounds(353,504,width,height);	
									rx1=479;
									ry1=600;
								}
								else if(i==2) {
									redpiece[i].setBounds(303,554,width,height);
									rx2=479;
									ry2=600;
								}
								else if(i==3) {
									redpiece[i].setBounds(353,554,width,height);	
									rx3=479;
									ry3=600;
								}		
							}
						}
						}
							if(ywin==4)
							{this.setVisible(false);
							YellowWin a=new YellowWin();
								a.setVisible(true);	
								
							}
						
					}
			}
				}
					
		
			}
	}