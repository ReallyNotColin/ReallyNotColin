import java.util.*;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class Dictionary <K,V>{
    // an array of KeyValuePair objects
    KeyValuePair<K, V>[] array;
    // Special "deleted" KeyValuePair object to use for marking an entry as deleted
    private final KeyValuePair<K,V> DELETED = new KeyValuePair<K,V>(null, null);


    // constructor
    public Dictionary(){
        array = (KeyValuePair<K,V>[]) new KeyValuePair[7];
    }

    // Inserts key value pair into hashtable using helper functions
    public void insert(K key, V value){
        // length of hash table (fragile code, instead insert .length)
        int m = array.length;
        // prehash-ed value of the given key
        int p  = prehash(key);
        
        // number of attempts to find an empty bucket 
        int attempt = 1;
        // While in bounds of the hashtable...
        while (attempt < m){
            // Create an index
            // If none of the if statements are applicible, it increases the number of attempts by one and tries again as long as the 
            // number of attempts is less than the array's size 
            int index = hash(p,attempt);

            // If there's an empty bucket at the generated index...
            if(array[index] == null || array[index] == DELETED){
                // insert the key value pair!! 
                array[index] = new KeyValuePair<K,V>(key, value);
                // exit loop;
                break;
            }

            // If there's NOT an empty bucket at the generated index 
            if (array[index] != null){
                // If the given key matches an identical key...
                if (key == array[index].getKey()){
                    // replace the value
                    array[index].setValue(value);
                }
                // Otherwise
                else{
                    // use linear probing to find a new index
                    int newIndex = linearProbe(index, attempt);
                        // If the new index is empty...
                        if (array[newIndex] == null){
                            // insert the key value pair!! 
                            array[newIndex] = new KeyValuePair<K,V>(key, value);
                            // exit loop
                            break;
                        }
                        // If the new index is not empty, the while loop will start another cycle 
                        // as long as the number of attempts < 7 to generate new index. 
                    }
            }
            // Increase the number of attempts by 1 
            attempt ++;
        }
    }

    // Converts the given key into an integer value using Java's hashCode() function
    private int prehash(K key){
        return key.hashCode();
    }

    // Takes the key's prehash integer value and "shrinks" it 
    private int hash(int p, int attempt){
        return (p % attempt);
    }

    // Re-hashes the key's index using division method 
    private int linearProbe(int index, int attempt){
        return ((index + (attempt -1)) % 7);
        
    }

    // Searches for the key within the hashtable and if found, returns its value
    public V search(K key){
        // Create a default returning value 
        V result = null;
        // length of hash table (fragile code, instead insert .length)
        int m = array.length;
        // prehash-ed value of the given key
        int p  = prehash(key);
        
        // number of attempts to find an empty bucket 
        int attempt = 1;
        // While in bounds of the hashtable...
        while (attempt < m){
            // Create an index
            // If none of the if statements are applicible, it increases the number of attempts by one and tries again as long as the 
            // number of attempts is less than the array's size 
            int index = hash(p,attempt);
            

            // if the key at the index is full and the keys match, return the keys value
            if (array[index] != null){
                if(array[index].getKey() == key){
                    result = array[index].getValue();
                    break;
                }
                // if the key at the index is full but the keys dont match, linear probe
                // until it does 
                if(array[index].getKey() != key){
                    int newIndex = linearProbe(index, attempt);
                    // If the new index is empty...
                    if (array[newIndex] != null){
                        if (array[newIndex].getKey() == key){
                            // insert the key value pair!! 
                            result = array[newIndex].getValue();
                            break;
                        }
                    }
                }
            }
            
            // if the key at the index is empty, return null as it does not exist 
            else if(array[index] == null){
                return result;
            }
        
            // Increase the number of attempts by 1 
            attempt ++;
        }
        // return the result 
        return result;
    }

    // void delete(key) function
    public void delete(K key){
        // length of hash table (fragile code, instead insert .length)
        int m = array.length;
        // prehash-ed value of the given key
        int p  = prehash(key);
        
        // number of attempts to find an empty bucket 
        int attempt = 1;
        // While in bounds of the hashtable...
        while (attempt < m){
            // Create an index
            // If none of the if statements are applicible, it increases the number of attempts by one and tries again as long as the 
            // number of attempts is less than the array's size 
            int index = hash(p,attempt);

            // if the key at the index is full and the keys match, delete the key 
            if (array[index] != null){
                if(array[index].getKey() == key){
                    array[index] = DELETED;
                }
                // if the key at the index is full but the keys dont match, linear probe until it does
                // then delete it 
                if(array[index].getKey() != key){
                    int newIndex = linearProbe(index, attempt);
                    // If the new index is empty...
                    if (array[newIndex] != null){
                        if (array[newIndex].getKey() == key){
                            array[newIndex] = DELETED;
                        }
                    }
                }
            }
        
            // Increase the number of attempts by 1 
            attempt ++;
        }
    }

    public List<KeyValuePair<K,V>> getCluster(int bucketIndex){
        List<KeyValuePair<K,V>> cluster = new List<KeyValuePair<K,V>>();

        // search for keys in the dict until they end with null 
        // has an append method, stops when hits null. skips deleted buckets
        // grab the length of the hashtable (which I'm calling array)
        int m = table.length;
        int rightwalker = bucketIndex;
        int leftwalker = bucketIndex;

        while(table[rightwalker] != null && rightwalker < m){
            if(table[rightwalker] == DELETED){
                rightwalker ++;
            }
            cluster.append(table[rightwalker]);
            rightwalker ++;
        }
        while(table[leftwalker] != null && leftwalker >=0){
            if (table[leftwalker] == DELETED){
                leftwalker --;
            }
            cluster.append(table[leftwalker]);
            leftwalker --;
        }
    }


} // end of Dictionary class

