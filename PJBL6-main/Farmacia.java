import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private List<Medicamento> listaMedicamentos;

    public Farmacia(String nome, String endereco, String horarioFuncionamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
        this.listaMedicamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        listaMedicamentos.add(medicamento);
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getHorario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorario'");
    }
}
