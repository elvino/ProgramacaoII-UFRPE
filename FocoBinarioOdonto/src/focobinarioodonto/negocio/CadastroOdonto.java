package focobinarioodonto.negocio;

import focobinarioodonto.dados.RepositorioOdonto;
import focobinarioodonto.negocio.beans.Odonto;


public class CadastroOdonto {
    
    private RepositorioOdonto repositorio;
    
    public CadastroOdonto() {
        this.repositorio = new RepositorioOdonto(100); 
    }
    
    public void inserirOdonto(Odonto odonto){}
    
    public void removerOdonto(int id){}
    
    public void editarOdonto(Odonto odonto){}
    
    public void pesquisarOdonto(int id){}
}