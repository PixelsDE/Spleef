package de.bypixels.spleef.util.files;

import java.util.List;
import java.util.UUID;

public class Extra {


    public void syncDataFiles(List<UUID> list_a, List<UUID> list_b){
        for (UUID  object_a : list_a){
            if (!list_b.contains(object_a)){
                list_b.add( object_a);
            }
        }

        for (UUID object_b : list_b){
            if (!list_a.contains(object_b)){
                list_a.add(object_b);
            }
        }
    }

}
