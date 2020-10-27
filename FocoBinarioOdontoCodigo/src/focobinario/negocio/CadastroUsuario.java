package focobinario.negocio;

import focobinario.dados.RepositorioUsuario;
import focobinario.negocio.beans.Usuario;


public class CadastroUsuario {
    private RepositorioUsuario repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuario(100); 
    }
    
    public void inserirUsuario(Usuario usuario){
        if (usuario != null) {          
            this.repositorio.inserirUsuario(usuario);            
        }     
    }
    
    public void removerUsuario(String id){
        this.repositorio.removerUsuario(id);
    }
    
    public void editarUsuario(Usuario usuario){
        this.repositorio.editarUsuario(usuario);
    }
    
    public Usuario pesquisarUsuario(String id){
        return this.repositorio.pesquisarUsuario(id);
    }
}
