package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import estruturaDeDados.ListaCircular;

public class ListaCircularTest {

    private ListaCircular e;

    @Before
    public void setUp() throws Exception {
        e = new ListaCircular();
    }

    @Test
    public void testInsereInicio() {
        e.insereInicio(0);
        assertTrue("Elemento 0 deve estar presente", e.buscaElemento(0));
        e.insereInicio(1);
        assertTrue("Elemento 0 deve estar presente", e.buscaElemento(0));
        e.insereInicio(2);
        e.insereInicio(3);
        assertEquals("O indice 0 é o 3", e.buscaIndice(0), 3);
        assertEquals("O indice 1 é o 2", e.buscaIndice(1), 2);
        assertEquals("O indice 2 é o 1", e.buscaIndice(2), 1);
        assertEquals("O indice 3 é o 0", e.buscaIndice(3), 0);

        assertFalse("Elemento 5 não deve estar presente", e.buscaElemento(5));
        assertFalse("Elemento -1 não deve estar presente", e.buscaElemento(-1));
    }
}
