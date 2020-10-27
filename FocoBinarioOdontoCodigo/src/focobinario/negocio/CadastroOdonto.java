package focobinario.negocio;

import focobinario.dados.RepositorioOdonto;
import focobinario.negocio.beans.Odonto;


public class CadastroOdonto {
    
    private RepositorioOdonto repositorio;
    
    public CadastroOdonto() {
        this.repositorio = new RepositorioOdonto(100); 
    }
    
    public void inserirOdonto(Odonto odonto){
        if (odonto != null) {          
            this.repositorio.inserirOdonto(odonto);            
        }     
    }
    
    public void removerOdonto(String id){
        this.repositorio.removerOdonto(id);
    }
    
    public void editarOdonto(Odonto odonto){
        this.repositorio.editarOdonto(odonto);
    }
    
    public Odonto pesquisarOdonto(String id){
        return this.repositorio.pesquisarOdonto(id);
    }
}