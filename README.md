# Decodage-Huffman  
This Huffman Project is a java project in order to decompress data with the Huffman Algorithm.  
A graphic interface make the visual result easier.  

## Table of Contents
1. [How to install](#How-to-install)  
2. [Usage](#Usage)  
3. [Milestones of the project](#Milestones-of-the-project)  
4. [Execution](#Execution)  

## Made with  
* ![Java](#https://www.java.com/fr/)  
* ![Eclipse - Java IDE](#https://www.eclipse.org/)

## How to install  
Clone the repository : 
```
git clone https://github.com/clement-massit/Decodage-Huffman
```  

## Usage
The program needs two kind of files : 
* file with compressed text (011010010001111)
* file with the alphabet and frequences  
  
  
It can be txt files.  
Launch the application and click on 'open' button.  
You have to open the compressed file first. Then a second file chooser window will be opened and you have to choose the frequences file.
Finally you will see on the frame all information concerning the decompression of the file. 

## Milestones of the project  
1. Learn about the Huffman Algorithm
2. Think about all different classes
3. Implement the main structure of the project
4. Open & read files (content, frequences, characters)
5. Implements Nodes structure
6. Huffman Tree implementation (based on frequences of characters)
7. How to run through the Huffman Tree in order to obtain the decompression of compressed text
8. Write the decompressed text in a file 
9. Implement a graphic interface in order to make a visual result  

## Execution  
__*1st step*__ open a file contains a binary chain  
```
010111000111100101
```

__*2nd step*__ open a file contains the frequences and alphabet  
```
6
b 1
j 1
n 1
u 1
r 1
o 2
```
__*3rd step*__ tree creation   
The program will create the following Huffman tree :  
![image](https://user-images.githubusercontent.com/72502592/121139006-934db800-c838-11eb-8d80-5ff602e2bd44.png)  

__*4th step*__ decompress the message  
Then the program will read through the previous tree, and return the text decompressed 
```
bonjour
```  
## Authors
MASSIT Clément alias @clement-massit  
Read the list of contributors to see who helped with the project!


