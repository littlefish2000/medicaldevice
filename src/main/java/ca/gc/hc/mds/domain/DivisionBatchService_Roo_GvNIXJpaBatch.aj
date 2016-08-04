// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Division;
import ca.gc.hc.mds.domain.DivisionBatchService;
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

privileged aspect DivisionBatchService_Roo_GvNIXJpaBatch {
    
    public Class DivisionBatchService.getEntity() {
        return Division.class;
    }
    
    public EntityManager DivisionBatchService.entityManager() {
        return Division.entityManager();
    }
    
    @Transactional
    public int DivisionBatchService.deleteAll() {
        return entityManager().createQuery("DELETE FROM Division").executeUpdate();
    }
    
    @Transactional
    public int DivisionBatchService.deleteIn(List<String> ids) {
        Query query = entityManager().createQuery("DELETE FROM Division as d WHERE d.divisionCd IN (:idList)");
        query.setParameter("idList", ids);
        return query.executeUpdate();
    }
    
    @Transactional
    public int DivisionBatchService.deleteNotIn(List<String> ids) {
        Query query = entityManager().createQuery("DELETE FROM Division as d WHERE d.divisionCd NOT IN (:idList)");
        query.setParameter("idList", ids);
        return query.executeUpdate();
    }
    
    @Transactional
    public void DivisionBatchService.create(List<Division> divisions) {
        for( Division division : divisions) {
            division.persist();
        }
    }
    
    @Transactional
    public List<Division> DivisionBatchService.update(List<Division> divisions) {
        List<Division> merged = new ArrayList<Division>();
        for( Division division : divisions) {
            merged.add( division.merge() );
        }
        return merged;
    }
    
    public List<Division> DivisionBatchService.findByValues(Map<String, Object> propertyValues) {
        
        // if there is a filter
        if (propertyValues != null && !propertyValues.isEmpty()) {
            // Prepare a predicate
            BooleanBuilder baseFilterPredicate = new BooleanBuilder();
            
            // Base filter. Using BooleanBuilder, a cascading builder for
            // Predicate expressions
            PathBuilder<Division> entity = new PathBuilder<Division>(Division.class, "entity");
            
            // Build base filter
            for (String key : propertyValues.keySet()) {
                baseFilterPredicate.and(entity.get(key).eq(propertyValues.get(key)));
            }
            
            // Create a query with filter
            JPAQuery query = new JPAQuery(Division.entityManager());
            query = query.from(entity);
            
            // execute query
            return query.where(baseFilterPredicate).list(entity);
        }
        
        // no filter: return all elements
        return Division.findAllDivisions();
    }
    
    @Transactional
    public long DivisionBatchService.deleteByValues(Map<String, Object> propertyValues) {
        
        // if there no is a filter
        if (propertyValues == null || propertyValues.isEmpty()) {
            throw new IllegalArgumentException("Missing property values");
        }
        // Prepare a predicate
        BooleanBuilder baseFilterPredicate = new BooleanBuilder();
        
        // Base filter. Using BooleanBuilder, a cascading builder for
        // Predicate expressions
        PathBuilder<Division> entity = new PathBuilder<Division>(Division.class, "entity");
        
        // Build base filter
        for (String key : propertyValues.keySet()) {
            baseFilterPredicate.and(entity.get(key).eq(propertyValues.get(key)));
        }
        
        // Create a query with filter
        JPADeleteClause delete = new JPADeleteClause(Division.entityManager(),entity);
        
        // execute delete
        return delete.where(baseFilterPredicate).execute();
    }
    
    @Transactional
    public void DivisionBatchService.delete(List<Division> divisions) {
        for( Division division : divisions) {
            division.remove();
        }
    }
    
}
