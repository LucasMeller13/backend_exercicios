package exercicio07.demo.controller;

import exercicio07.demo.DTO.ClienteDTO;
import exercicio07.demo.DTO.TransacaoDTO;
import exercicio07.demo.models.Cliente;
import exercicio07.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/{nome}")
    public ClienteDTO getClienteByName(@PathVariable String nome) {
        Cliente cliente = clienteService.getClienteByName(nome);
        if (cliente != null) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNome(cliente.getNome());
            clienteDTO.setSaldo(cliente.getSaldo());
            return clienteDTO;
        }
        return null;
    }

    @PostMapping("/transacao")
    public TransacaoDTO createTransacao(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        Cliente pagador = clienteService.updateSaldo(transacaoDTO.getPagador(), transacaoDTO.getRecebedor(), transacaoDTO.getQuantidade());
        if (pagador != null) {
            return transacaoDTO;
        }
        return null;
    }
}
