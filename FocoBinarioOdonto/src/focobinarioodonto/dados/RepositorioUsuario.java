package focobinarioodonto.dados;

import focobinarioodonto.negocio.beans.Usuario;


public class RepositorioUsuario {
    private Usuario[] usuarios;
    private int posicao;
    
    public RepositorioUsuario(int tamanho) {
        this.usuarios = new Usuario[tamanho];
        this.posicao = 0;
    }
    
    public void inserirUsuario(Usuario usuario){}
    
    public void removerUsuario(int id){}
    
    public void editarUsuario(Usuario usuario){}
    
    public void pesquisarUsuario(int id){}
    
    public void estendeRepositorioUsuario(){}
}
