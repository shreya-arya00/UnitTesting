import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testFindWordIndex() {
        // Test case 1: Search word found in the sentence
        assertEquals("3", getOutput("This is a sample sentence", "a"));

        // Test case 2: Search word not found in the sentence
        assertEquals("Not Found", getOutput("This is another sentence", "word"));

        // Test case 3: Search word found at the beginning of the sentence
        assertEquals("1", getOutput("Java is a programming language", "Java"));

        // Test case 4: Search word found at the end of the sentence
        assertEquals("5", getOutput("Testing the findWordIndex method", "method"));

        // Test case 5: Search word found in a sentence with multiple spaces
        assertEquals("2", getOutput("   Spaces between words   ", "between"));

        // Test case 6: Search word found in an empty sentence
        assertEquals("Not Found", getOutput("", "empty"));

        // Test case 7: Search word found in a sentence with leading/trailing spaces
        assertEquals("2", getOutput("   Spaces with leading/trailing   ", "Spaces"));
    }

    private String getOutput(String sentence, String searchWord) {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Redirect System.in to provide input to Scanner
        ByteArrayInputStream inputStream = new ByteArrayInputStream((sentence + "\n" + searchWord + "\n").getBytes());
        System.setIn(inputStream);

        // Call the main method
        test.main(new String[]{});

        // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Return the captured output
        return outputStream.toString().trim();
    }
}
