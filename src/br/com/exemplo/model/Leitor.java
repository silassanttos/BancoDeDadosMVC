package br.com.exemplo.model;

public class Leitor {
	//Atributos
	private int codLeitor;
	private String nomeLeitor;
	private String tipoLeitor;
	
	public Leitor(){
		//contrutor padrao
	}

	public Leitor(int codLeitor, String nomeLeitor, String tipoLeitor) {
		super();
		this.codLeitor = codLeitor;
		this.nomeLeitor = nomeLeitor;
		this.tipoLeitor = tipoLeitor;
	}

		//getters e setters
	public int getCodLeitor() {
		return codLeitor;
	}

	public void setCodLeitor(int codLeitor) {
		this.codLeitor = codLeitor;
	}

	public String getNomeLeitor() {
		return nomeLeitor;
	}

	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}

	public String getTipoLeitor() {
		return tipoLeitor;
	}

	public void setTipoLeitor(String tipoLeitor) {
		this.tipoLeitor = tipoLeitor;
	}
	
	

}






