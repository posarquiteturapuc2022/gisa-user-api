package br.com.posarquiteturapuc2022;

import java.math.BigDecimal;

import br.com.posarquiteturapuc2022.domain.Associado;

public class Teste {
    public static void main(String[] args) throws Exception {
        BigDecimal bd2 = new BigDecimal ("84.0");
        Associado associado = new Associado();
        associado.setValorPlanoMensal(bd2);
        associado.planoOdontologico(true, associado.getValorPlanoMensal());
    }
}
	