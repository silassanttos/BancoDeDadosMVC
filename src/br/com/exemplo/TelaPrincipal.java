package br.com.exemplo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.LeitorDAO;
import br.com.exemplo.model.Leitor;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNomeLeitor;
	private JLabel lblTipoLeitor;
	private JLabel lblMensagem;
	private JTextField txtCodLeitor;
	private JTextField txtNomeLeitor;
	private JComboBox cmbTipoLeitor;
	private TextArea txtListar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnListar;
	private Leitor leitor;
	private LeitorDAO dao;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Manuten\u00E7\u00E3o Leitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("C\u00F3digo do Leitor");
		lblNewLabel.setBounds(5, 5, 145, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		txtCodLeitor = new JTextField();
		txtCodLeitor.setBounds(155, 5, 285, 22);
		contentPane.add(txtCodLeitor);
		txtCodLeitor.setColumns(10);
		
		lblNomeLeitor = new JLabel("Nome Leitor");
		lblNomeLeitor.setBounds(5, 30, 108, 22);
		lblNomeLeitor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblNomeLeitor);
		
		txtNomeLeitor = new JTextField();
		txtNomeLeitor.setBounds(155, 32, 710, 22);
		txtNomeLeitor.setColumns(10);
		contentPane.add(txtNomeLeitor);
		
		lblTipoLeitor = new JLabel("Tipo de Leitor");
		lblTipoLeitor.setBounds(5, 59, 121, 22);
		lblTipoLeitor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblTipoLeitor);
		
		cmbTipoLeitor = new JComboBox();
		cmbTipoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbTipoLeitor.setBounds(155, 59, 710, 22);
		cmbTipoLeitor.setModel(new DefaultComboBoxModel(new String[] 
				{"Selecione uma op\u00E7\u00E3o", "Aluno", "Professor", "Administrativo"}));
		contentPane.add(cmbTipoLeitor);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(603, 108, 125, 38);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTÃO CONSULTAR  
				try {
					dao = new LeitorDAO();
					int cod = Integer.parseInt(txtCodLeitor.getText());
					leitor = dao.consultar(cod);
					txtNomeLeitor.setText(leitor.getNomeLeitor());
					
					String tip =  leitor.getTipoLeitor();
					
					if(tip.equals("Aluno")) {
						cmbTipoLeitor.setSelectedIndex(1);
					}
					else if(tip.equals("Professor")) {
						cmbTipoLeitor.setSelectedIndex(2);
					}
					else{
						cmbTipoLeitor.setSelectedIndex(3);
					}
					
				}catch(Exception e1) {
					lblMensagem.setText("Erro ao consultar");
					}
				}
		
		});
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(205, 407, 121, 38);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Botão NOVO onde ira realizar a limpeza da tela!
				txtCodLeitor.setText(null);
				txtNomeLeitor.setText(null);
				lblMensagem.setText(null);
				txtListar.setText(" ");
				cmbTipoLeitor.setSelectedIndex(0);
				//Fim do codigo para realizar a limpeza da tela!
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNovo);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnConsultar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(336, 407, 124, 38);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BOTÃO SALVAR
				try {
				leitor = new Leitor();
				leitor.setCodLeitor(Integer.parseInt(txtCodLeitor.getText()));
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setTipoLeitor((String) cmbTipoLeitor.getSelectedItem());
				//Abrir conexão
				dao = new LeitorDAO();
				dao.salvar(leitor);
				lblMensagem.setText("Salvo com Sucesso!");
				}catch(Exception e) {
					lblMensagem.setText("Erro ao Salvar!");
				}
			}		//FIM DO CÓDIOGO SALVAR
		});
		
				btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPane.add(btnSalvar);
		
		btnAlterar = new JButton("Atualizar");
		btnAlterar.setBounds(470, 407, 124, 38);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BOTÃO ALTERAR
				try {
				leitor = new Leitor();
				leitor.setCodLeitor(Integer.parseInt(txtCodLeitor.getText()));
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setTipoLeitor((String) cmbTipoLeitor.getSelectedItem());
				//Abrir conexão
				dao = new LeitorDAO();
				//Alterar
				dao.alterar(leitor);
				lblMensagem.setText("Alterado com Sucesso!");
				}catch(Exception e) {
					lblMensagem.setText("Erro ao Alterar!");
				}
			}		//FIM DO CÓDIOGO ALTERAR
			
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAlterar);
		
		btnListar = new JButton("Exibir Dados");
		btnListar.setBounds(738, 108, 129, 38);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				List<Leitor> lista = new ArrayList<Leitor>();
				dao = new LeitorDAO();
				lista = dao.listarTodos();
				for(Leitor leitor :  lista) {
					txtListar.append("Código do Leitor: " +leitor.getCodLeitor()+"\n");
					txtListar.append("Nome do Leitor:   " +leitor.getNomeLeitor()+"\n");
					txtListar.append("Tipo do Leitor:   " +leitor.getTipoLeitor()+"\n\n");
				}
			}catch(Exception e1) {
				lblMensagem.setText("Erro ao Listar ");
				}
			}
	
		});
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(604, 407, 124, 38);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BOTÃO EXCLUIR
				try {
				//Abrir conexão
				dao = new LeitorDAO();
				//Alterar
				int cod = Integer.parseInt(txtCodLeitor.getText());
				dao.Excluir(cod);
				lblMensagem.setText("Excluido com Sucesso!");
				}catch(Exception e) {
					lblMensagem.setText("Erro ao Excluir!");
				}
			}		//FIM DO CÓDIOGO EXCLUIR
	
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnExcluir);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnListar);
		
		txtListar = new TextArea();
		txtListar.setBounds(5, 152, 860, 247);
		contentPane.add(txtListar);
		
		lblMensagem = new JLabel("");
		lblMensagem.setForeground(new Color(0, 0, 0));
		lblMensagem.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 21));
		lblMensagem.setBounds(5, 108, 588, 38);
		lblMensagem.setBorder(new BevelBorder
				(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, Color.RED, new Color(64, 64, 64)));
		contentPane.add(lblMensagem);
		
		table = new JTable();
		table.setBounds(47, 326, 259, -82);
		contentPane.add(table);
		
		JList list = new JList();
		list.setBounds(59, 254, 26, -23);
		contentPane.add(list);
	}
}