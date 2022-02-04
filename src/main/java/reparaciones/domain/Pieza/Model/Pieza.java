package reparaciones.domain.Pieza.Model;

import reparaciones.domain.Coche.Model.Coche;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

import javax.persistence.*;

@Entity
@Table(name = "piezas")
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer piezaID;

    @ManyToOne
    @JoinColumn(name = "tipoPiezaID")
    TipoPieza tipoPieza;

    @ManyToOne
    @JoinColumn(name = "cocheID")
    Coche coche;

    @Column
    int fechaCambio;

}
