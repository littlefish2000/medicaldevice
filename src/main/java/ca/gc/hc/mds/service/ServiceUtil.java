package ca.gc.hc.mds.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ServiceUtil {
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }    
    
    public static void setAnyNullOrEmptyToDefault(Object myObject)
    {
    	String mystring = " ";
    	Long mylong = 0L;

    	java.beans.PropertyDescriptor[]  descriptors = PropertyUtils.getPropertyDescriptors(myObject);
    	
    	for(java.beans.PropertyDescriptor pd : descriptors)
        {   
    		 if(pd.getPropertyType() == mystring.getClass())
            {
    			String name = pd.getName();
                String value;
							try {
								value = (String) PropertyUtils.getProperty(myObject, name);
								if((value == null) || (value.isEmpty()))
				                {
									PropertyUtils.setProperty(myObject, name,mystring);

				                }
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
				
                
            }
            else if(pd.getPropertyType() == mylong.getClass())
            {
            	String name = pd.getName();
               
				try {
					 Long value = (Long) PropertyUtils.getProperty(myObject, name);
					 if(value == null)
	                {
						 PropertyUtils.setProperty(myObject, name,mylong);

	                }
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
               
            }
        }
        
    }
    
    public static Boolean isValueEmpty(String s){
    	if (s == null || s.isEmpty() || (s.trim().length()) == 0){
    		return true;
    	}
    	return false;
    }
    
    public static Boolean isValueEmpty(Long l){
    	if (l == null || l == 0){
    		return true;
    	}
    	return false;
    }

}
