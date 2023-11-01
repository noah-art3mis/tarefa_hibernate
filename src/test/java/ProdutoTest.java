package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import main.IProdutoDAO;
import main.java.Produto;
import main.java.ProdutoDAO;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

  public String chaveAleatoria() {
    return Integer.toString((new Random().nextInt(10000)));
  }

  public Produto criarProdutoTeste() {
    Produto produto = new Produto();
    produto.setCodigo(chaveAleatoria());
    produto.setNome("aksjdhaskdj");
    produto.setDescricao("lorem");
    produto.setValor(10D);
    produto.setFabricante("qoqlqlalalqoqla");
    return produto;
  }

  @Test
  public void readAndCreate_Test() {
    IProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = criarProdutoTeste();
    produtoDAO.create(produto);
    Produto result = produtoDAO.read(produto.getId());
    assertNotNull(result);
  }

  @Test
  public void update_Test() {
    IProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = criarProdutoTeste();
    produtoDAO.create(produto);
    Produto produto2 = criarProdutoTeste();
    produto2.setNome("Novo Nome");
    Produto produto3 = produtoDAO.update(produto2);
    assertEquals("Novo Nome", produto3.getNome());
  }

  @Test
  public void delete_Test() {
    IProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = criarProdutoTeste();
    produtoDAO.create(produto);
    produtoDAO.delete(produto);
    assertNull(produtoDAO.read(produto.getId()));
  }

  @Test
  public void readAll_Test() {
    IProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = criarProdutoTeste();
    produtoDAO.create(produto);
    List<Produto> list = produtoDAO.readAll();
    // assertTrue(list.contains(produtoDAO.read()));
    assertNotEquals(0, list.size());
  }
}
