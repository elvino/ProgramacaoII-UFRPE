package focobinarioodonto.negocio.beans;

public class Odonto {

    private int codigoOdonto;
    private String nomeOdonto;
    private String especialidadeOdonto;
    private String croOdonto;
    
    public int getCodigoOdonto() {
        return codigoOdonto;
    }

    public void setCodigoOdonto(int codigoOdonto) {
        this.codigoOdonto = codigoOdonto;
    }

    public String getNomeOdonto() {
        return nomeOdonto;
    }

    public void setNomeOdonto(String nomeOdonto) {
        this.nomeOdonto = nomeOdonto;
    }

    public String getEspecialidadeOdonto() {
        return especialidadeOdonto;
    }

    public void setEspecialidadeOdonto(String especialidadeOdonto) {
        this.especialidadeOdonto = especialidadeOdonto;
    }

    public String getCroOdonto() {
        return croOdonto;
    }

    public void setCroOdonto(String croOdonto) {
        this.croOdonto = croOdonto;
    }
      
    public Odonto(){}   
}