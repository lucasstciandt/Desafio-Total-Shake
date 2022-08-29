package br.com.desafio.totalshake.domain.service;

import br.com.desafio.totalshake.application.controller.request.PedidoDTOPost;
import br.com.desafio.totalshake.application.controller.response.PedidoDTOResponse;
import br.com.desafio.totalshake.domain.model.Pedido;
import br.com.desafio.totalshake.domain.model.Status;
import br.com.desafio.totalshake.domain.repository.PedidoRepository;
import br.com.desafio.totalshake.application.exception.PedidoInexistenteException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PedidoCrudService {

    private final PedidoRepository pedidoRepository;

    public PedidoCrudService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public PedidoDTOResponse salvarPedido(PedidoDTOPost pedidoDTOPost) {

        var pedido = pedidoDTOPost.toPedidoModel();

        pedido.setStatus(Status.REALIZADO);
        pedido.setDataHora(LocalDateTime.now());
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTOResponse(pedido);
    }

    @Transactional
    public PedidoDTOResponse acrescentarItem(Long pedidoId, Long itemId, int quantidade){
        var pedido = this.buscarPedidoPorId(pedidoId);
        pedido.acrescentarItemDoPedido(itemId, quantidade);
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTOResponse(pedido);
    }

    @Transactional
    public PedidoDTOResponse reduzirQuantidadeItem(Long pedidoId, Long itemId, int quantidade) {
        var pedido = this.buscarPedidoPorId(pedidoId);
        pedido.reduzirItemDoPedido(itemId, quantidade);
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTOResponse(pedido);
    }

    @Transactional
    public PedidoDTOResponse cancelarPedido(Long idPedido) {
        var pedido = this.buscarPedidoPorId(idPedido);
        pedido.setStatus(Status.CANCELADO);
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTOResponse(pedido);
    }

    @Transactional
    public Pedido buscarPedidoPorId(long idPedido) {
        return pedidoRepository
                .findById(idPedido)
                .orElseThrow(() -> new PedidoInexistenteException("Pedido inexistente"));
    }
}