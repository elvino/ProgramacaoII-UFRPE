package focobinario.dados;

import focobinario.negocio.beans.Paciente;


public class RepositorioPaciente {
    private Paciente[] pacientes;
    private int posicao;
    
    public RepositorioPaciente(int tamanho) {
        this.pacientes = new Paciente[tamanho];
        this.posicao = 0;
    }
    
   public void inserirPaciente(Paciente paciente){
        this.pacientes[this.posicao] = paciente;
        this.posicao = this.posicao + 1;
        if (this.posicao == this.pacientes.length) {
            this.extendeRepositorioPaciente();
        }        
    }
    
    public void removerPaciente(String id){
        int i = this.recuperarPosicaoPaciente(id);
        if (i != this.posicao) {
            this.pacientes[i] = this.pacientes[this.posicao - 1];
            this.pacientes[this.posicao - 1] = null;
            this.posicao = this.posicao - 1;
            System.out.println("LOG: Id " + id + " removido");
        } else {
            System.out.println("LOG: Id " + id + " não existe.");
        }
    }
    
    public void editarPaciente(Paciente paciente){
        Paciente alterar = null;
        int i = this.recuperarPosicaoPaciente(String.valueOf(paciente.getCodigoPaciente()));
        if (i != this.posicao) {
            this.pacientes[i].setCodigoPaciente(paciente.getCodigoPaciente());
            this.pacientes[i].setNomePaciente(paciente.getNomePaciente());  
            this.pacientes[i].setRgPaciente(paciente.getRgPaciente());  
            this.pacientes[i].setEnderecoPaciente(paciente.getEnderecoPaciente()); 
            this.pacientes[i].setIdadePaciente(paciente.getIdadePaciente());  
            System.out.println("LOG: Id atualizado");
        } else {
            System.out.println("LOG: Id  não existe.");
        }
    }
    
    public Paciente pesquisarPaciente(String id){
        int i = this.recuperarPosicaoPaciente(id);
        Paciente retorno = null;
        if (i != this.posicao) {
            retorno = this.pacientes[i];
        }
        return retorno;
    }
    
    private void extendeRepositorioPaciente(){
        if (this.pacientes != null && this.pacientes.length > 0) {
            Paciente[] extensorRepositorio = new Paciente[this.pacientes.length * 2];
            for (int i = 0; i < this.pacientes.length; i++) {
                extensorRepositorio[i] = this.pacientes[i];
            }
            this.pacientes = extensorRepositorio;
        }
    }
    
    private int recuperarPosicaoPaciente(String pos) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.posicao)) {
            if (pos.equals(String.valueOf(this.pacientes[i].getCodigoPaciente()))) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
}
