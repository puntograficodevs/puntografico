package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoArmado;
import com.puntografico.pm.enums.TipoColor;
import com.puntografico.pm.enums.TipoTalonario;
import com.puntografico.pm.enums.TipoTerminacionTalonario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "talonario")
@Getter @Setter
public class Talonario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private TipoColor tipoColor;

    private TipoTalonario tipoTalonario;

    private TipoArmado tipoArmado;

    private TipoTerminacionTalonario tipoTerminacionTalonario;

    private String medida;
}
