package model;

public class usuarioModel {

   private String oldAlias;
   private String alias;
   private String nombreUsua;
   private String apellidoUsua;
   private String emailUsua;
   private long   celular;
   private String contrasenia;
   private String fechaUsua;
   
   public usuarioModel(){}
   
   public usuarioModel(String alias, String nombreUsua, String apellidoUsua, String emailUsua,
           String celular, String contrasenia, String fechaUsua){
       this.alias        = alias;
       this.nombreUsua   = nombreUsua;
       this.apellidoUsua = apellidoUsua;
       this.emailUsua    = emailUsua;
       this.celular      = Long.parseLong(celular);
       this.contrasenia  = contrasenia;
       this.fechaUsua    = fechaUsua;
   }
    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the nombreUsua
     */
    public String getNombreUsua() {
        return nombreUsua;
    }

    /**
     * @param nombreUsua the nombreUsua to set
     */
    public void setNombreUsua(String nombreUsua) {
        this.nombreUsua = nombreUsua;
    }

    /**
     * @return the apellidoUsua
     */
    public String getApellidoUsua() {
        return apellidoUsua;
    }

    /**
     * @param apellidoUsua the apellidoUsua to set
     */
    public void setApellidoUsua(String apellidoUsua) {
        this.apellidoUsua = apellidoUsua;
    }

    /**
     * @return the emailUsua
     */
    public String getEmailUsua() {
        return emailUsua;
    }

    /**
     * @param emailUsua the emailUsua to set
     */
    public void setEmailUsua(String emailUsua) {
        this.emailUsua = emailUsua;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return Long.toString(celular);
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = Long.parseLong(celular);
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the fechaUsua
     */
    public String getFechaUsua() {
        return fechaUsua;
    }

    /**
     * @param fechaUsua the fechaUsua to set
     */
    public void setFechaUsua(String fechaUsua) {
        this.fechaUsua = fechaUsua;
    }
    
    public String getOldAlias() {
        return oldAlias;
    }

    public void setOldAlias(String oldAlias) {
        this.oldAlias = oldAlias;
    }
   
   @Override
    public String toString(){
        return this.alias + this.nombreUsua + this.apellidoUsua + this.emailUsua +
                this.celular + this.contrasenia + this.fechaUsua;
    }
    
    public Object[] toArray(){
        Object[] data = {alias, nombreUsua, apellidoUsua, emailUsua, celular, contrasenia, fechaUsua};
        return data;
    }
}
