package pe.com.unfpg.identidadyseguridad.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.identidadyseguridad.client.PersonasFeignClient;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioEntity;
import pe.com.unfpg.identidadyseguridad.repository.UsuarioRepository;
import pe.com.unfpg.identidadyseguridad.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository repositorio;
	private final PersonasFeignClient personasFeignClient;

	public UsuarioServiceImpl(UsuarioRepository repositorio, PersonasFeignClient personasFeignClient) {
		this.repositorio = repositorio;
		this.personasFeignClient = personasFeignClient;
	}

	@Override
	public List<UsuarioEntity> findAll() {
		List<UsuarioEntity> usuarios = repositorio.findAll();
		for (UsuarioEntity usuario : usuarios) {
			usuario.setAlumno(usuario.getCodalu() != null ? personasFeignClient.getAlumno(usuario.getCodalu()) : null);
			usuario.setDocente(usuario.getCoddoc() != null ? personasFeignClient.getDocente(usuario.getCoddoc()) : null);
			usuario.setEmpleado(usuario.getCodemp() != null ? personasFeignClient.getEmpleado(usuario.getCodemp()) : null);
		}
		return usuarios;
	}

	@Override
	public List<UsuarioEntity> findAllCustom() {
		List<UsuarioEntity> usuarios = repositorio.findAllCustom();
		for (UsuarioEntity usuario : usuarios) {
			usuario.setAlumno(usuario.getCodalu() != null ? personasFeignClient.getAlumno(usuario.getCodalu()) : null);
			usuario.setDocente(usuario.getCoddoc() != null ? personasFeignClient.getDocente(usuario.getCoddoc()) : null);
			usuario.setEmpleado(usuario.getCodemp() != null ? personasFeignClient.getEmpleado(usuario.getCodemp()) : null);
		}
		return usuarios;
	}

	@Override
	public UsuarioEntity findById(Long id) {
		UsuarioEntity usuario = repositorio.findById(id).get();
		usuario.setAlumno(usuario.getCodalu() != null ? personasFeignClient.getAlumno(usuario.getCodalu()) : null);
		usuario.setDocente(usuario.getCoddoc() != null ? personasFeignClient.getDocente(usuario.getCoddoc()) : null);
		usuario.setEmpleado(usuario.getCodemp() != null ? personasFeignClient.getEmpleado(usuario.getCodemp()) : null);
		return usuario;
	}

	@Override
	public UsuarioEntity add(UsuarioEntity obj) {
		if (obj.getEstado() == null) {
			obj.setEstado(true);
		}
		return repositorio.save(obj);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity obj, Long id) {
		UsuarioEntity objusu = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objusu, "codigo", "fechacreacion");
		return repositorio.save(objusu);
	}

	@Override
	public UsuarioEntity delete(Long id) {
		UsuarioEntity objusu = repositorio.findById(id).get();
		objusu.setEstado(false);
		return repositorio.save(objusu);
	}

	@Override
	public UsuarioEntity enable(Long id) {
		UsuarioEntity objusu = repositorio.findById(id).get();
		objusu.setEstado(true);
		return repositorio.save(objusu);
	}
}