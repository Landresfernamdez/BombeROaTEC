/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberoatec;

/**
 *
 * @author Andres
 */
/**
 * Esta clase se encarga de representar los espacios vacios en a matriz*/
public class EspacioVacio extends Element {

    public EspacioVacio(String id, String image) {
        super(id, image);
        id="Ev";
        image="/eventos/vacio.gif";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

   
}
