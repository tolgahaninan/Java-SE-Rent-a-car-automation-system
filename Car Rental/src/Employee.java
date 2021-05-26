
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Employee {

   private String name;
   private String salary;
   private String id;
   private String password;
   private String position;


   
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getSalary() {
      return salary;
   }
   
   public void setSalary(String salary) {
      this.salary = salary;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}

class EmployeeView extends JFrame implements ActionListener{
        
private final int WINDOW_HEIGHT = 300;
private final int WINDOW_WIDTH = 150;


        private JPanel mvc;
        private JLabel area;
        private JButton button;
        public void printEmployeeDetails(String name, String salary,String id,String password,String position){
        setTitle ("RentingMenagement");
        setSize (WINDOW_HEIGHT,WINDOW_WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
       

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
     
          
        mvc=new JPanel();
          mvc.setLayout(null);
        
          area=new JLabel(name+" Added");
          area.setBounds(80, 0, 300, 80);
           area.setFont(new Font("sansserif", Font.ITALIC, 22));
          mvc.add(area);
          
          button=new JButton("OK");
       button.setBounds(100, 80, 80, 30);
       button.setFont(new Font("Courier New", Font.BOLD, 20));
       mvc.add(button);
       button.addActionListener((ActionListener)this);
           
          
         
           add(mvc,BorderLayout.CENTER);
           
          mvc.setVisible(true);
            setVisible(true);
                  }
        
        public void setlabel(String name,String salary,String id,String password){
            area.setText(name+" "+salary+" "+id+" "+password);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button){
            
            mvc.setVisible(false);
            setVisible(false);
        }
        
    }
        
    }

class EmployeeController{
    BufferedWriter bf,bf2;
    FileWriter fw;
    private Employee model;
   private EmployeeView view;
   
   
   public EmployeeController(Employee model, EmployeeView view){
      this.model = model;
      this.view = view;
   }
 
   public void setEmployeePosition(String position){
       
       model.setPosition(position);
   }
   
   public String getEmployeePosition(String position){
       
       return model.getPosition();
   }
   
   public void setEmployeeName(String name){
      model.setName(name);		
   }

   public String getEmployeeName(){
      return model.getName();		
   }
   
    public void setEmployeeSalary(String salary){
      model.setSalary(salary);		
   }

   public String getEmployeeSalary(){
      return model.getSalary();		
   }
  
    public void setEmployeeId(String id){
      model.setId(id);		
   }

   public String getEmployeeId(){
      return model.getId();		
   }
   
   public void setEmployeePassword(String password){
      model.setId(password);		
   }

   public String getEmployeePassword(){
      return model.getPassword();		
   }
   
  
   
    public void updateView() throws IOException{				
      view.printEmployeeDetails(model.getName(), model.getSalary(), model.getId(), model.getPassword(),model.getPosition());
      
      bf=new BufferedWriter(new FileWriter("Employees.txt",true));
      bf2=new BufferedWriter(new FileWriter("Gider.txt",true));
           
             bf.write(model.getId()+","+model.getPassword()+","+model.getName()+","+model.getPosition()+","+model.getSalary());
             bf.newLine();
             bf.close();
             
             bf2.newLine();
             bf2.write(model.getSalary());
             bf2.close();
   }	
   
}

