package estruturaDeDados;

public class ListaCircular {
    private No cabeca;
    private int tamanho;

    public ListaCircular() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void insereInicio(int i) {
        No novoNo = new No(i);
        if (tamanho == 0) {
            // V Se a lista está vazia
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

    public boolean buscaElemento(int i) {
        No atual = cabeca;
        if (atual == null) return false; // Lista vazia
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

    public int getTamanho() {
        return tamanho;
    }
}
