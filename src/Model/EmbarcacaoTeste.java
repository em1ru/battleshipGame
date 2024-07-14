package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmbarcacaoTeste {
    private Tabuleiro tabuleiro;
    private Couracado couracado;
    private Cruzador cruzador;
    private Destroyer destroyer;
    private Hidroaviao hidroaviao;
    private Submarino submarino;

    @Before
    public void setUp() {
        tabuleiro = new Tabuleiro();
        tabuleiro.criacaoTabuleiros();
        couracado = new Couracado('H');
        cruzador = new Cruzador('H');
        destroyer = new Destroyer('H');
        hidroaviao = new Hidroaviao('H'); // Passa a direção como parâmetro
        submarino = new Submarino('H');
    }

    @Test
    public void testPosicionarValido() {
        boolean resultado = couracado.posicionar('A', 0, tabuleiro.getEstado('1'));
        assertTrue("Embarcação deve ser posicionada corretamente.", resultado);
    }

    @Test
    public void testPosicionarInvalidoForaDoTabuleiro() {
        boolean resultado = couracado.posicionar('A', 12, tabuleiro.getEstado('1'));
        assertFalse("Embarcação não deve ser posicionada fora do tabuleiro.", resultado);
    }

    @Test
    public void testPosicionarSobreposicao() {
        couracado.posicionar('A', 0, tabuleiro.getEstado('1'));
        boolean resultado = cruzador.posicionar('A', 0, tabuleiro.getEstado('1'));
        assertFalse("Embarcação não deve sobrepor outra.", resultado);
    }

    @Test
    public void testCouracadoPosicionamentoValido() {
        assertTrue("Couracado deve ser posicionado corretamente.", couracado.posicionar('B', 0, tabuleiro.getEstado('1')));
    }

    @Test
    public void testCruzadorPosicionamentoForaDoTabuleiro() {
        assertFalse("Cruzador não deve ser posicionado fora do tabuleiro.", cruzador.posicionar('B', 12, tabuleiro.getEstado('1')));
    }

    @Test
    public void testDestroyerPosicionamentoSobreposicao() {
        couracado.posicionar('A', 0, tabuleiro.getEstado('1'));
        assertFalse("Destroyer não deve sobrepor outro navio.", destroyer.posicionar('C', 2, tabuleiro.getEstado('1')));
    }

    @Test
    public void testHidroaviaoPosicionamentoValido() {
        assertTrue("Hidroavião deve ser posicionado corretamente.", hidroaviao.posicionar('C', 3, tabuleiro.getEstado('1')));
    }

    @Test
    public void testSubmarinoPosicionamentoValido() {
        assertTrue("Submarino deve ser posicionado corretamente.", submarino.posicionar('M', 14, tabuleiro.getEstado('1')));
    }

    @Test
    public void testHidroaviaoVerticalPosicionamentoValido() {
        hidroaviao = new Hidroaviao('V');
        assertTrue("Hidroavião deve ser posicionado corretamente.", hidroaviao.posicionar('C', 3, tabuleiro.getEstado('1')));
    }
}
