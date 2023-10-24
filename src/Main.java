import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner kk= new Scanner(System.in);
        System.out.println("Bienvenida a mi programa para la creacion de un grafo");
        int numVertices;
        int opc;
        ArrayList<String> cont= new ArrayList<>();
        System.out.println("Da el numero de vertices maximo");
        numVertices= kk.nextInt();
        kk.nextLine();
        GrafoMatriz grafo1=new GrafoMatriz(numVertices);
        Vertice vert;
        do{
            System.out.println("Digita la opcion que deseas hacer:" +"\n 1.Agregar vertice"+"\n 2.Añadir arco" +"\n 3.Buscar adyacencia" +"\n 4.Comprobar camino "+"\n 5.Recorrido BFS  "  +"\n 6.Recorrido por dfs" +"\n 7.Salir");
            opc= kk.nextInt();
            kk.nextLine();
            switch (opc){
                case 1:
                    System.out.print("Da el contenido del vertice");
                    String ver= kk.nextLine();
                    grafo1.AddVertex(ver);
                    break;
                case 2:
                    System.out.println("Da el nodo origen");
                    String or= kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String dest= kk.nextLine();
                    grafo1.newArco(or,dest);
                    System.out.println("Arco creado");
                    break;
                case 3:
                    System.out.println("Da el nodo origen");
                    String origin= kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String destt= kk.nextLine();
                    grafo1.adyacente(origin,destt);
                    if(grafo1.adyacente(origin,destt)==true){
                        System.out.println("Hay camino");
                    }
                    else{
                        System.out.println("No hay camino");
                    }
                    break;
                case 4:
                    System.out.println("da el nodo origen ");
                    String o= kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String d= kk.nextLine();
                    grafo1.existeCamino(o,d);
                    if (grafo1.existeCamino(o, d)==true) {
                        System.out.println("Hay camino");
                    }
                    else {
                        System.out.println("There´s no way!");
                    }
                    break;
                case 5:
                    System.out.println("Dame el vertice por el cual quieres partir ");
                    String vo= kk.nextLine();
                    cont= grafo1.bfs(vo);
                    System.out.println("Este es el recorrido ");
                    for(int i=0; i<cont.size();i++){
                        System.out.println(vo +"-->" + cont.get(i));
                    }
                  break;
                case 6:
                    System.out.println("Da el vertice del cual quieres partir ");
                    String vor= kk.nextLine();
                    cont=grafo1.dfs(vor);
                    System.out.println("Este es el reccorrido ´por dfs");
                    for(int i=0; i< cont.size(); i++)
                    {
                        System.out.println(vor +"-->" +cont.get(i));
                    }
                    break;
                case 7:
                    System.out.println("Saliedno...");
                    break;
                default:
                    System.out.println("Ingresa una opcion correcta");
            }

        }while (opc!=7);
    }
}