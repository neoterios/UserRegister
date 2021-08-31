package portfolio.com.gestion.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable {

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
    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(int id, int number, int citycode, int contrycode, Usuario usuario) {
        this.id = id;
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "id=" + id +
                ", number=" + number +
                ", citycode=" + citycode +
                ", contrycode=" + contrycode +
                ", usuario=" + usuario +
                '}';
    }
}
