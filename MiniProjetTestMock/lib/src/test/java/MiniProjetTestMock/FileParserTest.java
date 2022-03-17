package MiniProjetTestMock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;

public class FileParserTest {
	Dictionary dictionary = new Dictionary();
	@Test
	public void testBufferedreader() throws IOException {
		FileParser fileparser;
		fileparser = mock(FileParser.class);
		when(fileparser.readMot()).thenReturn("testTitre");
		when(fileparser.parseLine("fr;en")).thenReturn(new String[] { "fr", "en" });
		System.out.println(fileparser.readMot());
		verify(fileparser, times(1)).readMot();
	}
}

