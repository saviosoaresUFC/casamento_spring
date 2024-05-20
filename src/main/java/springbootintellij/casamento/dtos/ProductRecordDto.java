package springbootintellij.casamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank(message = "Name is required")
        String nome,

        @NotNull(message = "Value Min is required")
        BigDecimal valor_minimo,

        @NotNull(message = "Value Max is required")
        BigDecimal valor_maximo,

        @NotNull(message = "Url is required")
        String url_imagem
) {

}
