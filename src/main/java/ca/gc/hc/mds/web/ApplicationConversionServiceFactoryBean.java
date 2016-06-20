package ca.gc.hc.mds.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;


import ca.gc.hc.mds.domain.RenAuthCompanyPK;

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
	
	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
		registry.addConverter(getRenAuthCompanyPKConverter());
	}
}
