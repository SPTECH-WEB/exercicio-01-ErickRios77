package com.fatura.faturaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "fatura")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar em Branco")
    @Pattern(regexp ="\\d{16}", message="O número do cartão deve conter exatamente 16 digitos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em Branco")
    @Size(min = 3, max = 100, message = "O nome do titular deve conter no mínimo 3 letras, e no máximo 100")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser nulo")
    @Min(value = 10, message = "O valor mínimo é de R$10,00")
    @Max(value = 5000, message = "O valor máximo é de R$5000,00")
    private Double valor;

    @NotNull(message = "A data de pagamento não pode ser nula")
    @FutureOrPresent(message = "A data de pagamento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O e-mail não pode estar em Branco")
    @Email(message = "O e-mail deve ser válido")
    private String emailContato;

}
