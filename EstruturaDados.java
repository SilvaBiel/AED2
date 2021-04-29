public class EstruturaDados 
{
    /*________________________________
            ATRIBUTOS DA CLASSE
      ________________________________*/

      /*____________________________________
       LSE - LISTA SIMPLESMENTE ENCADEADA
       Nodes - Nó
      ______________________________________*/

    private Nodes inicioLista;   // Armazena a primeira célula ou nó da LSE. 
    private Nodes fimLista;      // Armazena a ultima célula ou nó da LSE
    private int totalElementos;   // Armazena o total de elementos da LSE

    /*_______________________________________
        MÉTODO GETTER DO TOTAL DE ELEMENTOS
      _______________________________________*/

    public int getTotalElementos() {
        return totalElementos;
    }

    /*____________________________________________
        RETORNA A CÉLULA NA POSIÇÃO INFORMADA
      ____________________________________________*/

    public Nodes pegaNodes(int posicao)
    {
        Nodes atual = this.inicioLista;
        /* 
        o FOR percorrerá cada célula ou nó da LSE usando o 'getProxPonteiro()' como base e irá parar o LOOP para retornar a célula solicitada
        assim que a posição informada for igual ao contador
        */
        for (int i=0;i<this.totalElementos;i++)
        {
            if (i == posicao-1)
            {
                break;
            }
            else
            {
                atual = atual.getProxPonteiro();
            }
        }
        return atual;
    }

    /*________________________________________________________________
        CRIA UMA CÉLULA E ADICIONA O PRIMEIRO ELEMENTO NA LSE
      ________________________________________________________________*/

    public void adicionaNodesComeco(int codigo)
    {
        Nodes novo = new Nodes(this.inicioLista, codigo);
        this.inicioLista = novo;
        if (this.totalElementos == 0)
        {
            this.fimLista = this.inicioLista;
        }
        this.totalElementos++;
    }

    /*_________________________________________
        ADICIONA UMA CÉLULA NO FINAL DA LSE
      _________________________________________*/

    public void adicionaNodes(Nodes elemento)
    {
        if (this.totalElementos == 0)
        {
            this.inicioLista = elemento;
            this.fimLista = this.inicioLista;
        }
        else
        {
            this.fimLista.setProxPonteiro(elemento);
            this.fimLista = elemento;
        }
        this.totalElementos++;
    }

    /*_______________________________________
        REMOVE UMA CÉLULA NO COMEÇO DA LSE
      _______________________________________*/

    public void removerComeco()
    {
        this.inicioLista = this.inicioLista.getProxPonteiro();
        this.totalElementos--;
        if (this.totalElementos == 0)
        {
            this.fimLista = null;
        }
    }

    /*________________________________________
        REMOVE UMA CÉLULA NO FINAL DA LSE
      ________________________________________*/

    public void remover()
    {
        if (this.totalElementos == 1)
        {
            this.removerComeco();
        }
        else
        {
            Nodes penultima = this.pegaNodes(this.totalElementos-1);
            penultima.setProxPonteiro(null);
            this.fimLista = penultima;
            this.totalElementos--;
        }
    }
}