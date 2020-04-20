package sk.fri.uniza;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

public class DataGenerator {
    private ObjectMapper mapper = new ObjectMapper();
    private Iterator<PowerData> iterator = null;
    DateTimeFormatter timeFormatObj = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dataFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public List<PowerData> getDataList() {
        return dataList;
    }

    private void resetInterator() {
        iterator = dataList.iterator();
    }

    List<PowerData> dataList;

    public DataGenerator() throws IOException {

        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("powerdata.json");
        dataList = mapper.readValue(resourceAsStream, new TypeReference<List<PowerData>>() {
        });
        resetInterator();
    }

    private String getStringTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        return myDateObj.format(timeFormatObj) + ":00";
    }

    private String getStringDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        return myDateObj.format(dataFormatObj);
    }

    PowerData getData(LocalTime time) {
        assert (iterator != null);

        while (true) {
            while (iterator.hasNext()) {
                PowerData powerData = iterator.next();
                if (powerData.getTime().equals(time.truncatedTo(ChronoUnit.MINUTES))) {
                    powerData.setDate(getStringDate());
                    return powerData;
                }
            }
            resetInterator(); //Start from begining
        }
    }

    /**
     *
      * @return PowerData -  aktuálne dáta z meračov spotreby. Interval vzorkovania je 1 min
     */
    public PowerData getCurrentData() {
        return getData(LocalTime.now());
    }


}
