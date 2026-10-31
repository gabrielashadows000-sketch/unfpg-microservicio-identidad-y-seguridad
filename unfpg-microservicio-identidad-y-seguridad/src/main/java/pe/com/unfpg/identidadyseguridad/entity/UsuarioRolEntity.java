package pe.com.unfpg.identidadyseguridad.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "UsuarioRolEntity")
@Table(name = "usuariorol")
public class UsuarioRolEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioRolId id;

	// claves foraneas (a la vez forman la clave primaria)
	@ManyToOne
	@MapsId("codusu")
	@JoinColumn(name = "codusu", nullable = false)
	private UsuarioEntity usuario;

	@ManyToOne
	@MapsId("codrol")
	@JoinColumn(name = "codrol", nullable = false)
	private RolEntity rol;
}