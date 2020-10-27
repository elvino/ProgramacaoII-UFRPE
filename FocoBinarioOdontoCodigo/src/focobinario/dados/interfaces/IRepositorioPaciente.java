package focobinario.dados.interfaces;

import focobinario.negocio.beans.Paciente;

public interface IRepositorioPaciente {
  void inserirPaciente(Paciente paciente);
  void removerPaciente(String id);    
  void editarPaciente(Paciente paciente);    
  Paciente pesquisarPaciente(String id);   
}