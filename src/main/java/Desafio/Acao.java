package Desafio;

/**
 *
 * @author Leonardo Simões
 */
import java.util.Date;

public class Acao {

    private String nome;
    private Date data;
    private double fechamento;
    private long volume;
    private double retorno;

    public Acao() {

    }

    public Acao(String nome, Date data, double fechamento, long volume) {
        this.nome = nome;
        this.data = data;
        this.fechamento = fechamento;
        this.volume = volume;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getFechamento() {
        return fechamento;
    }

    public void setFechamento(double fechamento) {
        this.fechamento = fechamento;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getRetorno() {
        return this.retorno;
    }

    public void setRetorno(double retorno) {
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "Acao [nome=" + nome + ", data=" + data + ", fechamento="
                + fechamento + ", volume=" + volume + "]";
    }
}
