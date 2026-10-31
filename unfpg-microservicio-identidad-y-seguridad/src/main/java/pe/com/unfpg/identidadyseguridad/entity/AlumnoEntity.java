package pe.com.unfpg.identidadyseguridad.entity;
import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
@Entity(name = "AlumnoEntity")
@Table(name = "alumno")
public class AlumnoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codalu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomalu",length = 50, nullable = false)
	private String nombre;
	@Column(name = "apepalu",length = 40, nullable = false)
	private String apellidopaterno;
	@Column(name = "apemalu",length = 40, nullable = false)
	private String apellidomaterno;
	@Column(name = "fecnac", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechanacimiento;
	@Column(name = "numdoc",length = 20, nullable = false)
	private String numerodocumento;
	@Column(name = "nacalu",length = 20, nullable = false)
	private String nacionalidad;
	@Column(name = "diralu",length = 300, nullable = false)
	private String direccion;
	@Column(name = "telalu",length = 15, nullable = false)
	private String telefono;
	@Column(name = "celalu",length = 15, nullable = false)
	private String celular;
	@Column(name = "coralu",length = 100, nullable = false)
	private String correo;
	@Column(name = "estalu", nullable = false)
	private Boolean estado;
	
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
