package focobinario.dados;

import focobinario.dados.interfaces.IRepositorioOdonto;
import focobinario.negocio.beans.Odonto;


public class RepositorioOdonto implements IRepositorioOdonto {
    private Odonto[] odontos;
    private int posicao;
    
    public RepositorioOdonto(int tamanho) {
        this.odontos = new Odonto[tamanho];
        this.posicao = 0;
    }
    
    public void inserirOdonto(Odonto odonto){
        this.odontos[this.posicao] = odonto;
        this.posicao = this.posicao + 1;
        if (this.posicao == this.odontos.length) {
            this.extendeRepositorioOdonto();
        }        
    }
    
    public void removerOdonto(String id){
        int i = this.recuperarPosicaoOdonto(id);
        if (i != this.posicao) {
            this.odontos[i] = this.odontos[this.posicao - 1];
            this.odontos[this.posicao - 1] = null;
            this.posicao = this.posicao - 1;
            System.out.println("LOG: Id " + id + " removido");
        } else {
            System.out.println("LOG: Id " + id + " não existe.");
        }
    }
    
    public void editarOdonto(Odonto odonto){
        Odonto alterar = null;
        int i = this.recuperarPosicaoOdonto(String.valueOf(odonto.getCodigoOdonto()));
        if (i != this.posicao) {
            this.odontos[i].setCodigoOdonto(odonto.getCodigoOdonto());
            this.odontos[i].setCroOdonto(odonto.getCroOdonto());  
            this.odontos[i].setNomeOdonto(odonto.getNomeOdonto());  
            this.odontos[i].setEspecialidadeOdonto(odonto.getEspecialidadeOdonto());  
            System.out.println("LOG: Id atualizado");
        } else {
            System.out.println("LOG: Id  não existe.");
        }
    }
    
    public Odonto pesquisarOdonto(String id){
        int i = this.recuperarPosicaoOdonto(id);
        Odonto retorno = null;
        if (i != this.posicao) {
            retorno = this.odontos[i];
        }
        return retorno;
    }
    
    private void extendeRepositorioOdonto(){
        if (this.odontos != null && this.odontos.length > 0) {
            Odonto[] extensorRepositorio = new Odonto[this.odontos.length * 2];
            for (int i = 0; i < this.odontos.length; i++) {
                extensorRepositorio[i] = this.odontos[i];
            }
            this.odontos = extensorRepositorio;
        }
    }
    
    private int recuperarPosicaoOdonto(String pos) {
        int i = 0;
        boolean encontrado = false;
        while ((!encontrado) && (i < this.posicao)) {
            if (pos.equals(String.valueOf(this.odontos[i].getCodigoOdonto()))) {
                encontrado = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
}
