public class Nodes 
{
    /*_________________________________
            ATRIBUTOS DA CLASSE
      _________________________________*/
    /*_________________________________
       LSE - LISTA SIMPLESMENTE ENCADEADA
      __________________________________*/

    private Bloco elemento;     // Responsável por armazenar o objeto Bloco.
    private Nodes ponteiro;    // Responsável por apontar para a próxima célula (nó).

    /*_______________________________________
            CONSTRUTORES DA CLASSE
      _______________________________________*/

    public Nodes(Nodes ProxPonteiro, int codigo)
    {
        this.setProxPonteiro(ProxPonteiro);
        this.setElemento(new Bloco(codigo));
    }

    public Nodes(int codigo)
    {
        this.setElemento(new Bloco(codigo));
    }

    /*__________________________________________
        MÉTODOS GETTERS E SETTERS DA CLASSE
      __________________________________________*/

    public Bloco getElemento() {
        return elemento;
    }
    public void setElemento(Bloco elemento) {
        this.elemento = elemento;
    }
    public Nodes getProxPonteiro() {
        return ponteiro;
    }
    public void setProxPonteiro(Nodes ProxPonteiro) {
        this.ponteiro = ProxPonteiro;
    }

    
}
