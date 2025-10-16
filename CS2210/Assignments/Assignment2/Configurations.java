public class Configurations {
    // instance variables
    private char[][] board;
    private int boardSize;
    private int lengthToWin;
    private int maxLevels;

    // Constructor
    public Configurations(int boardSize, int lengthToWin, int maxLevels) {
        this.boardSize = boardSize;
        this.lengthToWin = lengthToWin;
        this.maxLevels = maxLevels;
        this.board = new char[boardSize][boardSize];
  

        // Generating and initializg the game bored
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }



    public HashDictionary createDictionary() {
        // declarig size of hash table
        int sizeTable = 9111; 
        return new HashDictionary(sizeTable);


    }

    public int repeatedConfiguration(HashDictionary hashTable) {
        
        // storing charcters of the bored
        String config = boardStr();
        // checking if the string is in the hashtable
        int score = hashTable.get(config);
        return score;
    }

    public void addConfiguration(HashDictionary hashDictionary, int score) {
        
        String config = boardStr();

        // storing data in the hashdictionary
        Data data = new Data(config, score);
        hashDictionary.put(data);

    }




    public void savePlay(int row, int col, char symbol) {
        // storing the symbol in the board list
        board[row][col] = symbol;
    }

    public boolean squareIsEmpty(int row, int col) {
        // returns true if board is full of " " fales otherwise
        if (board[row][col] == ' ') {
            return true;
        } else {
            return false;
        }

    }
    
    public boolean wins(char symbol) {
        // idk whats going on here
        return false;
    }

    public boolean isDraw() {
        // iterates through bored and checks if there is empty ' '
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {

                if (board[i][j] == ' ') {
                    return false; 
                }
            }
        }
        return true; 
    }

    public int evalBoard() {
        // if only wins worked
        if (wins('O')) {
            return 3; 
        } else if (wins('X')) {
            return 0; 
        } else if (isDraw()) {
            return 2; 
        } else {
            return 1; 
        }


    }


    

    // creating privvate method to avoid code duplication
    private String boardStr() {
        // Convert the current board configuration to a string
        StringBuilder config = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {

                config.append(board[i][j]);
            }
        }
        return config.toString();
    }
}
