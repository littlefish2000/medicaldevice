// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Physician;
import ca.gc.hc.mds.domain.PhysicianBatchService;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.PathBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PhysicianBatchService_Roo_GvNIXJpaBatch {
    
    public Class PhysicianBatchService.getEntity() {
        return Physician.class;
    }
    
    public EntityManager PhysicianBatchService.entityManager() {
        return Physician.entityManager();
    }
    
    @Transactional
    public int PhysicianBatchService.deleteAll() {
        return entityManager().createQuery("DELETE FROM Physician").executeUpdate();
    }
    
    @Transactional
    public int PhysicianBatchService.deleteIn(List<Long> ids) {
        Query query = entityManager().createQuery("DELETE FROM Physician as p WHERE p.physicianId IN (:idList)");
        query.setParameter("idList", ids);
        return query.executeUpdate();
    }
    
    @Transactional
    public int PhysicianBatchService.deleteNotIn(List<Long> ids) {
        Query query = entityManager().createQuery("DELETE FROM Physician as p WHERE p.physicianId NOT IN (:idList)");
        query.setParameter("idList", ids);
        return query.executeUpdate();
    }
    
    @Transactional
    public void PhysicianBatchService.create(List<Physician> physicians) {
        for( Physician physician : physicians) {
            physician.persist();
        }
    }
    
    @Transactional
    public List<Physician> PhysicianBatchService.update(List<Physician> physicians) {
        List<Physician> merged = new ArrayList<Physician>();
        for( Physician physician : physicians) {
            merged.add( physician.merge() );
        }
        return merged;
    }
    
    public List<Physician> PhysicianBatchService.findByValues(Map<String, Object> propertyValues) {
        
        // if there is a filter
        if (propertyValues != null && !propertyValues.isEmpty()) {
            // Prepare a predicate
            BooleanBuilder baseFilterPredicate = new BooleanBuilder();
            
            // Base filter. Using BooleanBuilder, a cascading builder for
            // Predicate expressions
            PathBuilder<Physician> entity = new PathBuilder<Physician>(Physician.class, "entity");
            
            // Build base filter
            for (String key : propertyValues.keySet()) {
                baseFilterPredicate.and(entity.get(key).eq(propertyValues.get(key)));
            }
            
            // Create a query with filter
            JPAQuery query = new JPAQuery(Physician.entityManager());
            query = query.from(entity);
            
            // execute query
            return query.where(baseFilterPredicate).list(entity);
        }
        
        // no filter: return all elements
        return Physician.findAllPhysicians();
    }
    
    @Transactional
    public long PhysicianBatchService.deleteByValues(Map<String, Object> propertyValues) {
        
        // if there no is a filter
        if (propertyValues == null || propertyValues.isEmpty()) {
            throw new IllegalArgumentException("Missing property values");
        }
        // Prepare a predicate
        BooleanBuilder baseFilterPredicate = new BooleanBuilder();
        
        // Base filter. Using BooleanBuilder, a cascading builder for
        // Predicate expressions
        PathBuilder<Physician> entity = new PathBuilder<Physician>(Physician.class, "entity");
        
        // Build base filter
        for (String key : propertyValues.keySet()) {
            baseFilterPredicate.and(entity.get(key).eq(propertyValues.get(key)));
        }
        
        // Create a query with filter
        JPADeleteClause delete = new JPADeleteClause(Physician.entityManager(),entity);
        
        // execute delete
        return delete.where(baseFilterPredicate).execute();
    }
    
    @Transactional
    public void PhysicianBatchService.delete(List<Physician> physicians) {
        for( Physician physician : physicians) {
            physician.remove();
        }
    }
    
}
