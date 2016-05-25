// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Application, String> ApplicationConversionServiceFactoryBean.getApplicationToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<ca.gc.hc.mds.domain.Application, java.lang.String>() {
            public String convert(Application application) {
                return new StringBuilder().append(application.getApplcationName()).append(' ').append(application.getOrginLicenseId()).append(' ').append(application.getEntryDate()).append(' ').append(application.getReceiptDate()).toString();
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
                return new StringBuilder().append(company.getCompanyName()).append(' ').append(company.getAddressLine1()).append(' ').append(company.getAddressLine2()).append(' ').append(company.getPostCode()).toString();
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
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getApplicationToStringConverter());
        registry.addConverter(getIdToApplicationConverter());
        registry.addConverter(getStringToApplicationConverter());
        registry.addConverter(getCompanyToStringConverter());
        registry.addConverter(getIdToCompanyConverter());
        registry.addConverter(getStringToCompanyConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
