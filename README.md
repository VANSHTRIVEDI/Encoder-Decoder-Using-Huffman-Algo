**Huffman Coding Implementation in Java**

This repository contains a Java implementation of Huffman coding, a popular algorithm used for lossless data compression.


**Overview**

Huffman coding works by assigning variable-length codes to input characters, where the length of each code depends on the character's frequency of occurrence in the input data. This implementation includes methods to encode and decode messages using Huffman coding, as well as utilities for file input/output operations.


**How Huffman Coding Works**

The Huffman Algorithm works by creating a binary tree of nodes, where each node represents a character in the file and its frequency of occurrence. Here’s a simplified process:

Frequency Calculation: Calculate the frequency of each character in the file.

Priority Queue: Insert all characters into a priority queue based on their frequencies.

Tree Construction: Construct a binary tree by repeatedly combining the two least frequent nodes until a single tree remains.

Code Assignment: Assign binary codes to each character by traversing the tree. Characters with higher frequencies get shorter codes.

Encoding and Decoding: Use these codes to encode the file into a compressed format and decode it back to the original format when needed.


**Features**

Encoder and Decoder: Efficient encoding and decoding of messages using Huffman coding.

File I/O: Methods for reading input from files, encoding the data, and writing the encoded data to files.

Priority Queue: Utilizes Java's PriorityQueue for constructing the Huffman tree.
