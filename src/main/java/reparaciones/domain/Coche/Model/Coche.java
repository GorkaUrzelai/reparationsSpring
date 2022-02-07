package reparaciones.domain.Coche.Model;

import reparaciones.domain.Customer.Model.Customer;
import reparaciones.domain.Pieza.Model.Pieza;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cocheID;

    @ManyToOne
    @NotNull
    @JoinColumn(name="customerID")
    private Customer dueño;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private Integer kilometros;


    @OneToMany(mappedBy = "coche")
    Set<Pieza> piezas;

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Set<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(Set<Pieza> piezas) {
        this.piezas = piezas;
    }

    public Integer getCocheID() {
        return cocheID;
    }

    public void setCocheID(Integer cocheID) {
        this.cocheID = cocheID;
    }


    public Customer getDueño() {
        return dueño;
    }

    public void setDueño(Customer dueño) {
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
