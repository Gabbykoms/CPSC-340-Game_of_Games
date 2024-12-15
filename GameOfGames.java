import java.util.*;


class GameOfGames{
    public static void main(String args[]){

        //creating the input object to take inputs from the user
        Scanner myInput = new Scanner(System.in);

        String welcomeMessage = "Welcome to the Game of Games! \nPlease select a game to play by typing its name \n(Game Options: FindTheThimble’, ‘Even-Odd’, ‘RedThreadGame’, ‘CoinFlipGame’, ‘GuessTheNumber’). To quit, Type ‘Quit’:";
        System.out.println(welcomeMessage);
        Boolean loopCondition = true;
        String response;

        float p1_total_losses = 0; 
        float p1_total_wins = 0;
        float p2_total_wins = 0; 
        float p2_total_losses = 0;

        // String[] games = {"RedThreadGame", "CoinFlipGame", "FindTheThimble", "GuessTheNumber", "Even-Odd"} ;
        String chosenGameMessage1 = "You chose ";
        String chosenGameMessage2 = " Loading the game...";

        System.out.print("select a game by typing out the game name : ");
        String gameToPlay = myInput.nextLine();


        //condition to cause the loop to terminate
        if(gameToPlay.equalsIgnoreCase("quit")){
            loopCondition = false;

            //if the user wants to quit, we just return overall results
            System.out.println("display the results here");
        }


        while (loopCondition){
            // if(!gameToPlay.equalsIgnoreCase("quit")){

                    System.out.println(chosenGameMessage1+gameToPlay+chosenGameMessage2);


                    //Integrated successfully!
                    if (gameToPlay.trim().equalsIgnoreCase("RedThreadGame")){
                        System.out.println("I am creating the game object for you..");
                        RedThreadGame redObj = new RedThreadGame();
                        redObj.play();
                        p2_total_losses += redObj.computerLoss();
                        p2_total_wins += redObj.computerWins();

                        p1_total_losses += redObj.player1Loss();
                        p1_total_wins +=redObj.player1Wins();
                    }

                    //Integrated successfully!
                    else if (gameToPlay.trim().equalsIgnoreCase("CoinFlipGame")){
                        System.out.println("I am creating the game object");
                        CoinFlipGame coinObj = new CoinFlipGame();
                        coinObj.start();
                        p2_total_losses += coinObj.computerLoss();
                        p2_total_wins += coinObj.computerWins();

                        p1_total_losses += coinObj.player1Loss();
                        p1_total_wins +=coinObj.player1Wins();
                        
                    }

                    //Thimbles game integrated successfully!
                    else if (gameToPlay.trim().equalsIgnoreCase("FindTheThimble")){
                        System.out.println("I am creating the game object");
                        FindTheThimble findObj = new FindTheThimble();
                        findObj.play();

                        p2_total_losses += findObj.player2Losses();
                        p2_total_wins += findObj.player2Wins();

                        p1_total_losses += findObj.player1Losses();
                        p1_total_wins +=findObj.player1Wins();
                    }

                    //Guess the Number successfully integrated!
                    else if (gameToPlay.trim().equalsIgnoreCase("GuessTheNumber")){
                        System.out.println("I am creating the game object");
                        GuessTheNumber guessObj = new GuessTheNumber();
                        guessObj.start();
                        p2_total_losses += guessObj.player2Losses();
                        p2_total_wins += guessObj.player2Wins();

                        p1_total_losses += guessObj.player1Losses();
                        p1_total_wins +=guessObj.player1Wins();
                    }


                    else if( gameToPlay.trim().equalsIgnoreCase("Even-Odd")){
                        System.out.println("I am creating the game object");
                        EvenOddGame evenObj = new EvenOddGame();
                        evenObj.start();

                        p2_total_losses += evenObj.player2Losses();
                        p2_total_wins += evenObj.player2Wins();

                        p1_total_losses += evenObj.player1Losses();
                        p1_total_wins +=evenObj.player1Wins();

                    }
                    System.out.println("Would you like to play another game? :");
                    response = myInput.nextLine();

                    if(response.equalsIgnoreCase("quit")){
                        loopCondition = false;
                    }
                    else if(response.equalsIgnoreCase("yes")){
                        System.out.println("Type the name of the game you want to play");
                        gameToPlay = myInput.nextLine();
                    }

        }       
            System.out.println("Displaying final scoreboard");
            System.out.println("Final Scoreboard: ");
            System.out.println("Player 1 total wins/losses: "+ p1_total_wins+" "+p1_total_losses);
            System.out.println("Player 1 total wins/losses: "+ p2_total_wins+" "+p2_total_losses);

            if(p1_total_wins > p2_total_wins){
                System.out.println("The overall winner of this game is player 1, Congratulations");
            }
            else if(p2_total_wins > p1_total_wins) {
                System.out.println("The overall winner of this game is player 2, Congratulations");

            }
            else{
                System.out.println("It is a tie! Great Job. Thanks for playing");
            }



    }
}