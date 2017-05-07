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
 * Esta es la clase padre la cual se encarga de representar los atributos que todos los hijos van a recibir por herencia*/
public class Element {
    String id;
    String image;

    public Element(String id, String image) {
        this.id = id;
        this.image = image;
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
