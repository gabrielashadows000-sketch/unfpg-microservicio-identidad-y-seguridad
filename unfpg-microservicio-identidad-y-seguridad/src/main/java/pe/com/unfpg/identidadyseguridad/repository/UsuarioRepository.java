package pe.com.unfpg.identidadyseguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	@Query("select u from UsuarioEntity u where u.estado = true")
	List<UsuarioEntity> findAllCustom();
}