package portfolio.com.gestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Getter
//@Setter
public class PhonePostDto {

    @JsonProperty("number")
    private int number;

    @JsonProperty("citycode")
    private int citycode;

    @JsonProperty("contrycode")
    private int contrycode;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public int getContrycode() {
        return contrycode;
    }

    public void setContrycode(int contrycode) {
        this.contrycode = contrycode;
    }
}
