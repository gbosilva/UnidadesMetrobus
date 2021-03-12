package mx.qro.api.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.qro.model.UbicacionMetrobus;
import mx.qro.repository.IUbicacionMetrobusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UbicacionMetrobusTest {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	public static final Logger LOG = 
			LoggerFactory.getLogger(UbicacionMetrobusTest.class);
	
	/**
	 * Es la instancia del repositorio de ubicaciones
	 */
	@Autowired
	private IUbicacionMetrobusRepository iUbicacionMetrobusRepository;
	
	@Test
	public void contextLoads() {
		assertTrue(true);
	}
	
	/**
	 * Metodo para buscar las unidades que aun no tienen una alcaldia relacionada
	 */
	@Test
	public void buscaUnidadesSinAlcaldia() {
		List<UbicacionMetrobus> ubicacionMetrobus = iUbicacionMetrobusRepository
				.buscaUnidadesSinAlcaldia();
		LOG.info("Unidades sin alcaldia: {}", ubicacionMetrobus.size());
	}
}
