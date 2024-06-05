import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
        double preco = Double.parseDouble(precoMedicamentoField.getText());
        String localizacao = localizacaoMedicamentoField.getText();
        Farmacia farmacia = (Farmacia) farmaciaComboBox.getSelectedItem();

        if (farmacia != null) {
            Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
            farmacia.adicionarMedicamento(medicamento);

            displayArea.append("Medicamento adicionado: " + nome + " na farmácia " + farmacia.getNome() + "\n");

            nomeMedicamentoField.setText("");
            precoMedicamentoField.setText("");
            localizacaoMedicamentoField.setText("");
        } else {
            displayArea.append("Selecione uma farmácia.\n");
        }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FarmiconGUI().setVisible(true);
            }
        });
    }
}
