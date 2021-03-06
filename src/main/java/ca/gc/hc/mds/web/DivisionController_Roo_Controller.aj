// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Division;
import ca.gc.hc.mds.web.DivisionController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect DivisionController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String DivisionController.create(@Valid Division division, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, division);
            return "maintenance/codetable/division/create";
        }
        uiModel.asMap().clear();
        division.persist();
        return "redirect:/maintenance/codetable/division/" + encodeUrlPathSegment(division.getDivisionCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String DivisionController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Division());
        return "maintenance/codetable/division/create";
    }
    
    @RequestMapping(value = "/{divisionCd}", produces = "text/html")
    public String DivisionController.show(@PathVariable("divisionCd") String divisionCd, Model uiModel) {
        uiModel.addAttribute("division", Division.findDivision(divisionCd));
        uiModel.addAttribute("itemId", divisionCd);
        return "maintenance/codetable/division/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String DivisionController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("divisions", Division.findDivisionEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Division.countDivisions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("divisions", Division.findAllDivisions(sortFieldName, sortOrder));
        }
        return "maintenance/codetable/division/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String DivisionController.update(@Valid Division division, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, division);
            return "maintenance/codetable/division/update";
        }
        uiModel.asMap().clear();
        division.merge();
        return "redirect:/maintenance/codetable/division/" + encodeUrlPathSegment(division.getDivisionCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{divisionCd}", params = "form", produces = "text/html")
    public String DivisionController.updateForm(@PathVariable("divisionCd") String divisionCd, Model uiModel) {
        populateEditForm(uiModel, Division.findDivision(divisionCd));
        return "maintenance/codetable/division/update";
    }
    
    @RequestMapping(value = "/{divisionCd}", method = RequestMethod.DELETE, produces = "text/html")
    public String DivisionController.delete(@PathVariable("divisionCd") String divisionCd, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Division division = Division.findDivision(divisionCd);
        division.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/division";
    }
    
    void DivisionController.populateEditForm(Model uiModel, Division division) {
        uiModel.addAttribute("division", division);
    }
    
    String DivisionController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
