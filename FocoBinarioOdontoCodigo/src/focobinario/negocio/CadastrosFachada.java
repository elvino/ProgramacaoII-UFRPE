package focobinario.negocio;

import focobinario.negocio.beans.Odonto;
import focobinario.negocio.beans.Paciente;
import focobinario.negocio.beans.Usuario;

public class CadastrosFachada {
    private CadastroOdonto odontos;
    private CadastroPaciente pacientes;
    private CadastroUsuario usuarios; 
    
    private static CadastrosFachada instance;
    
    private CadastrosFachada(){
        this.odontos = new CadastroOdonto();
        this.pacientes = new CadastroPaciente();
	this.usuarios = new CadastroUsuario();
    }
    
    public static CadastrosFachada getInstance() {
        if (instance == null) {
            instance = new CadastrosFachada();
        }
        return instance;
    }
    
    public void inserirOdonto(Odonto odonto){
        this.odontos.inserirOdonto(odonto);
    }
    
    public void removerOdonto(String id){
        this.odontos.removerOdonto(id);
    }
    
    public void editarOdonto(Odonto odonto){
        this.odontos.editarOdonto(odonto);
    }
    
    public Odonto pesquisarOdonto(String id){
        return this.odontos.pesquisarOdonto(id);
    }
    
    public void inserirPaciente(Paciente paciente){
        this.pacientes.inserirPaciente(paciente);
    }
    
    public void removerPaciente(String id){
        this.pacientes.removerPaciente(id);
    }
    
    public void editarPaciente(Paciente paciente){
        this.pacientes.editarPaciente(paciente);
    }
    
    public void pesquisarPaciente(String id){
        this.pacientes.pesquisarPaciente(id);
    }
    
    public void inserirUsuario(Usuario usuario){
        this.usuarios.inserirUsuario(usuario);
    }
    
    public void removerUsuario(String id){
        this.usuarios.removerUsuario(id);
    }
    
    public void editarUsuario(Usuario usuario){
        this.usuarios.editarUsuario(usuario);
    }
    
    public void pesquisarUsuario(String id){
        this.usuarios.pesquisarUsuario(id);
    }
}
