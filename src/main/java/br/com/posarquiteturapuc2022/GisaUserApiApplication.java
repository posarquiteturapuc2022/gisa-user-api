package br.com.posarquiteturapuc2022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver;
import org.springframework.boot.actuate.endpoint.web.EndpointMapping;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.ExposableWebEndpoint;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import br.com.posarquiteturapuc2022.repositories.UsuarioRepository;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class GisaUserApiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(GisaUserApiApplication.class, args);
	}
	
	@Bean
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier, ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier, EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties, WebEndpointProperties webEndpointProperties, Environment environment) {
	    List<ExposableEndpoint<?>> allEndpoints = new ArrayList();
	    Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
	    allEndpoints.addAll(webEndpoints);
	    allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
	    allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
	    String basePath = webEndpointProperties.getBasePath();
	    EndpointMapping endpointMapping = new EndpointMapping(basePath);
	    boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
	    return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes, corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath), shouldRegisterLinksMapping, null);
	}

	private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
	    return webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
	}

	@Override
	public void run(String... args) throws Exception {
		usuarioRepositoy.saveAll(List.of(
		//Associados
		//          ID    NOME                    CPF            CNPJ              EMAIL                             PASSWORD       		
//		new Usuario(null, "Maria Madalena",       "65918656081", "",               "maria.madalena@gmail.com",       "123"),
//		new Usuario(null, "João Bosco",           "02638367036", "",               "joao.bosco@gmail.com",           "123"),
//		new Usuario(null, "Glôria Menezes",       "47997144064", "",               "gloria.menezes@gmail.com",       "123"),
//		new Usuario(null, "Tarsízio Meirao",      "10165088087", "",               "tarsizio.meira@gmail.com",       "123"),
		//Prestadores
//		new Usuario(null, "Hospital Santa Lúcia",   "",          "50551582000172", "hospitalsantalucia@gmail.com",   "123"),
//		new Usuario(null, "Hospital Santa Luzia",   "",          "95552223000178", "hospitalsantaluzia@gmail.com",   "123"),
//		new Usuario(null, "Hospital DFStar",        "",          "67604720000137", "dfstar@rededor.com",             "123"),
//		new Usuario(null, "Hospital Sirio Libanês", "",          "70327243000114", "hospitalsiriolibanes@hsl.com",   "123"),
//		new Usuario(null, "Hospital Anchieta",      "",          "04953315000104", "hospitalsiriolibanes@gmail.com", "123")
		));
	}

}
