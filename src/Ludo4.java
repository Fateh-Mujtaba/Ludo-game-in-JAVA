import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ludo4 extends JFrame implements ActionListener{
	
	JTextField [][]Y=new JTextField [6][3];
	JTextField [][]G=new JTextField [3][6];
	JTextField [][]B=new JTextField [3][6];
	JTextField [][]R=new JTextField [6][3];
	JLabel center;
	JLabel red;
	JLabel yellow;
	JLabel green;
	JLabel blue;
	JButton y,r,g,b;
	JButton back=new JButton();
	
	int rx=479,ry=600,rx1=rx,rx2=rx,rx3=rx,ry1=ry,ry2=ry,ry3=ry;
	int yx=545,yy=128,yx1=yx,yx2=yx,yx3=yx,yy1=yy,yy2=yy,yy3=yy;
	int gx=274,gy=333,gx1=gx,gx2=gx,gx3=gx,gy1=gy,gy2=gy,gy3=gy;
	int bx=750,by=395,bx1=bx,bx2=bx,bx3=bx,by1=by,by2=by,by3=by;
	
	final int width=25,height=25;
	JButton []redpiece=new JButton[4];
	JButton []yellowpiece=new JButton[4];
	JButton []greenpiece=new JButton[4];
	JButton []bluepiece=new JButton[4];
	int greencount[]= {-5,-5,-5,-5};
	int bluecount[]= {-5,-5,-5,-5};
	int redcount[]= {-5,-5,-5,-5};
	int yellowcount[]= {-5,-5,-5,-5};
	boolean rpiece=false,ypiece=false,bpiece=false,gpiece=false;
	JPanel py;
	JPanel pg;
	JPanel pr;
	JPanel pb;
	int turn=0,dice=0,rwin=0,ywin=0,bwin=0,gwin=0,turn1=0;
	Ludo4(){
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
		g=new JButton();
		b=new JButton();
		r.setBounds(125,600,50,50);
		y.setBounds(875,77,50,50);
		g.setBounds(125,77,50,50);
		b.setBounds(875,600,50,50);
		
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
	for(int i=0;i<4;i++) {
		greenpiece[i]=new JButton();
		greenpiece[i].addActionListener(this);
		if(i==0)
		greenpiece[i].setBounds(303,155,width,height);
		else if(i==1)
		greenpiece[i].setBounds(353,155,width,height);	
		else if(i==2)
		greenpiece[i].setBounds(303,205,width,height);
		else if(i==3)
		greenpiece[i].setBounds(353,205,width,height);	
		add(greenpiece[i]);
		greenpiece[i].setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\green piece.jpg"));
	}
	for(int i=0;i<4;i++) {
		bluepiece[i]=new JButton();
		bluepiece[i].addActionListener(this);
		if(i==0)
		bluepiece[i].setBounds(657,504,width,height);
		else if(i==1)
		bluepiece[i].setBounds(707,504,width,height);	
		else if(i==2)
		bluepiece[i].setBounds(657,554,width,height);
		else if(i==3)
		bluepiece[i].setBounds(707,554,width,height);	
		add(bluepiece[i]);
		bluepiece[i].setIcon(new ImageIcon("D:\\bS CS IV\\Project\\Images\\blue piece.jpg"));
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
	add(g);
	add(b);
	add(background);
	add(back);
	r.setBackground(Color.red);
	r.addActionListener(this);
	y.addActionListener(this);
	g.addActionListener(this);
	b.addActionListener(this);
	back.addActionListener(this);
	
	}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==back)
	{			
		this.setVisible(false);
		Introduction in=new Introduction();
    	in.setVisible(true);
	}
		
		if(turn%4==0) {
			if(turn1%4==0) {
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
					g.setBackground(Color.green);
					r.setBackground(Color.white);
					}
				turn1++;
				}
				
				}
			if(rpiece==true) {
				if(e.getSource()==redpiece[0]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					g.setBackground(Color.green);
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
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
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
							yy1=128;
							}
							else if(i==2) {
							yellowpiece[i].setBounds(657,205,width,height);
							yx2=545;
							yy2=128;
							}
							else if(i==3) {
							yellowpiece[i].setBounds(707,205,width,height);
							yx3=545;
							yy3=128;
							}
							yellowcount[i]=-5;
								
						}
						if(redpiece[0].getBounds().x==greenpiece[i].getBounds().x&&redpiece[0].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
							greenpiece[i].setBounds(303,155,width,height);
							gx=274;
							gy=333;
							}
							else if(i==1)
							{greenpiece[i].setBounds(353,155,width,height);	
							gx1=274;
							gy1=333;
							}
							else if(i==2)
							{greenpiece[i].setBounds(303,205,width,height);
							gx2=274;
							gy2=333;
							}
							else if(i==3)
							{greenpiece[i].setBounds(353,205,width,height);
							gx3=274;
							gy3=333;
							}
							greencount[i]=-5;
						}
						if(redpiece[0].getBounds().x==bluepiece[i].getBounds().x&&redpiece[0].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
							bluepiece[i].setBounds(657,504,width,height);
							bx=750;
							by=395;
							
							}
							else if(i==1)
							{
								bluepiece[i].setBounds(707,504,width,height);	
								bx1=750;
								by1=395;
								
							}
							else if(i==2)
							{
								bluepiece[i].setBounds(657,554,width,height);
								bx2=750;
								by2=395;
								
							}
							else if(i==3)
							{
								bluepiece[i].setBounds(707,554,width,height);	
								bx3=750;
								by3=395;
								
							}
									bluecount[i]=-5;
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					g.setBackground(Color.green);
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
					else if(t==5){
						rx1-=41;
						ry1-=41;
					}
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
					else if(t==56){
						ry1-=41;
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
					else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
					{
						
					}
					else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else {	
						if(redpiece[1].getBounds().x==yellowpiece[i].getBounds().x&&redpiece[0].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
							yellowpiece[i].setBounds(657,155,width,height);
							yx=545;
							yy=128;
							}
							else if(i==1) {
							yellowpiece[i].setBounds(707,155,width,height);	
							yx1=545;
							yy1=128;
							}
							else if(i==2) {
							yellowpiece[i].setBounds(657,205,width,height);
							yx2=545;
							yy2=128;
							}
							else if(i==3) {
							yellowpiece[i].setBounds(707,205,width,height);
							yx3=545;
							yy3=128;
							}
							yellowcount[i]=-5;
								
						}
						if(redpiece[1].getBounds().x==greenpiece[i].getBounds().x&&redpiece[0].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
							greenpiece[i].setBounds(303,155,width,height);
							gx=274;
							gy=333;
							}
							else if(i==1)
							{greenpiece[i].setBounds(353,155,width,height);	
							gx1=274;
							gy1=333;
							}
							else if(i==2)
							{greenpiece[i].setBounds(303,205,width,height);
							gx2=274;
							gy2=333;
							}
							else if(i==3)
							{greenpiece[i].setBounds(353,205,width,height);
							gx3=274;
							gy3=333;
							}
							greencount[i]=-5;
						}
						if(redpiece[1].getBounds().x==bluepiece[i].getBounds().x&&redpiece[0].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
							bluepiece[i].setBounds(657,504,width,height);
							bx=750;
							by=395;
							
							}
							else if(i==1)
							{
								bluepiece[i].setBounds(707,504,width,height);	
								bx1=750;
								by1=395;
								
							}
							else if(i==2)
							{
								bluepiece[i].setBounds(657,554,width,height);
								bx2=750;
								by2=395;
								
							}
							else if(i==3)
							{
								bluepiece[i].setBounds(707,554,width,height);	
								bx3=750;
								by3=395;
								
							}
									bluecount[i]=-5;
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					g.setBackground(Color.green);
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
					else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
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
							yy1=128;
							}
							else if(i==2) {
							yellowpiece[i].setBounds(657,205,width,height);
							yx2=545;
							yy2=128;
							}
							else if(i==3) {
							yellowpiece[i].setBounds(707,205,width,height);
							yx3=545;
							yy3=128;
							}
						yellowcount[i]=-5;
					}
					if(redpiece[2].getBounds().x==greenpiece[i].getBounds().x&&redpiece[2].getBounds().y==greenpiece[i].getBounds().y)
					{
						if(i==0) {
							greenpiece[i].setBounds(303,155,width,height);
							gx=274;
							gy=333;
							}
							else if(i==1)
							{greenpiece[i].setBounds(353,155,width,height);	
							gx1=274;
							gy1=333;
							}
							else if(i==2)
							{greenpiece[i].setBounds(303,205,width,height);
							gx2=274;
							gy2=333;
							}
							else if(i==3)
							{greenpiece[i].setBounds(353,205,width,height);
							gx3=274;
							gy3=333;
							}	
						greencount[i]=-5;
					}
					if(redpiece[2].getBounds().x==bluepiece[i].getBounds().x&&redpiece[2].getBounds().y==bluepiece[i].getBounds().y)
					{
						if(i==0) {
							bluepiece[i].setBounds(657,504,width,height);
							bx=750;
							by=395;
							
							}
							else if(i==1)
							{
								bluepiece[i].setBounds(707,504,width,height);	
								bx1=750;
								by1=395;
								
							}
							else if(i==2)
							{
								bluepiece[i].setBounds(657,554,width,height);
								bx2=750;
								by2=395;
								
							}
							else if(i==3)
							{
								bluepiece[i].setBounds(707,554,width,height);	
								bx3=750;
								by3=395;
								
							}
						bluecount[i]=-5;	
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					g.setBackground(Color.green);
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
					else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
					{
						
					}
					else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
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
							yy1=128;
							}
							else if(i==2) {
							yellowpiece[i].setBounds(657,205,width,height);
							yx2=545;
							yy2=128;
							}
							else if(i==3) {
							yellowpiece[i].setBounds(707,205,width,height);
							yx3=545;
							yy3=128;
							}
							yellowcount[i]=-5;
					}
					if(redpiece[3].getBounds().x==greenpiece[i].getBounds().x&&redpiece[3].getBounds().y==greenpiece[i].getBounds().y)
					{
						if(i==0) {
							greenpiece[i].setBounds(303,155,width,height);
							gx=274;
							gy=333;
							}
							else if(i==1)
							{greenpiece[i].setBounds(353,155,width,height);	
							gx1=274;
							gy1=333;
							}
							else if(i==2)
							{greenpiece[i].setBounds(303,205,width,height);
							gx2=274;
							gy2=333;
							}
							else if(i==3)
							{greenpiece[i].setBounds(353,205,width,height);
							gx3=274;
							gy3=333;
							}
						greencount[i]=-5;
					}
					if(redpiece[3].getBounds().x==bluepiece[i].getBounds().x&&redpiece[3].getBounds().y==bluepiece[i].getBounds().y)
					{
						if(i==0) {
							bluepiece[i].setBounds(657,504,width,height);
							bx=750;
							by=395;
							
							}
							else if(i==1)
							{
								bluepiece[i].setBounds(707,504,width,height);	
								bx1=750;
								by1=395;
								
							}
							else if(i==2)
							{
								bluepiece[i].setBounds(657,554,width,height);
								bx2=750;
								by2=395;
								
							}
							else if(i==3)
							{
								bluepiece[i].setBounds(707,554,width,height);	
								bx3=750;
								by3=395;
								
							}
						bluecount[i]=-5;	
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
		else if(turn%4==1) {
			if(turn1%4==1) {
				if(e.getSource()==g) {
				
				dice=(int)(Math.random()*6)+1;
				
				if(dice!=6)
				{if(((greenpiece[0].getBounds().x==303&&greenpiece[0].getBounds().y==155)||(greenpiece[0].getBounds().x==479&&greenpiece[0].getBounds().y==364))&&((greenpiece[1].getBounds().x==353&&greenpiece[1].getBounds().y==155)||(greenpiece[1].getBounds().x==479&&greenpiece[1].getBounds().y==364))&&((greenpiece[2].getBounds().x==303&&greenpiece[2].getBounds().y==205)||(greenpiece[2].getBounds().x==479&&greenpiece[2].getBounds().y==364))&&((greenpiece[3].getBounds().x==353&&greenpiece[3].getBounds().y==205)||(greenpiece[3].getBounds().x==479&&greenpiece[3].getBounds().y==364)))
					{gpiece=false;
					}
					if(dice==1) 
					g.setText("1");
				else if(dice==2) 
					g.setText("2");
				else if(dice==3) 
					g.setText("3");
				else if(dice==4) 
					g.setText("4");
				else if(dice==5) 
					g.setText("5");
					
				}
				else {
					g.setText("6");
					gpiece=true;
				}
				if(!gpiece) {
					turn++;
					y.setBackground(Color.yellow);
					g.setBackground(Color.white);
					}
				turn1++;
				}
				
				}
			if(gpiece==true) {
				if(e.getSource()==greenpiece[0]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					g.setBackground(Color.white);
						}
					if(greencount[0]+dice<57)	
					greencount[0]+=dice;
					if(greencount[0]<1)
						greencount[0]=-5;
					else if(greencount[0]==1)
						{greenpiece[0].setBounds(gx, gy,width , height);}
					
					else if(greencount[0]>1) {
					for(int t=greencount[0]-dice;t<greencount[0];t++) {
					if(t>0&&t<5) {
						gx+=41;
					}
					else if(t==5)
					{gx+=41;
					gy-=41;}
					else if(t<11)
						gy-=41;
					else if(t<13)
						gx+=33;
					else if(t<18)
						gy+=41;
					else if(t==18) {
						gx+=41;
						gy+=41;
					}
					else if(t<24)
						gx+=41;
					else if(t<26)
						gy+=31;
					else if(t<31)
						gx-=41;
					else if(t==31) {
						gx-=41;
						gy+=41;
					}
					else if(t<37)
						gy+=41;
					else if(t<39) 
						gx-=33;
					else if(t<44)
						gy-=41;
					else if(t==44) {
						gx-=41;
						gy-=41;
						}
					else if(t<50)
						gx-=41;
					else if(t==50) 
						gy-=31;
					else if(t<56)
						gx+=41;
					else if(t==56)
						{gx+=41;
						}
					
					}
					greenpiece[0].setBounds(gx, gy,width , height);
					}
					dice=0;
					gwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==364)
						gwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(greenpiece[0].getBounds().x==yellowpiece[i].getBounds().x&&greenpiece[0].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;	
						}
						if(greenpiece[0].getBounds().x==redpiece[i].getBounds().x&&greenpiece[0].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
							redpiece[i].setBounds(303,504,width,height);
							rx=479;
							ry=600;
							}
							else if(i==1)
							{redpiece[i].setBounds(353,504,width,height);	
							rx1=479;
							ry1=600;
							}
							else if(i==2)
							{redpiece[i].setBounds(303,504,width,height);
							rx2=479;
							ry2=600;
							}
							else if(i==3)
							{redpiece[i].setBounds(353,504,width,height);
							rx3=479;
							ry3=600;
							}
							redcount[i]=-5;
						}
						if(greenpiece[0].getBounds().x==bluepiece[i].getBounds().x&&greenpiece[0].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;
									
						}
					}
						}
						if(gwin==4)
						{this.setVisible(false);
						GreenWin a=new GreenWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==greenpiece[1]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					g.setBackground(Color.white);
						}
					if(greencount[1]+dice<57)	
					greencount[1]+=dice;
					if(greencount[1]<1)
						greencount[1]=-5;
					else if(greencount[1]==1)
						{greenpiece[1].setBounds(gx1, gy1,width , height);}
					
					else if(greencount[1]>1) {
					for(int t=greencount[1]-dice;t<greencount[1];t++) {
					if(t>0&&t<5) {
						gx1+=41;
					}
					else if(t==5)
					{gx1+=41;
					gy1-=41;}
					else if(t<11)
						gy1-=41;
					else if(t<13)
						gx1+=33;
					else if(t<18)
						gy1+=41;
					else if(t==18) {
						gx1+=41;
						gy1+=41;
					}
					else if(t<24)
						gx1+=41;
					else if(t<26)
						gy1+=31;
					else if(t<31)
						gx1-=41;
					else if(t==31) {
						gx1-=41;
						gy1+=41;
					}
					else if(t<37)
						gy1+=41;
					else if(t<39) 
						gx1-=33;
					else if(t<44)
						gy1-=41;
					else if(t==44) {
						gx1-=41;
						gy1-=41;
						}
					else if(t<50)
						gx1-=41;
					else if(t==50) 
						gy1-=31;
					else if(t<56)
						gx1+=41;
					else if(t==56)
						{gx1+=41;
						}
					
					}
					greenpiece[1].setBounds(gx1, gy1,width , height);
					}
					dice=0;
					gwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==364)
						gwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(greenpiece[1].getBounds().x==yellowpiece[i].getBounds().x&&greenpiece[1].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(greenpiece[1].getBounds().x==redpiece[i].getBounds().x&&greenpiece[1].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
							redcount[i]=-5;
						}
						if(greenpiece[1].getBounds().x==bluepiece[i].getBounds().x&&greenpiece[1].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;	
						}
					}
						}
						if(gwin==4)
						{this.setVisible(false);
						GreenWin a=new GreenWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==greenpiece[2]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					g.setBackground(Color.white);
						}
					if(greencount[2]+dice<57)	
					greencount[2]+=dice;
					if(greencount[2]<1)
						greencount[2]=-5;
					else if(greencount[2]==1)
						{greenpiece[2].setBounds(gx2,gy2,width , height);}
					
					else if(greencount[2]>1) {
					for(int t=greencount[2]-dice;t<greencount[2];t++) {
					if(t>0&&t<5) {
						gx2+=41;
					}
					else if(t==5)
					{gx2+=41;
					gy2-=41;}
					else if(t<11)
						gy2-=41;
					else if(t<13)
						gx2+=33;
					else if(t<18)
						gy2+=41;
					else if(t==18) {
						gx2+=41;
						gy2+=41;
					}
					else if(t<24)
						gx2+=41;
					else if(t<26)
						gy2+=31;
					else if(t<31)
						gx2-=41;
					else if(t==31) {
						gx2-=41;
						gy2+=41;
					}
					else if(t<37)
						gy2+=41;
					else if(t<39) 
						gx2-=33;
					else if(t<44)
						gy2-=41;
					else if(t==44) {
						gx2-=41;
						gy2-=41;
						}
					else if(t<50)
						gx2-=41;
					else if(t==50) 
						gy2-=31;
					else if(t<56)
						gx2+=41;
					else if(t==56)
						{gx2+=41;
						}
					
					}
					greenpiece[2].setBounds(gx2, gy2,width , height);
					}
					dice=0;
					gwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==364)
						gwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(greenpiece[2].getBounds().x==yellowpiece[i].getBounds().x&&greenpiece[2].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(greenpiece[2].getBounds().x==redpiece[i].getBounds().x&&greenpiece[2].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0)
								if(i==0) {
									redpiece[i].setBounds(303,504,width,height);
									rx=479;
									ry=600;
									}
									else if(i==1)
									{redpiece[i].setBounds(353,504,width,height);	
									rx1=479;
									ry1=600;
									}
									else if(i==2)
									{redpiece[i].setBounds(303,504,width,height);
									rx2=479;
									ry2=600;
									}
									else if(i==3)
									{redpiece[i].setBounds(353,504,width,height);
									rx3=479;
									ry3=600;
									}
							redcount[i]=-5;
						}
						if(greenpiece[2].getBounds().x==bluepiece[i].getBounds().x&&greenpiece[2].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;	
						}
					}
						}
						if(gwin==4)
						{this.setVisible(false);
						GreenWin a=new GreenWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==greenpiece[3]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.yellow);
					g.setBackground(Color.white);
						}
					if(greencount[3]+dice<57)	
					greencount[3]+=dice;
					if(greencount[3]<1)
						greencount[0]=-5;
					else if(greencount[3]==1)
						{greenpiece[3].setBounds(gx3, gy3,width , height);}
					
					else if(greencount[3]>1) {
					for(int t=greencount[3]-dice;t<greencount[3];t++) {
					if(t>0&&t<5) {
						gx3+=41;
					}
					else if(t==5)
					{gx3+=41;
					gy3-=41;}
					else if(t<11)
						gy3-=41;
					else if(t<13)
						gx3+=33;
					else if(t<18)
						gy3+=41;
					else if(t==18) {
						gx3+=41;
						gy3+=41;
					}
					else if(t<24)
						gx3+=41;
					else if(t<26)
						gy3+=31;
					else if(t<31)
						gx3-=41;
					else if(t==31) {
						gx3-=41;
						gy3+=41;
					}
					else if(t<37)
						gy3+=41;
					else if(t<39) 
						gx3-=33;
					else if(t<44)
						gy3-=41;
					else if(t==44) {
						gx3-=41;
						gy3-=41;
						}
					else if(t<50)
						gx3-=41;
					else if(t==50) 
						gy3-=31;
					else if(t<56)
						gx3+=41;
					else if(t==56)
						{gx3+=41;
						}
					
					}
					greenpiece[3].setBounds(gx3, gy3,width , height);
					}
					dice=0;
					gwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==364)
						gwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(greenpiece[3].getBounds().x==yellowpiece[i].getBounds().x&&greenpiece[3].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(greenpiece[3].getBounds().x==redpiece[i].getBounds().x&&greenpiece[3].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
							redcount[i]=-5;
						}
						if(greenpiece[3].getBounds().x==bluepiece[i].getBounds().x&&greenpiece[3].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;	
						}
					}
						}
						if(gwin==4)
						{this.setVisible(false);
						GreenWin a=new GreenWin();
							a.setVisible(true);	
							
						}
						
					
				}
				}
		}
		else if(turn%4==2) {
			 if(turn1%4==2) {
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
				b.setBackground(Color.blue);
				}
			turn1++;
			}
			
			 }
			if(ypiece==true) {
				if(e.getSource()==yellowpiece[0]) {
					if(dice==6)
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					b.setBackground(Color.blue);
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
						if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(yellowpiece[0].getBounds().x==greenpiece[i].getBounds().x&&yellowpiece[0].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
							greencount[i]=-5;
						}
						if(yellowpiece[0].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[0].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
							redcount[i]=-5;
						}
						if(yellowpiece[0].getBounds().x==bluepiece[i].getBounds().x&&yellowpiece[0].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;		
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					b.setBackground(Color.blue);
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
						if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(yellowpiece[1].getBounds().x==greenpiece[i].getBounds().x&&yellowpiece[1].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
								greencount[i]=-5;
						}
						if(yellowpiece[1].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[1].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
					
							redcount[i]=-5;
						}
						if(yellowpiece[1].getBounds().x==bluepiece[i].getBounds().x&&yellowpiece[1].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;	
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					b.setBackground(Color.blue);
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
						if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(yellowpiece[2].getBounds().x==greenpiece[i].getBounds().x&&yellowpiece[2].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
								greencount[i]=-5;
						}
						if(yellowpiece[2].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[2].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
								redcount[i]=-5;
						}
						if(yellowpiece[2].getBounds().x==bluepiece[i].getBounds().x&&yellowpiece[2].getBounds().y==bluepiece[i].getBounds().y)
						{
							if(i==0) {
								bluepiece[i].setBounds(657,504,width,height);
								bx=750;
								by=395;
								
								}
								else if(i==1)
								{
									bluepiece[i].setBounds(707,504,width,height);	
									bx1=750;
									by1=395;
									
								}
								else if(i==2)
								{
									bluepiece[i].setBounds(657,554,width,height);
									bx2=750;
									by2=395;
									
								}
								else if(i==3)
								{
									bluepiece[i].setBounds(707,554,width,height);	
									bx3=750;
									by3=395;
									
								}
							bluecount[i]=-5;	
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
						turn1+=3;
					if(dice>0&&dice<6) {
					turn++;
					y.setBackground(Color.white);
					b.setBackground(Color.blue);
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
							if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
							{
								
							}
							else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
							{
								
							}
							else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
							{
								
							}
							else if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
							{
								
							}
								else {	
							
							if(yellowpiece[3].getBounds().x==greenpiece[i].getBounds().x&&yellowpiece[3].getBounds().y==greenpiece[i].getBounds().y)
							{if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
								greencount[i]=-5;	
							}
							if(yellowpiece[3].getBounds().x==redpiece[i].getBounds().x&&yellowpiece[3].getBounds().y==redpiece[i].getBounds().y)
							{
								if(i==0) {
									redpiece[i].setBounds(303,504,width,height);
									rx=479;
									ry=600;
									}
									else if(i==1)
									{redpiece[i].setBounds(353,504,width,height);	
									rx1=479;
									ry1=600;
									}
									else if(i==2)
									{redpiece[i].setBounds(303,504,width,height);
									rx2=479;
									ry2=600;
									}
									else if(i==3)
									{redpiece[i].setBounds(353,504,width,height);
									rx3=479;
									ry3=600;
									}
									redcount[i]=-5;
							}
							if(yellowpiece[3].getBounds().x==bluepiece[i].getBounds().x&&yellowpiece[3].getBounds().y==bluepiece[i].getBounds().y)
							{
								if(i==0) {
									bluepiece[i].setBounds(657,504,width,height);
									bx=750;
									by=395;
									
									}
									else if(i==1)
									{
										bluepiece[i].setBounds(707,504,width,height);	
										bx1=750;
										by1=395;
										
									}
									else if(i==2)
									{
										bluepiece[i].setBounds(657,554,width,height);
										bx2=750;
										by2=395;
										
									}
									else if(i==3)
									{
										bluepiece[i].setBounds(707,554,width,height);	
										bx3=750;
										by3=395;
										
									}
								bluecount[i]=-5;	
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
		else if(turn%4==3) {
			if(turn1%4==3) {
				if(e.getSource()==b) {
				
				dice=(int)(Math.random()*6)+1;
				
				if(dice!=6)
				{if(((bluepiece[0].getBounds().x==657&&bluepiece[0].getBounds().y==504)||(bluepiece[0].getBounds().x==545&&bluepiece[0].getBounds().y==364))&&((bluepiece[1].getBounds().x==707&&bluepiece[1].getBounds().y==504)||(bluepiece[1].getBounds().x==545&&bluepiece[1].getBounds().y==364))&&((bluepiece[2].getBounds().x==657&&bluepiece[2].getBounds().y==554)||(bluepiece[2].getBounds().x==545&&bluepiece[2].getBounds().y==364))&&((bluepiece[3].getBounds().x==707&&bluepiece[3].getBounds().y==554)||(bluepiece[3].getBounds().x==545&&bluepiece[3].getBounds().y==364)))
					{bpiece=false;
					}
					if(dice==1) 
					b.setText("1");
				else if(dice==2) 
					b.setText("2");
				else if(dice==3) 
					b.setText("3");
				else if(dice==4) 
					b.setText("4");
				else if(dice==5) 
					b.setText("5");
					
				}
				else {
					b.setText("6");
					bpiece=true;
				}
				if(!bpiece) {
					turn++;
					r.setBackground(Color.red);
					b.setBackground(Color.white);
					}
				turn1++;
				}
			
				}
			if(bpiece==true) {
				if(e.getSource()==bluepiece[0]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					r.setBackground(Color.red);
					b.setBackground(Color.white);
						}
					if(bluecount[0]+dice<57)	
						bluecount[0]+=dice;
					if(bluecount[0]<1)
						bluecount[0]=-5;
					else if(bluecount[0]==1)
						{bluepiece[0].setBounds(bx, by,width , height);}
					
					else if(bluecount[0]>1) {
					for(int t=bluecount[0]-dice;t<bluecount[0];t++) {
					if(t>0&&t<5) {
						bx-=41;
					}
					else if(t==5)
					{bx-=41;
					by+=41;}
					else if(t<11)
						by+=41;
					else if(t<13)
						bx-=33;
					else if(t<18)
						by-=41;
					else if(t==18) {
						bx-=41;
						by-=41;
					}
					else if(t<24)
						bx-=41;
					else if(t<26)
						by-=31;
					else if(t<31)
						bx+=41;
					else if(t==31) {
						bx+=41;
						by-=41;
					}
					else if(t<37)
						by-=41;
					else if(t<39) 
						bx+=33;
					else if(t<44)
						by+=41;
					else if(t==44) {
						bx+=41;
						by+=41;
						}
					else if(t<50)
						bx+=41;
					else if(t==50) 
						by+=31;
					else if(t<56)
						bx-=41;
					else if(t==56)
						{bx-=41;
						}
					
					}
					bluepiece[0].setBounds(bx, by,width , height);
					}
					dice=0;
					bwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==364)
						bwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(bluepiece[0].getBounds().x==yellowpiece[i].getBounds().x&&bluepiece[0].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(bluepiece[0].getBounds().x==redpiece[i].getBounds().x&&bluepiece[0].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
							redcount[i]=-5;
						}
						if(bluepiece[0].getBounds().x==greenpiece[i].getBounds().x&&bluepiece[0].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
							greencount[i]=-5;		
						}
					}
						}
						if(bwin==4)
						{this.setVisible(false);
						BlueWin a=new BlueWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==bluepiece[1]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					r.setBackground(Color.red);
					b.setBackground(Color.white);
						}
					if(bluecount[1]+dice<57)	
						bluecount[1]+=dice;
					if(bluecount[1]<1)
						bluecount[1]=-5;
					else if(bluecount[1]==1)
						{bluepiece[1].setBounds(bx1, by1,width , height);}
					
					else if(bluecount[1]>1) {
					for(int t=bluecount[1]-dice;t<bluecount[1];t++) {
					if(t>0&&t<5) {
						bx1-=41;
					}
					else if(t==5)
					{bx1-=41;
					by1+=41;}
					else if(t<11)
						by1+=41;
					else if(t<13)
						bx1-=33;
					else if(t<18)
						by1-=41;
					else if(t==18) {
						bx1-=41;
						by1-=41;
					}
					else if(t<24)
						bx1-=41;
					else if(t<26)
						by1-=31;
					else if(t<31)
						bx1+=41;
					else if(t==31) {
						bx1+=41;
						by1-=41;
					}
					else if(t<37)
						by1-=41;
					else if(t<39) 
						bx1+=33;
					else if(t<44)
						by1+=41;
					else if(t==44) {
						bx1+=41;
						by1+=41;
						}
					else if(t<50)
						bx1+=41;
					else if(t==50) 
						by1+=31;
					else if(t<56)
						bx1-=41;
					else if(t==56)
						{bx1-=41;
						}
					
					}
					bluepiece[1].setBounds(bx1, by1,width , height);
					}
					dice=0;
					bwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==364)
							bwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(bluepiece[1].getBounds().x==yellowpiece[i].getBounds().x&&bluepiece[1].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;	
						}
						if(bluepiece[1].getBounds().x==redpiece[i].getBounds().x&&bluepiece[1].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
							redcount[i]=-5;
						}
						if(bluepiece[1].getBounds().x==greenpiece[i].getBounds().x&&bluepiece[1].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
							greencount[i]=-5;	
						}
					}
						}
						if(bwin==4)
						{this.setVisible(false);
						 BlueWin a=new BlueWin();
						 a.setVisible(true);	
						
						}
						
					
				}
				if(e.getSource()==bluepiece[2]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					r.setBackground(Color.red);
					b.setBackground(Color.white);
						}
					if(bluecount[2]+dice<57)	
						bluecount[2]+=dice;
					if(bluecount[2]<1)
						bluecount[2]=-5;
					else if(bluecount[2]==1)
						{bluepiece[2].setBounds(bx2, by2,width , height);}
					
					else if(bluecount[2]>1) {
					for(int t=bluecount[2]-dice;t<bluecount[2];t++) {
					if(t>0&&t<5) {
						bx2-=41;
					}
					else if(t==5)
					{bx2-=41;
					by2+=41;}
					else if(t<11)
						by2+=41;
					else if(t<13)
						bx2-=33;
					else if(t<18)
						by2-=41;
					else if(t==18) {
						bx2-=41;
						by2-=41;
					}
					else if(t<24)
						bx2-=41;
					else if(t<26)
						by2-=31;
					else if(t<31)
						bx2+=41;
					else if(t==31) {
						bx2+=41;
						by2-=41;
					}
					else if(t<37)
						by2-=41;
					else if(t<39) 
						bx2+=33;
					else if(t<44)
						by2+=41;
					else if(t==44) {
						bx2+=41;
						by2+=41;
						}
					else if(t<50)
						bx2+=41;
					else if(t==50) 
						by2+=31;
					else if(t<56)
						bx2-=41;
					else if(t==56)
						{bx2-=41;
						}
					
					}
					bluepiece[2].setBounds(bx2, by2,width , height);
					}
					dice=0;
					bwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==364)
						bwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(bluepiece[2].getBounds().x==yellowpiece[i].getBounds().x&&bluepiece[2].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(bluepiece[2].getBounds().x==redpiece[i].getBounds().x&&bluepiece[2].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
								redcount[i]=-5;
						}
						if(bluepiece[2].getBounds().x==greenpiece[i].getBounds().x&&bluepiece[2].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
							greencount[i]=-5;	
						}
					}
						}
						if(bwin==4)
						{this.setVisible(false);
						BlueWin a=new BlueWin();
							a.setVisible(true);	
							
						}
						
					
				}
				if(e.getSource()==bluepiece[3]) {
					if(dice==6)
						turn1+=3;
					else if(dice>0&&dice<6) {
					turn++;
					r.setBackground(Color.red);
					b.setBackground(Color.white);
						}
					if(bluecount[3]+dice<57)	
						bluecount[3]+=dice;
					if(bluecount[3]<1)
						bluecount[3]=-5;
					else if(bluecount[3]==1)
						{bluepiece[3].setBounds(bx3, by3,width , height);}
					
					else if(bluecount[3]>1) {
					for(int t=bluecount[3]-dice;t<bluecount[3];t++) {
					if(t>0&&t<5) {
						bx3-=41;
					}
					else if(t==5)
					{bx3-=41;
					by3+=41;}
					else if(t<11)
						by3+=41;
					else if(t<13)
						bx3-=33;
					else if(t<18)
						by3-=41;
					else if(t==18) {
						bx3-=41;
						by3-=41;
					}
					else if(t<24)
						bx3-=41;
					else if(t<26)
						by3-=31;
					else if(t<31)
						bx3+=41;
					else if(t==31) {
						bx3+=41;
						by3-=41;
					}
					else if(t<37)
						by3-=41;
					else if(t<39) 
						bx3+=33;
					else if(t<44)
						by3+=41;
					else if(t==44) {
						bx3+=41;
						by3+=41;
						}
					else if(t<50)
						bx3+=41;
					else if(t==50) 
						by3+=31;
					else if(t<56)
						bx3-=41;
					else if(t==56)
						{bx3-=41;
						}
					
					}
					bluepiece[3].setBounds(bx3, by3,width , height);
					}
					dice=0;
					bwin=0;
					for(int i=0;i<4;i++) {
						if(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==364)
						bwin++;
						if((yellowpiece[i].getBounds().x==479&&yellowpiece[i].getBounds().y==600)||(yellowpiece[i].getBounds().x==274&&yellowpiece[i].getBounds().y==333)||(yellowpiece[i].getBounds().x==545&&yellowpiece[i].getBounds().y==128)||(yellowpiece[i].getBounds().x==750&&yellowpiece[i].getBounds().y==395))
						{
							
						}
						else if((redpiece[i].getBounds().x==479&&redpiece[i].getBounds().y==600)||(redpiece[i].getBounds().x==274&&redpiece[i].getBounds().y==333)||(redpiece[i].getBounds().x==545&&redpiece[i].getBounds().y==128)||(redpiece[i].getBounds().x==750&&redpiece[i].getBounds().y==395))
						{
							
						}
						else if((bluepiece[i].getBounds().x==479&&bluepiece[i].getBounds().y==600)||(bluepiece[i].getBounds().x==274&&bluepiece[i].getBounds().y==333)||(bluepiece[i].getBounds().x==545&&bluepiece[i].getBounds().y==128)||(bluepiece[i].getBounds().x==750&&bluepiece[i].getBounds().y==395))
						{
							
						}
						else if((greenpiece[i].getBounds().x==479&&greenpiece[i].getBounds().y==600)||(greenpiece[i].getBounds().x==274&&greenpiece[i].getBounds().y==333)||(greenpiece[i].getBounds().x==545&&greenpiece[i].getBounds().y==128)||(greenpiece[i].getBounds().x==750&&greenpiece[i].getBounds().y==395))
						{
							
						}
							else {	
						
						if(bluepiece[3].getBounds().x==yellowpiece[i].getBounds().x&&bluepiece[3].getBounds().y==yellowpiece[i].getBounds().y)
						{
							if(i==0) {
								yellowpiece[i].setBounds(657,155,width,height);
								yx=545;
								yy=128;
								}
								else if(i==1) {
								yellowpiece[i].setBounds(707,155,width,height);	
								yx1=545;
								yy1=128;
								}
								else if(i==2) {
								yellowpiece[i].setBounds(657,205,width,height);
								yx2=545;
								yy2=128;
								}
								else if(i==3) {
								yellowpiece[i].setBounds(707,205,width,height);
								yx3=545;
								yy3=128;
								}
							yellowcount[i]=-5;
						}
						if(bluepiece[3].getBounds().x==redpiece[i].getBounds().x&&bluepiece[3].getBounds().y==redpiece[i].getBounds().y)
						{
							if(i==0) {
								redpiece[i].setBounds(303,504,width,height);
								rx=479;
								ry=600;
								}
								else if(i==1)
								{redpiece[i].setBounds(353,504,width,height);	
								rx1=479;
								ry1=600;
								}
								else if(i==2)
								{redpiece[i].setBounds(303,504,width,height);
								rx2=479;
								ry2=600;
								}
								else if(i==3)
								{redpiece[i].setBounds(353,504,width,height);
								rx3=479;
								ry3=600;
								}
								redcount[i]=-5;
						}
						if(bluepiece[0].getBounds().x==greenpiece[i].getBounds().x&&bluepiece[0].getBounds().y==greenpiece[i].getBounds().y)
						{
							if(i==0) {
								greenpiece[i].setBounds(303,155,width,height);
								gx=274;
								gy=333;
								}
								else if(i==1)
								{greenpiece[i].setBounds(353,155,width,height);	
								gx1=274;
								gy1=333;
								}
								else if(i==2)
								{greenpiece[i].setBounds(303,205,width,height);
								gx2=274;
								gy2=333;
								}
								else if(i==3)
								{greenpiece[i].setBounds(353,205,width,height);
								gx3=274;
								gy3=333;
								}
								
							greencount[i]=-5;	
						}
					}
						}
							if(bwin==4)
							{this.setVisible(false);
							BlueWin a=new BlueWin();
								a.setVisible(true);	
								
						}
						
					
				}
				}
		}
					
		
			}

}