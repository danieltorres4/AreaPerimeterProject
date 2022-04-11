package data;

import java.awt.Desktop;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import exceptions.*;

public class DataAccessImp implements IDataAccess{
	
	@Override
	public void openFile(String filename) throws DataAccessExc {
		File myPath = new File("files");
		myPath.mkdir();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String directory = sdf.format(date);
		File path = new File(myPath + File.separator + directory);
		File file = new File(path + File.separator + filename + ".txt");
		try{
            Desktop.getDesktop().open(file);
        } catch(IOException e){
            System.out.println(e);
        }
	}
	
	
	@Override
	public void writing(String filename, String content) throws DataWritingExc {
		File myPath = new File("files");
		myPath.mkdir();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String directory = sdf.format(date);
		File path = new File(myPath + File.separator + directory);
		File file = new File(path + File.separator + filename);
		
		try {
			PrintWriter output = new PrintWriter(new FileWriter(file, true));
			output.print(content);
			output.close();
			System.out.println(filename + " has been modified");
		} catch(IOException e) {
			e.printStackTrace();
			throw new DataWritingExc("Exception: " + e.getMessage());
		}
		
	}
	

	@Override
	public String searching(String directory, String toSearch) throws DataReadoutExc {
		File myPath = new File("files");
		myPath.mkdir();
		File path = new File(myPath + File.separator + directory);
		
		if(path.isDirectory()) {
			path.mkdir();
		} else {
			return "Not a directory";
			
		}
		
		File file = new File(path + File.separator + toSearch + ".txt");

		String result = null;
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line = null;
			line = input.readLine();
			
			while(line != null) {
				if(toSearch != null) {
					System.out.println(line);
					break;
				}
				
				line = input.readLine();
			}
			input.close();
			
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new DataReadoutExc("Exception: " + e.getMessage());
		}  catch(IOException e) {
			e.printStackTrace();
			throw new DataReadoutExc("Exception: " + e.getMessage());
		}
		
		return result;
	}
	

	@Override
	public void createDirectory(String filename) throws DataAccessExc {
		File myPath = new File("files");
		myPath.mkdir();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String directory = sdf.format(date);
		File path = new File(myPath + File.separator + directory);
		path.mkdir();
		File file = new File(path + File.separator + filename);
		
		if(file.exists()) {
			System.out.println("The file: " + filename + " already exists :(");
			System.out.println("You are going to overwrite the file (delete the current one and create a new one)");
			
			try {
				PrintWriter output = new PrintWriter(new FileWriter(file));
				output.close();
				System.out.println("File " + filename + " has been created again!");
			} catch(IOException e) {
				e.printStackTrace();
				throw new DataAccessExc("Exception: " + e.getMessage());
			}
			
		} else {
			try {
				PrintWriter output = new PrintWriter(new FileWriter(file));
				output.close();
				System.out.println("New file " + filename + " has been created!");
			} catch(IOException e) {
				e.printStackTrace();
				throw new DataAccessExc("Exception: " + e.getMessage());
			}
		}
		
	}


	@Override
	public void listDirectories(String filename) throws DataReadoutExc {
		File file = new File("files");
		String[] directories = file.list();
		
		for(int i = 0; i < directories.length; i++) {
			System.out.println((i+1) + "- " + directories[i]);
			File path = new File(file.getAbsolutePath(), directories[i]);
			
			if(path.isDirectory()) {
				String[] subpath = path.list();
				
				for(int j = 0; j < subpath.length; j++) {
					System.out.println("\t" + (j+1) + "- " + subpath[j]);
				}
			}
		}
		
	}

}
