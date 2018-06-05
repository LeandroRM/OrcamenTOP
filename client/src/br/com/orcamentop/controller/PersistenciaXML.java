package br.com.orcamentop.controller;

import br.com.orcamentop.interfaces.XMLParser;
import br.com.orcamentop.dto.ListaPessoa;
import br.com.orcamentop.dto.ListaProduto;
import br.com.orcamentop.dto.ListaOrcamento;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class PersistenciaXML {
    private static final String FILES_DIR = "./database/";
    private static PersistenciaXML instance;
    
    private PersistenciaXML() {
    }
    
    public static PersistenciaXML getInstance() {
        if (instance == null) {
            instance = new PersistenciaXML();
        }
        return instance;
    }
    
    public void save(XMLParser xmlObject) {
        File file = makeFile(xmlObject.getFileName());
        
        saveFile(file, xmlObject.parseToXML());
    }
    
    private File makeFile(String name) {
        File file = new File(FILES_DIR + name);
        file.mkdir();

        if (file.exists()) {
            file.delete();
        }
        
        return file;
    }
    
    private void saveFile(File file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (Exception e) {
            System.out.println("Falha ao gravar arquivo " + file.getAbsolutePath());
        }
    }
    
    public ListaPessoa loadPessoas() {
        ListaPessoa helper = new ListaPessoa();
        File file = new File(FILES_DIR + helper.getFileName());

        try (FileReader fileReader = new FileReader(file)) {
            ListaPessoa retornar = (ListaPessoa) helper.getParser().fromXML(fileReader);
            fileReader.close();
            
            return retornar;
        } catch (Exception e) {
            return helper;
        }
    }
    
    public ListaProduto loadProdutos() {
        ListaProduto helper = new ListaProduto();
        File file = new File(FILES_DIR + helper.getFileName());

        try (FileReader fileReader = new FileReader(file)) {
            ListaProduto retornar = (ListaProduto) helper.getParser().fromXML(fileReader);
            fileReader.close();
            
            return retornar;
        } catch (Exception e) {
            return helper;
        }
    }
    
    public ListaOrcamento loadOrcamentos() {
        ListaOrcamento helper = new ListaOrcamento();
        File file = new File(FILES_DIR + helper.getFileName());

        try (FileReader fileReader = new FileReader(file)) {
            ListaOrcamento retornar = (ListaOrcamento) helper.getParser().fromXML(fileReader);
            fileReader.close();
            
            return retornar;
        } catch (Exception e) {
            return helper;
        }
    }
}
