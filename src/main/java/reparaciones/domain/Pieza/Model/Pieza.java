package reparaciones.domain.Pieza.Model;

import reparaciones.domain.Coche.Model.Coche;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "piezas")
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    int fechaCambio;

}
