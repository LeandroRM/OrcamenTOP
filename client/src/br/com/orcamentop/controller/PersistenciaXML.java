package br.com.orcamentop.controller;

import br.com.orcamentop.interfaces.XMLParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

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
    
    public void save(List<XMLParser> xmlList) {
        
    }
    
    public void save(XMLParser xmlObject) {
        File file = makeFile(xmlObject.getDir());
        
        saveFile(file, xmlObject.parseToXML());
    }
    
    private File makeFile(String name) {
        File file = new File(FILES_DIR + name);
        file.mkdir();
//        dir += xmlObject.getFileName();
//        file = new File(dir);
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
}
