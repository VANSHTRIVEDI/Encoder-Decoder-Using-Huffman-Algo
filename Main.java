import java.io.IOException;

public class Main {

    // using string

    // public static void main(String[] args) {
    // String input = "vanshtrivediharajabcjab";
    // Huffman ed = new Huffman(input);
    // String encodedString = ed.encode(input);
    // System.out.println(encodedString);
    // String decodedString = ed.decode(encodedString);
    // System.out.println(decodedString);

    // if (input.equals(decodedString)) {
    // System.out.println("true");
    // }

    // }

    // using file
    public static void main(String[] args) {
        try {
            String inputFilePath = "C://Users//Vansh//Desktop//myname.txt";
            String encodedFilePath = "C://Users//Vansh//Desktop//myname.encoded.txt";
            String decodedFilePath = "C://Users//Vansh//Desktop//myname.decoded.txt";

            // Read input from file
            String input = Huffman.readFile(inputFilePath);

            // Initialize Huffman coding with input
            Huffman huffman = new Huffman(input);

            // Encode the input and write to encoded file
            String encodedString = huffman.encode(input);
            System.out.println(encodedString);
            Huffman.writeFile(encodedFilePath, encodedString);

            // Read encoded file
            String encodedInput = Huffman.readFile(encodedFilePath);

            // Decode the encoded string and write to decoded file
            String decodedString = huffman.decode(encodedInput);
            Huffman.writeFile(decodedFilePath, decodedString);

            // Verify if the decoded string matches the original input
            if (input.equals(decodedString)) {
                System.out.println("The decoded string matches the original input Verification successful!");
            } else {
                System.out.println("The decoded string does not match the originalinput.Verification failed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
