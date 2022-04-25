package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String company;

    private Integer factQliqData1;

    private Integer factQliqData2;

    private Integer factQoilData1;

    private Integer factQoilData2;

    private Integer forecastQliqData1;

    private Integer forecastQliqData2;

    private Integer forecastQoilData1;

    private Integer forecastQoilData2;

    private Date date;

    public Record(int id, String company, Date date,
                  int factQliqData1, int factQliqData2,
                  int factQoilData1, int factQoilData2,
                  int forecastQliqData1, int forecastQliqData2,
                  int forecastQoilData1, int forecastQoilData2)
    {
        this.id = id;
        this.company = company;
        this.date = date;
        this.factQliqData1 = factQliqData1;
        this.factQliqData2 = factQliqData2;
        this.factQoilData1 = factQoilData1;
        this.factQoilData2 = factQoilData2;
        this.forecastQliqData1 = forecastQliqData1;
        this.forecastQliqData2 = forecastQliqData2;
        this.forecastQoilData1 = forecastQoilData1;
        this.forecastQoilData2 = forecastQoilData2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFactQliqData1() {
        return factQliqData1;
    }

    public void setFactQliqData1(int factQloqData1) {
        this.factQliqData1 = factQloqData1;
    }

    public int getFactQliqData2() {
        return factQliqData2;
    }

    public void setFactQliqData2(int factQloqData2) {
        this.factQliqData2 = factQloqData2;
    }

    public int getFactQoilData1() {
        return factQoilData1;
    }

    public void setFactQoilData1(int factQoilData1) {
        this.factQoilData1 = factQoilData1;
    }

    public int getFactQoilData2() {
        return factQoilData2;
    }

    public void setFactQoilData2(int factQoilData2) {
        this.factQoilData2 = factQoilData2;
    }

    public int getForecastQliqData1() {
        return forecastQliqData1;
    }

    public void setForecastQliqData1(int forecastQliqData1) {
        this.forecastQliqData1 = forecastQliqData1;
    }

    public int getForecastQliqData2() {
        return forecastQliqData2;
    }

    public void setForecastQliqData2(int forecastQliqData2) {
        this.forecastQliqData2 = forecastQliqData2;
    }

    public int getForecastQoilData1() {
        return forecastQoilData1;
    }

    public void setForecastQoilData1(int forecastQoilData1) {
        this.forecastQoilData1 = forecastQoilData1;
    }

    public int getForecastQoilData2() {
        return forecastQoilData2;
    }

    public void setForecastQoilData2(int forecastQoilData2) {
        this.forecastQoilData2 = forecastQoilData2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
