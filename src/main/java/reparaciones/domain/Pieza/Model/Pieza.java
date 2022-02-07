package reparaciones.domain.Pieza.Model;

import reparaciones.domain.Coche.Model.Coche;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "piezas")
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer piezaID;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "tipoPiezaID")
    TipoPieza tipoPieza;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "cocheID")
    Coche coche;

    @Column
    LocalDate fechaCambio;

    public Pieza(TipoPieza tipoPieza, Coche coche) {
        this.coche = coche;
        this.tipoPieza = tipoPieza;
        fechaCambio = null;
    }

    public Pieza() {
    }
}
