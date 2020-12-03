package controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.ClienteDAO;
import entidades.Cliente;
import model.ClienteVO;
import model.PedidoVO;
import utilitarios.FabricaConexao;

@Named 
@RequestScoped
public class ClienteMB implements Serializable {
	private ClienteVO cliente = new ClienteVO();	
	private PedidoVO pedido = new PedidoVO();
	
	private List<Cliente> clientes;
	
	static ClienteDAO dao = new ClienteDAO();
//	static PedidoDAO dao2 = new PedidoDAO();
	
	public ClienteMB() {}
	
	
	public String salvar(String id) {
        // se o "id" do objeto "clienteVO" está NULL significa um "novo cliente"
		if (this.cliente.getId()==null) {
			cadastrar();
		} else
			atualizarCliente();
		return "";
	}
	public String novoCliente() {
		this.cliente = new ClienteVO();
		FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_INFO, 
	                		"Informe os dados do novo cliente", ""));	       
		return "";	
	}
	
    // método privado para incluir um novo cliente na base dados.
	private void cadastrarNovoCliente() {
		boolean incluiu = dao.incluir(cliente);
		if (incluiu)
		   FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cliente <"+cliente.getNome() + "> "
					+ " cadastrado com ID="+cliente.getId(), null));
		else
		   FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na Operação!", null));
		// limpa o "VO" para incluir um novo
		this.cliente = new ClienteVO();			
	}
	
	
	private void atualizarCliente() {		
		boolean ok = dao.atualiza(this.cliente);
		if (ok)
		   FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Cliente <" + this.cliente.getNome()
						+ "> atualizado com sucesso!", null));
		else
		   FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Erro na Operação!", null));
		// limpa o "VO" para incluir um novo
		this.cliente = new ClienteVO();					
	}
	
	
	public void delete(String id) {
		int idPK = Integer.parseInt(id);	
		Cliente cli = dao.findById(idPK);
		dao.delete(idPK);       
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Cliente <" + cli.getNome()
						+ "> Excluído com sucesso!", null));
    }
	
	public void update() {
/*	int idPK = Integer.parseInt(id);		 
	    Cliente cli = dao.findById(idPK);
	    this.cliente.setEndereco(cli.getEndereco());
	    this.cliente.setId(cli.getId());
	    this.cliente.setNome(cli.getNome());
	    return "";   */
		boolean ok = dao.atualiza(this.cliente);
		if (ok)
		   FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Cliente <" + this.cliente.getNome()
						+ "> atualizado com sucesso!", null));
		else
		   FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Erro na Operação!", null));
		// limpa o "VO" para incluir um novo
		this.cliente = new ClienteVO();
		
	}
	
	
	
	
	
	
	
 	
	public String cadastrar() {
		System.out.println("vo = " + cliente.toString() );
		boolean incluiu = dao.incluir(cliente);
		if (incluiu)
		   FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com ID="+cliente.getId(), null));
		else
		   FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na Operação!", null));
		// limpa o "VO" para incluir um novo
		this.cliente = new ClienteVO();
		return "";
	}
	
	
	
	// getters e setters
	public ClienteVO getCliente() {
		return this.cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		this.clientes = dao.getClientes();
		return this.clientes;
	}
	
/*	public List<Produto> getProdutos() {
		this.produtos = dao.getProdutos();
		return this.produtos;
	}
*/
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	private void atualizaPed() {		
		boolean ok = dao.atualizaPedido(this.cliente);
		if (ok)
		   FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Cliente <" + this.cliente.getNome()
						+ "> atualizado com sucesso!", null));
		else
		   FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Erro na Operação!", null));
		// limpa o "VO" para incluir um novo
		this.cliente = new ClienteVO();					
	}
		
}
