package com.fortiate.simulatorwskafka;

import java.util.ArrayList;
import java.util.HashMap;


public abstract class Transaction {


	public Transaction()
	{
		
	}
	
	public Transaction(ArrayList<DataElement> dataElements) {
		this.dataElements = dataElements;
	}

	public Transaction(ArrayList<DataElement> dataElements, String situation) {
		this.dataElements = dataElements;
		this.situation = situation;
	}
	
	protected final String _t = "txn";
	protected String message;
	protected String situation;

	protected String network = "rupay";
	protected static ArrayList<DataElement> dataElements = new ArrayList<>();

	protected static HashMap<String, String> deHM = new HashMap<String, String>();
	protected static HashMap<String, String> deDescription = new HashMap<String, String>();
	protected static HashMap<String, String> deKeyValue = new HashMap<String, String>();

	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public ArrayList<DataElement> getDataElements() {
		return dataElements;
	}
	public void setDataElements(ArrayList<DataElement> dataElements) {
		this.dataElements = dataElements;
	}


	public HashMap<String, String> getDeHM() {
		return deHM;
	}

	public void setDeHM(HashMap<String, String> deHM) {
		this.deHM = deHM;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public HashMap<String, String> getDeDescription() {
		return deDescription;
	}

	public void setDeDescription(HashMap<String, String> deDescription) {
		this.deDescription = deDescription;
	}

	public HashMap<String, String> getDeKeyValue() {
		return deKeyValue;
	}

	public void setDeKeyValue(HashMap<String, String> deKeyValue) {
		this.deKeyValue = deKeyValue;
	}

	public String get_t() {
		return _t;
	}













}
