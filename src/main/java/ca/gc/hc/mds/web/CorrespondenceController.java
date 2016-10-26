package ca.gc.hc.mds.web;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.gc.hc.mds.domain.Area;
import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.Correspondence;
import ca.gc.hc.mds.domain.Division;
import ca.gc.hc.mds.reference.YesAndNoType;
import ca.gc.hc.mds.reference.InOutType;
import ca.gc.hc.mds.reference.RegMfgType;
import ca.gc.hc.mds.service.ServiceUtil;

@RequestMapping("/correspondences")
@Controller
@RooWebScaffold(path = "correspondences", formBackingObject = Correspondence.class)
@RooWebFinder
@GvNIXWebJQuery
@SessionAttributes({"arealist","companydetails","divisionlist","regmfgtypes","inouttypes","yesandnotypes"})
public class CorrespondenceController {
	
	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("correspondence_letterdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("correspondence_bfdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }   
	
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "correspondence/index";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Correspondence correspondence, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, correspondence);
            return "correspondences/update";
        }
        
        if (!ServiceUtil.isValueEmpty(correspondence.getSeqcorrId())){
	        Correspondence existing = correspondence.findCorrespondence(correspondence.getSeqcorrId());
	        
	        if (existing.getCorrcompanyId().equals(correspondence.getCorrcompanyId())){
		        correspondence.setAddressLine1(existing.getAddressLine1());
		       	correspondence.setAddressLine2(existing.getAddressLine2());
		       	correspondence.setAddressLine3(existing.getAddressLine3());
		       	correspondence.setCompanyName(existing.getCompanyName());
		       	correspondence.setCity(existing.getCity());
		       	correspondence.setPostalCode(existing.getPostalCode());
		       	correspondence.setCountryCd(existing.getCountryCd());
		       	correspondence.setRegionCd(existing.getRegionCd());
	        }
	        else {
	        	setCompanyInformation(correspondence);
	        }
        }
                     
        ServiceUtil.setAnyNullOrEmptyToDefault(correspondence);
        
        uiModel.asMap().clear();
        if (!ServiceUtil.isValueEmpty(correspondence.getSeqcorrId())){
        	correspondence.merge();    
        }
        else{
        	correspondence.persist();
        }
        String companyDetails = getCompanyInformation(correspondence) ;
        correspondence.setCompanyDetails(companyDetails);
        return "redirect:/correspondences/" + encodeUrlPathSegment(correspondence.getSeqcorrId().toString(), httpServletRequest);
    }
    
    void populateEditForm(Model uiModel, Correspondence correspondence) {
    	List<Area> arealist = Area.findAllAreas(); 
    	List<Division> divisionlist = Division.findAllDivisions();
    	    	  	
    	String companyDetails = getCompanyInformation(correspondence) ;
    	correspondence.setCompanyDetails(companyDetails);
    	uiModel.addAttribute("companyDetails", companyDetails);
    	uiModel.addAttribute("arealist", arealist);
    	uiModel.addAttribute("divisionlist", divisionlist);
    	uiModel.addAttribute("yesandnotypes", Arrays.asList(YesAndNoType.values()));
    	uiModel.addAttribute("regmfgtypes", Arrays.asList(RegMfgType.values()));
    	uiModel.addAttribute("inouttypes", Arrays.asList(InOutType.values()));    	
        uiModel.addAttribute("correspondence", correspondence);
        addDateTimeFormatPatterns(uiModel);
    }
    
    
   
   void setCompanyInformation(Correspondence correspondence){
	   if (correspondence.getCorrcompanyId() != null && correspondence.getCorrcompanyId() != 0){
       	
       	Company comp = Company.findCompany(correspondence.getCorrcompanyId());
       	correspondence.setAddressLine1(comp.getAddressLine1());
       	correspondence.setAddressLine2(comp.getAddressLine2());
       	correspondence.setAddressLine3(comp.getAddressLine3());
       	correspondence.setCompanyName(comp.getCompanyName());
       	correspondence.setCity(comp.getCity());
       	correspondence.setPostalCode(comp.getPostCode());
       	correspondence.setCountryCd(comp.getCountry());
       	correspondence.setRegionCd(comp.getRegion());
       }
   }
   
   String getCompanyInformation(Correspondence correspondence){
	   
		   String companyDetails = correspondence.getCompanyName() + "\n"
					+ correspondence.getAddressLine1() + "," 
					+ correspondence.getCity();
	    return companyDetails;
   }
}
