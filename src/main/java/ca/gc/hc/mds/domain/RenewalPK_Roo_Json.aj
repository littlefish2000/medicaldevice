// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.RenewalPK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect RenewalPK_Roo_Json {
    
    public String RenewalPK.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String RenewalPK.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static RenewalPK RenewalPK.fromJsonToRenewalPK(String json) {
        return new JSONDeserializer<RenewalPK>()
        .use(null, RenewalPK.class).deserialize(json);
    }
    
    public static String RenewalPK.toJsonArray(Collection<RenewalPK> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String RenewalPK.toJsonArray(Collection<RenewalPK> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<RenewalPK> RenewalPK.fromJsonArrayToRenewalPKs(String json) {
        return new JSONDeserializer<List<RenewalPK>>()
        .use("values", RenewalPK.class).deserialize(json);
    }
    
}
