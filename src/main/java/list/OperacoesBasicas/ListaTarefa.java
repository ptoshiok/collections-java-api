package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> listaTarefas;

    public ListaTarefa() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t: listaTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
        }
        listaTarefas.removeAll(tarefasParaRemover);
    }
    public int obterNumeroTotalTarefas() {
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(listaTarefas);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println(listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Limpar a casa");

        listaTarefa.obterDescricoesTarefas();
    }
}
