package pe.com.unfpg.identidadyseguridad.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;
import pe.com.unfpg.identidadyseguridad.repository.UsuarioRolRepository;
import pe.com.unfpg.identidadyseguridad.service.UsuarioRolService;


@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

	private final UsuarioRolRepository repositorio;

	UsuarioRolServiceImpl(UsuarioRolRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<UsuarioRolEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<UsuarioRolEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public List<UsuarioRolEntity> findByUsuario(Long codusu) {
		return repositorio.findByUsuario(codusu);
	}

	@Override
	public UsuarioRolEntity findById(UsuarioRolId id) {
		return repositorio.findById(id).get();
	}

	@Override
	public UsuarioRolEntity add(UsuarioRolEntity obj) {
		if (obj.getUsuario() == null || obj.getRol() == null) {
			throw new IllegalArgumentException("Debe indicar el usuario y el rol");
		}
		UsuarioRolId id = new UsuarioRolId(obj.getUsuario().getCodigo(), obj.getRol().getCodigo());
		if (repositorio.existsById(id)) {
			throw new IllegalArgumentException("El usuario ya tiene asignado ese rol");
		}
		obj.setId(id);
		return repositorio.save(obj);
	}

	// el rol forma parte de la clave primaria: se reemplaza la fila vieja por la nueva
	@Override
	@Transactional
	public UsuarioRolEntity update(UsuarioRolId id, UsuarioRolEntity obj) {
		if (obj.getRol() == null) {
			throw new IllegalArgumentException("Debe indicar el nuevo rol");
		}
		UsuarioRolEntity actual = repositorio.findById(id).get();

		UsuarioRolId nuevoId = new UsuarioRolId(id.getCodusu(), obj.getRol().getCodigo());
		if (repositorio.existsById(nuevoId)) {
			throw new IllegalArgumentException("El usuario ya tiene asignado ese rol");
		}

		UsuarioRolEntity nuevo = UsuarioRolEntity.builder()
				.id(nuevoId)
				.usuario(actual.getUsuario())
				.rol(obj.getRol())
				.build();

		repositorio.delete(actual);
		return repositorio.save(nuevo);
	}
}