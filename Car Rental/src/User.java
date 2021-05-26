import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public interface User {

	void createAccount () throws IOException;
	
}


class Customer implements User{
	DataUser d1;
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;

	String data;
	String [] splited;
	ArrayList<String>mailCheckArrayList = new ArrayList<String>();
	boolean flag= true;
	
	
	@Override
	public void createAccount() throws IOException {
		
		reader = new BufferedReader(new FileReader("data.txt"));
		
		while ((data = reader.readLine()) != null) {
			//System.out.println(data);
			splited = data.split(",");
			mailCheckArrayList.add(splited[0]);
			 } 
		reader.close();


		String name = Gui.newNameT.getText();
		String email = Gui.newEmailT.getText();
		String mobileNum = Gui.newPhoneT.getText();
		String password = Gui.newPassT.getText();
		ArrayList datasUser = new ArrayList<DataUser>();
		
		
		
		
		for (int i = 0 ; i< mailCheckArrayList.size();i++) {
			if (email.equals(mailCheckArrayList.get(i).toString())) {
				flag = false;
					}
			
		}

		if (flag==true) {
		writer = new BufferedWriter(new FileWriter("data.txt",true));
		
		DataUser d1 = new DataUser(email, password, mobileNum, name,datasUser);
		d1.datas.add(d1);
		
	
		DataUser a1 = (DataUser) datasUser.get(0);
		writer.write(a1.email.toString()+","+a1.þifre.toString()+","+a1.telefon.toString()+","+a1.isim.toString());
		writer.newLine();
	
		//System.out.println(a1.email.toString()+"\0"+a1.þifre.toString()+"\0"+a1.telefon.toString()+"\0"+a1.isim.toString());
		writer.close();}
		
		else if (flag==false) {
			
			JFrame f1 = new JFrame();
			JOptionPane.showMessageDialog(f1, "An account has already been created with this mail adress");
		}
	
	}
	
	
}

class Company implements User {
	DataUser d1;
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	String data;
	String [] splited;
	ArrayList<String>mailCheckArrayListCompany = new ArrayList<String>();
	boolean flag= true;



	@Override
	public void createAccount() throws IOException {
		
		
		reader = new BufferedReader(new FileReader("dataC.txt"));
		
		while ((data = reader.readLine()) != null) {
			//System.out.println(data);
			splited = data.split(",");
			mailCheckArrayListCompany.add(splited[0]);
			 } 
		reader.close();
		
		
		
		String name = Gui.newNameT.getText();
		String email = Gui.newEmailT.getText();
		String mobileNum = Gui.newPhoneT.getText();
		String password = Gui.newPassT.getText();
		ArrayList datasUser = new ArrayList<DataUser>();
		

		for (int i = 0 ; i< mailCheckArrayListCompany.size();i++) {
			if (email.equals(mailCheckArrayListCompany.get(i).toString())) {
				flag = false;
					}
			
		}
		
		
		if(flag==true) {
		writer = new BufferedWriter(new FileWriter("dataC.txt",true));
		
		DataUser d1 = new DataUser(email, password, mobileNum, name,datasUser);
		d1.datas.add(d1);
		
	
		DataUser a1 = (DataUser) datasUser.get(0);
		writer.write(a1.email.toString()+","+a1.þifre.toString()+","+a1.telefon.toString()+","+a1.isim.toString());
		writer.newLine();
	
		//System.out.println(a1.email.toString()+"\0"+a1.þifre.toString()+"\0"+a1.telefon.toString()+"\0"+a1.isim.toString());
		writer.close();}
		else if (flag==false) {
			JFrame f1 = new JFrame();
			JOptionPane.showMessageDialog(f1, "An account has already been created with this mail adress");
			
		}
		
		
	}

	
}

class DataUser {
	String isim,þifre,telefon,email;
	ArrayList <DataUser> datas;
	double bill;
	
	public DataUser(String email , String þifre,String telefon,String isim,ArrayList <DataUser> datas) {
		
		this.isim=isim;
		this.email=email;
		this.telefon=telefon;
		this.þifre=þifre;
		this.datas=datas;
		
	}

	public DataUser (double bill) {
		this.bill=bill;	
	}
	
}



class UserFactory{
	
	public User getUser (String userType) {
		
		if (userType==null) {
			
		return null;
		}
		
		if (userType.equalsIgnoreCase("Customer")) {
			
		return new Customer();	
			
		}
		else if (userType.equalsIgnoreCase("Company")) {
			
		return new Company();
		}
		
		
		return null;
	}
	
	
	
	
}