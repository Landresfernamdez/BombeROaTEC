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
 * Esta clase se encarga de representar de el bloque barrera*/
public class BloqueBarrera extends Element{

    public BloqueBarrera(String id, String image) {
        super(id, image);
        id="Bb";
        image="/eventos/bloque.gif";
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
