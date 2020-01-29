package entidade;

import java.util.ArrayList;
import java.util.List;

import constantes.StatusAluno;

public class Aluno {

	private String nome;
	private Integer idade;
	private String email;
	private String registroGeral;
	private String numeroCpf;

	private List<Disciplina> disciplinas = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/* Método que retorna a média do aluno */
	public double getMediaNota() {
		Double total = 0.0;
		for (Disciplina disciplina : disciplinas) {
			total += disciplina.getNota();
		}

		return total / disciplinas.size();
	}

	public String getResultadoAluno() {
		double media = this.getMediaNota();
		if (media >= 50) {
			if (media >= 70) {
				return StatusAluno.APR;
			} else {
				return StatusAluno.REC;
			}
		} else {
			return StatusAluno.REP;
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", email=" + email + ", registroGeral=" + registroGeral
				+ ", numeroCpf=" + numeroCpf + ", disciplinas=" + disciplinas + "]";
	}

}
