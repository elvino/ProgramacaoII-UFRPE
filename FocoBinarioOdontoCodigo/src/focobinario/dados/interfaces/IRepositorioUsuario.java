package focobinario.dados.interfaces;

import focobinario.negocio.beans.Usuario;

public interface IRepositorioUsuario {
  void inserirUsuario(Usuario usuario);
  void removerUsuario(String id);    
  void editarUsuario(Usuario usuario);    
  Usuario pesquisarUsuario(String id); 
}
