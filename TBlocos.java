public class TBlocos 
{
    /*_________________________________
            ATRIBUTO DA CLASSE
      _________________________________*/
    /*_________________________________
       LSE - LISTA SIMPLESMENTE ENCADEADA
       Nodes - Nó
      _________________________________*/

    private EstruturaDados[] vetorListaEncadeada; // Responsável por conter em cada posição do vetor uma LSE.

    /*_________________________________
            CONSTRUTOR DA CLASSE 
      _________________________________*/

    public TBlocos(int totalBlocos)
    {
        /*
         O construtor cria o vetor de LSEs com base no total de blocos informados no arquivo de texto de entrada
         e o for irá adicionar em cada posição do vetor o bloco na lista simplesmenta encadeada.  
        */
        this.vetorListaEncadeada = new EstruturaDados[totalBlocos];
        for (int i=0;i<totalBlocos;i++)
        {
            this.vetorListaEncadeada[i] = new EstruturaDados();
            this.vetorListaEncadeada[i].adicionaNodesComeco(i);
        }
    }

    /*___________________________________
        MÉTODO PARA REALOCAR OS BLOCOS
      ___________________________________*/

    private void blocosParaRealocar(int posicaoDosBlocos, int blocoReferencia)
    {
        do
        {
            Nodes ultimaNo = this.vetorListaEncadeada[posicaoDosBlocos].pegaNodes(this.vetorListaEncadeada[posicaoDosBlocos].getTotalElementos());
            this.vetorListaEncadeada[posicaoDosBlocos].remover();
            this.vetorListaEncadeada[ultimaNo.getElemento().getCodigoDoBloco()].adicionaNodes(ultimaNo);
        }
        while (this.vetorListaEncadeada[posicaoDosBlocos].getPosicaoElementoLista(blocoReferencia)!=this.vetorListaEncadeada[posicaoDosBlocos].getTotalElementos());
    }

        /*________________________________
        PEGA A POSIÇÃO DE UM BLOCO DA LSE
      ____________________________________*/

      private int getPosicaoBloco(int bloco)
      {
          int posicaoDoBloco = bloco;
          for (int i=0;i<this.vetorListaEncadeada.length;i++)
          {
              if ((vetorListaEncadeada[i].ChecarElemento(bloco) == true) && (posicaoDoBloco != i))
              {
                  posicaoDoBloco = i;
                  break;
              }
          }
          return posicaoDoBloco;
      }

    /*_____________________________________
        MÉTODO MOVE ON NO MUNDO DOS BLOCOS
      _____________________________________*/

    public void MoveOnTo(int posicaoMovida, int posicaoParaMover)
    {
        int posicaoBlocoMovido = this.getPosicaoBloco(posicaoMovida);
        this.blocosParaRealocar(posicaoBlocoMovido, posicaoMovida);
        this.blocosParaRealocar(posicaoParaMover, posicaoParaMover);
        Nodes blocoParaMover = this.vetorListaEncadeada[posicaoBlocoMovido].pegaNodes(this.vetorListaEncadeada[posicaoBlocoMovido].getPosicaoElementoLista(posicaoMovida));
        this.vetorListaEncadeada[posicaoMovida].remover();
        this.vetorListaEncadeada[posicaoParaMover].adicionaNodes(blocoParaMover);
    }

    /*_______________________________________
        MÉTODO MOVE OVER NO MUNDO DOS BLOCOS
      _______________________________________*/

    public void MoveOver(int posicaoMovida, int posicaoParaMover)
    {
        int posicaoBlocoMovido = this.getPosicaoBloco(posicaoMovida);
        this.blocosParaRealocar(posicaoBlocoMovido, posicaoMovida);
        Nodes blocoParaMover = this.vetorListaEncadeada[posicaoMovida].pegaNodes(1);
        this.vetorListaEncadeada[posicaoMovida].remover();
        this.vetorListaEncadeada[posicaoParaMover].adicionaNodes(blocoParaMover);
    }

    /*_____________________________________
        MÉTODO PILE ON NO MUNDO DOS BLOCOS
      _____________________________________*/

    public void PileOnTo(int posicaoMovida, int posicaoParaMover)
    {
        int posicaoPilha = this.getPosicaoBloco(posicaoMovida);
        this.blocosParaRealocar(posicaoParaMover, posicaoParaMover);
        Nodes pilhaParaMover = this.vetorListaEncadeada[posicaoPilha].removerConjunto(posicaoMovida);
        this.vetorListaEncadeada[posicaoParaMover].adicionaConjunto(pilhaParaMover);
    }

    /*_______________________________________
        MÉTODO PILE OVER NO MUNDO DOS BLOCOS
      _______________________________________*/

    public void PileOver(int posicaoMovida, int posicaoParaMover)
    {
        int posicaoPilha = this.getPosicaoBloco(posicaoMovida);
        Nodes pilhaParaMover = this.vetorListaEncadeada[posicaoPilha].removerConjunto(posicaoMovida);
        this.vetorListaEncadeada[posicaoParaMover].adicionaConjunto(pilhaParaMover);


    }

    /*_______________________________________________________________________________________
        MÉTODO PARA RETORNAR EM UMA STRING COMO ESTÁ POSICIONADO OS BLOCOS NO MUNDO DOS BLOCOS
      _______________________________________________________________________________________*/

    public String ToString()
    {
        String saida = "";
        for (int i=0;i<this.vetorListaEncadeada.length;i++)
        {
            saida += String.valueOf(i) + ": ";
            if (this.vetorListaEncadeada[i].getTotalElementos() != 0)
            {
                Nodes atual = this.vetorListaEncadeada[i].pegaNodes(1);
                for (int l=0;l<this.vetorListaEncadeada[i].getTotalElementos();l++)
                {   
                    if (l == this.vetorListaEncadeada[i].getTotalElementos()-1)
                    {
                        saida += String.valueOf(this.vetorListaEncadeada[i].pegaNodes(l+1).getElemento().getCodigoDoBloco()) + "\n";
                    }
                    else
                    {
                        saida += String.valueOf(this.vetorListaEncadeada[i].pegaNodes(l+1).getElemento().getCodigoDoBloco()) + " ";
                        atual = atual.getProxPonteiro();
                    }
                }
            }
            else
            {
                saida += "\n";
            }
        }
        return saida;
    }
}