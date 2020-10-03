package focobinarioodonto.dados;

import focobinarioodonto.negocio.beans.Paciente;


public class RepositorioPaciente {
    private Paciente[] pacientes;
    private int posicao;
    
    public RepositorioPaciente(int tamanho) {
        this.pacientes = new Paciente[tamanho];
        this.posicao = 0;
    }
    
    public void inserirPaciente(Paciente paciente){}
    
    public void removerPaciente(int id){}
    
    public void editarPaciente(Paciente paciente){}
    
    public void pesquisarPaciente(int id){}
    
    public void estendeRepositorioPaciente(){}
}
