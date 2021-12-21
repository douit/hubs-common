package com.bluecc.gentool.common;

import com.bluecc.hubs.fund.MeshProfiles;
import com.bluecc.hubs.fund.MeshProfiles.MeshesProfile;
import com.bluecc.hubs.fund.SystemDefs;
import org.assertj.core.util.Preconditions;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class YamlTest {

    @Test
    public void loadMap() throws FileNotFoundException {
        File simpleFile=SystemDefs.prependHubsHomeFile("asset/mesh/simple.yml");
        Yaml yaml=new Yaml();
        Map<String, Object> simpeLoader=yaml.load(new FileReader(simpleFile));
        System.out.println(simpeLoader.keySet());

        // MeshesProfile profile=yaml.loadAs(new FileReader(simpleFile), MeshesProfile.class);
        // Map<String, Object> orderingProfile=(Map<String, Object>)profile.getMeshes().get("dummyStore")
        //         .getStates().get("orderingProfile");
        // System.out.println(orderingProfile.keySet());
        //
        // System.out.println(orderingProfile.get("forward").getClass().getName());
        // processForward((List<String>)orderingProfile.get("forward"));
    }

    // private void processForward(List<String> forward) {
    //     Preconditions.checkArgument(forward.size()==3,
    //             "Invalid forward config: %s", forward);
    //     System.out.println(new MeshProfiles.ForwardProfile(forward.get(0),
    //             forward.get(1),
    //             forward.get(2)));
    // }
}
