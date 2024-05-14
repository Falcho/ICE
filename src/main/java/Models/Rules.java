package Models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Rules {
    public static Map<String, SkillCategory> getEmptySkillList() {
        Map<String, SkillCategory> emptySkillList = new TreeMap<>();
        emptySkillList.put("Delving", new SkillCategory("Delving") );
        return emptySkillList;
    }

    public static Map<String, String> getTalentsAndFlaws() {
        Map<String,String> talentsAndFlaws = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<TalentsAndFlaws> talentList;
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, TalentsAndFlaws.class);

        //Læs json filen
        File json = new File("data/TalentsAndFlaws/Talents.json");
        //Konverter json til et array af TalentAndFlaws objekter
        try {
            talentList = objectMapper.readValue(json, collectionType);
            //talentsAndFlaws = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Konverter array til map
        for (TalentsAndFlaws talent : talentList) {
            talentsAndFlaws.put(talent.getName(), talent.getDescription());
        }

        return talentsAndFlaws;
    }
}
