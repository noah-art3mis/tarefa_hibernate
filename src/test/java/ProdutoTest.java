package test.java;

import static org.junit.Assert.assertNotNull;

import main.IProdutoDAO;
import main.java.Produto;
import main.java.ProdutoDAO;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

  public Produto criarProdutoTeste() {
    Produto produto = new Produto();
    produto.setCodigo("123");
    produto.setNome("aksjdhaskdj");
    produto.setDescricao("lorem");
    produto.setValor(10D);
    produto.setFabricante("qoqlqlalalqoqla");
    return produto;
  }

  @Test
  public void Read_Test() {
    IProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = criarProdutoTeste();
    produtoDAO.create(produto);
    Produto result = produtoDAO.read(produto.getId());
    assertNotNull(result);
  }
}
