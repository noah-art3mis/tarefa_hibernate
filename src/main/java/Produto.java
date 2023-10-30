package main.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
  @SequenceGenerator(
    name = "produto_seq",
    sequenceName = "sq_produto",
    initialValue = 1,
    allocationSize = 1
  )
  private Long id;

  @Column(name = "codigo")
  private String codigo;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descricao")
  private String descricao;

  @Column(name = "valor")
  private Double valor;

  @Column(name = "fabricante")
  private String fabricante;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(String fabricante) {
    this.fabricante = fabricante;
  }
}
