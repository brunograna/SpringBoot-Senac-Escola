package br.com.senac.domain;

import javax.persistence.*;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "resposta_id")
    private Resposta resposta;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Resposta getResposta() {
        return resposta;
    }
    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


}