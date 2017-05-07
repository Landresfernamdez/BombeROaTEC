/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberoatec;
import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractAction.*;
import java.awt.KeyEventDispatcher;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Andres
 */
/**
 * Esta es la matriz del juego*/
public class Jugar extends javax.swing.JFrame 

{

   
            boolean GloAction;
            int countLeft=0;
            int countRight=0;
            int countUp=0;
            int countDown=0;
            int countX;
            int countY;
            int ejeY=1;
            int ejeX=1;
            Element matriz20X20[][]=new Element[22][21];
            JButton matriz20X20G[][]=new JButton[22][21];
            String matriz40X40[][]=new String[40][40];
            String matriz60X60[][]=new String[60][60];
            int x=27;
            int y=24;
            int dx;
            int dy;
            //public Matrices matriz;
            JButton heroe;
            Timer t;
            JButton bloqueBarrera;
            JButton bloqueBarrerae;
            JButton espacioVacio;
            JButton bomba;
            ImageIcon imagenSpaceVacio;  
            String imageBloque="/eventos/bloque_concreto.gif";
            String imageSpaceVacio="/eventos/vacio.gif";
            String imageHeroe="/eventos/bomberman.gif";
            String imageBloqueBarrera="/eventos/bloque.gif";
            String bombas="/eventos/bombaExplotando.gif";
            String imageGlobo="/eventos/bomba.gif";
            ImageIcon imagenGlobo;
            ImageIcon imagenHeroe;
            ImageIcon imagenBloqueBarrera;
            ImageIcon imagenBloqueConcreto;
            ImageIcon boom;
            int emx;
            int emx1=27;
            int emx2;
            int emx3;
            int emx4=27;
            int emx5=54;
            int meX=54;
            int meY=48;
            int meX2=54;
            int meY2=48;
            int count;
            int count1;
            
    /**
     * Creates new form Jugar
     */
    
    public Jugar() {
        initComponents();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                
                                             }

            @Override
            
            public void keyPressed(KeyEvent e) {
                  int keySim=e.getKeyCode();
                    if(keySim==KeyEvent.VK_LEFT){
                          
                          if(ejeX-1!=0){
                            dx=-27;
                            Mover();
                            System.out.println("izquierda");
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(ejeX);
                            heroe.setBounds(x,y,27,24);  
                            dx=0;
                                        }
                            
                                
                                                                                 
                            
                            
                                                }
                    if(keySim==KeyEvent.VK_RIGHT){
                           
                           if((ejeX+1!=20)){
                                dx=27; 
                                Mover();
                                System.out.println("derecha");
                                System.out.println(x);
                                System.out.println(y);
                                System.out.println(ejeX);
                                heroe.setBounds(x,y,27,24);
                                dx=0;
                                           }
                           
                                
                                                                                
                           
                           
                                                 }
                    if(keySim==KeyEvent.VK_UP){
                           
                           if(ejeY-1!=0){
                                dy=-24;
                                Mover();
                                System.out.println("arriba");
                                System.out.println(x);
                                System.out.println(y);
                                System.out.println(ejeY);
                                heroe.setBounds(x,y,27,24);
                                dy=0;
                                        }
                                              }
                    if(keySim==KeyEvent.VK_DOWN){
                        
                        if(ejeY+1!=20){
                            dy=24;
                            Mover();
                            System.out.println("abajo");
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(ejeY);
                            heroe.setBounds(x,y,27,24);
                            dy=0;
                                       }
                                                }
                    if(keySim==KeyEvent.VK_SPACE){
                        int d=x;
                        int h=y;
                        Bomba b=new Bomba("boom","/eventos/bombaExplotando.gif");
                        matriz20X20[x/27][y/24]=b;
                        JButton bombas=new JButton(); 
                        bombas.setBounds(d,h,27,24);
                        bombas.setIcon(boom);
                        add(bombas);
                        t.start();
                        matriz20X20[x/27][y/24]=null;
                        Repintar();
                        repaint();
                       
                        
                        
                                                 }
                                                       }

            @Override
            public void keyReleased(KeyEvent e){
                int keySim=e.getKeyCode();
                if(keySim==KeyEvent.VK_LEFT){
                        dx=0;
                        Mover();
                                            }
                if(keySim==KeyEvent.VK_RIGHT){
                       dx=0;
                       Mover();
                                             }
                if(keySim==KeyEvent.VK_UP){
                        dy=0;
                        Mover();


                                          }
                if(keySim==KeyEvent.VK_UP){
                        dy=0;
                        Mover();

                                          }
                if(keySim==KeyEvent.VK_SPACE){



                                             }
       
       
                                               }

            
        });
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imagenHeroe=new ImageIcon(this.getClass().getResource(imageHeroe));
        imagenHeroe.getImage();
        imagenBloqueConcreto=new ImageIcon(this.getClass().getResource(imageBloque));
        imagenBloqueConcreto.getImage();
        imagenGlobo=new ImageIcon(this.getClass().getResource(imageGlobo));
        boom=new ImageIcon(this.getClass().getResource(bombas));
        boom.getImage();
        heroe=new JButton();
        bomba=new JButton();
        t = new Timer(2500, new ActionListener(){      
            public void actionPerformed(ActionEvent e) {
                explosion();
                t.stop();
                repaint();
                                                      }

            /**
             * Se encarga de explotar la bombacon un timer*/
            private void explosion() {
                        int bE=x/27;
                        int bEY=y/24;
                        
                  if(((bE-1!=0)&&(bE-1!=-1))&&((bEY-1!=0)&&(bEY-1!=-1))&&((bE+1!=20)&&(bE+1!=21))&&((bEY+1!=20)&&(bEY+1!=21))){
                        
                        if(matriz20X20[bE+1][bEY]!=null){
                            if(matriz20X20[bE+1][bEY].getId().equals("B")){
                                matriz20X20[bE+1][bEY]=null;
                                                              }
                                                         }
                        else if(matriz20X20[bE-1][bEY]!=null){
                            if(matriz20X20[bE-1][bEY].getId().equals("B")){
                                matriz20X20[bE-1][bEY]=null;
                                                              }
                                                             }
                        else if(matriz20X20[bE][bEY+1]!=null){
                            if(matriz20X20[bE][bEY+1].getId().equals("B")){
                                matriz20X20[bE][bEY+1]=null;
                                                              }
                                                             }
                        else if(matriz20X20[bE][bEY-1]!=null){
                            if(matriz20X20[bE][bEY-1].getId().equals("B")){
                                matriz20X20[bE][-1]=null;
                                                              }
                                                             }
                                                                           }
                   if(((bE-2!=0)&&(bE-2!=-1))&&((bEY-2!=0)&&(bEY-2!=-1))&&((bE+2!=20)&&(bE+2!=21))&&((bEY+2!=20)&&(bEY+2!=21))){
                        
                        if(matriz20X20[bE+2][bEY]!=null){
                            if(matriz20X20[bE+2][bEY].getId().equals("B")){
                                matriz20X20[bE+2][bEY]=null;
                                
                                                           }
                                                     }
                        else if(matriz20X20[bE-2][bEY]!=null){
                            if(matriz20X20[bE-2][bEY].getId().equals("B")){
                                matriz20X20[bE-2][bEY]=null;
                                
                                                           }
                                                          }
                        else if(matriz20X20[bE][bEY+2]!=null){
                            if(matriz20X20[bE][bEY+2].getId().equals("B")){
                                matriz20X20[bE][bEY+2]=null;
                                
                                                                  }
                                                             }
                        else if(matriz20X20[bE][bEY-2]!=null){
                            if(matriz20X20[bE][bEY-2].getId().equals("B")){
                                matriz20X20[bE][bEY-2]=null;
                                
                                                                   }
                                                             }
                                                                            }
                       
                   
                        
                
                
                                  
               
                
                
                                     
            }
            
        });
        /**
         * Este es el listener del boton*/
        heroe.addActionListener((ActionEvent e) -> {
        Mover();
                                                   });
        heroe.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
                                             }

            @Override
            public void keyPressed(KeyEvent e) {
                  int keySim=e.getKeyCode();
                    if(keySim==KeyEvent.VK_LEFT){
                          
                          if(ejeX-1!=0){
                            dx=-27;
                            Mover();
                            System.out.println("izquierda");
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(ejeX);
                            heroe.setBounds(x,y,27,24);  
                            dx=0;
                                        }
                            
                                
                                                                                 
                            
                            
                                                }
                    if(keySim==KeyEvent.VK_RIGHT){
                           
                           if((ejeX+1!=20)){
                                dx=27; 
                                Mover();
                                System.out.println("derecha");
                                System.out.println(x);
                                System.out.println(y);
                                System.out.println(ejeX);
                                heroe.setBounds(x,y,27,24);
                                dx=0;
                                           }
                           
                                
                                                                                
                           
                           
                                                 }
                    if(keySim==KeyEvent.VK_UP){
                           
                           if(ejeY-1!=0){
                                dy=-24;
                                Mover();
                                System.out.println("arriba");
                                System.out.println(x);
                                System.out.println(y);
                                System.out.println(ejeY);
                                heroe.setBounds(x,y,27,24);
                                dy=0;
                                        }
                                              }
                    if(keySim==KeyEvent.VK_DOWN){
                        
                        if(ejeY+1!=20){
                            dy=24;
                            Mover();
                            System.out.println("abajo");
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(ejeY);
                            heroe.setBounds(x,y,27,24);
                            dy=0;
                                       }
                                                }
                    if(keySim==KeyEvent.VK_SPACE){
                        int d=x;
                        int h=y;
                        Bomba b=new Bomba("boom","/eventos/bombaExplotando.gif");
                        matriz20X20[x/27][y/24]=b;
                        JButton bombas=new JButton(); 
                        bombas.setBounds(d,h,27,24);
                        bombas.setIcon(boom);
                        add(bombas);
                        t.start();
                        matriz20X20[x/27][y/24]=null;
                        Repintar();
                        repaint();
                       
                        
                        
                                                 }
                                                       }

            @Override
            public void keyReleased(KeyEvent e){
                int keySim=e.getKeyCode();
                if(keySim==KeyEvent.VK_LEFT){
                        dx=0;
                        Mover();
                                            }
                if(keySim==KeyEvent.VK_RIGHT){
                       dx=0;
                       Mover();
                                             }
                if(keySim==KeyEvent.VK_UP){
                        dy=0;
                        Mover();


                                          }
                if(keySim==KeyEvent.VK_UP){
                        dy=0;
                        Mover();

                                          }
                if(keySim==KeyEvent.VK_SPACE){



                                             }
       
       
                                               }

            
        });
        for(int x=0;x<21;x++){
            for(int y=0;y<21;y++){
               if((x%2==0)&&(y%2==0)&&((x!=19)&&(x!=0)&&(x!=1)&&(x!=20))){
                   BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                   matriz20X20[x][y]=Bb;
                                                                         }
               if((y==0)||(y==20)){
                   BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                   matriz20X20[x][y]=Bb;
               
                                   }
               if((x==0)){
                   BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                   matriz20X20[x][y]=Bb;
                         }
               if(x==20){
                   BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                   matriz20X20[x][y]=Bb;
                        }
               if((x==1)&&(y==0)||(y==20)){
                    BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                    matriz20X20[x][y]=Bb;
                                          }
               if((x==19)&&(y==0)||(y==20)){
                    BloqueBarrera Bb=new BloqueBarrera("Bb","/eventos/bloque.gif");
                    matriz20X20[x][y]=Bb;
                                          }
               
                                }
                             }
        heroe.setBounds(x, y, 27, 24);
        heroe.setIcon(imagenHeroe);
        this.add(heroe);
        
        imagenBloqueBarrera=new ImageIcon(this.getClass().getResource(imageBloqueBarrera));
        imagenSpaceVacio=new ImageIcon(this.getClass().getResource(imageSpaceVacio));
        imagenSpaceVacio.getImage();
        imagenBloqueBarrera.getImage();
        
        this.setSize(573,533);
        setTitle("Mover imagen con java");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
        


       
    }
    /**
     * Esta funcion se encarga de agregar los globos a la pantalla de forma aleatoria*/
    public void MovimientoGlobos(){
                //GloAction
                Random r=new Random();
                Random r1X=new Random();
                Random r1Y=new Random();
                Random r2X=new Random();
                Random r2Y=new Random();
                Random r3X=new Random();
                Random r3Y=new Random();
                Random r4X=new Random();
                Random r4Y=new Random();
                Random r5X=new Random();
                Random r5Y=new Random();
                Random r6X=new Random();
                Random r6Y=new Random();
                int random1X=(int)(r1X.nextDouble()*20+0);
                int random1Y=(int)(r1Y.nextDouble()*20+0);
                int random2X=(int)(r2X.nextDouble()*20+0);
                int random2Y=(int)(r2Y.nextDouble()*20+0);
                int random3X=(int)(r3X.nextDouble()*20+0);
                int random3Y=(int)(r3Y.nextDouble()*20+0);
                int random4X=(int)(r4X.nextDouble()*20+0);
                int random4Y=(int)(r4Y.nextDouble()*20+0);
                int random5X=(int)(r5X.nextDouble()*20+0);
                int random5Y=(int)(r5Y.nextDouble()*20+0);
                int random6X=(int)(r6X.nextDouble()*20+0);
                int random6Y=(int)(r6Y.nextDouble()*20+0);
                while(matriz20X20[random1X][random1Y]!=null){
                    random1X=(int)(r1X.nextDouble()*20+0);
                    random1Y=(int)(r1Y.nextDouble()*20+0);
                                                            }
                while(matriz20X20[random2X][random2Y]!=null){
                    random2X=(int)(r2X.nextDouble()*20+0);
                    random2Y=(int)(r2Y.nextDouble()*20+0);
                                                            }
                while(matriz20X20[random3X][random3Y]!=null){
                    random3X=(int)(r3X.nextDouble()*20+0);
                    random3Y=(int)(r3Y.nextDouble()*20+0);
                                                            }
                while(matriz20X20[random4X][random4Y]!=null){
                    random4X=(int)(r4X.nextDouble()*20+0);
                    random4Y=(int)(r4Y.nextDouble()*20+0);
                                                            }
                while(matriz20X20[random5X][random5Y]!=null){
                    random5X=(int)(r5X.nextDouble()*20+0);
                    random5Y=(int)(r5Y.nextDouble()*20+0);
                                                            }
                while(matriz20X20[random6X][random6Y]!=null){
                    random6X=(int)(r6X.nextDouble()*20+0);
                    random6Y=(int)(r6Y.nextDouble()*20+0);
                                                            }
                
                JButton BC=new JButton();
                BC.setIcon(imagenGlobo);
                BC.setBounds(random1X,random1Y,27,24);
                
                JButton BD=new JButton();
                BD.setIcon(imagenGlobo);
                BD.setBounds(random2X,random2Y,27,24);
                
                JButton BE=new JButton();
                BE.setIcon(imagenGlobo);
                BE.setBounds(random3X,random3Y,27,24);
                
                JButton BF=new JButton();
                BF.setIcon(imagenGlobo);
                BF.setBounds(random4X,random4Y,27,24);
                
                JButton BG=new JButton();
                BG.setIcon(imagenGlobo);
                BG.setBounds(random5X,random5Y,27,24);
                
                JButton BH=new JButton();
                BH.setIcon(imagenGlobo);
                BH.setBounds(random6X,random6Y,27,24);
                
                
                
                
                
                
                
                
                while(GloAction==true){
                        int random=(int) (r.nextDouble()*4+0);
                        if(random==1){


                                     }
                        if(random==2){


                                     }
                        if(random==3){


                                     }
                        if(random==4){


                                     }
                                      }
                
                
                
    
    
    
                                    
                                   }
    /**
     * Se encarga de pintar la pantalla despues de poner la bomba*/
    public void Repintar(){
                //removeAll();
                /*Jugar j = new Jugar();
                j.setVisible(true);
                revalidate();*/
                repaint();
                for(int x=0;x<21;x++){
                    for(int y=0;y<21;y++){
                        if(matriz20X20[x][y]!=null){
                            if(matriz20X20[x][y].id=="B"){
                                   //Bloque B=new Bloque("B","/eventos/bloque_concreto.gif");
                                    JButton BC=new JButton();
                                    BC.setIcon(imagenBloqueConcreto);
                                    BC.setBounds(x*27,y*24,27,24);
                                    add(BC);
                                    repaint();
                            
                                                         }
                            else if(matriz20X20[x][y].id=="Bb"){
                                 
                                 bloqueBarrera=new JButton();
                                 bloqueBarrera.setIcon(imagenBloqueBarrera);  
                                 bloqueBarrera.setBounds(x*27,y*24,27,24);
                                 add(bloqueBarrera);
                                 repaint();
                                                                }
                        
                                                   }
                    
                                         }
                                     }
                
    
    
    
                          }
    /**
     * Esta funcion se encarga de  agregar los bloques a la pantalla*/
    public void CargarBloquesCemento(){
            int countBloques=0;
            for(int i=0;i<75*4;i++){
                Random r=new Random();
                int nrandomX=(int) (r.nextDouble()*21+2);
                int nrandomY=(int) (r.nextDouble()*21+2);
                for(int x=0;x<21;x++){
                        for(int y=0;y<21;y++){
                            if((x==nrandomX)&&(y==nrandomY)&& matriz20X20[nrandomX][nrandomY]==null){
                                countBloques++;
                                if(countBloques==76){
                                    return;
                                                    }
                                Bloque B=new Bloque("B","/eventos/bloque_concreto.gif");
                                JButton BC=new JButton();
                                BC.setIcon(imagenBloqueConcreto);
                                BC.setBounds(nrandomX*27,nrandomY*24,27,24);
                                this.add(BC);
                                matriz20X20[nrandomX][nrandomY]=B;
                                                                                                                                 }
                                            }
                                      } 
                                  }
                                      }
    int counter=0;
    
    /**
     * Esta funcion se encarga de mover el heroe por la pantalla con sus respectivas valdaciones*/ 
    public void Mover(){ 
         
            if((matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX+1][ejeY]==null)){
                System.out.println("Se puede mover derecha ");
                if(dx==27){
                      x+=dx;
                      ejeX++;
                          }
                                                                                                                                                          
             else if((matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY-1]==null)&&(matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX-1][ejeY]==null)){
                System.out.println("Se puede mover arriba y abajo izquierda");
                if((dx==-27)){
                    x+=dx;
                    ejeX--;
                             }
                else if (dy==-24){
                    y+=dy;
                    ejeY--;
                                 }
                else if(dy==24){
                    y+=dy;
                    ejeY++;
                               }
                                                                                                                                                                 }                                                                                                                                              }
            
            
            
            else if((matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX-1][ejeY]==null)){
                System.out.println("Se puede mover izquierda ");
                if(dx==-27){
                      x+=dx;
                      ejeX--;
                          }
                                                                                                                                                               }                 
            else if((matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX-1][ejeY]==null)){
                System.out.println("Se puede mover derecha y izquierda");
                if((dx==27)){
                    x+=dx;
                    ejeX++;
                            }
                else if((dx==-27)){
                    x+=dx;
                    ejeX--;    
                                   }

                                                                                                                                                                } 
            
            else if((matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX-1][ejeY]==null)&&(matriz20X20[ejeX+1][ejeY]==null) ){
                System.out.println("Se puede mover derecha  izquierda y abajo");
                if((dy==24)){
                    y+=dy;
                    ejeY++;
                            }
                else if(dx==27){
                    x+=dx;
                    ejeX++;    }
                else if(dx==-27){
                    x+=dx;
                    ejeX--;
                                }
                                                                                                                                                                }

            else if((matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX][ejeY+1]==null)){
                System.out.println("Se puede mover derecha y abajo");
                if((dx==27)){
                    x+=dx;
                    ejeX++;
                            }
                else if((dy==24)){
                    y+=dy;
                    ejeY++;      }
                                                                                                                                                                }
            else if((matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                   System.out.println("Se puede mover derecha y arriba");
                   if((dx==27)){
                       x+=dx;
                       ejeX++;
                               }
                   else if((dy==-24)){
                       y+=dy;
                       ejeY--;
                                     }
                                                                                                                                                                }
            else if((matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX][ejeY-1]==null)&&(matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX-1][ejeY]==null)){
                System.out.println("Se puede mover arriba derecha y izquierda");
                if((dy==-24)){
                    y+=dy;
                    ejeY--; }
                else if(dx==27){
                    x+=dx;
                    ejeX++;
                               }
                else if(dx==-27){
                    x+=dx;
                    ejeX--;
                                }
                                                                                                                                                                }
            else if((matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                System.out.println("Se puede mover derecha y abajo y arriba");
                if((dy==24)){
                    System.out.println("entro1");
                    y+=dy;
                    ejeY++;
                            }
                else if((dy==-24)){
                    System.out.println("entro2");
                    y+=dy;
                    ejeY--;

                                  }
                else if((dx==27)){
                    System.out.println("Check");
                    x+=dx;
                    ejeX++;
                                 }

                                                                                                                                                                 }
            else if((matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY+1]==null)){
                System.out.println("Se puede mover abajo");
                if(dy==24){
                    y+=dy;
                    ejeY++;
                          }
                                                                                                                                                                }
            else if((matriz20X20[ejeX][ejeY-1]!=null)&&(matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX-1][ejeY]==null)&&(matriz20X20[ejeX][ejeY+1]==null)){
                   System.out.println("Se puede mover izquierda y abajo");   
                   if((dx==-27)){
                        x+=dx;
                        ejeX--;
                                }
                   else if(dy==24){
                        y+=dy;
                        ejeY++;
                                   }
                                                                                                                                                               }
            else if((matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                System.out.println("Se puede mover arriba y abajo");
                if((dy==24)){
                   y+=dy;
                   ejeY++;
                             }
                else if((dy==-24)){
                   y+=dy;
                   ejeY--;
                                  }

                                                                                                                                                               }
            else if((matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX-1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                System.out.println("Se puede mover  arriba");
                if(dy==-24){
                    y+=dy;
                    ejeY--;
                           }
                                                                                                                                                                }


            else if((matriz20X20[ejeX+1][ejeY]!=null)&&(matriz20X20[ejeX][ejeY+1]!=null)&&(matriz20X20[ejeX-1][ejeY]==null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                System.out.println("Se puede mover izquierda y arriba");
                if((dx==-27)){
                    x+=dx;
                    ejeX--;
                             }
                else if(dy==-24){
                    y+=dy;
                    ejeY--;
                                }

                                                                                                                                                               }
            else if((matriz20X20[ejeX+1][ejeY]==null)&&(matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX-1][ejeY]==null)&&(matriz20X20[ejeX][ejeY-1]==null)){
                if((dx==27)){
                    x+=dx;
                    ejeX++;
                              }
                if((dx==-27)){
                    x+=dx;
                    ejeX--;
                              }
                
                if(dy==24){
                    y+=dy;
                    ejeY++;
                
                          }
                if(dy==-24){
                    y+=dy;
                    ejeY--;
                
                           }
                
                
            
                                                                                                                                                                }
            else if((matriz20X20[ejeX][ejeY+1]==null)&&(matriz20X20[ejeX][ejeY-1]==null)&&(matriz20X20[ejeX-1][ejeY]==null)&&(matriz20X20[ejeX+1][ejeY]!=null)){
                System.out.println("Se puede mover izquierda arriba abajo ");
                if(dx==-27){
                      x+=dx;
                      ejeX--;
                          }
                if(dy==-24){
                      y+=dy;
                      ejeY--;
                          }
                if(dy==24){
                      y+=dy;
                      ejeY++;
                          }
                                                                                                                                                                }
           
                           
             
                        }
             
    /**
     * Se encarga de cargar los bloque barrera al JFrame*/
   public void CargarMatrizGraficaB(){ 
        for(int x=0;x<21;x++){
            for(int y=0;y<21;y++){
               if((x%2==0)&&(y%2==0)&&((x!=19)&&(x!=0)&&(x!=1)&&(x!=20))){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
                                                                         }
               if((y==0)||(y==20)){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
               
                                  }
               if((x==0)){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
                         }
               if(x==20){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
                        }
               if((x==1)&&(y==0)||(y==20)){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
                                          }
               if((x==19)&&(y==0)||(y==20)){
                   bloqueBarrera=new JButton();
                   bloqueBarrera.setIcon(imagenBloqueBarrera);  
                   bloqueBarrera.setBounds(x*27,y*24,27,24);
                   this.add(bloqueBarrera);
                                           }
               
                                     }
                             }
    
    
    
    
                                      }       

      
       
        void Imprimirmatrizlogica(){
                String matrixCon="";
                for(int x=0;x<22;x++){
                    System.out.println(matrixCon+"\n");
                    matrixCon="";
                    for(int y=0;y<21;y++){
                        if(matriz20X20[x][y].equals(Element.class)==true){
                               matrixCon+=matriz20X20[x][y].id+",";
                                                                         }
                        
                    
                                        }
                                     }
        
                                   }
       
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
          
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
       
    }//GEN-LAST:event_formKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  

  

 
  

}

