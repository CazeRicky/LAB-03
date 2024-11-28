package estruturaDeDados;

public class No {
    int value;      // Valor armazenado no no
    No next;        // Referencia para o prox

    public No(int value) {
        this.value = value;
        this.next = null;
    }
}
