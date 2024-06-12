import java.awt.*;
import javax.swing.*;

public final class FarmiconExtendedGUI extends FarmiconGUI {

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Farmicon Extended GUI");
                FarmiconExtendedGUI gui = new FarmiconExtendedGUI();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(gui);
                frame.pack();
                frame.setLocationRelativeTo(null); // Center on screen
                frame.setVisible(true);
            } catch (FarmaciaNaoEncontradaException e) {
                e.printStackTrace();
            }
        });
    }
    private final JTextField nomeAtendenteField;
    private final JTextField horarioAtendenteField;
    private final JButton addAtendenteButton;
    private final JTextArea clienteArea;
    private final JButton addCliente;
    private final JTextField cliente;

    private final JButton processarPagamento;

    public FarmiconExtendedGUI() throws FarmaciaNaoEncontradaException {
        super(); // Call the parent constructor (FarmiconGUI)

        // Configure attendant panel
        JPanel atendentePanel = new JPanel(new GridLayout(0, 2, 5, 5));
        atendentePanel.add(new JLabel("Nome do Atendente:"));
        nomeAtendenteField = new JTextField();
        atendentePanel.add(nomeAtendenteField);
        atendentePanel.add(new JLabel("Horário de Trabalho:"));
        horarioAtendenteField = new JTextField();
        atendentePanel.add(horarioAtendenteField);
        addAtendenteButton = new JButton("Adicionar Atendente");
        atendentePanel.add(addAtendenteButton);
        add(atendentePanel, BorderLayout.WEST);

        // Configure client panel
        JPanel clientePanel = new JPanel(new GridLayout(0, 2, 5, 5));
        clientePanel.add(new JLabel("Nome do Cliente:"));
        cliente = new JTextField();
        clientePanel.add(cliente);
        addCliente = new JButton("Adicionar Cliente");
        clientePanel.add(addCliente);
        add(clientePanel, BorderLayout.SOUTH);

        // Configure payment panel
        JPanel pagamentoPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        pagamentoPanel.add(new JLabel("Clientes:"));
        clienteArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(clienteArea);
        pagamentoPanel.add(scrollPane);
        processarPagamento = new JButton("Processar Pagamento");
        pagamentoPanel.add(processarPagamento);
        add(pagamentoPanel, BorderLayout.EAST);

        // Add listeners to buttons
        addAtendenteButton.addActionListener((e) -> adicionarAtendente());
        addCliente.addActionListener((e) -> adicionarCliente());
        processarPagamento.addActionListener((e) -> processarPagamento());

        // Load data from file when the application starts
        carregarDadosArquivo(FILE_PATH);
    }

    // Override method to load data from file (implementation required)
    @Override
    protected void carregarDadosArquivo(String filePath) {
        // Implement logic to load data from the specified file 'filePath'
        // For example, read from a CSV or TXT file and update the GUI with this data
        // This is currently left unimplemented in this example
        throw new UnsupportedOperationException("Método 'carregarDadosArquivo' não implementado.");
    }

    // Override method to save data to file (implementation required)
    @Override
    protected void salvarDados(String filePath) {
        // Implement logic to save GUI data to the specified file 'filePath'
        // This is currently left unimplemented in this example
        throw new UnsupportedOperationException("Método 'salvarDados' não implementado.");
    }

    // Method to add an attendant
    private void adicionarAtendente() {
        String nome = nomeAtendenteField.getText();
        String horario = horarioAtendenteField.getText();

        if (nome.isEmpty() || horario.isEmpty()) {
            displayArea.append("Preencha todos os campos do atendente.\n");
            return;
        }

        // Simulate logic to add attendant
        displayArea.append("Atendente adicionado: " + nome + "\n");

        // Clear fields after adding attendant
        nomeAtendenteField.setText("");
        horarioAtendenteField.setText("");

        // Save updated data to file
        salvarDados(FILE_PATH);
    }

    // Method to add a client
    private void adicionarCliente() {
        String nomeCliente = cliente.getText();

        if (nomeCliente.isEmpty()) {
            displayArea.append("Digite o nome do cliente.\n");
            return;
        }

        // Simulate logic to add client
        clienteArea.append("Cliente adicionado: " + nomeCliente + "\n");

        // Clear field after adding client
        cliente.setText("");

        // Save updated data to file
        salvarDados(FILE_PATH);
    }

    // Method to process a payment
    private void processarPagamento() {
        // Simulate logic to process payment
        displayArea.append("Pagamento processado.\n");

        // Save updated data to file
        salvarDados(FILE_PATH);
    }
}
