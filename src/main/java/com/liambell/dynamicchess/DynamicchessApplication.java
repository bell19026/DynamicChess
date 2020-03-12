package com.liambell.dynamicchess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicChessApplication {

    public static void main(String[] args) {SpringApplication.run(DynamicChessApplication.class, args);
    }

}

/*
Model - Logic. Classes that are used to assign properties to things.
View - Front End or Web Browser
Controller - Mediator between Model and the View

View -> Hey controller, I moved a chess piece from E3 to G5;
Controller -> Hey Model, I just got this information about the View moving a piece from E3 to G5;
Model -> Hold up, lemme do some math. I'll get back to you.
Model -> here is my updated information from the back.
Controller -> Hey View, my main man Model just gave me this.
View -> Hey browser, show this information that is current.

 */