package estruturaDeDados;

public class Lista {
    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No cabeca;
    private int tamanho;

    public Lista() {
        cabeca = null;
        tamanho = 0;
    }

    public void insereInicio(int i) {
        No novoNo = new No(i);
        if (tamanho == 0) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
        } else {
            No ultimo = cabeca;
            while (ultimo.proximo != cabeca) {
                ultimo = ultimo.proximo;
            }
            novoNo.proximo = cabeca;
            ultimo.proximo = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void insereFim(int i) {
        No novoNo = new No(i);
        if (tamanho == 0) {
            insereInicio(i); 
        } else {
            No ultimo = cabeca;
            while (ultimo.proximo != cabeca) {
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novoNo;
            novoNo.proximo = cabeca; // O novo nó aponta pacabeça
            tamanho++;
        }
    }

    public void removeInicio() {
        if (tamanho == 0) {
            return; 
        }
        if (tamanho == 1) {
            cabeca = null;
        } else {
            No ultimo = cabeca;
            while (ultimo.proximo != cabeca) {
                ultimo = ultimo.proximo;
            }
            cabeca = cabeca.proximo; // Atualiza a cabeça
            ultimo.proximo = cabeca; // ultimo agora aponta pa nova cabeça
        }
        tamanho--;
    }

    public void removeFim() {
        if (tamanho == 0) {
            return; // retorna se a lista estiver vazia
        }
        if (tamanho == 1) {
            cabeca = null; // Remove o único elemento
        } else {
            No atual = cabeca;
            while (atual.proximo.proximo != cabeca) {
                atual = atual.proximo;
            }
            atual.proximo = cabeca; //penúltimo elemento agora vai pa cabeça
        }
        tamanho--;
    }

    public void insereElementoPosicao(int i, int j) {
        if (j < 0 || j > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        if (j == 0) {
            insereInicio(i); // Insere no início se a posição for 0
        } else {
            No novoNo = new No(i);
            No atual = cabeca;
            for (int k = 0; k < j - 1; k++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            tamanho++;
        }
    }

    public void removeIndice(int j) {
        if (j < 0 || j >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        if (j == 0) {
            removeInicio(); //indice 0 chama o método removeInicio
        } else {
            No atual = cabeca;
            for (int k = 0; k < j - 1; k++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo; // Remove o no j
            tamanho--;
        }
    }

    public boolean buscaElemento(int i) {
        if (tamanho == 0) {
            return false;
        }
        No atual = cabeca;
        do {
            if (atual.valor == i) {
                return true;
            }
            atual = atual.proximo;
        } while (atual != cabeca);
        return false;
    }

    public Object buscaIndice(int i) {
        if (i < 0 || i >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        No atual = cabeca;
        for (int k = 0; k < i; k++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }
}
