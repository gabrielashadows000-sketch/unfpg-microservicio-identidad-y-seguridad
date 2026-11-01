package pe.com.unfpg.identidadyseguridad.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

    @Transient
    private Object usuario; 
    
    @Transient
    private Object rol;     
}