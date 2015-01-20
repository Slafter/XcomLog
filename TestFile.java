package xcom.log;

import java.io.IOException;
import javax.swing.*;

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
		
		JLabel infoText = new JLabel("Welcome to the XCOM Log");
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
		infoFrame.setVisible(true);
	}

}
