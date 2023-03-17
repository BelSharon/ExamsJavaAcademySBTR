package com.curso.sbatch.config;

import org.springframework.batch.item.ItemProcessor;

import com.curso.sbatch.entity.Cliente;

public class ClienteProcessor implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        if(cliente.getPais().equals("China")) {
            return cliente;
        }//estamos filtrando el cliente por país (China)
        return null;
        
    }
}
