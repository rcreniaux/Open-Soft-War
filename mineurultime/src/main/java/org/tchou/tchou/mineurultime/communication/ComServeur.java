package org.tchou.tchou.mineurultime.communication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ComServeur {

	Scanner scanner;

	public ComServeur() {
		this(System.in);
	}

	public ComServeur(InputStream in) {
		scanner = new Scanner(in);
	}

	public String getNextLine() throws IOException {
		return scanner.nextLine();
	}

	public void sendCommand(String cmde) {
		System.out.println(cmde);
	}
}
