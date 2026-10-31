package pe.com.unfpg.identidadyseguridad.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class UsuarioRolId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "codusu")
	private Long codusu;
	@Column(name = "codrol")
	private Long codrol;
}