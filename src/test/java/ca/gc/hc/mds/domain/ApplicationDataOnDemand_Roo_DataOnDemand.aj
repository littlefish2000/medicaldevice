// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.ApplicationDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect ApplicationDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ApplicationDataOnDemand: @Component;
    
    private Random ApplicationDataOnDemand.rnd = new SecureRandom();
    
    private List<Application> ApplicationDataOnDemand.data;
    
    public Application ApplicationDataOnDemand.getNewTransientApplication(int index) {
        Application obj = new Application();
        setApplcationName(obj, index);
        setApplicationDesc(obj, index);
        return obj;
    }
    
    public void ApplicationDataOnDemand.setApplcationName(Application obj, int index) {
        String applcationName = "applcationName_" + index;
        if (applcationName.length() > 30) {
            applcationName = applcationName.substring(0, 30);
        }
        obj.setApplcationName(applcationName);
    }
    
    public void ApplicationDataOnDemand.setApplicationDesc(Application obj, int index) {
        String applicationDesc = "applicationDesc_" + index;
        if (applicationDesc.length() > 30) {
            applicationDesc = applicationDesc.substring(0, 30);
        }
        obj.setApplicationDesc(applicationDesc);
    }
    
    public Application ApplicationDataOnDemand.getSpecificApplication(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Application obj = data.get(index);
        Long id = obj.getId();
        return Application.findApplication(id);
    }
    
    public Application ApplicationDataOnDemand.getRandomApplication() {
        init();
        Application obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Application.findApplication(id);
    }
    
    public boolean ApplicationDataOnDemand.modifyApplication(Application obj) {
        return false;
    }
    
    public void ApplicationDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Application.findApplicationEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Application' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Application>();
        for (int i = 0; i < 10; i++) {
            Application obj = getNewTransientApplication(i);
            try {
                obj.persist();
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
