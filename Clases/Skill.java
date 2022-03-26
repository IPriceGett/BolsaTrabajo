public class Skill {
    private int id;
    private String nombre;

    public Skill(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
