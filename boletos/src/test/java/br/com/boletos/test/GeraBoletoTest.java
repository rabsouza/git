package br.com.boletos.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

public class GeraBoletoTest {

	private static final int DIA_VENC_BOLETO = 20;
	private static final int DIA_DOC_BOLETO = 1;
	private static final int MES_BOLETO = 8;
	private static final int ANO_BOLETO = 2014;

	private static final String base_path = "export-" + DIA_VENC_BOLETO + "-" + MES_BOLETO + "-" + ANO_BOLETO + "-";

	@Test
	public void geraBoleloRafael() {
		Random rand = new Random();

		Datas datas = Datas.newDatas().withDocumento(DIA_DOC_BOLETO, MES_BOLETO, ANO_BOLETO)
				.withProcessamento(DIA_DOC_BOLETO, MES_BOLETO, ANO_BOLETO).withVencimento(DIA_VENC_BOLETO, MES_BOLETO, ANO_BOLETO);

		Emissor emissor = Emissor
				.newEmissor()
				.withCedente(
						"Centro Federal de Educação Tecnológica de Minas Gerais")
				.withAgencia(1615).withDvAgencia('2').withContaCorrente(333003)
				.withDvContaCorrente('6').withCarteira(18)
				.withNossoNumero(Long.valueOf(+(rand.nextInt(90000) + 90000) + "9854" + (rand.nextInt(90000) + 90000)));

		Sacado sacado = Sacado.newSacado()
				.withNome("RAFAEL ALESSANDRO BATISTA")
				.withCpf("         CPF: 079.667.236-90")
				.withEndereco("Rua Guajajaras, 329 Ap 306")
				.withBairro("Centro").withCep("30180-100")
				.withCidade("Belo Horizonte").withUf("MG");

		Banco banco = new BancoDoBrasil();

		DateFormat formatter = new SimpleDateFormat("MMM");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.MONTH, MES_BOLETO - 1);

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("450.00")
				.withInstrucoes(
						"Contribuinte: RAFAEL ALESSANDRO BATISTA " + formatter.format(calendar.getTime()) + "/ " + (ANO_BOLETO),
						"CPF/CNPJ: 079.667.236-90", " ",
						"Unidade: 30 - COLEGIADO DA DIRETORIA",
						"Tipo Pagamento: 165 - DPPG-ESPECIALIZAÇÃO EM AADSI")
				.withLocaisDePagamento(
						"ATÉ O VENCIMENTO, PAGÁVEL EM QUALQUER AGÊNCIA DA REDE BANCÁRIA")
				.withNoDocumento("0" + (rand.nextInt(90000) + 90000));

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF(base_path + "BancoDoBrasilRafael.pdf");

		// Para gerar um boleto em PNG
		gerador.toPNG(base_path + "BancoDoBrasilRafael.png");

	}

	@Test
	public void geraBoleloVanessa() {
		Random rand = new Random();

		Datas datas = Datas.newDatas().withDocumento(DIA_DOC_BOLETO, MES_BOLETO, ANO_BOLETO)
				.withProcessamento(DIA_DOC_BOLETO, MES_BOLETO, ANO_BOLETO).withVencimento(DIA_VENC_BOLETO, MES_BOLETO, ANO_BOLETO);

		Emissor emissor = Emissor
				.newEmissor()
				.withCedente(
						"Centro Federal de Educação Tecnológica de Minas Gerais")
				.withAgencia(1615).withDvAgencia('2').withContaCorrente(4578451)
				.withDvContaCorrente('6').withCarteira(18)
				.withNossoNumero(Long.valueOf(+(rand.nextInt(90000) + 90000) + "8621" + (rand.nextInt(90000) + 90000)));

		Sacado sacado = Sacado.newSacado()
				.withNome("VANESSA PARREIRAS DE CASTRO")
				.withCpf("         CPF: 046.095.776-74")
				.withEndereco("Rua Sandra, 108 ")
				.withBairro("Nova Cintra").withCep("30513-270")
				.withCidade("Belo Horizonte").withUf("MG");

		Banco banco = new BancoDoBrasil();

		DateFormat formatter = new SimpleDateFormat("MMM");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.MONTH, MES_BOLETO - 1);

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("530.00")
				.withInstrucoes(
						"Contribuinte: VANESSA PARREIRAS DE CASTRO " + formatter.format(calendar.getTime()) + "/ " + (ANO_BOLETO),
						"CPF/CNPJ: 046.095.776-74", " ",
						"Unidade: 30 - COLEGIADO DA DIRETORIA",
						"Tipo Pagamento: 135 - DPPG-ESPECIALIZAÇÃO EM GERH")
				.withLocaisDePagamento(
						"ATÉ O VENCIMENTO, PAGÁVEL EM QUALQUER AGÊNCIA DA REDE BANCÁRIA")
				.withNoDocumento("0" + (rand.nextInt(90000) + 90000));

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF(base_path + "BancoDoBrasilVanessa.pdf");

		// Para gerar um boleto em PNG
		gerador.toPNG(base_path + "BancoDoBrasilVanessa.png");

	}

}
