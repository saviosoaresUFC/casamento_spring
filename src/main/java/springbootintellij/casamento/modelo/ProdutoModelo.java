package springbootintellij.casamento.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS")
@Getter
@Setter

public class ProdutoModelo extends RepresentationModel<ProdutoModelo> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    private String nome;
    private BigDecimal valor_minimo;
    private BigDecimal valor_maximo;
    private boolean disponibilidade;
    private String url_imagem;
}