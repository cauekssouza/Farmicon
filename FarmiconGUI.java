import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FarmiconGUI extends JFrame {
    private static final String FILE_PATH = "farmacias_data.txt";
    private static List<Farmacia> farmacias = new ArrayList<>();

    private JTextArea displayArea;
    private JTextField nomeFarmaciaField;
    private JTextField enderecoFarmaciaField;
    private JTextField horarioFarmaciaField;
    private JTextField nomeMedicamentoField;
    private JTextField precoMedicamentoField;
    private JTextField localizacaoMedicamentoField;
    private JComboBox<Farmacia> farmaciaComboBox;

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

        add(mainPanel);

        addFarmaciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarFarmacia();
            }
        });

        addMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMedicamento();
            }
        });

        compararPrecosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararPrecos();
            }
        });

        // Carregar dados ao iniciar o programa
        carregarDados();
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
        if (!horario.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            displayArea.append("Formato de horário inválido. Use HH:MM (24h).\n");
            return;
        }

        Farmacia farmacia = new Farmacia(nome, endereco, horario);
        farmacias.add(farmacia);
        farmaciaComboBox.addItem(farmacia);

        displayArea.append("Farmácia adicionada: " + nome + "\n");

        nomeFarmaciaField.setText("");
        enderecoFarmaciaField.setText("");
        horarioFarmaciaField.setText(horario);

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
        localizacaoMedicamentoField.setText(localizacao);

        salvarDados();
    }

    private void compararPrecos() {
        displayArea.append("--- Comparação de Preços ---\n");

        for (Farmacia farmacia1 : farmacias) {
            for (Farmacia farmacia2 : farmacias) {
                if (!farmacia1.equals(farmacia2)) {
                    for (Medicamento medicamento1 : farmacia1.getListaMedicamentos()) {
                        for (Medicamento medicamento2 : farmacia2.getListaMedicamentos()) {
                            if (medicamento1.getNome().equals(medicamento2.getNome())) {
                                displayArea.append("Medicamento: " + medicamento1.getNome() + "\n");
                                displayArea.append("Preço " + farmacia1.getNome() + ": R$" + medicamento1.getPreco() + "\n");
                                displayArea.append("Preço " + farmacia2.getNome() + ": R$" + medicamento2.getPreco() + "\n");
                                displayArea.append("Diferença de preço: R$" + Math.abs(medicamento1.getPreco() - medicamento2.getPreco()) + "\n");
                            }
                        }
                    }
                }
            }
        }
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
                    Farmacia farmacia = buscarFarmacia(nomeFarmacia);
                    if (farmacia != null) {
                        Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
                        farmacia.adicionarMedicamento(medicamento);
                        displayArea.append("Medicamento carregado: " + nome + " na farmácia " + nomeFarmacia + "\n");
                    } else {
                        displayArea.append("Farmácia não encontrada para o medicamento: " + nome + "\n");
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            displayArea.append("Erro ao carregar o arquivo de dados.\n");
            e.printStackTrace();
        }
    }

    private Farmacia buscarFarmacia(String nome) {
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getNome().equals(nome)) {
                return farmacia;
            }
        }
        return null;
    }

    /**
     * 
     */
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
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FarmiconGUI().setVisible(true);
            }
        });
    }
}

