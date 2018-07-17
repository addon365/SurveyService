package com.addon.survey.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.addon.survey.model.District;
import com.addon.survey.model.Place;
import com.addon.survey.model.Polity;
import com.addon.survey.model.Taluk;

public class SampleData {

	public static Polity getPolity() {
		Polity polity = new Polity("Tamil Nadu", "TN");
		Set<District> districts = new HashSet<District>();
		districts.add(new District("Cuddalore", "CDL"));
		polity.setDistricts(districts);
		return polity;

	}

	public static List<District> getDistricts(Polity polity) {
		List<District> districts = new ArrayList<District>();
		List<Taluk> taluks = new ArrayList<Taluk>();
		List<Place> places = new ArrayList<Place>();

		District district = new District("Ariyalur", "AR", polity);

		Taluk taluk = new Taluk("Ariyalur", "AR", district, true);

		Place place = new Place("Ariyalur", "AR", taluk, false, true);
		places.add(place);

		district = new District("Chennai", "CH", polity);

		taluk = new Taluk("Chennai", "CH", district, true);
		place = new Place("Chennai", "CH", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Coimbatore", "CO", polity);

		taluk = new Taluk("Coimbatore", "CO", district, true);
		place = new Place("Coimbatore", "CO", taluk, false, true);
		;
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Cuddalore", "CU", polity);

		taluk = new Taluk("Cuddalore", "CU", district, true);
		place = new Place("Cuddalore", "CU", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Dharmapuri", "DH", polity);

		taluk = new Taluk("Dharmapuri", "DH", district, true);
		place = new Place("Dharmapuri", "DH", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Dindigul", "DI", polity);
		taluk = new Taluk("Dindigul", "DI", district, true);
		place = new Place("Dindigul", "DI", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Erode", "ER", polity);
		taluk = new Taluk("Erode", "ER", district, true);
		place = new Place("Erode", "ER", taluk, false, true);
		;
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Kanchipuram", "KC", polity);
		taluk = new Taluk("Kanchipuram", "KC", district, true);
		place = new Place("Kanchipuram", "KC", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Kanniyakumari", "KK", polity);
		taluk = new Taluk("Kanniyakumari", "KK", district, true);
		place = new Place("Kanniyakumari", "KK", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Karur", "KR", polity);
		taluk = new Taluk("Karur", "KR", district, true);
		place = new Place("Karur", "KR", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Krishnagiri", "KR", polity);
		taluk = new Taluk("Krishnagiri", "KR", district, true);
		place = new Place("Krishnagiri", "KR", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Madurai", "MA", polity);
		taluk = new Taluk("Madurai", "MA", district, true);
		place = new Place("Madurai", "MA", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Nagapattinam", "NG", polity);
		taluk = new Taluk("Nagapattinam", "NG", district, true);
		place = new Place("Nagapattinam", "NG", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Namakkal", "NM", polity);
		taluk = new Taluk("Namakkal", "NM", district, true);
		place = new Place("Namakkal", "NM", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Nilgiris", "NI", polity);
		taluk = new Taluk("Nilgiris", "NI", district, true);
		place = new Place("Nilgiris", "NI", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Perambalur", "PE", polity);
		taluk = new Taluk("Perambalur", "PE", district, true);
		place = new Place("Perambalur", "PE", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Pudukkottai", "PU", polity);
		taluk = new Taluk("Pudukkottai", "PU", district, true);
		place = new Place("Pudukkottai", "PU", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Ramanathapuram", "RA", polity);
		taluk = new Taluk("Ramanathapuram", "RA", district, true);
		place = new Place("Ramanathapuram", "RA", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Salem", "SA", polity);
		taluk = new Taluk("Salem", "SA", district, true);
		place = new Place("Salem", "SA", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Sivaganga", "SI", polity);
		taluk = new Taluk("Sivaganga", "SI", district, true);
		place = new Place("Sivaganga", "SI", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Thanjavur", "TJ", polity);
		taluk = new Taluk("Thanjavur", "TJ", district, true);
		place = new Place("Thanjavur", "TJ", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Theni", "TH", polity);
		taluk = new Taluk("Theni", "TH", district, true);
		place = new Place("Theni", "TH", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Thoothukudi", "TK", polity);
		taluk = new Taluk("Thoothukudi", "TK", district, true);
		place = new Place("Thoothukudi", "TK", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tiruchirappalli", "TC", polity);
		taluk = new Taluk("Tiruchirappalli", "TC", district, true);
		place = new Place("Tiruchirappalli", "TC", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tirunelveli", "TI", polity);
		taluk = new Taluk("Tirunelveli", "TI", district, true);
		place = new Place("Tirunelveli", "TI", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tiruppur", "TP", polity);
		taluk = new Taluk("Tiruppur", "TP", district, true);
		place = new Place("Tiruppur", "TP", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tiruvallur", "TL", polity);
		taluk = new Taluk("Tiruvallur", "TL", district, true);
		place = new Place("Tiruvallur", "TL", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tiruvannamalai", "TV", polity);
		taluk = new Taluk("Tiruvannamalai", "TV", district, true);
		place = new Place("Tiruvannamalai", "TV", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Tiruvarur", "TR", polity);
		taluk = new Taluk("Tiruvarur", "TR", district, true);
		place = new Place("Tiruvarur", "TR", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Vellore", "VE", polity);
		taluk = new Taluk("Vellore", "VE", district, true);
		place = new Place("Vellore", "VE", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Viluppuram", "VL", polity);
		taluk = new Taluk("Viluppuram", "VL", district, true);
		place = new Place("Viluppuram", "VL", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		district = new District("Virudhunagar", "VR", polity);
		taluk = new Taluk("Virudhunagar", "VR", district, true);
		place = new Place("Virudhunagar", "VR", taluk, false, true);
		districts.add(district);
		taluks.add(taluk);
		places.add(place);

		return districts;
	}

}
