package br.com.senac.service;

import br.com.senac.domain.Resposta;
import br.com.senac.repository.RespostaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    RespostaRepository respostaRepository;

    public List<Resposta> buscarTodosRespostas(){
        return respostaRepository.findAll();
    }

    public Resposta salvar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public Resposta buscaPorId(Integer id) throws ObjectNotFoundException {
        Optional<Resposta> resposta = respostaRepository.findById(id);
        return resposta.orElseThrow(() -> new ObjectNotFoundException("Resposta não encontrado, id "+id));
    }

    public Resposta salvarAlteracao(Resposta respostaAlterado) throws ObjectNotFoundException {
        Resposta resposta = buscaPorId(respostaAlterado.getId());
        resposta.setId(respostaAlterado.getId());
        resposta.setRespostaTexto(respostaAlterado.getRespostaTexto());
        return salvar(resposta);
    }

    public void excluir(Integer id) {
        respostaRepository.deleteById(id);
    }

}