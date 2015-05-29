package xcom.log;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import xcom.log.event.Operation;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

public class XcomLog {

	public static void main(String[] args) throws BiffException, IOException, WriteException {
			
		/*WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls")); 
		
		WritableSheet sheet1 = workbook.createSheet("First Sheet", 0);
		WritableSheet sheet2 = workbook.createSheet("Second Sheet", 1);
		
		Label label = new Label(0, 2, "Label");
		sheet1.addCell(label);

		Number number = new Number(3, 4, 3.1459);
		sheet2.addCell(number); 
		
		WritableHyperlink hyperlink = new WritableHyperlink(0, 4, "Second Sheet", sheet2, 1, 2);
		sheet1.addHyperlink(hyperlink);
		
		workbook.write();
		workbook.close(); 
		*/
		
		/* JLabel infoText = new JLabel("Welcome to the XCOM Log");
		JButton newGame = new JButton("New Campaign");
		JButton loadGame = new JButton("Load Campaign");
		
		JPanel logPanel = new JPanel();
		logPanel.add(infoText);
		logPanel.add(newGame);
		logPanel.add(loadGame);
		
		JFrame infoFrame = new JFrame();
		infoFrame.add(logPanel);
		infoFrame.setSize(450, 400);
		infoFrame.setTitle("XCOM Log");
		infoFrame.setLocation(500, 250);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setVisible(true); */
		
		Soldier mySoldier1 = new Soldier(new GregorianCalendar(2015, 3, 1), "Aaron", 
				4, 13, 30, 65, 0);
		Soldier mySoldier2 = new Soldier(new GregorianCalendar(2015, 3, 2), "Slafter", 
				3, 15, 25, 70, 2);
		
		CalendarSheet myCalendarSheet = new CalendarSheet();
		Operation myOperation1 = new Operation(Operation.ALIEN_ABDUCTION, Operation.UNITED_STATES, new int[] {0,1});
		myOperation1.setKills(10);
		myOperation1.setInjuries(0);
		myOperation1.setName("Blinding Heat");
		mySoldier1.addOperation(Operation.getNumberOfOperations() - 1, 3, 1, 
				Soldier.ASSAULT, 5, 13, 35, 70, Soldier.NON_WOUNDED, 0);
		mySoldier2.addOperation(Operation.getNumberOfOperations() - 1, 2, 1, 
				Soldier.INFANTRY, 4, 15, 30, 74, Soldier.NON_WOUNDED, 0);
		
		Operation myOperation2 = new Operation(Operation.UFO_CRASH, Operation.CANADA);
		myOperation2.setKills(12);
		myOperation2.setInjuries(1);
		myOperation2.setName("Severed Thorn");
		mySoldier1.addOperation(Operation.getNumberOfOperations() - 1, 3, 1, 
				5, 13, 35, 70, Soldier.NON_WOUNDED, 0);
		mySoldier2.addOperation(Operation.getNumberOfOperations() - 1, 2, 1, 
				4, 15, 30, 74, Soldier.WOUNDED, 12);
		
		Operation myOperation3 = new Operation(Operation.TARGET_ESCORT, Operation.FRANCE);
		myOperation3.setKills(14);
		myOperation3.setName("Banished King");
		mySoldier2.addOperation(Operation.getNumberOfOperations() - 1, 4, Soldier.NON_WOUNDED, 0);
		
		myCalendarSheet.addEvent(myOperation1, 0);
		myCalendarSheet.addEvent(myOperation2, new GregorianCalendar(2015, 3, 1));
		myCalendarSheet.addEvent(myOperation3, new GregorianCalendar(2015, 3, 1));
		
		System.out.print(myCalendarSheet.getEvent(0, 0).toString());
		System.out.println();
		System.out.print(myCalendarSheet.getEvent(0, 1).toString());
		System.out.println();
		System.out.print(myCalendarSheet.getEvent(0, 2).toString());
		
		
		System.out.println();
		System.out.println(mySoldier1.toString());
		System.out.println(mySoldier2.toString());

	}

}
