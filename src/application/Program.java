package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import constantes.StatusAluno;
import entidade.Aluno;
import entidade.Disciplina;

public class Program {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");

		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {

			List<Aluno> alunos = new ArrayList<>();
			/*
			 * List<Aluno> alunosAprovados = new ArrayList<>(); List<Aluno> alunosReprovados
			 * = new ArrayList<>(); List<Aluno> alunosRecupera��o = new ArrayList<>();
			 */

			HashMap<String, List<Aluno>> maps = new HashMap<>();

			Integer qtAluno = Integer.valueOf(JOptionPane.showInputDialog("Quantos alunos deseja inserir?"));

			for (int n = 1; n <= qtAluno; n++) {

				String nome = JOptionPane.showInputDialog("Nome do Aluno " + n);
				/*
				 * String idade = JOptionPane.showInputDialog("Idade do Aluno " + n); String
				 * email = JOptionPane.showInputDialog("Informe o e-mail do aluno " + n); String
				 * rg = JOptionPane.showInputDialog("RG do aluno " + n); String cpf =
				 * JOptionPane.showInputDialog("CPF do aluno " + n);
				 */

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);
				/*
				 * aluno1.setIdade(Integer.valueOf(idade)); aluno1.setEmail(email);
				 * aluno1.setRegistroGeral(rg); aluno1.setNumeroCpf(cpf);
				 */

				Integer qtdisc = Integer
						.valueOf(JOptionPane.showInputDialog("Quantas disciplinas deseja incluir as notas?"));

				for (int i = 1; i <= qtdisc; i++) {
					String disc = JOptionPane.showInputDialog("Nome da disciplina " + i);
					String nota = JOptionPane.showInputDialog("Nota da disciplina " + i);

					Disciplina disciplina = new Disciplina();
					disciplina.setNomeDisciplina(disc);
					disciplina.setNota(Double.valueOf(nota));

					aluno1.getDisciplinas().add(disciplina);
				}

				Integer escolha = JOptionPane.showConfirmDialog(null, "Deseja excluir alguma disciplina?");

				if (escolha == 0) {
					String removerDisc = JOptionPane.showInputDialog("Qual o n�mero da disciplina que deseja excluir?");
					aluno1.getDisciplinas().remove(Integer.valueOf(removerDisc).intValue() - 1);
				}

				alunos.add(aluno1);
			}

			Integer escolha = JOptionPane.showConfirmDialog(null, "Deseja visualizar algum aluno espec�fico?");

			if (escolha == 0) {

				String busca = JOptionPane.showInputDialog("Qual aluno deseja ver o resultado?");

				for (Aluno aluno : alunos) {

					if (aluno.getNome().equalsIgnoreCase(busca)) {
						System.out.println(aluno);
						System.out.println("M�dia do Aluno: " + String.format("%.2f", aluno.getMediaNota()));
						System.out.println("Resultado final: " + aluno.getResultadoAluno());
						System.out.println(
								"============================================================================================");

						for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
							Disciplina disc = aluno.getDisciplinas().get(posd);
							System.out.println("Disciplina: " + disc.getNomeDisciplina() + " = " + disc.getNota());

						}
						break;
					}
				}
			} else {

				Integer opt = JOptionPane.showConfirmDialog(null, "Deseja substituir algum aluno?");

				if (opt == 0) {
					String busca = JOptionPane.showInputDialog("Qual o nome do aluno que deseja substituir?");

					for (int pos = 0; pos < alunos.size(); pos++) {

						Aluno aluno = alunos.get(pos);

						if (aluno.getNome().equalsIgnoreCase(busca)) {

							Aluno novoAluno = new Aluno();
							String novoNome = JOptionPane.showInputDialog("Qual o nome do novo aluno?");
							novoAluno.setNome(novoNome);

							Integer qtdisc = Integer.valueOf(
									JOptionPane.showInputDialog("Quantas disciplinas deseja incluir para esse aluno?"));

							for (int i = 1; i <= qtdisc; i++) {
								String disc = JOptionPane.showInputDialog("Nome da disciplina " + i);
								String nota = JOptionPane.showInputDialog("Nota da disciplina " + i);

								Disciplina disciplina = new Disciplina();
								disciplina.setNomeDisciplina(disc);
								disciplina.setNota(Double.valueOf(nota));

								novoAluno.getDisciplinas().add(disciplina);
							}

							alunos.set(pos, novoAluno);
							aluno = alunos.get(pos);
						}

						System.out.println("Aluno: " + aluno.getNome());
						System.out.println("M�dia do aluno: " + String.format("%.2f", aluno.getMediaNota()));
						System.out.println("Resultado do aluno: " + aluno.getResultadoAluno());
						System.out.println("-------*-------");

						for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
							Disciplina disc = aluno.getDisciplinas().get(posd);
							System.out.println("Disciplina: " + disc.getNomeDisciplina() + " = " + disc.getNota());

						}

						System.out.println(
								"=============================================================================================");

					}
				} else {

					for (int pos = 0; pos < alunos.size(); pos++) {

						Aluno aluno = alunos.get(pos);

						System.out.println("Aluno: " + aluno.getNome());
						System.out.println("M�dia do aluno: " + String.format("%.2f", aluno.getMediaNota()));
						System.out.println("Resultado do aluno: " + aluno.getResultadoAluno());
						System.out.println("-------*-------");

						for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
							Disciplina disc = aluno.getDisciplinas().get(posd);
							System.out.println("Disciplina: " + disc.getNomeDisciplina() + " = " + disc.getNota());

						}

						System.out.println(
								"=============================================================================================");

					}
				}

			}

			maps.put(StatusAluno.APR, new ArrayList<Aluno>());
			maps.put(StatusAluno.REC, new ArrayList<Aluno>());
			maps.put(StatusAluno.REP, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {

				if (aluno.getResultadoAluno().equalsIgnoreCase(StatusAluno.APR)) {
					maps.get(StatusAluno.APR).add(aluno);
				} else if (aluno.getResultadoAluno().equalsIgnoreCase(StatusAluno.REC)) {
					maps.get(StatusAluno.REC).add(aluno);
				} else {
					maps.get(StatusAluno.REP).add(aluno);
				}
			}

			System.out.println("------------------- Lista de Aprovados -------------------");
			for (Aluno aluno : maps.get(StatusAluno.APR)) {
				System.out.println();
				System.out.println(
						"Aluno: " + aluno.getNome() + " / M�dia final: " + String.format("%.2f", aluno.getMediaNota()));
			}

			System.out.println("------------------- Lista de Recupera��o -------------------");
			for (Aluno aluno : maps.get(StatusAluno.REC)) {
				System.out.println();
				System.out.println(
						"Aluno: " + aluno.getNome() + " / M�dia final: " + String.format("%.2f", aluno.getMediaNota()));
			}

			System.out.println("------------------- Lista de Reprovados -------------------");
			for (Aluno aluno : maps.get(StatusAluno.REP)) {
				System.out.println();
				System.out.println(
						"Aluno: " + aluno.getNome() + " / M�dia final: " + String.format("%.2f", aluno.getMediaNota()));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou senha incorretos. Acesso proibido");
		}
	}
}
