package portfolio.com.gestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import portfolio.com.gestion.model.Phone;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

//@Getter
//@Setter
public class UserGetDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("createdOn")
    private Date createdOn;

    @JsonProperty("token")
    private String token;

    @JsonProperty("phones")
    private Set<Phone> phones;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
