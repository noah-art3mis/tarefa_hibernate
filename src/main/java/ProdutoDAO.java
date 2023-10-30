package main.java;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import main.IProdutoDAO;

public class ProdutoDAO implements IProdutoDAO {

  @Override
  public Produto read(Long id) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
      "ExemploJPA"
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Produto produto = em.find(Produto.class, id);
    em.getTransaction().commit();

    em.close();
    emf.close();
    return produto;
  }

  @Override
  public void create(Produto produto) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
      "ExemploJPA"
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(produto);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }

  @Override
  public Produto update(Produto produto) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
      "ExemploJPA"
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    produto = em.merge(produto);
    em.getTransaction().commit();

    em.close();
    emf.close();
    return produto;
  }

  @Override
  public void delete(Produto produto) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
      "ExemploJPA"
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    produto = em.merge(produto);
    em.remove(produto);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }

  @Override
  public List<Produto> readAll() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
      "ExemploJPA"
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    List<Produto> list = em
      .createQuery("SELECT p FROM Produto p", Produto.class)
      .getResultList();
    em.getTransaction().commit();

    em.close();
    emf.close();
    return list;
  }
}
