package pe.com.unfpg.identidadyseguridad.service;

import java.util.List;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioEntity;



public interface UsuarioService {
	List<UsuarioEntity> findAll();
	List<UsuarioEntity> findAllCustom();
	UsuarioEntity findById(Long id);
	UsuarioEntity add(UsuarioEntity obj);
	UsuarioEntity update(UsuarioEntity obj, Long id);
	UsuarioEntity delete(Long id);
	UsuarioEntity enable(Long id);
}