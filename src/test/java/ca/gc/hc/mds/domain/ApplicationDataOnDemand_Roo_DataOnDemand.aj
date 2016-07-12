// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.ApplicationDataOnDemand;
import ca.gc.hc.mds.reference.LicenceStatusType;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        setApplicationDesc(obj, index);
        setEntryDate(obj, index);
        setLicenceStatus(obj, index);
        setLicenceStatusDate(obj, index);
        setOrginLicenseId(obj, index);
        setReceiptDate(obj, index);
        return obj;
    }
    
    public void ApplicationDataOnDemand.setApplicationDesc(Application obj, int index) {
        String applicationDesc = "applicationDesc_" + index;
        if (applicationDesc.length() > 150) {
            applicationDesc = applicationDesc.substring(0, 150);
        }
        obj.setApplicationDesc(applicationDesc);
    }
    
    public void ApplicationDataOnDemand.setEntryDate(Application obj, int index) {
        Date entryDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setEntryDate(entryDate);
    }
    
    public void ApplicationDataOnDemand.setLicenceStatus(Application obj, int index) {
        LicenceStatusType licenceStatus = LicenceStatusType.class.getEnumConstants()[0];
        obj.setLicenceStatus(licenceStatus);
    }
    
    public void ApplicationDataOnDemand.setLicenceStatusDate(Application obj, int index) {
        Date licenceStatusDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setLicenceStatusDate(licenceStatusDate);
    }
    
    public void ApplicationDataOnDemand.setOrginLicenseId(Application obj, int index) {
        Long orginLicenseId = new Integer(index).longValue();
        obj.setOrginLicenseId(orginLicenseId);
    }
    
    public void ApplicationDataOnDemand.setReceiptDate(Application obj, int index) {
        Date receiptDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setReceiptDate(receiptDate);
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
        Long id = obj.getApplicationId();
        return Application.findApplication(id);
    }
    
    public Application ApplicationDataOnDemand.getRandomApplication() {
        init();
        Application obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getApplicationId();
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
