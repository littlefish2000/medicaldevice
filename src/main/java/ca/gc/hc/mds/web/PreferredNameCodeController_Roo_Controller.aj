// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.PreferredNameCode;
import ca.gc.hc.mds.web.PreferredNameCodeController;
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

privileged aspect PreferredNameCodeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PreferredNameCodeController.create(@Valid PreferredNameCode preferredNameCode, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, preferredNameCode);
            return "preferredNameCodes/create";
        }
        uiModel.asMap().clear();
        preferredNameCode.persist();
        return "redirect:/preferredNameCodes/" + encodeUrlPathSegment(preferredNameCode.getPrefNameCode().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PreferredNameCodeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new PreferredNameCode());
        return "preferredNameCodes/create";
    }
    
    @RequestMapping(value = "/{prefNameCode}", produces = "text/html")
    public String PreferredNameCodeController.show(@PathVariable("prefNameCode") String prefNameCode, Model uiModel) {
        uiModel.addAttribute("preferrednamecode", PreferredNameCode.findPreferredNameCode(prefNameCode));
        uiModel.addAttribute("itemId", prefNameCode);
        return "preferredNameCodes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PreferredNameCodeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("preferrednamecodes", PreferredNameCode.findPreferredNameCodeEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) PreferredNameCode.countPreferredNameCodes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("preferrednamecodes", PreferredNameCode.findAllPreferredNameCodes(sortFieldName, sortOrder));
        }
        return "preferredNameCodes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PreferredNameCodeController.update(@Valid PreferredNameCode preferredNameCode, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, preferredNameCode);
            return "preferredNameCodes/update";
        }
        uiModel.asMap().clear();
        preferredNameCode.merge();
        return "redirect:/preferredNameCodes/" + encodeUrlPathSegment(preferredNameCode.getPrefNameCode().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{prefNameCode}", params = "form", produces = "text/html")
    public String PreferredNameCodeController.updateForm(@PathVariable("prefNameCode") String prefNameCode, Model uiModel) {
        populateEditForm(uiModel, PreferredNameCode.findPreferredNameCode(prefNameCode));
        return "preferredNameCodes/update";
    }
    
    @RequestMapping(value = "/{prefNameCode}", method = RequestMethod.DELETE, produces = "text/html")
    public String PreferredNameCodeController.delete(@PathVariable("prefNameCode") String prefNameCode, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PreferredNameCode preferredNameCode = PreferredNameCode.findPreferredNameCode(prefNameCode);
        preferredNameCode.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/preferredNameCodes";
    }
    
    void PreferredNameCodeController.populateEditForm(Model uiModel, PreferredNameCode preferredNameCode) {
        uiModel.addAttribute("preferredNameCode", preferredNameCode);
    }
    
    String PreferredNameCodeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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