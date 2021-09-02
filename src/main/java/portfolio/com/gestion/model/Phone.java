package portfolio.com.gestion.model;


import javax.persistence.*;
import java.io.Serializable;

//@Getter
//@Setter
@Entity
@Table(name = "telefono")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idTelefono")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "citycode")
    private int citycode;

    @Column(name = "contrycode")
    private int contrycode;

    @ManyToOne
    @JoinColumn(name="IdUsuario")
    private User Idusuario;

    public Phone() {
    }

    public Phone(int number, int citycode, int contrycode, User usuario) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
        this.Idusuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public User getIdusuario() {
        return Idusuario;
    }

    public void setIdusuario(User usuario) {
        this.Idusuario = usuario;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "id=" + id +
                ", number=" + number +
                ", citycode=" + citycode +
                ", contrycode=" + contrycode +
                ", usuario=" + Idusuario +
                '}';
    }
}
