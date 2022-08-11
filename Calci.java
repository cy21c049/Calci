import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textField;
	// for creating buttons for each number 0 to 9
	JButton[] numberButtons=new JButton[10]; 
	JButton[] functionsButtons= new JButton[8];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equButton,delButton,clrButton;
	//Creating a panel to store all the buttons
	JPanel panel;
	Font myFont=new Font("Arial",Font.BOLD,30) ;
	double num1=0,num2=0,result =0;
	char operator;
	Calculator(){
		frame=new JFrame("Calci");
		// click on exit button to close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setResizable(false);
		// we will take care of layout later
		frame.setLayout(null);
		
		textField= new JTextField();
		textField.setBounds(50,25,300,50);
		textField.setFont(myFont);
		// to stop user from editing text
		textField.setEditable(false);
		addButton= new JButton("+");
		subButton= new JButton("-");
		mulButton= new JButton("*");
		divButton= new JButton("/");
		decButton= new JButton(".");
		equButton= new JButton("=");
		delButton= new JButton("Delete");
		clrButton= new JButton("C");
		
		functionsButtons[0]=addButton;
		functionsButtons[1]=subButton;
		functionsButtons[2]=mulButton;
		functionsButtons[3]=divButton;
		functionsButtons[4]=decButton;
		functionsButtons[5]=equButton;
		functionsButtons[6]=delButton;
		functionsButtons[7]=clrButton;
		
		for(int i=0;i<8;i++) {
			functionsButtons[i].addActionListener(this);
			functionsButtons[i].setFont(myFont);
			functionsButtons[i].setFocusable(false);
			
		}
		for(int i=0;i<10;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		delButton.setBounds(50,430,145,50);
		clrButton.setBounds(205,430,145,50);
		
		panel=new JPanel();
		// creating a square panel of 300*300
		panel.setBounds(50,100,300,300);
		// creating a grid with 4 rows, 4 columns and 10 spaces 
		// between the buttons
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.GRAY);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
	
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField); 
	
		frame.setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc=new Calculator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//clicking on number button will make it appear on textField
		for(int i=0;i<10;i++) {
			if(e.getSource()== numberButtons[i])
				textField.setText(textField.getText().concat(String.valueOf(i)));
		}
		if(e.getSource()== decButton) {
			try {
			textField.setText(textField.getText().concat("."));
			}
			catch (Exception ex) {
				textField.setText("0".concat("."));
			}
		}
		if (e.getSource()== addButton) {
			try{if(num1==0)num1=1;
			num1=1*(Double.parseDouble(textField.getText()));
			operator='+';
			textField.setText("");}
			catch(Exception ex) {
				 textField.setText("+");
			}
			
			
		}
		if (e.getSource()== subButton)
		{
			try {
			
			num1=(Double.parseDouble(textField.getText()));
			
			operator='-';
			textField.setText("");
			
		}
			catch(Exception ex) {
				 textField.setText("-");
			}
		}
		if (e.getSource()== mulButton) {
			try {
				num1=Double.parseDouble(textField.getText());
				operator='*';
				textField.setText("");
				}
				catch(Exception ex) {
					textField.setText("");
				}
		}
		if (e.getSource()== divButton) {
			try {
				num1=Double.parseDouble(textField.getText());
				operator='/';
				textField.setText("");
				}
				catch(Exception ex) {
					textField.setText("");
				}
			
		}
		if (e.getSource()== equButton) {
			try {
			num2=Double.parseDouble(textField.getText());
			switch(operator) {
			
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case '*':
				result=num1*num2;
				break;
			case '/':
				result=num1/num2;
				break;
			default: 
				result= num2;
			}
			textField.setText(String.valueOf(result));
			num1=result;}
			catch (Exception ex) {
				textField.setText("Syntax error");
			}
			
		}
		if(e.getSource()==clrButton) {
			textField.setText("");
			num1=0;
			num2=0;
		}
		if(e.getSource()==delButton) {
			String arg=textField.getText();
			textField.setText("");
			for(int i=0;i<arg.length()-1;i++) {
				textField.setText(textField.getText()+arg.charAt(i));
				
			}
		}
			
	}

}
