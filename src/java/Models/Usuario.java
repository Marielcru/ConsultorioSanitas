package Models;

public class Usuario {
  
    private int id;
    private int rol;
    private String name=null;
    private String contrasenia=null;
    
    public Usuario(int idrol,String name,String contrasenia){
        this.rol=idrol;
        this.name=name;
        this.contrasenia=contrasenia;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getidrol(){
        return rol;
    }
    
    public void setidrol(int idrol){
        this.rol=idrol;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
} 
