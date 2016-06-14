// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Device;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Device_Roo_Finder {
    
    public static Long Device.countFindDevicesByDeviceId(Long deviceId) {
        if (deviceId == null) throw new IllegalArgumentException("The deviceId argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Device AS o WHERE o.deviceId = :deviceId", Long.class);
        q.setParameter("deviceId", deviceId);
        return ((Long) q.getSingleResult());
    }
    
    public static Long Device.countFindDevicesByPerfnameCode(String perfnameCode) {
        if (perfnameCode == null || perfnameCode.length() == 0) throw new IllegalArgumentException("The perfnameCode argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Device AS o WHERE o.perfnameCode = :perfnameCode", Long.class);
        q.setParameter("perfnameCode", perfnameCode);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Device> Device.findDevicesByDeviceId(Long deviceId) {
        if (deviceId == null) throw new IllegalArgumentException("The deviceId argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery<Device> q = em.createQuery("SELECT o FROM Device AS o WHERE o.deviceId = :deviceId", Device.class);
        q.setParameter("deviceId", deviceId);
        return q;
    }
    
    public static TypedQuery<Device> Device.findDevicesByDeviceId(Long deviceId, String sortFieldName, String sortOrder) {
        if (deviceId == null) throw new IllegalArgumentException("The deviceId argument is required");
        EntityManager em = Device.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Device AS o WHERE o.deviceId = :deviceId");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Device> q = em.createQuery(queryBuilder.toString(), Device.class);
        q.setParameter("deviceId", deviceId);
        return q;
    }
    
    public static TypedQuery<Device> Device.findDevicesByPerfnameCode(String perfnameCode) {
        if (perfnameCode == null || perfnameCode.length() == 0) throw new IllegalArgumentException("The perfnameCode argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery<Device> q = em.createQuery("SELECT o FROM Device AS o WHERE o.perfnameCode = :perfnameCode", Device.class);
        q.setParameter("perfnameCode", perfnameCode);
        return q;
    }
    
    public static TypedQuery<Device> Device.findDevicesByPerfnameCode(String perfnameCode, String sortFieldName, String sortOrder) {
        if (perfnameCode == null || perfnameCode.length() == 0) throw new IllegalArgumentException("The perfnameCode argument is required");
        EntityManager em = Device.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM Device AS o WHERE o.perfnameCode = :perfnameCode");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<Device> q = em.createQuery(queryBuilder.toString(), Device.class);
        q.setParameter("perfnameCode", perfnameCode);
        return q;
    }
    
}