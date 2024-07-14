package Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestaTabuleiro {
    private Tabuleiro tabuleiro;
    private final String arquivoTeste = "estadoJogoTeste.txt";

    @Before
    public void setUp() {
        tabuleiro = new Tabuleiro();
        tabuleiro.criacaoTabuleiros(); // Inicializa os tabuleiros
    }

    @After
    public void tearDown() {
        // Apagar arquivos de teste após cada teste
        try {
            Files.deleteIfExists(Paths.get(arquivoTeste));
        } catch (IOException e) {
            System.err.println("Erro ao deletar o arquivo de teste: " + e.getMessage());
        }
    }

    @Test
    public void testInserirEmbarcacao() {
        Embarcacao destroyer = new Destroyer('H'); // Suponha que essa é uma chamada válida
        boolean resultado = tabuleiro.insereEmbarcacao(destroyer, 'A', 0, '1');
        assertTrue("Deve ser possível inserir a embarcação no tabuleiro P1.", resultado);
    }

    @Test
    public void testAtacarEmbarcacao() {
        Embarcacao submarino = new Submarino('V');
        tabuleiro.insereEmbarcacao(submarino, 'C', 5, '2'); // Insere submarino no tabuleiro P2
        String resultado = tabuleiro.atacar('C', 5, '1'); // P1 ataca a posição C5 do P2
        assertEquals("Deve haver um acerto ('Hit!')", "Hit!", resultado);
    }

    @Test
    public void testVerificarDerrota() {
        Embarcacao submarino = new Submarino('V');
        tabuleiro.insereEmbarcacao(submarino, 'C', 5, '2'); // Insere no P2
        tabuleiro.atacar('C', 5, '1'); // P1 ataca
        assertTrue("P2 deve ter sido derrotado.", tabuleiro.jogadorPerdeu('2')); // Use jogadorPerdeu() em vez de verificarDerrota()
    }

    @Test
    public void testSalvarCarregarEstado() {
        tabuleiro.insereEmbarcacao(new Destroyer('H'), 'A', 0, '1');
        tabuleiro.salvarEstado(arquivoTeste);

        Tabuleiro novoTabuleiro = new Tabuleiro();
        novoTabuleiro.carregarEstado(arquivoTeste);

        // Verificar se os tabuleiros são iguais após o carregamento
        assertArrayEquals("O tabuleiro P1 deve ser igual após o carregamento", tabuleiro.getEstado('1'), novoTabuleiro.getEstado('1'));
        assertArrayEquals("O tabuleiro P2 deve ser igual após o carregamento", tabuleiro.getEstado('2'), novoTabuleiro.getEstado('2'));
    }
}
