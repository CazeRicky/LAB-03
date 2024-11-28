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
        assertEquals(e.buscaElemento(0), true);
        e.insereInicio(1);
        assertEquals(e.buscaElemento(0), true);
        e.insereInicio(2);
        e.insereInicio(3);
        assertEquals("O indice 4 é o 3", e.buscaIndice(4), 3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
    }
}