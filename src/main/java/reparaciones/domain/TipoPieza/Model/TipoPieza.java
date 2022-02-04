package reparaciones.domain.TipoPieza.Model;

import reparaciones.domain.Pieza.Model.Pieza;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tipo_piezas")
public class TipoPieza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer tipoPiezaID;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "tipoPieza")
    Set<Pieza> piezas;



}
