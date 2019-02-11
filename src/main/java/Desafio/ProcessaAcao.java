package Desafio;

/**
 *
 * @author Leonardo Simões
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

//Classe para realizar operações relacionadas a conjuntos ou listas de Acoes
public class ProcessaAcao {

    public static List<Acao> lerCSV(String diretorio) {
        List<Acao> acoes = new ArrayList<Acao>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(diretorio));
            // Files.newBufferedReader(Paths.get("acoes.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Acao", "Data", "Close", "Volume").withIgnoreHeaderCase().withSkipHeaderRecord().withTrim());
            for (CSVRecord csvRecord : csvParser) {
                Acao acao;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date data = formatter.parse(csvRecord.get("Data"));
                acao = new Acao(csvRecord.get("Acao"), data, Double.parseDouble(csvRecord.get("Close")), Long.parseLong(csvRecord.get("Volume")));
                //System.out.println(acao.toString());
                acoes.add(acao);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro de arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Erro conversão data");
        }
        return acoes;
    }

    public static Acao fechamentoMaximoAcao(List<Acao> acoes) {
        final Comparator<Acao> comp = (acao1, acao2) -> Double.compare(acao1.getFechamento(), acao2.getFechamento());
        return acoes.stream().max(comp).get();
    }

    public static Acao fechamentoMinimoAcao(List<Acao> acoes) {
        final Comparator<Acao> comp = (acao1, acao2) -> Double.compare(acao1.getFechamento(), acao2.getFechamento());
        return acoes.stream().min(comp).get();
    }

    public static void retorno(List<Acao> acoes) {
        if (acoes.size() >= 1) {
            acoes.get(0).setRetorno(0.0);
        }
        double retornoI;
        for (int i = 1; i < acoes.size(); ++i) {
            //Evitando divisão por zero, se comparar com 0.0 pode ter problema de precisão
            if (acoes.get(i - 1).getFechamento() < 0.000000001) {
                acoes.get(i).setRetorno(0.0);
            } else {
                retornoI = acoes.get(i).getFechamento() / acoes.get(i - 1).getFechamento() - 1;
                acoes.get(i).setRetorno(retornoI);
            }
        }
    }

    public static Acao retornoMaximoAcao(List<Acao> acoes) {
        final Comparator<Acao> comp = (acao1, acao2) -> Double.compare(acao1.getRetorno(), acao2.getRetorno());
        return acoes.stream().max(comp).get();
    }

    public static Acao retornoMinimoAcao(List<Acao> acoes) {
        final Comparator<Acao> comp = (acao1, acao2) -> Double.compare(acao1.getRetorno(), acao2.getRetorno());
        return acoes.stream().min(comp).get();
    }

    public static Double volumeMedioAcao(List<Acao> acoes) {
        return acoes.stream().filter(a -> a.getVolume() != 0).mapToDouble(Acao::getVolume).average().getAsDouble();
    }

}
