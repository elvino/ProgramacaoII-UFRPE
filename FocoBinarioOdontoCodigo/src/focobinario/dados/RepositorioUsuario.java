package focobinario.dados;

import focobinario.negocio.beans.Usuario;


public class RepositorioUsuario {
    private Usuario[] usuarios;
    private int posicao;
    
    public RepositorioUsuario(int tamanho) {
        this.usuarios = new Usuario[tamanho];
        this.posicao = 0;
    }
    
    public void inserirUsuario(Usuario usuario){
        this.usuarios[this.posicao] = usuario;
        this.posicao = this.posicao + 1;
        if (this.posicao == this.usuarios.length) {
            this.extendeRepositorioUsuario();
        }        
    }
    
    public void removerUsuario(String id){
        int i = this.recuperarPosicaoUsuario(id);
        if (i != this.posicao) {
            this.usuarios[i] = this.usuarios[this.posicao - 1];
            this.usuarios[this.posicao - 1] = null;
            this.posicao = this.posicao - 1;
            System.out.println("LOG: Id " + id + " removido");
        } else {
            System.out.println("LOG: Id " + id + " não existe.");
        }
    }
    
    public void editarUsuario(Usuario usuario){
        Usuario alterar = null;
        int i = this.recuperarPosicaoUsuario(String.valueOf(usuario.getCodigoUsuario()));
        if (i != this.posicao) {
            this.usuarios[i].setCodigoUsuario(usuario.getCodigoUsuario());
            this.usuarios[i].setNomeUsuario(usuario.getNomeUsuario());  
            this.usuarios[i].setTipoUsuario(usuario.getTipoUsuario());  
            System.out.println("LOG: Id atualizado");
        } else {
            System.out.println("LOG: Id  não existe.");
        }
    }
    
    public Usuario pesquisarUsuario(String id){
        int i = this.recuperarPosicaoUsuario(id);
        Usuario retorno = null;
        if (i != this.posicao) {
            retorno = this.usuarios[i];
        }
        return retorno;
    }
    
    private void extendeRepositorioUsuario(){
        if (this.usuarios != null && this.usuarios.length > 0) {
            Usuario[] extensorRepositorio = new Usuario[this.usuarios.length * 2];
            for (int i = 0; i < this.usuarios.length; i++) {
                extensorRepositorio[i] = this.usuarios[i];
            }
            this.usuarios = extensorRepositorio;
        }
    }
    
    private int recuperarPosicaoUsuario(String pos) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.posicao)) {
            if (pos.equals(String.valueOf(this.usuarios[i].getCodigoUsuario()))) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
}
