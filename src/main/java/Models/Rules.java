package Models;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonException;

import java.io.*;
import java.util.*;


public class Rules {
    public static Map<String, SkillCategory> getEmptySkillList() {
        Map<String, SkillCategory> emptySkillList = new TreeMap<>();
        emptySkillList.put("Delving", new SkillCategory("Delving"));
        return emptySkillList;
    }

    public static List<Map<String, Object>> getProfessionList(String profPath) {
        List<Map<String,Object>> professions = new ArrayList<>();

        try(FileReader reader = new FileReader("data/professions/professions.json")) {
            //Parse JSON File
            JsonArray professionList = (JsonArray) Jsoner.deserialize(reader);

            //Iterate over each profession object
            for(Object profObj : professionList) {
                JsonObject professionJson = (JsonObject) profObj;

                String name = (String) professionJson.get("name");
                String description = (String) professionJson.get("description");
                JsonArray availableSkillsArray = (JsonArray) professionJson.get("availableProfessionalSkillList");
                JsonArray skillCostArray = (JsonArray) professionJson.get("professionSkillCost");

                //Convert available skills to list
                List <String> availableSkills = new ArrayList<>();
                for(Object skill : availableSkillsArray) {
                    availableSkills.add((String) skill);
                }
                //Convert skill costs to map
                Map<String,List<Integer>> skillCosts = new HashMap<>();
                for(Object skillCostObj : skillCostArray) {
                    JsonObject skillCostJson = (JsonObject) skillCostObj;
                    String skillName = (String) skillCostJson.get("name");
                    int cost1 = ((Number) skillCostJson.get("cost1")).intValue();
                    int cost2 = ((Number) skillCostJson.get("cost2")).intValue();
                    skillCosts.put(skillName, Arrays.asList(cost1, cost2));
                }
                //Create profession map
                Map<String, Object> profession = new HashMap<>();
                profession.put("name", name);
                profession.put("description", description);
                profession.put("availableProfessionalSkillList", availableSkills);
                profession.put("ProfessionSkillCosts", skillCosts);
            }

        }catch (IOException | JsonException e) {
            e.printStackTrace();
        }
        return professions;
    }

  /* public static Map<String, Profession>getProfessionList() {
        Map<String, Profession> professionMap = new TreeMap<>();
        List<Profession> professionList;
        ObjectMapper mapper = new ObjectMapper();
        File json = new File("data/proffessions/professions.json");
        try {
            professionList = mapper.readValue(json, new TypeReference<List<Profession>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return professionMap;
    }*/

    public static Map<String, String> getTalentsAndFlaws() {
        Map<String, String> talentsAndFlaws = new HashMap<>();
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
