package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasSet.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaARemover = null;
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t: tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaARemover = t;
                    break;
                }
            }
            tarefasSet.remove(tarefaARemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if(tarefaARemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    public int contarTarefas() {
        return tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t: tarefasSet) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t: tarefasSet) {
                if (!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t: tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                }
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t: tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                }
            }
        }
    }

    public void limparListaTarefas() {
        if (tarefasSet.isEmpty()) {
            System.out.println("A lista já está vazia");
        } else {
            tarefasSet.clear();
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
