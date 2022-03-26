
public class Empresa {
    private String nombre;
    private Area[] areas;

    public Empresa(String nombre, int numeroAreas){
        this.nombre = nombre;
        this.areas = new Area[numeroAreas];
    }

    public String getNombre(){
        return this.nombre;
    }

    public Area getArea(int indice){
        return this.areas[indice];
    }

    public Area[] getAreas(){
        return this.areas;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNewArea(Area area){
        int cont = 0;
        while( this.areas[cont] != null) cont++;
        this.areas[cont] = area;
    }
}
