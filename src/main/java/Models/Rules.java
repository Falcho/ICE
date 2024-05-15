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

    public static Map<String, Culture> getCultures(){


        Map<String, Culture> cultures = new TreeMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        //CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(Map.class, Culture.class);
        File json = new File("data/cultures/cultures.json");
        try {
            Map<String, Map<String, Object>> tempMap = objectMapper.readValue(json, new TypeReference<Map<String, Map<String, Object>>>(){});
            for (Map.Entry<String, Map<String, Object>> entry : tempMap.entrySet()) {
                String cultureKey = entry.getKey();
                Map<String, Object> cultureData = entry.getValue();
                Culture culture = new Culture();
                culture.setName((String) cultureData.get("name"));
                culture.setDescription((String) cultureData.get("description"));
                culture.setCrafts((List<String>) cultureData.get("crafts"));
                culture.setVocations((List<String>) cultureData.get("vocations"));

                List<Map<String, Integer>> skillsList = (List<Map<String, Integer>>) cultureData.get("skills");
                Map<String, Integer> skillsMap = new LinkedHashMap<>();
                for (Map<String, Integer> skill : skillsList) {
                    skillsMap.putAll(skill);
                }
                culture.setSkills(skillsMap);

                cultures.put(cultureKey, culture);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try {
            cultures = objectMapper.readValue(json, new TypeReference<Map<String, Culture>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return cultures;
    }
}
