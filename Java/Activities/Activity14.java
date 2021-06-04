package activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		
		try{
			File file = new File("newfile.txt");
			boolean fstatus = file.createNewFile();
			if(fstatus) {
				System.out.println("New file created");
			}
			else System.out.println("File already exists");
			FileWriter writer = new FileWriter(file);
			writer.write("My New File.");
			writer.close();
			File fileutil = FileUtils.getFile(file);
			System.out.println("Data in file:\n" + FileUtils.readFileToString(fileutil, "UTF8"));
			File destDir = new File("Resources");
			FileUtils.copyFileToDirectory(file, destDir);
			File newFile = FileUtils.getFile(destDir,"newfile.txt");
			System.out.println("Data in new file:\n" + FileUtils.readFileToString(newFile, "UTF8"));
			
		} catch(IOException e){
			e.getMessage();
		}
	}

}
