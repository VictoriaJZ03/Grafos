public class Vertice {
    String nombre;
    int numVertex;
    public Vertice(String x){
        nombre= x;
        numVertex=-1; //Al principio no hay vertices

    }
    public String getNombre(){
        return nombre;
    }
    public void asigVertex(int n){
        numVertex=n;
    }
    public boolean equals(Vertice n) // true, si dos vértices son iguales
    {
        return nombre.equals(n.nombre);
    }
    public String toString() // características del vértice
    {
        return nombre + " (" + numVertex + ")";
    }

}
