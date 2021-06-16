
# BancoDeDadosMVC

![Captura de tela 2021-06-15 221109](https://user-images.githubusercontent.com/69328711/122142946-c5f24480-ce26-11eb-93a8-014e8681fe1f.png)



 
1 – Criação do baco de dados, nome: CREATE DATABASE dbLeitor;
2. Criação da tabela com o nome tbLeitor usando a sintaxe em SQL seguinte:
	CREATE TABLE tbLeitor( 
codLeitor INT(4), 
nomeLeitor VARCHAR(40),
 tipoLeitor VARCHAR(20),
PRIMARY KEY (codLeitor)
);
Ao ser criada, a tabela terá a estrutura apresentada abaixo:
Nome do campo	Tipo de dados	Tamanho
CodLeitor	INT	4
NomeLeitor	VARCHAR	40
TipoLeitor	VARCHAR	20

Com os procedimentos anteriores foi criado o banco de dados com uma tabela vazia em MYSQL. Esse será o banco de dados manipulado pela aplicação Java descrita no item 1.2.
