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
 * Se encarga de representar el objeto globo*/
public class Globo extends Element{

    public Globo(String id, String image) {
        super(id, image);
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
