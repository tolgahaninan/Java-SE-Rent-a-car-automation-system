import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Car {
	
	
	void operateCar(String model, String plate , String price) throws IOException;

	
}

abstract class CarDecorator implements Car{
	
	protected Car c1;
	
	public CarDecorator(Car c1) {
		this.c1=c1;
		
	}
	public void operateCar(String model , String plate, String price) throws IOException {
		c1.operateCar(model, plate , price);
	
	}
	
}



class BmwM3 implements Car  {
	
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	public int cost = 500;
	

	


	@Override
	public void operateCar(String model , String plate , String price) throws IOException {

			
			writer = new BufferedWriter(new FileWriter("Car.txt",true));
			
			writer.write(plate+","+model+","+price+",");
			writer.close();
	
		
		
	}


	
}
class BmwM4 implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	

	@Override
	public void operateCar(String model ,String plate, String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}

	
	
	
	
}
class MercedesE250 implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	


	@Override
	public void operateCar(String model ,String plate , String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}

}
class MercedesC180 implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	

	@Override
	public void operateCar(String model ,String plate ,String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}
	
}
	
	

class AudiA6 implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;

	

	@Override
	public void operateCar(String model ,String plate, String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}
	
	
}
class AudiA7 implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	
	

	@Override
	public void operateCar(String model ,String plate,String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}
	
	
}
class FiatLinea implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	int cost = 300;
	
	

	@Override
	public void operateCar(String model ,String plate,String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}



	
	
	
}
class FiatEgea implements Car{
	Gui g1;
	BufferedWriter writer;
	BufferedReader reader;
	int cost = 400;
	

	@Override
	public void operateCar(String model ,String plate,String price) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		
		writer.write(plate+","+model+","+price+",");
		writer.close();		
	}


	
	
}


////////////////////////////////////// DECORATORS

class PremiumPackDecorator extends CarDecorator{
	BufferedWriter writer;

	public PremiumPackDecorator(Car c1) {
		super(c1);
	
		// TODO Auto-generated constructor stub
	}
	
	public void operateCar (String model,String plate,String price) throws IOException {
		c1.operateCar(model, plate, price);
		setPremium(c1);
		
		
		
	}
	public void setPremium(Car c1) throws IOException{
		
		
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		writer.write("Premium Package");
		writer.newLine();
		writer.close();
		
		
	}

	
	
}

class ClassicPackDecorator extends CarDecorator{
	BufferedWriter writer;

	public ClassicPackDecorator(Car c1) {
		super(c1);
	
		// TODO Auto-generated constructor stub
	}
	
	public void operateCar (String model,String plate,String price) throws IOException {
		c1.operateCar(model, plate, price);
		setClassic(c1);
		
		
	}
	public void setClassic(Car c1) throws IOException{
		
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		writer.write("Classic Package");
		writer.newLine();
		writer.close();
	}


	
	
}

class SportPackDecorator extends CarDecorator{
	BufferedWriter writer;
	BufferedWriter writer2;

	public SportPackDecorator(Car c1) {
		super(c1);
	
		// TODO Auto-generated constructor stub
	}
	
	public void operateCar (String model,String plate,String price) throws IOException {
		c1.operateCar(model, plate, price);
		setSport(c1);
		
		
	}
	public void setSport(Car c1) throws IOException{
		
		writer = new BufferedWriter(new FileWriter("Car.txt",true));
		writer.write("Sport Package");
		writer.newLine();
		writer.close();
		
	}


	
}


