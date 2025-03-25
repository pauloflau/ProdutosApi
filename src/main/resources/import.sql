

-- Inserir Categorias
INSERT INTO tb_categoria ( nome) VALUES ( 'Informatica');
INSERT INTO tb_categoria ( nome) VALUES ( 'Eletronicos');
INSERT INTO tb_categoria ( nome) VALUES ( 'Games');

-- Inserir Fornecedores
INSERT INTO tb_fornecedor ( nome, cnpj) VALUES ( 'Fornecedor A', '11111111');
INSERT INTO tb_fornecedor ( nome, cnpj) VALUES ( 'Fornecedor B', '22222222');

-- Inserir Produtos
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'Notebook', 3 , 1500.00, 1, 1);
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'Mouse', 9, 50.00, 1, 2);
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'Teclado', 5,  3500.00, 1, 1);
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'TV LCD', 2, 100.00, 2, 2);
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'PACMAN', 1, 100.00, 3, 2);
INSERT INTO tb_produto ( nome, quantidade, preco, idcategoria, idfornecedor) VALUES ( 'Ventilador', 4, 100.00, 2, 1);

