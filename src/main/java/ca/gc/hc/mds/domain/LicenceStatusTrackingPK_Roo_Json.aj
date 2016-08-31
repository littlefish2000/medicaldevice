// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.LicenceStatusTrackingPK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect LicenceStatusTrackingPK_Roo_Json {
    
    public String LicenceStatusTrackingPK.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String LicenceStatusTrackingPK.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static LicenceStatusTrackingPK LicenceStatusTrackingPK.fromJsonToLicenceStatusTrackingPK(String json) {
        return new JSONDeserializer<LicenceStatusTrackingPK>()
        .use(null, LicenceStatusTrackingPK.class).deserialize(json);
    }
    
    public static String LicenceStatusTrackingPK.toJsonArray(Collection<LicenceStatusTrackingPK> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String LicenceStatusTrackingPK.toJsonArray(Collection<LicenceStatusTrackingPK> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<LicenceStatusTrackingPK> LicenceStatusTrackingPK.fromJsonArrayToLicenceStatusTrackingPKs(String json) {
        return new JSONDeserializer<List<LicenceStatusTrackingPK>>()
        .use("values", LicenceStatusTrackingPK.class).deserialize(json);
    }
    
}
