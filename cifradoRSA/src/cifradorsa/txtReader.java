/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;
/**
 *
 * @author Francisco Molina
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class txtReader{
    private BufferedWriter writer;
    private FileWriter escritor;
    private BufferedReader reader;
  //Escoge archivo
    private JFileChooser menu;
  //Filtro para archivo unicamente TXT
    private FileNameExtensionFilter txtOnly;
    
    private FileReader lector;
  
    /**
     * Constructor, estado inicial con filtro de TXT
     */
  public txtReader(){
      this.writer = null;
      this.escritor= null;
      this.lector=null;
      this.reader = null;
      this.menu = new JFileChooser();
      this.txtOnly= new FileNameExtensionFilter("TEXT FILES", "txt", "text");
      menu.setFileFilter(txtOnly);
    }
  /**
   * Carga el archivo que el usuario desea leer
   * @param menu variable de tipo filechooser
   * @return un bufferedReader para dicho archivo
   * @throws FileNotFoundException en caso no exista dicho archivo
   */
  public BufferedReader load(JFileChooser menu) throws FileNotFoundException{
      int returnV = menu.showOpenDialog(null);
      if (returnV == JFileChooser.APPROVE_OPTION){
          lector= new FileReader(menu.getSelectedFile().getAbsoluteFile());
          reader = new BufferedReader(lector);
      }
       return reader;  
  }
  
    public BufferedWriter loadWriter(JFileChooser menu) throws FileNotFoundException, IOException{
      int returnV = menu.showOpenDialog(null);
      if (returnV == JFileChooser.APPROVE_OPTION){
          escritor= new FileWriter(menu.getSelectedFile().getAbsoluteFile());
          writer = new BufferedWriter(escritor);
      }
       return writer;  
  }
  
  /**
   * lee el texto y devuelve en lista las cartas
   * @param reader bufferedReader
   * @return el doc, linea por linea.
   * @throws IOException 
   */
  public String readTxt(BufferedReader reader) throws IOException{
      String msj="";
      String linea="";
      while((linea = reader.readLine())!= null){ 
        msj += linea + "\n";
      }
      reader.close();
      return msj;
    }
  
  public void writeAndCreate(BufferedWriter writer, String mensaje){
        try {
            writer.write(mensaje);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(txtReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
  }
  
  public JFileChooser getChooser(){
      return this.menu;
  }
      
  }
  
        
        
  
      
