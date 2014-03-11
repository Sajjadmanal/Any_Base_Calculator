/*


#########################################################################################################################################################
#          
#                    ANY BASE CALCULATOR
#		       
#                   Name : SAJJAD MANAL (sajjadmanal24@gmail.com)
#
#
#
#
###########################################################################################################################################################


*/








import java.awt.*;
import java.awt.Dialog.*;
import javax.swing.*;
import java.awt.event.*;


public class Base implements ActionListener 
{
	JFrame f;
	JTextField text1,text2,text3,text4,text5,text6,text7;             //  FOR GRAPHICAL USER INTERFACE
	JLabel name1,name2,name3,name4,name5,name6,name7,heading;
	JButton button,button1,button2,button3,button4,button5,button6,button7,button8,button9;
	JPanel panel1,panel2,panel3,panel4,panel_head;
	public int f1=0;
	public int f2=0;


	int convertb(int r)
	{
		if(r>9 && r<36)
		{	
			r+=55;
		}
		else if(r>35)
		{
			r+=61;
		}
		else if(r<10)
		{
			r+=48;				
		}
		return r;
	}


	public String comp(String s , int b)
	{
		int i;
		String[] s1 = s.split("\\.");
		char[] digitint = s1[0].toCharArray();
		char[] digitflt = s1[1].toCharArray();
		for(i=0;i<digitflt.length;i++)
		{
			digitflt[i] = convert(digitflt[i],b);
			if((int)digitflt[i]>=b)
			{
				f2 = 1;
				break;
			}
		}
		for(i=0;i<digitint.length;i++)
		{
			digitint[i] = convert(digitint[i],b);
			if((int)digitint[i]>=b)
			{
				f1 = 1;
				break;
			}
		}
		if(f1 == 0 && f2 ==0)
		{
			String cno="";
			for(i=digitflt.length-1;i>=0;i--)
			{
				digitflt[i] = (char)((b-1) - (int)digitflt[i]);
				digitflt[i] = (char)convertb((int)digitflt[i]);
				cno=digitflt[i]+cno;
			}
			cno='.'+cno;
			for(i=digitint.length-1;i>=0;i--)
			{
				digitint[i] = (char)((b-1) - (int)digitint[i]);
				digitint[i] = (char)convertb((int)digitint[i]);
				cno=digitint[i]+cno;
			}
			return cno;
		}
		else
		{
			text2.setText("Invalid Number");
			text5.setText(" ");
			String cno="Invalid Number";
			return cno;
		}
	}	
	char convert(char digit , int b)
	{
		if((int)digit>47 && (int)digit<58)
		{
			digit = (char)((int)digit - 48);
		}
		if((int)digit>64 && (int)digit<91)
		{
			digit = (char)((int)digit - 55);
		}
		if((int)digit>96 && (int)digit<123)
		{
			digit = (char)((int)digit - 61);
		}
		return digit;
	}	






	public String cbase(String s , int b , int b1)
	{
		f1=f2=0;
		String[] s1 = null;
		s1 = s.split("\\.");
		char[] digit = s1[0].toCharArray();
		char[] digit1 = s1[1].toCharArray();
		char[] digit2;
		digit2 = new char[8];
		int[] digits;
		digits = new int[1000];
		String cno="";
		int r=0,no1=0;
		float no=0,no2=0;
		int i;
		char c;
		for(i=0;i<digit.length;i++)
		{
			digit[i] = convert(digit[i],b);
			if((int)digit[i]>=b)
			{
				f1 = 1;
				break ;
			}
		}
		for(i=0;i<digit1.length;i++)
		{
			digit1[i] = convert(digit1[i],b);
			if((int)digit1[i]>=b)
			{
				f2 = 1;
				break ;
			}
		}
		if(f1 == 0 && f2 == 0)
		{
			for(i=0;i<digit.length;i++)
			{
				no = no + (float)(Math.pow(b,(digit.length-1)-i))*(float)digit[i];
			}
			for(i=0;i<digit1.length;i++)
			{
				no = no + (float)(Math.pow(b,-(i+1)))*(float)digit1[i];
			}
			if(b1 == 10)
			{
				cno=String.valueOf(no);
				return cno;
			}
			else
			{
			no1 = (int)no;
			no2 =  no - (float)((int)no);
			i=0;
			do
			{
				r=(int)(no2*b1);
				r = convertb(r);
				digit2[i] = (char)r;
				i++;
				no2 = (float)(no2*b1) - (float)((int)(no2*b1));
			}			
			while((int)(no2*10) > 0);
			for(i=digit2.length-1;i>=0;i--)
			{
				c = digit2[i];
				cno=c+cno;
			}
			char d='.';
			cno=d+cno;
			do
			{
				r=no1%b1;
				r = convertb(r);
				c = (char)r;
				cno=c+cno;
				no1 = no1/b1;
			}  
			while(no1>0);
			return cno;
			}
		}
		else
		{
			text2.setText("Invalid number");
			text5.setText(" ");
			cno="Invalid number";
			return cno;
		}
	}




	Base(String j)
	{
		f = new JFrame(j);
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		text1 = new JTextField(20);
		text3 = new JTextField(3);
		text4 = new JTextField(3);
		text2 = new JTextField(20);
		text5 = new JTextField(3);
		text6 = new JTextField(20);
		text7 = new JTextField(3);
		heading = new JLabel(" Enter any Number in float format (eg. A4578.0 )      Designed By Akif Khan Yusufzai(11 CSS 07)");
		name1 = new JLabel("Number");
		name2 = new JLabel("Base");
		name4 = new JLabel("New Base");
		name6 = new JLabel("Number");
		name7 = new JLabel("Base");
		name3 = new JLabel("Resultant Number");
		name5 = new JLabel(" Base");


		button = new JButton("Convert");
		button1 = new JButton("Add");
		button2 = new JButton("Subtract");
		button3 = new JButton("MULTIPLY");
		button4 = new JButton("DIVIDE");
		button5 = new JButton("NOT");
		button6 = new JButton("OR");
		button7 = new JButton("AND");
		button8 = new JButton("NAND");		
		button9 = new JButton("NOR");


		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel_head = new JPanel();
 




		panel_head.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_head.add(heading);		




		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(name1);
		panel1.add(text1);
		panel1.add(name2);
		panel1.add(text3);
		panel1.add(name4);
		panel1.add(text4);
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.add(name6);
		panel4.add(text6);
		panel4.add(name7);
		panel4.add(text7);
		panel3.setLayout(new FlowLayout());
		panel3.add(button);
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(button4);
		panel3.add(button5);
		panel3.add(button6);
		panel3.add(button7);
		panel3.add(button8);
		panel3.add(button9);


		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(name3);
		panel2.add(text2);
		panel2.add(name5);
		panel2.add(text5);
		f.getContentPane().add(panel_head);
		f.getContentPane().add(panel1);
		f.getContentPane().add(panel4);
		f.getContentPane().add(panel3);
		f.getContentPane().add(panel2); 
		ActionListener l = new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				System.out.println("Action event from a text field");
			}
		};
		text1.addActionListener(l);
		text2.addActionListener(l);
		text3.addActionListener(l);
		text4.addActionListener(l);
		text5.addActionListener(l);
		text6.addActionListener(l);
		text7.addActionListener(l);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);


		f.setSize(750,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{ 
		String s = text1.getText();
		int b = Integer.parseInt(text3.getText()); 
		if(e.getSource()==button)
		{
			int b1 = Integer.parseInt(text4.getText());
			String cno = cbase(s,b,b1);                                  // call of cbase here
			text2.setText(cno);
			text5.setText(String.valueOf(b1));
		}
		if(e.getSource() == button1)
		{
			String s1 = text6.getText();
			int b1 = Integer.parseInt(text7.getText());
			if(b1 != b)
			{
				s1 = cbase(s1,b1,b);
				b1 = b;
			}
			String[] s11 = null;
			s11 = s.split("\\.");
			String[] s12 = null;
			s12 = s1.split("\\.");
			String v1 = s11[0];
			String v2 = s12[0];
			int j = (v1.length()) - (v2.length());
			int i;
			if(j < 0)
			{
				for(i=0;i<-j;i++)
				{
					v1='0'+v1;
				}
			}
			if(j > 0)
			{
				for(i=0;i<j;i++)
				{
					v2='0'+v2;
				}
			}
			j = 0;
			char[] digit1int = v1.toCharArray();
			char[] digit2int = v2.toCharArray();
			j = (s11[1].length()) - (s12[1].length());
			if(j < 0)
			{
				for(i=0;i<-j;i++)
				{
					s11[1]=s11[1].concat("0");
				}
			}
			if(j > 0)
			{
				for(i=0;i<j;i++)
				{
					s12[1]=s12[1].concat("0");
				}
			}
			char[] digit1flt = s11[1].toCharArray();
			char[] digit2flt = s12[1].toCharArray();
			f1=f2=0;
			for(i=0;i<digit1int.length;i++)
			{
				digit1int[i] = convert(digit1int[i],b);
				if((int)digit1int[i] >= b)
				{
					f1 = 1;
					break;
				}
				if(f1 == 0)
				{
					digit2int[i] = convert(digit2int[i],b);
					if((int)digit2int[i] >= b)
					{
						f1 = 1;
						break;
					}
				}
			}
			for(i=0;i<digit1flt.length;i++)
			{
				digit1flt[i] = convert(digit1flt[i],b);
				if((int)digit1flt[i] >= b)
				{
					f2 = 1;
					break;
				}
				if(f2 == 0)
				{
					digit2flt[i] = convert(digit2flt[i],b);
					if((int)digit2flt[i] >= b)
					{
						f2 = 1;
						break;
					}
				}
			}
			if(f1 == 0 && f2 == 0)
			{
				int t,l=0,r;
				String sum=" ";
				char c;
				for(i=digit1flt.length-1;i>=0;i--)
				{
					t = (int)digit1flt[i] + (int)digit2flt[i] + l;
					r = t%b;
					r = convertb(r);
					c = (char)r;
					sum=c+sum;
					l = t/b;
				}
				sum='.'+sum;
				for(i=digit1int.length-1;i>=0;i--)
				{
					t = (int)digit1int[i] + (int)digit2int[i] + l;
					r = t%b;
					r = convertb(r);
					c = (char)r;
					sum=c+sum;
					l = t/b;
				}
				text2.setText(sum);
				text5.setText(String.valueOf(b));
			}
			else
			{
				text2.setText("Invalid number");
				text5.setText(" ");
			}
		}
		if(e.getSource() == button2) //subtract
		{
			String s1 = text6.getText();
			int b1 = Integer.parseInt(text7.getText());
			String str1= cbase(s,b,10);
			String str2=cbase(s1,b1,10);


			float  f1=Float.parseFloat(str1);
			float f2=Float.parseFloat(str2);
			float digit = 0;
			if(f1>f2)
			{digit=f1-f2;
		     }   
		     if(f2>f1)
			 {
			     digit=(f2-f1);
			 }


			    String cno = Float.toString(digit);


              String cno1 = cbase(cno,10,b);


			text2.setText(cno1);
			text5.setText(String.valueOf(b));


		}


		if(e.getSource()==button3)  // MULTIPLY
		{	String str = text6.getText();
			int base = Integer.parseInt(text7.getText());
			String cno = cbase(s,b,10);
			String cno1 =cbase(str,base,10);


			float  f1=Float.parseFloat(cno);
			float f2=Float.parseFloat(cno1);
			float digit = f1*f2;
			     cno= Float.toString(digit);


              cno = cbase(cno,10,b);


			text2.setText(cno);
			text5.setText(String.valueOf(b));
		}




 	if(e.getSource()==button4)     // DIVIDE
   	{
     		System.out.println("Divide");
        	String str = text6.getText();
			int base = Integer.parseInt(text7.getText());
			String cno = cbase(s,b,10);
			String cno1 =cbase(str,base,10);


			float  f1=Float.parseFloat(cno);
			float f2=Float.parseFloat(cno1);
			float digit = f1/f2;
			     cno= Float.toString(digit);


              cno = cbase(cno,10,b);


			text2.setText(cno);
			text5.setText(String.valueOf(b));
    	}


   




 	if(e.getSource()==button5)           //NOT
		{	String str = text1.getText();
			int base = Integer.parseInt(text3.getText());
			String cno = cbase(str,base,2);
			char[] digit = cno.toCharArray();


			/*for(i=0;i<20;i++)
			{	if(digit[i]==0)
				{	digit[i]=1;
				}
				
				if(digit[i]==1)
				{	digit[i]=0;
				
				}
	         */text2.setText(cno);
			text5.setText(String.valueOf(2));
		}




	if(e.getSource()==button6)  //OR
		{   String str = text6.getText();
			int base = Integer.parseInt(text7.getText());
		System.out.println("button OR");
			String cno = cbase(s,b,2);
			String cno1=cbase(str,base,2);
			char digit[]=cno.toCharArray();
			char digit1[]=cno1.toCharArray();
			 char digit2[]=digit1;


			text2.setText(cno1);
			text5.setText(String.valueOf(2));
		}


	if(e.getSource()==button7)   //  AND BUTTON
		{	
		System.out.println("button 7");
		String str = text1.getText();
			int base = Integer.parseInt(text3.getText());
			String str1 = text6.getText();
			int base1 = Integer.parseInt(text7.getText());
			String str2 = cbase(str,base,2);
			String str3 = cbase(str1,base1,2);
			if(str2.length()>str3.length())
			{  for(int i=0;i<(str2.length()-str3.length());i++)
					{
						str3="0"+str3;
					}
			}
			if(str3.length()>str2.length())
			{  for(int i=0;i<(str3.length()-str2.length());i++)
					{
						str2="0"+str2;
					}
			}
 			
		     char[] digit1 = str1.toCharArray();
			 char[] digit2 = str2.toCharArray(); 
			 char [] digit3 = str1.toCharArray();
			 int i=0;
			   for(i=0;i<30;i++)
			{	if(digit1[i]==1 && digit2[i]==1)
				{	digit3[i]=1;
				}


				if (digit1[i]=='.' || digit2[i]=='.')
				  { digit3[i]='.';}


				 else
				  digit3[i]=0;
			}	
			str3= new String(digit3);	
			text2.setText(str3);
			text5.setText("2");
		}




	if(e.getSource()==button8)                  //NAND
		{   System.out.println("button 8");
			String cno = cbase(s,b,2);
			text2.setText(cno);
			text5.setText(String.valueOf(2));
		}


	if(e.getSource()==button9)                 // NOR
		{  System.out.println("button 9");
			String cno = cbase(s,b,2);
			text2.setText(cno);
			text5.setText(String.valueOf(2));
		}




}


	public static void main(String[] args)
	{
		new Base("Any Base Calculator ");
	}
}
