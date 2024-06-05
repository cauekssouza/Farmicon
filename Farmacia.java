import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private String nome;
    private String endereco;
    private String horario;
    private List<Medicamento> medicamentos;

    public Farmacia(String nome, String endereco, String horario) {
        this.nome = nome;
        this.endereco = endereco;
        this.horario = horario;
        this.medicamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public List<Medicamento> getListaMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
        return nome;
    }
}
