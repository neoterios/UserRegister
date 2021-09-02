package portfolio.com.gestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Set;

//@Getter
//@Setter
public class UserPostDto {

    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("email")
    String email;

    @NotNull
    @JsonProperty("password")
    private String password;

    @JsonProperty("phones")
    private Set<PhonePostDto> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PhonePostDto> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhonePostDto> phones) {
        this.phones = phones;
    }
}
