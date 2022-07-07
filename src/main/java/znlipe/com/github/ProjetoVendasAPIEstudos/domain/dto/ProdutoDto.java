package znlipe.com.github.ProjetoVendasAPIEstudos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Integer id;

    @Column
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 3, max = 120, message = "o tamanho deve ser entre 3 e 120 letras.")
    private String nome;

    @Column
    @NotEmpty(message = "Campo de preço é obrigatório.")
    private BigDecimal preco;

}
