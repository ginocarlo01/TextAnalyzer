# Java Text Analyzer

<a name="visao-geral"></a>
## ✔️ Project Overview  

The objective of this project is to develop a Java program for preprocessing text files, preparing them for analysis as digraphs using the open-source software Gephi. The program should accept a list of plain text files (.txt) as command-line input and generate output in .csv format, containing adjacency lists indicating word succession for the construction of digraphs.

Code files can be found on TextAnalyser\src\main\java\MainPackage

<a name="visao-geral"></a>
## ✔️ Key Features:

-Each word in the text is treated as a unique node in the digraph.
-Node A has an edge to node B if and only if the word represented by B follows the word represented by A in the text.
-Punctuation marks, quotes, hyphens, and similar characters are removed, while all text is converted to lowercase.
-Each word appears only once as the starting word of a line, sorted alphabetically.
-The list of destinations may consist of one or more words, without repetition in the same line.

<a name="colaboradores"></a>
## 👨‍💻 Team
[Gino Carlo]

