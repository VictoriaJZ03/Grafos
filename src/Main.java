
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner kk= new Scanner(System.in);
        System.out.println("Bienvenida a mi programa para la creacion de un grafo");
        int numVertices;
        int opc;
        ArrayList<String> cont;
        System.out.println("Da el numero de vertices maximo");
        numVertices= kk.nextInt();
        kk.nextLine();
        GrafoMatriz grafo1=new GrafoMatriz(numVertices);
        do{
            System.out.println("""
                    Digita la opcion que deseas hacer:
                     1.Agregar vertice
                     2.Añadir arco
                     3.Buscar adyacencia
                     4.Comprobar camino\s
                     5.Recorrido BFS \s
                     6.Recorrido por dfs
                     7.Salir""");
            opc= kk.nextInt();
            kk.nextLine();
            switch (opc) {
                case 1 -> {
                    System.out.print("Da el contenido del vertice");
                    String ver = kk.nextLine();
                    grafo1.AddVertex(ver);
                }
                case 2 -> {
                    System.out.println("Da el nodo origen");
                    String or = kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String dest = kk.nextLine();
                    grafo1.newArco(or, dest);
                    System.out.println("Arco creado");
                }
                case 3 -> {
                    System.out.println("Da el nodo origen");
                    String origin = kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String destt = kk.nextLine();
                    grafo1.adyacente(origin, destt);
                    if (grafo1.adyacente(origin, destt)) {
                        System.out.println("Hay camino");
                    } else {
                        System.out.println("No hay camino");
                    }
                }
                case 4 -> {
                    System.out.println("da el nodo origen ");
                    String o = kk.nextLine();
                    System.out.println("Da el nodo destino");
                    String d = kk.nextLine();
                    grafo1.existeCamino(o, d);
                    if (grafo1.existeCamino(o, d)) {
                        System.out.println("Hay camino");
                    } else {
                        System.out.println("There´s no way!");
                    }
                }
                case 5 -> {
                    System.out.println("Dame el vertice por el cual quieres partir ");
                    String vo = kk.nextLine();
                    cont = grafo1.bfs(vo);
                    System.out.println("Este es el recorrido ");
                    for (String s : cont) {
                        System.out.println(vo + "-->" + s);
                    }
                }
                case 6 -> {
                    System.out.println("Da el vertice del cual quieres partir ");
                    String vor = kk.nextLine();
                    cont = grafo1.dfs(vor);
                    System.out.println("Este es el reccorrido ´por dfs");
                    for (String s : cont) {
                        System.out.println(vor + "-->" + s);
                    }
                }
                case 7 -> System.out.println("Saliedno...");
                default -> System.out.println("Ingresa una opcion correcta");
            }

        }while (opc!=7);
    }
}