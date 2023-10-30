package test.java;

import static org.junit.Assert.assertNotNull;

import main.IProdutoDAO;
import main.java.Produto;
import main.java.ProdutoDAO;
import org.junit.Test;

public class ProdutoTest {

  @Test
  public void Read_Test() {
    Produto produto = new Produto();
    produto.setCodigo("123");
    produto.setNome("aksjdhaskdj");
    produto.setDescricao("lorem");
    produto.setValor(10D);
    produto.setFabricante("qoqlqlalalqoqla");

    IProdutoDAO produtoDAO = new ProdutoDAO();

    produtoDAO.create(produto);
    Produto result = produtoDAO.read(produto.getId())
    assertNotNull(result);
  }
}
