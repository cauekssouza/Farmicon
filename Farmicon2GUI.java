import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Farmicon2GUI extends JFrame {
   private static List<Farmacia> farmacias = new ArrayList<>();
   private JTextArea displayArea;
   private JTextField nomeFarmaciaField;
   private JTextField enderecoFarmaciaField;
   private JTextField horarioFarmaciaField;
   private JTextField nomeMedicamentoField;
   private JTextField precoMedicamentoField;
   private JTextField localizacaoMedicamentoField;
   private JComboBox<Farmacia> farmaciaComboBox;

   public Farmicon2GUI() {
      this.setTitle("Farmicon");
      this.setSize(600, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      JMenuBar menuBar = new JMenuBar();
      JMenu arquivoMenu = new JMenu("Arquivo");
      JMenuItem carregarCSVItem = new JMenuItem("Carregar CSV");
      arquivoMenu.add(carregarCSVItem);
      menuBar.add(arquivoMenu);
      this.setJMenuBar(menuBar);
      carregarCSVItem.addActionListener(e -> carregarDadosCSV());
      JPanel mainPanel = new JPanel(new BorderLayout());
      this.displayArea = new JTextArea();
      this.displayArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(this.displayArea);
      mainPanel.add(scrollPane, BorderLayout.CENTER);
      JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
      inputPanel.add(new JLabel("Nome da Farmácia:"));
      this.nomeFarmaciaField = new JTextField();
      inputPanel.add(this.nomeFarmaciaField);
      inputPanel.add(new JLabel("Endereço da Farmácia:"));
      this.enderecoFarmaciaField = new JTextField();
      inputPanel.add(this.enderecoFarmaciaField);
      inputPanel.add(new JLabel("Horário de Funcionamento:"));
      this.horarioFarmaciaField = new JTextField();
      inputPanel.add(this.horarioFarmaciaField);
      inputPanel.add(new JLabel("Nome do Medicamento:"));
      this.nomeMedicamentoField = new JTextField();
      inputPanel.add(this.nomeMedicamentoField);
      inputPanel.add(new JLabel("Preço do Medicamento:"));
      this.precoMedicamentoField = new JTextField();
      inputPanel.add(this.precoMedicamentoField);
      inputPanel.add(new JLabel("Localização do Medicamento:"));
      this.localizacaoMedicamentoField = new JTextField();
      inputPanel.add(this.localizacaoMedicamentoField);
      inputPanel.add(new JLabel("Farmácia:"));
      this.farmaciaComboBox = new JComboBox<>();
      inputPanel.add(this.farmaciaComboBox);
      mainPanel.add(inputPanel, BorderLayout.NORTH);
      JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
      JButton addFarmaciaButton = new JButton("Adicionar Farmácia");
      JButton addMedicamentoButton = new JButton("Adicionar Medicamento");
      JButton compararPrecosButton = new JButton("Comparar Preços");
      buttonPanel.add(addFarmaciaButton);
      buttonPanel.add(addMedicamentoButton);
      buttonPanel.add(compararPrecosButton);
      mainPanel.add(buttonPanel, BorderLayout.SOUTH);
      this.add(mainPanel);
      addFarmaciaButton.addActionListener(e -> adicionarFarmacia());
      addMedicamentoButton.addActionListener(e -> adicionarMedicamento());
      compararPrecosButton.addActionListener(e -> compararPrecos());
   }

   private void carregarDadosCSV() {
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) {
         try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
               if (data.length == 3) {
                  String nome = data[0];
                  String endereco = data[1];
                  String horario = data[2];
                  Farmacia farmacia = new Farmacia(nome, endereco, horario);
                  farmacias.add(farmacia);
                  this.farmaciaComboBox.addItem(farmacia);
                  this.displayArea.append("Farmácia carregada: " + nome + "\n");
               } else if (data.length == 4) {
                  String nome = data[0];
                  double preco = Double.parseDouble(data[1]);
                  String localizacao = data[2];
                  String nomeFarmacia = data[3];
                  Farmacia farmacia = farmacias.stream()
                        .filter(f -> f.getNome().equalsIgnoreCase(nomeFarmacia))
                        .findFirst()
                        .orElse(null);
                  if (farmacia != null) {
                     Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
                     farmacia.adicionarMedicamento(medicamento);
                     this.displayArea.append("Medicamento carregado: " + nome + " na farmácia " + nomeFarmacia + "\n");
                  } else {
                     this.displayArea.append("Farmácia não encontrada para o medicamento: " + nome + "\n");
                  }
               }
            }
         } catch (IOException e) {
            e.printStackTrace();
            this.displayArea.append("Erro ao carregar o arquivo.\n");
         }
      }
   }

   private void adicionarFarmacia() {
      String nome = this.nomeFarmaciaField.getText();
      String endereco = this.enderecoFarmaciaField.getText();
      String horario = this.horarioFarmaciaField.getText();
      Farmacia farmacia = new Farmacia(nome, endereco, horario);
      farmacias.add(farmacia);
      this.farmaciaComboBox.addItem(farmacia);
      this.displayArea.append("Farmácia adicionada: " + nome + "\n");
      this.nomeFarmaciaField.setText("");
      this.enderecoFarmaciaField.setText("");
      this.horarioFarmaciaField.setText("");
   }

   private void adicionarMedicamento() {
      String nome = this.nomeMedicamentoField.getText();
      double preco = Double.parseDouble(this.precoMedicamentoField.getText());
      String localizacao = this.localizacaoMedicamentoField.getText();
      Farmacia farmacia = (Farmacia)this.farmaciaComboBox.getSelectedItem();
      if (farmacia != null) {
         Medicamento medicamento = new Medicamento(nome, preco, farmacia, localizacao);
         farmacia.adicionarMedicamento(medicamento);
         this.displayArea.append("Medicamento adicionado: " + nome + " na farmácia " + farmacia.getNome() + "\n");
         this.nomeMedicamentoField.setText("");
         this.precoMedicamentoField.setText("");
         this.localizacaoMedicamentoField.setText("");
      } else {
         this.displayArea.append("Selecione uma farmácia.\n");
      }
   }

   private void compararPrecos() {
      this.displayArea.append("--- Comparação de Preços ---\n");
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

                           this.displayArea.append(comparacao);
                           writer.write(comparacao);
                        }
                     }
                  }
               }
            }
         }

         writer.write("--- Fim da Comparação ---\n");
         this.displayArea.append("--- Fim da Comparação ---\n");
      } catch (IOException e) {
         e.printStackTrace();
         this.displayArea.append("Erro ao escrever no arquivo.\n");
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new Farmicon2GUI().setVisible(true));
   }
}
