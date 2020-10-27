package focobinario.dados.interfaces;

import focobinario.negocio.beans.Odonto;

public interface IRepositorioOdonto {
  void inserirOdonto(Odonto odonto);
  void removerOdonto(String id);    
  void editarOdonto(Odonto odonto);    
  Odonto pesquisarOdonto(String id);    
}