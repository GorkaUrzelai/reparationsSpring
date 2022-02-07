package reparaciones.domain.TipoPieza.Model;

import reparaciones.domain.Pieza.Model.Pieza;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="tipo_piezas")
public class TipoPieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer tipoPiezaID;

    @Column
    @NotNull
    private String nombre;

    @OneToMany(mappedBy = "tipoPieza")
    Set<Pieza> piezas;

    public Integer getTipoPiezaID() {
        return tipoPiezaID;
    }

    public void setTipoPiezaID(Integer tipoPiezaID) {
        this.tipoPiezaID = tipoPiezaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(Set<Pieza> piezas) {
        this.piezas = piezas;
    }
}
