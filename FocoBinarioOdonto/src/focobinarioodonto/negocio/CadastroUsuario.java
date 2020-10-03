package focobinarioodonto.negocio;

import focobinarioodonto.dados.RepositorioUsuario;
import focobinarioodonto.negocio.beans.Usuario;


public class CadastroUsuario {
    private RepositorioUsuario repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuario(100); 
    }
    
    public void inserirUsuario(Usuario usuario){}
    
    public void removerUsuario(int id){}
    
    public void editarUsuario(Usuario usuario){}
    
    public void pesquisarUsuario(int id){}
}
