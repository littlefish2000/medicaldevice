package ca.gc.hc.mds.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;


import ca.gc.hc.mds.domain.RenAuthCompanyPK;
import ca.gc.hc.mds.domain.RenLicenceInfoPK;
import ca.gc.hc.mds.reference.InOutType;
import ca.gc.hc.mds.reference.LicenceStatusType;
import ca.gc.hc.mds.reference.RegMfgType;
import ca.gc.hc.mds.reference.StatusType;
import ca.gc.hc.mds.reference.YesAndNoType;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    Converter<RenAuthCompanyPK, String> getRenAuthCompanyPKConverter() {
        return new Converter<RenAuthCompanyPK, String>() {
            public String convert(RenAuthCompanyPK properties) {
                return properties.getCompanyAuthId().toString()+' '+properties.getRenewalRunDt().toString();      // 1
            }
        };
    }	
    
    Converter<LicenceStatusType, String> getLicenceStatusTypeConverter() {
        return new Converter<LicenceStatusType, String>() {
            public String convert(LicenceStatusType properties) {
                switch(properties){
                case C:
                    return "Cancelled";
                case D:
                    return "Issued/Conditiona";
                case I:
                    return "Issued/Active";
                case M:
                    return "Merged";
                case O:
                    return "Discontinued at Renewal";
                case P:
                    return "Pending signature";
                case R:
                    return "Cancelled Renewal No Response";
                case S:
                    return "Suspended";   
                case W:
                    return "Withdrawn";
                case Q:
                    return "Suspended/Invalid QS Certificate";
                case X:
                    return "Cancelled QS/2003";                      
                default: throw new AssertionError();
                }

            }
        };
    }	    
    
    Converter<YesAndNoType, String> geYesAndNoTypeConverter() {
        return new Converter<YesAndNoType, String>() {
            public String convert(YesAndNoType properties) {
                switch(properties){
                case Y:
                    return "Yes";
                case N:
                    return "No";
                default: throw new AssertionError();
                }

            }
        };
    }	    
    
    
    Converter<StatusType, String> getStatusTypeConverter() {
        return new Converter<StatusType, String>() {
            public String convert(StatusType properties) {
                switch(properties){
                case A:
                    return "Active";
                case I:
                    return "InActive";
                case D:
                    return "Duplicate";
                case X:
                    return "Internet Addr.";
                default: throw new AssertionError();
                }

            }
        };
    }	    
    
    Converter<RenLicenceInfoPK, String> getRenLicenceInfoPKConverter() {
        return new Converter<RenLicenceInfoPK, String>() {
            public String convert(RenLicenceInfoPK properties) {
                return properties.getCompanyAuthId().toString()+' '+properties.getCompanyId().toString()
                		+' '+properties.getOriginalLicenceNo().toString()+' '+properties.getRenewalRunDt().toString();      // 1
            }
        };
    }    
    Converter<RegMfgType, String> getRegMfgTypeConverter() {
        return new Converter<RegMfgType, String>() {
            public String convert(RegMfgType properties) {
                switch(properties){
                case R:
                    return "Regulatory";
                case M:
                    return "Manufacturer";
                default: throw new AssertionError();
                }

            }
        };
    }
    
    Converter<InOutType, String> getInOutTypeConverter() {
        return new Converter<InOutType, String>() {
            public String convert(InOutType properties) {
                switch(properties){
                case I:
                    return "In";
                case O:
                    return "Out";
                default: throw new AssertionError();
                }

            }
        };
    }
    
	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
		registry.addConverter(getRenAuthCompanyPKConverter());
		registry.addConverter(getRenLicenceInfoPKConverter());
		registry.addConverter(getLicenceStatusTypeConverter());
		registry.addConverter(geYesAndNoTypeConverter());
		registry.addConverter(getStatusTypeConverter());
		registry.addConverter(getRegMfgTypeConverter());
		registry.addConverter(getInOutTypeConverter());
	}
}
