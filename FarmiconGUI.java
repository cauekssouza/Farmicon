import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class FarmiconGUI extends JFrame {
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

        inputPanel.add(new JLabel("Horário de Funcionamento:"));
        horarioFarmaciaField = new JTextField();
        inputPanel.add(horarioFarmaciaField);

        inputPanel.add(new JLabel("Nome do Medicamento:"));
        nomeMedicamentoField = new JTextField();
        inputPanel.add(nomeMedicamentoField);

        inputPanel.add(new JLabel("Preço do Medicamento:")); // exemplo: 5.00
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
        JButton addMedicamentoButton = new JButton("Adicionar Medicamento"); // Seria para encerrar o programa mas precisa está preenchido todas aréas
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
    }

    private void adicionarFarmacia() {
        String nome = nomeFarmaciaField.getText();
        String endereco = enderecoFarmaciaField.getText();
        String horario = horarioFarmaciaField.getText();

        Farmacia farmacia = new Farmacia(nome, endereco, horario);
        farmacias.add(farmacia);
        farmaciaComboBox.addItem(farmacia);

        displayArea.append("Farmácia adicionada: " + nome + "\n");

        nomeFarmaciaField.setText("");
        enderecoFarmaciaField.setText("");
        horarioFarmaciaField.setText("");
    }

    private void adicionarMedicamento() {
        String nome = nomeMedicamentoField.getText();
        String precoText = precoMedicamentoField.getText();
        String localizacao = localizacaoMedicamentoField.getText();
        Farmacia farmacia = (Farmacia) farmaciaComboBox.getSelectedItem();
    
        if (nome.isEmpty() || precoText.isEmpty() || localizacao.isEmpty() || farmacia == null) {
            displayArea.append("Preencha todos os campos e selecione uma farmácia.\n");
            return;
        }
    
        double preco;
        try {
            preco = Double.parseDouble(precoText);
        } catch (NumberFormatException e) {
            displayArea.append("Preço inválido. Por favor, insira um número.\n");
            return;
        }
    
        Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
        farmacia.adicionarMedicamento(medicamento);
    
        displayArea.append("Medicamento adicionado: " + nome + " na farmácia " + farmacia.getNome() + "\n");
    
        nomeMedicamentoField.setText("");
        precoMedicamentoField.setText("");
        localizacaoMedicamentoField.setText("");
    }
    

    private void compararPrecos() {
        displayArea.append("--- Comparação de Preços ---\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comparacao_precos.txt"))) {
            writer.write("--- Comparação de Preços ---\n");

            for (Farmacia farmacia1 : farmacias) {
                for (Farmacia farmacia2 : farmacias) {
                    if (!farmacia1.equals(farmacia2)) {
                        for (Medicamento medicamento1 : farmacia1.getListaMedicamentos()) {
                            for (Medicamento medicamento2 : farmacia2.getListaMedicamentos()) {
                                if (medicamento1.getNome().equals(medicamento2.getNome())) {
                                    String comparacao = "Medicamento: " + medicamento1.getNome() + "\n" +
                                            "Preço " + farmacia1.getNome() + ": R$" + medicamento1.getPreco() + "\n" +
                                            "Preço " + farmacia2.getNome() + ": R$" + medicamento2.getPreco() + "\n" +
                                            "Diferença de preço: R$" + Math.abs(medicamento1.getPreco() - medicamento2.getPreco()) + "\n";

                                    displayArea.append(comparacao);
                                    writer.write(comparacao);
                                }
                            }
                        }
                    }
                }
            }

            writer.write("--- Fim da Comparação ---\n");
            displayArea.append("--- Fim da Comparação ---\n");
        } catch (IOException e) {
            e.printStackTrace();
            displayArea.append("Erro ao escrever no arquivo.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FarmiconGUI().setVisible(true);
            }
        });
    }
}
