package ru.alexey.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("QuestionAnswerView")
class QuestionAnswerViewImplTest {

    @Test
    @DisplayName("should output message")
    void showQuestion() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        new QuestionAnswerViewImpl().showQuestion("message");
        outStream.flush();
        assertTrue(outStream.toString().contains("message"));
    }

    @Test
    @DisplayName("should read message")
    void shouldReadMessage() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("name");
        assertThat(reader.readLine()).isEqualTo(new QuestionAnswerViewImpl(reader).getAnswer());
    }
}
