package estruturaDeDados;

public class Lista {
    private No head; // Referência ao início da lista
    private int size;  // Tamanho da lista

    // Construtor
    public Lista() {
        this.head = null;
        this.size = 0;
    }

    // Método para inserir no início da lista
    public void insereInicio(int i) {
        No newNode = new No(i);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Método para buscar se um elemento existe na lista
    public boolean buscaElemento(int i) {
        No current = head;
        while (current != null) {
            if (current.value == i) {
                return true;
            }
            current = current.next;
        }
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

    // Método para inserir no final da lista
    public void insereFim(int i) {
        No newNode = new No(i);
        if (head == null) {
            head = newNode;
        } else {
            No current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Método para remover o primeiro elemento
    public void removeInicio() {
        if (head == null) {
            throw new IllegalStateException("Lista vazia");
        }
        head = head.next;
        size--;
    }

    // Método para remover o último elemento
    public void removeFim() {
        if (head == null) {
            throw new IllegalStateException("Lista vazia");
        }
        if (head.next == null) {
            head = null;
        } else {
            No current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
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
