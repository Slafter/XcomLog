package xcom.log;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

public class XcomLog {

	/**
	 * @param args
	 * @throws WriteException 
	 */
	public static void main(String[] args) throws BiffException, IOException, WriteException {
		// TODO Auto-generated method stub
			
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
		
		CalendarSheet myCalendarSheet = new CalendarSheet();
		Operation myOperation1 = new Operation(Operation.ALIEN_ABDUCTION, Operation.UNITED_STATES);
		myOperation1.setKills(10);
		myOperation1.setInjuries(2);
		myOperation1.setName("Blinding Heat");
		
		Operation myOperation2 = new Operation(Operation.UFO_CRASH, Operation.CANADA);
		myOperation2.setKills(12);
		myOperation2.setInjuries(1);
		myOperation2.setName("Severed Thorn");
		
		myCalendarSheet.addEvent(myOperation1, 0);
		myCalendarSheet.addEvent(myOperation2, new GregorianCalendar(2015, 3, 1));
		
		System.out.print(myCalendarSheet.getEvent(0, 0).toString());
		System.out.println();
		System.out.print(myCalendarSheet.getEvent(0, 1).toString());
		
		// so like, did all that push pull stuff work?
		
		

	}

}
