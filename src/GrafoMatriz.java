
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoMatriz {
    int numVerts;
    static int maxVerts=20;
    Vertice verts[];
    int matAd[][];
    public GrafoMatriz(){
        this(maxVerts);
    }
    public GrafoMatriz(int mx){
        matAd= new int[mx][mx];
        verts= new Vertice[mx];
        for(int i=0; i<mx; i++){
            for(int j=0; j<mx; j++){
                matAd[i][j]=0;
                numVerts=0;
            }
        }
    }
    public void AddVertex(String n){
        boolean esta= numVer(n)>=0;
        if(esta!=false){
            Vertice v= new Vertice(n);
            v.asigVertex(numVerts);
            verts[numVerts++]=v;

        }

    }

    int numVer(String vs)
    {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;)
        {
            encontrado = verts[i].equals(v);
            if (!encontrado) i++ ;
        }
        return (i < numVerts) ? i : 1 ;
    }
    public void newArco(String a, String b){
        int va, vb;
        va= numVer(a);
        vb= numVer(b);
        matAd[va][vb]=1;
    }
public boolean adyacente(String a, String b){
        boolean ad= false;
        int va,vb;

        va = numVer(a);
        vb= numVer(b);
        return matAd[va][vb]==1;
}

    public boolean existeCamino(String origen, String destino) {
        int va = numVer(origen);
        int vb = numVer(destino);
        boolean visitados[] = new boolean[numVerts];
        return existeCaminoDFS(va, vb, visitados);
    }

    private boolean existeCaminoDFS(int va, int vb, boolean visitados[]) {
        if (va == vb) {
            return true; // Encontramos un camino
        }

        visitados[va] = true;

        for (int i = 0; i < numVerts; i++) {
            if (matAd[va][i] == 1 && !visitados[i]) {
                if (existeCaminoDFS(i, vb, visitados)) {
                    return true; // Encontramos un camino a través de este nodo
                }
            }
        }

        return false; // No se encontró un camino
    }
public ArrayList<String> bfs(String or)
    {
ArrayList<String> orden= new ArrayList<>(); //Nos va a devolver el orden ene l que se visitan los arcos
ArrayList<String> visitados= new ArrayList<>(); // Vamos a guardar los nodos que ya hemos visitado, para no volverlo a visitar
Queue<String> cola= new LinkedList<>(); // vamos a gyardar nuestros arcos en una estructura de tipo coia para hacer el recorrido del grafo
visitados.add(or);// Añadimos el vertice del cual vamos a partir
cola.add(or);// igualmente niuestro primer elemento nos indica desde donde partimos
while(!cola.isEmpty()){
    String actual= cola.poll(); //Sacamos un elemento de la cola siempre y cuando esta aun tenga
    orden.add(actual);
    int vac=numVer(actual);

        for(int i=0; i<numVerts; i++){
            if(matAd[vac][i]==1) {
                String dest = verts[i].getNombre();
                if (!visitados.contains(dest)) {
                    visitados.add(dest);
                    cola.offer(dest);
                }
            }
        }
}
return orden;
    }




    public ArrayList<String> dfs(String or)
    {
        ArrayList<String> orden= new ArrayList<>(); //Nos va a devolver el orden ene l que se visitan los arcos
        ArrayList<String> visitados= new ArrayList<>(); // Vamos a guardar los nodos que ya hemos visitado, para no volverlo a visitar
        Stack<String> pila= new Stack<>(); // vamos a gyardar nuestros arcos en una estructura de tipo coia para hacer el recorrido del grafo
        visitados.add(or);// Añadimos el vertice del cual vamos a partir
        pila.add(or);// igualmente niuestro primer elemento nos indica desde donde partimos
        while(!pila.isEmpty()){
            String actual= pila.pop(); //Sacamos un elemento de la cola siempre y cuando esta aun tenga
            orden.add(actual);
            int vac=numVer(actual);

            for(int i=0; i<numVerts; i++){
                if(matAd[vac][i]==1) {
                    String dest = verts[i].getNombre();
                    if (!visitados.contains(dest)) {
                        visitados.add(dest);
                        pila.push(dest);
                    }
                }
            }
        }
        return orden;
    }

}

