import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class FarmiconGUI extends JFrame {
    private static final String FILE_PATH = "farmacias_data.txt";
    private static final List<Farmacia> farmacias = new ArrayList<>();

    private final JTextArea displayArea;
    private final JTextField nomeFarmaciaField;
    private final JTextField enderecoFarmaciaField;
    private final JTextField horarioFarmaciaField;
    private final JTextField nomeMedicamentoField;
    private final JTextField precoMedicamentoField;
    private final JTextField localizacaoMedicamentoField;
    private final JComboBox<Farmacia> farmaciaComboBox;
    private final JTextArea avaliacaoTextArea;
    private final JButton enviarComentarioButton;

    public FarmiconGUI() {
        setTitle("Farmicon");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        inputPanel.add(new JLabel("Nome da Farmácia:"));
        nomeFarmaciaField = new JTextField();
        inputPanel.add(nomeFarmaciaField);

        inputPanel.add(new JLabel("Endereço da Farmácia:"));
        enderecoFarmaciaField = new JTextField();
        inputPanel.add(enderecoFarmaciaField);

        inputPanel.add(new JLabel("Horário de Funcionamento (24h):"));
        horarioFarmaciaField = new JTextField();
        inputPanel.add(horarioFarmaciaField);

        inputPanel.add(new JLabel("Nome do Medicamento:"));
        nomeMedicamentoField = new JTextField();
        inputPanel.add(nomeMedicamentoField);

        inputPanel.add(new JLabel("Preço do Medicamento:"));
        precoMedicamentoField = new JTextField();
        inputPanel.add(precoMedicamentoField);

        inputPanel.add(new JLabel("Localização do Medicamento:"));
        localizacaoMedicamentoField = new JTextField();
        inputPanel.add(localizacaoMedicamentoField);

        inputPanel.add(new JLabel("Farmácia:"));
        farmaciaComboBox = new JComboBox<>();
        inputPanel.add(farmaciaComboBox);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        JButton addFarmaciaButton = new JButton("Adicionar Farmácia");
        JButton addMedicamentoButton = new JButton("Adicionar Medicamento");
        JButton compararPrecosButton = new JButton("Comparar Preços");

        buttonPanel.add(addFarmaciaButton);
        buttonPanel.add(addMedicamentoButton);
        buttonPanel.add(compararPrecosButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel comentarioPanel = new JPanel(new BorderLayout());
        JLabel labelComentario = new JLabel("Avaliações e Comentários:");
        comentarioPanel.add(labelComentario, BorderLayout.NORTH);

        avaliacaoTextArea = new JTextArea(5, 20);
        JScrollPane scrollPaneComentario = new JScrollPane(avaliacaoTextArea);
        comentarioPanel.add(scrollPaneComentario, BorderLayout.CENTER);

        enviarComentarioButton = new JButton("Enviar Avaliação/Comentário");
        comentarioPanel.add(enviarComentarioButton, BorderLayout.SOUTH);

        mainPanel.add(comentarioPanel, BorderLayout.EAST);

        add(mainPanel);

        addFarmaciaButton.addActionListener((e) -> adicionarFarmacia());
        addMedicamentoButton.addActionListener((e) -> adicionarMedicamento());
        compararPrecosButton.addActionListener((e) -> compararPrecos());
        enviarComentarioButton.addActionListener((e) -> enviarComentario());

        carregarDados(); // Carregar dados ao iniciar o programa
    }

    private void adicionarFarmacia() {
        String nome = nomeFarmaciaField.getText();
        String endereco = enderecoFarmaciaField.getText();
        String horario = horarioFarmaciaField.getText();

        if (nome.isEmpty() || endereco.isEmpty() || horario.isEmpty()) {
            displayArea.append("Preencha todos os campos da farmácia.\n");
            return;
        }

        // Validar formato de horário 24h
        if (!horario.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$|^24:00$")) {
            displayArea.append("Formato de horário inválido.\n");
            return;
        }

        Farmacia farmacia = new Farmacia(nome, endereco, horario);
        farmacias.add(farmacia);
        farmaciaComboBox.addItem(farmacia);

        displayArea.append("Farmácia adicionada: " + nome + "\n");

        nomeFarmaciaField.setText("");
        enderecoFarmaciaField.setText("");
        horarioFarmaciaField.setText("");

        salvarDados();
    }

    private void adicionarMedicamento() {
        String nome = nomeMedicamentoField.getText();
        String precoText = precoMedicamentoField.getText();
        String localizacao = localizacaoMedicamentoField.getText();
        Farmacia farmacia = (Farmacia) farmaciaComboBox.getSelectedItem();

        if (nome.isEmpty() || precoText.isEmpty() || localizacao.isEmpty()) {
            displayArea.append("Preencha todos os campos do medicamento.\n");
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoText);
            if (preco < 0) {
                displayArea.append("Preço não pode ser negativo.\n");
                return;
            }
        } catch (NumberFormatException ex) {
            displayArea.append("Preço inválido. Digite um número válido.\n");
            return;
        }

        if (farmacia == null) {
            displayArea.append("Selecione uma farmácia.\n");
            return;
        }

        Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
        farmacia.adicionarMedicamento(medicamento);

        displayArea.append("Medicamento adicionado: " + nome + " na farmácia " + farmacia.getNome() + "\n");

        nomeMedicamentoField.setText("");
        precoMedicamentoField.setText("");
        localizacaoMedicamentoField.setText("");

        salvarDados();
    }

    private void compararPrecos() {
        displayArea.setText("--- Dados Registrados ---\n");
        for (Farmacia farmacia : farmacias) {
            displayArea.append("Farmácia: " + farmacia.getNome() + ", Endereço: " + farmacia.getEndereco() + ", Horário: " + farmacia.getHorario() + "\n");
            for (Medicamento medicamento : farmacia.getListaMedicamentos()) {
                displayArea.append("   Medicamento: " + medicamento.getNome() + ", Preço: R$" + medicamento.getPreco() + ", Localização: " + medicamento.getLocalizacao() + "\n");
            }
            displayArea.append("\n");
        }
    }

    private void enviarComentario() {
        String comentario = avaliacaoTextArea.getText();
        if (comentario.isEmpty()) {
            displayArea.append("Digite um comentário antes de enviar.\n");
            return;
        }
        // Limitando comentários a 100 caracteres
        if (comentario.length() > 100) {
            displayArea.append("Comentário excede o limite de 100 caracteres.\n");
            enviarComentarioButton.setEnabled(false); // Desativa o botão após atingir o limite
            return;
        }

        displayArea.append("Comentário enviado: " + comentario + "\n");

        // Limpar o campo de texto após enviar o comentário
        avaliacaoTextArea.setText("");
    }

    private void carregarDados() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            displayArea.append("Arquivo de dados não encontrado.\n");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nome = parts[0];
                    String endereco = parts[1];
                    String horario = parts[2];
                    Farmacia farmacia = new Farmacia(nome, endereco, horario);
                    farmacias.add(farmacia);
                    farmaciaComboBox.addItem(farmacia);
                    displayArea.append("Farmácia carregada: " + nome + "\n");
                } else if (parts.length == 4) {
                    String nome = parts[0];
                    double preco = Double.parseDouble(parts[1]);
                    String localizacao = parts[2];
                    String nomeFarmacia = parts[3];
                    Farmacia farmaciaEncontrada = null;
                    for (Farmacia farmacia : farmacias) {
                        if (farmacia.getNome().equals(nomeFarmacia)) {
                            farmaciaEncontrada = farmacia;
                            break;
                        }
                    }
                    if (farmaciaEncontrada != null) {
                        Medicamento medicamento = new Medicamento(nome, preco, farmaciaEncontrada, localizacao);
                        farmaciaEncontrada.adicionarMedicamento(medicamento);
                        displayArea.append("Medicamento carregado: " + nome + " na farmácia " + nomeFarmacia + "\n");
                    } else {
                        displayArea.append("Farmácia não encontrada para o medicamento: " + nome + "\n");
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            displayArea.append("Erro ao carregar o arquivo de dados.\n");
        }
    }

    private void salvarDados() {
        File file = new File(FILE_PATH);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Farmacia farmacia : farmacias) {
                writer.println(farmacia.getNome() + "," + farmacia.getEndereco() + "," + farmacia.getHorario());

                for (Medicamento medicamento : farmacia.getListaMedicamentos()) {
                    writer.println(medicamento.getNome() + "," + medicamento.getPreco() + "," + medicamento.getLocalizacao() + "," + farmacia.getNome());
                }
            }
            displayArea.append("Dados salvos com sucesso.\n");

        } catch (IOException e) {
            displayArea.append("Erro ao salvar os dados.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FarmiconGUI().setVisible(true);
        });
    }
}


