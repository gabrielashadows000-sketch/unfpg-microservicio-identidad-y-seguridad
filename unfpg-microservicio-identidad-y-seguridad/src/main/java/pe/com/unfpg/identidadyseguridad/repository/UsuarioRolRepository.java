package pe.com.unfpg.identidadyseguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, UsuarioRolId> {

	// Como el rol está en otro microservicio, traemos todas las asignaciones
	// y el servicio se encarga de hidratarlas y filtrarlas si es necesario.
	@Query("select ur from UsuarioRolEntity ur")
	List<UsuarioRolEntity> findAllCustom();

	// Buscar roles de un usuario usando el campo codusu del ID compuesto
	@Query("select ur from UsuarioRolEntity ur where ur.id.codusu = :codusu")
	List<UsuarioRolEntity> findByUsuario(@Param("codusu") Long codusu);
}