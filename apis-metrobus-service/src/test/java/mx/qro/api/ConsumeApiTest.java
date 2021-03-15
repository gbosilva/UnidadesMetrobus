package mx.qro.api;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.qro.model.Direccion;
import mx.qro.service.IDireccionAlcaldiaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumeApiTest {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	public static final Logger LOG = 
			LoggerFactory.getLogger(ConsumeApiTest.class);
	
	/**
	 * Es la instancia del repositorio de consultar direcciones
	 */
	@Autowired
	public IDireccionAlcaldiaService iAlcaldiaService;
	
	@Test
	public void contextLoads() {
		assertTrue(true);
	}
	
	/**
	 * Metodo para validar el consumo de un api
	 */
	@Test
	public void pruebaConsumoApi() {
		Direccion direccion = iAlcaldiaService.consultaAlcaldiaPorAPI("19.3174991608,-99.1877975464");
		LOG.info("DireccionTest: {}", direccion.getResults().size());
		LOG.info("DireccionTest: {}", direccion.getResults());
	}
	
}
