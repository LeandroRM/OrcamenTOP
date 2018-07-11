package br.com.orcamentop.view;

import br.com.orcamentop.dto.Orcamento;
import br.com.orcamentop.listmodel.PessoaListModel;
import br.com.orcamentop.listmodel.ProdutoListModel;
import br.com.orcamentop.negocio.ControllerOrcamento;
import br.com.orcamentop.negocio.ControllerPessoa;
import br.com.orcamentop.negocio.ControllerProduto;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class CadastroOrcamento extends javax.swing.JFrame {
    
    private final ControllerOrcamento controllerOrcamento;
    private final ControllerProduto controllerProduto;
    private final ControllerPessoa controllerPessoa;
    
    /**
     * Creates new form CadastroPessoa
     * 
     * @param controllerOrcamento
     * @param controllerProduto
     * @param controllerPessoa
     */
    public CadastroOrcamento(ControllerOrcamento controllerOrcamento,
            ControllerProduto controllerProduto, ControllerPessoa controllerPessoa) {
        this.controllerOrcamento = controllerOrcamento;
        this.controllerProduto = controllerProduto;
        this.controllerPessoa = controllerPessoa;
        
        initComponents();
        initListas();
        
        //Alinha a tela no centro
        super.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProduto = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtValorExtra = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValorFinal = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPessoa = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Orçamento");

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Produto:");

        jScrollPane2.setViewportView(listProduto);

        jLabel1.setText("Valor extra:");

        txtValorExtra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorExtra.setText("0");

        jLabel2.setText("Valor total:");

        txtValorFinal.setEditable(false);
        txtValorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorFinal.setText("0");

        jScrollPane3.setViewportView(listPessoa);

        jLabel5.setText("Pessoa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtValorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initListas() {
        ProdutoListModel produtoListModel = new ProdutoListModel(controllerProduto.carregar());
        listProduto.setModel(produtoListModel);
        listProduto.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        PessoaListModel pessoaListModel = new PessoaListModel(controllerPessoa.carregar());
        listPessoa.setModel(pessoaListModel);
        listPessoa.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Orcamento orcamento = getOrcamento();
       
       if (orcamento == null) {
           return;
       }
       
       if (controllerOrcamento.gravar(orcamento)) {
           JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
           this.dispose();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private Orcamento getOrcamento() {
//        if (txtNome.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "É necessário informar o nome!");
//            return null;
//        }
//        
//        String nome = txtNome.getText();
//        String telefone = txtTelefone.getText();
//        String email = txtEmail.getText();
//        
//        if (telefone.trim().length() < 9) {
//            telefone = "";
//        }
//        
        Orcamento orcamento = new Orcamento();
//        orcamento.setNome(nome);
//        orcamento.setTelefone(telefone);
//        orcamento.setEmail(email);

        return orcamento;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listPessoa;
    private javax.swing.JList<String> listProduto;
    private javax.swing.JFormattedTextField txtValorExtra;
    private javax.swing.JFormattedTextField txtValorFinal;
    // End of variables declaration//GEN-END:variables
}
