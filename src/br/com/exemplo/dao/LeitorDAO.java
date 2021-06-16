package br.com.exemplo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Leitor;
import br.com.exemplo.util.ConnectionFactory;



public class LeitorDAO {	//CRUD
	//Atributos
	private Leitor leitor;
	private Connection conn; // COnecta com o banco de dados
	private PreparedStatement ps; //executa querys
	private ResultSet rs; //cria uma tabela

	

	public LeitorDAO() throws Exception{

		try {
			conn = ConnectionFactory.getConnection();
		}catch (Exception e) {
			throw new Exception("Erro"+e.getMessage());
		}

	}

	
//METODO SALVAR
	public void salvar(Leitor leitor) throws Exception{
		try {
			String sql="INSERT INTO tbleitor(codLeitor,nomeLeitor,tipoLeitor)"+" values(?,?,?)";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,leitor.getCodLeitor());
			ps.setString(2,leitor.getNomeLeitor());
			ps.setString(3,leitor.getTipoLeitor());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao salvar"+e.getMessage());
		}
	}

	
	//METODO LISTAR
	public List listarTodos() throws Exception{
		List<Leitor> lista = new ArrayList<Leitor>();
		try {
			ps = conn.prepareStatement("SELECT * FROM tbleitor");
			rs = ps.executeQuery();
			
			while(rs.next()) {

				int codLeitor = rs.getInt("codLeitor");
				String nomeLeitor = rs.getString("nomeLeitor");
				String tipoLeitor = rs.getString("tipoLeitor");
				leitor = new Leitor(codLeitor,nomeLeitor,tipoLeitor);
				lista.add(leitor);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception("erro ao listar"+e.getMessage());
		}

	}

	//METODO ALTERAR
	public void alterar(Leitor leitor) throws Exception{
		try {
			String sql="UPDATE tbleitor SET nomeLeitor=?,tipoLeitor=? "+" WHERE codLeitor=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1,leitor.getNomeLeitor());
			ps.setString(2,leitor.getTipoLeitor());
			ps.setInt(3,leitor.getCodLeitor());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao alterar"+e.getMessage());
		}
	}

	
//METODO EXCLUIR
	public void Excluir(int codLeitor) throws Exception{
		try {
			String sql="DELETE FROM tbleitor "+" WHERE codLeitor=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, codLeitor);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao excluir"+e.getMessage());
		}
	}

	
//METODO CONSULTAR
	public Leitor consultar(int codLeitor) throws Exception{
		try {
			ps = conn.prepareStatement("SELECT * FROM tbleitor WHERE codLeitor=?");
			ps.setInt(1,codLeitor);
			rs = ps.executeQuery();
			if(rs.next()) {
						String nomeLeitor = rs.getString("nomeLeitor");
						String tipoLeitor = rs.getString("tipoLeitor");
						leitor = new Leitor(codLeitor,nomeLeitor,tipoLeitor);
				}
			return leitor;
		}catch (Exception e) {
			throw new Exception("Erro ao listar"+e.getMessage());
		}

	}

	



}




