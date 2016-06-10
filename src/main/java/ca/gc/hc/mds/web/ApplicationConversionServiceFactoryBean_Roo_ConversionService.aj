// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.CompanyContact;
import ca.gc.hc.mds.domain.CompanyHistory;
import ca.gc.hc.mds.domain.Device;
import ca.gc.hc.mds.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Application, String> ApplicationConversionServiceFactoryBean.getApplicationToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.Application, java.lang.String>() {
            public String convert(Application application) {
                return new StringBuilder().append(application.getOrginLicenseId()).append(' ').append(application.getEntryDate()).append(' ').append(application.getReceiptDate()).append(' ').append(application.getApplicationDesc()).toString();
            }
        };
    }
    
    public Converter<Long, Application> ApplicationConversionServiceFactoryBean.getIdToApplicationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, ca.gc.hc.mds.domain.Application>() {
            public ca.gc.hc.mds.domain.Application convert(java.lang.Long id) {
                return Application.findApplication(id);
            }
        };
    }
    
    public Converter<String, Application> ApplicationConversionServiceFactoryBean.getStringToApplicationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ca.gc.hc.mds.domain.Application>() {
            public ca.gc.hc.mds.domain.Application convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Application.class);
            }
        };
    }
    
    public Converter<Company, String> ApplicationConversionServiceFactoryBean.getCompanyToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.Company, java.lang.String>() {
            public String convert(Company company) {
                return new StringBuilder().append(company.getCompanyName()).append(' ').append(company.getAddressLine1()).append(' ').append(company.getAddressLine2()).append(' ').append(company.getAddressLine3()).toString();
            }
        };
    }
    
    public Converter<Long, Company> ApplicationConversionServiceFactoryBean.getIdToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, ca.gc.hc.mds.domain.Company>() {
            public ca.gc.hc.mds.domain.Company convert(java.lang.Long id) {
                return Company.findCompany(id);
            }
        };
    }
    
    public Converter<String, Company> ApplicationConversionServiceFactoryBean.getStringToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ca.gc.hc.mds.domain.Company>() {
            public ca.gc.hc.mds.domain.Company convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Company.class);
            }
        };
    }
    
    public Converter<CompanyContact, String> ApplicationConversionServiceFactoryBean.getCompanyContactToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.CompanyContact, java.lang.String>() {
            public String convert(CompanyContact companyContact) {
                return new StringBuilder().append(companyContact.getStatusDate()).append(' ').append(companyContact.getContactName()).append(' ').append(companyContact.getContactTitle()).append(' ').append(companyContact.getE_MAIL()).toString();
            }
        };
    }
    
    public Converter<Long, CompanyContact> ApplicationConversionServiceFactoryBean.getIdToCompanyContactConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, ca.gc.hc.mds.domain.CompanyContact>() {
            public ca.gc.hc.mds.domain.CompanyContact convert(java.lang.Long id) {
                return CompanyContact.findCompanyContact(id);
            }
        };
    }
    
    public Converter<String, CompanyContact> ApplicationConversionServiceFactoryBean.getStringToCompanyContactConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ca.gc.hc.mds.domain.CompanyContact>() {
            public ca.gc.hc.mds.domain.CompanyContact convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CompanyContact.class);
            }
        };
    }
    
    public Converter<CompanyHistory, String> ApplicationConversionServiceFactoryBean.getCompanyHistoryToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.CompanyHistory, java.lang.String>() {
            public String convert(CompanyHistory companyHistory) {
                return new StringBuilder().append(companyHistory.getChangeDate()).append(' ').append(companyHistory.getCompanyName()).append(' ').append(companyHistory.getAddressLine1()).append(' ').append(companyHistory.getAddressLine2()).toString();
            }
        };
    }
    
    public Converter<Long, CompanyHistory> ApplicationConversionServiceFactoryBean.getIdToCompanyHistoryConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, ca.gc.hc.mds.domain.CompanyHistory>() {
            public ca.gc.hc.mds.domain.CompanyHistory convert(java.lang.Long id) {
                return CompanyHistory.findCompanyHistory(id);
            }
        };
    }
    
    public Converter<String, CompanyHistory> ApplicationConversionServiceFactoryBean.getStringToCompanyHistoryConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ca.gc.hc.mds.domain.CompanyHistory>() {
            public ca.gc.hc.mds.domain.CompanyHistory convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CompanyHistory.class);
            }
        };
    }
    
    public Converter<Device, String> ApplicationConversionServiceFactoryBean.getDeviceToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.Device, java.lang.String>() {
            public String convert(Device device) {
                return new StringBuilder().append(device.getTradeName()).append(' ').append(device.getPerfnameCode()).append(' ').append(device.getEntryDate()).append(' ').append(device.getLastChangeDate()).toString();
            }
        };
    }
    
    public Converter<Long, Device> ApplicationConversionServiceFactoryBean.getIdToDeviceConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, ca.gc.hc.mds.domain.Device>() {
            public ca.gc.hc.mds.domain.Device convert(java.lang.Long id) {
                return Device.findDevice(id);
            }
        };
    }
    
    public Converter<String, Device> ApplicationConversionServiceFactoryBean.getStringToDeviceConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, ca.gc.hc.mds.domain.Device>() {
            public ca.gc.hc.mds.domain.Device convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Device.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getApplicationToStringConverter());
        registry.addConverter(getIdToApplicationConverter());
        registry.addConverter(getStringToApplicationConverter());
        registry.addConverter(getCompanyToStringConverter());
        registry.addConverter(getIdToCompanyConverter());
        registry.addConverter(getStringToCompanyConverter());
        registry.addConverter(getCompanyContactToStringConverter());
        registry.addConverter(getIdToCompanyContactConverter());
        registry.addConverter(getStringToCompanyContactConverter());
        registry.addConverter(getCompanyHistoryToStringConverter());
        registry.addConverter(getIdToCompanyHistoryConverter());
        registry.addConverter(getStringToCompanyHistoryConverter());
        registry.addConverter(getDeviceToStringConverter());
        registry.addConverter(getIdToDeviceConverter());
        registry.addConverter(getStringToDeviceConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
