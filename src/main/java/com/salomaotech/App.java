package com.salomaotech;

import com.salomaotech.model.cliente.Cliente;
import com.salomaotech.model.compras.Carrinho;
import com.salomaotech.model.compras.Produto;
import com.salomaotech.model.fatura.Fatura;
import com.salomaotech.repository.JpaUtil;
import com.salomaotech.repository.cliente.ClienteRepository;
import com.salomaotech.repository.compras.CarrinhoRepository;
import com.salomaotech.repository.compras.ProdutoRepository;
import com.salomaotech.repository.fatura.FaturaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author www.taimber.com
 */
public class App {

    public static void save() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);
        FaturaRepository faturaRepository = new FaturaRepository(jpaUtil);

        Cliente cliente = new Cliente();
        cliente.setNome("Salomão Silva");
        cliente.setTelefone("62 0000-0000");
        cliente.setEmail("salomao@email.com");

        Fatura fatura = new Fatura();
        fatura.setIsPago(false);
        fatura.setValor(new BigDecimal(1500));
        fatura.setDataVencimento(LocalDate.now());
        fatura.setCliente(cliente);

        clienteRepository.save(cliente);
        faturaRepository.save(fatura);

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

    private static void cadastraCompra() {

        JpaUtil jpaUtil = new JpaUtil();
        ClienteRepository clienteRepository = new ClienteRepository(jpaUtil);
        ProdutoRepository produtoRepository = new ProdutoRepository(jpaUtil);
        CarrinhoRepository carrinhoRepository = new CarrinhoRepository(jpaUtil);

        Cliente cliente = new Cliente();
        cliente.setNome("Salomão Silva");
        cliente.setTelefone("62 0000-0000");
        cliente.setEmail("salomao@email.com");

        Produto produto = new Produto();
        produto.setNome("Mouse HP");
        produto.setPreco(new BigDecimal(100));

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);
        carrinho.getProdutos().add(produto);

        clienteRepository.save(cliente);
        produtoRepository.save(produto);
        carrinhoRepository.save(carrinho);

        jpaUtil.close();

    }

    public static void main(String[] args) {

        cadastraCompra();

    }

}
