package Clases;

public final class LoginLunandina {

    private String usuario;
    private String contraseña;
    private String estado;
    private String cargo;
    private String nomEmp;
    
    Controlador control=new Controlador();

    @SuppressWarnings("empty-statement")
    public LoginLunandina(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = DevolverDato("estado");
        this.cargo = DevolverDato("cargo");
        this.nomEmp = DevolverDato("concat(apellidos,', ', nombres)");
    }
    
    public String getEstado()  { return estado;}
    public String getUsuario() {return usuario;}
    public String getCargo()   {return cargo;}
    public String getnomEmp()  {return nomEmp;}
        
    public boolean VerifUsuario(){ //Verifica si existe un usuario
        return control.Verficnst("SELECT * FROM vw_empleados WHERE username = '"+usuario+"';");
    }
    public boolean VerifCredenciales(){
        return control.Verficnst("SELECT * FROM vw_empleados WHERE username = '"+usuario+"' AND psw=md5('"+contraseña+"');");
    }  
    public String DevolverDato(String dato){
        return control.DevolverRegistroDto("SELECT "+dato+" FROM vw_empleados WHERE username = '"+usuario+"' AND psw=md5('"+contraseña+"');", 1);
    }
    
}
