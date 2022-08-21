package Models;

public class Usuario {
  
    private int id;
    private String rol=null;
    private String name=null;
    private String contrasenia=null;
    
    public Usuario(String rol,String name,String contrasenia){
        this.rol=rol;
        this.name=name;
        this.contrasenia=contrasenia;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getRol(){
        return rol;
    }
    
    public void setRol(String rol){
        this.rol=rol;
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
