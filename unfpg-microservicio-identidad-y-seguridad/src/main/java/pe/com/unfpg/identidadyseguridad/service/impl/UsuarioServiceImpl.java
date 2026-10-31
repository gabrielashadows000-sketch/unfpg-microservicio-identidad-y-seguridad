package pe.com.unfpg.identidadyseguridad.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioEntity;
import pe.com.unfpg.identidadyseguridad.repository.UsuarioRepository;
import pe.com.unfpg.identidadyseguridad.service.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository repositorio;

	UsuarioServiceImpl(UsuarioRepository repositorio) {
		this.repositorio = repositorio;
	}

	// replica el CHECK de la BD: solo uno de alumno, docente o empleado
	private void validarPropietario(UsuarioEntity obj) {
		int cantidad = 0;
		if (obj.getAlumno() != null) cantidad++;
		if (obj.getDocente() != null) cantidad++;
		if (obj.getEmpleado() != null) cantidad++;
		if (cantidad != 1) {
			throw new IllegalArgumentException(
				"El usuario debe pertenecer a un alumno, un docente o un empleado (solo uno)");
		}
	}

	@Override
	public List<UsuarioEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<UsuarioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public UsuarioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public UsuarioEntity add(UsuarioEntity obj) {
		validarPropietario(obj);
		// valor por defecto de la BD
		if (obj.getEstado() == null) {
			obj.setEstado(true);
		}
		return repositorio.save(obj);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity obj, Long id) {
		validarPropietario(obj);
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