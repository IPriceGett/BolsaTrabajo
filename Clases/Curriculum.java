public class Curriculum extends Persona{
    private Skill[] skills;
    private int añosExperiencia;
    private String instituto;

    public Curriculum(int añosExperiencia, String instituto, Skill[] skills, String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.añosExperiencia = añosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public String getInstituto(){
        return this.instituto;
    }

    public int getAñosExperiencia(){
        return this.añosExperiencia;
    }

    public Skill[] getSkills(){
        return this.skills;
    }

    public void setInstituto(String instituto){
        this.instituto = instituto;
    }

    public void setAñosExperiencia(int añosExperiencia){
        this.añosExperiencia = añosExperiencia;
    }

    public void setSkills(Skill[] skills){
        this.skills = skills;
    }
}
