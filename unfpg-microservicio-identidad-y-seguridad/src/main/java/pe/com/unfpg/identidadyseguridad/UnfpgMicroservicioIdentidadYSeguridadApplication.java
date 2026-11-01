package pe.com.unfpg.identidadyseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UnfpgMicroservicioIdentidadYSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfpgMicroservicioIdentidadYSeguridadApplication.class, args);
	}

}
