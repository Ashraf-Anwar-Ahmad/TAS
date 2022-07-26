package com.icg.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icg.model.ContrabandThreat;
import com.icg.model.CounterThreat;
import com.icg.model.DropdownMaster;
import com.icg.model.HumanTrafficing;
import com.icg.model.NarcoticThreat;
import com.icg.model.SatelliteAndOther;
import com.icg.model.ThreatCheck;
import com.icg.model.ThreatReceive;
import com.icg.model.User;
import com.icg.model.ViewPDFBean;
import com.icg.service.RolesService;
import com.icg.service.SearchThreatService;
import com.icg.service.TestService;
import com.icg.service.ThreatService;
import com.icg.service.UserService;
import com.icg.service.UtilsService;
import com.icg.util.MessageExtension;
import com.icg.util.VMSUtils;
import com.icg.util.convertToString;

@Controller
public class AppController {

	@Autowired
	UtilsService utilsService;

	@Autowired
	UserService userService;

	@Autowired
	RolesService rolesService;

	@Autowired
	TestService testService;

	@Autowired
	ThreatService threatService;

	@Autowired
	SearchThreatService searchThreatService;

	// Author:- Keshav Dutta
	// Start

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		/*
		 * session.setAttribute("userId", new
		 * String(Base64.decode(request.getParameter("userId").toString().getBytes())));
		 */
		// System.out.println(new
		// String(Base64.decode(request.getParameter("userId").toString().getBytes())));
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response, @ModelAttribute("user") User user) {

		try {
			String userName = user.getUserId();
			String password = user.getPassword();
			// byte[] bytesEncoded = Base64.encode(password.getBytes());
			// String test=new String(bytesEncoded);
			// System.out.println("encoded value is " + test);
			// byte[] valueDecoded = Base64.decode(test.getBytes());
			// System.out.println("Decoded value is " + new String(valueDecoded));
			String responce = userService.validateUser(userName, password);
			if (responce.equals("T"))
			// if (userName.equalsIgnoreCase("admin") &&
			// password.equalsIgnoreCase("admin123"))
			{
				// System.out.println("in if condition--"+userName+"--password--"+password);
				List<DropdownMaster> threatList = utilsService.getMaster("", "THREAT_TYPE");
				List<DropdownMaster> orgnList = utilsService.getMaster("", "ORIGINATOR");
				List<DropdownMaster> grdList = utilsService.getMaster("", "GRADING");
				List<DropdownMaster> rgnList = utilsService.getMaster("", "REGION");
				List<DropdownMaster> cstlstList = utilsService.getMaster("", "COASTAL_STATE");
				List<DropdownMaster> shrdwtList = utilsService.getMaster("", "SHARED_WITH");
				List<DropdownMaster> vsltpList = utilsService.getMaster("", "VESSEL_TYPE");
				List<DropdownMaster> rlgnList = utilsService.getMaster("", "RELIGION");
				List<DropdownMaster> unitList = utilsService.getMaster("", "UNIT");
				List<DropdownMaster> marrstList = utilsService.getMaster("", "MARITAL_STATUS");
				List<DropdownMaster> narcoList = utilsService.getMaster("", "NARCOTIC_TYPE");
				List<DropdownMaster> locList = utilsService.getMaster("", "LOCATION");
				List<DropdownMaster> idProofList = utilsService.getMaster("", "ID_PROOF");// (0406)
				List<DropdownMaster> weightUnitList = utilsService.getMaster("", "UNITS_QTY");
				List<DropdownMaster> boatTypeList = utilsService.getMaster("", "BOAT_TYPE");
				List<DropdownMaster> contrabandTypeList = utilsService.getMaster("", "CONTRABAND_TYPE");

				List<DropdownMaster> distanceTypeList = utilsService.getMaster("", "DISTANCE");
				List<DropdownMaster> placeTypeList = utilsService.getMaster("", "PLACE");
				List<DropdownMaster> satTypeList = utilsService.getMaster("", "SATELLITE_INTERCEPTION");

				// unitList.forEach(System.out::println);

				session.setAttribute("threatList", threatList);
				session.setAttribute("orgnList", orgnList);
				session.setAttribute("grdList", grdList);
				session.setAttribute("rgnList", rgnList);
				session.setAttribute("cstlstList", cstlstList);
				session.setAttribute("shrdwtList", shrdwtList);
				session.setAttribute("vsltpList", vsltpList);
				session.setAttribute("rlgnList", rlgnList);
				session.setAttribute("unitList", unitList);
				session.setAttribute("marrstList", marrstList);
				session.setAttribute("narcoList", narcoList);
				session.setAttribute("locList", locList);// (0406)
				session.setAttribute("idProofList", idProofList);
				session.setAttribute("weightUnitList", weightUnitList);
				session.setAttribute("boatTypeList", boatTypeList);
				session.setAttribute("contrabandTypeList", contrabandTypeList);
				session.setAttribute("distanceTypeList", distanceTypeList);
				session.setAttribute("placeTypeList", placeTypeList);
				session.setAttribute("satTypeList", satTypeList);

				return "redirect:/addThreat";
			} else {
				// System.out.println("in else condition--"+userName+"--password--"+password);
				redirectAttributes.addFlashAttribute("error", MessageExtension.LOGIN_MESSAGE_ERROR);
				return "redirect:/";

			}
		}
		// catch (LoginException e) {
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	public String loginProcess2(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes,
			HttpServletResponse response, @ModelAttribute("user") User user) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			return "redirect:/addThreat";
		} else {
			redirectAttributes.addFlashAttribute("error", MessageExtension.LOGIN_MESSAGE_ERROR);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/loggedOut", method = RequestMethod.GET)
	public String showReLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("loggedout", "You have been Successfully logged out!");
		return "redirect:/";
	}

	@RequestMapping(value = { "version" }, method = RequestMethod.GET)
	public ModelAndView version(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			// System.out.println("test");
			ModelAndView mav = new ModelAndView("version");
			return mav;
		} else {
			// System.out.println("session invalidate ");
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	// contrabandSmuggle keshav start

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody List<DropdownMaster> getList(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("param");
		List<DropdownMaster> list = utilsService.getMaster(id, "COASTAL_STATE");
		String sendDrop = convertToString.changeDropdown(list);
		// System.out.println(" list :: "+sendDrop);
		return list;
	}

	@RequestMapping(value = "/getCheckInput", method = RequestMethod.GET)
	public @ResponseBody String getCheckInput(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("param");
		// System.out.println("ID :: "+id);
		String status = utilsService.checkInputId(id);
		// System.out.println(" getCheckInput status :: "+status);
		return status;
	}

	@RequestMapping(value = { "threatAlert" }, method = RequestMethod.POST)
	public @ResponseBody List<ThreatReceive> threatAlert(@RequestBody ThreatCheck threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		// System.out.println("Enter in threat-- ");
		// System.out.println("group=="+threat.toString());
		List<ThreatReceive> response = threatService.getList(threat);
		return response;
	}

	@RequestMapping(value = { "addThreat" }, method = RequestMethod.GET)
	public ModelAndView addThreat(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {

		if (request.getSession(false).getAttribute("threatList") != null) {
			// System.out.println("test=="+request.getParameter("id"));
			VMSUtils.setUpdatedSessionValue(session);
			ModelAndView mav = new ModelAndView("addThreat");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "contrabandSmuggle" }, method = RequestMethod.GET)
	public ModelAndView contrabandSmuggle(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			//// System.out.println("test==" + request.getParameter("id"));
			ModelAndView mav = new ModelAndView("contrabandSmuggle");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "saveGroupDetails" }, method = RequestMethod.POST)
	public @ResponseBody String saveGroupDetails(@RequestBody ContrabandThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {
				if (saveGroupForm.getInputId() != null && !saveGroupForm.getInputId().isEmpty()) {
					if (!uploadedInputId.trim().equals(saveGroupForm.getInputId().trim())) {
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.CONTRABANDSMUGGLE + "/";// obunto
						// String PATH = MessageExtension.MASTERDIRECTORY +
						// MessageExtension.CONTRABANDSMUGGLE + "\\"; // windows
//						String PATH = "/Users/mac/Desktop/" + MessageExtension.CONTRABANDSMUGGLE + "\\"; // for mac
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(saveGroupForm.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			// System.out.println(saveGroupForm + "saveGroupForm");
			String response = threatService.add(saveGroupForm);

			// String response="Success";
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "successPage" }, method = RequestMethod.GET)
	public ModelAndView successSubmission1(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			ModelAndView mav = new ModelAndView("successSubmission");
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "errorSubmission" }, method = RequestMethod.GET)
	public ModelAndView errorSubmission(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("errorSubmission");
			return mav;
		} else {
			session.invalidate();
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "updateContraband" }, method = RequestMethod.GET)
	public ModelAndView updateContraband(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {

		if (request.getSession(false).getAttribute("threatList") != null) {
			// System.out.println("test");
			ModelAndView mav = new ModelAndView("updateContraband");
			ContrabandThreat threat = threatService.findById(request.getParameter("id"));
			// get input id end....
			String sendList = convertToString.change(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);
			// Added by Rakesh
			// get input id start....
			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";
			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.CONTRABANDSMUGGLE, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "updateGroupDetails" }, method = RequestMethod.POST)
	public @ResponseBody String updateGroupDetails(@RequestBody ContrabandThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {

		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("Enter in updateGroupDetails-- ");
			// System.out.println("group=="+saveGroupForm.toString());
			String response = threatService.update(saveGroupForm);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}

	}

	// counterTerrorism
	@RequestMapping(value = { "counterTerrorism" }, method = RequestMethod.GET)
	public ModelAndView counterTerrorism(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("counterTerrorism");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "saveCounterDetails" }, method = RequestMethod.POST)
	public @ResponseBody String saveCounterDetails(@RequestBody CounterThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {
				if (saveGroupForm.getInputId() != null && !saveGroupForm.getInputId().isEmpty()) {
					if (!uploadedInputId.trim().equals(saveGroupForm.getInputId().trim())) {
						// String PATH =
						// MessageExtension.MASTERDIRECTORY+MessageExtension.COUNTER_TERRORIST+"/";//obunto
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.CONTRABANDSMUGGLE + "\\"; // windows
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(saveGroupForm.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			// End
			String response = threatService.addCounter(saveGroupForm);
			return response;

		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}

	}

	// below for update counter terrorism
	@RequestMapping(value = { "updateCounter" }, method = RequestMethod.GET)
	public ModelAndView updateCounter(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("test");
			ModelAndView mav = new ModelAndView("updateCounter");

			CounterThreat threat = threatService.findCounterById(request.getParameter("id"));
			String sendList = convertToString.changecounter(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);
			// Added by Rakesh
			// get input id start....
			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";
			// System.out.println(" update
			// inputId=========================================="+inputId);
			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.COUNTER_TERRORIST, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "updateCounterDetails" }, method = RequestMethod.POST)
	public @ResponseBody String updateCounterDetails(@RequestBody CounterThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String response = threatService.updateCounter(saveGroupForm);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	// narcotics
	@RequestMapping(value = { "narcotics" }, method = RequestMethod.GET)
	public ModelAndView narcotics(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("test");
			ModelAndView mav = new ModelAndView("narcotics");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "saveNarcoticDetails" }, method = RequestMethod.POST)
	public @ResponseBody String saveNarcoticDetails(@RequestBody NarcoticThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {
				if (saveGroupForm.getInputId() != null && !saveGroupForm.getInputId().isEmpty()) {
					if (!uploadedInputId.trim().equals(saveGroupForm.getInputId().trim())) {
						// String PATH =
						// MessageExtension.MASTERDIRECTORY+MessageExtension.NARCOTICSSMUGGLEING+"/";//obunto
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.NARCOTICSSMUGGLEING + "\\";// windows
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(saveGroupForm.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			// End
			String response = threatService.addNarcotic(saveGroupForm);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	// below for update narcotics
	@RequestMapping(value = { "updateNarcotic" }, method = RequestMethod.GET)
	public ModelAndView updateNarcotic(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("test");
			ModelAndView mav = new ModelAndView("updateNarcotic");

			NarcoticThreat threat = threatService.findNarcoticById(request.getParameter("id"));
			String sendList = convertToString.changenarco(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);

			// Added by Rakesh
			// get input id start....
			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";

			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.NARCOTICSSMUGGLEING, inputId.trim());
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "updateNarcoticDetails" }, method = RequestMethod.POST)
	public @ResponseBody String updateNarcoticDetails(@RequestBody NarcoticThreat saveGroupForm,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("Enter in updateCounterDetails-- ");
			// System.out.println("group=="+saveGroupForm.toString());
			String response = threatService.updateNarcotic(saveGroupForm);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	// humanTrafficking

	@RequestMapping(value = { "humanTrafficking" }, method = RequestMethod.GET)
	public ModelAndView humanTrafficking(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("humanTrafficking");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "savehumanTrafficking" }, method = RequestMethod.POST)
	public @ResponseBody String saveHumanTrafficking(@RequestBody HumanTrafficing threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {
				if (threat.getInputId() != null && !threat.getInputId().isEmpty()) {
					if (!uploadedInputId.trim().equals(threat.getInputId().trim())) {
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.HUMANTRAFFICKING + "\\";// windows
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(threat.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			String response = threatService.save(threat);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "updateHumanTrafficking" }, method = RequestMethod.GET)
	public ModelAndView updateHumanTrafficking(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("test");
			ModelAndView mav = new ModelAndView("updateHumntrafficking");

			HumanTrafficing threat = threatService.findHumanTraffickingById(request.getParameter("id"));

			// get input id end....
			String sendList = convertToString.getJson(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);

			// Added by Rakesh
			// get input id start....
			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";
			// System.out.println(" update
			// inputId=========================================="+inputId);
			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.HUMANTRAFFICKING, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "updateHumanTraffickingData" }, method = RequestMethod.POST)
	public @ResponseBody String updateHumanTraffickingData(@RequestBody HumanTrafficing threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {

		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("Enter in update human Details-- ");
			// System.out.println("group=="+threat.toString());
			String response = threatService.updateHumanTrafficking(threat);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}
	// humantrafficking1

	// Satelight & Others

	// Added By Rakesh kumar for file Upload Start

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> fileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		int count = 0;
		String threatFolder = request.getParameter("threatFolder");
		String threatId = request.getParameter("id");
// create the folder directory ...

		String directoryName = MessageExtension.MASTERDIRECTORY + threatFolder + "/" + threatId; // obuntu
//		String directoryName = MessageExtension.MASTERDIRECTORY + threatFolder + "\\" + threatId; // windows
//		directoryName = "/Users/mac/Documents/" + threatFolder + "/" + threatId;
//		System.out.println(">>>" + directoryName + "<<<directoryName" + "threatId" + threatId);

		String uploadTime = request.getParameter("uploadTime");
		if (uploadTime != null && !uploadTime.isEmpty() && uploadTime.equals("f1")) {
			VMSUtils.removeDirectory(new File(directoryName));

		}

		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			if (!mpf.getOriginalFilename().isEmpty()) {
				BufferedOutputStream outputStream;
				try {
					File directory = new File(directoryName);
					// Create the Directory
//				if (directory.canWrite())
//						System.out.println("Can be written");
//					else
//						System.out.println("Cannot be written");

					if (!directory.exists()) {

						directory.mkdir();
					}

					outputStream = new BufferedOutputStream(
							new FileOutputStream(new File(directoryName, mpf.getOriginalFilename())));
					outputStream.write(mpf.getBytes());
					outputStream.flush();
					outputStream.close();
					count++;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}

		map.put("Status", 200);
		map.put("count", count);
		return map;
	}

	@RequestMapping(value = "/fileUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> fileUpdate(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		int ucount = 0;
		int dcount = 0;
		String threatFolder = request.getParameter("threatFolder");
		String threatId = request.getParameter("id");

		// String directoryName =
		// MessageExtension.MASTERDIRECTORY+threatFolder+"/"+threatId;// obunto
		String directoryName = MessageExtension.MASTERDIRECTORY + threatFolder + "\\" + threatId; // windows

		Map<String, Object> map = new HashMap<String, Object>();

		// Delete the images;;
		String noOfFileToDel = request.getParameter("noOfFileToDel");
		int l = Integer.valueOf(noOfFileToDel).intValue();

		for (int i = 0; i < l; i++) {
			String fileToDel = request.getParameter("filetoDel_" + i);
			// String path = directoryName+"/";//obunto
			String path = directoryName + "\\"; // windows

			if (fileToDel != null && !fileToDel.isEmpty()) {
				path = path + fileToDel.trim();
				// System.out.println("path==="+path);
				File f = new File(path);
				// delete file
				if (f.delete())
					dcount++;
				else
					System.out.println("File was not deleted");
			}
		}

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			// System.out.println("filename========"+mpf.getOriginalFilename());

			if (!mpf.getOriginalFilename().isEmpty()) {
				BufferedOutputStream outputStream;
				try {
					File directory = new File(directoryName);
					if (!directory.exists()) {
						directory.mkdir();

					}
					outputStream = new BufferedOutputStream(
							new FileOutputStream(new File(directoryName, mpf.getOriginalFilename())));
					outputStream.write(mpf.getBytes());
					outputStream.flush();
					outputStream.close();

					ucount++;
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}

		}

		// Getting list of file from folder
		List<String> fileNames = VMSUtils.getAllFilenames(threatFolder, threatId);
		map.put("Status", 200);
		map.put("fileNames", fileNames);
		map.put("ucount", ucount);
		map.put("dcount", dcount);
		return map;
	}

	// To View image /doc file
	@RequestMapping(value = { "/viewdoc" }, method = RequestMethod.GET)
	public String getModLetter(@RequestParam("fileName") String fileName, @RequestParam("inputId") String inputId,
			@RequestParam("threatFolder") String threatFolder, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {

		if (request.getSession(false).getAttribute("threatList") != null) {

			if (fileName != null && !fileName.isEmpty()) {
				String documentName = fileName.trim();
				// String path =
				// MessageExtension.MASTERDIRECTORY+threatFolder+"/"+inputId+"/"+fileName;
				// //obunto
				String path = MessageExtension.MASTERDIRECTORY + threatFolder + "\\" + inputId + "\\" + fileName; // windows
				File file = new File(path);

				byte[] documentByteArray = VMSUtils.readFileToByteArray(file);
				if (documentName.indexOf("doc") > 0 || documentName.indexOf("docx") > 0 || documentName.contains(".doc")
						|| documentName.contains(".docx")) {
					response.setContentType("application/msword");
					response.setHeader("Content-disposition", "inline; filename=" + documentName);
				}

				response.setContentLength(documentByteArray.length);
				response.getOutputStream().write(documentByteArray);
			}

			return null;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}
	// Added By Rakesh kumar for file Upload End

	@RequestMapping(value = { "satelliteInterception" }, method = RequestMethod.GET)
	public ModelAndView satelliteInterception(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			ModelAndView mav = new ModelAndView("satelliteInterception");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "saveSatelliteInterception" }, method = RequestMethod.POST)
	public @ResponseBody String saveSatelliteInterception(@RequestBody SatelliteAndOther threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {

				if (threat.getInputId() != null && !threat.getInputId().isEmpty()) {

					if (!uploadedInputId.trim().equals(threat.getInputId().trim())) {
						// String PATH =
						// MessageExtension.MASTERDIRECTORY+MessageExtension.SATELLITE_INTERCEPTION+"/";
						// //obunto
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.SATELLITE_INTERCEPTION + "\\"; // windows
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(threat.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			String response = threatService.save(threat);
			return response;

		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}

	}

	@RequestMapping(value = { "updateSatelliteInterceptionPage" }, method = RequestMethod.GET)
	public ModelAndView updateSatelliteInterceptionPage(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {

		if (request.getSession(false).getAttribute("threatList") != null) {

			ModelAndView mav = new ModelAndView("updatesatelliteInterception");

			SatelliteAndOther threat = threatService.findSatelliteAndOtherById(request.getParameter("id"));

			String sendList = convertToString.getJson(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);

			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";
			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.SATELLITE_INTERCEPTION, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = { "updateSatelliteInterception" }, method = RequestMethod.POST)
	public @ResponseBody String updateSatelliteInterception(@RequestBody SatelliteAndOther threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			String response = threatService.update(threat);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	// otherThreat

	@RequestMapping(value = { "others" }, method = RequestMethod.GET)
	public ModelAndView otherThreat(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			// System.out.println("test");
			ModelAndView mav = new ModelAndView("otherThreat");
			mav.addObject("chngId", request.getParameter("id"));
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "saveOthers" }, method = RequestMethod.POST)
	public @ResponseBody String saveOthers(@RequestBody SatelliteAndOther threat, RedirectAttributes redirectAttributes,
			HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String uploadedInputId = request.getParameter("uploadedInputId");
			if (uploadedInputId != null && !uploadedInputId.isEmpty()) {
				if (threat.getInputId() != null && !threat.getInputId().isEmpty()) {
					if (!uploadedInputId.trim().equals(threat.getInputId().trim())) {
						// String PATH =
						// MessageExtension.MASTERDIRECTORY+MessageExtension.OTHER_THREAT+"/";//obunto
						String PATH = MessageExtension.MASTERDIRECTORY + MessageExtension.OTHER_THREAT + "\\";// windows
						File sourceFile = new File(PATH.concat(uploadedInputId));
						File destFile = new File(PATH.concat(threat.getInputId()));
						VMSUtils.renameDirectory(sourceFile, destFile);
					}
				}
			}
			String response = threatService.saveOther(threat);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "updateOtherPage" }, method = RequestMethod.GET)
	public ModelAndView updateOtherPage(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		if (request.getSession(false).getAttribute("threatList") != null) {

			ModelAndView mav = new ModelAndView("updateOtherThreat");

			SatelliteAndOther threat = threatService.findSatelliteAndOtherById(request.getParameter("id"));

			String sendList = convertToString.getJson(threat);
			List<DropdownMaster> cstlstList = utilsService.getMaster(threat.getRegionId(), "COASTAL_STATE");
			mav.addObject("chncoastlst", cstlstList);
			mav.addObject("list", sendList);

			String inputId = threat.getInputId() != null ? threat.getInputId().trim() : "";
			List<String> fileNames = VMSUtils.getAllFilenames(MessageExtension.OTHER_THREAT, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "updateOther" }, method = RequestMethod.POST)
	public @ResponseBody String updateOther(@RequestBody SatelliteAndOther threat,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			String response = threatService.updateOther(threat);
			return response;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "search" }, method = RequestMethod.GET)
	public ModelAndView search(RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			ModelAndView mav = new ModelAndView("search");
			List<DropdownMaster> selectTypeList = new ArrayList<DropdownMaster>();
			String type = "SEARCH";
			selectTypeList = utilsService.getMaster("", type);
			mav.addObject("searchByList", selectTypeList);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = "/getSearchCombo", method = RequestMethod.GET)
	public @ResponseBody List<DropdownMaster> getSearchCombo(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		List<DropdownMaster> dropDownList = null;
		Map<String, String> selectType = new HashMap<>();
		String refData = request.getParameter("refData");
		selectType.put("0004", "REGION");
		selectType.put("0005", "COASTAL_STATE");
		selectType.put("0006", "LOCATION");
		selectType.put("0002", "CONTRABAND_TYPE");
		selectType.put("0003", "NARCOTIC_TYPE");
		selectType.put("0010", "VESSEL_TYPE");
		selectType.put("0018", "ORIGINATOR");
		selectType.put("0019", "GRADING");
		String type = "";
		if (selectType.containsKey(refData)) {
			type = selectType.get(refData);
		}
		dropDownList = utilsService.getMaster("", type);
		return dropDownList;
	}

	/*
	 * @RequestMapping(value = "/getSearchThreatList", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String getSearchThreatList(@RequestParam("searchBy")
	 * String searchBy,
	 * 
	 * @RequestParam("searchTerm") String searchTerm, HttpSession session,
	 * HttpServletRequest request, RedirectAttributes redirectAttributes) { if
	 * (request.getSession(false).getAttribute("threatList") != null) {
	 * System.out.println("getSearchThreatList--if"); String searchBeanJson =
	 * searchThreatService.getSearchThreatList(searchBy, searchTerm); return
	 * searchBeanJson; } else { System.out.println("getSearchThreatList--else");
	 * session.invalidate(); redirectAttributes.addFlashAttribute("error",
	 * MessageExtension.SESSION_EXP_MSG); return "redirect:/"; } }
	 */

	@RequestMapping(value = "/getSearchThreatList", method = RequestMethod.GET)
	@ResponseBody
	public String getSearchThreatList(@RequestParam("imeiNo") String imeiNo,
			@RequestParam("contactNo") String contactNo, @RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude, @RequestParam("region") String region,
			@RequestParam("state") String state, @RequestParam("location") String location,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("boatName") String boatName, @RequestParam("vesselName") String vesselName,
			@RequestParam("crewName") String crewName, @RequestParam("inputId") String inputId,
			@RequestParam("threatType") String threatType, @RequestParam("narcoticType") String narcoticType,
			@RequestParam("contrabandType") String contrabandType, @RequestParam("boatRegNo") String boatRegNo,
			@RequestParam("boatPortOfReg") String boatPortOfReg, @RequestParam("boatLPC") String boatLPC,
			@RequestParam("boatNPC") String boatNPC, @RequestParam("originator") String originator,
			@RequestParam("grading") String grading,
			@RequestParam("vesselFlagAndPortOfReg") String vesselFlagAndPortOfReg, HttpSession session,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			String searchBeanJson = searchThreatService.getSearchThreatList(imeiNo, contactNo, latitude, longitude,
					region, state, location, fromDate, toDate, boatName, vesselName, crewName, inputId, threatType,
					narcoticType, contrabandType, boatRegNo, boatPortOfReg, boatLPC, boatNPC, originator, grading,
					vesselFlagAndPortOfReg);
			return searchBeanJson;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "view" }, method = RequestMethod.GET)
	public ModelAndView view(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("view");
			VMSUtils.setUpdatedSessionValue(session);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = "/getViewThreatList", method = RequestMethod.GET)
	@ResponseBody
	public String getViewThreatList(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			String searchBeanJson = searchThreatService.getViewList();
			// System.out.println("getViewThreatList--"+searchBeanJson);
			return searchBeanJson;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "threatHistory" }, method = RequestMethod.GET)
	public ModelAndView threatHistory(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			VMSUtils.setUpdatedSessionValue(session);
			ModelAndView mav = new ModelAndView("threatHistory");
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}

	@RequestMapping(value = "/getThreatHistoryList", method = RequestMethod.GET)
	@ResponseBody
	public String getThreatHistoryList(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {

			String searchBeanJson = searchThreatService.getThreatHistoryList();
			// System.out.println("history--"+searchBeanJson.toString());
			return searchBeanJson;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/viewPDF", method = RequestMethod.GET)
	public ModelAndView viewPDF(@RequestParam("id") String id, HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ViewPDFBean threatData = searchThreatService.getViewPdfList(id);
			return new ModelAndView("pdfView", "threatData", threatData);
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	// ........./rajkumar...............

	// view Dock
	@RequestMapping(value = { "viewDocPage" }, method = RequestMethod.GET)
	public ModelAndView viewDocPage(HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("viewdocument");

			String inputId = request.getParameter("inputId");

			if (inputId != null && !inputId.isEmpty()) {
				inputId = inputId.trim();
			}
			String threadId = request.getParameter("threadId");

			String threatFolder = "";

			if (threadId != null && !threadId.isEmpty()) {

				threadId = threadId.trim();
				switch (threadId) {
				case "0001": {
					threatFolder = MessageExtension.SATELLITE_INTERCEPTION;
					break;
				}
				case "0002": {
					threatFolder = MessageExtension.COUNTER_TERRORIST;
					break;
				}
				case "0003": {
					threatFolder = MessageExtension.NARCOTICSSMUGGLEING;
					break;
				}
				case "0004": {
					threatFolder = MessageExtension.CONTRABANDSMUGGLE;
					break;
				}
				case "0005": {
					threatFolder = MessageExtension.HUMANTRAFFICKING;
					break;
				}
				case "0006": {
					threatFolder = MessageExtension.OTHER_THREAT;
					break;
				}

				}

			}

			List<String> fileNames = VMSUtils.getAllFilenames(threatFolder, inputId);
			mav.addObject("fileNames", fileNames);
			mav.addObject("inputId", inputId);
			mav.addObject("threatFolder", threatFolder);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}

	}
	// ...................map ........................

	@RequestMapping(value = { "viewMapSingle" }, method = RequestMethod.GET)
	public ModelAndView viewMapSingle(@RequestParam("encData") String encData, HttpSession session,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("viewMapSingle");
			byte[] decodedBytes = Base64.getDecoder().decode(encData);
			String[] decData = new String(decodedBytes).split("#~#");
			mav.addObject("lattitude", decData[0]);
			mav.addObject("longitude", decData[1]);
			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = { "viewMap" }, method = RequestMethod.GET)
	public ModelAndView viewMap(@RequestParam("encData") String encData, HttpSession session,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (request.getSession(false).getAttribute("threatList") != null) {
			ModelAndView mav = new ModelAndView("viewMap");
			byte[] decodedBytes = Base64.getDecoder().decode(encData);
			String decData = new String(decodedBytes);
			mav.addObject("mapList", decData);

			return mav;
		} else {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", MessageExtension.SESSION_EXP_MSG);
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	// .................../map testing ........................

}