package br.com.desafio.totalshake.application.errors.exceptions;

public class QuantidadeInvalidaException extends RuntimeException {

    private final String codInternoErro;
    private final String mensagem;

    public QuantidadeInvalidaException(String codInternoErro, String mensagem){
        this.codInternoErro = codInternoErro;
        this.mensagem = mensagem;
    }

    public String getCodInternoErro() {
        return codInternoErro;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
