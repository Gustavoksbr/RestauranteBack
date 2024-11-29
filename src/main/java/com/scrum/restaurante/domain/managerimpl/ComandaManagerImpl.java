package com.scrum.restaurante.domain.managerimpl;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import com.scrum.restaurante.domain.ports.manager.ComandaManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComandaManagerImpl implements ComandaManagerPort {

    @Autowired
    private ComandaRepositoryPort comandaRepositoryPort;

    @Autowired
    private ItemComandaRepositoryPort itemComandaRepositoryPort;

    @Autowired
    private ProdutoRepositoryPort produtoRepositoryPort;

    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        comandaRepositoryPort.buscarComandaPorId(idComanda); //serve pra verificar se a comanda existe
        return this.itemComandaRepositoryPort.listarItensDaComanda(idComanda);
    }

    @Override
    public void pagarComanda(Long idComanda) {
        this.comandaRepositoryPort.pagarComanda(idComanda);
    }

    @Override
    public void removerComanda(Long idComanda) {
        this.comandaRepositoryPort.removerComanda(idComanda);
    }

    @Override
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda) {
        Comanda comanda = this.comandaRepositoryPort.buscarComandaPorId(idComanda); //serve pra verificar se a comanda existe
        Produto produto = this.produtoRepositoryPort.buscarProdutoPorNome(itemComanda.getNomeProduto()); //serve pra verificar se o tipo do produto existe
        itemComanda.setIdComanda(comanda.getId());
        itemComanda.setIdProduto(produto.getId());
        this.itemComandaRepositoryPort.adicionarItemComanda(itemComanda);
    }

    @Override
    public List<Comanda> listarComandasPagas() {
        return this.comandaRepositoryPort.listarComandasPagas();
    }

}
