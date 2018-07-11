package br.com.orcamentop.persistencia;

import br.com.orcamentop.dto.ListaPessoa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public class PersistenciaPessoaImpl extends PersistenciaPessoaPOA {

    private static final String FILES_DIR = "database/";
    
    @Override
    public boolean salvar(ListaPessoa pessoas) {
        try {
            File file = makeFile(pessoas.getFileName());

            saveFile(file, pessoas.parseToXML());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private File makeFile(String name) {
        File file = new File(FILES_DIR + name);
        file.mkdirs();

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
            e.printStackTrace();
        }
    }
    
    @Override
    public ListaPessoa carregar() {
        ListaPessoa helper = new ListaPessoa();
        File file = new File(FILES_DIR + helper.getFileName());
        if (!file.exists()) {
            return helper;
        }
        
        try (FileReader fileReader = new FileReader(file)) {
            ListaPessoa retornar = (ListaPessoa) helper.getParser().fromXML(fileReader);
            fileReader.close();
            return retornar;
        } catch (Exception e) {
            e.printStackTrace();
            return helper;
        }
    }
}
