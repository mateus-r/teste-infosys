package br.com.teste.infosys.entrypoint;

import br.com.teste.infosys.core.messaging.TesteMessageProducer;
import br.com.teste.infosys.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class InfosysApi {

    @Autowired
    TesteMessageProducer pessoaMessageProducer;

    @PostMapping
    public ResponseEntity<String> gravar(@RequestBody Pessoa pessoa) {

    }
}
