import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Accounting {

	public static int  sumExpense ;
	public static  int  sum ;
	public static int   sumIncome ;
	String data;
	int temp;
	
	ArrayList<Integer> listIncomeData = new ArrayList<>();
	ArrayList<Integer> listExpenseData = new ArrayList<>();
	abstract void readData()throws Throwable;
	abstract void organizeData()throws Throwable;
	

	public final void dataOperations() throws Throwable {
		readData();
		organizeData();
		
	}
	
}


class Income extends Accounting {
	

	@Override
	void readData() throws Throwable {
		File incomeFile = new File ("gelirCC.txt");
		File incomeFile2 = new File ("gelirCash.txt");
		File incomeFile3 = new File ("gelirBill.txt");
		
		BufferedReader reader	 = null;
		reader = new BufferedReader (new FileReader(incomeFile));
		
		while ((data = reader.readLine()) != null) {
			temp = Integer.valueOf(data);
			listIncomeData.add(temp);
		
		  } 
		reader = new BufferedReader (new FileReader(incomeFile2));
		while ((data = reader.readLine()) != null) {
			temp = Integer.valueOf(data);
			listIncomeData.add(temp);
		
		  } 
		reader = new BufferedReader (new FileReader(incomeFile3));
		while ((data = reader.readLine()) != null) {
			temp = Integer.valueOf(data);
			listIncomeData.add(temp);
		
		  } 
		
		//	System.out.println(listIncomeData);

		reader.close();
	}

	@Override
	void organizeData() {
		for (int i =0 ; i<listIncomeData.size() ; i++) {
			sumIncome = sumIncome +listIncomeData.get(i);
			
		}
		//System.out.println(sumIncome);

	}
	
	
}

class Expense extends Accounting {
	

	@Override
	void readData() throws Throwable {
		File expenseFile = new File ("gider.txt");
		BufferedReader reader	 = null;
		reader = new BufferedReader (new FileReader(expenseFile));
		
		while ((data = reader.readLine()) != null) {
			temp = Integer.valueOf(data);
			listExpenseData.add(temp);
		
		  } 
			//System.out.println(listExpenseData);

		reader.close();
	}

	@Override
	void organizeData() {
		for (int i =0 ; i<listExpenseData.size() ; i++) {
			sumExpense = sumExpense +listExpenseData.get(i);
			
		}
		//System.out.println(sumExpense);

	}
	
	
}

class Profit extends Accounting {
	

	Expense e1 = new Expense();
	Income i1 = new Income();
	@Override
	void readData() throws Throwable {
		e1.readData();
		i1.readData();
	
		
	}

	@Override
	void organizeData() {
		e1.organizeData();
		i1.organizeData();
		Accounting.sum = Accounting.sumIncome-Accounting.sumExpense;
		//System.out.println(Accounting.sum);
	
			
		
		

	}
	
	
}
	

	
	
