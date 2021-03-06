// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.ApplAmendmentReason;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect ApplAmendmentReason_Roo_Finder {
    
    public static Long ApplAmendmentReason.countFindApplAmendmentReasonsByApplicationId(Long applicationId) {
        if (applicationId == null) throw new IllegalArgumentException("The applicationId argument is required");
        EntityManager em = ApplAmendmentReason.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM ApplAmendmentReason AS o WHERE o.applicationId = :applicationId", Long.class);
        q.setParameter("applicationId", applicationId);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<ApplAmendmentReason> ApplAmendmentReason.findApplAmendmentReasonsByApplicationId(Long applicationId) {
        if (applicationId == null) throw new IllegalArgumentException("The applicationId argument is required");
        EntityManager em = ApplAmendmentReason.entityManager();
        TypedQuery<ApplAmendmentReason> q = em.createQuery("SELECT o FROM ApplAmendmentReason AS o WHERE o.applicationId = :applicationId", ApplAmendmentReason.class);
        q.setParameter("applicationId", applicationId);
        return q;
    }
    
    public static TypedQuery<ApplAmendmentReason> ApplAmendmentReason.findApplAmendmentReasonsByApplicationId(Long applicationId, String sortFieldName, String sortOrder) {
        if (applicationId == null) throw new IllegalArgumentException("The applicationId argument is required");
        EntityManager em = ApplAmendmentReason.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM ApplAmendmentReason AS o WHERE o.applicationId = :applicationId");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<ApplAmendmentReason> q = em.createQuery(queryBuilder.toString(), ApplAmendmentReason.class);
        q.setParameter("applicationId", applicationId);
        return q;
    }
    
}
