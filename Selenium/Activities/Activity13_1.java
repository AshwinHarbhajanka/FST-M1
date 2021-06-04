package activities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {

	public static void main(String[] args) throws IOException, CsvException {
		CSVReader csvFile = new CSVReader(new FileReader("csvExample.csv"));
		List<String[]> list = csvFile.readAll();
		System.out.println(list.size());
		Iterator<String[]> itr = list.iterator();
		while(itr.hasNext()) {
			String[] str = itr.next();
			for(int i=0;i<str.length;i++) {
				System.out.print(" "+str[i]);
			}
			System.out.println(" ");
		}
		csvFile.close();
	}

}
