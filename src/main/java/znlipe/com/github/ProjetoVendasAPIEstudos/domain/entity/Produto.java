package znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 3, max = 120, message = "o tamanho deve ser entre 3 e 120 letras.")
    private String nome;

    @Column
    @NotEmpty(message = "Campo de preço é obrigatório.")
    private BigDecimal preco;

}
