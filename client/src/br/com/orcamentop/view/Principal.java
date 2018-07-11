package br.com.orcamentop.view;

import br.com.orcamentop.negocio.ControllerOrcamento;
import br.com.orcamentop.negocio.ControllerOrcamentoHelper;
import br.com.orcamentop.negocio.ControllerPessoa;
import br.com.orcamentop.negocio.ControllerPessoaHelper;
import br.com.orcamentop.negocio.ControllerProduto;
import br.com.orcamentop.negocio.ControllerProdutoHelper;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class Principal extends javax.swing.JFrame {
    
    private ControllerPessoa controllerPessoa;
    private ControllerProduto controllerProduto;
    private ControllerOrcamento controllerOrcamento;
    
    /**
     * Creates new form CadastroPessoa
     * 
     * @param args
     */
    public Principal(String[] args) {
        try {
            java.util.Properties props = new java.util.Properties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            props.put("com.sun.CORBA.giop.ORBGIOPVersion", "1.0");
            
            //Cria e inicializa o ORB
            ORB orb = ORB.init(args, props);
            
            //Obtem referencia para o servico de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            //Obtem referencia para o servidor
            controllerPessoa = ControllerPessoaHelper
                    .narrow(ncRef.resolve_str("ControllerPessoa"));
            controllerProduto = ControllerProdutoHelper
                    .narrow(ncRef.resolve_str("ControllerProduto"));
            controllerOrcamento = ControllerOrcamentoHelper
                    .narrow(ncRef.resolve_str("ControllerOrcamento"));

            initComponents();
            super.getContentPane().setBackground(new Color(3,1,66));

            //Alinha a tela no centro
            super.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            String mensagem = "Não foi possível inicar a aplicação";
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOrcamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnProduto = new javax.swing.JButton();
        btnPessoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OrçamenTOP");
        setBackground(new java.awt.Color(3, 1, 66));
        setResizable(false);

        btnOrcamento.setBackground(new java.awt.Color(96, 124, 253));
        btnOrcamento.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnOrcamento.setForeground(new java.awt.Color(254, 254, 254));
        btnOrcamento.setText("Orçamento");
        btnOrcamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OrçamenTOP");

        btnProduto.setBackground(new java.awt.Color(96, 124, 253));
        btnProduto.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnProduto.setForeground(new java.awt.Color(254, 254, 254));
        btnProduto.setText("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnPessoa.setBackground(new java.awt.Color(96, 124, 253));
        btnPessoa.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnPessoa.setForeground(new java.awt.Color(254, 254, 254));
        btnPessoa.setText("Pessoa");
        btnPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        CadastroOrcamento viewCadastroOrcamento = new CadastroOrcamento(controllerOrcamento, controllerProduto, controllerPessoa);
        viewCadastroOrcamento.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        CadastroProduto viewCadastroProduto = new CadastroProduto(controllerProduto);
        viewCadastroProduto.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPessoaActionPerformed
        CadastroPessoa viewCadastroPessoa = new CadastroPessoa(controllerPessoa);
        viewCadastroPessoa.setVisible(true);
    }//GEN-LAST:event_btnPessoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnPessoa;
    private javax.swing.JButton btnProduto;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String[] args) {
        Principal principal = new Principal(args);
        principal.setVisible(true);
    }
}
