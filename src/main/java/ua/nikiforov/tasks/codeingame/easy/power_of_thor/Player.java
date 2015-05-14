package ua.nikiforov.tasks.codeingame.easy.power_of_thor;

import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int LX = in.nextInt(); // the X position of the light of power
        int LY = in.nextInt(); // the Y position of the light of power
        int TX = in.nextInt(); // Thor's starting X position
        int TY = in.nextInt(); // Thor's starting Y position

        while (true) {
            int E = in.nextInt(); // The level of Thor's remaining energy, representing the number of moves he can still make.
            String direction = "";
            
            if (TY > LY) {
                direction += "N";
                --TY;
            } else if (TY < LY) {
                direction += "S";
                ++TY;
            }
            
            if (TX > LX) {
                direction += "W";
                ++TX;
            } else if (TX < LX) {
                direction += "E";
                --TX;
            }

            System.out.println(direction); // A single line providing the move to be made: N NE E SE S SW W or NW
            
        }
    }
}