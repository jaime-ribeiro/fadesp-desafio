create table pagamentos(
    id bigint NOT NULL AUTO_INCREMENT,
    codigoDebito VARCHAR(255),
    cpfCnpj VARCHAR(255) NOT NULL UNIQUE,
    metodoPagamento VARCHAR(255) NOT NULL,
    numeroCartao VARCHAR(255),
    valorPagamento VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
)