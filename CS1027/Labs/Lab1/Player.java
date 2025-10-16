
public class Player {
        
        private String name;
        private String position;
        private int jerseyNum;
    
        public Player(String theName, String thePosition, int theJersey) {
        name = theName;
        position = thePosition;
        jerseyNum = theJersey;
        }
    
        public String getName() {
        return name;
        }
    
        public String getPosition() {
        return position;
        }
    
        public int getJerseyNum() {
        return jerseyNum;
        }
    
        public void setName(String newName) {
        name = newName;
        }
    
        public void setPosition(String newPosition) {
        position = newPosition;
        }
    
        public void setJerseyNum(int newJersey) {
        jerseyNum = newJersey;
        
    }
}




