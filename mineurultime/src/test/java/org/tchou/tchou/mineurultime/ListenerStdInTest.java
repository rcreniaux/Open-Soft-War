package org.tchou.tchou.mineurultime;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class ListenerStdInTest {

	@Test
	public void listener_should_get_message_on_stdout() throws Exception {
		// Given
		String expectedMessage = "TEST MESSAGE";
		
		OutputStreamWriter outWriter = new OutputStreamWriter(System.out);
		InputStream in = new ByteArrayInputStream(expectedMessage.getBytes());
		System.setIn(in);
		
		ListenerStdIn listener = new ListenerStdIn(in);
		
		// When
		outWriter.write(expectedMessage);
		
		// Then
		String result = listener.getNextLine();
		Assertions.assertThat(result).isEqualTo(expectedMessage);
	}

}
