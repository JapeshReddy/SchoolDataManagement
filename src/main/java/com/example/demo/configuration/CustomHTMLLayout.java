package com.example.demo.configuration;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class CustomHTMLLayout extends LayoutBase<ILoggingEvent> {

//	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String doLayout(ILoggingEvent event) {
		return null;
	}

//	private String getColor(String level) {
//		switch (level) {
//		case "ERROR":
//			return "yellow";
//		case "WARN":
//			return "yellow";
//		case "INFO":
//			return "white";
//		case "DEBUG":
//			return "green";
//		case "TRACE":
//			return "blue";
//		default:
//			return "black";
//		}
//	}

	@Override
	public String getFileHeader() {
		System.out.println("---------------------------");
		return "<html><head><style>table { border-collapse: collapse;} td {border: 10px solid red; padding: 5px;} tr {height: 25px;}</style></head><body><table>\n";
	}

	@Override
	public String getFileFooter() {
		return "</table></body></html>\n";
	}

	@Override
	public String getPresentationHeader() {
		return getFileHeader();
	}

	@Override
	public String getPresentationFooter() {
		return getFileFooter();
	}
}
