/*
 * Student ID UOW: w2052233
 * Student ID IIT: 20232192
 * Name: RamudiMunasinghe
 */

package w2052233;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Read the network from a file
        String filename = "benchmarks/network_5.txt"; // Example filename
        FlowNetwork network = readNetworkFromFile(filename);

        // Create the Ford-Fulkerson algorithm object
        FordFulkerson fordFulkerson = new FordFulkerson(network);

        // Calculate the maximum flow from source (0) to sink (last node)
        int maxFlow = fordFulkerson.calculateMaxFlow(0, network.size() - 1);
        System.out.println("Maximum Flow: " + maxFlow);
    }

    private static FlowNetwork readNetworkFromFile(String filename) {
        FlowNetwork network = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(br.readLine());
            network = new FlowNetwork(n);

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int from = Integer.parseInt(parts[0]);
                    int to = Integer.parseInt(parts[1]);
                    int capacity = Integer.parseInt(parts[2]);
                    network.addEdge(from, to, capacity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return network;
    }
}
