package Clases;

public class Area {
    private String nombre;
    private int vacantes;
    private int total;
    private Skill[] skills;
    private Curriculum[] contratados;
    private Curriculum[] postulantes;

    public Area(String nombre, int vacantes, int total, Skill[] skills, int maximoPostulantes){
        this.nombre = nombre;
        this.vacantes = vacantes;
        this.total = total;
        this.contratados = new Curriculum[total];
        this.postulantes = new Curriculum[maximoPostulantes];
        this.skills = skills;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getVacantes(){
        return this.vacantes;
    }

    public Skill[] getSkills(){
        return this.skills;
    }

    public Skill getSkill(int numeroSkill){
        return this.skills[numeroSkill];
    }

    public Curriculum[] getPostulantes(){
        return this.postulantes;
    }

    public Curriculum[] getContratados(){
        return this.contratados;
    }

    public int getPuestosTotales(){
        return this.total;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setVacantes(int vacantes){
        this.vacantes = vacantes;
    }

    public void setSkills(Skill[] skills){
        this.skills = skills;
    }

    public void setContratados(Curriculum[] contratados){
        this.contratados = contratados;
    }

    public void setPostulantes(Curriculum[] postulantes){
        this.postulantes = postulantes;
    }

}
