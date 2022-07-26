package com.icg.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icg.model.Ammunition;
import com.icg.model.Boat;
import com.icg.model.Contact;
import com.icg.model.Crew;
import com.icg.model.Narcotic;
import com.icg.model.PassengerBean;
import com.icg.model.Vessel;
import com.icg.model.ViewPDFBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilder extends AbstractITextPdfView {

	Font topHeading = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	Font subHeading = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ViewPDFBean threatData = (ViewPDFBean) model.get("threatData");
//"0001","Satellite interception","0002","Counter terrorism","0003","Narcotics smuggling","0004","Contraband smuggling","0005","Human trafficking","0006","Others"		

		String threatId = threatData.getThreatTypeId();
		switch (threatId) {

		case "0001": // Satellite interception
			doc = getSatelliteInterceptionFormPdf(doc, threatData);
			break;
		case "0002": // Counter terrorism
			doc = getCounterTerrorismFormPdf(doc, threatData);
			break;
		case "0003": // Narcotics smuggling
			doc = getNarcoticsSmugglingFormPdf(doc, threatData);
			break;
		case "0004": // Contraband smuggling
			doc = getContrabandSmuggleFormPdf(doc, threatData);
			break;
		case "0005": // Human trafficking
			doc = getHumanTraffickingFormPdf(doc, threatData);
			break;
		case "0006": // Others
			doc = getOthersFormPdf(doc, threatData);
			break;
		}// closed switch

	}

	// ....................... Others Form Pdf........................
	Document getOthersFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		Paragraph preface = new Paragraph("Others Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row

		// Font font = FontFactory.getFont(FontFactory.HELVETICA);
		// font.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................
		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}
	// ....................... /Others Form Pdf........................

	// ....................... Satellite interception Form
	// Pdf........................
	Document getSatelliteInterceptionFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		Paragraph preface = new Paragraph("Satellite Interception Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................
		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}
	// ....................... /Satellite Interception Form
	// Pdf........................

	// ....................... Human Trafficking Form Pdf........................
	Document getHumanTraffickingFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		Paragraph preface = new Paragraph("Human Trafficking Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................

		/*
		 * Human Trafficking Details Icg Units Involved,,,,,Latitude (Decimal
		 * Degrees),Longitude (Decimal Degrees),Latitude (Degrees, Minutes,
		 * Seconds),Longitude (Degrees, Minutes, Seconds)
		 */// ..........................Human Trafficking Details ......................
		doc.add(new Paragraph("Human Trafficking Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableSmugglingDetails = new PdfPTable(2);
		tableSmugglingDetails.setWidthPercentage(100);
		tableSmugglingDetails.addCell("Icg Units Involved");
		tableSmugglingDetails
				.addCell((threatData.getIcgUnitsName() != null) ? String.join(",", threatData.getIcgUnitsName()) : "");
		tableSmugglingDetails.addCell("Case handed over to");
		tableSmugglingDetails.addCell(threatData.getCaseHandedTo());
		tableSmugglingDetails.addCell("Joint opertaion with");
		tableSmugglingDetails.addCell(threatData.getJointOperWith());
		tableSmugglingDetails.addCell("No. of Passengers Onboard");
		tableSmugglingDetails.addCell(threatData.getNoOfPass());
		tableSmugglingDetails.addCell("Investigation Agency");
		tableSmugglingDetails.addCell(threatData.getInvesAgency());
		tableSmugglingDetails.addCell("Latitude (Decimal Degrees)");
		tableSmugglingDetails.addCell(threatData.getApplattitudeDec());
		tableSmugglingDetails.addCell("Longitude (Decimal Degrees)");
		tableSmugglingDetails.addCell(threatData.getApplongitudeDec());
		tableSmugglingDetails.addCell("Latitude (Degrees, Minutes, Seconds)");
		tableSmugglingDetails.addCell(threatData.getApplattitudeDeg());
		tableSmugglingDetails.addCell("Longitude (Degrees, Minutes, Seconds)");
		tableSmugglingDetails.addCell(threatData.getApplongitudeDeg());

		doc.add(tableSmugglingDetails);

		// ........................../Counter Terrorism Details ......................

		// ..........................Boat Details ......................

		List<Boat> boatList = threatData.getBoatList();
		if (boatList != null && !boatList.isEmpty()) {
			doc.add(new Paragraph("Boat Details", subHeading));
			PdfPTable table = new PdfPTable(17);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header
			String[] boatRowHeading = { "Name of Boat", "Reg. No.", "Name of Owner", "Port of Reg.", "Number of Crew",
					"Documents Held", "NAV Eqpt Fitted", "Common Eqpt Fitted", "Life Saving Eqpt Fitted", "LPC", "ETD",
					"NPC", "ETA", "License for Fishing", "Owner Contact Details", "Boat Confirming to Colour Code",
					"Remarks" };

			for (int i = 0; i < boatRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(boatRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}

			if (boatList != null && !boatList.isEmpty()) {
				for (Boat data : boatList) {
					table.addCell(data.getBoatName());
					table.addCell(data.getRegNum());
					table.addCell(data.getOwnerName());
					table.addCell(data.getPortReg());
					table.addCell(data.getNoOfCrew());
					table.addCell(data.getDocHeld());
					table.addCell(data.getNavEqpt());
					table.addCell(data.getCommEqpt());
					table.addCell(data.getLifeEqpt());
					table.addCell(data.getBoatlpc());
					table.addCell(data.getBoatetd());
					table.addCell(data.getBoatnpc());
					table.addCell(data.getBoateta());
					table.addCell(data.getLicenseFish());
					table.addCell(data.getOwnerContDts());
					table.addCell(data.getBoatColrcd());
					table.addCell(data.getRemarks());

				}
			} else {
				PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
				c2.setColspan(17);
				table.addCell(c2);
			}
			doc.add(table);
		}
		// ........................../Boat Details ......................
//..........................Vessel details......................

		List<Vessel> vesselList = threatData.getVesselList();
		if (vesselList != null && !vesselList.isEmpty()) {
			doc.add(new Paragraph("Vessel Details", subHeading));
			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row

			/*
			 * Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			 * font1.setColor(BaseColor.BLACK);
			 */
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header

			String[] vesselRowHeading = { "Name of Vessel", "Vessel Type", "International Call Sign", "MMSI", "IMO No.",
					"Cargo", "LPC", "ETD", "NPC", "ETA", "Total Crew", "Flag or Port of Reg.", "Inmarsat No.",
					"Other Comm. Eqpt.", "Agent", "PANS" };

			for (int i = 0; i < vesselRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(vesselRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}
			if (vesselList != null && !vesselList.isEmpty()) {
				for (Vessel data : vesselList) {
					table.addCell(data.getVesselName());
					table.addCell(data.getVesselTypeName());
					table.addCell(data.getIntCallSign());
					table.addCell(data.getMmsi());
					table.addCell(data.getImoNo());
					table.addCell(data.getCargo());
					table.addCell(data.getVessellpc());
					table.addCell(data.getVesseletd());
					table.addCell(data.getVesselnpc());
					table.addCell(data.getVesseleta());
					table.addCell(data.getTotCrew());
					table.addCell(data.getFlgPrtReg());
					table.addCell(data.getInmarsatNo());
					table.addCell(data.getOtherCommEqpt());
					table.addCell(data.getAgent());
					table.addCell(data.getPans());

				}
			} else {
				PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
				c2.setColspan(16);
				table.addCell(c2);
			}
			doc.add(table);
		}
		// ........................../Vessel details. ......................

//..........................Passengers Details......................

		doc.add(new Paragraph("Passengers Details", subHeading));
		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row

		/*
		 * Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
		 * font2.setColor(BaseColor.BLACK);
		 */
		// define table header cell
		PdfPCell cellPassengers = new PdfPCell();
		cellPassengers.setBackgroundColor(BaseColor.WHITE);
		cellPassengers.setPadding(5);
		// write table header
		String[] passengerRowHeading = { "Name", "Age", "Gender", "Nationality", "Address", "Telephone Number",
				"Marital Status", "Profession", "Identification Marks", "Religion" };

		for (int i = 0; i < passengerRowHeading.length; i++) {
			cellPassengers.setPhrase(new Phrase(passengerRowHeading[i], subHeading));
			table.addCell(cellPassengers);
		}
		List<PassengerBean> passengerList = threatData.getPassengerList();
		if (passengerList != null && !passengerList.isEmpty()) {
			for (PassengerBean data : passengerList) {

				table.addCell(data.getName());
				table.addCell(data.getAge());
				table.addCell(data.getGenderDescr());
				table.addCell(data.getNationality());
				table.addCell(data.getAddress());
				table.addCell(data.getTelephoneNumber());
				table.addCell(data.getMaritalStatusDescr());
				table.addCell(data.getProfession());
				table.addCell(data.getIdentificationMarks());
				table.addCell(data.getReligionDescr());
			}
		} else {
			PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
			c2.setColspan(10);
			table.addCell(c2);
		}
		doc.add(table);

		// ........................../Passengers Details. ......................

		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}
//....................... /Human Trafficking Form Pdf........................

	// ....................... Counter Terrorism Form Pdf........................
	Document getCounterTerrorismFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		/*
		 * Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); Font
		 * boldFontSubHeading = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
		 */

		Paragraph preface = new Paragraph("Counter Terrorism Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................

		// ..........................Counter Terrorism Details ......................
		doc.add(new Paragraph("Counter Terrorism Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableContrabandSmugglingDetails = new PdfPTable(2);
		tableContrabandSmugglingDetails.setWidthPercentage(100);
		tableContrabandSmugglingDetails.addCell("Icg Units Involved");
		tableContrabandSmugglingDetails
				.addCell((threatData.getIcgUnitsName() != null) ? String.join(",", threatData.getIcgUnitsName()) : "");
		tableContrabandSmugglingDetails.addCell("Latitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDec());
		tableContrabandSmugglingDetails.addCell("Longitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDec());
		tableContrabandSmugglingDetails.addCell("Latitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDeg());
		tableContrabandSmugglingDetails.addCell("Longitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDeg());

		doc.add(tableContrabandSmugglingDetails);

		// ........................../Counter Terrorism Details ......................

		// ..........................Crew details......................
		doc.add(new Paragraph("Crew Details", subHeading));
		PdfPTable crewtable = new PdfPTable(10);
		crewtable.setWidthPercentage(100.0f);
		crewtable.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		crewtable.setSpacingBefore(10);

		// define font for table header row

		/*
		 * Font font = FontFactory.getFont(FontFactory.HELVETICA);
		 * font.setColor(BaseColor.BLACK);
		 */
		// define table header cell
		PdfPCell cellCrew = new PdfPCell();
		cellCrew.setBackgroundColor(BaseColor.WHITE);
		cellCrew.setPadding(5);
		// write table header

		String[] crewRowHeading = { "Name", "Age", "Nationality", "Address", "Telephone Number", "Marital Status",
				"Profession", "Identification Marks", "Religion", "Details of ID Proof" };

		for (int i = 0; i < crewRowHeading.length; i++) {
			cellCrew.setPhrase(new Phrase(crewRowHeading[i], subHeading));
			crewtable.addCell(cellCrew);
		}

		List<Crew> crewList = threatData.getCrewList();
		if (crewList != null && !crewList.isEmpty()) {
			for (Crew data : crewList) {
				crewtable.addCell(data.getCrName());
				crewtable.addCell(data.getCrAge());
				crewtable.addCell(data.getCrNationality());
				crewtable.addCell(data.getCrAddress());
				crewtable.addCell(data.getCrTelNo());
				crewtable.addCell(data.getCrMartSts());
				crewtable.addCell(data.getCrProfession());
				crewtable.addCell(data.getCrIdenMrks());
				crewtable.addCell(data.getCrRelgn());
				crewtable.addCell(data.getCrDtlsIdPf());

			}
		} else {

			PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
			c2.setColspan(10);
			crewtable.addCell(c2);
		}
		doc.add(crewtable);

		// ........................../Crew details. ......................

		// ..........................Details of Ammunition......................
		doc.add(new Paragraph("Details of Ammunition", subHeading));
		PdfPTable ammunitionTable = new PdfPTable(6);
		ammunitionTable.setWidthPercentage(100.0f);
		ammunitionTable.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		ammunitionTable.setSpacingBefore(10);

		// define font for table header row

		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cellAmmunition = new PdfPCell();
		cellAmmunition.setBackgroundColor(BaseColor.WHITE);
		cellAmmunition.setPadding(5);
		// write table header

		String[] ammunitionRowHeading = { "Type Of Ammunition", "Quantity", "Make", "Model", "Manufacture Country",
				"Remarks" };
		for (int i = 0; i < ammunitionRowHeading.length; i++) {
			cellAmmunition.setPhrase(new Phrase(ammunitionRowHeading[i], font1));
			ammunitionTable.addCell(cellAmmunition);
		}

		List<Ammunition> ammunitionList = threatData.getAmmunitionList();
		if (ammunitionList != null && !ammunitionList.isEmpty()) {
			for (Ammunition data : ammunitionList) {
				ammunitionTable.addCell(data.getTypeAmmun());
				ammunitionTable.addCell(data.getAmmunQty());
				ammunitionTable.addCell(data.getAmmunMake());
				ammunitionTable.addCell(data.getAmmunModel());
				ammunitionTable.addCell(data.getAmmunManuCntry());
				ammunitionTable.addCell(data.getAmmunRmks());

			}
		} else {

			PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
			c2.setColspan(6);
			ammunitionTable.addCell(c2);
		}
		doc.add(ammunitionTable);

		// ........................../Details of Ammunition. ......................

		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}
	// ....................... /Counter Terrorism Form Pdf........................

	// ....................... Narcotics smuggling Form Pdf........................
	Document getNarcoticsSmugglingFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		Paragraph preface = new Paragraph("Narcotics Smuggling Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................

		// ..........................Narcotics Smuggling Details ......................
		doc.add(new Paragraph("Narcotics Smuggling Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableContrabandSmugglingDetails = new PdfPTable(2);
		tableContrabandSmugglingDetails.setWidthPercentage(100);
		tableContrabandSmugglingDetails.addCell("Date & Time of Apprehension");
		tableContrabandSmugglingDetails.addCell(threatData.getApprehensionDt());
		tableContrabandSmugglingDetails.addCell("Icg Units Involved");
		tableContrabandSmugglingDetails
				.addCell((threatData.getIcgUnitsName() != null) ? String.join(",", threatData.getIcgUnitsName()) : "");
		tableContrabandSmugglingDetails.addCell("Worth");
		tableContrabandSmugglingDetails.addCell(threatData.getWorth());
		tableContrabandSmugglingDetails.addCell("Case handed over to");
		tableContrabandSmugglingDetails.addCell(threatData.getCaseHandedTo());
		tableContrabandSmugglingDetails.addCell("Brought to location");
		tableContrabandSmugglingDetails.addCell(threatData.getLocBoughtTo());
		tableContrabandSmugglingDetails.addCell("Joint opertaion with");
		tableContrabandSmugglingDetails.addCell(threatData.getJointOperWith());
		tableContrabandSmugglingDetails.addCell("Latitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDec());
		tableContrabandSmugglingDetails.addCell("Longitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDec());
		tableContrabandSmugglingDetails.addCell("Latitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDeg());
		tableContrabandSmugglingDetails.addCell("Longitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDeg());

		// ...............nested table................
		PdfPCell c2 = new PdfPCell(new Phrase(" Narcotics Type Details  ", subHeading));
		c2.setColspan(2);
		tableContrabandSmugglingDetails.addCell(c2);

		PdfPTable narcoticsTypeDetails = new PdfPTable(2);
		narcoticsTypeDetails.setWidthPercentage(100.0f);
		narcoticsTypeDetails.setSpacingBefore(10);

		// define font for table header row
		// define table header cell
		PdfPCell cell2 = new PdfPCell();
		cell2.setBackgroundColor(BaseColor.WHITE);
		cell2.setPadding(5);
		// write table header
		cell2.setPhrase(new Phrase("Type of Narcotics", subHeading));
		narcoticsTypeDetails.addCell(cell2);

		cell.setPhrase(new Phrase("Quantity", subHeading));
		narcoticsTypeDetails.addCell(cell);
		List<Narcotic> narcoticList = threatData.getNarcoticList();
		if (narcoticList != null && !narcoticList.isEmpty()) {
			for (Narcotic data : narcoticList) {
				narcoticsTypeDetails.addCell(data.getNarcoTypeName());
				narcoticsTypeDetails.addCell(data.getNarcoQty());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no details.    "));
			colSpan.setColspan(2);
			narcoticsTypeDetails.addCell(colSpan);
		}

		PdfPCell nestedTable2 = new PdfPCell();
		nestedTable2.setColspan(2);
		nestedTable2.addElement(narcoticsTypeDetails);
		tableContrabandSmugglingDetails.addCell(nestedTable2);
		// .............../nested table................

		doc.add(tableContrabandSmugglingDetails);

		// ........................../Narcotics Smuggling Details ......................

		// ..........................Boat Details ......................

		List<Boat> boatList = threatData.getBoatList();
		if (boatList != null && !boatList.isEmpty()) {
			doc.add(new Paragraph("Boat Details", subHeading));
			PdfPTable table = new PdfPTable(17);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
			// font.setColor(BaseColor.BLACK);
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header
			String[] boatRowHeading = { "Name of Boat", "Reg. No.", "Name of Owner", "Port of Reg.", "Number of Crew",
					"Documents Held", "NAV Eqpt Fitted", "Common Eqpt Fitted", "Life Saving Eqpt Fitted", "LPC", "ETD",
					"NPC", "ETA", "License for Fishing", "Owner Contact Details", "Boat Confirming to Colour Code",
					"Remarks" };

			for (int i = 0; i < boatRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(boatRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}

			if (boatList != null && !boatList.isEmpty()) {
				for (Boat data : boatList) {
					table.addCell(data.getBoatName());
					table.addCell(data.getRegNum());
					table.addCell(data.getOwnerName());
					table.addCell(data.getPortReg());
					table.addCell(data.getNoOfCrew());
					table.addCell(data.getDocHeld());
					table.addCell(data.getNavEqpt());
					table.addCell(data.getCommEqpt());
					table.addCell(data.getLifeEqpt());
					table.addCell(data.getBoatlpc());
					table.addCell(data.getBoatetd());
					table.addCell(data.getBoatnpc());
					table.addCell(data.getBoateta());
					table.addCell(data.getLicenseFish());
					table.addCell(data.getOwnerContDts());
					table.addCell(data.getBoatColrcd());
					table.addCell(data.getRemarks());

				}
			} else {
				PdfPCell c3 = new PdfPCell(new Phrase("    There is no details.   "));
				c3.setColspan(17);
				table.addCell(c3);
			}
			doc.add(table);
		}
		// ........................../Boat Details ......................
		// ..........................Vessel details......................

		List<Vessel> vesselList = threatData.getVesselList();
		if (vesselList != null && !vesselList.isEmpty()) {
			doc.add(new Paragraph("Vessel Details", subHeading));
			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
			// font.setColor(BaseColor.BLACK);
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header

			String[] vesselRowHeading = { "Name of Vessel", "Vessel Type", "International Call Sign", "MMSI", "IMO No.",
					"Cargo", "LPC", "ETD", "NPC", "ETA", "Total Crew", "Flag or Port of Reg.", "Inmarsat No.",
					"Other Comm. Eqpt.", "Agent", "PANS" };

			for (int i = 0; i < vesselRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(vesselRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}
			if (vesselList != null && !vesselList.isEmpty()) {
				for (Vessel data : vesselList) {
					table.addCell(data.getVesselName());
					table.addCell(data.getVesselTypeName());
					table.addCell(data.getIntCallSign());
					table.addCell(data.getMmsi());
					table.addCell(data.getImoNo());
					table.addCell(data.getCargo());
					table.addCell(data.getVessellpc());
					table.addCell(data.getVesseletd());
					table.addCell(data.getVesselnpc());
					table.addCell(data.getVesseleta());
					table.addCell(data.getTotCrew());
					table.addCell(data.getFlgPrtReg());
					table.addCell(data.getInmarsatNo());
					table.addCell(data.getOtherCommEqpt());
					table.addCell(data.getAgent());
					table.addCell(data.getPans());

				}
			} else {
				PdfPCell c3 = new PdfPCell(new Phrase("    There is no details.   "));
				c3.setColspan(16);
				table.addCell(c3);
			}
			doc.add(table);
		}
		// ........................../Vessel details. ......................

		// ..........................Crew details......................

		doc.add(new Paragraph("Crew Details", subHeading));
		PdfPTable crewtable = new PdfPTable(10);
		crewtable.setWidthPercentage(100.0f);
		crewtable.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		crewtable.setSpacingBefore(10);

		// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
//	    font.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cellCrew = new PdfPCell();
		cellCrew.setBackgroundColor(BaseColor.WHITE);
		cellCrew.setPadding(5);
		// write table header

		String[] crewRowHeading = { "Name", "Age", "Nationality", "Address", "Telephone Number", "Marital Status",
				"Profession", "Identification Marks", "Religion", "Details of ID Proof" };

		for (int i = 0; i < crewRowHeading.length; i++) {
			cellCrew.setPhrase(new Phrase(crewRowHeading[i], subHeading));
			crewtable.addCell(cellCrew);
		}

		List<Crew> crewList = threatData.getCrewList();

		if (crewList != null && !crewList.isEmpty()) {
			for (Crew data : crewList) {
				crewtable.addCell(data.getCrName());
				crewtable.addCell(data.getCrAge());
				crewtable.addCell(data.getCrNationality());
				crewtable.addCell(data.getCrAddress());
				crewtable.addCell(data.getCrTelNo());
				crewtable.addCell(data.getCrMartSts());
				crewtable.addCell(data.getCrProfession());
				crewtable.addCell(data.getCrIdenMrks());
				crewtable.addCell(data.getCrRelgn());
				crewtable.addCell(data.getCrDtlsIdPf());

			}
		} else {

			PdfPCell c3 = new PdfPCell(new Phrase("    There is no details.   "));
			c2.setColspan(10);
			crewtable.addCell(c3);
		}
		doc.add(crewtable);

		// ........................../Crew details. ......................

		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}

	// ....................... /Narcotics smuggling Form Pdf........................

	// ....................... Contraband SmuggleForm Pdf........................
	Document getContrabandSmuggleFormPdf(Document doc, ViewPDFBean threatData) throws Exception {

		String[] generalDetailsCol = { "Type of Threat", "Input Id", "Date of receipt", "Originator",
				"Time of Position", "Time of Activation", "Grading", "Latitude (Decimal Degrees)",
				"Longitude (Decimal Degrees)", "Latitude (Degrees, Minutes, Seconds)",
				"Longitude (Degrees, Minutes, Seconds)", "Killometers (Km)", "Nautical Miles", "Location", "Region",
				"Coastal State", "IMEI No.", "Name of Suspects", "Shared With", "Contacted No. Details" };

		Paragraph preface = new Paragraph("Contraband Smuggling Threat Details", topHeading);
		preface.setAlignment(Element.ALIGN_CENTER);

		doc.add(preface);
		doc.add(new Paragraph(" "));
		// ..........................GENERAL DETAILS ......................
		doc.add(new Paragraph("General Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tablePersonalDetails = new PdfPTable(2);
		tablePersonalDetails.setWidthPercentage(100);
		tablePersonalDetails.addCell(generalDetailsCol[0]);
		tablePersonalDetails.addCell(threatData.getThreatTypeName());
		tablePersonalDetails.addCell(generalDetailsCol[1]);
		tablePersonalDetails.addCell(threatData.getInputId());
		tablePersonalDetails.addCell(generalDetailsCol[2]);
		tablePersonalDetails.addCell(threatData.getDateRecpt());
		tablePersonalDetails.addCell(generalDetailsCol[3]);
		tablePersonalDetails.addCell(threatData.getOrigntrName());
		tablePersonalDetails.addCell(generalDetailsCol[4]);
		tablePersonalDetails.addCell(threatData.getTimeOfPos());
		tablePersonalDetails.addCell(generalDetailsCol[5]);
		tablePersonalDetails.addCell(threatData.getTimeOfActivation());
		tablePersonalDetails.addCell(generalDetailsCol[6]);
		tablePersonalDetails.addCell(threatData.getGradingName());
		tablePersonalDetails.addCell(generalDetailsCol[7]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[8]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDec());
		tablePersonalDetails.addCell(generalDetailsCol[9]);
		tablePersonalDetails.addCell(threatData.getGpslattitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[10]);
		tablePersonalDetails.addCell(threatData.getGpslongitudeDeg());
		tablePersonalDetails.addCell(generalDetailsCol[11]);
		tablePersonalDetails.addCell(threatData.getDistanceKmLnd());
		tablePersonalDetails.addCell(generalDetailsCol[12]);
		tablePersonalDetails.addCell(threatData.getDistanceMileLnd());
		tablePersonalDetails.addCell("From Where");
		tablePersonalDetails.addCell(threatData.getFromWhere());
		tablePersonalDetails.addCell(generalDetailsCol[13]);
		tablePersonalDetails.addCell(threatData.getLocation());
		tablePersonalDetails.addCell(generalDetailsCol[14]);
		tablePersonalDetails.addCell(threatData.getRegionName());
		tablePersonalDetails.addCell(generalDetailsCol[15]);
		tablePersonalDetails.addCell(threatData.getCoastStatName());
		tablePersonalDetails.addCell(generalDetailsCol[16]);
		tablePersonalDetails.addCell(threatData.getImeiNo());
		tablePersonalDetails.addCell(generalDetailsCol[17]);
		tablePersonalDetails.addCell(threatData.getNameSuspects());
		tablePersonalDetails.addCell(generalDetailsCol[18]);
		tablePersonalDetails.addCell(threatData.getSharedWithName());

		// ...............nested table................
		PdfPCell c1 = new PdfPCell(new Phrase(" Contacted No. Details  ", subHeading));
		c1.setColspan(2);
		tablePersonalDetails.addCell(c1);

		PdfPTable contactedNoDetails = new PdfPTable(2);
		contactedNoDetails.setWidthPercentage(100.0f);
		contactedNoDetails.setSpacingBefore(10);

		// define font for table header row
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Contacted Number", subHeading));
		contactedNoDetails.addCell(cell);

		cell.setPhrase(new Phrase("Country", subHeading));
		contactedNoDetails.addCell(cell);
		List<Contact> contactList = threatData.getContactList();
		if (contactList != null && !contactList.isEmpty()) {
			for (Contact data : contactList) {
				contactedNoDetails.addCell(data.getContactNo());
				contactedNoDetails.addCell(data.getCountry());
			}
		} else {
			PdfPCell colSpan = new PdfPCell(new Phrase("    There is no contacted no. details.    "));
			colSpan.setColspan(2);
			contactedNoDetails.addCell(colSpan);
		}

		PdfPCell nestedTable = new PdfPCell();
		nestedTable.setColspan(2);
		nestedTable.addElement(contactedNoDetails);
		tablePersonalDetails.addCell(nestedTable);
		// .............../nested table................
		doc.add(tablePersonalDetails);

		// ........................../GENERAL DETAILS ......................

		// ..........................Contraband Smuggling Details ......................
		doc.add(new Paragraph("Contraband Smuggling Details  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableContrabandSmugglingDetails = new PdfPTable(2);
		tableContrabandSmugglingDetails.setWidthPercentage(100);
		tableContrabandSmugglingDetails.addCell("Icg Units Involved");
		tableContrabandSmugglingDetails
				.addCell((threatData.getIcgUnitsName() != null) ? String.join(",", threatData.getIcgUnitsName()) : "");
		tableContrabandSmugglingDetails.addCell("Type of Contraband Seized");
		tableContrabandSmugglingDetails.addCell(threatData.getTypeOfContra());
		tableContrabandSmugglingDetails.addCell("Quantity");
		tableContrabandSmugglingDetails.addCell(threatData.getQuantity());
		tableContrabandSmugglingDetails.addCell("Weight");
		tableContrabandSmugglingDetails.addCell(threatData.getWeight());
		tableContrabandSmugglingDetails.addCell("Worth");
		tableContrabandSmugglingDetails.addCell(threatData.getWorth());
		tableContrabandSmugglingDetails.addCell("Case handed over to");
		tableContrabandSmugglingDetails.addCell(threatData.getCaseHandedTo());
		tableContrabandSmugglingDetails.addCell("Joint opertaion with");
		tableContrabandSmugglingDetails.addCell(threatData.getJointOperWith());
		tableContrabandSmugglingDetails.addCell("Latitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDec());
		tableContrabandSmugglingDetails.addCell("Longitude (Decimal Degrees)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDec());
		tableContrabandSmugglingDetails.addCell("Latitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplattitudeDeg());
		tableContrabandSmugglingDetails.addCell("Longitude (Degrees, Minutes, Seconds)");
		tableContrabandSmugglingDetails.addCell(threatData.getApplongitudeDeg());

		doc.add(tableContrabandSmugglingDetails);

		// ........................../Contraband Smuggling Details
		// ......................

		// ..........................Boat Details ......................

		List<Boat> boatList = threatData.getBoatList();
		if (boatList != null && !boatList.isEmpty()) {
			doc.add(new Paragraph("Boat Details", subHeading));
			PdfPTable table = new PdfPTable(17);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
			// font.setColor(BaseColor.BLACK);
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header
			String[] boatRowHeading = { "Name of Boat", "Reg. No.", "Name of Owner", "Port of Reg.", "Number of Crew",
					"Documents Held", "NAV Eqpt Fitted", "Common Eqpt Fitted", "Life Saving Eqpt Fitted", "LPC", "ETD",
					"NPC", "ETA", "License for Fishing", "Owner Contact Details", "Boat Confirming to Colour Code",
					"Remarks" };

			for (int i = 0; i < boatRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(boatRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}

			if (boatList != null && !boatList.isEmpty()) {
				for (Boat data : boatList) {
					table.addCell(data.getBoatName());
					table.addCell(data.getRegNum());
					table.addCell(data.getOwnerName());
					table.addCell(data.getPortReg());
					table.addCell(data.getNoOfCrew());
					table.addCell(data.getDocHeld());
					table.addCell(data.getNavEqpt());
					table.addCell(data.getCommEqpt());
					table.addCell(data.getLifeEqpt());
					table.addCell(data.getBoatlpc());
					table.addCell(data.getBoatetd());
					table.addCell(data.getBoatnpc());
					table.addCell(data.getBoateta());
					table.addCell(data.getLicenseFish());
					table.addCell(data.getOwnerContDts());
					table.addCell(data.getBoatColrcd());
					table.addCell(data.getRemarks());

				}
			} else {
				PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
				c2.setColspan(17);
				table.addCell(c2);
			}
			doc.add(table);
		}
		// ........................../Boat Details ......................
		// ..........................Vessel details......................

		List<Vessel> vesselList = threatData.getVesselList();
		if (vesselList != null && !vesselList.isEmpty()) {
			doc.add(new Paragraph("Vessel Details", subHeading));
			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f,
					2.0f, 2.0f, 2.0f });
			table.setSpacingBefore(10);

			// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
			// font.setColor(BaseColor.BLACK);
			// define table header cell
			PdfPCell cellBoat = new PdfPCell();
			cellBoat.setBackgroundColor(BaseColor.WHITE);
			cellBoat.setPadding(5);
			// write table header

			String[] vesselRowHeading = { "Name of Vessel", "Vessel Type", "International Call Sign", "MMSI", "IMO No.",
					"Cargo", "LPC", "ETD", "NPC", "ETA", "Total Crew", "Flag or Port of Reg.", "Inmarsat No.",
					"Other Comm. Eqpt.", "Agent", "PANS" };

			for (int i = 0; i < vesselRowHeading.length; i++) {
				cellBoat.setPhrase(new Phrase(vesselRowHeading[i], subHeading));
				table.addCell(cellBoat);
			}
			if (vesselList != null && !vesselList.isEmpty()) {
				for (Vessel data : vesselList) {
					table.addCell(data.getVesselName());
					table.addCell(data.getVesselTypeName());
					table.addCell(data.getIntCallSign());
					table.addCell(data.getMmsi());
					table.addCell(data.getImoNo());
					table.addCell(data.getCargo());
					table.addCell(data.getVessellpc());
					table.addCell(data.getVesseletd());
					table.addCell(data.getVesselnpc());
					table.addCell(data.getVesseleta());
					table.addCell(data.getTotCrew());
					table.addCell(data.getFlgPrtReg());
					table.addCell(data.getInmarsatNo());
					table.addCell(data.getOtherCommEqpt());
					table.addCell(data.getAgent());
					table.addCell(data.getPans());

				}
			} else {
				PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
				c2.setColspan(16);
				table.addCell(c2);
			}
			doc.add(table);
		}
		// ........................../Vessel details. ......................

		// ..........................Crew details......................

		doc.add(new Paragraph("Crew Details", subHeading));
		PdfPTable crewtable = new PdfPTable(10);
		crewtable.setWidthPercentage(100.0f);
		crewtable.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
		crewtable.setSpacingBefore(10);

		// define font for table header row

//	    Font font = FontFactory.getFont(FontFactory.HELVETICA);
		// font.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cellCrew = new PdfPCell();
		cellCrew.setBackgroundColor(BaseColor.WHITE);
		cellCrew.setPadding(5);
		// write table header

		String[] crewRowHeading = { "Name", "Age", "Nationality", "Address", "Telephone Number", "Marital Status",
				"Profession", "Identification Marks", "Religion", "Details of ID Proof" };

		for (int i = 0; i < crewRowHeading.length; i++) {
			cellCrew.setPhrase(new Phrase(crewRowHeading[i], subHeading));
			crewtable.addCell(cellCrew);
		}

		List<Crew> crewList = threatData.getCrewList();
		if (crewList != null && !crewList.isEmpty()) {
			for (Crew data : crewList) {
				crewtable.addCell(data.getCrName());
				crewtable.addCell(data.getCrAge());
				crewtable.addCell(data.getCrNationality());
				crewtable.addCell(data.getCrAddress());
				crewtable.addCell(data.getCrTelNo());
				crewtable.addCell(data.getCrMartSts());
				crewtable.addCell(data.getCrProfession());
				crewtable.addCell(data.getCrIdenMrks());
				crewtable.addCell(data.getCrRelgn());
				crewtable.addCell(data.getCrDtlsIdPf());

			}
		} else {

			PdfPCell c2 = new PdfPCell(new Phrase("    There is no details.   "));
			c2.setColspan(10);
			crewtable.addCell(c2);
		}
		doc.add(crewtable);

		// ........................../Crew details. ......................

		doc.add(new Paragraph(" "));
		// ..........................Other Information......................
		doc.add(new Paragraph("Other Information  ", subHeading));
		doc.add(new Paragraph(" "));
		PdfPTable tableOtherInformation = new PdfPTable(2);
		tableOtherInformation.setWidthPercentage(100);
		tableOtherInformation.addCell("Other Information");
		tableOtherInformation.addCell(threatData.getOtherInfo());
		tableOtherInformation.addCell("Follow Up");
		tableOtherInformation.addCell(threatData.getFollowUp());
		doc.add(tableOtherInformation);
		// ..........................Other Information......................

		return doc;
	}

	// ....................... /Contraband Smuggle Form Pdf........................

	/*
	 * public PdfPCell getCell(String text, int alignment) { PdfPCell cell = new
	 * PdfPCell(new Phrase(text)); cell.setPadding(0);
	 * cell.setHorizontalAlignment(alignment); cell.setBorder(PdfPCell.NO_BORDER);
	 * return cell; }
	 */
}