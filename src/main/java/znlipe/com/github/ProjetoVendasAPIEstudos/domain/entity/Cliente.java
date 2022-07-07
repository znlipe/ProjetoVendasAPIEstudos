package znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //Mapeia para o banco de dados >> cria uma tabela
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id") // define um nome para o banco de dados, se eu quiser mudar o nome do banco de dados, eu altero aqui, poderia alterar por exemplo para "cliente_id"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera uma numeração sequencial no banco de dados de forma automatico, cliente 1, 2, 3, 4... uma ID para cada cliente
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 5, max = 120, message = "o tamanho deve ser entre 5 e 120 letras!")
    private String nome;

    @Column(name = "email")
    @NotEmpty(message = "Campo email é obrigatório")
    @Email(message = "Email inválido, por favor, digite um email válido!")
    private String email;

    @Column(name = "telefone")
    @NotEmpty(message = "Campo telefone é obrigatório")
    @Length(min = 8, max = 15, message = "O telefone deve contar entre 8 e 15 números.")
    private String telefone;

    @Column(unique = true, name = "cpf")
    @CPF
    @NotEmpty(message = "CPF não pode ser vazio.")
    private String cpf;

    @Column(name = "endereco")
    @Length(min = 5, max = 120, message = "o tamanho do endereço deve estar entre 5 a 120 caracteres.")
    private String endereco;

}
