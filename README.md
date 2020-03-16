# DynamicChess
To demonstrate Object-oriented competency, I'm working on a version of chess that will incorporate the ability to create new pieces, 
as well as have new preset pieces with their own calculated ranking values. The goal is to enable network based multiplayer, 
as well as a minimax approach to an AI player. This solution is being built using the Spring Framework, primarily for the built 
in Inversion of Control capabilities. My end-goal with this will be a fully functional dynamic version of chess, built without 
any reference documentation, not including the minimax algorithm wikipedia page.

I've incorporated some key Java 8 functionality, primarily the use of Streams and lambda functions for arbitrary iteration. 
It's reduced the amount of boilerplate code, as well as increased readability.

Currently, this project does not have a front-end, as I am prioritizing main functionality before user interface. There are two endpoints
currently. "createBoard" is used to initialize a board. The reason this is an endpoint is for later custom board functionality. The second 
endpoint is "movePieces". This endpoint takes in a header parameter, with 4 numbers. These four numbers are passed through JSON as a string,
then are converted into individual coordinates in the web server itself. This is to make POSTMan testing less tedious with multiple header parameters.

This project uses Maven as the package management system. To build, please run the following command in command-line within the project directory:
-clean mvn install

This will bootup the server on your localhost:8080. On createBoard, the board will be shown within the command line, and will update every time a piece moves.

Current functionality includes the movement of pieces in their correct rule bound paths, until the point that a movement will put the current pieces allied King
in check.
