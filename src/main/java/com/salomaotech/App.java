package com.salomaotech;

import com.salomaotech.model.cliente.Cliente;
import com.salomaotech.repository.JpaUtil;
import com.salomaotech.repository.cliente.ClienteRepository;
import java.util.List;

/**
 *
 * @author www.taimber.com
 */
public class App {

    public static void save() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);

        Cliente cliente = new Cliente();
        cliente.setNome("Salomão Silva");
        cliente.setTelefone("62 0000-0000");
        cliente.setEmail("salomao@email.com");

        clienteRepository.save(cliente);
        jpaUtil.close();

    }

    public static void update() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Salomão Silva");
        cliente.setTelefone("62 1111-1111");
        cliente.setEmail("salomao@email.com");

        clienteRepository.update(cliente);
        jpaUtil.close();

    }

    public static void delete() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);

        clienteRepository.delete(1L, Cliente.class);
        jpaUtil.close();

    }

    public static void findById() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);

        Cliente cliente = (Cliente) clienteRepository.findById(1L, Cliente.class);
        System.out.println(cliente.getNome());
        System.out.println(cliente.getTelefone());
        System.out.println(cliente.getEmail());

        jpaUtil.close();

    }

    public static void findAll() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);

        List<Cliente> clientes = clienteRepository.findAll(Cliente.class);

        for (Cliente c : clientes) {

            System.out.println(c.getNome());
            System.out.println(c.getTelefone());
            System.out.println(c.getEmail());

        }

        jpaUtil.close();

    }

    public static void main(String[] args) {

        save();

    }

}
