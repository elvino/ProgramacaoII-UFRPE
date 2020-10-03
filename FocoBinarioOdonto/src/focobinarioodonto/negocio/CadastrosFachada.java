package focobinarioodonto.negocio;

import focobinarioodonto.negocio.beans.Odonto;
import focobinarioodonto.negocio.beans.Paciente;
import focobinarioodonto.negocio.beans.Usuario;

public class CadastrosFachada {
    private CadastroOdonto odontos;
    private CadastroPaciente pacientes;
    private CadastroUsuario usuarios; 
    
    private CadastrosFachada(){
        this.odontos = new CadastroOdonto();
        this.pacientes = new CadastroPaciente();
	this.usuarios = new CadastroUsuario();
    }
    
    public void inserirOdonto(Odonto odonto){}
    
    public void removerOdonto(int id){}
    
    public void editarOdonto(Odonto odonto){}
    
    public void pesquisarOdonto(int id){}
    
    public void inserirPaciente(Paciente paciente){}
    
    public void removerPaciente(int id){}
    
    public void editarPaciente(Paciente paciente){}
    
    public void pesquisarPaciente(int id){}
    
    public void inserirUsuario(Usuario usuario){}
    
    public void removerUsuario(int id){}
    
    public void editarUsuario(Usuario usuario){}
    
    public void pesquisarUsuario(int id){}
}
