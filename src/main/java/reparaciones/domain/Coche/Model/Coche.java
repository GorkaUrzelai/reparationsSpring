package reparaciones.domain.Coche.Model;

import reparaciones.domain.Customer.Model.Customer;
import reparaciones.domain.Pieza.Model.Pieza;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cocheID;

    @ManyToOne
    @JoinColumn(name="customerID")
    private Customer dueño;

    @Column
    private String nombre;



    @OneToMany(mappedBy = "coche")
    Set<Pieza> piezas;

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
