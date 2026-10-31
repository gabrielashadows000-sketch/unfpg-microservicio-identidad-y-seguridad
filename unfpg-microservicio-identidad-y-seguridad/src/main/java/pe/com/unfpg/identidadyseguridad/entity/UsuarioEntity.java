package pe.com.unfpg.identidadyseguridad.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codusu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomusu", length = 50, nullable = false, unique = true)
	private String nombreusuario;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // la clave no se devuelve en las respuestas
	@Column(name = "clausu", length = 255, nullable = false)
	private String clave;
	@Column(name = "corusu", length = 100, nullable = false, unique = true)
	private String correo;
	@Column(name = "creusu", insertable = false, updatable = false) // lo asigna MySQL
	private LocalDateTime fechacreacion;
	@Column(name = "estusu", nullable = false)
	private Boolean estado;

	// claves foraneas (solo una de las tres debe venir con valor)
	@ManyToOne
	@JoinColumn(name = "codalu", nullable = true)
	private AlumnoEntity alumno;

	@ManyToOne
	@JoinColumn(name = "coddoc", nullable = true)
	private DocenteEntity docente;

	@ManyToOne
	@JoinColumn(name = "codemp", nullable = true)
	private EmpleadoEntity empleado;
}