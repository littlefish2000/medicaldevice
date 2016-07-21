package ca.gc.hc.mds.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.Device;
import ca.gc.hc.mds.domain.PreferredNameKeyword;


@RequestMapping("preferredNameKeywords")
@Controller
@RooWebScaffold(path = "preferredNameKeywords", formBackingObject = PreferredNameKeyword.class)
@RooWebFinder
@GvNIXWebJQuery
public class PreferredNameKeywordController {
	
}
