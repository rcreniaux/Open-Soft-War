package org.tchou.tchou.mineurultime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ListenerStdIn {
	
	Scanner scanner;
//	private InputStream in;
	
	public ListenerStdIn(){
		this(System.in);
	}

	public ListenerStdIn(InputStream in){
//		this.in = in;
		scanner = new Scanner(in);
	}

	public String getNextLine() throws IOException {
		return scanner.nextLine();
	}

}
