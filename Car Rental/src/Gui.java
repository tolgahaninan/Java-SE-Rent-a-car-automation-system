import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Gui extends JFrame {


private final int WINDOW_HEIGHT = 900;
private final int WINDOW_WIDTH = 600;



private JPanel centerPanel,centerPanel2,centerPanel3,centerPanel4,centerPanel5,centerPanel6,centerPanel7,centerPanel8,centerPanel9,centerPanel10,centerPanel11,centerPanel12,eastPanel1,eastPanel2,eastPanel3,eastPanel4,eastPanel5,eastPanel6;
private JButton loginB,createB,rentACarB,returnACarB, CarOpB,EmployeeOpB,setShiftB,statisticsB;

private JButton addEmp,deleteEmp,updateEmp;

private JLabel newIdL,newPassL,newEmailL,newPhoneL,accountTypeL,addEmpIdL,empPasswordL;
public static JTextField newNameT,newPassT,newEmailT,newPhoneT,addSalaryT,idT,passwordT;
private static JTextField addNameT,addEmpIdT,empPasswordT;
private JButton accountB,addCarB,removeCarB;
private JLabel empL,sundayL,mondayL,tuesdayL,wednesdayL,thursdayL,fridayL,saturdayL,addSalaryL,addPositionL;
private JComboBox emp,sundayC,mondayC,tuesdayC,wednesdayC,thursdayC,fridayC,saturdayC,addPositionC,brandC,packageC;
private JButton submitB,addCarB2,addEmpB2,removeEmpB,returnCarB2,removeCarB2;
private JLabel packageL,modelL,plateL,plateL2,RemoveIdL,returnCarL,addNameL,priceL;
private JTextField plateT,plateT2,RemoveIdT,priceT2;
private JButton backB1,backB2,backB3,backB4,backB5,backB6,backB7,MyRentedCarsB,showPrizeB;
private JTable denemeT;
private static JTable denemeT2;



private JComboBox paymentTypeC,rentedCarsC;
private JLabel selectCarL,paymentTypeL;
private JLabel dayL;
private JTextField dayT;
private JButton rentCarB;       

private static JComboBox availableCarsC;

private static JTextField priceT;
public static String selectedBrand;
public static String selectedPackage;


ImageIcon imagebg=new ImageIcon("bg.jpg");
JLabel image2=new JLabel(imagebg); 
Customer u1 = new Customer();
ImageIcon imagebg2=new ImageIcon("bg.jpg");
JLabel image3= new JLabel(imagebg2);

ImageIcon imageback1=new ImageIcon("back.png");
JLabel image7=new JLabel(imageback1); 




public Gui(){


        setTitle ("RentingMenagement");
        setSize (WINDOW_HEIGHT,WINDOW_WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        
        Singeleton dataModifier = Singeleton.getInstance();
        String[] columns2 = {"Income","Expense","Profit"};
        dataModifier.tableModel2.addRow(columns2);
        
        ImageIcon imageback1=new ImageIcon("back.png");
        JLabel image7=new JLabel(imageback1); 
       image7.setBounds(0, 0, 50, 100);
      
        
        /////// CENTER PANEL 
     
        centerPanel=new JPanel();
        centerPanel.setLayout(null);
        
        loginB=new JButton("Login");
        centerPanel.add(loginB);          
        loginB.setBounds(325,500,90,35);
        loginB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				try {
					checkLogin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
        

        createB=new JButton("Create a new account"); centerPanel.add(createB); 
        createB.setBounds(420, 500, 160, 35);
        
        createB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				visibilityCheck(centerPanel7);
		        centerPanel.setVisible(false);
		           
				
			}
		});
       

        idT=new JTextField(); centerPanel.add(idT);
        idT.setFont(new Font("sansserif", Font.ITALIC, 18)); idT.setHorizontalAlignment(SwingConstants.CENTER);
        idT.setBounds(325, 400, 250, 40);
        

        passwordT=new JTextField(); centerPanel.add(passwordT);
        passwordT.setFont(new Font("sansserif", Font.ITALIC, 18));passwordT.setHorizontalAlignment(SwingConstants.CENTER);
        passwordT.setBounds(325, 450, 250, 40);
        
        ImageIcon image1=new ImageIcon("car.jpg");
        JLabel imagel=new JLabel(image1);
        imagel.setBounds(0, 0, 900, 594);
        
        
        centerPanel.add(imagel);
        add (centerPanel,BorderLayout.CENTER);
        centerPanel.setVisible(true);
        setVisible(true);
        

        
        /////// CENTER PANEL 2 - Customer general page
        
        
         centerPanel2=new JPanel();
         centerPanel2.setLayout(null);
       
         rentACarB = new JButton("Rent A Car");
         rentACarB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setAllInvisibleCustomer();
				visibilityCheck(centerPanel12);
				
				
				
				
				
			}
		});
         
         
         setFont(rentACarB,20); centerPanel2.add(rentACarB);    
         rentACarB.setBounds(200, 100, 500, 150);
         
         returnACarB = new JButton("Return A Car");
         returnACarB.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleCustomer();
				visibilityCheck(centerPanel10);
				
				try {
					rentedCarsC = new JComboBox(stringsRentedCars());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
         setFont(returnACarB,20);
         centerPanel2.add(returnACarB);     
         returnACarB.setBounds(200, 300, 500, 150);

		// centerPanel2.add(image2);
					
        /////// CENTER PANEL 3 - Admin general page
   
        
          centerPanel3=new JPanel();
          centerPanel3.setLayout(null);


          CarOpB=new JButton("Car Operations");
          CarOpB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			setAllInvisibleAdmin();
			visibilityCheck(centerPanel9);
				
			}
		});
          
          setFont(CarOpB,20);
          centerPanel3.add(CarOpB);
          CarOpB.setBounds(100, 160, 300, 100);

          EmployeeOpB=new JButton("Employee Operations");
          
          EmployeeOpB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheckWithEast(centerPanel6, eastPanel2);
				
				
			}
		});
        
          setFont(EmployeeOpB,20);
          centerPanel3.add(EmployeeOpB);
          EmployeeOpB.setBounds(100, 320, 300, 100);


          setShiftB=new JButton("Set Shift");
          
          setShiftB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheck(centerPanel8);
				
				
			}
		});
          setFont(setShiftB,20);
          centerPanel3.add(setShiftB);
          setShiftB.setBounds(460, 160, 300, 100);


          statisticsB=new JButton("Show Statistics");
          statisticsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheck(centerPanel11);
				try {
					dataModifier.add2();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		           
				
				
				
			}
		});
          setFont(statisticsB,20);
          centerPanel3.add(statisticsB);
          statisticsB.setBounds(460, 320, 300, 100);

      
          centerPanel3.add(image2);

        
        /////// CENTER PANEL 4 - Employee General page
        
          centerPanel4=new JPanel();
          centerPanel4.setLayout(null);
   
          
          denemeT = new JTable(dataModifier.tableModel);   
          denemeT.setEnabled(false);
          denemeT.setRowHeight(150);
          denemeT.setBackground(Color.white.darker());
          denemeT.setFont(new Font("Courier New", Font.BOLD, 18));
          denemeT.setBounds(0, 120, 890, 300);
         
          centerPanel4.add(denemeT);
          
          
     //     shiftT=new JTextField();
     //     shiftT.setBounds(90, 75, 700, 400);
     //     shiftT.setEditable(false);
     //     centerPanel4.add(shiftT);
 
   
                 
          ///// CENTERPANEL 6 - Admin Employee Part

          
          centerPanel6= new JPanel();
          centerPanel6.setLayout(null);
          eastPanel2= new JPanel();
          eastPanel2.setLayout(null);
          
          addEmp=new JButton("ADD EMPLOYEE");
          addEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheckWithEast(centerPanel6, eastPanel3);
				
			}
		});
       
          addEmp.setBounds(50,50, 200,125);
          setFont(addEmp,15);
          centerPanel6.add(addEmp);
          
          
          deleteEmp=new JButton("DELETE EMPLOYEE");
          deleteEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheckWithEast(centerPanel6, eastPanel6);
				
			}
		});
          
      
          deleteEmp.setBounds(50,225, 200,125);
          setFont(deleteEmp,15);
          centerPanel6.add(deleteEmp);

   
          
      /*    updateEmp=new JButton("UPDATE EMPLOYEE");
          updateEmp.addActionListener((ActionListener)this);
          updateEmp.setBounds(50,400, 200,125);
          setFont(updateEmp,15);
          centerPanel6.add(updateEmp);*/
          
          backB2=new JButton();
          backB2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllInvisibleAdmin();
				visibilityCheck(centerPanel3);
				
			}
		});
          
          backB2.setBounds(0, 0, 75, 50);
     /*     ImageIcon imageback2=new ImageIcon("back.png");
          JLabel image11=new JLabel(imageback2); 
          image11.setBounds(0, 0, 50, 100);*/
       
          backB2.add(image7);
          centerPanel6.add(backB2);
          

          eastPanel2.setPreferredSize(new Dimension(600,600));
         
          
      

          
///////  CENTERPANEL 7 - Create Account part
          /////////////////////////////////////////////////// DÜZENLENEN ALAN 19.12
          centerPanel7= new JPanel();
          centerPanel7.setLayout(null);
      
          
          String[ ] accounts = {"Customer Account","Company Account"};
          JComboBox comboBox = new JComboBox(accounts);
          centerPanel7.add(comboBox);
          comboBox.setBounds(350, 65, 200, 35);
          
          accountTypeL=new JLabel("Account Type:");
          accountTypeL.setBounds(190, 65, 200, 35);
          accountTypeL.setFont(new Font("Courier New", Font.BOLD, 20));
          centerPanel7.add(accountTypeL);
          
          
          newNameT=new JTextField();
          newNameT.setBounds(350, 130, 200, 35);
          centerPanel7.add(newNameT);
          newNameT.setFont(new Font("sansserif", Font.ITALIC, 18));
         
          
          newIdL=new JLabel("NAME:");
          newIdL.setBounds(290, 130, 100, 35);
          newIdL.setFont(new Font("Courier New", Font.BOLD, 20));
          centerPanel7.add(newIdL);
          /////////
          newEmailT=new JTextField();
          newEmailT.setBounds(350, 200, 200, 35);
          centerPanel7.add(newEmailT);
          newEmailT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          newEmailL=new JLabel("EMAÝL:");
          newEmailL.setBounds(280, 200, 100, 35);
          newEmailL.setFont(new Font("Courier New", Font.BOLD, 20));
          centerPanel7.add(newEmailL);
          /////////
          newPhoneT=new JTextField();
          newPhoneT.setBounds(350, 270, 200, 35);
          centerPanel7.add(newPhoneT);
          newPhoneT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          newPhoneL=new JLabel("Mobile Number:");
          newPhoneL.setBounds(185, 270, 300, 35);
          newPhoneL.setFont(new Font("Courier New", Font.BOLD, 20));
          centerPanel7.add(newPhoneL);
          //////////
          newPassT=new JTextField();
          newPassT.setBounds(350, 340, 200, 35);
          centerPanel7.add(newPassT);
          newPassT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          newPassL=new JLabel("Password:");
          newPassL.setBounds(240, 340, 150, 35);
          newPassL.setFont(new Font("Courier New", Font.BOLD, 20));
          centerPanel7.add(newPassL);
          ////// 
         accountB=new JButton("Create Your Account");
         accountB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
								
				if(newNameT.getText().isEmpty() || newPassT.getText().isEmpty() || newEmailT.getText().isEmpty()|| newPhoneT.getText().isEmpty()) {
					flag=false;
				}
					
				String selectedType =comboBox.getSelectedItem().toString();
					
				if (flag==true){
					UserFactory u1 = new UserFactory();
					if (selectedType=="Customer Account") {
						User user1 =u1.getUser("Customer");
		            
						try {
							user1.createAccount();
							JFrame f1 = new JFrame();
							JOptionPane.showMessageDialog(f1, "Account has been created(Customer Type)");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
					else if (selectedType == "Company Account") {
					
						User user1 =u1.getUser("Company");
			            
			            try {
							user1.createAccount();
							JFrame f1 = new JFrame();
							JOptionPane.showMessageDialog(f1, "Account has been created(Company Type)");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}}
					          
				else if (flag==false){
					JFrame f1 = new JFrame();
					JOptionPane.showMessageDialog(f1, "Please Fill All the Blanks");
				}
				
			}
			
		});

         accountB.setBounds(280, 400, 300, 35);
         accountB.setFont(new Font("Courier New", Font.BOLD, 20));
         centerPanel7.add(accountB);
         centerPanel7.add(image2);

        
////////////CENTERPANEL 8 Admin Set shift part
          
        centerPanel8= new JPanel();
       centerPanel8.setLayout(null);
       
       empL=new JLabel("Choose an employee");
       empL.setBounds(325, 10, 250, 35);
       centerPanel8.add(empL);
       empL.setFont(new Font("Courier New", Font.BOLD, 18));

   
		try {
			emp = new JComboBox(employeeToComboBox());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
       centerPanel8.add(emp);
       emp.setBounds(350, 50, 150, 35);
       
     
       String[ ] shift = {"8:00-14:00","10:00-16:00","12:00-18:00","14:00-20:00","16:00-10:00"};

       ////////////
       sundayL=new JLabel("Sunday");
       sundayL.setBounds(50, 150, 100, 35);
       sundayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(sundayL);
       
       sundayC = new JComboBox(shift);
       centerPanel8.add(sundayC);
       sundayC.setBounds(45, 190, 80, 35);
       //////////////////
       
     
        mondayL=new JLabel("monday");
       mondayL.setBounds(150, 150, 100, 35);
       mondayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(mondayL);
       
       mondayC = new JComboBox(shift);
       centerPanel8.add(mondayC);
       mondayC.setBounds(145, 190, 80, 35);
       //////
        tuesdayL=new JLabel("Tuesday");
       tuesdayL.setBounds(260, 150, 100, 35);
       tuesdayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(tuesdayL);
       
       tuesdayC = new JComboBox(shift);
       centerPanel8.add(tuesdayC);
       tuesdayC.setBounds(255, 190, 80, 35);
       ////////
        wednesdayL=new JLabel("Wednesday");
       wednesdayL.setBounds(385, 150, 150, 35);
       wednesdayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(wednesdayL);
       
       wednesdayC = new JComboBox(shift);
       centerPanel8.add(wednesdayC);
       wednesdayC.setBounds(380, 190, 80, 35);
       ///////
        thursdayL=new JLabel("Thursday");
       thursdayL.setBounds(520, 150, 100, 35);
       thursdayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(thursdayL);
       
       thursdayC = new JComboBox(shift);
       centerPanel8.add(thursdayC);
       thursdayC.setBounds(515, 190, 80, 35);
       ///////
        fridayL=new JLabel("Friday");
       fridayL.setBounds(640, 150, 100, 35);
       fridayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(fridayL);
       
       fridayC = new JComboBox(shift);
       centerPanel8.add(fridayC);
       fridayC.setBounds(635, 190, 80, 35);
       ///////
       saturdayL=new JLabel("Saturday");
       saturdayL.setBounds(740, 150, 100, 35);
       saturdayL.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(saturdayL);
       
       saturdayC = new JComboBox(shift);
       centerPanel8.add(saturdayC);
       saturdayC.setBounds(740, 190, 100, 35);
       
       
       submitB=new JButton("SUBMÝT");
       submitB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e){

			try {
				setShiftMethod();
				JFrame f1 = new JFrame();
				JOptionPane.showMessageDialog(f1, "Shift has been added");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
       submitB.setBounds(310, 350, 200, 50);
       submitB.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel8.add(submitB);
       
       backB3=new JButton();
       backB3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setAllInvisibleAdmin();
			visibilityCheck(centerPanel3);
			
		}
	});
       
       backB3.setBounds(0, 0, 75, 50);
    /*   ImageIcon imageback3=new ImageIcon("back.png");
       JLabel image9=new JLabel(imageback3); 
       image7.setBounds(0, 0, 50, 100);*/
    
       backB3.add(image7);
       centerPanel8.add(backB3);
    
 
       
       //////EAST PANEL 3 Admin Add employee part
       
       eastPanel3 = new JPanel();
       eastPanel3.setLayout(null);
       
       
      
       addNameL=new JLabel("NAME:");
       addNameL.setBounds(145, 50, 100, 35);
       addNameL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(addNameL);

       addNameT=new JTextField();
       addNameT.setBounds(220, 50, 200, 35);
       eastPanel3.add(addNameT);
       addNameT.setFont(new Font("sansserif", Font.ITALIC, 18));
       
       
       
       
       String positions[]={"Marketing Maneger","Operations MAneger","Sales Assistant","Supervisor"};
       addPositionC = new JComboBox(positions);
       eastPanel3.add(addPositionC);
       
       
       addPositionC.setBounds(220, 150, 200, 35);
       addPositionL=new JLabel("POSITION:");
       addPositionL.setBounds(100, 150, 200, 35);
       addPositionL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(addPositionL);
       
       
       addSalaryT=new JTextField();
       addSalaryT.setBounds(220, 250, 200, 35);
       eastPanel3.add(addSalaryT);
       addSalaryT.setFont(new Font("sansserif", Font.ITALIC, 18));
       
       addSalaryL=new JLabel("SALARY:");
       addSalaryL.setBounds(120, 250, 100, 35);
       addSalaryL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(addSalaryL);
       
       addEmpIdT=new JTextField();
       addEmpIdT.setBounds(220, 350, 200, 35);
       eastPanel3.add(addEmpIdT);
       addEmpIdT.setFont(new Font("sansserif", Font.ITALIC, 18));
       
       addEmpIdL=new JLabel("ID:");
       addEmpIdL.setBounds(140, 350, 100, 35);
       addEmpIdL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(addEmpIdL);
       
       
       empPasswordT=new JTextField();
       empPasswordT.setBounds(220, 450, 200, 35);
       eastPanel3.add(empPasswordT);
       empPasswordT.setFont(new Font("sansserif", Font.ITALIC, 18));
       
       empPasswordL=new JLabel("Password:");
       empPasswordL.setBounds(80, 450, 300, 35);
       empPasswordL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(empPasswordL);
       
       
        addEmpB2=new JButton("Add Employee");
       addEmpB2.setBounds(170, 510, 200, 50);
       addEmpB2.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel3.add(addEmpB2);
       
       
       addEmpB2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean flag = true;

			
			if(addNameT.getText().isEmpty() || addSalaryT.getText().isEmpty() || addEmpIdT.getText().isEmpty()|| empPasswordT.getText().isEmpty()) {
				flag=false;
			}
			
			if (flag==true) {
			 try {
				 
					
			        String selectedPosition = (String) addPositionC.getSelectedItem();
			        String selectedId = (String) addEmpIdT.getText();
			               
			        EmployeeView view = new EmployeeView();
			        Employee model=retriveEmployeeFromDatabase();                   ///addEmpB2 yeni eklendi
			          
			          
			        EmployeeController controller = new EmployeeController(model, view);

			        controller.setEmployeePosition(selectedPosition);
			     
						controller.updateView();
					emp.addItem(selectedId);
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 
				
			}
			else if (flag==false) {
				JFrame f1 = new JFrame();
				JOptionPane.showMessageDialog(f1, "Please Fill All the Blanks");
				
			}
			
			
		}
	});
     
       eastPanel3.add(image2);
       eastPanel3.setPreferredSize(new Dimension(600,600));
       
       
     
       
       ///////CENTERPANEL9(CAR OPERATÝONS) - Admin Car operations part
       
       centerPanel9=new JPanel();
       centerPanel9.setLayout(null);
          
       addCarB=new JButton("Add Car");
       addCarB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setAllInvisibleAdmin();
			centerPanel9.add(image2);
			visibilityCheckWithEast(centerPanel9, eastPanel4);
		}
	});
       addCarB.setBounds(70, 100, 200, 50);
       addCarB.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel9.add(addCarB);
       
       
       removeCarB=new JButton("Remove Car");
       removeCarB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setAllInvisibleAdmin();
			visibilityCheckWithEast(centerPanel9, eastPanel5);
			
		}
	});
       removeCarB.setBounds(70, 300, 200, 50);
       removeCarB.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel9.add(removeCarB);
      
       
       backB4=new JButton();
       backB4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setAllInvisibleAdmin();
			visibilityCheck(centerPanel3);
		
		}
	});
       
     
       backB4.setBounds(0, 0, 75, 50);
     /*  ImageIcon imageback4=new ImageIcon("back.png");
       JLabel image10=new JLabel(imageback4); 
       image10.setBounds(0, 0, 50, 100);*/
       
          backB4.add(image7);
       //   centerPanel9.add(image2);
          centerPanel9.add(backB4);
       
       ///EASTPANEL 4 - Admin Add car part
          eastPanel4=new JPanel();
          eastPanel4.setLayout(null); 
        
       modelL=new JLabel("Model:");
       modelL.setBounds(100, 100, 100, 35);
       modelL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel4.add(modelL);
      
       String brands[]={"BMW-M3","BMW-M4","AUDÝ-A6","AUDI-A7","FÝAT-LINEA","FIAT-EGEA","MERCEDES-C180","MERCEDES-E250"};
       brandC = new JComboBox(brands);
       eastPanel4.add(brandC);
       brandC.setBounds(200, 100, 200, 35);
       
       	packageL=new JLabel("Package:");
       	packageL.setBounds(100, 200, 100, 35);
       	packageL.setFont(new Font("Courier New", Font.BOLD, 20));
       	eastPanel4.add(packageL);
       
       String packages[]={"Premium","Sport","Classical"};
          packageC=new JComboBox(packages);
          packageC.setBounds(200, 200, 200, 35);
          eastPanel4.add(packageC);
          
          plateL=new JLabel("Plate Number:");
       plateL.setBounds(40, 300, 200, 35);
       plateL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel4.add(plateL);
       
       
       plateT=new JTextField();
          plateT.setBounds(200, 300, 200, 35);
          eastPanel4.add(plateT);
          plateT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          
          priceL=new JLabel("Price:");
          priceL.setBounds(100, 400, 200, 35);
          priceL.setFont(new Font("Courier New", Font.BOLD, 20));
          eastPanel4.add(priceL);
          
          
          
          priceT = new JTextField();
          priceT.setBounds(200, 400, 200, 35);
          eastPanel4.add(priceT);
          priceT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          
          addCarB2=new JButton("Add Car");
       addCarB2.setBounds(200, 470, 200, 50);
       addCarB2.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel4.add(addCarB2);
       addCarB2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean flag = true ;
		
			if(plateT.getText().isEmpty() || priceT.getText().isEmpty()) {
				flag=false;
			}
			
				if (flag==true) {
			
			   try {
				addCar();
				JFrame f1 = new JFrame();
				JOptionPane.showMessageDialog(f1, "Car has been added");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			else if (flag== false) {
				
				JFrame f1 = new JFrame();
				JOptionPane.showMessageDialog(f1, "Please Fill All the Blanks");
			}
	    	   
	    	   
	}});
       
       eastPanel4.add(image2);
        eastPanel4.setPreferredSize(new Dimension(600,600));
        
        //EASTPANEL 5 - Admin remove car part
        
        eastPanel5=new JPanel();
          eastPanel5.setLayout(null); 
          
         removeCarB2=new JButton("Remove the Car");
         removeCarB2.setBounds(200, 300, 210, 50);
         removeCarB2.setFont(new Font("Courier New", Font.BOLD, 20));
         eastPanel5.add(removeCarB2);
         removeCarB2.addActionListener(new ActionListener() {
			
     
        	 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
	        	 boolean flag = true;
	        	 
	        	 if (plateT2.getText().isEmpty()) {
	        		 
	        		 flag = false ;
	        	 }
	        	 
	        	 if (flag==true) {
				try {
					deleteCar();
					JFrame f1 = new JFrame();
	     			JOptionPane.showMessageDialog(f1, "The car has been deleted");
	     		
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				
	        	 else if (flag==false) { 
	        		 JFrame f1 = new JFrame();
	     			JOptionPane.showMessageDialog(f1, "Please Fill all the blanks");
	        	 }
	        	 
			}
		});
       
         plateT2=new JTextField();
         plateT2.setBounds(200, 220, 200, 35);
         eastPanel5.add(plateT2);
         plateT2.setFont(new Font("sansserif", Font.ITALIC, 18));
          
         plateL2=new JLabel("Plate Number:");
         plateL2.setBounds(40, 220, 200, 35);
         plateL2.setFont(new Font("Courier New", Font.BOLD, 20));
         eastPanel5.add(plateL2);
          
          eastPanel5.setPreferredSize(new Dimension(600,600));

       /////EASTPANEL 6 (DELETE EMPLOYEE) Admin delete employee
       eastPanel6=new JPanel();
          eastPanel6.setLayout(null); 
          
          removeEmpB=new JButton("Remove the Employee");
       removeEmpB.setBounds(150, 300, 300, 50);
       removeEmpB.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel6.add(removeEmpB);
       removeEmpB.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {

        	   	boolean flag =true ;
        	   	
        	   	if (RemoveIdT.getText().isEmpty()) {
        	   		
        	   		flag = false ;
        	   	}
        	   	
        	   	if (flag == true) {
        	   try {
					deleteEmp();
					JFrame f1 = new JFrame();
					JOptionPane.showMessageDialog(f1, "Employee has been deleted");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

           }
        	    else if (flag==false) {
        	    	JFrame f1 = new JFrame();
					JOptionPane.showMessageDialog(f1, "Please Fill All the Blanks");
        	    }
        	              	
           }
          
           
       });
       
        RemoveIdT=new JTextField();
          RemoveIdT.setBounds(250, 220, 200, 35);
          eastPanel6.add(RemoveIdT);
          RemoveIdT.setFont(new Font("sansserif", Font.ITALIC, 18));
          
          RemoveIdL=new JLabel("Employee ID:");
       RemoveIdL.setBounds(90, 220, 200, 35);
       RemoveIdL.setFont(new Font("Courier New", Font.BOLD, 20));
       eastPanel6.add(RemoveIdL);
          
          eastPanel6.setPreferredSize(new Dimension(600,600));
          
        ///centerpanel 10 (REMOVE CAR)
       centerPanel10=new JPanel();
       centerPanel10.setLayout(null); 
          
       returnCarB2=new JButton("Remove the Car");
       returnCarB2.setBounds(300, 300, 300, 50);
       returnCarB2.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel10.add(returnCarB2);
       
          
        returnCarL=new JLabel("My Rented Cars:");
        returnCarL.setBounds(190, 220, 200, 35);
        returnCarL.setFont(new Font("Courier New", Font.BOLD, 20));
        centerPanel10.add(returnCarL);
       
       
         
        MyRentedCarsB=new JButton("Show my cars");
        MyRentedCarsB.setBounds(340, 420, 200, 50);
        MyRentedCarsB.setFont(new Font("Courier New", Font.BOLD, 20));
        
        centerPanel10.add(MyRentedCarsB);
        MyRentedCarsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            
                setAllInvisibleCustomer();
                 
                      
                      centerPanel5=new JPanel();
          centerPanel5.setLayout(null); 
          
       returnCarB2=new JButton("Return the Car");
       returnCarB2.setBounds(300, 300, 300, 50);
       returnCarB2.setFont(new Font("Courier New", Font.BOLD, 20));
       centerPanel5.add(returnCarB2);
       returnCarB2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	
                       // boolean flag = true;
                        
                        
                        try {
                            returnCar();
                            setAllInvisibleCustomer();
                            centerPanel5.setVisible(false);
                            visibilityCheck(centerPanel2);
                            centerPanel12.revalidate();
                            JFrame f1 = new JFrame();
        					JOptionPane.showMessageDialog(f1, "Selected car has been returned");
        					availableCarsC.addItem(rentedCarsC.getSelectedItem());
        					
                            
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
       
          
        returnCarL=new JLabel("My Rented Cars:");
        returnCarL.setBounds(150, 220, 200, 35);
        returnCarL.setFont(new Font("Courier New", Font.BOLD, 20));
        centerPanel5.add(returnCarL);
       
       
        backB5=new JButton();
          backB5.setBounds(0, 0, 75, 50);
          backB5.add(image7);
          centerPanel5.add(backB5);
        
          backB5.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               setAllInvisibleCustomer();
               centerPanel5.setVisible(false);
               visibilityCheck(centerPanel2);
                           
           }
       });
        
        
                     
                    
                     
          
                try {
                    rentedCarsC= new JComboBox(MyRentedCars());
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
          centerPanel5.add(rentedCarsC);
          rentedCarsC.setBounds(350, 220, 300, 35);
                
        centerPanel5.setVisible(true);
                setVisible(true);
                   
                visibilityCheck(centerPanel5);
            }
        });
         
                     
         
         
          
          backB5=new JButton();
          backB5.setBounds(0, 0, 75, 50);
          backB5.add(image7);
         
          backB5.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               setAllInvisibleAdmin();
               centerPanel2.setVisible(true);
               centerPanel2.add(image2);
           }
       });
          centerPanel10.add(backB5);
       	  
        
          ////////////// CENTER PANEL 12
          centerPanel12=new JPanel();
          centerPanel12.setLayout(null); 

           selectCarL=new JLabel("SelectCar:");
           selectCarL.setBounds(270, 150, 200, 35);
           selectCarL.setFont(new Font("Courier New", Font.BOLD, 20));
           centerPanel12.add(selectCarL);
           
        

           try {
			availableCarsC = new JComboBox(availableCars());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           centerPanel12.add(availableCarsC);
           availableCarsC.setBounds(400, 150, 300, 35);
 
           paymentTypeL=new JLabel("Payment Type:");
           paymentTypeL.setBounds(220, 250, 200, 35);
           paymentTypeL.setFont(new Font("Courier New", Font.BOLD, 20));
           centerPanel12.add(paymentTypeL);

           String[ ] payment = {"Cash","Credit Card","Indenture"};
           paymentTypeC = new JComboBox(payment);
           centerPanel12.add(paymentTypeC);
           paymentTypeC.setBounds(400, 250, 200, 35);

           dayL=new JLabel("Day:");
        dayL.setBounds(320, 350, 50, 35);
        dayL.setFont(new Font("Courier New", Font.BOLD, 20));
        centerPanel12.add(dayL);

        dayT=new JTextField();
           dayT.setBounds(400, 350, 50, 35);
           centerPanel12.add(dayT);
           dayT.setFont(new Font("sansserif", Font.ITALIC, 18));

           

           backB7=new JButton();
          backB7.setBounds(0, 0, 75, 50);
          backB7.add(image7);
          centerPanel12.add(backB7);
         
          backB7.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               setAllInvisibleCustomer();
               centerPanel12.setVisible(false);
               visibilityCheck(centerPanel2);
               rentCarB.setVisible(false);
                           
           }
       });
          
          showPrizeB=new JButton("Show Price");
          showPrizeB.setBounds(340, 420, 200, 50);
          showPrizeB.setFont(new Font("Courier New", Font.BOLD, 20));
          showPrizeB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//centerPanel12.add(rentCarB);
				
				boolean flag = true ;
				
				if (dayT.getText().isEmpty()) {
					
					flag=false ;
				}
				
				if (flag==true) {
				rentCarB.setVisible(true);
				showPrice();}
				else if (flag==false) {
				       JFrame f1 = new JFrame();
				       JOptionPane.showMessageDialog(f1, "Please fill all the blanks ");
					
				}
				
				
			}
		});
          centerPanel12.add(showPrizeB);
          
          priceT2 = new JTextField();
          priceT2.setBounds(570, 420, 100, 50);
          priceT2.setEnabled(false);
          centerPanel12.add(priceT2);
          
          
           

        rentCarB=new JButton("Rent it!");
        rentCarB.setVisible(false);
        rentCarB.setBounds(340, 500, 200, 50);
        rentCarB.setFont(new Font("Courier New", Font.BOLD, 20));
        centerPanel12.add(rentCarB);
        rentCarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    rentCar();
                    JFrame f1 = new JFrame();
        			JOptionPane.showMessageDialog(f1, "The car has been rented ");
                    availableCarsC.removeItemAt(availableCarsC.getSelectedIndex());
                    
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
         
           
           /////// CENTER PANEL 11 - Employee General page
           
           centerPanel11=new JPanel();
           centerPanel11.setLayout(null);
           
           
           backB6 = new JButton();
           backB6.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				setAllInvisibleAdmin();
 				visibilityCheck(centerPanel3);
 				
 				Accounting.sum=0;
 				Accounting.sumExpense=0;
 				Accounting.sumIncome=0;
 				
 				dataModifier.tableModel2.removeRow(1);
 			}
 		});
           
        
           backB6.setBounds(0, 0, 75, 50);
           centerPanel11.add(backB6);
           
           
           denemeT2 = new JTable(dataModifier.tableModel2);   
           denemeT2.setEnabled(false);
           denemeT2.setRowHeight(150);
           denemeT2.setBackground(Color.white.darker());
           denemeT2.setFont(new Font("Courier New", Font.BOLD, 18));
           denemeT2.setBounds(0, 120, 890, 300);
          
           centerPanel11.add(denemeT2);




       	  
}

	public void setFont(JButton x,int a) {
		x.setFont(new Font("sansserif", Font.ITALIC, a));
        x.setBackground(Color.LIGHT_GRAY.brighter());	
	}
	
	private static Employee retriveEmployeeFromDatabase(){
	      Employee employee = new Employee();
	      
	      employee.setName(Gui.addNameT.getText());              ///BU METHOD DA YENÝ EKLENDÝ
	      employee.setId(addEmpIdT.getText());
	      employee.setSalary(addSalaryT.getText());              ////Gui classýnýn  içine (constructurun deðil)
	      employee.setPassword(empPasswordT.getText());
	    

	      
	      return employee;
	   }
	
	
	public String[] availableCars() throws IOException{
		String data;
		String[] splited;
		BufferedReader reader;
		ArrayList<String> availableCars= new ArrayList<String>();
		
	reader = new BufferedReader(new FileReader("car.txt"));
		
		
		while ((data = reader.readLine()) != null) {
			
		
		availableCars.add(data);
			
			
		} 
		
		reader.close();
		
		
		String [] neededs = new String [availableCars.size()] ;
		
		   for (int i = 0 ; i< availableCars.size();i++) {
	        	neededs[i]=(availableCars.get(i));
	        	
	        }		
		reader.close();
		
		return neededs;
	}
	
	public void showPrice () {
		
		String [] splited;
		String data = availableCarsC.getSelectedItem().toString();
		String neededData;
		String day = dayT.getText();
		
		splited = data.split(",");
		neededData = splited[2];
		
		
		int dayInt = Integer.parseInt(day);
		int priceInt = Integer.parseInt(neededData);
		
		
		int calculetedPrice = dayInt*priceInt;
		
		priceT2.setText(Integer.toString(calculetedPrice));
		
		//System.out.println(calculetedPrice);
		
		
	}
	public void checkLogin() throws IOException {
		
		String data;
		String data2;
		String data3;
		BufferedReader reader;
		BufferedReader reader2;
		BufferedReader reader3;
		String[] splited ;
		String[] splited2 ;
		String[] splited3 ;
		ArrayList<String> mails = new ArrayList<String>(); //For customer enterence AS ID
		ArrayList<String> passwords = new ArrayList<String>(); // Customer accs passwords
		ArrayList<String> mails2 = new ArrayList<String>(); //For customer enterence AS ID
		ArrayList<String> passwords3 = new ArrayList<String>(); // Customer accs passwords
		ArrayList<String> ids  = new ArrayList<String>(); //For employee enterence AS ID
		ArrayList<String> passwords2 = new ArrayList<String>(); // employee accs passwords
		Singeleton singeleton = Singeleton.getInstance();

		int switchVal = 0;
		
		
		/////////// Customer Company Login Part
	
		
		reader = new BufferedReader(new FileReader("dataC.txt"));
		
		
		while ((data = reader.readLine()) != null) {
			//System.out.println(data);
			splited = data.split(",");
			//System.out.println("Items  = " + Arrays.toString(splited));
			mails.add(splited[0]);
			passwords.add(splited[1]); 
			
			
		} 
		
		reader.close();
		////////// Employee Login Part
		
		reader2 = new BufferedReader (new FileReader("Employees.txt"));
		while((data2 = reader2.readLine())!= null) {
			//System.out.println(data2);
			splited2 = data2.split(",");
			ids.add(splited2[0]);
			passwords2.add(splited2[1]);
			
			
		}
		reader2.close();
		
		////////// Normal Customer Login Part
		
		reader3 = new BufferedReader(new FileReader("data.txt"));
		while ((data3 = reader3.readLine()) != null) {
			//System.out.println(data3);
			splited3 = data3.split(",");
			mails2.add(splited3[0]);
			passwords3.add(splited3[1]); 
			} 
		
		
		reader3.close();
		
		
		
		for (int i =0 ; i<mails.size() ; i++) {
			
			if (idT.getText().toString().equals(mails.get(i)) && passwordT.getText().toString().equals(passwords.get(i))) {
				
				//System.out.println("Login Succesfully");
				switchVal=1; /// To provide case 1 /// Customer Login
				}
			else if (idT.getText().toString().equals(mails2.get(i)) && passwordT.getText().toString().equals(passwords3.get(i))) {
				//System.out.println("Login Succesfully Company");
				switchVal=1;
				
			}
			else {
				System.out.println("Wrong");} 
		
		}
		
		for (int j = 0 ; j<ids.size();j++) {
			
			if (idT.getText().toString().equals(ids.get(j)) && passwordT.getText().toString().equals(passwords2.get(j))) {
				
			//	System.out.println("Login Succesfully");
				switchVal=2;
				}
			else {
				System.out.println("Wrong");} 	
			
			
		}
		
		if (idT.getText().toString().equals("admin") && passwordT.getText().toString().equals("123456789")) {
			
			//System.out.println("Login Succesfully");
			switchVal=3;
			}
		
		
	
		switch (switchVal) {
		case 0 :
			JFrame f1 = new JFrame();
			JOptionPane.showMessageDialog(f1, "Login is not successful");
			break;
		
		case 1 :
			
			   image2.setBounds(0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	           add(centerPanel2,BorderLayout.CENTER);
	           centerPanel.setVisible(false);
	           centerPanel2.setVisible(true);
	           centerPanel2.add(image2);
	           break;
			
			
		case 2 :
			   image2.setBounds(0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
			   add(centerPanel4,BorderLayout.CENTER);
	           singeleton.add(idT.getText());
	           centerPanel.setVisible(false);
	           centerPanel4.setVisible(true);
	           centerPanel4.add(this.image2);
	           break;
	            
			
			
		case 3 :	
		       image2.setBounds(0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
	           add(centerPanel3,BorderLayout.CENTER);
	           centerPanel.setVisible(false);
	           centerPanel3.setVisible(true);
	           centerPanel3.add(this.image2);
	           break;
		
		
		}
		
		
		
		
	}
	
	public void visibilityCheck (JPanel panel ) {
		
		   image2.setBounds(0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
			panel.add(image2);
			
           add(panel,BorderLayout.CENTER);
           centerPanel.setVisible(false);
           panel.setVisible(true);
        //   panel.add(image2);
		
		
	}
	
	
	public void visibilityCheckWithEast (JPanel panel , JPanel panel2) {
		
		image3.setBounds(0, 0, 300, 600);
		panel2.add(image2);
		//image2.setBounds(0, 0, 900, 600);
		panel.add(image3);
		
		
		
		//  image2.setBounds(0, 0, WINDOW_HEIGHT, WINDOW_WIDTH);
          add(panel,BorderLayout.CENTER);
          add(panel2,BorderLayout.EAST);
          
          panel.setVisible(true);
       //   panel.add(image2);
          panel2.setVisible(true);
       //   panel2.add(image2);
          
          
       //   panel.setVisible(true);
       //   panel.add(image2);
          centerPanel2.setVisible(false);
		
	}

	public void setAllInvisibleAdmin(){
		
		centerPanel3.setVisible(false);
		centerPanel6.setVisible(false);
		centerPanel8.setVisible(false);
		centerPanel9.setVisible(false);
		centerPanel11.setVisible(false);
		eastPanel2.setVisible(false);
		eastPanel3.setVisible(false);
		eastPanel4.setVisible(false);
		eastPanel5.setVisible(false);
		eastPanel6.setVisible(false);
		
		
	}
	
	public void setAllInvisibleCustomer () {
		centerPanel2.setVisible(false);
		//centerPanel5.setVisible(false);
		centerPanel10.setVisible(false);
		centerPanel11.setVisible(false);
	    centerPanel12.setVisible(false);
	//	eastPanel1.setVisible(false);
/*		eastAudi.setVisible(false);
		eastBmw.setVisible(false);
		eastFiat.setVisible(false);
		eastMercedes.setVisible(false);*/
		
		
	}
	
	/*public int priceHandler(String selectedPack , int price1 ) {
	
		
		switch(selectedPack) 
        { 
            case "Classic Packet": 
            	price1=price1+100;
            	
                break; 
            case "Sport Packet" :
            	price1=price1+200;
            	
            	
                break;
            case "Premium Packet":
            	price1=price1+300;
            	
            	break;
        }
		return price1;
		
		
		
	}*/
	public String[] MyRentedCars() throws IOException{
        
        String newId=idT.getText();
        

     BufferedReader reader;
     String data;
     String[] splited;
    

     File file=new File("RentedCars.txt");
     reader = new BufferedReader(new FileReader("RentedCars.txt"));
     ArrayList<CarD> car1=new ArrayList<>();
        
      while((data=reader.readLine())!=null){

        splited=data.split(",");
         String id=(splited[0]);
         String platee=(splited[1]);
         String model=(splited[2]);
         String price=(splited[3]);
         String packagee=(splited[4]);
        
         
       

         CarD car=new CarD(id,platee, model,price,packagee);
         car1.add(car);
     }
        reader.close();
	
	
	String [] neededs = new String [car1.size()] ;
            ArrayList<String> arr1=new ArrayList<String>();
	
	   for (int i = 0 ; i< neededs.length;i++) {
                   
                   if(car1.get(i).getId().equals(idT.getText())){
                   
        	neededs[i]=(car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
        	}
        }		
               
               for (int i =0 ; i<neededs.length ; i++){
                   
                   if (neededs[i]!=null){
                       
                       arr1.add(neededs[i]);
                   }
               }
               
               String [] neededs2 = new String[arr1.size()];
               
               for (int i =0 ; i<neededs2.length ; i++){
                   neededs2[i]=arr1.get(i).toString();
                   
               }
	reader.close();
	
	return neededs2;
       
    }
	
	 public void returnCar() throws FileNotFoundException, IOException{
         
         String data = (String)rentedCarsC.getSelectedItem();
         
         BufferedWriter writer;
         BufferedWriter writer2;
         BufferedReader reader;
      String[] splited;
     
      
      File file=new File("RentedCars.txt");
      reader = new BufferedReader(new FileReader("RentedCars.txt"));
      ArrayList<CarD> car1=new ArrayList<>();
         
      

          splited=data.split(",");
          String platee=(splited[0]);
         
         
      
          while((data=reader.readLine())!=null){

         splited=data.split(",");
          String id=(splited[0]);
          String plate2=(splited[1]);
          String model=(splited[2]);
          String price=(splited[3]);
          String packagee=(splited[4]);
         
          
        

          CarD car=new CarD(id,plate2, model,price,packagee);
          car1.add(car);
      }
          reader.close();
         
          writer2=new BufferedWriter(new FileWriter("Car.txt",true));
          
          for(int i=0;i<car1.size();i++){
              if(car1.get(i).getPlateD().equals(platee)){
              
              writer2.write(car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
              writer2.newLine();
              }
          }
          writer2.close();
          
        
          
       for(int i=0;i<car1.size();i++){
              
              if(car1.get(i).getPlateD().equals(platee)){
                  
                  car1.remove(i);
              }
              
          }
          file.delete();
          file.createNewFile();
          
         writer=new BufferedWriter(new FileWriter("RentedCars.txt",true));
          
           
          
          for(int i=0;i<car1.size();i++){
              
              
              writer.write(car1.get(i).getId()+","+car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
              writer.newLine();
              
          }
          writer.close();  
     }
        public void rentCar() throws FileNotFoundException, IOException{
            
         String selectedCar = (String)availableCarsC.getSelectedItem();
         String selectedPayment = (String) paymentTypeC.getSelectedItem();
        
         
         
         Context context ;
         
   
         
        
         	String[] splited;
         	BufferedReader reader;
            splited=selectedCar.split(",");
             String plate=(splited[0]);
             int priceForStrategy = Integer.parseInt(splited[2]);
             
             
         File file=new File("Car.txt");
         reader = new BufferedReader(new FileReader("Car.txt"));
         
         
       
         ArrayList<CarD> car1=new ArrayList<>();
            
          while((selectedCar=reader.readLine())!=null){

            splited=selectedCar.split(",");
             String platee=(splited[0]);
             String model=(splited[1]);
             String price=(splited[2]);
             String packagee=(splited[3]);
             
             
           

             CarD car=new CarD(platee, model,price,packagee);
             car1.add(car);
     
          									}
          reader.close();
          BufferedWriter writer;
          writer=new BufferedWriter(new FileWriter("RentedCars.txt",true));

           for(int i=0;i<car1.size();i++){

            if(car1.get(i).toString().equals(plate)){
               
              
             
              writer.write(idT.getText()+","+car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
              writer.newLine();
               
                car1.remove(i);
            }

        }
           writer.close();
       
           file.delete();
          
          file.createNewFile();
          
            BufferedWriter writer2;
            writer2=new BufferedWriter(new FileWriter("Car.txt",true));
          
          for(int i=0;i<car1.size();i++){


              
          writer2.write(car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
          writer2.newLine();


        }
            writer2.close();  
            

            
            switch(selectedPayment) 
   	        { 
            
           
   	            case "Credit Card": 
   	            	//System.out.println("Burdayým CC"+priceForStrategy);
   	            	context = new Context (new CreditCard());  
   	            	context.doPayment(priceForStrategy);
   		
   	                break; 
   	                
   	            case "Cash":
   	            	//System.out.println("Burdayým CASH");

   	            	context = new Context (new Cash());
   	            	context.doPayment(priceForStrategy);
   	            	break;
   	            
   	            case "Indenture":
   	            	//System.out.println("Burdayým ÝÞTE");
   	            	

   	            	context = new Context (new Bill());
   	            	context.doPayment(priceForStrategy);
   	            	break;
   	        }   
            
            
        }
        
        
	
	public void addCar() throws IOException {
		
		 	String selectedPackage = (String)packageC.getSelectedItem();
		    String selectedCar = (String)brandC.getSelectedItem();
		   	String selectedPrice = priceT.getText();
		    String selectedPlate = plateT.getText();
		   
		   //System.out.println(selectedPackage+selectedCar+selectedPlate);
		   if (selectedPackage.equals("Sport"))  {
	    		     
		    		   switch(selectedCar) 
		    	        { 
		    	            case "BMW-M3": 
		    	            	Car s1 = new SportPackDecorator(new BmwM3());
		    	            	s1.operateCar(selectedCar, selectedPlate , selectedPrice);
		    	            	
		    	                break; 
		    	            case "BMW-M4":
  
		    	            	Car s2 = new SportPackDecorator(new BmwM4());
		    	            	s2.operateCar(selectedCar, selectedPlate , selectedPrice );
		    	            	break;
		    	            case "AUDÝ-A6":
		    	            	Car s3 = new SportPackDecorator(new AudiA6());
		    	            	s3.operateCar(selectedCar, selectedPlate , selectedPrice);
		    	            	break;
		    	            case "AUDÝ-A7": 
		    	            	Car s4 = new SportPackDecorator(new AudiA7());
		    	            	s4.operateCar(selectedCar, selectedPlate , selectedPrice);
		    	                break; 
		    	            case "FÝAT-LINEA":
		    	            	Car s5 = new SportPackDecorator(new FiatLinea());
		    	            	s5.operateCar(selectedCar, selectedPlate, selectedPrice);
		    	            	break;
		    	            case "FIAT-EGEA":
		    	            	Car s6 = new SportPackDecorator(new FiatEgea());
		    	            	s6.operateCar(selectedCar, selectedPlate, selectedPrice);
		    	            	break;
		    	            case "MERCEDES-C180": 
		    	            	Car s7 = new SportPackDecorator(new MercedesC180());
		    	            	s7.operateCar(selectedCar, selectedPlate, selectedPrice);
		    	                
		    	                break; 
		    	            case "MERCEDES-E250":
		    	            	Car s8 = new SportPackDecorator(new MercedesE250());
		    	            	s8.operateCar(selectedCar, selectedPlate, selectedPrice);
		    	            	break;
		    	          
		    	            
				
		    	   }
		    	   }
		   else if (selectedPackage.equals("Premium"))  {
  		     
    		   switch(selectedCar) 
    	        { 
    	            case "BMW-M3": 
    	            	Car s1 = new PremiumPackDecorator(new BmwM3());
    	            	s1.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	
    	                break; 
    	            case "BMW-M4":

    	            	Car s2 = new PremiumPackDecorator(new BmwM4());
    	            	s2.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "AUDÝ-A6":
    	            	Car s3 = new PremiumPackDecorator(new AudiA6());
    	            	s3.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "AUDÝ-A7": 
    	            	Car s4 = new PremiumPackDecorator(new AudiA7());
    	            	s4.operateCar(selectedCar, selectedPlate, selectedPrice);
    	                break; 
    	            case "FÝAT-LINEA":
    	            	Car s5 = new PremiumPackDecorator(new FiatLinea());
    	            	s5.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "FIAT-EGEA":
    	            	Car s6 = new PremiumPackDecorator(new FiatEgea());
    	            	s6.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "MERCEDES-C180": 
    	            	Car s7 = new PremiumPackDecorator(new MercedesC180());
    	            	s7.operateCar(selectedCar, selectedPlate, selectedPrice);
    	                
    	                break; 
    	            case "MERCEDES-E250":
    	            	Car s8 = new PremiumPackDecorator(new MercedesE250());
    	            	s8.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	
    	   }
    	   }
		   
		   else if (selectedPackage.equals("Classical"))  {
  		     
    		   switch(selectedCar) 
    	        { 
    	            case "BMW-M3": 
    	            	Car s1 = new ClassicPackDecorator(new BmwM3());
    	            	s1.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	
    	                break; 
    	            case "BMW-M4":

    	            	Car s2 = new ClassicPackDecorator(new BmwM4());
    	            	s2.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "AUDÝ-A6":
    	            	Car s3 = new ClassicPackDecorator(new AudiA6());
    	            	s3.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "AUDÝ-A7": 
    	            	Car s4 = new ClassicPackDecorator(new AudiA7());
    	            	s4.operateCar(selectedCar, selectedPlate, selectedPrice);
    	                break; 
    	            case "FÝAT-LINEA":
    	            	Car s5 = new ClassicPackDecorator(new FiatLinea());
    	            	s5.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "FIAT-EGEA":
    	            	Car s6 = new ClassicPackDecorator(new FiatEgea());
    	            	s6.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	            case "MERCEDES-C180": 
    	            	Car s7 = new ClassicPackDecorator(new MercedesC180());
    	            	s7.operateCar(selectedCar, selectedPlate, selectedPrice);
    	                
    	                break; 
    	            case "MERCEDES-E250":
    	            	Car s8 = new ClassicPackDecorator(new MercedesE250());
    	            	s8.operateCar(selectedCar, selectedPlate, selectedPrice);
    	            	break;
    	          
    	            
		
    	   }
    	   }
		
		
	}
	public void deleteCar()throws IOException{
            
            
            String plate=plateT2.getText();
            
 
         BufferedReader reader;
         String data;
         String[] splited;
        

         File file=new File("Car.txt");
         reader = new BufferedReader(new FileReader("Car.txt"));
         ArrayList<CarD> car1=new ArrayList<>();
            
          while((data=reader.readLine())!=null){

            splited=data.split(",");
             String platee=(splited[0]);
             String model=(splited[1]);
             String price=(splited[2]);
             String packagee=(splited[3]);
            
             
           

             CarD car=new CarD(platee, model,price,packagee);
             car1.add(car);
         }
            reader.close();
            
            for(int i=0;i<car1.size();i++){

            if(car1.get(i).toString().equals(plate)){
                car1.remove(i);
            }

        }
            
            file.delete();


      file.createNewFile();
      
      BufferedWriter bf;
        bf=new BufferedWriter(new FileWriter("Car.txt",true));
         for(int i=0;i<car1.size();i++){



          bf.write(car1.get(i).getPlateD()+","+car1.get(i).getModelD()+","+car1.get(i).getPrice()+","+car1.get(i).getPackageD());
          bf.newLine();


        }
         bf.close();
            
        }

	public void deleteEmp() throws IOException{

        String id=RemoveIdT.getText();

         BufferedReader reader;
         BufferedWriter bf2;
         bf2=new BufferedWriter(new FileWriter("GelirCash.txt",true));
         
         
         
         String data;
         String[] splited;

         File file=new File("Employees.txt");
         reader = new BufferedReader(new FileReader("Employees.txt"));
         ArrayList<EmployeeD> emp1=new ArrayList<>();
         while((data=reader.readLine())!=null){

             splited=data.split(",");
             String id1=(splited[0]);
             String password=(splited[1]);
             String name=(splited[2]);
             String position=(splited[3]);
             String salary=(splited[4]);

             EmployeeD emp=new EmployeeD(name, salary, id1, password, position);
             emp1.add(emp);
         }
         reader.close();

        for(int i=0;i<emp1.size();i++){

            if(emp1.get(i).toString().equals(id)){
               
                bf2.newLine();
                bf2.write(emp1.get(i).getSalary());
                emp1.remove(i);
                
         
            }

        }
        bf2.close();
         file.delete();


      file.createNewFile();

        BufferedWriter bf;
        bf=new BufferedWriter(new FileWriter("Employees.txt",true));
         for(int i=0;i<emp1.size();i++){



          bf.write(emp1.get(i).getId()+","+emp1.get(i).getPassword()+","+emp1.get(i).getName()+","+emp1.get(i).getPosition()+","+emp1.get(i).getSalary());
          bf.newLine();



        }
         bf.close();
     }
	
	public void setShiftMethod () throws IOException{
		
		ArrayList <String> shiftDetails = new ArrayList<String>();
		
		//Vakit kalýrsa fixle
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("EmpShift.txt",true));
		
		shiftDetails.add(emp.getSelectedItem().toString());
		shiftDetails.add(sundayC.getSelectedItem().toString());
		shiftDetails.add(mondayC.getSelectedItem().toString());
		shiftDetails.add(tuesdayC.getSelectedItem().toString());
		shiftDetails.add(wednesdayC.getSelectedItem().toString());
		shiftDetails.add(thursdayC.getSelectedItem().toString());
		shiftDetails.add(fridayC.getSelectedItem().toString());
		shiftDetails.add(saturdayC.getSelectedItem().toString());
		
		
		for (int i = 0; i<shiftDetails.size() ; i ++ ) {
		writer.write(shiftDetails.get(i).toString()+",");
			
			
		}
		writer.newLine();
		writer.close();
		
	}
	
	public String[] stringsRentedCars() throws IOException{

        String data;
        String[] splited;
        BufferedReader reader;
       ArrayList<String> MyRentedCars= new ArrayList<String>();
       //System.out.println(idT);
    
      reader = new BufferedReader(new FileReader("RentedCars.txt"));


      while ((data = reader.readLine()) != null) {


    	  splited=data.split(",");
            String id=(splited[0]);

            if(idT.getText().equals(splited[0])){
                MyRentedCars.add(data);
            }

    } 

    reader.close();


    String [] neededs = new String [MyRentedCars.size()] ;

       for (int i = 0 ; i< MyRentedCars.size();i++) {
            neededs[i]=(MyRentedCars.get(i));

        }
    reader.close();

    return neededs;

    }
	
	public String[] employeeToComboBox () throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Employees.txt"));
		String data;
		String [] splited = null;
		//String [] neededs = new String [5] ;
		ArrayList <String> arrayList= new ArrayList<String>();
		ArrayList <String> arrayList2 = new ArrayList<String>();
		
		while ((data = reader.readLine()) != null) {
			//System.out.println(data);
			splited = data.split(",");
			arrayList2.add(splited[0]);
			arrayList.add(splited[2]);
			} 
			String [] neededs = new String [arrayList.size()] ;
	
		   for (int i = 0 ; i< arrayList.size();i++) {
	        	neededs[i]=(arrayList2.get(i));
	        	
	        }		
		reader.close();
		
		return neededs;
	
	}

}

class Singeleton {
	
	private static Singeleton singeletona = new Singeleton();
	 String[] columns = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	 String[] columns2 = {"Income","Expense","Profit"};
	 Object[] data ;
	 
     DefaultTableModel tableModel = new DefaultTableModel(columns,0);    
     DefaultTableModel tableModel2 =new DefaultTableModel(columns2,0);
     
  

	//DataEmp d1 ;
	
	
	private Singeleton () {}
	
	public static Singeleton getInstance () {
		
		return singeletona;
		
	}
	
	public void add (String id) throws IOException {
		
			String data;
			String splited[];
			ArrayList <String> idList = new ArrayList<String>();
			ArrayList <String> shiftsForSelectedID = new ArrayList<String>();
		
			BufferedReader reader = new BufferedReader(new FileReader("EmpShift.txt"));
		
			while ((data = reader.readLine()) != null) {
				splited = data.split(",");
				idList.add(splited[0]);
				if (id.equals(splited[0])) {
					for (int i = 1; i<8 ; i++) {
						shiftsForSelectedID.add(splited[i]);
						
					}
					
				}
				 } 
			
			
			reader.close();
			
			
		//	System.out.println(shiftsForSelectedID.get(0).toString()+shiftsForSelectedID.get(1).toString()+shiftsForSelectedID.get(2).toString()+shiftsForSelectedID.get(3).toString());
		//	System.out.println(shiftsForSelectedID.get(4).toString()+shiftsForSelectedID.get(5).toString()+shiftsForSelectedID.get(6).toString());

			//d1.datas = new ArrayList<DataEmp>();
			// d1.datas.add(d1);
			Object[] data2 = {shiftsForSelectedID.get(0),shiftsForSelectedID.get(1),shiftsForSelectedID.get(2),shiftsForSelectedID.get(3),
					shiftsForSelectedID.get(4),shiftsForSelectedID.get(5),shiftsForSelectedID.get(6)};
			Object[] data3 = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			
			tableModel.addRow(data3);
			tableModel.addRow(data2);
			
		
		
	}
	 
	public void add2 () throws Throwable {
		
		
		
	
		Accounting a3 = new Profit ();
			a3.dataOperations();
		
          
		Object[] data  = {Accounting.sumIncome,Accounting.sumExpense,Accounting.sum};
		
	
	
		tableModel2.addRow(data);
		
}
	
		
	}

	
	

	

/*class DataEmp {
	String isim;
	String soyisim;
	String telefon;
	String email;
	ArrayList <DataEmp> datas;
	
	public DataEmp(String isim , String soyisim) {
		
		this.isim=isim;
		this.soyisim=soyisim;
		
	}
	public DataEmp(String isim , String soyisim,String telefon,String email,ArrayList <DataEmp> datas) {
		
		this.isim=isim;
		this.soyisim=soyisim;
		this.telefon=telefon;
		this.email=email;
		this.datas=datas;
		
	}
	
	

	
}
*/



class test{

    public static void main(String[] args) throws IOException {
    	
    
    		
    		
    		
          Gui gui=new Gui();
          
      
      
        

           
    }
    

}