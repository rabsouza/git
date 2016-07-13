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
    private static final int DIA_DOC_BOLETO = 5;
    private static final int MES_BOLETO = 7;
    private static final int ANO_BOLETO = 2016;

    private static final String base_path = "export/export-" + DIA_VENC_BOLETO + "-" + MES_BOLETO + "-" + ANO_BOLETO + "-";

    @Test
    public void geraBoleloRafael() {
        Random rand = new Random();

        Datas datas = Datas.newDatas().withDocumento(DIA_DOC_BOLETO + rand.nextInt(5), MES_BOLETO, ANO_BOLETO).withProcessamento(DIA_DOC_BOLETO + rand.nextInt(5), MES_BOLETO, ANO_BOLETO)
                        .withVencimento(DIA_VENC_BOLETO, MES_BOLETO, ANO_BOLETO);

        Emissor emissor = Emissor.newEmissor().withCedente("Centro Federal de Educação Tecnológica - FUNEC ").withAgencia(1615).withDvAgencia('2').withContaCorrente(333003).withDvContaCorrente('6')
                        .withCarteira(18).withNossoNumero(Long.valueOf(+(rand.nextInt(90000) + 90000) + "9854" + (rand.nextInt(90000) + 90000)));

        Sacado sacado = Sacado.newSacado().withNome("RAFAEL ALESSANDRO BATISTA").withCpf("         CPF: 079.667.236-90").withEndereco("Rua Guajajaras, 329 Ap 306").withBairro("Centro")
                        .withCep("30180-100").withCidade("Belo Horizonte").withUf("MG");

        Banco[] banco = { new BancoDoBrasil() };
        int indexBanco = (int) (Math.round(Math.random()) % banco.length);

        DateFormat formatter = new SimpleDateFormat("MMM");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, MES_BOLETO - 1);

        Boleto boleto = Boleto.newBoleto().withBanco(banco[indexBanco]).withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto("350.00")
                        .withInstrucoes("Contribuinte: RAFAEL ALESSANDRO BATISTA " + formatter.format(calendar.getTime()) + "/ " + ANO_BOLETO, "CPF/CNPJ: 079.667.236-90", " ",
                                        "Unidade: 30 - COLEGIADO DA DIRETORIA", "Tipo Pagamento: 165 - DPCT-TÉCNICO EM ADMINISTRAÇÃO")
                        .withLocaisDePagamento("ATÉ O VENCIMENTO, PAGÁVEL EM QUALQUER AGÊNCIA DA REDE BANCÁRIA").withNoDocumento("0" + (rand.nextInt(90000) + 90000));

        BoletoGenerator gerador = new BoletoGenerator(boleto);

        // Para gerar um boleto em PDF
        String boletoName = "BoletoRafael.pdf";
        System.out.println("Path: " + base_path + boletoName);
        gerador.toPDF(base_path + boletoName);

        // Para gerar um boleto em PNG
        String boletoImg = "ImgRafael.png";
        System.out.println("Path: " + base_path + boletoImg);
        gerador.toPNG(base_path + boletoImg);

    }

    @Test
    public void geraBoleloVanessa() {
        Random rand = new Random();

        Datas datas = Datas.newDatas().withDocumento(DIA_DOC_BOLETO + rand.nextInt(5), MES_BOLETO, ANO_BOLETO).withProcessamento(DIA_DOC_BOLETO + rand.nextInt(5), MES_BOLETO, ANO_BOLETO)
                        .withVencimento(DIA_VENC_BOLETO, MES_BOLETO, ANO_BOLETO);

        Emissor emissor = Emissor.newEmissor().withCedente("Centro Federal de Educação Tecnológica - FUNEC ").withAgencia(1615).withDvAgencia('2').withContaCorrente(4578451).withDvContaCorrente('6')
                        .withCarteira(18).withNossoNumero(Long.valueOf(+(rand.nextInt(90000) + 90000) + "8621" + (rand.nextInt(90000) + 90000)));

        Sacado sacado = Sacado.newSacado().withNome("VANESSA PARREIRAS DE CASTRO").withCpf("         CPF: 046.095.776-74").withEndereco("Rua Sandra, 108 ").withBairro("Nova Cintra")
                        .withCep("30513-270").withCidade("Belo Horizonte").withUf("MG");

        Banco[] banco = { new BancoDoBrasil() };
        int indexBanco = (int) (Math.round(Math.random()) % banco.length);

        DateFormat formatter = new SimpleDateFormat("MMM");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, MES_BOLETO - 1);

        Boleto boleto = Boleto.newBoleto().withBanco(banco[indexBanco]).withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto("330.00")
                        .withInstrucoes("Contribuinte: VANESSA PARREIRAS DE CASTRO " + formatter.format(calendar.getTime()) + "/ " + ANO_BOLETO, "CPF/CNPJ: 046.095.776-74", " ",
                                        "Unidade: 30 - COLEGIADO DA DIRETORIA", "Tipo Pagamento: 135 - DPCT-TÉCNICO EM GERH")
                        .withLocaisDePagamento("ATÉ O VENCIMENTO, PAGÁVEL EM QUALQUER AGÊNCIA DA REDE BANCÁRIA").withNoDocumento("0" + (rand.nextInt(90000) + 90000));

        BoletoGenerator gerador = new BoletoGenerator(boleto);

        // Para gerar um boleto em PDF
        String boletoName = "BoletoVanessa.pdf";
        System.out.println("Path: " + base_path + boletoName);
        gerador.toPDF(base_path + boletoName);

        // Para gerar um boleto em PNG
        String boletoImg = "ImgVanessa.png";
        System.out.println("Path: " + base_path + boletoImg);
        gerador.toPNG(base_path + boletoImg);

    }

}
