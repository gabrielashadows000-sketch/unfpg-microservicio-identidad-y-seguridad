package pe.com.unfpg.identidadyseguridad.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "DocenteEntity")
@Table(name = "docente")
public class DocenteEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "coddoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nomdoc", length = 50, nullable = false)
    private String nombre;
    
    @Column(name = "apepdoc", length = 40, nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apemdoc", length = 40, nullable = false)
    private String apellidoMaterno;
    
    @Column(name = "fecnac", nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column(name = "numdoc", length = 20, nullable = false, unique = true)
    private String numeroDocumento;
    
    @Column(name = "nacdoc", length = 20, nullable = false)
    private String nacionalidad;
    
    @Column(name = "dirdoc", columnDefinition = "TEXT", nullable = false)
    private String direccion;
    
    @Column(name = "teldoc", length = 15)
    private String telefono;
    
    @Column(name = "celdoc", length = 15, nullable = false)
    private String celular;
    
    @Column(name = "cordoc", length = 100, nullable = false, unique = true)
    private String correo;
    
    @Column(name = "estdoc", nullable = false)
    private Boolean estado;
    
    @Column(name = "credoc", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(name = "suedoc", precision = 8, scale = 2, nullable = false)
    private BigDecimal sueldo;
    
  
    
}
