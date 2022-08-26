create table ITEM_PEDIDO (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL,
    descricao VARCHAR(120) NOT NULL,
    pedido_id BIGINT NOT NULL,
    FOREIGN KEY(pedido_id) REFERENCES PEDIDO(id)
);