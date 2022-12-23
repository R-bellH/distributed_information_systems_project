import java.net.*;
import java.util.*;
import java.io.*;
public class ExManager {
    private String path;
    private num_of_nodes;
    // your code here

    public ExManager(String path){
        this.path = path;
        nodes = new Hashtable<>();
        // your code here
    }

    public Node get_node(int id){
        // your code here
    }

    public int getNum_of_nodes() {
        return num_of_nodes;
    }

    public void update_edge(int id1, int id2, double weight){
        Node n1 = get_node(id1);
        Node n2 = get_node(id2);
        n1.update(id2,weight);
        n2.update(id1,weight);
    }

    public void read_txt() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String num_nodes=scanner.nextLine();
        num_of_nodes= Integer.parseInt(num_nodes);
        for (int i = 0; i < num_of_nodes; i++) {
            String line=scanner.nextLine();
            String[] parts = line.split(" ");
            int nodeNum = Integer.parseInt(parts[0]);
            Hashtable<Integer,Hashtable<String,String>> neighbors = new Hashtable<>();
            for(int j = 1; j < parts.length;j+=4){
                int neighbor_id= Integer.parseInt(parts[j]);
                Hashtable<String,String> neighbor= new Hashtable<>();
                neighbor.put("weight",parts[j+1]);
                neighbor.put("send_port",parts[j+2]);
                neighbor.put("listen_port",parts[j+3]);
                neighbors.put(neighbor_id,neighbor);
            }
            Node node = new Node(nodeNum,neighbors,num_of_nodes);
            nodes.put(nodeNum,node);

            }
    }

    public void start(){
        for (int i = 1; i <= num_of_nodes; i++) {
            Node n = get_node(i);
            n.start();
        }
    }
}
