import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    HashMap<Character, String> encoder = new HashMap<>();
    HashMap<String, Character> decoder = new HashMap<>();

    private class Node implements Comparable<Node> {

        Character key;
        int count;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.key = data;
            this.count = cost;
            this.left = null;
            this.right = null;

        }

        @Override
        public int compareTo(Node other) {
            return this.count - other.count;
        }

    }

    public Huffman(String input) {
        HashMap<Character, Integer> fMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Map=" + fMap);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
            minHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (minHeap.size() != 1) {
            Node firNode = minHeap.poll();
            Node secNode = minHeap.poll();

            Node merged = new Node(null, firNode.count + secNode.count);
            merged.left = firNode;
            merged.right = secNode;
            minHeap.add(merged);

        }
        Node fullTreeRoot = minHeap.poll();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(fullTreeRoot, "");
    }

    private void initEncoderDecoder(Node fullTreeRoot, String output) {
        if (fullTreeRoot == null) {
            return;
        }
        if (fullTreeRoot.left == null && fullTreeRoot.right == null) {
            encoder.put(fullTreeRoot.key, output);
            decoder.put(output, fullTreeRoot.key);
        }
        initEncoderDecoder(fullTreeRoot.left, output + "0");
        initEncoderDecoder(fullTreeRoot.right, output + "1");

    }

    public String encode(String source) {
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String encodedString) {
        String key = "";
        String ans = "";
        for (int i = 0; i < encodedString.length(); i++) {
            key = key + encodedString.charAt(i);
            if (decoder.containsKey(key)) {
                ans = ans + decoder.get(key);
                key = "";
            }

        }
        return ans;

    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        }
    }

}
