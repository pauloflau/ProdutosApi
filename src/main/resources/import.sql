-- Inserir Categorias
INSERT INTO tb_categoria (idcategoria, nome) VALUES (1, 'Informatica');
INSERT INTO tb_categoria (idcategoria, nome) VALUES (2, 'Eletronicos');
INSERT INTO tb_categoria (idcategoria, nome) VALUES (3, 'Games');

-- Inserir Fornecedores
INSERT INTO tb_fornecedor (idfornecedor, nome, cnpj) VALUES (1, 'Fornecedor A', '11111111');
INSERT INTO tb_fornecedor (idfornecedor, nome, cnpj) VALUES (2, 'Fornecedor B', '22222222');

-- Inserir Produtos
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (1, 'Notebook', 3 , 1500.00, 1, 1);
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (2, 'Mouse', 9, 50.00, 1, 2);
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (3, 'Teclado', 5,  3500.00, 1, 1);
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (4, 'TV LCD', 2, 100.00, 2, 2);
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (5, 'PACMAN', 1, 100.00, 3, 2);
INSERT INTO tb_produto (idproduto, nome, quantidade, preco, idcategoria, idfornecedor) VALUES (6, 'Ventilador', 4, 100.00, 2, 1);

