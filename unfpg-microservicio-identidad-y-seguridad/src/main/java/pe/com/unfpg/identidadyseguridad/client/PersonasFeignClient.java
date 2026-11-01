package pe.com.unfpg.identidadyseguridad.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "unfpg-microservicio-personas", url = "http://localhost:9092/unfpg/api")


public interface PersonasFeignClient {

	 @GetMapping("/alumno/{id}")
	    Object getAlumno(@PathVariable("id") Long id);
	    
	    @GetMapping("/docente/{id}")
	    Object getDocente(@PathVariable("id") Long id);
	    
	    @GetMapping("/empleado/{id}")
	    Object getEmpleado(@PathVariable("id") Long id);
	    
	  
}
