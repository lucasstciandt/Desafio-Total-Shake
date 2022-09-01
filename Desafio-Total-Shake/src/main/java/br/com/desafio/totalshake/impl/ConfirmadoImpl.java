package br.com.desafio.totalshake.impl;

import br.com.desafio.totalshake.application.errors.exceptions.StatusInvalidoException;
import br.com.desafio.totalshake.domain.model.Pedido;
import br.com.desafio.totalshake.domain.model.Status;
import br.com.desafio.totalshake.domain.service.EstadoPedido;

public class ConfirmadoImpl implements EstadoPedido {

    private final Pedido pedido;
    private final Status confirmado = Status.CONFIRMADO;

    public ConfirmadoImpl(Pedido pedido) {
        this.pedido = pedido;
        this.pedido.setStatus(confirmado);
    }

    @Override
    public void pedidoPronto() {
        this.pedido.setEstadoPedido(new ProntoImpl(this.pedido));
    }

    @Override
    public void realizarPedido() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }

    @Override
    public void pagarPedido() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }

    @Override
    public void confirmarPedido() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }

    @Override
    public void cancelarPedido() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }


    @Override
    public void pedidoSaiuParaEntrega() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }

    @Override
    public void pedidoEntregue() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }

    @Override
    public void naoAutorizarPedido() {
        throw new StatusInvalidoException("Operação inválida, o pedido está em status de: " + confirmado);
    }
}
