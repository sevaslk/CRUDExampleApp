package com.sevaslk.crudexampleapp;

import java.util.HashMap;
import java.util.Map;

class SkillRepository {
    private static Map<Long, String> skillMap = new HashMap<>();

    public static void create(String skill) {
        skillMap.put(Skill.getCountID() + 1, skill);
    }

    public static String getByID(long ID) {
        return skillMap.get(ID);
    }

    public static void update(Long ID, String skill) {
        skillMap.replace(ID, skill);
    }

    public static void deleteByID(Long id) {
        skillMap.remove(id);

    }

}
