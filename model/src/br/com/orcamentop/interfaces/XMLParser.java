package br.com.orcamentop.interfaces;

/**
 *
 * @author Leandro Ramos (leandroramosmarcelino@hotmail.com)
 */
public interface XMLParser {
    public String parseToXML();
    public com.thoughtworks.xstream.XStream getParser();
    public String getDir();
    public String getFileName();
}
