public class Bloco 
{
    /*_________________________________
            ATRIBUTO DA CLASSE
      _________________________________*/
    /*_________________________________
       LSE - LISTA SIMPLESMENTE ENCADEADA
       No - Nó
      __________________________________*/

    private int codigoBloco;

    /*__________________________________
            CONSTRUTOR DA CLASSE
      __________________________________*/

    public Bloco(int codigo)
    {
        this.setCodigoBloco(codigo);
    }

    /*__________________________________________
          MÉTODOS GETTER E SETTER DA CLASSE
      __________________________________________*/

    public int getCodigoDoBloco() {
        return codigoBloco;
    }

    public void setCodigoBloco(int codigo) {
        this.codigoBloco = codigo;
    }
}
