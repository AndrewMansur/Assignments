import java.util.LinkedList;

 
public class HashDictionary {
    // instnace varliables  
    private int size;
    private LinkedList<Data>[] dataList;
 

    // contrscutor
    public HashDictionary(int size) {
        this.size = size;
        dataList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            dataList[i] = new LinkedList<>();


        }
    }

    // polynomial hash function
    private int hashFun(String config) {
    
        int hash = 0;
        int primeNum = 31;

        for (char c : config.toCharArray()) {
            
            hash = (hash * primeNum + c) % size;
        }

        return hash;
    }

    // adds record to the dictionary
    public int put(Data record) {
        int config = hashFun(record.getConfiguration());

        LinkedList<Data> list = dataList[config];
        // iteraying through list
        for (Data data : list) { if (data.getConfiguration().equals(record.getConfiguration())) {

                return 1;
            }
        }
        // add using java library
        list.add(record);
        return 0; 
    }

    // removing record from the dictionary
    public void remove(String config) {

        int strConfig = hashFun(config);
        LinkedList<Data> list = dataList[strConfig];

        for (Data data : list) { if (data.getConfiguration().equals(config)) {
                // remove using java library
                list.remove(data);
                return;

            }
        }
    }



    //returns the score stored in the record of the dictionary with key config
    public int get(String config) {
        int strConfig = hashFun(config);
        LinkedList<Data> list = dataList[strConfig];

        // iterating the llist to find config 
        for (Data data : list) { if (data.getConfiguration().equals(config)) { return data.getScore();
            }
        }

        return -1; 
    }




    // returns the number of data objects stored in the dictionary
    public int numRecords() {
        int dataObjects = 0;
        for (LinkedList<Data> list : dataList) { dataObjects += list.size();
        }


        return dataObjects;
    }
}
