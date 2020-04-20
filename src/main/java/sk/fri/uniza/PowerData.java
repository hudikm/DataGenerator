
package sk.fri.uniza;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Date",
        "Time",
        "Global_active_power",
        "Global_reactive_power",
        "Voltage",
        "Global_intensity",
        "Sub_metering_1",
        "Sub_metering_2",
        "Sub_metering_3"
})
public class PowerData {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("Global_active_power")
    private Double globalActivePower;
    @JsonProperty("Global_reactive_power")
    private Double globalReactivePower;
    @JsonProperty("Voltage")
    private Double voltage;
    @JsonProperty("Global_intensity")
    private Double globalIntensity;
    @JsonProperty("Sub_metering_1")
    private Integer subMetering1;
    @JsonProperty("Sub_metering_2")
    private Integer subMetering2;
    @JsonProperty("Sub_metering_3")
    private Integer subMetering3;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonIgnore
    DateTimeFormatter dataFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @JsonProperty("Date")
    public LocalDate getDate() {
        return LocalDate.parse(date,dataFormatObj);
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Time")
    public LocalTime getTime() {
        return LocalTime.parse(time);
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("Global_active_power")
    public Double getGlobalActivePower() {
        return globalActivePower;
    }

    @JsonProperty("Global_active_power")
    public void setGlobalActivePower(Double globalActivePower) {
        this.globalActivePower = globalActivePower;
    }

    @JsonProperty("Global_reactive_power")
    public Double getGlobalReactivePower() {
        return globalReactivePower;
    }

    @JsonProperty("Global_reactive_power")
    public void setGlobalReactivePower(Double globalReactivePower) {
        this.globalReactivePower = globalReactivePower;
    }

    @JsonProperty("Voltage")
    public Double getVoltage() {
        return voltage;
    }

    @JsonProperty("Voltage")
    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    @JsonProperty("Global_intensity")
    public Double getGlobalIntensity() {
        return globalIntensity;
    }

    @JsonProperty("Global_intensity")
    public void setGlobalIntensity(Double globalIntensity) {
        this.globalIntensity = globalIntensity;
    }

    @JsonProperty("Sub_metering_1")
    public Integer getSubMetering1() {
        return subMetering1;
    }

    @JsonProperty("Sub_metering_1")
    public void setSubMetering1(Integer subMetering1) {
        this.subMetering1 = subMetering1;
    }

    @JsonProperty("Sub_metering_2")
    public Integer getSubMetering2() {
        return subMetering2;
    }

    @JsonProperty("Sub_metering_2")
    public void setSubMetering2(Integer subMetering2) {
        this.subMetering2 = subMetering2;
    }

    @JsonProperty("Sub_metering_3")
    public Integer getSubMetering3() {
        return subMetering3;
    }

    @JsonProperty("Sub_metering_3")
    public void setSubMetering3(Integer subMetering3) {
        this.subMetering3 = subMetering3;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
