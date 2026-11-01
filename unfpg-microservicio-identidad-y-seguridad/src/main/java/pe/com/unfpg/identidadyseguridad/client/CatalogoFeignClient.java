package pe.com.unfpg.identidadyseguridad.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "unfpg-microservicio-catalogo", url = "http://localhost:9091/unfpg/api")




public interface CatalogoFeignClient {
	@GetMapping("/rol/{id}")
	Object getRol(@PathVariable("id") Long id);
}
