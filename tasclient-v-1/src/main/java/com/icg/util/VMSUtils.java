package com.icg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import com.icg.service.UtilsServiceImpl;

public class VMSUtils {

	public static Date dateFormatterDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String URLify(String str) {
		str = str.trim();
		int length = str.length();
		int trueL = length;
		if (str.contains(" ")) {
			for (int i = 0; i < length; i++) {
				if (str.charAt(i) == ' ') {
					trueL = trueL + 2;
				}
			}
			char[] oldArr = str.toCharArray();
			char[] newArr = new char[trueL];
			int x = 0;
			for (int i = 0; i < length; i++) {
				if (oldArr[i] == ' ') {
					newArr[x] = '%';
					newArr[x + 1] = '2';
					newArr[x + 2] = '0';
					x += 3;
				} else {
					newArr[x] = oldArr[i];
					x++;
				}
			}
			str = new String(newArr, 0, trueL);
		}
		return str;
	}

	public static String getDate(Calendar cal) {
		return "" + cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	}

	public static String dateInDDMMYYYY(String stringDate) {
		String str = stringDate.substring(0, 10);
		// System.out.println("str: "+str);

		String strArray[] = str.split("-");

		String date = strArray[2] + "/" + strArray[1] + "/" + strArray[0];
		// System.out.println("date : "+date);
		return date;
	}

	public static Date getDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sqlDate = null;
		try {
			Date utilDate = format.parse(date);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	public static boolean isValidEmail(String email) {
		/*
		 * String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +
		 * "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		 */

		// string
		// s="^(([-\w\d]+)(\.[-\w\d]+)*@([-\w\d]+)(\.[-\w\d]+)*(\.([a-zA-Z]{2,5}|[\d]{1,3})){1,2})$";
		String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
	}

	public static boolean isValidMobNo(String s) {
		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	// Added by Rakesh kumar

	public static void removeDirectory(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			System.out.println("files"+files.toString());
			if (files != null && files.length > 0) {
				System.out.println("ifFileNOtNUll");
				for (File aFile : files) {
					System.out.println("forlooop");
					removeDirectory(aFile);
				}
			}
			dir.delete();
		} else {
			dir.delete();
		}
	}

	/**
	 * This method uses java.io.FileInputStream to read file content into a byte
	 * array
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		return bArray;
	}

	public static void renameDirectory(File sourceFile, File destFile) {
		System.out.println(sourceFile + " *** " + destFile);
		if (sourceFile.renameTo(destFile)) {
			// System.out.println("Directory renamed successfully");
		} else {

			// System.out.println("Failed to rename directory");
		}
	}

	public static List<String> getAllFilenames(String threatFoder, String inputId) {
		// String path = MessageExtension.MASTERDIRECTORY+threatFoder+"/"+inputId;
		// //obunto
		String path = MessageExtension.MASTERDIRECTORY + threatFoder + "\\" + inputId; // all
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> list = new ArrayList<String>();
		if (listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					list.add(listOfFiles[i].getName());
				}
			}
		}
		return list;
	}

	public static void setUpdatedSessionValue(HttpSession session) {
		session.setAttribute("orgnList", new UtilsServiceImpl().getMaster("", "ORIGINATOR"));
		session.setAttribute("shrdwtList", new UtilsServiceImpl().getMaster("", "SHARED_WITH"));

	}
}
