package Desafio;

/**
 *
 * @author Leonardo Simões
 */
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Classe com o método que realiza as tarefas exigidas
public class Principal {

    //Metodo estático main que será executado automaticamente
    public static void main(String[] args) {
        //Lista de ações construidas a partir do arquivo csv
        String diretorio;
        //O diretorio está fixo com o caminho completo para funcionar executando pelo .java e pelo .jar
        diretorio = "C://acoes.csv";
        List<Acao> acoes = ProcessaAcao.lerCSV(diretorio);
        Map<String, List<Acao>> m = acoes.stream().collect(Collectors.groupingBy(Acao::getNome));
        //Formatador de data
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        //For para realizar operações para grupos de ações com mesmo nome
        for (String nome : m.keySet()) {
            List<Acao> acaoEmpresa = m.get(nome);
            System.out.println(" ----------------  Acao " + nome + "  ---------------- ");
            Acao acaoMaxFechamento = ProcessaAcao.fechamentoMaximoAcao(acaoEmpresa);
            System.out.println("1 - Fechamento Maximo no dia " + fd.format(acaoMaxFechamento.getData()) + " com valor R$" + acaoMaxFechamento.getFechamento());
            Acao acaoMinFechamento = ProcessaAcao.fechamentoMinimoAcao(acaoEmpresa);
            System.out.println("2 - Fechamento Minimo no dia " + fd.format(acaoMinFechamento.getData()) + " com valor R$" + acaoMinFechamento.getFechamento());
            ProcessaAcao.retorno(acaoEmpresa);
            Acao acaoMaxRetorno = ProcessaAcao.retornoMaximoAcao(acaoEmpresa);
            System.out.println("3 - Retorno Maximo no dia " + fd.format(acaoMaxRetorno.getData()) + " com valor R$" + acaoMaxRetorno.getRetorno());
            Acao acaoMinRetorno = ProcessaAcao.retornoMinimoAcao(acaoEmpresa);
            System.out.println("4 - Retorno Minimo no dia " + fd.format(acaoMinRetorno.getData()) + " com valor R$" + acaoMinRetorno.getRetorno());
            double volumeMedio = ProcessaAcao.volumeMedioAcao(acaoEmpresa);
            System.out.println("5 - Volume medio de acao: " + volumeMedio);
            System.out.println("\n");
        }
    }

}
