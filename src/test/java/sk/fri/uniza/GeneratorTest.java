package sk.fri.uniza;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GeneratorTest {
    DateTimeFormatter timeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Test
    public void testTime() {
        PowerData data;
        DataGenerator dataGenerator = null;
        LocalTime timeOld = LocalTime.parse("23:59:00");
        try {
            dataGenerator = new DataGenerator();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (dataGenerator != null);
        LocalTime timeTest = LocalTime.of(0, 0);
        for (int i = 0; i < 8 * 24 * 60 * 2; i++) {

            data = dataGenerator.getData(timeTest);
            if (data == null) break;
            LocalTime time = data.getTime();
            assert (data.getTime().equals(timeTest));
            assert (data.getDate().equals(LocalDate.now()));
            assert (timeOld.plusMinutes(1).equals(time));
            timeOld = time;
            timeTest = timeTest.plusMinutes(1);
        }
    }
    @Test
    public void TestCurrentTime(){
        DataGenerator dataGenerator = null;
        try {
            dataGenerator = new DataGenerator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PowerData currentData = dataGenerator.getCurrentData();
        assert(currentData.getDate().equals(LocalDate.now()));
        assert(currentData.getTime().equals(LocalTime.now().truncatedTo(ChronoUnit.MINUTES)));

    }

}
