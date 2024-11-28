package estruturaDeDados;

public class ListaCircular {
    private No head; // Referência ao início da lista
    private No tail; // Referência ao final da lista
    private int size; // Tamanho da lista

    // Construtor
    public ListaCircular() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Método para inserir no início da lista
    public void insereInicio(int i) {
        No newNode = new No(i);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Atualiza a referência do último nó
        }
        size++;
    }

    // Método para inserir no final da lista
    public void insereFim(int i) {
        No newNode = new No(i);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Faz o último nó apontar para o primeiro
        }
        size++;
    }

    // Método para buscar se um elemento existe na lista
    public boolean buscaElemento(int i) {
        if (size == 0) return false;

        No current = head;
        do {
            if (current.value == i) return true;
            current = current.next;
        } while (current != head);

        return false;
    }

    // Método para buscar o elemento pelo índice
    public Object buscaIndice(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        No current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.value;
    }

    // Método para remover o primeiro elemento
    public void removeInicio() {
        if (size == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head; // Atualiza o último nó para apontar ao novo início
        }
        size--;
    }

    // Método para remover o último elemento
    public void removeFim() {
        if (size == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            No current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = head; // Atualiza o último nó para apontar ao início
        }
        size--;
    }

    // Método para remover pelo índice
    public void removeIndice(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (i == 0) {
            removeInicio();
            return;
        }
        No current = head;
        for (int index = 0; index < i - 1; index++) {
            current = current.next;
        }
        current.next = current.next.next;

        if (i == size - 1) {
            tail = current; // Atualiza o tail caso o último seja removido
        }
        size--;
    }

    // Método para inserir um elemento em uma posição específica
    public void insereElementoPosicao(int i, int j) {
        if (j < 0 || j > size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (j == 0) {
            insereInicio(i);
            return;
        }
        if (j == size) {
            insereFim(i);
            return;
        }
        No newNode = new No(i);
        No current = head;
        for (int index = 0; index < j - 1; index++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}
