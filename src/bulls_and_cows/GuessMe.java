    package bulls_and_cows;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Random; 

    public class GuessMe {
        
        private String number_to_guess;
        private int guess_number;
        /*The guess history is comprised of 2 consecutive characters-sequences:
        The first is the bulls and cows - first the number of bulls, then the number of cows
        The second is the sequence itself*/
        private ArrayList<String> history = new ArrayList<String>();
        private final int number_length=4;
        private final int bulls_index=0;
        private final int cows_index=1;

        public int get_bulls_index () {
            return bulls_index;
        }

        public int get_cows_index () {
            return cows_index;
        }

        public int get_guess_number () {
            return guess_number;
        }

        //get and set functions (think if needed)

        //Print history function for main
        public void print_history () {
            System.out.println("-----------------------------------");
            System.out.println("This is the updated guess history:");
            for (int i=0; i<guess_number;i++) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Guess number: "+(i+1));
                System.out.println("The guess is: "+history.get(i).substring(cows_index+1,cows_index+1+number_length));
                System.out.println("Bulls: "+history.get(i).charAt(bulls_index)+", Cows: "+history.get(i).charAt(cows_index));
            }
            System.out.println("-----------------------------------");
        }

        /*Print the number of bulls and cows*/
        public void print_bulls_and_cows (int bulls, int cows) {
            System.out.println("The number of bulls is: "+Integer.toString(bulls));
            System.out.println("The number of cows is: "+Integer.toString(cows));
        }

        /*Compare the guessed number with the actual number
        In the output - the first char is the number of bulls, second char is the number of cows*/
        public String compare_number (String guess) {
            int bulls=0, cows=0;
            String bulls_and_cows;
            for (int i=0;i<number_length;i++) {
                if(number_to_guess.charAt(i)==guess.charAt(i)) {
                    bulls++;
                }
                else {
                    for (int j=0;j<number_length;j++) {
                        if(j==i) {
                            continue;
                        }
                        if(number_to_guess.charAt(i)==guess.charAt(j)) {
                            cows++;
                        }
                    }
                }
            }
            bulls_and_cows=Integer.toString(bulls)+Integer.toString(cows);
            history.add(bulls_and_cows+guess);
            return bulls_and_cows;
        }

        //Verify that the number entered by the user is OK
        public boolean check_number (String number) {
            if(number.length()!=number_length) {
                System.out.println("Input length is incorrect");
                return false;
            }
            for (int i=0; i<number_length; i++) {
                if(!Character.isDigit(number.charAt(i))) {
                    System.out.println("One of the characters is not a digit");
                    return false;
                }
            }
            return true;
        }

        //Increment guess number
        public void add_guess () {
            guess_number++;
        }

        //Setting a new random number
        private void new_number_to_guess() {
            int[] number_to_guess_array=new int[number_length];
            Random r = new Random();
            boolean re_random=false;
            for(int i=0; i<number_length; i++) {
                number_to_guess_array[i]=r.nextInt(10);
                for (int j=0; j<i; j++) {
                    if(number_to_guess_array[j]==number_to_guess_array[i]) {
                        re_random=true;
                    }
                }
                if(re_random) {
                    i=i-1;
                    re_random=false;
                }
            }
            number_to_guess=Arrays.toString(number_to_guess_array).replaceAll("\\[|\\]|,|\\s", "");
        }

        //Restart the game (new game)
        public void restart() {
            history.removeAll(history);
            guess_number=0;
            new_number_to_guess();
        }
    }