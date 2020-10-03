package focobinarioodonto.dados;

import focobinarioodonto.negocio.beans.Odonto;


public class RepositorioOdonto {
    private Odonto[] odontos;
    private int posicao;
    
    public RepositorioOdonto(int tamanho) {
        this.odontos = new Odonto[tamanho];
        this.posicao = 0;
    }
    
    public void inserirOdonto(Odonto odonto){}
    
    public void removerOdonto(int id){}
    
    public void editarOdonto(Odonto odonto){}
    
    public void pesquisarOdonto(int id){}
    
    public void estendeRepositorioOdonto(){}
}
