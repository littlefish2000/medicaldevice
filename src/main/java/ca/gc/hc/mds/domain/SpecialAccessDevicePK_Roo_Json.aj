// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.SpecialAccessDevicePK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect SpecialAccessDevicePK_Roo_Json {
    
    public String SpecialAccessDevicePK.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String SpecialAccessDevicePK.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static SpecialAccessDevicePK SpecialAccessDevicePK.fromJsonToSpecialAccessDevicePK(String json) {
        return new JSONDeserializer<SpecialAccessDevicePK>()
        .use(null, SpecialAccessDevicePK.class).deserialize(json);
    }
    
    public static String SpecialAccessDevicePK.toJsonArray(Collection<SpecialAccessDevicePK> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String SpecialAccessDevicePK.toJsonArray(Collection<SpecialAccessDevicePK> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<SpecialAccessDevicePK> SpecialAccessDevicePK.fromJsonArrayToSpecialAccessDevicePKs(String json) {
        return new JSONDeserializer<List<SpecialAccessDevicePK>>()
        .use("values", SpecialAccessDevicePK.class).deserialize(json);
    }
    
}