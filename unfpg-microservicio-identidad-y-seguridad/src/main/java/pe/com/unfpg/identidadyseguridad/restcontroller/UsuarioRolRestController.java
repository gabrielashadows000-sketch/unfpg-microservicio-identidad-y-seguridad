package pe.com.unfpg.identidadyseguridad.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolEntity;
import pe.com.unfpg.identidadyseguridad.entity.UsuarioRolId;
import pe.com.unfpg.identidadyseguridad.service.UsuarioRolService;



@RestController
@RequestMapping("/api/usuariorol")
public class UsuarioRolRestController {

	@Autowired
	private UsuarioRolService servicio;

	@GetMapping
	public List<UsuarioRolEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<UsuarioRolEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/usuario/{codusu}")
	public List<UsuarioRolEntity> findByUsuario(@PathVariable Long codusu) {
		return servicio.findByUsuario(codusu);
	}

	@GetMapping("/{codusu}/{codrol}")
	public UsuarioRolEntity findById(@PathVariable Long codusu, @PathVariable Long codrol) {
		return servicio.findById(new UsuarioRolId(codusu, codrol));
	}

	@PostMapping
	public UsuarioRolEntity add(@RequestBody UsuarioRolEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{codusu}/{codrol}")
	public UsuarioRolEntity update(@PathVariable Long codusu, @PathVariable Long codrol,
			@RequestBody UsuarioRolEntity obj) {
		return servicio.update(new UsuarioRolId(codusu, codrol), obj);
	}
}