package main;

import java.util.List;
import main.java.Produto;

public interface IProdutoDAO {
  public void create(Produto produto);

  public Produto read(Long id);

  public Produto update(Produto produto);

  public void delete(Produto produto);

  public List<Produto> readAll();
}
