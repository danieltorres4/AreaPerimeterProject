package data;

import exceptions.*;

public interface IDataAccess {
	void openFile(String filename) throws DataAccessExc;
	void writing(String filename, String content) throws DataWritingExc;
	String searching(String directory, String toSearch) throws DataReadoutExc;
	void createDirectory(String filename) throws DataAccessExc;
	void listDirectories(String filename) throws DataReadoutExc;
	
}
