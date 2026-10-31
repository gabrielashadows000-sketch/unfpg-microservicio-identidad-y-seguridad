package pe.com.unfpg.identidadyseguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;


public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, UsuarioRolId> {

	// solo asignaciones donde el usuario y el rol estan activos
	@Query("select ur from UsuarioRolEntity ur where ur.usuario.estado=true and ur.rol.estado=true")
	List<UsuarioRolEntity> findAllCustom();

	// roles de un usuario
	@Query("select ur from UsuarioRolEntity ur where ur.usuario.codigo=:codusu")
	List<UsuarioRolEntity> findByUsuario(@Param("codusu") Long codusu);
}