DROP TABLE IF EXISTS tb_produto;
DROP TABLE IF EXISTS tb_categoria;
DROP TABLE IF EXISTS tb_fornecedor;

-- Criar a tabela categoria (exemplo)
CREATE TABLE tb_categoria (
    idcategoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criar a tabela fornecedor (exemplo)
CREATE TABLE tb_fornecedor (
    idfornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Agora, criar a tabela tb_produto
CREATE TABLE tb_produto (
    idproduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    idcategoria INT NOT NULL,
    idfornecedor INT NOT NULL,
    FOREIGN KEY (idcategoria) REFERENCES tb_categoria(idcategoria),
    FOREIGN KEY (idfornecedor) REFERENCES tb_fornecedor(idfornecedor)
);