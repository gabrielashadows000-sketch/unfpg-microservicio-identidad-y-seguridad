package pe.com.unfpg.identidadyseguridad.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.unfpg.identidadyseguridad.client.CatalogoFeignClient;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;
import pe.com.unfpg.identidadyseguridad.repository.UsuarioRolRepository;
import pe.com.unfpg.identidadyseguridad.service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

	private final UsuarioRolRepository repositorio;
	private final CatalogoFeignClient catalogoFeignClient;

	public UsuarioRolServiceImpl(UsuarioRolRepository repositorio, CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<UsuarioRolEntity> findAll() {
		List<UsuarioRolEntity> list = repositorio.findAll();
		for (UsuarioRolEntity obj : list) {
			obj.setRol(catalogoFeignClient.getRol(obj.getId().getCodrol()));
		}
		return list;
	}

	@Override
	public List<UsuarioRolEntity> findAllCustom() {
		List<UsuarioRolEntity> list = repositorio.findAllCustom();
		for (UsuarioRolEntity obj : list) {
			obj.setRol(catalogoFeignClient.getRol(obj.getId().getCodrol()));
		}
		return list;
	}

	@Override
	public List<UsuarioRolEntity> findByUsuario(Long codusu) {
		List<UsuarioRolEntity> list = repositorio.findByUsuario(codusu);
		for (UsuarioRolEntity obj : list) {
			obj.setRol(catalogoFeignClient.getRol(obj.getId().getCodrol()));
		}
		return list;
	}

	@Override
	public UsuarioRolEntity findById(UsuarioRolId id) {
		UsuarioRolEntity obj = repositorio.findById(id).get();
		obj.setRol(catalogoFeignClient.getRol(obj.getId().getCodrol()));
		return obj;
	}

	@Override
	public UsuarioRolEntity add(UsuarioRolEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	@Transactional
	public UsuarioRolEntity update(UsuarioRolId id, UsuarioRolEntity obj) {
		UsuarioRolEntity actual = repositorio.findById(id).get();
		UsuarioRolId nuevoId = new UsuarioRolId(id.getCodusu(), obj.getId().getCodrol());
		UsuarioRolEntity nuevo = UsuarioRolEntity.builder()
				.id(nuevoId)
				.usuario(actual.getUsuario())
				.rol(actual.getRol())
				.build();
		repositorio.delete(actual);
		return repositorio.save(nuevo);
	}
}