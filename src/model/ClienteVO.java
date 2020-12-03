package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteVO implements Serializable {
//	private Integer id;
	private String nome;
	private String endereco;
	private Integer id;
	private Date data;
	private String nomeProduto;
	private Integer quantidade;
	private BigDecimal valorTotal;
	
	private List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
	 
	public ClienteVO() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer idCliente) {		
		this.id = idCliente;
		// this.idStr = this.id+"";
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<PedidoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoVO> pedidos) {
		this.pedidos = pedidos;
	}
	 
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	 
	@Override
	public String toString() {
		return "ClienteVO [id=" + id  + " ,"
				+ " nome=" + nome + ", endereco=" + endereco + ", pedidos=" + pedidos + "]";
	}	

}
