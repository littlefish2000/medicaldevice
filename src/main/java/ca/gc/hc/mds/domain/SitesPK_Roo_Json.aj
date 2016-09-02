// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.SitesPK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect SitesPK_Roo_Json {
    
    public String SitesPK.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String SitesPK.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static SitesPK SitesPK.fromJsonToSitesPK(String json) {
        return new JSONDeserializer<SitesPK>()
        .use(null, SitesPK.class).deserialize(json);
    }
    
    public static String SitesPK.toJsonArray(Collection<SitesPK> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String SitesPK.toJsonArray(Collection<SitesPK> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<SitesPK> SitesPK.fromJsonArrayToSitesPKs(String json) {
        return new JSONDeserializer<List<SitesPK>>()
        .use("values", SitesPK.class).deserialize(json);
    }
    
}