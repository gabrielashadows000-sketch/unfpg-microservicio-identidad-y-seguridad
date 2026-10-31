package pe.com.unfpg.identidadyseguridad.service;

import java.util.List;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;



public interface UsuarioRolService {
	List<UsuarioRolEntity> findAll();
	List<UsuarioRolEntity> findAllCustom();
	List<UsuarioRolEntity> findByUsuario(Long codusu);
	UsuarioRolEntity findById(UsuarioRolId id);
	UsuarioRolEntity add(UsuarioRolEntity obj);
	UsuarioRolEntity update(UsuarioRolId id, UsuarioRolEntity obj);
}