public class Data {
    private String configuration;
    private int score;

    // Construcctor
    public Data(String config, int score) {
        this.score = score;
        this.configuration = config;
        
    }

    
    // Configuration get method
    public String getConfiguration() {
        return configuration;
    }

    // Score get methjod
    public int getScore() {
        return score;

    }
}
