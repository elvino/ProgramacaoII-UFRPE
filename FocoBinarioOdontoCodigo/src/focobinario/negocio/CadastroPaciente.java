package focobinario.negocio;

import focobinario.dados.RepositorioPaciente;
import focobinario.negocio.beans.Paciente;

public class CadastroPaciente {
    private RepositorioPaciente repositorio;

    public CadastroPaciente() {
        this.repositorio = new RepositorioPaciente(100); 
    }
    
    public void inserirPaciente(Paciente paciente){
        if (paciente != null) {          
            this.repositorio.inserirPaciente(paciente);            
        }     
    }
    
    public void removerPaciente(String id){
        this.repositorio.removerPaciente(id);
    }
    
    public void editarPaciente(Paciente paciente){
        this.repositorio.editarPaciente(paciente);
    }
    
    public Paciente pesquisarPaciente(String id){
        return this.repositorio.pesquisarPaciente(id);
    }
}
