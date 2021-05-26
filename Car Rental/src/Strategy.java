import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;

interface Strategy {

	public void doPayment(int amount) throws IOException ;
	
	
}


class CreditCard implements Strategy {
	BufferedWriter writer;
	
	@Override
	public void doPayment(int amount) throws IOException {
		writer=new BufferedWriter (new FileWriter("GelirCC.txt",true));
		writer.write(String.valueOf(amount));
		writer.newLine();
		writer.close();
	}
	
}

class Cash implements Strategy {
	BufferedWriter writer;

	@Override
	public void doPayment(int amount) throws IOException {
		writer=new BufferedWriter (new FileWriter("GelirCash.txt",true));
		writer.write(String.valueOf(amount));
		writer.newLine();
		writer.close();
		
	}
	
	
}
class Bill implements Strategy {
	BufferedWriter writer;
	
	@Override
	public void doPayment(int amount) throws IOException {
		
		writer=new BufferedWriter (new FileWriter("GelirBill.txt",true));
		writer.write(String.valueOf(amount));
		writer.newLine();
		writer.close();
	}
	
	
}

class Context {
	private Strategy strategy;
	
	
	public Context (Strategy strategy) {
		this.strategy=strategy;
		
	}
	
	public void doPayment (int amount) throws IOException {
		strategy.doPayment(amount);
		
	}
	
	
}



