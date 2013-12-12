package org.tchou.tchou.mineurultime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ListenerStdIn {
	
	private InputStream in;
	
	public ListenerStdIn(){
		this.in = System.in;
	}

	public ListenerStdIn(InputStream in){
		this.in = in;
	}

	public String getNextLine() throws IOException {
		Scanner scanner = new Scanner(in);
		return scanner.nextLine();
	}

}
