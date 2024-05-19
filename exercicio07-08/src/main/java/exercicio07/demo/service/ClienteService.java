package exercicio07.demo.service;

import exercicio07.demo.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private final Map<String, Cliente> clientes = new HashMap<>();

    public ClienteService() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("lucas");
        cliente1.setSaldo(1000.0);
        cliente1.setSenha("lucas123");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("joao");
        cliente2.setSaldo(1500.0);
        cliente2.setSenha("joao123");

        clientes.put(cliente1.getNome(), cliente1);
        clientes.put(cliente2.getNome(), cliente2);
    }

    public Cliente getClienteByName(String nome) {
        return clientes.get(nome);
    }

    public Cliente updateSaldo(String pagador, String recebedor, Double quantidade) {
        Cliente clientePagador = clientes.get(pagador);
        Cliente clienteRecebedor = clientes.get(recebedor);

        if (clientePagador != null && clienteRecebedor != null) {
            clientePagador.setSaldo(clientePagador.getSaldo() - quantidade);
            clienteRecebedor.setSaldo(clienteRecebedor.getSaldo() + quantidade);
        }
        return clientePagador;
    }
}
