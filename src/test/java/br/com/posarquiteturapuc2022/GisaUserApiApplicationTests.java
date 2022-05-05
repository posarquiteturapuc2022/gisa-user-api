package br.com.posarquiteturapuc2022;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.posarquiteturapuc2022.domain.Associado;

@SpringBootTest
class GisaUserApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testValidacaoRegrasNegocio() {
		
//		switch (key) {
//		case value:
//			
//			break;
//
//		default:
//			break;
//		}
	}
	
	
	@Test
	public void testQuinzePorCentoPlanoOdontologicoMensal() {
        BigDecimal bd2 = new BigDecimal ("84.0");
        Associado associado = new Associado();
        associado.setValorPlanoMensal(bd2);
        associado.planoOdontologico(true, associado.getValorPlanoMensal());
	}
		

}
