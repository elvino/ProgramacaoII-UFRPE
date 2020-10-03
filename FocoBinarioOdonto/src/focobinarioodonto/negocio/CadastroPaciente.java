package focobinarioodonto.negocio;

import focobinarioodonto.dados.RepositorioPaciente;
import focobinarioodonto.negocio.beans.Paciente;

public class CadastroPaciente {
    private RepositorioPaciente repositorio;

    public CadastroPaciente() {
        this.repositorio = new RepositorioPaciente(100); 
    }
    
    public void inserirPaciente(Paciente paciente){}
    
    public void removerPaciente(int id){}
    
    public void editarPaciente(Paciente paciente){}
    
    public void pesquisarPaciente(int id){}

}
